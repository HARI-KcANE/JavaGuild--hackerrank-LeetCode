public class Ticket {

    private int ticketId;
    private int ticketPrice;
    private String eventName;

    public Ticket(int ticketId, int ticketPrice, String eventName) {
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.eventName = eventName;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId + ", ticketPrice=" + ticketPrice + ", eventName=" + eventName + '}';
    }
}
