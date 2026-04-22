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
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppDialogUserProtocolBinding implements ViewBinding {
    public final TintTextView agree;
    public final LinearLayout container;
    public final TextView content;
    public final ImageView dialogBackground;
    public final TintTextView disagree;
    public final TextView privacyInfo;
    public final ScrollView rootContainer;
    private final FrameLayout rootView;
    public final View space;
    public final TextView title;

    private BiliAppDialogUserProtocolBinding(FrameLayout rootView, TintTextView agree, LinearLayout container, TextView content, ImageView dialogBackground, TintTextView disagree, TextView privacyInfo, ScrollView rootContainer, View space, TextView title) {
        this.rootView = rootView;
        this.agree = agree;
        this.container = container;
        this.content = content;
        this.dialogBackground = dialogBackground;
        this.disagree = disagree;
        this.privacyInfo = privacyInfo;
        this.rootContainer = rootContainer;
        this.space = space;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogUserProtocolBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogUserProtocolBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_user_protocol, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogUserProtocolBinding bind(View rootView) {
        TintTextView disagree;
        View space;
        int id = R.id.agree;
        TintTextView agree = ViewBindings.findChildViewById(rootView, id);
        if (agree != null) {
            id = R.id.container;
            LinearLayout container = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (container != null) {
                id = R.id.content;
                TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (content != null) {
                    id = R.id.dialog_background;
                    ImageView dialogBackground = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (dialogBackground != null && (disagree = ViewBindings.findChildViewById(rootView, (id = R.id.disagree))) != null) {
                        id = R.id.privacy_info;
                        TextView privacyInfo = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (privacyInfo != null) {
                            id = R.id.root_container;
                            ScrollView rootContainer = (ScrollView) ViewBindings.findChildViewById(rootView, id);
                            if (rootContainer != null && (space = ViewBindings.findChildViewById(rootView, (id = R.id.space))) != null) {
                                id = R.id.title;
                                TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (title != null) {
                                    return new BiliAppDialogUserProtocolBinding((FrameLayout) rootView, agree, container, content, dialogBackground, disagree, privacyInfo, rootContainer, space, title);
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