package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutCollectionTabItemBinding implements ViewBinding {
    public final View divider;
    private final FrameLayout rootView;
    public final TintTextView tabTitle;

    private BiliAppLayoutCollectionTabItemBinding(FrameLayout rootView, View divider, TintTextView tabTitle) {
        this.rootView = rootView;
        this.divider = divider;
        this.tabTitle = tabTitle;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutCollectionTabItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutCollectionTabItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_collection_tab_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutCollectionTabItemBinding bind(View rootView) {
        TintTextView tabTitle;
        int id = R.id.divider;
        View divider = ViewBindings.findChildViewById(rootView, id);
        if (divider != null && (tabTitle = ViewBindings.findChildViewById(rootView, (id = R.id.tab_title))) != null) {
            return new BiliAppLayoutCollectionTabItemBinding((FrameLayout) rootView, divider, tabTitle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}