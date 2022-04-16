package ethniconnect_backend.UserCredentials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserCredentialsRepository
        extends JpaRepository<UserCredentials, Long> {

    Optional<UserCredentials> findByLoginid(long login_id);
    Optional<UserCredentials> findByEmail(String email);
    public UserCredentials findByResetpasswordtoken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE UserCredentials a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);




}
