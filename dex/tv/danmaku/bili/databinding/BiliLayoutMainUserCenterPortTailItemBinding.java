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
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.widget.EllipsisTailTextView;

public final class BiliLayoutMainUserCenterPortTailItemBinding implements ViewBinding {
    public final NumberBadgeView badge;
    public final MoleBadgeView badgeMole;
    public final BiliImageView icon;
    private final ConstraintLayout rootView;
    public final EllipsisTailTextView title;

    private BiliLayoutMainUserCenterPortTailItemBinding(ConstraintLayout rootView, NumberBadgeView badge, MoleBadgeView badgeMole, BiliImageView icon, EllipsisTailTextView title) {
        this.rootView = rootView;
        this.badge = badge;
        this.badgeMole = badgeMole;
        this.icon = icon;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterPortTailItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterPortTailItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_port_tail_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterPortTailItemBinding bind(View rootView) {
        MoleBadgeView badgeMole;
        BiliImageView icon;
        int id = R.id.badge;
        NumberBadgeView badge = ViewBindings.findChildViewById(rootView, id);
        if (badge != null && (badgeMole = ViewBindings.findChildViewById(rootView, (id = R.id.badge_mole))) != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null) {
            id = R.id.title;
            EllipsisTailTextView title = (EllipsisTailTextView) ViewBindings.findChildViewById(rootView, id);
            if (title != null) {
                return new BiliLayoutMainUserCenterPortTailItemBinding((ConstraintLayout) rootView, badge, badgeMole, icon, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}