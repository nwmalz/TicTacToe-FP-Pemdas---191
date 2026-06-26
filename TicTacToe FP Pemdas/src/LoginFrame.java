import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField     txtUsername;
    private JPasswordField txtPassword;
    private JButton        btnLogin;
    private PlayerService  playerService;

    public LoginFrame() {
        playerService = new PlayerService();
        setupUI();
    }
        
    private void setupUI() {
        setTitle("Tic-Tac-Toe — Login");
        setSize(360, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill   = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Tic-Tac-Toe Login", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Username:"), gbc);
        txtUsername = new JTextField(15);
        gbc.gridx = 1;
        panel.add(txtUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);
        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(txtPassword, gbc);

        btnLogin = new JButton("Login");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        add(panel);

        btnLogin.addActionListener(e -> handleLogin());
        txtPassword.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Username dan password tidak boleh kosong.",
                "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Player player = playerService.login(username, password);

        if (player != null) {
            JOptionPane.showMessageDialog(this,
                "Login berhasil! Selamat datang, " + player.getUsername() + ".",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
            MainMenuFrame menuFrame = new MainMenuFrame(player);
            menuFrame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                "Username atau password salah.",
                "Login Gagal", JOptionPane.ERROR_MESSAGE);
            txtPassword.setText("");
        }
    }
}
