package ist.yasat.util;


import ist.yasat.model.Class;
import ist.yasat.model.File;
import lombok.Data;

@Data
public class FileAndClass {
    private File file;
    private Class clazz;


    public FileAndClass(File file, Class clazz) {
        this.file = file;
        this.clazz = clazz;
    }
}
