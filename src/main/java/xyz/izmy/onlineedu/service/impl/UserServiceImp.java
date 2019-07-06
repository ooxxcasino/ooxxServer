package xyz.izmy.onlineedu.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import xyz.izmy.onlineedu.entity.User;
import xyz.izmy.onlineedu.entity.Video;
import xyz.izmy.onlineedu.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import xyz.izmy.onlineedu.repository.VideoRepository;

import java.util.List;

/**
 * @author iYmz
 */
@Service
public class UserServiceImp {
    private final UserRepository userRepository;
    private final VideoRepository videoRepository;

    public UserServiceImp(UserRepository userRepository, VideoRepository videoRepository) {
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
    }


    /**
     * 用户注册
     * @return 注册成功，返回true
     */

    public int login(User user) throws ServiceException{
        if(userRepository.existsUserByAccount(user.getAccount())){
            User userData=userRepository.findUserByAccount(user.getAccount());
            if(userData.getPwd().equals(user.getPwd())){
                //密码正确
                return 1;
            }else return 0;//密码错误不存在该用户

        }
        return 0;//密码错误不存在该用户
    }

    public int signUp(User user) throws ServiceException{
        if(!userRepository.existsUserByAccount(user.getAccount()))
        {
            System.out.println("注册密码是："+user.getPwd());
            try{
                userRepository.save(user);
                return 1;//注册成功
            }catch (Exception e){
                e.printStackTrace();
            //    return 2;//注册失败，出现未知错误
            }
        }
            return 0;//用户已存在
    }

    public int addMyVideo(String userAccount,Long videoId) throws ServiceException {

        if(!userRepository.existsUserByAccount(userAccount)|| !videoRepository.existsVideoById(videoId))
            return 0;//用户或者视频不存在
        User user = userRepository.findUserByAccount(userAccount);
        Video video = videoRepository.findById(videoId).orElse(null);
        List<Video> videoList = user.getMyVideos();
        videoList.add(video);
        user.setMyVideos(videoList);
        try {
            userRepository.save(user);
            return 1; //我的视频保存成功
        } catch (Exception e){
            e.printStackTrace();
           // return 0; //我的视频保存失败
        }
        return 0;//我的视频保存失败
    }

    public Object getMyVideo()
    {
        return null;
    }

}
