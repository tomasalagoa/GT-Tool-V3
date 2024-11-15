package javaLang.switchCase;

public class Experiment {
    public void method(String id) {
        if (id == null) {
            // nothing
        }

        switch (id) {
            case "1":
                executeQuery(id);
                break;
            case "2":
                executeQuery(sanitize(id));
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
