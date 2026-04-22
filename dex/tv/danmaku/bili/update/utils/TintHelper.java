package tv.danmaku.bili.update.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.bilibili.app.updater.R;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.api.supplier.TintResourceSupplier;

public class TintHelper {
    private static final String TAG = "TintHelper";

    public static boolean setCompoundButtonDrawableTint(CompoundButton view2, ColorStateList tintList) {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(view2);
        if (buttonDrawable != null) {
            Drawable buttonDrawable2 = DrawableCompat.wrap(buttonDrawable).mutate();
            DrawableCompat.setTintList(buttonDrawable2, tintList);
            if (buttonDrawable2.isStateful()) {
                buttonDrawable2.setState(view2.getDrawableState());
            }
            view2.setButtonDrawable(buttonDrawable2);
            return true;
        }
        return false;
    }

    public static void tryTintPositiveButtonBackground(Context context, Dialog dialog, View positiveBtn) {
        TintResourceSupplier tintResourceSupplier = RuntimeHelper.getUpdaterOptions().getTintResourceSupplier();
        Drawable backgroundDrawable = null;
        if (tintResourceSupplier != null) {
            try {
                backgroundDrawable = tintResourceSupplier.getDrawable(dialog.getContext(), R.drawable.update_dialog_confirm_button);
            } catch (Exception e) {
                BLog.i(TAG, "Unable to adapt to multiple themes");
            }
        }
        if (backgroundDrawable == null) {
            try {
                backgroundDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.update_dialog_confirm_button, (Resources.Theme) null);
            } catch (Exception e2) {
                BLog.e(TAG, "No multi-theme color resource is defined");
            }
        }
        if (backgroundDrawable != null) {
            positiveBtn.setBackground(backgroundDrawable);
        }
    }
}