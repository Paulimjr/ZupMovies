package movies.zup.com.br.zupmovies.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import butterknife.ButterKnife;
import movies.zup.com.br.zupmovies.R;
import movies.zup.com.br.zupmovies.utils.NumberUtils;

public class Splash extends Activity {

    private Class<?> activityClass;
    private Class[] paramTypes = { Integer.TYPE, Integer.TYPE };
    private Method overrideAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(Splash.this);

        try {
            activityClass = Class.forName("android.app.Activity");
            overrideAnimation = activityClass.getDeclaredMethod(
                    "overridePendingTransition", paramTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this,
                        Main.class);
                startActivity(i);
                finish();

                if (overrideAnimation != null) {
                    try {
                        overrideAnimation.invoke(movies.zup.com.br.zupmovies.ui.Splash.this, android.R.anim.fade_in,
                                android.R.anim.slide_out_right);
                    } catch (IllegalArgumentException e) {
                        Log.v("IllegalArgumentExp: ", e.getMessage());
                    } catch (IllegalAccessException e) {
                        Log.v("IllegalAccessExp: ", e.getMessage());
                    } catch (InvocationTargetException e) {
                        Log.v("InvocationTargetExp: ", e.getMessage());
                    }
                }
            }
        }, NumberUtils.SPLASH_DURATION);
    }
}
