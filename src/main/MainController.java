package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {
    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private Button translateButton;

    private Translator translator = new Translator();

//    public void initialize(){
//    }

    public void onTranslateButtonClick(){
        String input = inputTextArea.getText();
        this.outputTextArea.setText(translator.translate(input));
    }

}
