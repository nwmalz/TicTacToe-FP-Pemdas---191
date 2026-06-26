import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame() {
        setupUI();
    }

    private void setupUI() {
        setTitle("Top 5 Scorers");
        setSize(480, 240);
        setLocationRelativeTo(null);
        setResizable(false);

        String[] columns = {"#", "Username", "Menang", "Kalah", "Seri", "Skor"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        PlayerService playerService = new PlayerService();
        List<Player> topList = playerService.getTopFiveScorers();

        for (int i = 0; i < topList.size(); i++) {
            Player p = topList.get(i);
            model.addRow(new Object[]{
                i + 1,
                p.getUsername(),
                p.getWins(),
                p.getLosses(),
                p.getDraws(),
                p.getScore()
            });
        }

        JTable table = new JTable(model);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.setFont(new Font("Arial", Font.PLAIN, 12));

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitle = new JLabel("Top 5 Pemain Terbaik", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblTitle, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnClose = new JButton("Tutup");
        btnClose.addActionListener(e -> dispose());
        panel.add(btnClose, BorderLayout.SOUTH);

        add(panel);
    }
}
