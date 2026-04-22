package tv.danmaku.bili.qrcode;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.qrcode.QrcodeService;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class QrCodeHelper {
    public static final String URI_SCAN = "bilibili://qrcode";

    public static Bitmap generate(String source, int bitmapWidth, int bitmapHeight, int color) {
        QrcodeService qrcodeService;
        if (TextUtils.isEmpty(source) || (qrcodeService = (QrcodeService) BLRouter.INSTANCE.getServices(QrcodeService.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT)) == null) {
            return null;
        }
        return qrcodeService.generateBitmap(source, bitmapWidth, bitmapHeight, color);
    }
}