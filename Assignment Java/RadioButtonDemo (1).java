import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {

    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 320);
        setLayout(new BorderLayout(10, 10));

        // --- Main Panel with Blue Border ---
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 0, 180), 3),   // outer blue border
            BorderFactory.createEmptyBorder(10, 10, 10, 10)             // inner padding
        ));

        // --- Radio Buttons Panel (Left) with Blue Border ---
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1, 5, 5));
        radioPanel.setBackground(Color.WHITE);
        radioPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 130, 180), 2), // steel blue border
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        birdButton   = new JRadioButton("Bird");
        catButton    = new JRadioButton("Cat");
        dogButton    = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton    = new JRadioButton("Pig");
        pigButton.setSelected(true);

        // Style each button
        JRadioButton[] buttons = {birdButton, catButton, dogButton, rabbitButton, pigButton};
        for (JRadioButton btn : buttons) {
            btn.setBackground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.PLAIN, 14));
            btn.setForeground(new Color(0, 0, 139)); // dark blue text
            btn.addActionListener(this);
        }

        ButtonGroup group = new ButtonGroup();
        for (JRadioButton btn : buttons) group.add(btn);

        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // --- Image Panel (Right) with Blue Border ---
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 130, 180), 2), // steel blue border
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(200, 200));
        updateImage("Pig");

        imagePanel.add(imageLabel, BorderLayout.CENTER);

        mainPanel.add(radioPanel, BorderLayout.WEST);
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // --- Blue Title Bar Panel ---
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 0, 180));
        JLabel titleLabel = new JLabel("RadioButtonDemo");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titlePanel.add(titleLabel);

        add(titlePanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        getContentPane().setBackground(new Color(173, 216, 230)); // light blue background

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pet = e.getActionCommand();
        updateImage(pet);
        JOptionPane.showMessageDialog(
            this,
            "You selected: " + pet,
            "Pet Selected",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void updateImage(String pet) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(pet.toLowerCase() + ".png"));
            Image scaled = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
            imageLabel.setText("");
        } catch (Exception ex) {
            imageLabel.setIcon(null);
            imageLabel.setForeground(new Color(0, 0, 139));
            imageLabel.setFont(new Font("Arial", Font.BOLD, 16));
            imageLabel.setText("[" + pet + " image]");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonDemo::new);
    }
}