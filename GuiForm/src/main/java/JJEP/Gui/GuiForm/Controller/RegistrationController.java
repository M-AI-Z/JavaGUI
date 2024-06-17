package JJEP.Gui.GuiForm.Controller;

import JJEP.Gui.GuiForm.Model.UserProfile;
import JJEP.Gui.GuiForm.Repository.UserProfileRepository;
import JJEP.Gui.GuiForm.Model.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/reg-users")
public class RegistrationController {

    private final UserProfileRepository userProfileRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public RegistrationController(UserProfileRepository userProfileRepository,
                                  BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userProfileRepository = userProfileRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/create")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserProfile user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            UserProfile savedUser = userProfileRepository.save(user);
            // Return a DTO or a response object that doesn't include sensitive data
            UserResponseDto response = new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle and log the exception, and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }
}
