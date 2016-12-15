import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThredPool td = new ThredPool();
        td.start(4);

        for (int i = 0; i < 1000; i++) {
             int k = i;
            td.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Cейчас работает " + Thread.currentThread().getId() + " поток и делает " + k + " задачу");
                }
            });


        }


    }
}
