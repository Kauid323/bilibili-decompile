package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppListItemSingleTextBinding implements ViewBinding {
    private final LinearLayout rootView;

    /* renamed from: tv  reason: collision with root package name */
    public final TextView f14tv;

    private BiliAppListItemSingleTextBinding(LinearLayout rootView, TextView tv2) {
        this.rootView = rootView;
        this.f14tv = tv2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemSingleTextBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemSingleTextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_single_text, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemSingleTextBinding bind(View rootView) {
        int id = R.id.f13tv;
        TextView tv2 = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (tv2 != null) {
            return new BiliAppListItemSingleTextBinding((LinearLayout) rootView, tv2);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}