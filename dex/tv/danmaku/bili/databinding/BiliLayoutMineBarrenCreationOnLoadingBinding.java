package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintView;
import tv.danmaku.bili.R;

public final class BiliLayoutMineBarrenCreationOnLoadingBinding implements ViewBinding {
    public final TintView coverLeft;
    public final TintView coverRight;
    private final ConstraintLayout rootView;

    private BiliLayoutMineBarrenCreationOnLoadingBinding(ConstraintLayout rootView, TintView coverLeft, TintView coverRight) {
        this.rootView = rootView;
        this.coverLeft = coverLeft;
        this.coverRight = coverRight;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMineBarrenCreationOnLoadingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMineBarrenCreationOnLoadingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_mine_barren_creation_on_loading, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMineBarrenCreationOnLoadingBinding bind(View rootView) {
        TintView coverRight;
        int id = R.id.cover_left;
        TintView coverLeft = ViewBindings.findChildViewById(rootView, id);
        if (coverLeft != null && (coverRight = ViewBindings.findChildViewById(rootView, (id = R.id.cover_right))) != null) {
            return new BiliLayoutMineBarrenCreationOnLoadingBinding((ConstraintLayout) rootView, coverLeft, coverRight);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}