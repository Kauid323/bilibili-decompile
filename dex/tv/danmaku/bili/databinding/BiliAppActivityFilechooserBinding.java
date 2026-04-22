package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivityFilechooserBinding implements ViewBinding {
    public final Button cancel;
    public final FrameLayout content;
    public final Button newFolder;
    public final Button ok;
    private final LinearLayout rootView;
    public final TextView title;

    private BiliAppActivityFilechooserBinding(LinearLayout rootView, Button cancel, FrameLayout content, Button newFolder, Button ok, TextView title) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.content = content;
        this.newFolder = newFolder;
        this.ok = ok;
        this.title = title;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityFilechooserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityFilechooserBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_filechooser, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityFilechooserBinding bind(View rootView) {
        int id = R.id.cancel;
        Button cancel = (Button) ViewBindings.findChildViewById(rootView, id);
        if (cancel != null) {
            id = R.id.content;
            FrameLayout content = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (content != null) {
                id = R.id.new_folder;
                Button newFolder = (Button) ViewBindings.findChildViewById(rootView, id);
                if (newFolder != null) {
                    id = R.id.ok;
                    Button ok = (Button) ViewBindings.findChildViewById(rootView, id);
                    if (ok != null) {
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new BiliAppActivityFilechooserBinding((LinearLayout) rootView, cancel, content, newFolder, ok, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}