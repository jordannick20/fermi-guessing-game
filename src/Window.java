import tools.TextFieldValidator;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
public class Window extends JFrame {

    private JTextField FirstField;
    private JTextField SecondField;
    private JTextField ThirdField;

    private JTextArea txtOutput;

    private JButton OKButton;
    private JButton ResetButton;

    private TextFieldValidator FirstValue;
    private TextFieldValidator SecondValue;  
    private TextFieldValidator ThirdValue;

    private HintManager hintManager;

    public Window() {
        // panel setup
        setSize(500, 450);
        setLocation(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        hintManager = new HintManager();
        
        JPanel mainPanel = new JPanel(new MigLayout(""));
        setContentPane(mainPanel);
        JPanel leftPanel = new JPanel(new MigLayout("", "", "[]10[]10[]10[]10[]10[]180"));
        mainPanel.add(leftPanel);

        // JLabels
        leftPanel.add(new JLabel("Fermi Guessing Game"), "wrap");
        leftPanel.add(new JLabel("Enter your three guesses (0-9):"),"wrap");

        // text fields
        FirstField = new JTextField();
        leftPanel.add(FirstField,"wrap");
        SecondField = new JTextField();
        leftPanel.add(SecondField,"wrap");
        ThirdField = new JTextField();
        leftPanel.add(ThirdField, "wrap");

        // setting size for text
        FirstField.setPreferredSize(new Dimension(80, 20));
        SecondField.setPreferredSize(new Dimension(80, 20));
        ThirdField.setPreferredSize(new Dimension(80, 20));

        // ok Button
        OKButton = new JButton("     Ok    ");
        leftPanel.add(OKButton,"wrap");

        // reset button
        ResetButton = new JButton("  Reset  ");
        leftPanel.add(ResetButton);

        JPanel rightPanel = new JPanel(new MigLayout(""));
        mainPanel.add(rightPanel);
        rightPanel.add(new JLabel("Hints"),"wrap");

        // text area that shows the hints
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        txtOutput.setPreferredSize(new Dimension(400, 200));

        // ScrollPane with dimension
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setPreferredSize(new Dimension(250, 300));
        rightPanel.add(scrollPane);

        // sets the boarder color around textfield when an error occurs
        FirstValue = new TextFieldValidator(FirstField, Color.RED);
        SecondValue = new TextFieldValidator(SecondField, Color.RED);   
        ThirdValue = new TextFieldValidator(ThirdField, Color.RED);

        // only single digit numbers 0-9 are alowed 
        FirstValue.setRegExp("^[0-9]$");
        SecondValue.setRegExp("^[0-9]$");
        ThirdValue.setRegExp("^[0-9]$");

        // ok button action listener 
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            FirstValue.reset();                    
            SecondValue.reset();
            ThirdValue.reset();

            // runs check method to see if digit entered is 0-9
            boolean pass1 = FirstValue.check();
            boolean pass2 = SecondValue.check();    
            boolean pass3 = ThirdValue.check();

            if (pass1 && pass2 && pass3) {
                int input1 = Integer.parseInt(FirstField.getText());
                int input2 = Integer.parseInt(SecondField.getText());
                int input3 = Integer.parseInt(ThirdField.getText());

                String reset = hintManager.getHint(input1, input2, input3);
                txtOutput.append(reset + "\n");
                
                // when game is over remove text disable input and OKButton
                FirstField.setText("");
                SecondField.setText("");
                ThirdField.setText("");
                // focus for First JText area when ok button is clicked
                FirstField.requestFocusInWindow();

                if (hintManager.isGameOver()) {
                    FirstField.setEnabled(false);
                    SecondField.setEnabled(false); 
                    ThirdField.setEnabled(false);
                    OKButton.setEnabled(false);
                }
            }
        }
    });
        // reset button event listener
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
            hintManager.reset();

            FirstValue.reset();
            SecondValue.reset();
            ThirdValue.reset();
            

            FirstField.setText("");
            SecondField.setText("");
            ThirdField.setText("");
            txtOutput.setText("");
            // focus for First JTextField on reset
            FirstField.requestFocusInWindow();

            

            FirstField.setEnabled(true);
            SecondField.setEnabled(true);
            ThirdField.setEnabled(true);  
            OKButton.setEnabled(true);
            }
        });
    }
    public static void main(String[] args) {
        new Window().setVisible(true);
    }
}
