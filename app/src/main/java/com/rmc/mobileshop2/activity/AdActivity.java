package com.rmc.mobileshop2.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rmc.mobileshop2.R;
import com.rmc.mobileshop2.common.BaseActivity;
import com.rmc.mobileshop2.common.MobileShopApp;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;



public class AdActivity extends BaseActivity {
    private TextView tv_skip;
    private static  final String TAG="test_base";
    @Override
    public int getContentViewId() {
        return R.layout.activity_ad;
    }

    @Override
    protected void initView() {
        super.initView();

        tv_skip=(TextView)findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                skip();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        String url ="http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg";
        ImageLoader.getInstance().displayImage(url, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                MobileShopApp.handler.post(jumpTread);
                Log.d(TAG,imageUri+"failed");
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                MobileShopApp.handler.post(jumpTread);
                Log.d(TAG,imageUri+"failed"+"complied");
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                MobileShopApp.handler.post(jumpTread);
                Log.d(TAG,imageUri+"cancles");
            }
        });
    }
    private void skip(){
        Intent intent = new Intent(AdActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        c_count = COUNT;
        MobileShopApp.handler.removeCallbacks(jumpTread);
    }


    private final static int COUNT=5;
    private final static int DELATED=1000;
    private int c_count =COUNT;
    private static final String SKIP_TEXT="点击跳过%d";
    private Runnable jumpTread = new Runnable() {
        @Override
        public void run() {
            if (c_count<=0){
                skip();
            }else {
                tv_skip.setText(String.format(SKIP_TEXT,c_count));

                c_count--;
                MobileShopApp.handler.postDelayed(jumpTread,DELATED);
            }
        }
    };

}
