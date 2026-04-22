package tv.danmaku.bili.ui.personinfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.View;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

/* JADX INFO: Access modifiers changed from: package-private */
public final class PersonInfoQRCodeHelper {
    PersonInfoQRCodeHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap getBitmapFromView(View v) {
        Bitmap overlayBitmap;
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(-16777216);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setFilterBitmap(true);
        p.setDither(true);
        boolean isDrawingCacheEnabled = v.isDrawingCacheEnabled();
        if (!isDrawingCacheEnabled) {
            v.setDrawingCacheEnabled(true);
        }
        if (!(v instanceof SurfaceView) && (overlayBitmap = v.getDrawingCache()) != null) {
            canvas.drawBitmap(overlayBitmap, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, p);
        }
        if (!isDrawingCacheEnabled) {
            v.setDrawingCacheEnabled(false);
        }
        return bitmap;
    }
}