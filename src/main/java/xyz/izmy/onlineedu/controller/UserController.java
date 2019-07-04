package xyz.izmy.onlineedu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import xyz.izmy.onlineedu.entity.User;
import xyz.izmy.onlineedu.repository.UserRepository;
import xyz.izmy.onlineedu.service.impl.UserServiceImp;

/**
 * user controller
 * @author iYmz
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserServiceImp userServiceImp;

    public UserController(UserRepository userRepository, UserServiceImp userServiceImp) {
        this.userRepository = userRepository;
        this.userServiceImp = userServiceImp;
    }

    /**
     *
     * save user
     */


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object getUserById(@PathVariable("id") Long id){
        User user = userRepository.findById(id).orElse(null);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        return user;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object loginUser( @RequestBody JSONObject userJson)
    {

        JSONObject jsonObject = new JSONObject();
        JSONObject dataJsonObject = new JSONObject();
       User user = getUserAccountAndPwdFromJSONObject(userJson);

        try{
            int status =userServiceImp.login(user);
            jsonObject.put("code",status);
            if(status==1) //密码正确
                dataJsonObject.put("info","验证通过");
            else if(status == 0)//密码错误
                dataJsonObject.put("info","密码错误或不存在该用户");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        jsonObject.put("data",dataJsonObject);
        return JSON.toJSON(jsonObject);
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Object registUser( @RequestBody JSONObject userJson)
    {

        User user = getUserAccountAndPwdFromJSONObject(userJson);
       int code = userServiceImp.signUp(user);
       String info;
       if(code==1) info="注册成功";//注册成功
           else info="用户已存在";//用户已存在


        return JSON.toJSON(JSONWithCodeAndInfo(code,info));



       // return JSON.toJSON(json);
    }

    @RequestMapping(value = "/video",method = RequestMethod.POST)
    @ResponseBody
    public Object addUserVideo(@RequestBody JSONObject jsonObject)
    {
        String userAccount = jsonObject.get("userAccount").toString();
        Long videoId =jsonObject.getLong("videoId");
        int code = userServiceImp.addMyVideo(userAccount,videoId);
        String msg;
        if(code==1)msg="Success";
        else msg="failed";
        JSONObject json = JSONWithCodeAndInfo(code,msg);
        return json;
    }
    @RequestMapping(value = "")
    public User getUserAccountAndPwdFromJSONObject(JSONObject jsonObject)
    {
        JSONObject json=new JSONObject();
        User user = new User();
        String account = jsonObject.get("account").toString();
        String pwd =  jsonObject.get("pwd").toString();

        user.setAccount(account);
        user.setPwd(pwd);
        return user;
    }

    /**
     *
     * @param code
     * @param info
     * @return
     * {
     *     "code":code,
     *     "data":{
     *         "info":"msg"
     *     }
     * }
     */
    public JSONObject JSONWithCodeAndInfo(int code,String info){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonInfo = new JSONObject();
        jsonObject.put("code",code);
        jsonInfo.put("info",info);
        jsonObject.put("data",jsonInfo);
        return jsonObject;
    }
}
