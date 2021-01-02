/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIN;

import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author ysnak
 */
public class ControlUtil {

    public static TextFormatter OnlyDouble() {
        UnaryOperator<TextFormatter.Change> filter = new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change t) {
                if (t.isReplaced()) {
                    if (t.getText().matches("[^0-9]")) {
                        t.setText(t.getControlText().substring(t.getRangeStart() , t.getRangeEnd()));
                    }
                }
                if (t.isAdded()) {
                    if (t.getControlText().contains(".")) {
                        if (t.getText().matches("[^0-9]")) {
                            t.setText("");
                        }else if(t.getText().matches("[^0-9.]")){
                            t.setText("");
                        }
                    }
                }
                return t;
            }
        };
        return new TextFormatter(filter);
    }

}
