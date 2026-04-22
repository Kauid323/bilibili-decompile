package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppLayoutVideodownloadPromptBinding implements ViewBinding {
    public final TextView content;
    private final LinearLayout rootView;

    private BiliAppLayoutVideodownloadPromptBinding(LinearLayout rootView, TextView content) {
        this.rootView = rootView;
        this.content = content;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutVideodownloadPromptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutVideodownloadPromptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_videodownload_prompt, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutVideodownloadPromptBinding bind(View rootView) {
        int id = R.id.content;
        TextView content = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (content != null) {
            return new BiliAppLayoutVideodownloadPromptBinding((LinearLayout) rootView, content);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}