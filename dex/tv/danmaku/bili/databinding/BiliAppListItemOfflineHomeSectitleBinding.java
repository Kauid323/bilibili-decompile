package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppListItemOfflineHomeSectitleBinding implements ViewBinding {
    private final TintTextView rootView;

    private BiliAppListItemOfflineHomeSectitleBinding(TintTextView rootView) {
        this.rootView = rootView;
    }

    public TintTextView getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemOfflineHomeSectitleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemOfflineHomeSectitleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_offline_home_sectitle, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemOfflineHomeSectitleBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppListItemOfflineHomeSectitleBinding((TintTextView) rootView);
    }
}