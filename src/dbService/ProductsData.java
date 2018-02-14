package dbService;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductsData {

    private final StringProperty ID;
    private final StringProperty NAME;
    private final StringProperty PRICE;
    private final StringProperty DOB;
    private final StringProperty IMAGE;
    private final StringProperty COMPANY;


    public ProductsData(String id, String name, String price,String image, String company,  String dob) {

        this.ID = new SimpleStringProperty(id);
        this.NAME = new SimpleStringProperty(name);
        this.PRICE = new SimpleStringProperty(price);
        this.DOB = new SimpleStringProperty(dob);
        this.IMAGE = new SimpleStringProperty(image);
        this.COMPANY = new SimpleStringProperty(company);

    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getNAME() {
        return NAME.get();
    }

    public StringProperty NAMEProperty() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME.set(NAME);
    }

    public String getPRICE() {
        return PRICE.get();
    }

    public StringProperty PRICEProperty() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE.set(PRICE);
    }

    public String getDOB() {
        return DOB.get();
    }

    public StringProperty DOBProperty() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
    }

    public String getIMAGE() {
        return IMAGE.get();
    }

    public StringProperty IMAGEProperty() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE.set(IMAGE);
    }

    public String getCOMPANY() {
        return COMPANY.get();
    }

    public StringProperty COMPANYProperty() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY.set(COMPANY);
    }



}
