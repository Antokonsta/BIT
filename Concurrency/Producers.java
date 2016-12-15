import sun.nio.ch.ThreadPool;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.currentTimeMillis;

public class Producers {
    private final List<String> strings = new ArrayList<>();
    private ThredPool thredPool;

    public void produce() {
        while (true){
            synchronized (this){
                while (strings.size() > 10000){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                notify();
                strings.add("item " + currentTimeMillis());
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (this) {
                while (!strings.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String remove = strings.remove(0);
                    System.out.println(remove);
                    notify();
                }
            }
        }
    }


    public static void main(String[] args) {
        Map<Integer,Integer> l = new ConcurrentHashMap<>();
        List<Integer> ll = new CopyOnWriteArrayList<>();
                Producers pr = new Producers();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                pr.produce();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                pr.consume();
            }
        });
        thread1.start();
        thread2.start();

    }

}
