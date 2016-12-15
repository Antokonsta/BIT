import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Anton on 15.12.16.
 */
public class Main {
    public static void main(String[] args) {
        Person ted = new Person(18,"Ted");
        Person nick = new Person(20,"Nick");
        Person sam = new Person(23,"Sam");
        List<Person> personList = new ArrayList<>();
        personList.add(ted);
        personList.add(nick);
        personList.add(sam);

        Map person = Streams.of(personList)
                .filter(p -> p.getAge() > 19)
                .transform(p -> new Person(p.getAge() + 2,p.getName()))
                .toMap(p -> p.getName(), p -> p.getAge());

        for (Object o : person.keySet()) {
            System.out.println(o.toString() + " " + person.get(o).toString());
        }

    }
}
