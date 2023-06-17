package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.example.entities.enums.DeliveryType;
import org.example.entities.Order;
import org.example.utils.ConnectionFactory;

import java.sql.*;

public class OrderRepository {
    private final String GET_BY_ID_TEMPLATE = "select * from orders where order_id = ?";
    private final String INSERT_TEMPLATE = "insert into orders(order_id, customer_id, order_create_date, delivery_address, delivery_type) values (?, ?, ?, ?, ?)";

    private final String GET_LAST_ID_TEMPLATE = "select max(order_id) as last_id from orders";

    private static final Logger logger = LogManager.getLogger(OrderItemRepository.class);
    private final Connection connection;

    public OrderRepository(ConnectionFactory connectionFactory) {
        this.connection = ConnectionFactory.getConnection();
    }

    public Long getLastId() {
        try {
            PreparedStatement ps = connection.prepareStatement(GET_LAST_ID_TEMPLATE);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong("last_id");
            }
            return 0L;
        } catch (SQLException e) {
            logger.error("Ошибка получения последнего созданного id:\n" + e.getMessage());
            return null;
        }
    }

    public Order get(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID_TEMPLATE);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Order(
                        resultSet.getLong("order_id"),
                        resultSet.getLong("customer_id"),
                        resultSet.getDate("order_create_date"),
                        resultSet.getString("delivery_address"),
                        DeliveryType.fromString(resultSet.getString("delivery_type")));
            }
            return null;
        } catch (SQLException | IllegalAccessException e) {
            logger.error("Ошибка получения заказа по id:\n" + e.getMessage());
            return null;
        }
    }

    public boolean save(Order order) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_TEMPLATE);
            ps.setLong(1, order.getId());
            ps.setLong(2, order.getCustomerId());
            ps.setDate(3, (Date) order.getCreateDate());
            ps.setString(4, order.getDeliveryAddress());
            ps.setString(5, order.getDeliveryType().getValue());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Ошибка добавления заказа:\n" + e.getMessage());
            return false;
        }
    }
}
