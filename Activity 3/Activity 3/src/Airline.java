public class Airline {
    private String Airline;
    private int FlightNumber ;
    private String Date;
    private int Time;

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
