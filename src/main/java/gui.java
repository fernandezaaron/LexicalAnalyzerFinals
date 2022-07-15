import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.ActionEvent;

public class gui extends JFrame {
    // Panels
    public static JPanel inputPanel;
    public static JPanel outputPanel;

    // Labels
    public static JLabel[] title = new JLabel[2];

    // Scrolls
    public static JScrollPane scrollPane;

    // Input Field
    public static JTextArea textArea;
    public static JTextArea numberLines;

    // Output Field
    public static DefaultTableModel tableModel;
    public static JTable table;

    // Buttons
    public static JButton enterButton;
    public static JButton editButton;

    // Logic
    private lexical lexical;

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
        setLocationRelativeTo(null);

        setLabel();
        setInput();
        setScrollPane();
        setButton();
        setOutput();

        setVisible(true);
    }

    // Used to set JPanel
    public void setPanel(){
        inputPanel.setLayout(new BorderLayout(100, 100));
        inputPanel.setBounds(10, 50, 365, 350);
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        inputPanel.setBackground(new Color(187, 163, 159));

        outputPanel.setLayout(new GridBagLayout());
        outputPanel.setBounds(410, 50, 365, 350);
        outputPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        outputPanel.setBackground(new Color(187, 163, 159));
    }
    // Used to set JScrollPane
    public void setScrollPane(){
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setRowHeaderView(numberLines);
        inputPanel.add(scrollPane);
    }

    // Used to set JLabel
    public void setLabel(){
        title[0] = new JLabel("Input");
        title[1] = new JLabel("Output");

        title[0].setBounds(inputPanel.getWidth() - inputPanel.getWidth() / 2,
                20, 75, 20);
        title[1].setBounds((int) ((outputPanel.getWidth() - outputPanel.getWidth() / 3) * 2) +
                outputPanel.getWidth() / 4, 20, 75, 20);

        add(title[0]);
        add(title[1]);

    }

    // Used to set JTextArea
    public void setInput(){
        textArea = new JTextArea();

        setNumberLines(textArea);

        textArea.setBounds(17, 10, inputPanel.getWidth() - inputPanel.getWidth() / 10,
                inputPanel.getHeight() - inputPanel.getWidth() / 20);
        inputPanel.add(textArea);
    }

    // Used to set number in the side of JTextArea
    public void setNumberLines(JTextArea textArea){
        numberLines = new JTextArea("1");
        numberLines.setBackground(Color.GRAY);
        numberLines.setEditable(false);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public String getText(){
                int position = textArea.getDocument().getLength();
                Element root = textArea.getDocument().getDefaultRootElement();
                String text = "1" + System.getProperty("line.separator");
                for(int i=2; i<root.getElementIndex(position) + 2; i++){
                    text += i +System.getProperty("line.separator");
                }
                return text;
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                numberLines.setText(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                numberLines.setText(getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                numberLines.setText(getText());
            }
        });
    }

    // Used to set JButton
    public void setButton(){
        enterButton = new JButton("Enter");
        editButton = new JButton("Edit");

        enterButton.setBounds((int) (inputPanel.getWidth() / 8), 410, 100, 30);
        editButton.setBounds((int) (inputPanel.getWidth() / 1.5), 410, 100, 30);

        editButton.setEnabled(false);
        enterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add here the code for logic

                int rowCount = tableModel.getRowCount();
                int colCount = tableModel.getColumnCount();
                String code = textArea.getText();
                if(rowCount > 0){
                    //Remove rows one by one from the end of the table
                    for (int i = rowCount - 1; i >= 0; i--) {
                        tableModel.removeRow(i);
                    }
                }
                lexical = new lexical(code);
                lexical.logic();
                lexical.addRow();
                // Add here the code for logic
                table.setEnabled(false);
                textArea.setEnabled(false);
                enterButton.setEnabled(false);
                editButton.setEnabled(true);
            }
        });

        editButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setEnabled(true);
                editButton.setEnabled(false);
                enterButton.setEnabled(true);
            }
        });
        add(enterButton);
        add(editButton);
    }

    // Used to set JTable
    public void setOutput(){
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.ipady = outputPanel.getHeight() - 50;
        gridConstraints.ipadx = outputPanel.getWidth() - 50;

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        tableModel.addColumn("Code");
        tableModel.addColumn("Value");
        tableModel.addColumn("Output");

        outputPanel.add(new JScrollPane(table), gridConstraints);
    }
}