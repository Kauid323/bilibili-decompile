package tv.danmaku.bili.ui.personinfo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.qrcode.QrcodeService;

/* JADX INFO: Access modifiers changed from: package-private */
public final class QrCodeHelper {
    QrCodeHelper() {
    }

    public static Bitmap generate(String source, int bitmapWidth, int bitmapHeight, int color) {
        QrcodeService qrcodeService;
        if (TextUtils.isEmpty(source) || (qrcodeService = (QrcodeService) BLRouter.INSTANCE.getServices(QrcodeService.class).get("default")) == null) {
            return null;
        }
        return qrcodeService.generateBitmap(source, bitmapWidth, bitmapHeight, color);
    }
}