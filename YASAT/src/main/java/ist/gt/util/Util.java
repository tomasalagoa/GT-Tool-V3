package ist.yasat.util;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

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
}


