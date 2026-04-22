package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppMineRevisitInTribeePopBinding implements ViewBinding {
    public final TintImageView ivAnchor;
    private final TintLinearLayout rootView;
    public final TintTextView tvText;

    private BiliAppMineRevisitInTribeePopBinding(TintLinearLayout rootView, TintImageView ivAnchor, TintTextView tvText) {
        this.rootView = rootView;
        this.ivAnchor = ivAnchor;
        this.tvText = tvText;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppMineRevisitInTribeePopBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppMineRevisitInTribeePopBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_mine_revisit_in_tribee_pop, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppMineRevisitInTribeePopBinding bind(View rootView) {
        TintTextView tvText;
        int id = R.id.iv_anchor;
        TintImageView ivAnchor = ViewBindings.findChildViewById(rootView, id);
        if (ivAnchor != null && (tvText = ViewBindings.findChildViewById(rootView, (id = R.id.tv_text))) != null) {
            return new BiliAppMineRevisitInTribeePopBinding((TintLinearLayout) rootView, ivAnchor, tvText);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}