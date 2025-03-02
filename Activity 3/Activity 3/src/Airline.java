public class Airline extends Reservation {
    private String Airline;
    private int FlightNumber ;
    private String Date;
    private int Time;

    public Airline(String Airline, int FlightNumber, String Date, int Time){
        this.Airline = Airline;
        this.FlightNumber = FlightNumber;
        this.Date = Date;
        this.Time = Time;
    }

    public Airline() {
        Airline = "";
        FlightNumber = 0;
        Date = "";
        Time = 0;
    }

    //airline setter
    public void setAirline(String newAirline){
        this.Airline = newAirline;
    }

    //flight num setter
    public void setFlightNumber(int newFlightNumber){
        this.FlightNumber = newFlightNumber;
    }

    //date setter
    public void setDate(String newDate){
        this.Date = newDate;
    }

    //time setter
    public void setTime(int newTime){
        this.Time = newTime;
    }

    //Airline getter
    public String getAirline(){
        return Airline;
    }

    //Flight num getter
    public int getFlightNumber(){
        return FlightNumber;
    }

    //Date getter
    public String getDate(){
        return Date;
    }


    
    //Time getter
    public int getTime(){
        return Time;
    }
}
