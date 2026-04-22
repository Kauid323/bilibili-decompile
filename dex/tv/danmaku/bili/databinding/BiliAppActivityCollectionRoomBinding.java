package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import tv.danmaku.bili.R;

public final class BiliAppActivityCollectionRoomBinding implements ViewBinding {
    public final ConstraintLayout collectionRoomRootView;
    private final ConstraintLayout rootView;

    private BiliAppActivityCollectionRoomBinding(ConstraintLayout rootView, ConstraintLayout collectionRoomRootView) {
        this.rootView = rootView;
        this.collectionRoomRootView = collectionRoomRootView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityCollectionRoomBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityCollectionRoomBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_collection_room, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityCollectionRoomBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ConstraintLayout collectionRoomRootView = (ConstraintLayout) rootView;
        return new BiliAppActivityCollectionRoomBinding((ConstraintLayout) rootView, collectionRoomRootView);
    }
}