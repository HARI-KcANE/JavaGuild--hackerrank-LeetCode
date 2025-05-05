import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private int maximumCapacity;
    private Queue<Ticket> tickets;

    public TicketPool(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        tickets = new LinkedList<>();
    }
    //this method will add tickets to the queue by the vendor
    public synchronized void addTicket(Ticket ticket){
        while(tickets.size()>=maximumCapacity){ //if max cap is reached, the vendor cannot add tickets
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        tickets.add(ticket);
        notifyAll();
    }

    //this method will remove tickets from the queue by the customer
    public synchronized Ticket buyTicket(){
        while(tickets.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Ticket ticket = tickets.poll();
        notifyAll();
        return ticket;
    }
}
