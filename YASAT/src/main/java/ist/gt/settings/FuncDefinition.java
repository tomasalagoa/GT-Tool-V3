package ist.gt.settings;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class FuncDefinition {
    @NonNull
    private String name;
    private String type;
}
