package arona;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Arona arona;
    private Image aronaImage = new Image(this.getClass().getResourceAsStream("/images/Arona_Icon.png"));
    private Image senseiImage = new Image(this.getClass().getResourceAsStream("/images/Sensei_Icon.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getAronaDialog(Ui.showGreeting(), aronaImage)
        );
    }

    /** Injects the Arona instance */
    public void setArona(Arona a) {
        this.arona = a;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Arona's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = arona.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getSenseiDialog(input, senseiImage),
                DialogBox.getAronaDialog(response, aronaImage)
        );
        userInput.clear();
    }
}
