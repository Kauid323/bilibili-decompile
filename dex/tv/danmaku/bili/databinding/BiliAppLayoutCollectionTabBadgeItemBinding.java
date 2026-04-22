package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutCollectionTabBadgeItemBinding implements ViewBinding {
    public final TintView badge;
    private final ConstraintLayout rootView;
    public final TintTextView tabTitle;

    private BiliAppLayoutCollectionTabBadgeItemBinding(ConstraintLayout rootView, TintView badge, TintTextView tabTitle) {
        this.rootView = rootView;
        this.badge = badge;
        this.tabTitle = tabTitle;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutCollectionTabBadgeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutCollectionTabBadgeItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_collection_tab_badge_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutCollectionTabBadgeItemBinding bind(View rootView) {
        TintTextView tabTitle;
        int id = R.id.badge;
        TintView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null && (tabTitle = ViewBindings.findChildViewById(rootView, (id = R.id.tab_title))) != null) {
            return new BiliAppLayoutCollectionTabBadgeItemBinding((ConstraintLayout) rootView, badge, tabTitle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}