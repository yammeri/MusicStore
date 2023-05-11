package repositories;

import entities.DeliveryStatus;
import entities.TravelHistory;
import factories.ConnectionFactory;

import java.sql.*;

public class TravelHistoryRepository {
    private final String GET_BY_ID_TEMPLATE = "select * from travel_histories where travel_history_id = ?";
    private final String INSERT_TEMPLATE = "insert into travel_histories(travel_history_id, order_id, current_address, current_travel_date, current_status) values (?, ?, ?, ?, ?)";

    private TravelHistory get(Long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID_TEMPLATE);
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new TravelHistory(
                        resultSet.getLong("travel_history_id"),
                        resultSet.getLong("order_id"),
                        resultSet.getString("current_address"),
                        resultSet.getDate("current_travel_date"),
                        DeliveryStatus.fromString(resultSet.getString("current_status")));
            }
            return null;
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean save(TravelHistory travelHistory) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(INSERT_TEMPLATE);
            ps.setLong(1, travelHistory.getId());
            ps.setLong(2, travelHistory.getOrderId());
            ps.setString(3, travelHistory.getCurAddress());
            ps.setDate(4, (Date) travelHistory.getCurTravelDate());
            ps.setString(5, travelHistory.getCurStatus().getValue());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
