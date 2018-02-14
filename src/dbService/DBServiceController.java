package dbService;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBServiceController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField company;
    @FXML
    private TextField image;

    @FXML
    private TableView<ProductsData> productTable;

    @FXML
    private TableColumn<ProductsData, String> idColumn;
    @FXML
    private TableColumn<ProductsData, String> nameColumn;
    @FXML
    private TableColumn<ProductsData, String> priceColumn;
    @FXML
    private TableColumn<ProductsData, String> companyColumn;
    @FXML
    private TableColumn<ProductsData, String> dobColumn;

    private dbConnection dc;
    private ObservableList<ProductsData> data;

    private String sql = "SELECT * FROM product";

    public void initialize(URL url, ResourceBundle rb){
        this.dc = new dbConnection();

    }


    @FXML
    private void loadProductsData(ActionEvent event) {
        try {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new ProductsData(rs.getString(1), rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6)));
            }

        } catch (SQLException e) {
            System.err.println("Error: "+ e);
        }

        this.idColumn.setCellValueFactory(new PropertyValueFactory<ProductsData, String>("ID"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<ProductsData, String>("NAME"));
        this.priceColumn.setCellValueFactory(new PropertyValueFactory<ProductsData, String>("PRICE"));
        this.companyColumn.setCellValueFactory(new PropertyValueFactory<ProductsData, String>("COMPANY"));
        this.dobColumn.setCellValueFactory(new PropertyValueFactory<ProductsData, String>("DOB"));

        this.productTable.setItems(null);
        this.productTable.setItems(this.data);

    }

    @FXML
    private void addProduct (ActionEvent event) {
        String sqlInsert = "INSERT INTO product(id, name, price, image, company, dob) VALUES(?, ?, ?, ?, ?, ?)";


        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.id.getText());
            stmt.setString(2, this.name.getText());
            stmt.setString(3, this.price.getText());
            stmt.setString(4, "image");
            stmt.setString(5, this.company.getText());
            stmt.setString(6, this.dob.getEditor().getText());

            stmt.execute();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void clearData(ActionEvent event){
        this.id.setText("");
        this.name.setText("");
        this.price.setText("");
        this.company.setText("");
        this.dob.setValue(null);
    }


}
