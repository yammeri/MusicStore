package repositories;

import entities.Customer;
import factories.ConnectionFactory;

import java.sql.*;

public class CustomerRepository {
    private final String GET_BY_ID_TEMPLATE = "select * from customers where customer_id = ?";

    private final String INSERT_TEMPLATE = "insert into customers(customer_id, first_name, last_name, email, phone) values (?, ?, ?, ?, ?)";

    public Customer get(Long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID_TEMPLATE);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Customer(
                        resultSet.getLong("customer_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean save(Customer customer) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(INSERT_TEMPLATE);
            ps.setLong(1, customer.getId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getPhone());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
