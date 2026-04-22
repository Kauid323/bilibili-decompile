package tv.danmaku.video.bilicardplayer.utils;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/video/bilicardplayer/utils/ChronosUtils;", "", "<init>", "()V", "bitmapToRgba", "", "bitmap", "Landroid/graphics/Bitmap;", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosUtils {
    public static final ChronosUtils INSTANCE = new ChronosUtils();

    private ChronosUtils() {
    }

    public final byte[] bitmapToRgba(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        byte[] bytes = new byte[pixels.length * 4];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = 0;
        for (int pixel : pixels) {
            int A = (pixel >> 24) & 255;
            int R = (pixel >> 16) & 255;
            int G = (pixel >> 8) & 255;
            int B = pixel & 255;
            int i2 = i + 1;
            bytes[i] = (byte) R;
            int i3 = i2 + 1;
            bytes[i2] = (byte) G;
            int i4 = i3 + 1;
            bytes[i3] = (byte) B;
            i = i4 + 1;
            bytes[i4] = (byte) A;
        }
        return bytes;
    }
}