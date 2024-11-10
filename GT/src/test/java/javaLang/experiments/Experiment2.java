package javaLang.experiments;

public class Experiment2 {
    // TODO: there seems to be an issue where the taint analysis occurs twice, as the vulnerability on line 6 is report
    //  twice in the logs. It is only written once in the report since the set of vulnerabilities eliminates duplicates
    public void method(String id) {
        // executeQuery(id); // vuln
        // executeQuery(sanitize(id));

        int x = 2;

        for (int i = 0, j = 0; i < 10; i++) {
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
