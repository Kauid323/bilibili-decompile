package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashCardItemBinding implements ViewBinding {
    public final TintLinearLayout brandContainer;
    public final BiliImageView brandImage;
    public final CardView cardOutline;
    private final TintLinearLayout rootView;
    public final ImageView selectBtn;
    public final TintFrameLayout selectClickArea;
    public final TintTextView title;

    private BiliAppListBrandSplashCardItemBinding(TintLinearLayout rootView, TintLinearLayout brandContainer, BiliImageView brandImage, CardView cardOutline, ImageView selectBtn, TintFrameLayout selectClickArea, TintTextView title) {
        this.rootView = rootView;
        this.brandContainer = brandContainer;
        this.brandImage = brandImage;
        this.cardOutline = cardOutline;
        this.selectBtn = selectBtn;
        this.selectClickArea = selectClickArea;
        this.title = title;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashCardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashCardItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_card_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashCardItemBinding bind(View rootView) {
        CardView cardOutline;
        TintFrameLayout selectClickArea;
        TintLinearLayout brandContainer = (TintLinearLayout) rootView;
        int id = R.id.brand_image;
        BiliImageView brandImage = ViewBindings.findChildViewById(rootView, id);
        if (brandImage != null && (cardOutline = ViewBindings.findChildViewById(rootView, (id = R.id.card_outline))) != null) {
            id = R.id.select_btn;
            ImageView selectBtn = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (selectBtn != null && (selectClickArea = ViewBindings.findChildViewById(rootView, (id = R.id.select_click_area))) != null) {
                int id2 = R.id.title;
                TintTextView title = ViewBindings.findChildViewById(rootView, id2);
                if (title == null) {
                    id = id2;
                } else {
                    return new BiliAppListBrandSplashCardItemBinding((TintLinearLayout) rootView, brandContainer, brandImage, cardOutline, selectBtn, selectClickArea, title);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}