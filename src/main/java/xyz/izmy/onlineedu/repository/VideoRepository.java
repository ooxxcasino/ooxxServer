
package xyz.izmy.onlineedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.izmy.onlineedu.entity.Video;

public interface VideoRepository extends JpaRepository<Video,Long> {

    Boolean existsVideoById(Long id);

    Video findVideoById(Long id);
}