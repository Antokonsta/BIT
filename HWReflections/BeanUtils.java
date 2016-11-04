import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 04.11.16.
 */
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * <p>
     * contains correspondent setter, it will invoke it
     * <p>
     * to set property value for "to" which equals to the property
     * <p>
     * of "from".
     * <p>
     * <p/>
     * <p>
     * The type in setter should be compatible to the value returned
     * <p>
     * by getter (if not, no invocation performed).
     * <p>
     * Compatible means that parameter type in setter should
     * <p>
     * be the same or be superclass of the return type of the getter.
     * <p>
     * <p/>
     * <p>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */

    public static void assign(Object to, Object from) {
        List<String> allGetMethodsFrom = new ArrayList<>();

        Method[] methodsfrom = from.getClass().getMethods();
        for (Method method : methodsfrom) {
            if (method.getName().startsWith("get") &&
                    !method.getReturnType().equals(Void.TYPE) && method.getParameterCount() == 0) {
                allGetMethodsFrom.add(method.getName());
            }
        }


        List<String> allSetMethodsTo = new ArrayList<>();
        Method[] methodsto = to.getClass().getMethods();
        for (Method method : methodsto) {
            if (method.getName().startsWith("set") &&
                    method.getReturnType().equals(Void.TYPE) && method.getParameterCount() == 1) {
                allSetMethodsTo.add(method.getName());
            }
        }


        for (String methodset : allSetMethodsTo) {
            String[] setters = methodset.split("set");
            for (String methodget : allGetMethodsFrom) {
                String[] getters = methodget.split("get");
                if (setters[1].equals(getters[1])) {
                    try {
                        Method get = from.getClass().getMethod("get" + getters[1]);
                        Object gettersresult = get.invoke(from);
                        Class returnType = get.getReturnType();

                        for (int i = 0; i < methodsto.length; i++) {
                            if(methodsto[i].getName().equals(methodset)){
                                Class[] setMethodType = methodsto[i].getParameterTypes();
                                if(setMethodType[0].isAssignableFrom(returnType)) {
                                    Method set = to.getClass().getMethod("set" + setters[1], setMethodType[0]);
                                    set.invoke(to, gettersresult);
                                }
                            }
                        }


                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
