package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDlcDialogCardResultBottomBinding implements ViewBinding {
    public final ConstraintLayout clDlcCardResultBottom;
    private final ConstraintLayout rootView;
    public final Space spaceDlcCardResultBottom;
    public final AppCompatTextView tvDlcCardResultDrawAgain;
    public final AppCompatTextView tvDlcCardResultGotoGraphic;
    public final AppCompatTextView tvDlcCardResultLeftChance;

    private BiliAppDlcDialogCardResultBottomBinding(ConstraintLayout rootView, ConstraintLayout clDlcCardResultBottom, Space spaceDlcCardResultBottom, AppCompatTextView tvDlcCardResultDrawAgain, AppCompatTextView tvDlcCardResultGotoGraphic, AppCompatTextView tvDlcCardResultLeftChance) {
        this.rootView = rootView;
        this.clDlcCardResultBottom = clDlcCardResultBottom;
        this.spaceDlcCardResultBottom = spaceDlcCardResultBottom;
        this.tvDlcCardResultDrawAgain = tvDlcCardResultDrawAgain;
        this.tvDlcCardResultGotoGraphic = tvDlcCardResultGotoGraphic;
        this.tvDlcCardResultLeftChance = tvDlcCardResultLeftChance;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDlcDialogCardResultBottomBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDlcDialogCardResultBottomBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dlc_dialog_card_result_bottom, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDlcDialogCardResultBottomBinding bind(View rootView) {
        AppCompatTextView tvDlcCardResultDrawAgain;
        AppCompatTextView tvDlcCardResultGotoGraphic;
        ConstraintLayout clDlcCardResultBottom = (ConstraintLayout) rootView;
        int id = R.id.space_dlc_card_result_bottom;
        Space spaceDlcCardResultBottom = (Space) ViewBindings.findChildViewById(rootView, id);
        if (spaceDlcCardResultBottom != null && (tvDlcCardResultDrawAgain = ViewBindings.findChildViewById(rootView, (id = R.id.tv_dlc_card_result_draw_again))) != null && (tvDlcCardResultGotoGraphic = ViewBindings.findChildViewById(rootView, (id = R.id.tv_dlc_card_result_goto_graphic))) != null) {
            int id2 = R.id.tv_dlc_card_result_left_chance;
            AppCompatTextView tvDlcCardResultLeftChance = ViewBindings.findChildViewById(rootView, id2);
            if (tvDlcCardResultLeftChance == null) {
                id = id2;
            } else {
                return new BiliAppDlcDialogCardResultBottomBinding((ConstraintLayout) rootView, clDlcCardResultBottom, spaceDlcCardResultBottom, tvDlcCardResultDrawAgain, tvDlcCardResultGotoGraphic, tvDlcCardResultLeftChance);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}