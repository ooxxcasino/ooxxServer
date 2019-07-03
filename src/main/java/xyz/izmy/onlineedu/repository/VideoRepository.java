package xyz.izmy.onlineedu.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.izmy.onlineedu.entity.Video;

import java.util.List;

/**
 *
 * @author SEEDzy
 *
 */


public interface VideoRepository extends CrudRepository<Video,Long> {

    @Override
    List<Video> findAll();
    List<Video> findVideoByInfoLike(String info);


}
