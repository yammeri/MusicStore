package org.example.repositories;

import org.example.entities.Provider;
import org.example.utils.ConnectionFactory;

import java.sql.*;

public class ProviderRepository {
    private final String GET_BY_ID_TEMPLATE = "select * from providers where provider_id = ?";
    private final String INSERT_TEMPLATE = "insert into providers(provider_id, provider_name, provider_address, email, phone) values (?, ?, ?, ?, ?)";

    private final Connection connection;

    public ProviderRepository(ConnectionFactory connectionFactory) {
        this.connection = ConnectionFactory.getConnection();
    }

    public Provider get(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID_TEMPLATE);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Provider(
                        resultSet.getLong("provider_id"),
                        resultSet.getString("provider_name"),
                        resultSet.getString("provider_address"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean save(Provider provider) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_TEMPLATE);
            ps.setLong(1, provider.getId());
            ps.setString(2, provider.getName());
            ps.setString(3, provider.getAddress());
            ps.setString(4, provider.getEmail());
            ps.setString(5, provider.getPhone());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
