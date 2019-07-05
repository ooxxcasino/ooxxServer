package xyz.izmy.onlineedu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import xyz.izmy.onlineedu.entity.Video;
import xyz.izmy.onlineedu.entity.score;
import xyz.izmy.onlineedu.repository.ScoreRepository;
import xyz.izmy.onlineedu.repository.VideoRepository;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private ScoreRepository scoreRepository;


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

    @PostMapping(value = "/star")
    public Object videoScore(@RequestBody JSONObject jsonObject){
        int temporaryScore=0;
        int times;
        JSONObject sJsonObject = new JSONObject();
        JSONObject s2JsonObject = new JSONObject();
        try{
            Video video = videoRepository.findVideoById(jsonObject.getLong("id"));
            temporaryScore=(video.getVideoScores().getScore()+jsonObject.getIntValue("star"));
            score vScore = new score();
            //video.getVideoScores();
            //score=(score_now+score_get)/score_times
            temporaryScore=temporaryScore/2;
            vScore.setId(video.getVideoScores().getId());
            vScore.setScore(temporaryScore);
            vScore.setScoreTimes(video.getVideoScores().getScoreTimes()+1);
            scoreRepository.save(vScore);
            video.setVideoScores(vScore);
            videoRepository.save(video);
            s2JsonObject.put("star",temporaryScore);
            sJsonObject.put("data",s2JsonObject);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sJsonObject;
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
        score vScore = new score();
        vScore.setScore(0);
        vScore.setScoreTimes(0);
        scoreRepository.save(vScore);
        video.setVideoScores(vScore);
        videoRepository.save(video);
        return true;
    }



}
