package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {
    private JFrame mainFrame;
    private JTextField username ;
    private JPasswordField password;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private String ZALOGUJ = "zaloguj";
    private String REJESTRACJA = "rejestracja";
    private String ZAREJESTRUJ = "zarejestruj";
    private String LOGOWANIE = "logowanie";
    private JButton login;
    private JButton register;

    public MainWindow(){
        this.initialize();

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
        mainFrame.setTitle("Logowanie");


        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        textPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.white);
        textPanel.setBackground(Color.white);
        GridBagConstraints c = new GridBagConstraints();



        JLabel labelUsername = new JLabel("Nazwa użytkownika:");
        labelUsername.setLabelFor(username);



        JLabel labelPassword = new JLabel("Hasło:");
        labelPassword.setLabelFor(password);
        login =new JButton("Zaloguj");
        login.addActionListener(this);

        register = new JButton("Zarejestruj");
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
        switchToLoginPage();


    }

    private void switchToLoginPage(){
        buttonPanel.setBackground(Color.white);
        textPanel.setBackground(Color.white);
        register.setActionCommand(REJESTRACJA);
        login.setActionCommand(ZALOGUJ);
        register.setText("Rejestracja");
        login.setText("Zaloguj");
    }

    private void switchToRegisterPage(){
        register.setText("Zarejestruj");
        login.setText("Logowanie");
        buttonPanel.setBackground(Color.white);
        textPanel.setBackground(Color.white);
        register.setActionCommand(ZAREJESTRUJ);

        login.setActionCommand(LOGOWANIE);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (ZALOGUJ.equals(cmd)){
            boolean success = Database.logIn(username.getText(), password.getPassword());
            if (success){
                buttonPanel.setBackground(Color.green);
                textPanel.setBackground(Color.green);
                username.setText(null);
                password.setText(null);
            }else{
                buttonPanel.setBackground(Color.red);
                textPanel.setBackground(Color.red);
                username.setText(null);
                password.setText(null);
            }
        }else if (REJESTRACJA.equals(cmd)){
            switchToRegisterPage();
        }else if (ZAREJESTRUJ.equals(cmd)){
            Database.addUser(username.getText(), password.getPassword());
            username.setText(null);
            password.setText(null);
        }else if (LOGOWANIE.equals(cmd)){
            switchToLoginPage();
        }
    }
}
