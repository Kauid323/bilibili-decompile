package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import tv.danmaku.bili.R;

public final class BiliAppDialogVipWithTextDoubleButtonBinding implements ViewBinding {
    public final ImageView close;
    public final StaticImageView2 image;
    private final FrameLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;

    private BiliAppDialogVipWithTextDoubleButtonBinding(FrameLayout rootView, ImageView close, StaticImageView2 image, TextView text1, TextView text2, TextView text3, TextView text4) {
        this.rootView = rootView;
        this.close = close;
        this.image = image;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogVipWithTextDoubleButtonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogVipWithTextDoubleButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_vip_with_text_double_button, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogVipWithTextDoubleButtonBinding bind(View rootView) {
        StaticImageView2 image;
        int id = R.id.close;
        ImageView close = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (close != null && (image = ViewBindings.findChildViewById(rootView, (id = R.id.image))) != null) {
            id = R.id.text1;
            TextView text1 = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (text1 != null) {
                id = R.id.text2;
                TextView text2 = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (text2 != null) {
                    id = R.id.text3;
                    TextView text3 = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (text3 != null) {
                        id = R.id.text4;
                        TextView text4 = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (text4 != null) {
                            return new BiliAppDialogVipWithTextDoubleButtonBinding((FrameLayout) rootView, close, image, text1, text2, text3, text4);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}