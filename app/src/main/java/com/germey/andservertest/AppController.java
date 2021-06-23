package com.germey.andservertest;


import com.goldze.mvvmhabit.utils.NativeUtils;
import com.yanzhenjie.andserver.annotation.Controller;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.framework.body.JsonBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class AppController {
    @GetMapping("/encrypt")
    public void encrypt(HttpRequest request, HttpResponse response) {
        String plaintext = request.getQuery("plaintext");
        int offset = Integer.parseInt(Objects.requireNonNull(request.getQuery("offset")));
        Map<String, String> sign_map = new HashMap<>();
        String sign = NativeUtils.encrypt(plaintext, offset);
        sign_map.put("sign", sign);
        JSONObject jsonObject = new JSONObject(sign_map);
        response.setBody(new JsonBody(jsonObject));
    }
}