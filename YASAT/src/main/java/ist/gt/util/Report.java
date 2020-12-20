package ist.yasat.util;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Report {
    private final Set<Vulnerability> vulnerabilities = new HashSet<>();
    private long timeToProcessMilliseconds;
}
