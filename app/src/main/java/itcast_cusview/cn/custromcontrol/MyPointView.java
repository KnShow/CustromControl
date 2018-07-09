package itcast_cusview.cn.custromcontrol;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;

public class MyPointView extends View {
    private Point mCurPoint;
    private Paint mPaint;
    private int mWidth;
    private int mHeight;

    public MyPointView(Context context) {
        this(context, null);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//去除锯齿
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurPoint != null)
            canvas.drawCircle(mWidth / 2, mHeight / 2, mCurPoint.getRadius(), mPaint);
    }

    public void doPointAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), new Point(20), new Point(300));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(Animation.RESTART);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }


}
