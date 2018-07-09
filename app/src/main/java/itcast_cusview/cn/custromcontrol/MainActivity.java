package itcast_cusview.cn.custromcontrol;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView btn_txt;
    private MyPointView myPointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPointView = findViewById(R.id.myPointView);
        btn_txt = findViewById(R.id.btn_txt);
    }

    public void start(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char curChar = (char) animation.getAnimatedValue();
                btn_txt.setText(String.valueOf(curChar));
            }
        });
        valueAnimator.setRepeatCount(Animation.RESTART);
        valueAnimator.setDuration(10000);
        // 在动画开始的地方速率改变比较慢，然后开始加速
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.start();
        myPointView.doPointAnim();
    }

    public void end(View view) {
    }


}
