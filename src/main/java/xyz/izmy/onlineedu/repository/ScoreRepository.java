package xyz.izmy.onlineedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.izmy.onlineedu.entity.score;

public interface ScoreRepository extends JpaRepository<score,Long>  {
    @Override
    <S extends xyz.izmy.onlineedu.entity.score> S save(S entity);
}
