package ist.yasat.util;

import ist.yasat.model.File;
import ist.yasat.model.Class;
import ist.yasat.model.Function;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileAndFunction {
    private File file;
    private Function function;
    private Class clazz;

    public FileAndFunction(File file, Function function) {
        this.file = file;
        this.function = function;
    }


}
