package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppLayoutOpBizDialogBinding implements ViewBinding {
    public final ImageView close;
    public final ConstraintLayout dialogContainer;
    public final ImageView dialogImage;
    private final ConstraintLayout rootView;

    private BiliAppLayoutOpBizDialogBinding(ConstraintLayout rootView, ImageView close, ConstraintLayout dialogContainer, ImageView dialogImage) {
        this.rootView = rootView;
        this.close = close;
        this.dialogContainer = dialogContainer;
        this.dialogImage = dialogImage;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutOpBizDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutOpBizDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_op_biz_dialog, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutOpBizDialogBinding bind(View rootView) {
        int id = R.id.close;
        ImageView close = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (close != null) {
            ConstraintLayout dialogContainer = (ConstraintLayout) rootView;
            id = R.id.dialog_image;
            ImageView dialogImage = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (dialogImage != null) {
                return new BiliAppLayoutOpBizDialogBinding((ConstraintLayout) rootView, close, dialogContainer, dialogImage);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}