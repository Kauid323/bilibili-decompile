package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppLayoutFilechooserItemBinding implements ViewBinding {
    private final TextView rootView;

    private BiliAppLayoutFilechooserItemBinding(TextView rootView) {
        this.rootView = rootView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutFilechooserItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutFilechooserItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_filechooser_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutFilechooserItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new BiliAppLayoutFilechooserItemBinding((TextView) rootView);
    }
}