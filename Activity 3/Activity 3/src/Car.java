public class Car extends Reservation {
    private String Type;
    private long LicenseNumber;
    
    public Car(String Type, long LicenseNumber){
        this.Type = Type;
        this.LicenseNumber = LicenseNumber;
    }

    public Car() {
        Type = "";
        LicenseNumber = 0;
    }

    //Type getter
    public String getType(){
        return Type;
    }

    //LicenseNumber getter
    public long getLicenseNumber(){
        return LicenseNumber;
    }
}
