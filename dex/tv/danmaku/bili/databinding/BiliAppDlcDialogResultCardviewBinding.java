package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliAppDlcDialogResultCardviewBinding implements ViewBinding {
    public final BiliImageView bivBadge;
    public final BiliImageView bivFrameBolder;
    public final BiliImageView dlcDetailImage;
    public final TextView dlcDetailTagContent;
    public final BiliImageView dlcDetailTagIcon;
    public final LinearLayoutCompat dlcDetailTagRoot;
    private final ConstraintLayout rootView;

    private BiliAppDlcDialogResultCardviewBinding(ConstraintLayout rootView, BiliImageView bivBadge, BiliImageView bivFrameBolder, BiliImageView dlcDetailImage, TextView dlcDetailTagContent, BiliImageView dlcDetailTagIcon, LinearLayoutCompat dlcDetailTagRoot) {
        this.rootView = rootView;
        this.bivBadge = bivBadge;
        this.bivFrameBolder = bivFrameBolder;
        this.dlcDetailImage = dlcDetailImage;
        this.dlcDetailTagContent = dlcDetailTagContent;
        this.dlcDetailTagIcon = dlcDetailTagIcon;
        this.dlcDetailTagRoot = dlcDetailTagRoot;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDlcDialogResultCardviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDlcDialogResultCardviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dlc_dialog_result_cardview, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDlcDialogResultCardviewBinding bind(View rootView) {
        BiliImageView bivFrameBolder;
        BiliImageView dlcDetailImage;
        BiliImageView dlcDetailTagIcon;
        LinearLayoutCompat dlcDetailTagRoot;
        int id = R.id.bivBadge;
        BiliImageView bivBadge = ViewBindings.findChildViewById(rootView, id);
        if (bivBadge != null && (bivFrameBolder = ViewBindings.findChildViewById(rootView, (id = R.id.bivFrameBolder))) != null && (dlcDetailImage = ViewBindings.findChildViewById(rootView, (id = R.id.dlc_detail_image))) != null) {
            id = R.id.dlc_detail_tag_content;
            TextView dlcDetailTagContent = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (dlcDetailTagContent != null && (dlcDetailTagIcon = ViewBindings.findChildViewById(rootView, (id = R.id.dlc_detail_tag_icon))) != null && (dlcDetailTagRoot = ViewBindings.findChildViewById(rootView, (id = R.id.dlc_detail_tag_root))) != null) {
                return new BiliAppDlcDialogResultCardviewBinding((ConstraintLayout) rootView, bivBadge, bivFrameBolder, dlcDetailImage, dlcDetailTagContent, dlcDetailTagIcon, dlcDetailTagRoot);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}