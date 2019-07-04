package xyz.izmy.onlineedu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/add")
    public Object videoAdd(/*@RequestParam("video_image_url") String video_image_url
            ,@RequestParam("video_info") String video_info,@RequestParam("video_name") String video_name
            ,@RequestParam("video_price") int video_price,@RequestParam("video_type") String video_type
            ,@RequestParam("video_url") String video_url*/@RequestBody Video video){
        /*Video video=new Video();
        video.setName(video_name);
        video.setInfo(video_info);
        video.setImageUrl(video_image_url);
        video.setUrl(video_url);
        video.setType(video_type);
        video.setPrice(video_price);*/

        return videoRepository.save(video);
    }

}
