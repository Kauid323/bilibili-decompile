package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliLayoutMainUserCenterAnswerViewBinding implements ViewBinding {
    public final ImageView arrow;
    public final TextView content;
    public final Space leftLayout;
    public final TextView percent;
    private final ConstraintLayout rootView;

    private BiliLayoutMainUserCenterAnswerViewBinding(ConstraintLayout rootView, ImageView arrow, TextView content, Space leftLayout, TextView percent) {
        this.rootView = rootView;
        this.arrow = arrow;
        this.content = content;
        this.leftLayout = leftLayout;
        this.percent = percent;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterAnswerViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterAnswerViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center_answer_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMainUserCenterAnswerViewBinding bind(View rootView) {
        int id = R.id.arrow;
        ImageView arrow = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (arrow != null) {
            id = R.id.content;
            TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (content != null) {
                id = R.id.left_layout;
                Space leftLayout = (Space) ViewBindings.findChildViewById(rootView, id);
                if (leftLayout != null) {
                    id = R.id.percent;
                    TextView percent = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (percent != null) {
                        return new BiliLayoutMainUserCenterAnswerViewBinding((ConstraintLayout) rootView, arrow, content, leftLayout, percent);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}