package kntr.base.avif.decoder;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import java.nio.ByteBuffer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.avif.jni.NativeAvifDecoder;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AvifDecoder.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "decodeAvif", "Lkntr/base/avif/decoder/AvifImage;", "data", "", "isAvifAnimated", "", "isAvifFormat", "avif_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvifDecoder_androidKt {
    private static final String TAG = "AvifDecoder";

    public static final AvifImage decodeAvif(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!NativeAvifDecoder.INSTANCE.getSoLoaderSuccess()) {
            KLog_androidKt.getKLog().e("AvifDecoder", "AVIF decoder library not loaded");
            return null;
        }
        ByteBuffer buffer = ByteBuffer.allocateDirect(data.length);
        buffer.put(data);
        buffer.rewind();
        NativeAvifDecoder.Info info = new NativeAvifDecoder.Info(0, 0, 0, false, 15, null);
        if (!NativeAvifDecoder.INSTANCE.getInfo(buffer, data.length, info)) {
            KLog_androidKt.getKLog().e("AvifDecoder", "Failed to get AVIF image info");
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(info.getWidth(), info.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(...)");
        buffer.rewind();
        int threadCount = RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors(), 1);
        boolean success = NativeAvifDecoder.INSTANCE.decode(buffer, data.length, bitmap, threadCount);
        if (!success) {
            bitmap.recycle();
            KLog_androidKt.getKLog().e("AvifDecoder", "Failed to decode AVIF image");
            return null;
        }
        return new AvifImage(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), info.getWidth(), info.getHeight(), info.getDepth(), info.getAlphaPresent());
    }

    public static final boolean isAvifAnimated(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        KLog_androidKt.getKLog().w("AvifDecoder", "AVIF animation detection not yet implemented");
        return false;
    }

    public static final boolean isAvifFormat(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (NativeAvifDecoder.INSTANCE.getSoLoaderSuccess()) {
            if (!(data.length == 0)) {
                try {
                    ByteBuffer buffer = ByteBuffer.allocateDirect(data.length);
                    buffer.put(data);
                    buffer.rewind();
                    return NativeAvifDecoder.INSTANCE.isAvifImage(buffer, data.length);
                } catch (Exception e) {
                    KLog_androidKt.getKLog().e("AvifDecoder", "Failed to check AVIF format", e);
                    return false;
                }
            }
        }
        return false;
    }
}