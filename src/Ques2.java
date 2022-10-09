import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ques2 {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10 ; i++) {
            int finalI = i;
            executorService1.submit(() -> {
                System.out.println("Fixed Thread pool "+ finalI);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService1.shutdown();
        try {
            executorService1.awaitTermination(5, TimeUnit.MINUTES);
            System.out.println("Fixed Thread pool finished execution");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10 ; i++) {
            int finalI = i;
            executorService2.submit(() -> {
                System.out.println("Single Thread Executor "+ finalI);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService2.shutdown();
        try {
            executorService2.awaitTermination(5, TimeUnit.MINUTES);
            System.out.println("Single Thread Executor finished execution");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService executorService3 = Executors.newCachedThreadPool();
        for (int i = 0; i < 10 ; i++) {
            int finalI = i;
            executorService3.submit(() -> {
                System.out.println("Cached Thread Pool "+ finalI);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService3.shutdown();
        try {
            executorService3.awaitTermination(5, TimeUnit.MINUTES);
            System.out.println("Cached Thread Pool finished Execution");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//