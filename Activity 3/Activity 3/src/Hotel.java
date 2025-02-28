public class Hotel {
    private int RatingWanted;
    private int AmountRooms;
    private String Date;

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
