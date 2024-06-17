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
@Document(collection = "Questionnaires")
public class Questionnaire {
    @Id
    private String id;
    private String userId;
    private String scenarioType;
    private List<Question> question;
    private Boolean completed;
    private Date createdAt;
    private Date completedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Question {
        private String questionText;
        private String responseType;
        private Object response;
    }
}
