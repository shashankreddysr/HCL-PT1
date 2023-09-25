import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Feedback {
    private String busNumber;
    private String passengerName;
    private String feedbackText;

    public Feedback(String busNumber, String passengerName, String feedbackText) {
        this.busNumber = busNumber;
        this.passengerName = passengerName;
        this.feedbackText = feedbackText;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFeedbackText() {
        return feedbackText;
    }
}
class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class PaymentGateway {

    // Simulate a payment processing function
    public static boolean processPayment(String cardNumber, double amount) {
        // You would typically call the actual payment gateway API here
        // For simplicity, we'll just return true if the payment is successful
        return true;
    }
}

class Bus {
    private String busNumber;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;
    private String source;
    private String destination;
    private String boardingDate;
    private String boardingTime;
    private String arrivalDate;
    private String arrivalTime;
    private double latitude;
    private double longitude;
    private List<Passenger> passengerList;

    public Bus(String busNumber, int totalSeats, double ticketPrice, String source, String destination, String boardingDate, String boardingTime, String arrivalDate, String arrivalTime) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.source = source;
        this.destination = destination;
        this.boardingDate = boardingDate;
        this.boardingTime = boardingTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.latitude = 160.2812;
        this.longitude = 42.8346;
        this.passengerList = new ArrayList<>();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getBoardingDate() {
        return boardingDate;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void collectFeedback(String passengerName, String feedbackText) {
        Feedback feedback = new Feedback(busNumber, passengerName, feedbackText);
        // Store the feedback for later review or analysis
        // You can add a list or database to store feedback here
        System.out.println("Thank you for your feedback!");
    }
    
    public void bookSeats(List<Passenger> passengers) {
        if (passengers.size() <= availableSeats) {
            // Calculate the total price
            double totalPrice = passengers.size() * ticketPrice;

            // Simulate payment processing
            boolean paymentSuccess = PaymentGateway.processPayment("1234-5678-9876-5432", totalPrice);

            if (paymentSuccess) {
                availableSeats -= passengers.size();
                passengerList.addAll(passengers);
                System.out.println(passengers.size() + " seat(s) booked successfully on bus " + busNumber);
                System.out.println("Total Price: $" + totalPrice);
            } else {
                System.out.println("Payment failed. Booking not confirmed.");
            }
        } else {
            System.out.println("Not enough seats available on bus " + busNumber);
        }
    }
}


class BusReservationSystem {
    private List<Bus> buses;

    public Bus getBusByNumber(String busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    public BusReservationSystem() {
        buses = new ArrayList<>();
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void displayAvailableBuses() {
        System.out.println("Available Buses:");
        for (Bus bus : buses) {
            System.out.println("Bus Number: " + bus.getBusNumber());
            System.out.println("Source: " + bus.getSource());
            System.out.println("Destination: " + bus.getDestination());
            System.out.println("Boarding Date: " + bus.getBoardingDate());
            System.out.println("Boarding Time: " + bus.getBoardingTime());
            System.out.println("Arrival Date: " + bus.getArrivalDate());
            System.out.println("Arrival Time: " + bus.getArrivalTime());
            System.out.println("Total Seats: " + bus.getTotalSeats());
            System.out.println("Available Seats: " + bus.getAvailableSeats());
            System.out.println("Ticket Price: $" + bus.getTicketPrice());
            System.out.println();
        }
    }

    public boolean makePayment(String busNumber, double amount, String cardNumber, String expiryDate, String cvv, List<Passenger> passengers) {
        Bus bus = getBusByNumber(busNumber);

        if (bus == null) {
            System.out.println("Bus with number " + busNumber + " not found.");
            return false;
        }

        // Check if there are available seats and calculate the total price
        int availableSeats = bus.getAvailableSeats();
        if (availableSeats < passengers.size()) {
            System.out.println("Not enough available seats on bus " + busNumber);
            return false;
        }

        double totalPrice = passengers.size() * bus.getTicketPrice();

        // Simulate payment processing (replace with actual payment gateway integration)
        boolean paymentSuccess = simulatePaymentProcessing(cardNumber, expiryDate, cvv, totalPrice);

        if (paymentSuccess) {
            // Update the booking and reduce available seats
            bus.bookSeats(passengers);
            System.out.println("Payment successful! " + passengers.size() + " seat(s) booked on bus " + busNumber);
            System.out.println("Total Price: $" + totalPrice);
            return true;
        } else {
            System.out.println("Payment failed. Booking not confirmed.");
            return false;
        }
    }

    private boolean simulatePaymentProcessing(String cardNumber, String expiryDate, String cvv, double amount) {
        // Simulate payment processing here (replace with actual payment gateway integration)
        // For simplicity, assume all payments are successful
        return true;
    }

    public void bookTicket(String busNumber, List<Passenger> passengers) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                bus.bookSeats(passengers);
                return;
            }
        }
        System.out.println("Bus with number " + busNumber + " not found.");
    }
    
    public void collectFeedback(String busNumber, String passengerName, String feedbackText) {
        Bus bus = getBusByNumber(busNumber);

        if (bus != null) {
            bus.collectFeedback(passengerName, feedbackText);
        } else {
            System.out.println("Bus with number " + busNumber + " not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String correctUsername = "shashank";
        String correctPassword = "SHAshank@5183";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bus Reservation System");
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
            System.out.println("Login successful!");

            BusReservationSystem reservationSystem = new BusReservationSystem();
            reservationSystem.addBus(new Bus("Bus001", 50, 50.0, "Chennai", "Hyderabad", "22-09-2023", "9:00pm", "23-09-2023", "7:00am"));
            reservationSystem.addBus(new Bus("Bus002", 40, 70.0, "Chennai", "Bangalore", "22-09-2023", "9:00pm", "23-09-2023", "5:00pm"));
            reservationSystem.addBus(new Bus("Bus003", 30, 90.0, "Bangalore", "Hyderabad", "22-09-2023", "7:00pm", "23-09-2023", "5:00am"));

            while (true) {
                System.out.println("1. Display available buses");
                System.out.println("2. Book a ticket");
                System.out.println("3. Display passenger details for a bus");
                System.out.println("4. Live Tracking");
                System.out.println("5. provide feedback");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        reservationSystem.displayAvailableBuses();
                        break;
                    case 2:
    			System.out.print("Enter the bus number: ");
    			String busNumber = scanner.next();
    			System.out.print("Enter the number of passengers: ");
    			int passengerCount = scanner.nextInt();

    			List<Passenger> passengers = new ArrayList<>();
    			for (int i = 1; i <= passengerCount; i++) {
        		    System.out.println("Enter details for passenger " + i + ":");
        		    System.out.print("Name: ");
        	 	    String name = scanner.next();
        		    System.out.print("Age: ");
        		    int age = scanner.nextInt();
        		    passengers.add(new Passenger(name, age));
    			}

    			// Collect payment details
    			System.out.print("Enter card number: ");
    			String cardNumber = scanner.next();
    			System.out.print("Enter expiry date (MM/YY): ");
    			String expiryDate = scanner.next();
    			System.out.print("Enter CVV: ");
    			String cvv = scanner.next();

    			// Calculate the total price
    			Bus bus = reservationSystem.getBusByNumber(busNumber);
    			if (bus != null) {
        		    double totalPrice = passengers.size() * bus.getTicketPrice();

        		// Call the makePayment method
       			    boolean paymentSuccess = reservationSystem.makePayment(busNumber, totalPrice, cardNumber, expiryDate, cvv, passengers);

        		    if (paymentSuccess) {
            			System.out.println("Booking confirmed!");
       			    } else {
            			System.out.println("Booking failed. Please try again.");
        		    }
   		        } else {
        		    System.out.println("Bus with number " + busNumber + " not found.");
    			}
    			break;

                        
                    case 3:
                        System.out.print("Enter the bus number to display passenger details: ");
                        String busNumberToDisplay = scanner.next();
                        Bus busToDisplay = reservationSystem.getBusByNumber(busNumberToDisplay);

                        if (busToDisplay != null) {
                            List<Passenger> passengerList = busToDisplay.getPassengerList();
                            System.out.println("Passenger details for Bus " + busNumberToDisplay + ":");
                            for (Passenger passenger : passengerList) {
                                System.out.println("Name: " + passenger.getName());
                                System.out.println("Age: " + passenger.getAge());
                                System.out.println();
                            }
                        } else {
                            System.out.println("Bus with number " + busNumberToDisplay + " not found.");
                        }
                        break;
                    case 4:
                        startLiveTracking();
                        break;
                    case 5:
                        provideFeedback(reservationSystem, scanner);
                        break;
                    case 6:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
    }
    
    private static void provideFeedback(BusReservationSystem reservationSystem, Scanner scanner) {
        System.out.print("Enter the bus number for feedback: ");
        String busNumber = scanner.next();
        System.out.print("Enter your name: ");
        String passengerName = scanner.next();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter your feedback: ");
        String feedbackText = scanner.nextLine();

        reservationSystem.collectFeedback(busNumber, passengerName, feedbackText);
    }

    private static void startLiveTracking() {
        System.out.println("Live Tracking started. Press Enter to stop.");
        Scanner scanner = new Scanner(System.in);
        Bus bus001 = new Bus("Bus001", 50, 50.0, "Chennai", "Hyderabad", "22-09-2023", "9:00pm", "23-09-2023", "7:00am");
        Random rand = new Random();

        displayGPSInfo(bus001);

        while (true) {
            if (scanner.nextLine().isEmpty()) {
                break;
            }

            double latitude = bus001.getLatitude() + (rand.nextDouble() - 0.5) * 0.001;
            double longitude = bus001.getLongitude() + (rand.nextDouble() - 0.5) * 0.001;

            bus001.setLatitude(latitude);
            bus001.setLongitude(longitude);

            displayGPSInfo(bus001);
        }

        System.out.println("Live Tracking stopped.");
    }

    private static void displayGPSInfo(Bus bus) {
        double latitude = bus.getLatitude();
        double longitude = bus.getLongitude();
        System.out.println("Current GPS Coordinates: Latitude " + latitude + ", Longitude " + longitude);
    }
}
