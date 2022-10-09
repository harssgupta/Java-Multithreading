class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread created using Runnable Interface");
    }
}
class ThreadThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread created using Thread Class");
    }
}
public class Ques1 {
    public static void main(String[] args) {
        ThreadRunnable threadRunnable= new ThreadRunnable();
        ThreadThread threadThread= new ThreadThread();
        threadThread.start();
        try {
            threadThread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            threadThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(threadRunnable).start();
    }
}
