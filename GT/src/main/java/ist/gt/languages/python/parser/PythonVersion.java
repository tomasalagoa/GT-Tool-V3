package ist.gt.languages.python.parser;

import lombok.Getter;

@Getter
public enum PythonVersion {
    Autodetect(0),
    Python2(2),
    Python3(3);

    private final int value;

    PythonVersion(int value) {
        this.value = value;
    }

}
