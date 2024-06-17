package JJEP.Gui.GuiForm.Repository;

import JJEP.Gui.GuiForm.Model.Scenario;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ScenarioRepository extends MongoRepository<Scenario, String> {
}
