public class Main {
    public static void main(String[] args) {

        TicketPool ticketPool = new TicketPool(5);

        for(int i = 0; i < 10; i++) {
            Thread vendorThread = new Thread(new Vendor(i+1,10, 1, ticketPool), "Vendor " + (i+1));
            Thread customerThread = new Thread(new Customer(i+1, 1, 10, ticketPool), "Customer " + (i+1));
            vendorThread.start();
            customerThread.start();
        }
    }
}