import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Main {

    private JFrame frame;
    private JFileChooser j;
    private File mFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel mainL = new JLabel("JAVA FILE LINE COUNTER");
        mainL.setFont(new Font("MS Gothic", Font.BOLD, 60));
        mainL.setHorizontalAlignment(SwingConstants.CENTER);
        mainL.setBounds(5, 41, 776, 62);
        frame.getContentPane().add(mainL);

        JButton btnNewButton = new JButton("CHOOSE FILE!");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                File F = new File("C:\\Users\\charl\\eclipse-workspace");
                j = new JFileChooser(F, FileSystemView.getFileSystemView());

                int i = j.showOpenDialog(null);

                if (i == JFileChooser.APPROVE_OPTION) {

                    mFile = new File(j.getSelectedFile().getAbsolutePath());

                } else {

                    JOptionPane.showMessageDialog(null, "You Have Chosen No File You Pleb");

                }

            }
        });
        btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 40));
        btnNewButton.setBounds(213, 154, 359, 62);
        frame.getContentPane().add(btnNewButton);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("MS Gothic", Font.BOLD, 40));
        textArea.setBounds(374, 397, 407, 49);
        frame.getContentPane().add(textArea);

        JButton btnstart = new JButton("!!!START!!!");
        btnstart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Counter temp = new Counter(mFile);
                try {
                    textArea.setText(String.valueOf(temp.traverseF()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        btnstart.setFont(new Font("MS Gothic", Font.BOLD, 40));
        btnstart.setBounds(213, 267, 359, 62);
        frame.getContentPane().add(btnstart);

        JLabel lblNewLabel = new JLabel("NUMBER OF LINES");
        lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(5, 391, 359, 56);
        frame.getContentPane().add(lblNewLabel);

    }
}
