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

        setTitle("Lexical Analysis");
        setLayout(null);
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLabel();
        setInput();
        setVisible(true);
    }
    public void setLabel(){
        title[0] = new JLabel("Input");
        title[1] = new JLabel("Output");

        title[0].setBounds(20, 20, 75, 20);
        title[1].setBounds(20, 20, 75, 20);

        add(title[0]);
        add(title[1]);
    }
    public void setInput(){
        textArea = new JTextArea();

        inputPanel.add(textArea);
    }
    public void setButton(){
        enterButton = new JButton();
        editButton = new JButton();

        add(enterButton);
        add(editButton);
    }
}

