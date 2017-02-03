package com.liyunlong.zxing.qrcode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.liyunlong.zxing.encoding.EncodingHandler;

/**
 * @author liyunlong
 * @date 2017/1/19 18:28
 */
public class GeneratorActivity extends AppCompatActivity {

    private static final int CUSTOM_COLOR = 0xff37b19e;
    private static final String URL = "http://blog.csdn.net/u014651216";

    ImageView qrcode1;
    ImageView qrcode2;
    ImageView qrcode3;
    ImageView qrcode4;
    ImageView qrcode5;
    ImageView qrcode6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("花式二维码");
        setSupportActionBar(toolbar);

        qrcode1 = (ImageView) findViewById(R.id.qrcode1);
        qrcode2 = (ImageView) findViewById(R.id.qrcode2);
        qrcode3 = (ImageView) findViewById(R.id.qrcode3);
        qrcode4 = (ImageView) findViewById(R.id.qrcode4);
        qrcode5 = (ImageView) findViewById(R.id.qrcode5);
        qrcode6 = (ImageView) findViewById(R.id.qrcode6);

        Bitmap bitmap = drawableToBitmap(getResources().getDrawable(R.mipmap.ic_launcher));
        qrcode1.setImageBitmap(EncodingHandler.createQRCode(URL));
        qrcode2.setImageBitmap(EncodingHandler.createQRCode(URL, CUSTOM_COLOR));
        qrcode3.setImageBitmap(EncodingHandler.createQRCodeWithLogo(URL, bitmap));
        qrcode4.setImageBitmap(EncodingHandler.createQRCodeWithLogo(URL, bitmap, CUSTOM_COLOR));
        qrcode5.setImageBitmap(EncodingHandler.createQRCodeWithLogo2(URL, bitmap));
        qrcode6.setImageBitmap(EncodingHandler.createQRCodeWithBackground(URL, bitmap));
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
