package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliAppDialogDigitalCardBottomBinding implements ViewBinding {
    public final ComposeView checkAvatar;
    public final AppCompatImageView digitalActivityArrow;
    public final BiliImageView digitalActivityIcon;
    public final AppCompatTextView digitalActivityText;
    public final AppCompatTextView digitalChangeAvatar;
    public final AppCompatTextView digitalChangePendant;
    private final ConstraintLayout rootView;

    private BiliAppDialogDigitalCardBottomBinding(ConstraintLayout rootView, ComposeView checkAvatar, AppCompatImageView digitalActivityArrow, BiliImageView digitalActivityIcon, AppCompatTextView digitalActivityText, AppCompatTextView digitalChangeAvatar, AppCompatTextView digitalChangePendant) {
        this.rootView = rootView;
        this.checkAvatar = checkAvatar;
        this.digitalActivityArrow = digitalActivityArrow;
        this.digitalActivityIcon = digitalActivityIcon;
        this.digitalActivityText = digitalActivityText;
        this.digitalChangeAvatar = digitalChangeAvatar;
        this.digitalChangePendant = digitalChangePendant;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalCardBottomBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalCardBottomBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_card_bottom, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDigitalCardBottomBinding bind(View rootView) {
        AppCompatImageView digitalActivityArrow;
        BiliImageView digitalActivityIcon;
        AppCompatTextView digitalActivityText;
        AppCompatTextView digitalChangeAvatar;
        AppCompatTextView digitalChangePendant;
        int id = R.id.checkAvatar;
        ComposeView checkAvatar = ViewBindings.findChildViewById(rootView, id);
        if (checkAvatar != null && (digitalActivityArrow = ViewBindings.findChildViewById(rootView, (id = R.id.digital_activity_arrow))) != null && (digitalActivityIcon = ViewBindings.findChildViewById(rootView, (id = R.id.digital_activity_icon))) != null && (digitalActivityText = ViewBindings.findChildViewById(rootView, (id = R.id.digital_activity_text))) != null && (digitalChangeAvatar = ViewBindings.findChildViewById(rootView, (id = R.id.digital_change_avatar))) != null && (digitalChangePendant = ViewBindings.findChildViewById(rootView, (id = R.id.digital_change_pendant))) != null) {
            return new BiliAppDialogDigitalCardBottomBinding((ConstraintLayout) rootView, checkAvatar, digitalActivityArrow, digitalActivityIcon, digitalActivityText, digitalChangeAvatar, digitalChangePendant);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}