package JJEP.Gui.GuiForm.Service;

import JJEP.Gui.GuiForm.Model.Questionnaire;
import JJEP.Gui.GuiForm.Repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> getQuestionnaireByScenario(String scenarioType) {
        return questionnaireRepository.findByScenarioType(scenarioType);
    }
}
