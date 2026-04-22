package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDialogUserProtocolTestBinding implements ViewBinding {
    public final TextView agree;
    public final LinearLayout container;
    public final TextView content;
    public final ImageView dialogBackgroundBottom;
    public final ImageView dialogBackgroundMiddle;
    public final ImageView dialogBackgroundTop;
    public final TextView disagree;
    public final TextView privacyInfo;
    public final ScrollView rootContainer;
    private final FrameLayout rootView;
    public final View space;
    public final TextView title;

    private BiliAppDialogUserProtocolTestBinding(FrameLayout rootView, TextView agree, LinearLayout container, TextView content, ImageView dialogBackgroundBottom, ImageView dialogBackgroundMiddle, ImageView dialogBackgroundTop, TextView disagree, TextView privacyInfo, ScrollView rootContainer, View space, TextView title) {
        this.rootView = rootView;
        this.agree = agree;
        this.container = container;
        this.content = content;
        this.dialogBackgroundBottom = dialogBackgroundBottom;
        this.dialogBackgroundMiddle = dialogBackgroundMiddle;
        this.dialogBackgroundTop = dialogBackgroundTop;
        this.disagree = disagree;
        this.privacyInfo = privacyInfo;
        this.rootContainer = rootContainer;
        this.space = space;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogUserProtocolTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogUserProtocolTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_user_protocol_test, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogUserProtocolTestBinding bind(View rootView) {
        View space;
        int id = R.id.agree;
        TextView agree = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (agree != null) {
            id = R.id.container;
            LinearLayout container = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (container != null) {
                id = R.id.content;
                TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (content != null) {
                    id = R.id.dialog_background_bottom;
                    ImageView dialogBackgroundBottom = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (dialogBackgroundBottom != null) {
                        id = R.id.dialog_background_middle;
                        ImageView dialogBackgroundMiddle = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (dialogBackgroundMiddle != null) {
                            id = R.id.dialog_background_top;
                            ImageView dialogBackgroundTop = (ImageView) ViewBindings.findChildViewById(rootView, id);
                            if (dialogBackgroundTop != null) {
                                id = R.id.disagree;
                                TextView disagree = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (disagree != null) {
                                    id = R.id.privacy_info;
                                    TextView privacyInfo = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (privacyInfo != null) {
                                        id = R.id.root_container;
                                        ScrollView rootContainer = (ScrollView) ViewBindings.findChildViewById(rootView, id);
                                        if (rootContainer != null && (space = ViewBindings.findChildViewById(rootView, (id = R.id.space))) != null) {
                                            id = R.id.title;
                                            TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                                            if (title != null) {
                                                return new BiliAppDialogUserProtocolTestBinding((FrameLayout) rootView, agree, container, content, dialogBackgroundBottom, dialogBackgroundMiddle, dialogBackgroundTop, disagree, privacyInfo, rootContainer, space, title);
                                            }
                                        }
                                    }
                                }
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