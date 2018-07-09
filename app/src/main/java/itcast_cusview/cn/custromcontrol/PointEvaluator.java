package itcast_cusview.cn.custromcontrol;

import android.animation.TypeEvaluator;

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();
        return new Point((int) (fraction * end - start + start));
    }
}
