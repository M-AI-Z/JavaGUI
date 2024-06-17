package JJEP.Gui.GuiForm.Repository;

import JJEP.Gui.GuiForm.Model.Questionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String > {
    List<Questionnaire> findByScenarioType(String scenarioType);
}
