package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppHomeStoryEntranceGuideBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView title;

    private BiliAppHomeStoryEntranceGuideBinding(FrameLayout rootView, TextView title) {
        this.rootView = rootView;
        this.title = title;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppHomeStoryEntranceGuideBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppHomeStoryEntranceGuideBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_home_story_entrance_guide, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppHomeStoryEntranceGuideBinding bind(View rootView) {
        int id = R.id.title;
        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (title != null) {
            return new BiliAppHomeStoryEntranceGuideBinding((FrameLayout) rootView, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}