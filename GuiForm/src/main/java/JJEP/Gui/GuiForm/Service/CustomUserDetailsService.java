package JJEP.Gui.GuiForm.Service;

import JJEP.Gui.GuiForm.Model.UserProfile;
import JJEP.Gui.GuiForm.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public CustomUserDetailsService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = userProfileRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

}
