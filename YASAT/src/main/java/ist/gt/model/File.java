package ist.yasat.model;

import ist.yasat.gastBuilder.AstBuilderVisitorInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class File extends Element {
    @NonNull
    private String name;
    private Path path;
    private HashMap<String, Class> classes = new HashMap<>();
    private Set<String> importedFiles = new HashSet<>();
    private HashMap<String, Function> functions = new HashMap<>();
    private Function rootFunc = new Function("ROOT");

    @Override
    public void accept(AstBuilderVisitorInterface visitor) {
        visitor.visit(this);
    }
}
