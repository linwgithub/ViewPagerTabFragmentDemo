package linw.viewpagertabfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import linw.viewpagertabfragmentdemo.base.BasePagerFragment;

/**
 * 作者: linw
 * 时间: 16/7/25
 * 内容:
 */
public class MainFragment extends BasePagerFragment implements View.OnTouchListener {

    public static final String ARG_PAGE = "ARG_PAGE";

    private ViewPager pager;

    public static MainFragment newInstance(int pager) {
        MainFragment fragment = new MainFragment();
        Bundle arg = new Bundle();
        arg.putInt(ARG_PAGE, pager);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void fetchData() {
        // TODO:  show data for user
        Log.e("baseFragment", "BaseFragment fetchData");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return pager.dispatchTouchEvent(motionEvent);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null, false);
        pager = (ViewPager) view.findViewById(R.id.view_pager);
        pager.setAdapter(new MyPagerAdapter());
        pager.setOffscreenPageLimit(5);
        pager.setPageMargin(-20);
        pager.setCurrentItem(0);

        return view;
    }

    class MyPagerAdapter extends PagerAdapter {

        Map<Integer, View> viewMap = new HashMap<>();

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.view_time_axis, null, false);
            TextView tv = (TextView) view.findViewById(R.id.tv_center);
            tv.setText("NO." + position);
            container.addView(view);
            viewMap.put(position, view);
            return view;
//            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (viewMap.get(position) != null) {
                container.removeView(viewMap.get(position));
                viewMap.remove(position);
            }
//            super.destroyItem(container, position, object);
        }
    }
}
