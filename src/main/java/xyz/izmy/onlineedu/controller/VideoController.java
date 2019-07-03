package xyz.izmy.onlineedu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.izmy.onlineedu.entity.Video;
import xyz.izmy.onlineedu.repository.VideoRepository;

import java.util.List;

/**
 *
 * @author SEEDzy
 *
 */

@RestController
@RequestMapping(value = "/video")

public class VideoController {
    @Autowired
    private VideoRepository videoRepository;


    @GetMapping(value = "/list")
    public Object getVideoList(){
        List<Video> video=videoRepository.findAll();
        return video;
    }

    @GetMapping(value = "/{id}")
    public Object getVideoById(@PathVariable("id") Long id){
       return videoRepository.findById(id);
    }

}
