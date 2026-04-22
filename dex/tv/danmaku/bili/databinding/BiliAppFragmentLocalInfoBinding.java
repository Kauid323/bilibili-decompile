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
import tv.danmaku.bili.widget.RecyclerView;

public final class BiliAppFragmentLocalInfoBinding implements ViewBinding {
    public final Guideline guideline1;
    private final ConstraintLayout rootView;
    public final RecyclerView rvModInfo;
    public final TextView tvModEnv;
    public final TextView tvModInfo;
    public final TextView tvModTotalNum;
    public final TextView tvModTotalSize;

    private BiliAppFragmentLocalInfoBinding(ConstraintLayout rootView, Guideline guideline1, RecyclerView rvModInfo, TextView tvModEnv, TextView tvModInfo, TextView tvModTotalNum, TextView tvModTotalSize) {
        this.rootView = rootView;
        this.guideline1 = guideline1;
        this.rvModInfo = rvModInfo;
        this.tvModEnv = tvModEnv;
        this.tvModInfo = tvModInfo;
        this.tvModTotalNum = tvModTotalNum;
        this.tvModTotalSize = tvModTotalSize;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentLocalInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentLocalInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_local_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentLocalInfoBinding bind(View rootView) {
        RecyclerView rvModInfo;
        int id = R.id.guideline1;
        Guideline guideline1 = ViewBindings.findChildViewById(rootView, id);
        if (guideline1 != null && (rvModInfo = ViewBindings.findChildViewById(rootView, (id = R.id.rv_mod_info))) != null) {
            id = R.id.tv_mod_env;
            TextView tvModEnv = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (tvModEnv != null) {
                id = R.id.tv_mod_info;
                TextView tvModInfo = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (tvModInfo != null) {
                    id = R.id.tv_mod_total_num;
                    TextView tvModTotalNum = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (tvModTotalNum != null) {
                        id = R.id.tv_mod_total_size;
                        TextView tvModTotalSize = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (tvModTotalSize != null) {
                            return new BiliAppFragmentLocalInfoBinding((ConstraintLayout) rootView, guideline1, rvModInfo, tvModEnv, tvModInfo, tvModTotalNum, tvModTotalSize);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}