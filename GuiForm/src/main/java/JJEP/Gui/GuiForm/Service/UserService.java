package JJEP.Gui.GuiForm.Service;

import JJEP.Gui.GuiForm.Model.UserProfile;
import JJEP.Gui.GuiForm.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserProfileRepository userProfileRepository, PasswordEncoder passwordEncoder) {
        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserProfile createUser(UserProfile user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userProfileRepository.save(user);
    }

    public Optional<UserProfile> getUserById(String id) {
        return userProfileRepository.findById(id);
    }

    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    public UserProfile updateUser(String id, UserProfile updatedUser) {
        return userProfileRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    user.setFamilyStatus(updatedUser.getFamilyStatus());
                    user.setAge(updatedUser.getAge());
                    user.setFinancialSituation(updatedUser.getFinancialSituation());
                    return userProfileRepository.save(user);
                })
                .orElseGet(() -> {
                    updatedUser.setId(id);
                    return userProfileRepository.save(updatedUser);
                });
    }

    public void deleteUser(String id) {
        userProfileRepository.deleteById(id);
    }

}

