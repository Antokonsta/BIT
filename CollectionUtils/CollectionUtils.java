import java.util.*;

/**
 * Created by Anton on 23.10.16.
 */
public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {//+

        destination.addAll(source);

    }


    public static<T> List<T> newArrayList(List<T> list) {

       return list = new ArrayList<>();
    }


    public static <E> int indexOf(List<? super E> source, E e) {//+

        return source.indexOf(e);
    }


    public static<T> List<T> limit(List<T> source, int size) {//+
        List<T> res = new ArrayList<>();
        int a = source.size();
        if (a < size) {
            return source;
        } else {
            for (int i = 0; i < size; i++) {
                res.add(source.get(i));
            }
            return res;
        }
    }


    public static <E> void add(List<? super E> source, E e) {//+
        source.add(e);

    }


    public static <E> void removeAll(List<? super E> removeFrom, List<? extends E> c2) {//+
        removeFrom.removeAll(c2);
    }


    public static <E> boolean containsAll(List<? super E> c1, List<? extends E> c2) {//+
        return c1.containsAll(c2);
    }//+


    public static <E> boolean containsAny(List<? super E> c1, List<? extends E> c2) {//+
        int c = 0;

        for (int i = 0; i < c2.size(); i++) {
            if (c1.contains(c2.get(i))) {
                return true;
            }
        }
        return false;
    }


    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max) {//+
        Collections.sort(list);
        List<T> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).compareTo(min) < 0 || list.get(i).compareTo(max) > 0)) {
                res.add(list.get(i));
            }
        }
        return res;
    }


    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max, Comparator comparator) {
        Collections.sort(list,comparator);
        List<T> res1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).compareTo(min) < 0 || list.get(i).compareTo(max) > 0)) {
                res1.add(list.get(i));
            }
        }
        return res1;
    }


}

