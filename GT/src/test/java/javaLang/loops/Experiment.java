package javaLang.loops;

public class Experiment {
    // TODO: there seems to be an issue where the taint analysis occurs twice, as the vulnerability on line 6 is report
    //  twice in the logs. It is only written once in the report since the set of vulnerabilities eliminates duplicates
    public void method(String id) {
        // executeQuery(id); // vuln
        // executeQuery(sanitize(id));

        int x = 2;
        int i = 0;
        int j = 0;
        j += 3;

        for (j = 0, x += 3; i < 10; i++) {
            if (i == -1) {
                executeQuery(id); // safe
            }

            if (i % 2 == 0) {
                executeQuery(id); // vuln
            }
        }

        // Should report two vulns
    }

    public void executeQuery(String id) {}
    public String sanitize(String id) {
        return id;
    }
}
