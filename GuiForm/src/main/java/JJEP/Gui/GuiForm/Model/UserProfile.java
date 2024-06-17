package JJEP.Gui.GuiForm.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password"})
@Document(collection = "User Profiles")
public class UserProfile {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String age;
    private String familyStatus;
    private FinancialSituation financialSituation;
    private Date createdAt;
    private Date updatedAt;

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class  FinancialSituation {
        private Double income;
        private List<Asset> assets;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Asset {
            private String type;
            private Double value;
        }
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id + '\'' +
                ", username=" + username +'\'' +
                ", email=" + email +'\'' +
                ", age=" + age + '\'' +
                ", familyStatus=" + familyStatus + '\'' +
                ", financialSituation=" + financialSituation +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';

    }
}
