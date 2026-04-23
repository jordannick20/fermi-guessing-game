package tools;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TextFieldValidator {

    private final JTextField target;
    private String regExp = "\\w";
    private Color errorColor = Color.RED;

  
    private final Border defaultBorder;

     /**
     * constructor
     *  creates a validator for text field
     * 
     * @param Target the JTextField to validate
     * @param myErrorColor the border color to useif the input invalid
     */
    public TextFieldValidator(JTextField Target, Color myErrorColor) {
        target = Target;
        errorColor = myErrorColor;
        defaultBorder = Target.getBorder();
    }
      /**
     * @param myTarget the JTextField to validate
     */
    public TextFieldValidator(JTextField Target) {
        target = Target;
        defaultBorder = Target.getBorder();
    }
    /**
     * sets the regular expression used in validation
     * @param myRegExp the regular expression 
     */
    public void setRegExp(String myRegExp) {
        regExp = myRegExp;
    }
    /**
     * sets the color for the error border
     * @param myColor the new error color
     */
    public void setErrorColor(Color myColor) {
        errorColor = myColor;
    }
    /**
     * checks whether the text in the target field matches the regular expression.
     * @return true if valid false if invalid
     */
    public Boolean check() {
        if (target.getText().matches(regExp)) {
            return true;
        } else {
            target.setBorder(BorderFactory.createLineBorder(errorColor, 3));
            return false;
        }
    }
    /**
     * restores border
     */
    public void reset() {
        target.setBorder(defaultBorder);
    }
}

