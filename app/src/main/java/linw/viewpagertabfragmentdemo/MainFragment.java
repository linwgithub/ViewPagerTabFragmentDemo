package linw.viewpagertabfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者: linw
 * 时间: 16/7/25
 * 内容:
 */
public class MainFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null, false);
        return view;
    }

}
