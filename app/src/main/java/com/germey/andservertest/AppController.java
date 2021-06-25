package com.germey.andservertest;


import com.goldze.mvvmhabit.utils.NativeUtils;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.QueryParam;
import com.yanzhenjie.andserver.annotation.RestController;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @GetMapping("/encrypt")
    public JSONObject login(@QueryParam("plaintext") String plaintext,
                            @QueryParam("offset") int offset) {
        Map<String, String> map = new HashMap<>();
        String sign = NativeUtils.encrypt(plaintext, offset);
        map.put("sign", sign);
        return new JSONObject(map);
    }
}