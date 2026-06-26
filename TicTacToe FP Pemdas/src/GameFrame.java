import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Player        currentPlayer;
    private PlayerService playerService;
    private GameLogic     gameLogic;
    private JButton[] buttons;
    private JLabel    lblStatus;
    private boolean   gameOver;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic     = new GameLogic();
        this.gameOver      = false;
        setupUI();
    }

    private void setupUI() {
        setTitle("Tic-Tac-Toe — " + currentPlayer.getUsername() + " vs Komputer");
        setSize(380, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        lblStatus = new JLabel("Giliran kamu — klik sel untuk bermain", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 13));
        mainPanel.add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        buttons = new JButton[9];
        // TODO: Buat loop untuk instansiasi 9 tombol JButton dan pasang ActionListener pada komponen array
        for (int i = 0; i < 9; i++) {
            final int index = i;
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            boardPanel.add(buttons[i]);
        }
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        JButton btnBack = new JButton("Kembali ke Menu");
        btnBack.addActionListener(e -> goBackToMenu());
        mainPanel.add(btnBack, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void handlePlayerMove(int index) {
        if (gameOver) return;
        // TODO: Validasi dan eksekusi langkah pemain manusia ('X') ke Core Logic
        boolean moved = gameLogic.makeMove(index, 'X');
        if (!moved) {
            JOptionPane.showMessageDialog(this,
                "Sel sudah terisi! Pilih sel lain.",
                "Gerakan Tidak Valid", JOptionPane.WARNING_MESSAGE);
            return;
        }

        buttons[index].setText("X");
        buttons[index].setForeground(new Color(0, 100, 200));

        // TODO: Periksa kondisi akhir (Menang/Seri) setelah pemain melangkah
        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }
        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Komputer sedang berpikir...");

        // TODO: Pemicuan langkah otomatis dari AI Komputer (Minimax) dan update komponen visual

        int compIndex = gameLogic.computerMove();
        gameLogic.makeMove(compIndex, 'O');
        buttons[compIndex].setText("O");
        buttons[compIndex].setForeground(new Color(200, 50, 50));

        // TODO: Periksa kondisi akhir (Kalah/Seri) setelah komputer melangkah
        if (gameLogic.checkWinner('O')) {
            finishGame("LOSE");
            return;
        }
        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Giliran kamu — klik sel untuk bermain");
    }

    private void finishGame(String result) {
        gameOver = true;

        for (JButton btn : buttons) {
            btn.setEnabled(false);
        }

        playerService.updateStatistics(currentPlayer, result);

        String message;
        switch (result) {
            case "WIN":
                message = "Kamu menang! +10 poin";
                lblStatus.setText("Kamu menang!");
                break;
            case "LOSE":
                message = "Kamu kalah. +0 poin";
                lblStatus.setText("Komputer menang.");
                break;
            default:
                message = "Seri! +3 poin";
                lblStatus.setText("Draw!");
        }

        int choice = JOptionPane.showOptionDialog(this,
            message + "\n\nMau main lagi?",
            "Hasil Game",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]{"Main Lagi", "Kembali ke Menu"},
            "Main Lagi");

        if (choice == JOptionPane.YES_OPTION) {
            gameLogic.resetBoard();
            gameOver = false;
            for (JButton btn : buttons) {
                btn.setText("");
                btn.setEnabled(true);
            }
            lblStatus.setText("Giliran kamu — klik sel untuk bermain");
        } else {
            goBackToMenu();
        }
    }

    private void goBackToMenu() {
        Player refreshed = playerService.getPlayerById(currentPlayer.getId());
        Player toPass = (refreshed != null) ? refreshed : currentPlayer;
        MainMenuFrame menuFrame = new MainMenuFrame(toPass);
        menuFrame.setVisible(true);
        this.dispose();
    }
}
