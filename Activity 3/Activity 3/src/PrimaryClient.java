public class PrimaryClient {
    private String name;

    public PrimaryClient (String name){
        this.name = name;
    }
    public PrimaryClient() {
        name = "";
    }
    //Setter
    public void setName(String name) {
       name = name;
    }
    //Getter
    public String getName() {
        return name;
    }
}
