package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDlcDialogCardResultMultiCardBinding implements ViewBinding {
    public final LinearLayout clDlcCardResultMid;
    public final ScrollView dlcResultCardScrollview;
    public final AppCompatImageView dlcResultCardTopCancel;
    public final LinearLayout linNameWrapper;
    private final ConstraintLayout rootView;
    public final AppCompatTextView tvCardsTitle;

    private BiliAppDlcDialogCardResultMultiCardBinding(ConstraintLayout rootView, LinearLayout clDlcCardResultMid, ScrollView dlcResultCardScrollview, AppCompatImageView dlcResultCardTopCancel, LinearLayout linNameWrapper, AppCompatTextView tvCardsTitle) {
        this.rootView = rootView;
        this.clDlcCardResultMid = clDlcCardResultMid;
        this.dlcResultCardScrollview = dlcResultCardScrollview;
        this.dlcResultCardTopCancel = dlcResultCardTopCancel;
        this.linNameWrapper = linNameWrapper;
        this.tvCardsTitle = tvCardsTitle;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDlcDialogCardResultMultiCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDlcDialogCardResultMultiCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dlc_dialog_card_result_multi_card, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDlcDialogCardResultMultiCardBinding bind(View rootView) {
        AppCompatImageView dlcResultCardTopCancel;
        AppCompatTextView tvCardsTitle;
        int id = R.id.cl_dlc_card_result_mid;
        LinearLayout clDlcCardResultMid = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (clDlcCardResultMid != null) {
            id = R.id.dlc_result_card_scrollview;
            ScrollView dlcResultCardScrollview = (ScrollView) ViewBindings.findChildViewById(rootView, id);
            if (dlcResultCardScrollview != null && (dlcResultCardTopCancel = ViewBindings.findChildViewById(rootView, (id = R.id.dlc_result_card_top_cancel))) != null) {
                id = R.id.linNameWrapper;
                LinearLayout linNameWrapper = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (linNameWrapper != null && (tvCardsTitle = ViewBindings.findChildViewById(rootView, (id = R.id.tvCardsTitle))) != null) {
                    return new BiliAppDlcDialogCardResultMultiCardBinding((ConstraintLayout) rootView, clDlcCardResultMid, dlcResultCardScrollview, dlcResultCardTopCancel, linNameWrapper, tvCardsTitle);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}