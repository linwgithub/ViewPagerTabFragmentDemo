package linw.viewpagertabfragmentdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout mainTabLayout;
    CusTomViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        mainViewPager = (CusTomViewPager) findViewById(R.id.main_viewPager);
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(MainFragment.newInstance(1));
        fragments.add(MainFragment.newInstance(2));
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        mainViewPager.setAdapter(adapter);
        mainViewPager.setSlide(true);
        mainTabLayout.setupWithViewPager(mainViewPager);
        mainTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < mainTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mainTabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapter.getCusTabView(i));
            }
        }
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragments;
        public MyFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            if (fragments != null && fragments.size() >= position) {
                return fragments.get(position);
            } else {
                return null;
            }
        }

        @Override
        public int getCount() {
            return fragments != null ? fragments.size() : 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "第+" + position;
        }

        public View getCusTabView(int pagerIndex) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.view_tab, null, false);
            TextView tvTab = (TextView) view.findViewById(R.id.tv_tab);
            tvTab.setText("第" + pagerIndex + "标签");
            return view;
        }
    }

}
