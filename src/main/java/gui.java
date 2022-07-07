import javax.swing.*;
import java.awt.*;

public class gui extends JFrame {
    // Panels
    public static JPanel inputPanel;
    public static JPanel outputPanel;

    // Labels
    public static JLabel[] title = new JLabel[2];

    // Input Field
    public static JTextArea textArea;

    // Output Field

    // Buttons
    public static JButton enterButton;
    public static JButton editButton;

    public gui(){
        inputPanel = new JPanel();
        outputPanel = new JPanel();

        add(inputPanel);
        add(outputPanel);

        setPanel();

        setTitle("Lexical Analysis");
        setLayout(null);
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        setLabel();
        setInput();
        setButton();

        setVisible(true);
    }
    public void setPanel(){
        inputPanel.setLayout(null);
        inputPanel.setBounds(10, 50, 365, 350);
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        inputPanel.setBackground(new Color(187, 163, 159));

        outputPanel.setLayout(new GridBagLayout());
        outputPanel.setBounds(410, 50, 365, 350);
        outputPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        outputPanel.setBackground(new Color(187, 163, 159));
    }
    public void setLabel(){
        title[0] = new JLabel("Input");
        title[1] = new JLabel("Output");

        title[0].setBounds(inputPanel.getWidth() - inputPanel.getWidth() / 2, 20, 75, 20);
        title[1].setBounds((int) ((outputPanel.getWidth() - outputPanel.getWidth() / 3) * 2) + outputPanel.getWidth() / 4, 20, 75, 20);

        add(title[0]);
        add(title[1]);

    }
    public void setInput(){
        textArea = new JTextArea();

        textArea.setBounds(17, 10, inputPanel.getWidth() - inputPanel.getWidth() / 10, inputPanel.getHeight() - inputPanel.getWidth() / 20);
        inputPanel.add(textArea);
    }
    public void setButton(){
        enterButton = new JButton("Enter");
        editButton = new JButton("Edit");

        enterButton.setBounds((int) (inputPanel.getWidth() / 8), 410, 100, 30);
        editButton.setBounds((int) (inputPanel.getWidth() / 1.5), 410, 100, 30);

        add(enterButton);
        add(editButton);
    }
}

