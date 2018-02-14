package dbClient;

public enum ProductType {
    Kwiaty, Drzewa, Krzewy, Nawozy, Narzędzia, Inne;

    private ProductType(){}


    public String value(){
        return name();
    }


    public static ProductType fromValue(String v) {
        return valueOf(v);
    }
}
