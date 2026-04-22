package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivityAuthorSpaceHeaderPlayerBinding implements ViewBinding {
    public final FrameLayout authorSpaceHeaderVideoContainer;
    private final FrameLayout rootView;

    private BiliAppActivityAuthorSpaceHeaderPlayerBinding(FrameLayout rootView, FrameLayout authorSpaceHeaderVideoContainer) {
        this.rootView = rootView;
        this.authorSpaceHeaderVideoContainer = authorSpaceHeaderVideoContainer;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityAuthorSpaceHeaderPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityAuthorSpaceHeaderPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_author_space_header_player, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityAuthorSpaceHeaderPlayerBinding bind(View rootView) {
        int id = R.id.author_space_header_video_container;
        FrameLayout authorSpaceHeaderVideoContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (authorSpaceHeaderVideoContainer != null) {
            return new BiliAppActivityAuthorSpaceHeaderPlayerBinding((FrameLayout) rootView, authorSpaceHeaderVideoContainer);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}