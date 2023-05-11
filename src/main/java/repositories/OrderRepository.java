package repositories;

import entities.DeliveryType;
import entities.Order;
import factories.ConnectionFactory;

import java.sql.*;

public class OrderRepository {
    private final String GET_BY_ID_TEMPLATE = "select * from orders where order_id = ?";
    private final String INSERT_TEMPLATE = "insert into orders(order_id, customer_id, order_create_date, delivery_address, delivery_type) values (?, ?, ?, ?, ?)";

    public Order get(Long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
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
            throw new RuntimeException(e);
        }
    }

    public boolean save(Order order) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(INSERT_TEMPLATE);
            ps.setLong(1, order.getId());
            ps.setLong(2, order.getCustomerId());
            ps.setDate(3, (Date) order.getCreateDate());
            ps.setString(4, order.getDeliveryAddress());
            ps.setString(5, order.getDeliveryType().getValue());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
