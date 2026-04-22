package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppListItemModInfoBinding implements ViewBinding {
    public final Guideline guideline1;
    public final Guideline guideline2;
    private final ConstraintLayout rootView;
    public final TextView tvModName;
    public final TextView tvModSize;

    private BiliAppListItemModInfoBinding(ConstraintLayout rootView, Guideline guideline1, Guideline guideline2, TextView tvModName, TextView tvModSize) {
        this.rootView = rootView;
        this.guideline1 = guideline1;
        this.guideline2 = guideline2;
        this.tvModName = tvModName;
        this.tvModSize = tvModSize;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListItemModInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListItemModInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_item_mod_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListItemModInfoBinding bind(View rootView) {
        Guideline guideline2;
        int id = R.id.guideline1;
        Guideline guideline1 = ViewBindings.findChildViewById(rootView, id);
        if (guideline1 != null && (guideline2 = ViewBindings.findChildViewById(rootView, (id = R.id.guideline2))) != null) {
            id = R.id.tv_mod_name;
            TextView tvModName = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvModName != null) {
                id = R.id.tv_mod_size;
                TextView tvModSize = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tvModSize != null) {
                    return new BiliAppListItemModInfoBinding((ConstraintLayout) rootView, guideline1, guideline2, tvModName, tvModSize);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}