package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.badge.NumberBadgeView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterLandItemBinding implements ViewBinding {
    public final ImageView arrow;
    public final NumberBadgeView badge;
    public final BiliImageView icon;
    public final BiliImageView mngIcon;
    private final ConstraintLayout rootView;
    public final TintTextView title;

    private BiliLayoutMainUserCenterLandItemBinding(ConstraintLayout rootView, ImageView arrow, NumberBadgeView badge, BiliImageView icon, BiliImageView mngIcon, TintTextView title) {
        this.rootView = rootView;
        this.arrow = arrow;
        this.badge = badge;
        this.icon = icon;
        this.mngIcon = mngIcon;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterLandItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterLandItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_land_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterLandItemBinding bind(View rootView) {
        NumberBadgeView badge;
        BiliImageView icon;
        BiliImageView mngIcon;
        TintTextView title;
        int id = R.id.arrow;
        ImageView arrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (arrow != null && (badge = ViewBindings.findChildViewById(rootView, (id = R.id.badge))) != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null && (mngIcon = ViewBindings.findChildViewById(rootView, (id = R.id.mng_icon))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliLayoutMainUserCenterLandItemBinding((ConstraintLayout) rootView, arrow, badge, icon, mngIcon, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}