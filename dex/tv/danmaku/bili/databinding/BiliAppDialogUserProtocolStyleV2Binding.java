package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppDialogUserProtocolStyleV2Binding implements ViewBinding {
    public final TintTextView agree;
    public final TextView content;
    public final TintTextView disagree;
    public final TextView privacyInfo;
    private final ScrollView rootView;
    public final View space;
    public final TextView title;

    private BiliAppDialogUserProtocolStyleV2Binding(ScrollView rootView, TintTextView agree, TextView content, TintTextView disagree, TextView privacyInfo, View space, TextView title) {
        this.rootView = rootView;
        this.agree = agree;
        this.content = content;
        this.disagree = disagree;
        this.privacyInfo = privacyInfo;
        this.space = space;
        this.title = title;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogUserProtocolStyleV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogUserProtocolStyleV2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_user_protocol_style_v2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogUserProtocolStyleV2Binding bind(View rootView) {
        TintTextView disagree;
        View space;
        int id = R.id.agree;
        TintTextView agree = ViewBindings.findChildViewById(rootView, id);
        if (agree != null) {
            id = R.id.content;
            TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (content != null && (disagree = ViewBindings.findChildViewById(rootView, (id = R.id.disagree))) != null) {
                id = R.id.privacy_info;
                TextView privacyInfo = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (privacyInfo != null && (space = ViewBindings.findChildViewById(rootView, (id = R.id.space))) != null) {
                    id = R.id.title;
                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (title != null) {
                        return new BiliAppDialogUserProtocolStyleV2Binding((ScrollView) rootView, agree, content, disagree, privacyInfo, space, title);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}