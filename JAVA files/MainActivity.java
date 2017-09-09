package rkapoors.healthguide;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends FragmentActivity implements OnTabChangeListener, OnPageChangeListener {

    MyPageAdapter pageAdapter;
    private ViewPager mViewPager;
    private TabHost mTabHost;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        // Tab Initialization
        initialiseTabHost();

        // Fragments and ViewPager Initialization
        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(pageAdapter);
        mViewPager.setOnPageChangeListener(MainActivity.this);
    }
    // Method to add a TabHost
    private static void AddTab(MainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
        tabSpec.setContent(new MyTabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    // Manages the Tab changes, synchronizing it with Pages
    public void onTabChanged(String tag) {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    // Manages the Page changes, synchronizing it with Tabs
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        int pos = this.mViewPager.getCurrentItem();
        this.mTabHost.setCurrentTab(pos);
    }
    @Override
    public void onPageSelected(int arg0) {
    }

    private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<Fragment>();

        // TODO Put here your Fragments
        MySampleFragment f1 = new MySampleFragment();
        MySampleFragment1 f2 = new MySampleFragment1();
        MySampleFragment2 f3 = new MySampleFragment2();
        fList.add(f1);
        fList.add(f2);
        fList.add(f3);

        return fList;
    }
    // Tabs Creation
    private void initialiseTabHost() {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        // TODO Put here your Tabs
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("Schedule"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("Reminders"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("Records"));

        mTabHost.setOnTabChangedListener(this);
    }
}