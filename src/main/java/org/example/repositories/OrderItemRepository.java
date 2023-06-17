package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.example.entities.OrderItem;
import org.example.utils.ConnectionFactory;

import java.sql.*;

public class OrderItemRepository {
    private final String GET_BY_ID_TEMPLATE = "select * from order_items where item_id = ?";
    private final String INSERT_TEMPLATE = "insert into order_items(item_id, order_id, product_id, items_count, total_cost) values (?, ?, ?, ?, ?)";

    private static final Logger logger = LogManager.getLogger(OrderItemRepository.class);
    private final Connection connection;

    public OrderItemRepository(ConnectionFactory connectionFactory) {
        this.connection = ConnectionFactory.getConnection();
    }

    public OrderItem get(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID_TEMPLATE);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new OrderItem(
                        resultSet.getLong("item_id"),
                        resultSet.getLong("order_id"),
                        resultSet.getLong("product_id"),
                        resultSet.getInt("items_count"),
                        resultSet.getBigDecimal("total_cost"));
            }
            return null;
        } catch (SQLException e) {
            logger.error("Ошибка получения пункта заказа по id:" + e.getMessage());
            return null;
        }
    }

    public boolean save(OrderItem orderItem) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_TEMPLATE);
            ps.setLong(1, orderItem.getId());
            ps.setLong(2, orderItem.getOrderId());
            ps.setLong(3, orderItem.getProductId());
            ps.setInt(4, orderItem.getCount());
            ps.setBigDecimal(5, orderItem.getTotalCost());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Ошибка добавления пункта заказа:\n" + e.getMessage());
            return false;
        }
    }
}
