import java.util.ArrayList;
import java.util.List;

public class ThredPool {
    public List<Runnable> getRunnablelist() {
        return runnablelist;
    }

    private List<Runnable> runnablelist = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    public void start(int count) {


        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new MyRunnable(runnablelist));
            threads.add(thread);
        }

        for (Thread thread:threads) {
            thread.start();
        }
    }

    public void execute(Runnable runnable){
        synchronized (runnablelist) {
            runnablelist.add(runnable);
            runnablelist.notify();
        }
    }
}
