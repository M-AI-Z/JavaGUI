package JJEP.Gui.GuiForm.Controller;

import JJEP.Gui.GuiForm.Model.Questionnaire;
import JJEP.Gui.GuiForm.Repository.QuestionnaireRepository;
import JJEP.Gui.GuiForm.Service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/{scenarioType}")
    public ResponseEntity<List<Questionnaire>> getQuestionnaire(@PathVariable String scenarioType) {
        return ResponseEntity.ok(questionnaireService.getQuestionnaireByScenario(scenarioType));
    }
}
