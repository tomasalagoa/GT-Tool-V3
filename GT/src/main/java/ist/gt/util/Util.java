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

    /**
     *
     * @param obj the object from which we want to call the method from
     * @param methodName the name of the method to be called
     * @return the result of the call, if successfull
     * This function checks whether an object implements a specific method which accepts no arguments, and if so, it
     * calls the method and returns the result
     */
    public static Object callMethodIfExists(Object obj, String methodName) {
        try {
            // Get the method by name and parameter types
            Method method = obj.getClass().getDeclaredMethod(methodName);
            // Invoke the method
            return method.invoke(obj);
        } catch (NoSuchMethodException e) {
            //System.out.println("Method '" + methodName + "' not found.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param obj the object from which we want to call the method from
     * @param methodName the name of the method to be called
     * @param parameterTypes the types of each argument
     * @param args the arguments to be passed on to the method
     * @return the result of the call, if successfull
     * This function checks whether an object implements a specific method which accepts a number of arguments, and if
     * so, it calls the method and returns the result
     */
    public static Object callMethodIfExists(Object obj, String methodName, Class<?>[] parameterTypes,
                                            Object... args) {
        try {
            // Get the method by name and parameter types
            Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
            // Invoke the method
            return method.invoke(obj, args);
        } catch (NoSuchMethodException e) {
            // System.out.println("Method '" + methodName + "' not found.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param obj the object from which we want to call the method from
     * @param methodNames the names of the methods to be called
     * @param parameterTypes the types of each argument
     * @param args the arguments to be passed on to the method
     * @return the result of the chained calls, or null if one of the methods does not exist
     * This function calls a chain of methods, which may or may not receive any arguments
     */
    public static Object callMethodChain(Object obj, String[] methodNames, Class<?>[][] parameterTypes,
                                        Object[][] args) {
        Object currentObj = obj; // Start with the initial object
        try {
            for (int i = 0; i < methodNames.length; i++) {
                // Get the method
                Method method = currentObj.getClass().getMethod(methodNames[i], parameterTypes[i]);
                // Invoke the method and update the current object if the method returns something
                currentObj = method.invoke(currentObj, args[i]);
                if (currentObj == null) {
                    return null;
                }
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentObj;
    }
}