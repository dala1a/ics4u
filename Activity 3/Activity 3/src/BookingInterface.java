public class BookingInterface {
    public static void main(String[] args) {
        PrimaryClient client = new PrimaryClient("John Doe");
        Hotel hotel = new Hotel(5, 2, "2025-07-15");
        Car car = new Car("SUV",9108223);
        Airline airline = new Airline("Delta", 4567, "2025-07-16", 1430);

        System.out.println("Client Name: " + client.getName());
        System.out.println("Hotel Rating: " + hotel.getRatingWanted());
        System.out.println("Hotel Rooms: " + hotel.getAmountRooms());
        System.out.println("Hotel Date: " + hotel.getDate());
        System.out.println("Car Type: " + car.getType());
        System.out.println("Car License No.: " + car.getLicenseNumber());
        System.out.println("Airline Name: " + airline.getAirline());
        System.out.println("Flight Number: " + airline.getFlightNumber());
        System.out.println("Flight Date: " + airline.getDate());
        System.out.println("Flight Time: " + airline.getTime());
    }
}