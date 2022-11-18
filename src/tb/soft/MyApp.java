package tb.soft;

import javax.swing.*;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class MyApp implements Runnable {

    public void run() {
        Database.addUser("Kacper","qwerty".toCharArray());
        Database.addUser("Jakub","asdfg".toCharArray());
        MainWindow window = new MainWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MyApp());
    }
}