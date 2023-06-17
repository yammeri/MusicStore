package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.example.entities.enums.Category;
import org.example.entities.Product;
import org.example.utils.ConnectionFactory;

import java.sql.*;

public class ProductRepository {
    private final String GET_BY_ID_TEMPLATE = "select * from products where product_id = ? ";
    private final String INSERT_TEMPLATE = "insert into products(product_id, provider_id, category, product_name, count_in_stock, product_cost) values (?, ?, ?, ?, ?, ?)";
    private final String DELETE_TEMPLATE = "delete from products where id = ?";

    private static final Logger logger = LogManager.getLogger(ProductRepository.class);
    private final Connection connection;

    public ProductRepository(ConnectionFactory connectionFactory) {
        this.connection = ConnectionFactory.getConnection();
    }

    public Product get(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID_TEMPLATE);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Product(
                        resultSet.getLong("product_id"),
                        resultSet.getLong("provider_id"),
                        Category.fromString(resultSet.getString("category")),
                        resultSet.getString("product_name"),
                        resultSet.getInt("count_in_stock"),
                        resultSet.getBigDecimal("product_cost"));
            }
            return null;
        } catch (SQLException | IllegalAccessException e) {
            logger.error("Ошибка получения продукта по id:\n" + e.getMessage());
            return null;
        }
    }

    public boolean save(Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_TEMPLATE);
            ps.setLong(1, product.getId());
            ps.setLong(2, product.getProviderId());
            ps.setString(3, product.getCategory().getValue());
            ps.setString(4, product.getName());
            ps.setInt(5, product.getCountInStock());
            ps.setBigDecimal(6, product.getCost());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Ошибка добавления продукта:\n" + e.getMessage());
            return false;
        }
    }

    public boolean extract(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_TEMPLATE);
            ps.setLong(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Ошибка удаления продукта по id:\n" + e.getMessage());
            return false;
        }
    }
}
