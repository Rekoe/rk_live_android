package com.wxy.player;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.devlin_n.floatWindowPermission.FloatWindowManager;
import com.devlin_n.yinyangplayer.controller.StandardVideoController;
import com.devlin_n.yinyangplayer.player.YinYangPlayer;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


public class OneSportActivity extends TVActivity {

    private final static String TITLE_NAME = "OneSport";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        yinYangPlayer = (YinYangPlayer) findViewById(R.id.player);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(TITLE_NAME);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final StandardVideoController controller = new StandardVideoController(this);
        controller.setLive(true);

        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Basic QDA3NzEyMSM6QDA3NzEyMSM=");
        header.put("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4.4; SM-J110H Build/KTU84P)");
        HttpGet("http://163.172.89.201:8080/chick.nettv/", header, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String playStr = onSportSign(response);
                String url = "http://185.21.217.29:9100/delta/arabic/onsports/playlist.m3u8?wmsAuthSign=" + playStr;
                yinYangPlayer.autoRotate().setUrl(url).setVideoController(controller);
            }
        }, mRequestQueue);
    }

    public String onSportSign(String sign) {
        String wmsAuthSign = StringUtils.remove(sign, "?wmsAuthSign=");
        char[] chars = wmsAuthSign.toCharArray();
        int len = chars.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (i == len - 31 || i == len - 24 || i == len - 21 || i == len - 18) {
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}
