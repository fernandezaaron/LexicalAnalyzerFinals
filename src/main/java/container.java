public class container {
    private String code;
    private String value;
    private String identify;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getIdentify() {
        return identify;
    }

    public container(String code, String value, String identify){
        this.code = code;
        this.value = value;
        this.identify = identify;
    }

    public void show(){
        System.out.println(code + " " + value + " " + identify);
    }
}
