package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliIncludeWidgetUpCardGapBinding implements ViewBinding {
    private final FrameLayout rootView;

    private BiliIncludeWidgetUpCardGapBinding(FrameLayout rootView) {
        this.rootView = rootView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliIncludeWidgetUpCardGapBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliIncludeWidgetUpCardGapBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_include_widget_up_card_gap, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliIncludeWidgetUpCardGapBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliIncludeWidgetUpCardGapBinding((FrameLayout) rootView);
    }
}