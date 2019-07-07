package xyz.izmy.onlineedu.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;
import xyz.izmy.onlineedu.entity.*;
import xyz.izmy.onlineedu.repository.*;

import java.util.ArrayList;
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
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserScoreRepository userScoreRepository;

/*    @GetMapping(value = "/list")
    public Object getVideoList(){
        List<Video> video=videoRepository.findAll();
        return video;
    }*/

//视频列表
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


    //返回评分
    @PostMapping(value = "/star")
    public Object videoScore(@RequestBody JSONObject jsonObject){
        int temporaryScore=0;
        int status = 1;
        score vScore = new score();
        JSONObject sJsonObject = new JSONObject();
        JSONObject s2JsonObject = new JSONObject();
        try{
            Video video = videoRepository.findVideoById(jsonObject.getLong("id"));
            List<UserScore> userScoreList = video.getVideoScores().getUserScoreList();
            temporaryScore=video.getVideoScores().getScore();
            //score=(score_now+score_get)/score_times

            //保存已评论用户账号
            if(userScoreRepository.findUserScoreByUserAccount(jsonObject.getString("userAccount"))==null||userScoreRepository.findUserScoreByUserAccount(jsonObject.getString("userAccount")).getVideoId()!=jsonObject.getLong("id")) {
                if(jsonObject.getIntValue("star")!=0) {
                    if(temporaryScore==0){
                        temporaryScore =jsonObject.getIntValue("star");
                    }
                    else{
                        temporaryScore = temporaryScore + jsonObject.getIntValue("star");
                        temporaryScore = temporaryScore / 2;
                    }
                    UserScore userScore = new UserScore();
                    userScore.setUserAccount(jsonObject.getString("userAccount"));
                    userScore.setVideoId(jsonObject.getLong("id"));
                    userScoreRepository.save(userScore);
                    userScoreList.add(userScore);

                    vScore.setId(video.getVideoScores().getId());
                    vScore.setScore(temporaryScore);
                    vScore.setUserScoreList(userScoreList);
                    vScore.setScoreTimes(video.getVideoScores().getScoreTimes()+1);
                    scoreRepository.save(vScore);

                    video.setVideoScores(vScore);
                    videoRepository.save(video);
                }
                if(temporaryScore==0){
                    temporaryScore =jsonObject.getIntValue("star");
                }
                status=0;
            }
            s2JsonObject.put("star",temporaryScore);
            sJsonObject.put("status",status);
            sJsonObject.put("data",s2JsonObject);
            return sJsonObject;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //添加视频评论
    @PostMapping(value = "/addComment")
    public Object addVideoComment(@RequestBody JSONObject jsonObject){
        Comment comment = new Comment();
        User user = new User();
        try{
            Video video = videoRepository.findVideoById(jsonObject.getLong("videoId"));
            List<Comment> commentList = video.getVideoComments();
            if(jsonObject.getString("userAccount")!=null)
            {
                user = userRepository.findUserByAccount(jsonObject.getString("userAccount"));
                comment.setUserName(user.getName());
            }
            else if(jsonObject.getString("toUserAccount")!=null){
                user = userRepository.findUserByAccount(jsonObject.getString("toUserAccount"));
                comment.setToUserName(user.getName());
                comment.setToCommentId(jsonObject.getLong("commentId"));
                comment.setUserName(commentRepository.findCommentById(jsonObject.getLong("commentId")).getUserName());
            }
            comment.setContent(jsonObject.getString("content"));
            comment.setDate(jsonObject.getDate("date"));
            comment.setUserId(user.getId());
            commentRepository.save(comment);
            commentList.add(comment);
            video.setVideoComments(commentList);
            videoRepository.save(video);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }




    //添加视频并初始化
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
