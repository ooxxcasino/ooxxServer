package xyz.izmy.onlineedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.izmy.onlineedu.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * 用户操作
 * @author iYmz
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    <S extends User> S save(S entity);

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long aLong);

    User findUserById(Long id);
}
