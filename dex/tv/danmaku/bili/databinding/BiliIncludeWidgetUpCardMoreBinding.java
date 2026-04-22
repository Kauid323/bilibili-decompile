package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliIncludeWidgetUpCardMoreBinding implements ViewBinding {
    public final FrameLayout moreLayout;
    private final LinearLayout rootView;
    public final TextView tvMore;
    public final TextView tvTitle1;

    private BiliIncludeWidgetUpCardMoreBinding(LinearLayout rootView, FrameLayout moreLayout, TextView tvMore, TextView tvTitle1) {
        this.rootView = rootView;
        this.moreLayout = moreLayout;
        this.tvMore = tvMore;
        this.tvTitle1 = tvTitle1;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliIncludeWidgetUpCardMoreBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliIncludeWidgetUpCardMoreBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_include_widget_up_card_more, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliIncludeWidgetUpCardMoreBinding bind(View rootView) {
        int id = R.id.more_layout;
        FrameLayout moreLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (moreLayout != null) {
            id = R.id.tv_more;
            TextView tvMore = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvMore != null) {
                id = R.id.tv_title_1;
                TextView tvTitle1 = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tvTitle1 != null) {
                    return new BiliIncludeWidgetUpCardMoreBinding((LinearLayout) rootView, moreLayout, tvMore, tvTitle1);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}