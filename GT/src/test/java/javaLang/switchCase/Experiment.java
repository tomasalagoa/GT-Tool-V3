package javaLang.switchCase;

public class Experiment {
    public void method(String id) {
        if (id == null) {
            // nothing
        }

        switch ("1") {
            case "0":
                executeQuery(id);
            case "1":
                executeQuery(id);
            case "2":
                executeQuery(sanitize(id));
                break;
            case "3":
                sanitize(id);
                break;
            default:
                break;
        }
    }

    public void executeQuery(String id) {}
    public String sanitize(String id) {
        return id;
    }
}
