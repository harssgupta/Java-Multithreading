class TicketBookingCounter {
    int ticketsAvailable = 2;
    void bookTicket(String name, int ticketsToBook) {
        if((ticketsAvailable >= ticketsToBook) && (ticketsToBook > 0)) {
            System.out.println(name+" : "+ ticketsToBook + " Tickets Booked Successfully");
            ticketsAvailable -= ticketsToBook;
        } else {
            System.out.println(name +" : No Tickets are Available");
        }
    }
}
class TicketCounterThread extends Thread {
    TicketBookingCounter thread;
    String name;
    int tickets;
    TicketCounterThread(TicketBookingCounter thread, String name, int tickets) {
        this.thread = thread;
        this.name = name;
        this.tickets = tickets;
    }
    public void run() {
        synchronized (thread){
            thread.bookTicket(name, tickets);
        }
    }
}
public class Ques3BlockSynchronised extends Thread{
    public static void main(String[] args) {
        TicketBookingCounter tc = new TicketBookingCounter();
        TicketCounterThread thread1 = new TicketCounterThread(tc, "Harsh", 2);
        TicketCounterThread thread2 = new TicketCounterThread(tc, "Mayank", 1);
        thread1.start();
        thread2.start();
    }
}
