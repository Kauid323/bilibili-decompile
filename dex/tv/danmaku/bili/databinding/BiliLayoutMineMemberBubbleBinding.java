package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeImageView;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeTextView;

public final class BiliLayoutMineMemberBubbleBinding implements ViewBinding {
    public final MultipleThemeImageView arrow;
    private final ConstraintLayout rootView;
    public final MultipleThemeTextView text;

    private BiliLayoutMineMemberBubbleBinding(ConstraintLayout rootView, MultipleThemeImageView arrow, MultipleThemeTextView text) {
        this.rootView = rootView;
        this.arrow = arrow;
        this.text = text;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMineMemberBubbleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMineMemberBubbleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_mine_member_bubble, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMineMemberBubbleBinding bind(View rootView) {
        int id = R.id.arrow;
        MultipleThemeImageView arrow = (MultipleThemeImageView) ViewBindings.findChildViewById(rootView, id);
        if (arrow != null) {
            id = R.id.text;
            MultipleThemeTextView text = (MultipleThemeTextView) ViewBindings.findChildViewById(rootView, id);
            if (text != null) {
                return new BiliLayoutMineMemberBubbleBinding((ConstraintLayout) rootView, arrow, text);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}