package xyz.izmy.onlineedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.izmy.onlineedu.entity.UserScore;

public interface UserScoreRepository extends JpaRepository<UserScore,Long> {

    UserScore findUserScoreByUserAccount(String userAccount);
}
