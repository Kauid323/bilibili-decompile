package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppItemMenuCommonBottomSheetBinding implements ViewBinding {
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final TextView tvText;

    private BiliAppItemMenuCommonBottomSheetBinding(ConstraintLayout rootView, ImageView ivIcon, TextView tvText) {
        this.rootView = rootView;
        this.ivIcon = ivIcon;
        this.tvText = tvText;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppItemMenuCommonBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppItemMenuCommonBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_item_menu_common_bottom_sheet, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppItemMenuCommonBottomSheetBinding bind(View rootView) {
        int id = R.id.iv_icon;
        ImageView ivIcon = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (ivIcon != null) {
            id = R.id.tv_text;
            TextView tvText = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvText != null) {
                return new BiliAppItemMenuCommonBottomSheetBinding((ConstraintLayout) rootView, ivIcon, tvText);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}