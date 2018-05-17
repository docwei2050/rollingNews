package com.docwei.rollingnewdemo.fragment;


import com.docwei.rollingnewdemo.BaseFragement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tobo on 17/2/3.
 */

public class FragmentFactory {
    private static final int                         HOME_FRAGMENT     = 0;
    private static final int                         FAVORITE_FRAGMENT = 1;
    private static final int                         BOOK_FRAGMENT     = 2;
    private static final int                         MUSIC_FRAGMENT    = 3;
    private static final int                         TV_FRAGMENT       = 4;
    public static        Map<Integer, BaseFragement> fragements        = new HashMap<>();

    public static BaseFragement createFragment(int position) {
        if (fragements.containsKey(position)) {
            return fragements.get(position);
        }
        BaseFragement fragement = null;
        switch (position) {
            case HOME_FRAGMENT:
                fragement = new HomeFragment();
                break;
            case FAVORITE_FRAGMENT:
                fragement = new FavoriteFragment();
                break;
            case BOOK_FRAGMENT:
                fragement = new BookFragment();
                break;
            case MUSIC_FRAGMENT:
                fragement = new MusicFragment();
                break;
            case TV_FRAGMENT:
                fragement = new TvFragment();
                break;

        }
        fragements.put(position, fragement);
        return fragement;
    }
}
