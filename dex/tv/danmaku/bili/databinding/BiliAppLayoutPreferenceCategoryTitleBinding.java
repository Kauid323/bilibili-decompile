package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutPreferenceCategoryTitleBinding implements ViewBinding {
    private final TintTextView rootView;
    public final TintTextView title;

    private BiliAppLayoutPreferenceCategoryTitleBinding(TintTextView rootView, TintTextView title) {
        this.rootView = rootView;
        this.title = title;
    }

    public TintTextView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutPreferenceCategoryTitleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutPreferenceCategoryTitleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_preference_category_title, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutPreferenceCategoryTitleBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TintTextView title = (TintTextView) rootView;
        return new BiliAppLayoutPreferenceCategoryTitleBinding((TintTextView) rootView, title);
    }
}