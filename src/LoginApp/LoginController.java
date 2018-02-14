package LoginApp;

import dbClient.DBClientController;
import dbService.DBServiceController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbStatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<Option> logAsComboBox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;


    public void initialize(URL url, ResourceBundle rb){

        if(this.loginModel.isDatabaseConnected()){
            this.dbStatus.setText("Connected to database");
        } else {
            this.dbStatus.setText("Not connected to database");
        }

        this.logAsComboBox.setItems(FXCollections.observableArrayList(Option.values()));
    }

    @FXML
    public void login(ActionEvent event){
        try {
            if(this.loginModel.isLogin(this.username.getText(), this.password.getText(), this.logAsComboBox.getValue().toString())){
                Stage stage = (Stage)this.loginButton.getScene().getWindow();
                stage.close();
                switch (((Option)this.logAsComboBox.getValue()).toString()) {
                    case "Admin":
                        logAsAdmin();
                        break;

                    case "Klient":
                        logAsClient();
                        break;
                }

            } else {
                this.loginStatus.setText("Niepoprawny login lub hasło");
            }


        } catch(Exception ex) {

        }
    }

    public void logAsAdmin(){
        try {
            Stage newStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane root = (Pane) adminLoader.load(getClass().getResource("/dbService/DBService.fxml").openStream());

            DBServiceController dbServiceController = (DBServiceController)adminLoader.getController();

            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.setTitle("Baza produktów");
            newStage.setResizable(false);
            newStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void logAsClient(){
        try {
            Stage newStage = new Stage();
            FXMLLoader clientLoader = new FXMLLoader();
            Pane root = (Pane) clientLoader.load(getClass().getResource("/dbClient/DBClient.fxml").openStream());

            DBClientController dbClient = (DBClientController) clientLoader.getController();

            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.setTitle("Baza produktów");
            newStage.setResizable(false);
            newStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
