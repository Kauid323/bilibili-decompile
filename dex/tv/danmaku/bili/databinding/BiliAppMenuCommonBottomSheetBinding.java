package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppMenuCommonBottomSheetBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView tvCancel;

    private BiliAppMenuCommonBottomSheetBinding(LinearLayout rootView, RecyclerView recyclerView, TextView tvCancel) {
        this.rootView = rootView;
        this.recyclerView = recyclerView;
        this.tvCancel = tvCancel;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppMenuCommonBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppMenuCommonBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_menu_common_bottom_sheet, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppMenuCommonBottomSheetBinding bind(View rootView) {
        int id = R.id.recycler_view;
        RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
        if (recyclerView != null) {
            id = R.id.tv_cancel;
            TextView tvCancel = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvCancel != null) {
                return new BiliAppMenuCommonBottomSheetBinding((LinearLayout) rootView, recyclerView, tvCancel);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}