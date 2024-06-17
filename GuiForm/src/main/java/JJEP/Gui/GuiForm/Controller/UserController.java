package JJEP.Gui.GuiForm.Controller;

import JJEP.Gui.GuiForm.Model.UserProfile;
import JJEP.Gui.GuiForm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    // Get a user profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String id) {
        Optional<UserProfile> userProfile = userService.getUserById(id);
        return userProfile
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all user profiles
    @GetMapping("/all")
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        List<UserProfile> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Update a user profile
    @PutMapping("/update/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable String id, @RequestBody UserProfile userProfile) {
        UserProfile updatedUserProfile = userService.updateUser(id, userProfile);
        return ResponseEntity.ok(updatedUserProfile);
    }

    // Delete a user profile
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }


}
