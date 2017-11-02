package com.example.jiecaotest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends Activity {
    private JZVideoPlayerStandard jzVideoPlayerStandard;
    private Uri uri;
    private String  path="http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uri = Uri.parse(path);
        jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "饺子闭眼睛");
        //.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
        jzVideoPlayerStandard.thumbImageView.setImageURI(uri);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
