package xyz.izmy.onlineedu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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


/*    @GetMapping(value = "/list")
    public Object getVideoList(){
        List<Video> video=videoRepository.findAll();
        return video;
    }*/

    @GetMapping(value = "/list")
    public Object getVideoList(){
        JSONObject jsonObject = new JSONObject();
        List<Video> video=videoRepository.findAll();
        int status = 1;
        try {
            if(video!=null) {
                jsonObject.put("code",status);
                jsonObject.put("info","查询成功");
                jsonObject.put("data",video);
            }
            else {
                status = 0;
                jsonObject.put("code",status);
                jsonObject.put("info","视频不存在");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }



//根据id查询视频信息
    @GetMapping(value = "/{id}")
    public Object getVideoById(@PathVariable("id") Long id){
        JSONObject jsonObject = new JSONObject();
        int status=1;
        try {
            if(videoRepository.existsVideoById(id)) {
                jsonObject.put("code",status);
                jsonObject.put("info","查询成功");
                jsonObject.put("data",videoRepository.findVideoById(id));
            }
            else {
                status = 0;
                jsonObject.put("code",status);
                jsonObject.put("info","视频不存在");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
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
