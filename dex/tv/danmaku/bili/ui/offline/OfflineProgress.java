package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import tv.danmaku.bili.R;

public class OfflineProgress extends TintProgressBar {
    public boolean mIsDownloading;

    public OfflineProgress(Context context) {
        super(context);
        init(context);
    }

    public OfflineProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.layerlist_progress_offline));
    }

    public void updateStatus(boolean isDownloading) {
        this.mIsDownloading = isDownloading;
        tint();
    }

    public void tint() {
        super.tint();
        Drawable d = getProgressDrawable();
        if (d != null && (d instanceof LayerDrawable)) {
            LayerDrawable drawable = (LayerDrawable) d;
            Drawable mainLayer = drawable.findDrawableByLayerId(16908301);
            if (mainLayer != null) {
                int mainColor = ThemeUtils.getColorById(getContext(), this.mIsDownloading ? com.bilibili.app.comm.baseres.R.color.theme_color_secondary : com.bilibili.lib.theme.R.color.Ga4);
                DrawableCompat.setTint(DrawableCompat.wrap(mainLayer), mainColor);
            }
            Drawable backLayer = drawable.findDrawableByLayerId(16908288);
            if (backLayer != null) {
                int backColor = ThemeUtils.getColorById(getContext(), com.bilibili.lib.theme.R.color.Ga2);
                DrawableCompat.setTint(DrawableCompat.wrap(backLayer), backColor);
            }
        }
    }
}