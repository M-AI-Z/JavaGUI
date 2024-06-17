package JJEP.Gui.GuiForm.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Scenarios")
public class Scenario {
    @Id
    private String  id;
    private String familyStatus;
    private List<ScenarioDetail> scenarios;
    private Date createdAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScenarioDetail {
        private String tittle;
        private String description;
    }
}
