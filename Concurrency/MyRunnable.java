import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable {
    List<Runnable> runlist = new ArrayList<>();

    public MyRunnable(List<Runnable> runlist) {
        this.runlist = runlist;
    }

    @Override
    public void run() {
        while (true) {
            Runnable runnable = null;
            synchronized (runlist){
                while (runlist.isEmpty()) {
                    try {
                        runlist.wait();
                        System.out.println("Жду");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(!runlist.isEmpty()){
                    runnable = runlist.get(0);
                    runlist.remove(0);
                }

            }

            if(runnable!= null)
                runnable.run();
        }
    }
}
