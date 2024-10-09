package ist.gt.util;

import ist.gt.model.Operator;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.lang.reflect.Method;

public class Util {


    public static <T extends Serializable> T cloneObject(T object) {
        try {
            return SerializationUtils.clone(object);
        } catch (Exception e) {
            System.out.println("An error has occurred while trying to clone object");
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public static <E extends Throwable> void throwAny(Throwable e) throws E {
        throw (E) e;
    }

    public static String removeQuotes(String string) {
        return string.replaceAll("^\"+|\"+$", "");

    }


    public static <T> T getPropSafe(PropertySafe<T> action) {
        try {
            return action.getPropertySafe();
        } catch (Exception e) {
            return null;
        }
    }

    public static Operator toOperator(String op) {
        return switch (op) {
            case "==" -> Operator.EQUAL;
            case "!=" -> Operator.NOT_EQUAL;
            case "+" -> Operator.ADD;
            case "-" -> Operator.SUBTRACT;
            case "*" -> Operator.MULTIPLY;
            case "/" -> Operator.DIVIDE;
            case "%" -> Operator.MODULUS;
            default -> null;
        };
    }

    public static Object callMethodIfExists(Object obj, String methodName) {
        try {
            // Get the method by name and parameter types
            Method method = obj.getClass().getDeclaredMethod(methodName);
            // Invoke the method
            return method.invoke(obj);
        } catch (NoSuchMethodException e) {
            System.out.println("Method '" + methodName + "' not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


