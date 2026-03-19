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
    

    public Window() {
        // panel setup
        setSize(500, 450);
        setLocation(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panelInput = new JPanel(new MigLayout("", "", "[]10[]10[]10[]10[]10[]20"));
        setContentPane(panelInput);
        // JLabels
        panelInput.add(new JLabel("Fermi Guessing Game"), "wrap");
        panelInput.add(new JLabel("Enter your three guesses (0-9):                Hints"),"wrap");
        // text fields
        FirstField = new JTextField();
        panelInput.add(FirstField,"wrap");
        SecondField = new JTextField();
        panelInput.add(SecondField,"wrap");
        ThirdField = new JTextField();
        panelInput.add(ThirdField, "wrap");

        FirstField.setPreferredSize(new Dimension(80, 20));
        SecondField.setPreferredSize(new Dimension(80, 20));
        ThirdField.setPreferredSize(new Dimension(80, 20));

        // ok Button
        OKButton = new JButton("     Ok    ");
        panelInput.add(OKButton,"wrap");
        // text area that shows the hints
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        txtOutput.setPreferredSize(new Dimension(400, 200));
        panelInput.add(txtOutput,"span 3, align right, wrap");
        // reset button at the bottom
        ResetButton = new JButton("  Reset  ");
        panelInput.add(ResetButton);
        
    }

    public static void main(String[] args) throws Exception {
        new Window().setVisible(true);
        
    }
}
