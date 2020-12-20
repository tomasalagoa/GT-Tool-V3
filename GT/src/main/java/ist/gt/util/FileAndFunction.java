package ist.gt.util;

import ist.gt.model.File;
import ist.gt.model.Class;
import ist.gt.model.Function;
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
