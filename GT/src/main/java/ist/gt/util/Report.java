package ist.gt.util;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Report {
    private String unknownMethodWarning;
    private final Set<Vulnerability> vulnerabilities = new HashSet<>();
    private long timeToProcessMilliseconds;
}
