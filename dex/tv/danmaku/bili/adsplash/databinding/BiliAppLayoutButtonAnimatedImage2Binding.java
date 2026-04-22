package tv.danmaku.bili.adsplash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.adsplash.R;

public final class BiliAppLayoutButtonAnimatedImage2Binding implements ViewBinding {
    public final BiliImageView animatedImage;
    private final ConstraintLayout rootView;
    public final TintTextView subtitle;
    public final TintImageView textBackground;
    public final LinearLayout textContainer;
    public final TintTextView title;

    private BiliAppLayoutButtonAnimatedImage2Binding(ConstraintLayout rootView, BiliImageView animatedImage, TintTextView subtitle, TintImageView textBackground, LinearLayout textContainer, TintTextView title) {
        this.rootView = rootView;
        this.animatedImage = animatedImage;
        this.subtitle = subtitle;
        this.textBackground = textBackground;
        this.textContainer = textContainer;
        this.title = title;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutButtonAnimatedImage2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutButtonAnimatedImage2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_button_animated_image_2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutButtonAnimatedImage2Binding bind(View rootView) {
        TintTextView subtitle;
        TintImageView textBackground;
        TintTextView title;
        int id = R.id.animated_image;
        BiliImageView animatedImage = ViewBindings.findChildViewById(rootView, id);
        if (animatedImage != null && (subtitle = ViewBindings.findChildViewById(rootView, (id = R.id.subtitle))) != null && (textBackground = ViewBindings.findChildViewById(rootView, (id = R.id.text_background))) != null) {
            id = R.id.text_container;
            LinearLayout textContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (textContainer != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                return new BiliAppLayoutButtonAnimatedImage2Binding((ConstraintLayout) rootView, animatedImage, subtitle, textBackground, textContainer, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}