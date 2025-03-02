public class Reservation {
    private int AmountOfTravellers;

    public Reservation (int AmountOfTravellers) {
        this.AmountOfTravellers = AmountOfTravellers;
    }

    public Reservation() {
        AmountOfTravellers = 0;
    }

    //Setter
    public void setAmountOfTravelers(int newAmountOfTravellers){
        this.AmountOfTravellers = newAmountOfTravellers;
    }
    //Getter
    public int getAmountOfTravellers(){
        return AmountOfTravellers;
    }
}
