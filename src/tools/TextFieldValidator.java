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

  
    public TextFieldValidator(JTextField Target, Color myErrorColor) {
        target = Target;
        errorColor = myErrorColor;
        defaultBorder = Target.getBorder();
    }

    public TextFieldValidator(JTextField Target) {
        target = Target;
        defaultBorder = Target.getBorder();
    }

    public void setRegExp(String myRegExp) {
        regExp = myRegExp;
    }

    public void setErrorColor(Color myColor) {
        errorColor = myColor;
    }

    public Boolean check() {
        if (target.getText().matches(regExp)) {
            return true;
        } else {
            target.setBorder(BorderFactory.createLineBorder(errorColor, 3));
            return false;
        }
    }

    public void reset() {
        target.setBorder(defaultBorder);
    }
}

