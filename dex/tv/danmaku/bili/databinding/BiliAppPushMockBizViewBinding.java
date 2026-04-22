package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppPushMockBizViewBinding implements ViewBinding {
    public final TextView pushMockTextview;
    public final FrameLayout pushMockView;
    private final FrameLayout rootView;

    private BiliAppPushMockBizViewBinding(FrameLayout rootView, TextView pushMockTextview, FrameLayout pushMockView) {
        this.rootView = rootView;
        this.pushMockTextview = pushMockTextview;
        this.pushMockView = pushMockView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppPushMockBizViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppPushMockBizViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_push_mock_biz_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppPushMockBizViewBinding bind(View rootView) {
        int id = R.id.push_mock_textview;
        TextView pushMockTextview = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (pushMockTextview != null) {
            id = R.id.push_mock_view;
            FrameLayout pushMockView = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (pushMockView != null) {
                return new BiliAppPushMockBizViewBinding((FrameLayout) rootView, pushMockTextview, pushMockView);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}