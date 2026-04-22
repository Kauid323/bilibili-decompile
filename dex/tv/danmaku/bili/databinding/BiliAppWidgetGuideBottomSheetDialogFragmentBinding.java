package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.app.comm.list.widget.swiper.CircleIndicator;
import com.bilibili.app.comm.list.widget.swiper.SwiperBanner;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.TintView;
import tv.danmaku.bili.R;

public final class BiliAppWidgetGuideBottomSheetDialogFragmentBinding implements ViewBinding {
    public final SwiperBanner banner;
    public final CircleIndicator bannerIndicator;
    public final TintLinearLayout container;
    public final TintView indicator;
    public final TintFrameLayout indicatorContainer;
    public final TintButton negativeButton;
    private final TintLinearLayout rootView;
    public final TintTextView title;

    private BiliAppWidgetGuideBottomSheetDialogFragmentBinding(TintLinearLayout rootView, SwiperBanner banner, CircleIndicator bannerIndicator, TintLinearLayout container, TintView indicator, TintFrameLayout indicatorContainer, TintButton negativeButton, TintTextView title) {
        this.rootView = rootView;
        this.banner = banner;
        this.bannerIndicator = bannerIndicator;
        this.container = container;
        this.indicator = indicator;
        this.indicatorContainer = indicatorContainer;
        this.negativeButton = negativeButton;
        this.title = title;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppWidgetGuideBottomSheetDialogFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppWidgetGuideBottomSheetDialogFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_widget_guide_bottom_sheet_dialog_fragment, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppWidgetGuideBottomSheetDialogFragmentBinding bind(View rootView) {
        CircleIndicator bannerIndicator;
        TintFrameLayout indicatorContainer;
        TintButton negativeButton;
        TintTextView title;
        int id = R.id.banner;
        SwiperBanner banner = ViewBindings.findChildViewById(rootView, id);
        if (banner != null && (bannerIndicator = ViewBindings.findChildViewById(rootView, (id = R.id.banner_indicator))) != null) {
            TintLinearLayout container = (TintLinearLayout) rootView;
            id = R.id.indicator;
            TintView indicator = ViewBindings.findChildViewById(rootView, id);
            if (indicator != null && (indicatorContainer = ViewBindings.findChildViewById(rootView, (id = R.id.indicator_container))) != null && (negativeButton = ViewBindings.findChildViewById(rootView, (id = R.id.negative_button))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                return new BiliAppWidgetGuideBottomSheetDialogFragmentBinding((TintLinearLayout) rootView, banner, bannerIndicator, container, indicator, indicatorContainer, negativeButton, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}