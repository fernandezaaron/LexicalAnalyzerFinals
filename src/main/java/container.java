public class container {
    private String code;
    private String value;
    private String identify;
    private boolean used;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }


    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getIdentify() {
        return identify;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public container(String code, String value, String identify){
        this.code = code;
        this.value = value;
        this.identify = identify;
    }

    public container(String code, String value, String identify, boolean used){
        this.code = code;
        this.value = value;
        this.identify = identify;
        this.used = used;
    }


    public void show(){
        System.out.println(code + " " + value + " " + identify);
    }
}
