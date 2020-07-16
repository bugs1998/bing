package com.bing.img.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bing.img.entity.User;
import com.bing.img.service.MusicDayService;
import com.bing.img.utils.HTTPUtils;
import com.bing.img.utils.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘建
 * @date 2020/6/1 12:53
 */
@Service
public class MusicDayServiceImpl implements MusicDayService {

    /**
     * 网易云日推
     *
     * @return 日推信息
     */
    @Override
    public Object toDaysMusic(User user) throws Exception {

        String alias = null;
        String artists = null;
        //状态码
        Integer codeStatus = 200;
        String url = "https://music.163.com/weapi/v2/discovery/recommend/songs";
        Map<String, String> head = new HashMap<String, String>();
        Map<String, String> body = new HashMap<String, String>();

        //请求参数
        head.put("Cookie", user.getCookieMusic());
        body.put("encSecKey", user.getEncSecKey());
        body.put("params", user.getParams());

        String msg = HTTPUtils.post(url, head, body);
        JSONObject jsonObject = JSONObject.parseObject(msg);
        int code = (int) jsonObject.get("code");

        //接口通信异常
        if (code != codeStatus) {
            return Result.errorMsg(code, "请检查Cookie");
        }

        //获取需要处理的数据
        JSONArray data = jsonObject.getJSONObject("data").getJSONArray("dailySongs");

        //获取歌曲信息
        for (int i = 0; i < data.size(); i++) {
            JSONObject array = data.getJSONObject(i);
            //获取推荐原因
            String reason = null;
            reason = array.get("reason").toString();

            //判断是否存在RR
            if (reason.contains("RR")) {
                reason = reason.substring(0, array.get("reason").toString().indexOf("RR"));
            }
            System.out.println(reason);

            System.out.println("歌曲：" + array.get("name") + "歌曲ID:" + array.get("id"));

            //获取原唱或出处
            JSONArray array1 = array.getJSONArray("alias");
            if (array1.size() != 0 || array1 != null) {
                for (int j = 0; j < array1.size(); j++) {
                    //判断作者人数
                    if (j > 0) {
                        alias = alias + "/" + (String) array1.get(j);
                    } else {
                        alias = (String) array1.get(j);
                    }
                }
            }
            if (alias != null) {
                System.out.println("原唱" + alias);
            }

            //获取演唱者
            JSONArray array2 = array.getJSONArray("artists");
            for (int j = 0; j < array2.size(); j++) {
                //判断演唱者人数
                if (j > 0) {
                    artists = artists + "/" + array2.getJSONObject(j).get("name");
                } else {
                    artists = (String) array2.getJSONObject(j).get("name");
                }
            }

            if (artists != null) {
                System.out.println("歌手" + artists);
            }

            artists = null;
            alias = null;
        }
        return data;
    }
}
