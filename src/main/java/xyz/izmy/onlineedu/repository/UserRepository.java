package xyz.izmy.onlineedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.izmy.onlineedu.entity.User;
/**
 * 用户操作
 * @author iYmz
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    <S extends User> S save(S entity);
}
