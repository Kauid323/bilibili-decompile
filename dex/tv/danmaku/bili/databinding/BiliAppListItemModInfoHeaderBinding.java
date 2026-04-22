package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppListItemModInfoHeaderBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvModHeader;

    private BiliAppListItemModInfoHeaderBinding(ConstraintLayout rootView, TextView tvModHeader) {
        this.rootView = rootView;
        this.tvModHeader = tvModHeader;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemModInfoHeaderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemModInfoHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_mod_info_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemModInfoHeaderBinding bind(View rootView) {
        int id = R.id.tv_mod_header;
        TextView tvModHeader = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (tvModHeader != null) {
            return new BiliAppListItemModInfoHeaderBinding((ConstraintLayout) rootView, tvModHeader);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}