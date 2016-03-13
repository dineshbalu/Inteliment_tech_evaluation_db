package db.apps.android.intelimenttechevaluation.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import db.apps.android.intelimenttechevaluation.fragment.IPageFragment;

/**
 * Created by dineshbalu on 13/03/16.
 */
public class IPageAdapter extends FragmentPagerAdapter
{

    String[] titles = new String[]{ "Fragment 1" , "Fragment 2" , "Fragment 3" , "Fragment 4" };
    int[] colors = new int[]{ android.R.color.holo_blue_light ,android.R.color.holo_green_light ,android.R.color.holo_orange_light ,android.R.color.holo_red_light };


    public IPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        IPageFragment fragment = new IPageFragment();
        Bundle b = new Bundle();
        b.putString( IPageFragment.TITLE , titles[position] );
        b.putInt( IPageFragment.COLOR , colors[position] );
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

}