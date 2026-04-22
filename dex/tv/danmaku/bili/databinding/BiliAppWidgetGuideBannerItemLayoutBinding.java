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

public final class BiliAppWidgetGuideBannerItemLayoutBinding implements ViewBinding {
    public final TintTextView describe;
    public final BiliImageView ivBanner;
    private final LinearLayout rootView;

    private BiliAppWidgetGuideBannerItemLayoutBinding(LinearLayout rootView, TintTextView describe, BiliImageView ivBanner) {
        this.rootView = rootView;
        this.describe = describe;
        this.ivBanner = ivBanner;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppWidgetGuideBannerItemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppWidgetGuideBannerItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_widget_guide_banner_item_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppWidgetGuideBannerItemLayoutBinding bind(View rootView) {
        BiliImageView ivBanner;
        int id = R.id.describe;
        TintTextView describe = ViewBindings.findChildViewById(rootView, id);
        if (describe != null && (ivBanner = ViewBindings.findChildViewById(rootView, (id = R.id.iv_banner))) != null) {
            return new BiliAppWidgetGuideBannerItemLayoutBinding((LinearLayout) rootView, describe, ivBanner);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}