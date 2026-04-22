package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDialogAnswerFreeBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnConfirm;
    public final TextView content;
    private final LinearLayout rootView;
    public final ImageView title;
    public final LinearLayout vContainer;

    private BiliAppDialogAnswerFreeBinding(LinearLayout rootView, TextView btnCancel, TextView btnConfirm, TextView content, ImageView title, LinearLayout vContainer) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnConfirm = btnConfirm;
        this.content = content;
        this.title = title;
        this.vContainer = vContainer;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogAnswerFreeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogAnswerFreeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_answer_free, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogAnswerFreeBinding bind(View rootView) {
        int id = R.id.btn_cancel;
        TextView btnCancel = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (btnCancel != null) {
            id = R.id.btn_confirm;
            TextView btnConfirm = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (btnConfirm != null) {
                id = R.id.content;
                TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (content != null) {
                    id = R.id.title;
                    ImageView title = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (title != null) {
                        LinearLayout vContainer = (LinearLayout) rootView;
                        return new BiliAppDialogAnswerFreeBinding((LinearLayout) rootView, btnCancel, btnConfirm, content, title, vContainer);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}