import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 04.11.16.
 */
public class Test {
    public static void main(String[] args) {
        Person gena = new Person();
        gena.setAge(20);
        gena.setName("Gena");
        System.out.println(gena.getName());
        System.out.println(gena.getAge());
        System.out.println();
        Person lexa = new Person();
        lexa.setAge(22);
        lexa.setName("Alexey");

        System.out.println(lexa.getName());
        System.out.println(lexa.getAge());
        System.out.println();
        System.out.println("Меняем леху на гену");
        BeanUtils.assign(lexa,gena);

        System.out.println(gena.getName());
        System.out.println(gena.getAge());
        System.out.println();
        System.out.println(lexa.getName());
        System.out.println(lexa.getAge());
        System.out.println();



        Robot robot = new Robot();
        robot.setAge(45);
        robot.setName(1234);

        System.out.println("Робот врывается");
        System.out.println(robot.getName());
        System.out.println(robot.getAge());
        System.out.println();

        System.out.println("Меняем гену на робота, но имя измениться не должно");
        BeanUtils.assign(gena,robot);

        System.out.println(gena.getName());
        System.out.println(gena.getAge());
        System.out.println();

        SuperRobot superrobot = new SuperRobot();
        superrobot.setAge(100);
        superrobot.setName(2500);
        System.out.println("Новый суперробот");
        System.out.println(superrobot.getName());
        System.out.println(superrobot.getAge());
        System.out.println();

        System.out.println("Меняем суперробота на робота, все должно поменяться ведь Number является суперклассом для int");
        BeanUtils.assign(superrobot,robot);

        System.out.println(superrobot.getName());
        System.out.println(superrobot.getAge());
        System.out.println();

        superrobot.setAge(100);
        superrobot.setName(2500);
        System.out.println("А наоборот не сработает! Ничего не изменится");
        BeanUtils.assign(robot,superrobot);

        System.out.println(robot.getName());
        System.out.println(robot.getAge());
        System.out.println();


    }
}
