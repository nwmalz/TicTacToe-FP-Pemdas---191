import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {
        PlayerService playerService = new PlayerService();
        Player fresh = playerService.getPlayerById(player.getId());
        if (fresh != null) player = fresh;
        setupUI(player);
    }

    private void setupUI(Player player) {
        setTitle("Statistik — " + player.getUsername());
        setSize(300, 280);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(7, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        Font labelFont = new Font("Arial", Font.PLAIN, 13);
        Font valueFont = new Font("Arial", Font.BOLD, 13);

        int total = player.getWins() + player.getLosses() + player.getDraws();

        addRow(panel, "Pemain:",     player.getUsername(),           labelFont, valueFont);
        addRow(panel, "Menang:",     String.valueOf(player.getWins()),   labelFont, valueFont);
        addRow(panel, "Kalah:",      String.valueOf(player.getLosses()), labelFont, valueFont);
        addRow(panel, "Seri:",       String.valueOf(player.getDraws()),  labelFont, valueFont);
        addRow(panel, "Total Game:", String.valueOf(total),              labelFont, valueFont);
        addRow(panel, "Skor:",       String.valueOf(player.getScore()),  labelFont, valueFont);

        JButton btnClose = new JButton("Tutup");
        btnClose.addActionListener(e -> dispose());
        panel.add(new JLabel());
        panel.add(btnClose);

        add(panel);
    }

    private void addRow(JPanel panel, String label, String value,
                        Font labelFont, Font valueFont) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(labelFont);
        JLabel val = new JLabel(value);
        val.setFont(valueFont);
        panel.add(lbl);
        panel.add(val);
    }
}
