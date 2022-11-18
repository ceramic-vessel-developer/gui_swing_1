package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainWindow implements ActionListener {
    private JFrame mainFrame;
    private JTextField username ;
    private JPasswordField password;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private String ZALOGUJ = "zaloguj";
    private String ZAREJESTRUJ = "zarejestruj";

    public MainWindow(){
        this.initialize();
        this.switchToLogInPage();
    }
    private void initialize(){
        mainFrame = new JFrame();
        username = new JTextField(10);
        password = new JPasswordField(10);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setMinimumSize(new Dimension(250,200));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    private void switchToLogInPage(){
        mainFrame.setTitle("Logowanie");


        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        textPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.white);
        textPanel.setBackground(Color.white);
        GridBagConstraints c = new GridBagConstraints();

        username.setActionCommand(ZALOGUJ);
        username.addActionListener(this);

        JLabel labelUsername = new JLabel("Nazwa użytkownika:");
        labelUsername.setLabelFor(username);

        password.setActionCommand(ZALOGUJ);
        password.addActionListener(this);

        JLabel labelPassword = new JLabel("Hasło:");
        labelPassword.setLabelFor(password);

        JButton login =new JButton("Zaloguj");
        login.setActionCommand(ZALOGUJ);
        login.addActionListener(this);

        JButton register = new JButton("Zarejestruj");
        register.setActionCommand(ZAREJESTRUJ);
        register.addActionListener(this);

        textPanel.add(labelUsername,c);
        textPanel.add(username,c);
        c.gridy = 1;
        textPanel.add(labelPassword,c);
        textPanel.add(password,c);
        buttonPanel.add(login);
        buttonPanel.add(register);

        mainFrame.add(textPanel,BorderLayout.CENTER);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
        mainFrame.pack();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (ZALOGUJ.equals(cmd)){
            boolean success = Database.logIn(username.getText(), password.getPassword());
            if (success){
                buttonPanel.setBackground(Color.green);
                textPanel.setBackground(Color.green);
            }else{
                buttonPanel.setBackground(Color.red);
                textPanel.setBackground(Color.red);
            }
        }
    }
}
