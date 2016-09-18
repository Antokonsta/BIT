/**
 * Created by Anton on 18.09.16.
 */
public class Main {
    public static void main(String[] args) {
        Person john = new Person(true, "John");
        Person helly = new Person(false, "Helly");
        Person lola = new Person(false, "Lola");
        Person mark = new Person(true, "Mark");

        helly.marry(john);
        john.marry(lola); // Джон развелся с Хелли и поженился на Лоле
        mark.marry(helly); // Тут у всех есть пара
        mark.marry(lola); // теперь Джон и Хелли не имеют пары

        System.out.println(john.getName() + " married with " + john.getSpouseName());
        System.out.println(helly.getName() + " married with " + helly.getSpouseName());
        System.out.println(lola.getName() + " married with " + lola.getSpouseName());
        System.out.println(mark.getName() + " married with " + mark.getSpouseName());
    }
}
