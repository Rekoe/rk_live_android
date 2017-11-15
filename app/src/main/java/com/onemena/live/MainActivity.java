package com.onemena.live;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.onemena.live.video.VideoBean;

public class MainActivity extends AppCompatActivity {

    public enum ChannlType {

        HD("标清HD"), Base("标准");

        public String des;

        ChannlType(String des) {
            this.des = des;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CCTV1(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("name", "CCTV1");
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://183.251.61.207/PLTV/88888888/224/3221225812/index.m3u8"));

        startActivity(intent);
    }

    public void CCTV2(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv2.m3u8"));
        intent.putExtra("name", "CCTV2");
        startActivity(intent);
    }

    public void CCTV3(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv3.m3u8"));
        intent.putExtra("name", "CCTV3");
        startActivity(intent);
    }

    public void CCTV4(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv4.m3u8"));
        intent.putExtra("name", "CCTV4");
        startActivity(intent);
    }

    public void CCTV5(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv5.m3u8"));
        intent.putExtra("name", "CCTV5");
        startActivity(intent);
    }

    public void CCTV6(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv6.m3u8"));
        intent.putExtra("name", "CCTV6");
        startActivity(intent);
    }

    public void CCTV7(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv7.m3u8"));
        intent.putExtra("name", "CCTV7");
        startActivity(intent);
    }

    public void CCTV8(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv8.m3u8"));
        intent.putExtra("name", "CCTV8");
        startActivity(intent);
    }

    public void CCTV9(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv9.m3u8"));
        intent.putExtra("name", "CCTV9");
        startActivity(intent);
    }

    public void CCTV10(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv10.m3u8"));
        intent.putExtra("name", "CCTV10");
        startActivity(intent);
    }

    public void CCTV11(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv11.m3u8"));
        intent.putExtra("name", "CCTV11");
        startActivity(intent);
    }

    public void CCTV12(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv12.m3u8"));
        intent.putExtra("name", "CCTV12直播");
        startActivity(intent);
    }

    public void CCTV13(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/cctv13.m3u8"));
        intent.putExtra("name", "CCTV13");
        startActivity(intent);
    }

    public void huNanTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/hunantv.m3u8"));
        intent.putExtra("name", "湖南卫视");
        startActivity(intent);
    }

    public void beiJingTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("name", "北京卫视");
        intent.putExtra("video", new VideoBean().addValue(ChannlType.Base.des, "http://ivi.bupt.edu.cn/hls/btv1.m3u8"));
        startActivity(intent);
    }

    public void shenZhenTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/sztv.m3u8"));
        intent.putExtra("name", "深圳卫视");
        startActivity(intent);
    }

    public void guangDongTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://ivi.bupt.edu.cn/hls/gdtv.m3u8"));
        intent.putExtra("name", "广东卫视");
        startActivity(intent);
    }

    public void nmpdTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://weblive.hebtv.com/live/nmpd_bq/index.m3u8"));
        intent.putExtra("name", "农民频道");
        startActivity(intent);
    }

    public void zsxjTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://zsxj.chinashadt.com:1935/zhibo/xjsh.stream_360p/playlist.m3u8"));
        intent.putExtra("name", "辛集生活");
        startActivity(intent);
    }

    public void dfwsTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://live-stream.kksmg.com/hls/dtv8edac050_a59211e7abc4cec278b6b50a/playlist.m3u8"));
        intent.putExtra("name", "东方卫视");
        startActivity(intent);
    }

    public void hbTV(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("video", new VideoBean().addValue(ChannlType.HD.des, "http://weblive.hebtv.com/live/hbws_bq/index.m3u8"));
        intent.putExtra("name", "河北卫视");
        startActivity(intent);
    }
}
