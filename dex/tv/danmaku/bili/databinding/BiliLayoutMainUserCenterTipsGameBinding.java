package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterTipsGameBinding implements ViewBinding {
    public final BiliImageView ivTips;
    private final LinearLayout rootView;
    public final TintTextView tvTips;

    private BiliLayoutMainUserCenterTipsGameBinding(LinearLayout rootView, BiliImageView ivTips, TintTextView tvTips) {
        this.rootView = rootView;
        this.ivTips = ivTips;
        this.tvTips = tvTips;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterTipsGameBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterTipsGameBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_tips_game, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterTipsGameBinding bind(View rootView) {
        TintTextView tvTips;
        int id = R.id.iv_tips;
        BiliImageView ivTips = ViewBindings.findChildViewById(rootView, id);
        if (ivTips != null && (tvTips = ViewBindings.findChildViewById(rootView, (id = R.id.tv_tips))) != null) {
            return new BiliLayoutMainUserCenterTipsGameBinding((LinearLayout) rootView, ivTips, tvTips);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}