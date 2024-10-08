package ist.gt.gastBuilder;

import lombok.Data;

@Data
public class LiteralOptions {

    private final boolean isNegativeNumber;
    private final boolean removeQuotes;

    public LiteralOptions(boolean isNegativeNumber, boolean removeQuotes) {
        this.isNegativeNumber = isNegativeNumber;
        this.removeQuotes = removeQuotes;
    }
}
