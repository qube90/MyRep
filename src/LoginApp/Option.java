package LoginApp;

public enum Option {

    Admin, Klient;

    private Option (){}


        public String value(){
            return name();
        }


    public static Option fromValue(String v) {
        return valueOf(v);
    }

}
