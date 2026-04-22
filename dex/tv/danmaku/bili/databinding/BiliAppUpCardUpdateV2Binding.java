package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppUpCardUpdateV2Binding implements ViewBinding {
    public final LinearLayout background;
    public final ImageView brand;
    public final RelativeLayout container;
    public final ImageView ivCover;
    public final ImageView ivPerson;
    public final LinearLayout leftCenterContainer;
    public final TextView leftCenterOnlinePerson;
    public final TextView leftCenterTitle;
    public final TextView leftCenterUpdateProgress;
    public final LinearLayout leftTopContainer;
    public final TextView leftTopTitle;
    public final LinearLayout onlinePersonContainer;
    private final RelativeLayout rootView;

    private BiliAppUpCardUpdateV2Binding(RelativeLayout rootView, LinearLayout background, ImageView brand, RelativeLayout container, ImageView ivCover, ImageView ivPerson, LinearLayout leftCenterContainer, TextView leftCenterOnlinePerson, TextView leftCenterTitle, TextView leftCenterUpdateProgress, LinearLayout leftTopContainer, TextView leftTopTitle, LinearLayout onlinePersonContainer) {
        this.rootView = rootView;
        this.background = background;
        this.brand = brand;
        this.container = container;
        this.ivCover = ivCover;
        this.ivPerson = ivPerson;
        this.leftCenterContainer = leftCenterContainer;
        this.leftCenterOnlinePerson = leftCenterOnlinePerson;
        this.leftCenterTitle = leftCenterTitle;
        this.leftCenterUpdateProgress = leftCenterUpdateProgress;
        this.leftTopContainer = leftTopContainer;
        this.leftTopTitle = leftTopTitle;
        this.onlinePersonContainer = onlinePersonContainer;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppUpCardUpdateV2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppUpCardUpdateV2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_up_card_update_v2, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppUpCardUpdateV2Binding bind(View rootView) {
        int id = 16908288;
        LinearLayout background = (LinearLayout) ViewBindings.findChildViewById(rootView, 16908288);
        if (background != null) {
            id = R.id.brand;
            ImageView brand = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (brand != null) {
                id = R.id.container;
                RelativeLayout container = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                if (container != null) {
                    id = R.id.iv_cover;
                    ImageView ivCover = (ImageView) ViewBindings.findChildViewById(rootView, id);
                    if (ivCover != null) {
                        id = R.id.iv_person;
                        ImageView ivPerson = (ImageView) ViewBindings.findChildViewById(rootView, id);
                        if (ivPerson != null) {
                            id = R.id.left_center_container;
                            LinearLayout leftCenterContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                            if (leftCenterContainer != null) {
                                id = R.id.left_center_online_person;
                                TextView leftCenterOnlinePerson = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (leftCenterOnlinePerson != null) {
                                    id = R.id.left_center_title;
                                    TextView leftCenterTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (leftCenterTitle != null) {
                                        id = R.id.left_center_update_progress;
                                        TextView leftCenterUpdateProgress = (TextView) ViewBindings.findChildViewById(rootView, id);
                                        if (leftCenterUpdateProgress != null) {
                                            id = R.id.left_top_container;
                                            LinearLayout leftTopContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                            if (leftTopContainer != null) {
                                                id = R.id.left_top_title;
                                                TextView leftTopTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                if (leftTopTitle != null) {
                                                    id = R.id.online_person_container;
                                                    LinearLayout onlinePersonContainer = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                                    if (onlinePersonContainer != null) {
                                                        return new BiliAppUpCardUpdateV2Binding((RelativeLayout) rootView, background, brand, container, ivCover, ivPerson, leftCenterContainer, leftCenterOnlinePerson, leftCenterTitle, leftCenterUpdateProgress, leftTopContainer, leftTopTitle, onlinePersonContainer);
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
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}