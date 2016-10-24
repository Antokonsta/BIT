import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anton on 24.10.16.
 */
public class TestCollUt {
    public static void main(String[] args) {
        List<String> st = new ArrayList<>();
        List<String> st1 = new ArrayList<>();
        List<String> st2 = new ArrayList<>();
        List<String> st5 = new LinkedList<>();
        st5.add("GO");
        st.add("Hello");
        st.add("World");
        st.add("Of");
        st.add("Warcraft");

        st1.add("How");
        st1.add("are you?");


        st2.add("Snickers");
        st2.add("Mars");
        st2.add("Bounty");
        st2.add("AlphenGOld");
        st2.add("Of");

        CollectionUtils.addAll(st,st1);

        System.out.println(st1);
        System.out.println(CollectionUtils.newArrayList(st5).getClass());

        int a = CollectionUtils.indexOf(st1,"How");
        System.out.println(a);



        System.out.println(CollectionUtils.limit(st2,2));

        CollectionUtils.add(st1,"Fine");
        System.out.println(st1);

        CollectionUtils.removeAll(st,st1);
        System.out.println(st);


        System.out.println(CollectionUtils.containsAll(st2,st2));

        System.out.println(CollectionUtils.containsAny(st,st2));

        System.out.println(CollectionUtils.range(st2,"Mars","JJJJJJ"));

        List<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(4);
        in.add(6);
        in.add(5);
        in.add(7);
        in.add(8);
        System.out.println(in);

        System.out.println(CollectionUtils.range(in,2,7));

    }
}
