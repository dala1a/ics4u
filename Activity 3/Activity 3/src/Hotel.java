public class Hotel extends Reservation {
    private int RatingWanted;
    private int AmountRooms;
    private String Date;

    public Hotel(int RatingWanted, int AmountRooms, String Date) {
        this.RatingWanted = RatingWanted;
        this.AmountRooms = AmountRooms;
        this.Date = Date;
    }

    public Hotel() {
        RatingWanted = 0;
        AmountRooms = 0;
        Date = "";
    }

    //Rating setter
    public void setRatingWanted(int newRatingWanted){
        this.RatingWanted = newRatingWanted;
    }

    //Room amount setter
    public void setAmountRooms(int newAmountRooms){
        this.AmountRooms = newAmountRooms;
    }

    //Date setter
    public void setDate(String newDate){
        this.Date = newDate;
    }

    //Rating getter
    public int getRating(){
        return RatingWanted;
    }

    //room amount getter
    public int getAmountRooms(){
        return AmountRooms;
    }

    //Date getter
    public String getDate(){
        return Date;
    }
}
