package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.widgets.MineBannedItemView;

public final class BiliLayoutMainUserCenterSilenceBinding implements ViewBinding {
    public final MineBannedItemView mineBannedEntry;
    private final MineBannedItemView rootView;

    private BiliLayoutMainUserCenterSilenceBinding(MineBannedItemView rootView, MineBannedItemView mineBannedEntry) {
        this.rootView = rootView;
        this.mineBannedEntry = mineBannedEntry;
    }

    public MineBannedItemView getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterSilenceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterSilenceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_silence, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterSilenceBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        MineBannedItemView mineBannedEntry = (MineBannedItemView) rootView;
        return new BiliLayoutMainUserCenterSilenceBinding((MineBannedItemView) rootView, mineBannedEntry);
    }
}