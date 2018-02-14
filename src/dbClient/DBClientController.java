package dbClient;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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


    public String table;

    private dbConnection dc;

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();

        this.choiceBox.setItems(FXCollections.observableArrayList(ProductType.values()));

    }

    public void loadData(int offset) {
        try {
            Connection con = dbConnection.getConnection();
            if (choiceBox.getValue().toString() == "Kwiaty") {
                 table = "kwiaty";
             } else if (choiceBox.getValue().toString() == "Krzewy"){
                table = "krzewy";
            }else if (choiceBox.getValue().toString() == "Drzewa"){
                table = "drzewa";
            }else if (choiceBox.getValue().toString() == "Narzędzia"){
                table = "narzedzia";
            }else if (choiceBox.getValue().toString() == "Nawozy"){
                table = "nawozy";
            }else if (choiceBox.getValue().toString() == "Inne"){
                table = "inne";
            } else {
                table = null;
            }

            String sqlLine = "SELECT * FROM " + table + " LIMIT 1 OFFSET " + Integer.toString(offset);

            Image image = new Image("D:\\programowanie\\pliki programów nauka\\Kamil1\\probny_kwiaty.jpg");

            ResultSet rs = con.createStatement().executeQuery(sqlLine);

            this.labelName.setText(rs.getString(1));
            this.labelPrice.setText(rs.getString(2));
            this.labelDescription.setText(rs.getString(3));
            this.imageView.setImage(image);


        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }















}
