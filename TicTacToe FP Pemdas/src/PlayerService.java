import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    public Player login(String username, String password) {
        String sql = "SELECT * FROM players WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Player(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getInt("wins"),
                    rs.getInt("losses"),
                    rs.getInt("draws"),
                    rs.getInt("score")
                );
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM players WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Player(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getInt("wins"),
                    rs.getInt("losses"),
                    rs.getInt("draws"),
                    rs.getInt("score")
                );
            }
        } catch (Exception e) {
            System.out.println("getPlayerById error: " + e.getMessage());
        }
        return null;
    }

    public void updateStatistics(Player player, String result) {
        String sql;
        int additionalScore;

        switch (result.toUpperCase()) {
            case "WIN":
                sql = "UPDATE players SET wins = wins + 1, score = score + ? WHERE id = ?";
                additionalScore = 10;
                break;
            case "LOSE":
                sql = "UPDATE players SET losses = losses + 1, score = score + ? WHERE id = ?";
                additionalScore = 0;
                break;
            case "DRAW":
                sql = "UPDATE players SET draws = draws + 1, score = score + ? WHERE id = ?";
                additionalScore = 3;
                break;
            default:
                return;
        }

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, additionalScore);
            stmt.setInt(2, player.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("updateStatistics error: " + e.getMessage());
        }
    }

    public List<Player> getTopFiveScorers() {
        List<Player> topList = new ArrayList<>();
        String sql = "SELECT * FROM players ORDER BY score DESC, wins DESC LIMIT 5";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                topList.add(new Player(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getInt("wins"),
                    rs.getInt("losses"),
                    rs.getInt("draws"),
                    rs.getInt("score")
                ));
            }
        } catch (Exception e) {
            System.out.println("getTopFiveScorers error: " + e.getMessage());
        }
        return topList;
    }
}
