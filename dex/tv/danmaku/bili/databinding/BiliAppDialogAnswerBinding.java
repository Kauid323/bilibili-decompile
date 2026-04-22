package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDialogAnswerBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnInviteCode;
    public final TextView btnToAnswer;
    public final TextView content;
    private final FrameLayout rootView;
    public final TextView title;
    public final LinearLayout vContainer;

    private BiliAppDialogAnswerBinding(FrameLayout rootView, TextView btnCancel, TextView btnInviteCode, TextView btnToAnswer, TextView content, TextView title, LinearLayout vContainer) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnInviteCode = btnInviteCode;
        this.btnToAnswer = btnToAnswer;
        this.content = content;
        this.title = title;
        this.vContainer = vContainer;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogAnswerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogAnswerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_answer, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogAnswerBinding bind(View rootView) {
        int id = R.id.btn_cancel;
        TextView btnCancel = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (btnCancel != null) {
            id = R.id.btn_invite_code;
            TextView btnInviteCode = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (btnInviteCode != null) {
                id = R.id.btn_to_answer;
                TextView btnToAnswer = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (btnToAnswer != null) {
                    id = R.id.content;
                    TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (content != null) {
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            id = R.id.v_container;
                            LinearLayout vContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (vContainer != null) {
                                return new BiliAppDialogAnswerBinding((FrameLayout) rootView, btnCancel, btnInviteCode, btnToAnswer, content, title, vContainer);
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}