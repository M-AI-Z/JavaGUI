package JJEP.Gui.GuiForm.Controller;

import JJEP.Gui.GuiForm.Model.Scenario;
import JJEP.Gui.GuiForm.Service.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scenarios")
public class ScenarioController {

    private final ScenarioService scenarioService;

    @Autowired
    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    // Endpoint to get all scenarios, will be useful to show user all options
    @GetMapping
    public List<Scenario> getAllScenarios() {
        return scenarioService.getAllScenarios();
    }

    // Endpoint to get a scenario by family status
    @GetMapping("/status/{familyStatus}")
    public List<Scenario> getScenarioByFamilyStatus(@PathVariable String familyStatus) {
        return scenarioService.getScenariosByFamilyStatus(familyStatus);
    }
}
