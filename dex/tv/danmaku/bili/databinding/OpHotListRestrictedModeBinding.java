package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class OpHotListRestrictedModeBinding implements ViewBinding {
    public final ImageView brand;
    public final ConstraintLayout container;
    public final ImageView restrictedCover1;
    public final ImageView restrictedCover2;
    public final ImageView restrictedCover3;
    private final ConstraintLayout rootView;
    public final TextView tvRestrictedText;
    public final ConstraintLayout videoContainer;

    private OpHotListRestrictedModeBinding(ConstraintLayout rootView, ImageView brand, ConstraintLayout container, ImageView restrictedCover1, ImageView restrictedCover2, ImageView restrictedCover3, TextView tvRestrictedText, ConstraintLayout videoContainer) {
        this.rootView = rootView;
        this.brand = brand;
        this.container = container;
        this.restrictedCover1 = restrictedCover1;
        this.restrictedCover2 = restrictedCover2;
        this.restrictedCover3 = restrictedCover3;
        this.tvRestrictedText = tvRestrictedText;
        this.videoContainer = videoContainer;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static OpHotListRestrictedModeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static OpHotListRestrictedModeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.op_hot_list_restricted_mode, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static OpHotListRestrictedModeBinding bind(View rootView) {
        ConstraintLayout videoContainer;
        int id = R.id.brand;
        ImageView brand = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (brand != null) {
            ConstraintLayout container = (ConstraintLayout) rootView;
            id = R.id.restricted_cover_1;
            ImageView restrictedCover1 = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (restrictedCover1 != null) {
                id = R.id.restricted_cover_2;
                ImageView restrictedCover2 = (ImageView) ViewBindings.findChildViewById(rootView, id);
                if (restrictedCover2 != null) {
                    id = R.id.restricted_cover_3;
                    ImageView restrictedCover3 = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (restrictedCover3 != null) {
                        id = R.id.tv_restricted_text;
                        TextView tvRestrictedText = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (tvRestrictedText != null && (videoContainer = ViewBindings.findChildViewById(rootView, (id = R.id.video_container))) != null) {
                            return new OpHotListRestrictedModeBinding((ConstraintLayout) rootView, brand, container, restrictedCover1, restrictedCover2, restrictedCover3, tvRestrictedText, videoContainer);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}