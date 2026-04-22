package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashCardItemSmallBinding implements ViewBinding {
    public final TextView badge;
    public final FrameLayout brandContainer;
    public final BiliImageView brandImage;
    public final CardView cardOutline;
    private final FrameLayout rootView;
    public final ImageView selectBtn;
    public final TextView title;

    private BiliAppListBrandSplashCardItemSmallBinding(FrameLayout rootView, TextView badge, FrameLayout brandContainer, BiliImageView brandImage, CardView cardOutline, ImageView selectBtn, TextView title) {
        this.rootView = rootView;
        this.badge = badge;
        this.brandContainer = brandContainer;
        this.brandImage = brandImage;
        this.cardOutline = cardOutline;
        this.selectBtn = selectBtn;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashCardItemSmallBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashCardItemSmallBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_card_item_small, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashCardItemSmallBinding bind(View rootView) {
        CardView cardOutline;
        int id = R.id.badge;
        TextView badge = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (badge != null) {
            FrameLayout brandContainer = (FrameLayout) rootView;
            id = R.id.brand_image;
            BiliImageView brandImage = ViewBindings.findChildViewById(rootView, id);
            if (brandImage != null && (cardOutline = ViewBindings.findChildViewById(rootView, (id = R.id.card_outline))) != null) {
                id = R.id.select_btn;
                ImageView selectBtn = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (selectBtn != null) {
                    id = R.id.title;
                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (title != null) {
                        return new BiliAppListBrandSplashCardItemSmallBinding((FrameLayout) rootView, badge, brandContainer, brandImage, cardOutline, selectBtn, title);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}