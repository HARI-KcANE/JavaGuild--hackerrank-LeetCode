public class Vendor implements Runnable {

    private int vendorId;
    private int totalTickets;
    private int ticketReleaseRate;
    private TicketPool ticketPool;

    public Vendor(int vendorId, int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.vendorId = vendorId;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    @Override
    public void run() {
        for (int i = 1; i<= totalTickets; i++){
            Ticket ticket = new Ticket(i+1, 420, "FILM EKAK");
            ticketPool.addTicket(ticket);
            System.out.println(Thread.currentThread().getName() + " released " + ticket);
            try {
                Thread.sleep(ticketReleaseRate * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
