package linw.viewpagertabfragmentdemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者: linw
 * 时间: 16/7/22
 * 内容:
 */
public class CusTomViewPager extends ViewPager {

    private boolean isSlide = true;

    public CusTomViewPager(Context context) {
        super(context);
    }

    public CusTomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.isSlide && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.isSlide && super.onInterceptTouchEvent(ev);
    }

    public void setSlide(boolean isSlide) {
        this.isSlide = isSlide;
    }
}
