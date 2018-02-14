package dbClient;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DBClientController implements Initializable {


    @FXML
    private Label labelName;
    @FXML
    private Label labelPrice;
    @FXML
    private Label labelDescription;
    @FXML
    private ImageView imageView;
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private ChoiceBox<ProductType> choiceBox;




    private dbConnection dc;

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();

        this.choiceBox.setItems(FXCollections.observableArrayList(ProductType.values()));

    }












}
