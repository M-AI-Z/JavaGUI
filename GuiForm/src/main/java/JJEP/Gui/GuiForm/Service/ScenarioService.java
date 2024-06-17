package JJEP.Gui.GuiForm.Service;

import JJEP.Gui.GuiForm.Model.Scenario;
import JJEP.Gui.GuiForm.Repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScenarioService {

    private final ScenarioRepository scenarioRepository;

    @Autowired
    public ScenarioService(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    // Method to get all scenarios
    public List<Scenario> getAllScenarios() {
        return scenarioRepository.findAll();
    }

    // Method to get scenarios by family status
    public List<Scenario> getScenariosByFamilyStatus(String familyStatus) {
        return scenarioRepository.findAll().stream()
                .filter(scenario -> scenario.getFamilyStatus().equalsIgnoreCase(familyStatus))
                .collect(Collectors.toList());
    }
}
