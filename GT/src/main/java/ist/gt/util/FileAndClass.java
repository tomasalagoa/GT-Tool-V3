package ist.gt.util;


import ist.gt.model.Class;
import ist.gt.model.File;
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
