package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliAppDialogAnswerItemIconBinding implements ViewBinding {
    public final BiliImageView iconImg;
    public final TextView iconText;
    private final LinearLayout rootView;

    private BiliAppDialogAnswerItemIconBinding(LinearLayout rootView, BiliImageView iconImg, TextView iconText) {
        this.rootView = rootView;
        this.iconImg = iconImg;
        this.iconText = iconText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogAnswerItemIconBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogAnswerItemIconBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_answer_item_icon, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogAnswerItemIconBinding bind(View rootView) {
        int id = R.id.icon_img;
        BiliImageView iconImg = ViewBindings.findChildViewById(rootView, id);
        if (iconImg != null) {
            id = R.id.icon_text;
            TextView iconText = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (iconText != null) {
                return new BiliAppDialogAnswerItemIconBinding((LinearLayout) rootView, iconImg, iconText);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}