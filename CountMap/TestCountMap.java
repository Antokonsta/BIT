import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Anton on 23.10.16.
 */
public class TestCountMap {
    public static void main(String[] args) {
        CountMap<Number> map = new CountMapIml<>();


        map.add(10);

        map.add(10);

        map.add(5);

        map.add(6);

        map.add(5);
        map.add(10);
        map.add(1);
        map.add(3);
        map.add(3);
        map.add(3);
        map.add(1);
        map.add(1);
        map.add(1);
        map.add(0);
        map.add(8);
        map.add(8);
        map.add(5);
        map.add(4);
        map.add(2);
        map.add(2);
        map.add(2);
        map.add(3);
        map.add(33);


        System.out.println(map.getCount(5));
        System.out.println(map.getCount(6));
        System.out.println(map.getCount(10));
        System.out.println(map.size());
        System.out.println();

        System.out.println(map.remove(5));
        System.out.println(map.getCount(5));
        System.out.println();

        System.out.println(map.size());
        System.out.println(map.toMap());

        CountMap<Integer> maptoadd = new CountMapIml<>();
        System.out.println(map.getCount(1));

        maptoadd.add(1);
        maptoadd.add(1);
        maptoadd.add(1);
        maptoadd.add(1);
        maptoadd.add(0);
        maptoadd.add(7);
        maptoadd.add(6);
        maptoadd.add(2);
        maptoadd.add(1);
        maptoadd.add(100);
        maptoadd.add(100);
        maptoadd.add(200);
        maptoadd.add(200);
        System.out.println(maptoadd.toMap());
        map.addAll(maptoadd);
        System.out.println();

        System.out.println(map.toMap());

        Map<Integer, Integer> hash = map.toMap();
        System.out.println(hash);
        Map<Number, Integer> maped = new HashMap<>();
        maped.put(29, 3);

        map.toMap(maped);

        System.out.println(maped);


    }
}
