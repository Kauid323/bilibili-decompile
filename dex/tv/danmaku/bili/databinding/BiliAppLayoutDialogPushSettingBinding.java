package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutDialogPushSettingBinding implements ViewBinding {
    public final ConstraintLayout content;
    public final StaticImageView2 image;
    public final ImageView imageClose;
    private final FrameLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TintTextView text4;

    private BiliAppLayoutDialogPushSettingBinding(FrameLayout rootView, ConstraintLayout content, StaticImageView2 image, ImageView imageClose, TextView text1, TextView text2, TintTextView text4) {
        this.rootView = rootView;
        this.content = content;
        this.image = image;
        this.imageClose = imageClose;
        this.text1 = text1;
        this.text2 = text2;
        this.text4 = text4;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutDialogPushSettingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutDialogPushSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_dialog_push_setting, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutDialogPushSettingBinding bind(View rootView) {
        StaticImageView2 image;
        TintTextView text4;
        int id = R.id.content;
        ConstraintLayout content = ViewBindings.findChildViewById(rootView, id);
        if (content != null && (image = ViewBindings.findChildViewById(rootView, (id = R.id.image))) != null) {
            id = R.id.image_close;
            ImageView imageClose = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (imageClose != null) {
                id = R.id.text1;
                TextView text1 = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (text1 != null) {
                    id = R.id.text2;
                    TextView text2 = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (text2 != null && (text4 = ViewBindings.findChildViewById(rootView, (id = R.id.text4))) != null) {
                        return new BiliAppLayoutDialogPushSettingBinding((FrameLayout) rootView, content, image, imageClose, text1, text2, text4);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}