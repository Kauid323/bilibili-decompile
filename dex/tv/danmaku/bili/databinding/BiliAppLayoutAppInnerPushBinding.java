package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintImageView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutAppInnerPushBinding implements ViewBinding {
    public final RelativeLayout bizRootView;
    public final ConstraintLayout contentView;
    public final TintImageView go;
    public final StaticImageView2 icon;
    public final Barrier iconBarrier;
    public final FrameLayout innerRootView;
    public final BiliImageView ivCover;
    public final ViewStub liveAvatarStub;
    public final TextView message;
    public final FrameLayout rootView;
    private final FrameLayout rootView_;
    public final TextView title;

    private BiliAppLayoutAppInnerPushBinding(FrameLayout rootView_, RelativeLayout bizRootView, ConstraintLayout contentView, TintImageView go, StaticImageView2 icon, Barrier iconBarrier, FrameLayout innerRootView, BiliImageView ivCover, ViewStub liveAvatarStub, TextView message, FrameLayout rootView, TextView title) {
        this.rootView_ = rootView_;
        this.bizRootView = bizRootView;
        this.contentView = contentView;
        this.go = go;
        this.icon = icon;
        this.iconBarrier = iconBarrier;
        this.innerRootView = innerRootView;
        this.ivCover = ivCover;
        this.liveAvatarStub = liveAvatarStub;
        this.message = message;
        this.rootView = rootView;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView_;
    }

    public static BiliAppLayoutAppInnerPushBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutAppInnerPushBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_app_inner_push, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutAppInnerPushBinding bind(View rootView) {
        ConstraintLayout contentView;
        TintImageView go;
        StaticImageView2 icon;
        Barrier iconBarrier;
        BiliImageView ivCover;
        int id = R.id.biz_root_view;
        RelativeLayout bizRootView = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
        if (bizRootView != null && (contentView = ViewBindings.findChildViewById(rootView, (id = R.id.content_view))) != null && (go = ViewBindings.findChildViewById(rootView, (id = R.id.go))) != null && (icon = ViewBindings.findChildViewById(rootView, (id = R.id.icon))) != null && (iconBarrier = ViewBindings.findChildViewById(rootView, (id = R.id.icon_barrier))) != null) {
            id = R.id.inner_root_view;
            FrameLayout innerRootView = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (innerRootView != null && (ivCover = ViewBindings.findChildViewById(rootView, (id = R.id.iv_cover))) != null) {
                id = R.id.live_avatar_stub;
                ViewStub liveAvatarStub = (ViewStub) ViewBindings.findChildViewById(rootView, id);
                if (liveAvatarStub != null) {
                    id = R.id.message;
                    TextView message = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (message != null) {
                        FrameLayout rootView_ = (FrameLayout) rootView;
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new BiliAppLayoutAppInnerPushBinding((FrameLayout) rootView, bizRootView, contentView, go, icon, iconBarrier, innerRootView, ivCover, liveAvatarStub, message, rootView_, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}