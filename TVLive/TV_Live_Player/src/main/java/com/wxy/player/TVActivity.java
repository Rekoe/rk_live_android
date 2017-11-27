package com.wxy.player;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.devlin_n.floatWindowPermission.FloatWindowManager;
import com.devlin_n.yinyangplayer.controller.StandardVideoController;
import com.devlin_n.yinyangplayer.player.YinYangPlayer;

import java.util.Map;

import static com.bumptech.glide.request.Request.*;

/**
 * Created by wang on 2017/6/22.
 */

public class TVActivity extends AppCompatActivity {

    protected YinYangPlayer yinYangPlayer;

    protected RequestQueue mRequestQueue = TVPlayerApplication.mRequestQueue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        yinYangPlayer = (YinYangPlayer) findViewById(R.id.player);

        String url = getIntent().getStringExtra("url");
        String name = getIntent().getStringExtra("name");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(name);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        StandardVideoController controller = new StandardVideoController(this);
        controller.setLive(true);
        //Glide.with(this).load("http://7xqblc.com1.z0.glb.clouddn.com/tvlive.jpg").asBitmap().animate(R.anim.anim_alpha_in).placeholder(android.R.color.black).into(controller.getThumb());
        //yinYangPlayer.autoRotate().useAndroidMediaPlayer().setUrl(url).setVideoController(controller);
        yinYangPlayer.autoRotate().setUrl(url).setVideoController(controller);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        yinYangPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        yinYangPlayer.resume();
        yinYangPlayer.stopFloatWindow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        yinYangPlayer.release();
    }

    @Override
    public void onBackPressed() {
        if (!yinYangPlayer.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FloatWindowManager.PERMISSION_REQUEST_CODE) {
            if (FloatWindowManager.getInstance().checkPermission(this)) {
                yinYangPlayer.startFloatWindow();
            } else {
                Toast.makeText(TVActivity.this, "权限授予失败，无法开启悬浮窗", Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected void HttpGet(String url, final Map<String, String> header, Response.Listener<String> listener, RequestQueue mRequestQueue) {
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url, listener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d(" request error ", "", volleyError);
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return header;
            }
        };
        mRequestQueue.add(stringRequest);
    }

    protected void HttpPost(String url, final Map<String, String> header, final Map<String, String> params, Response.Listener<String> listener, RequestQueue mRequestQueue) {
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, url, listener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d(" request error ", "", volleyError);
                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return header;
            }
        };
        mRequestQueue.add(stringRequest);
    }
}
