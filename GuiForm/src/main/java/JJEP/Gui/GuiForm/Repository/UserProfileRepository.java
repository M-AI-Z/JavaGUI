package JJEP.Gui.GuiForm.Repository;

import JJEP.Gui.GuiForm.Model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    UserProfile findByUsername(String Username);

}

