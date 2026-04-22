package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.homepage.widget.badge.MoleBadgeView;
import com.bilibili.lib.homepage.widget.badge.NumberBadgeView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterPortItemBinding implements ViewBinding {
    public final NumberBadgeView badge;
    public final MoleBadgeView badgeMole;
    public final BiliImageView icon;
    private final ConstraintLayout rootView;
    public final TintTextView title;

    private BiliLayoutMainUserCenterPortItemBinding(ConstraintLayout rootView, NumberBadgeView badge, MoleBadgeView badgeMole, BiliImageView icon, TintTextView title) {
        this.rootView = rootView;
        this.badge = badge;
        this.badgeMole = badgeMole;
        this.icon = icon;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterPortItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterPortItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_port_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterPortItemBinding bind(View rootView) {
        MoleBadgeView badgeMole;
        BiliImageView icon;
        TintTextView title;
        int id = R.id.badge;
        NumberBadgeView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null && (badgeMole = ViewBindings.findChildViewById(rootView, (id = R.id.badge_mole))) != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            return new BiliLayoutMainUserCenterPortItemBinding((ConstraintLayout) rootView, badge, badgeMole, icon, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}