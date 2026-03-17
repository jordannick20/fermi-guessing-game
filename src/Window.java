import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
public class Window extends JFrame {

    private JTextField txtType;
    private JTextField txtCount;
    private JTextField txtPrice;

    private JTextArea txtOutput;

    private JButton OKButton;
    private JButton ResetButton;
    

    public Window() {
        setSize(500, 450);
        setLocation(200, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panelInput = new JPanel(new MigLayout("", "", "[]10[]10[]10[]10[]10[]20"));
        setContentPane(panelInput);
        
        
        panelInput.add(new JLabel("Fermi Guessing Game"), "wrap");
        panelInput.add(new JLabel("Enter your three guesses (0-9):                Hints"),"wrap");
        txtType = new JTextField();
        panelInput.add(txtType,"wrap");
        txtCount = new JTextField();
        panelInput.add(txtCount,"wrap");
        txtPrice = new JTextField();
        panelInput.add(txtPrice, "wrap");

        txtType.setPreferredSize(new Dimension(80, 20));
        txtCount.setPreferredSize(new Dimension(80, 20));
        txtPrice.setPreferredSize(new Dimension(80, 20));
        
        OKButton = new JButton("     Ok    ");
        panelInput.add(OKButton,"wrap");

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        txtOutput.setPreferredSize(new Dimension(400, 200));
        panelInput.add(txtOutput,"span 3, align right, wrap");

        ResetButton = new JButton("  Reset  ");
        panelInput.add(ResetButton);
        
    }


    public static void main(String[] args) throws Exception {
        new Window().setVisible(true);
        
    }
}
