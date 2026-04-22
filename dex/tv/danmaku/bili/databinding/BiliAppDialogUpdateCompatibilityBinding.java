package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppDialogUpdateCompatibilityBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final View space;
    public final TintTextView tvConfirm;
    public final TextView tvContent;
    public final TextView tvTitle;

    private BiliAppDialogUpdateCompatibilityBinding(LinearLayout rootView, View space, TintTextView tvConfirm, TextView tvContent, TextView tvTitle) {
        this.rootView = rootView;
        this.space = space;
        this.tvConfirm = tvConfirm;
        this.tvContent = tvContent;
        this.tvTitle = tvTitle;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogUpdateCompatibilityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogUpdateCompatibilityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_update_compatibility, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogUpdateCompatibilityBinding bind(View rootView) {
        TintTextView tvConfirm;
        int id = R.id.space;
        View space = ViewBindings.findChildViewById(rootView, id);
        if (space != null && (tvConfirm = ViewBindings.findChildViewById(rootView, (id = R.id.tv_confirm))) != null) {
            id = R.id.tv_content;
            TextView tvContent = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvContent != null) {
                id = R.id.tv_title;
                TextView tvTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tvTitle != null) {
                    return new BiliAppDialogUpdateCompatibilityBinding((LinearLayout) rootView, space, tvConfirm, tvContent, tvTitle);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}