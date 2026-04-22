package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.PriorityLinearLayout;

public final class BiliLayoutMainUserCenterButtonNoticeBinding implements ViewBinding {
    public final TintTextView content;
    public final BiliImageView icAction;
    public final BiliImageView icNotice;
    private final PriorityLinearLayout rootView;
    public final PriorityLinearLayout tipRoot;
    public final TintTextView tvAction;

    private BiliLayoutMainUserCenterButtonNoticeBinding(PriorityLinearLayout rootView, TintTextView content, BiliImageView icAction, BiliImageView icNotice, PriorityLinearLayout tipRoot, TintTextView tvAction) {
        this.rootView = rootView;
        this.content = content;
        this.icAction = icAction;
        this.icNotice = icNotice;
        this.tipRoot = tipRoot;
        this.tvAction = tvAction;
    }

    public PriorityLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterButtonNoticeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterButtonNoticeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_button_notice, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterButtonNoticeBinding bind(View rootView) {
        BiliImageView icAction;
        BiliImageView icNotice;
        int id = R.id.content;
        TintTextView content = ViewBindings.findChildViewById(rootView, id);
        if (content != null && (icAction = ViewBindings.findChildViewById(rootView, (id = R.id.ic_action))) != null && (icNotice = ViewBindings.findChildViewById(rootView, (id = R.id.ic_notice))) != null) {
            PriorityLinearLayout tipRoot = (PriorityLinearLayout) rootView;
            id = R.id.tv_action;
            TintTextView tvAction = ViewBindings.findChildViewById(rootView, id);
            if (tvAction != null) {
                return new BiliLayoutMainUserCenterButtonNoticeBinding((PriorityLinearLayout) rootView, content, icAction, icNotice, tipRoot, tvAction);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}