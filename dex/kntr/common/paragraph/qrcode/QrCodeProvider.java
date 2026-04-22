package kntr.common.paragraph.qrcode;

import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCodeProvider.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0016J0\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/common/paragraph/qrcode/QrCodeProvider;", "", "getQrCodeImageData", "", "qrCodeString", "", "bitmapWidth", "", "bitmapHeight", "color", "getQrCodeImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "qrcode_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface QrCodeProvider {
    ImageBitmap getQrCodeImage(String str, int i, int i2, int i3);

    byte[] getQrCodeImageData(String str, int i, int i2, int i3);

    /* compiled from: QrCodeProvider.kt */
    /* renamed from: kntr.common.paragraph.qrcode.QrCodeProvider$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ byte[] getQrCodeImageData$default(QrCodeProvider qrCodeProvider, String str, int i, int i2, int i3, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    i = 400;
                }
                if ((i4 & 4) != 0) {
                    i2 = 400;
                }
                if ((i4 & 8) != 0) {
                    i3 = -16777216;
                }
                return qrCodeProvider.getQrCodeImageData(str, i, i2, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQrCodeImageData");
        }

        public static byte[] $default$getQrCodeImageData(QrCodeProvider _this, String qrCodeString, int bitmapWidth, int bitmapHeight, int color) {
            Intrinsics.checkNotNullParameter(qrCodeString, "qrCodeString");
            return null;
        }

        public static /* synthetic */ ImageBitmap getQrCodeImage$default(QrCodeProvider qrCodeProvider, String str, int i, int i2, int i3, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    i = 400;
                }
                if ((i4 & 4) != 0) {
                    i2 = 400;
                }
                if ((i4 & 8) != 0) {
                    i3 = -16777216;
                }
                return qrCodeProvider.getQrCodeImage(str, i, i2, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQrCodeImage");
        }

        public static ImageBitmap $default$getQrCodeImage(QrCodeProvider _this, String qrCodeString, int bitmapWidth, int bitmapHeight, int color) {
            Intrinsics.checkNotNullParameter(qrCodeString, "qrCodeString");
            return null;
        }
    }

    /* compiled from: QrCodeProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static byte[] getQrCodeImageData(QrCodeProvider $this, String qrCodeString, int bitmapWidth, int bitmapHeight, int color) {
            Intrinsics.checkNotNullParameter(qrCodeString, "qrCodeString");
            return CC.$default$getQrCodeImageData($this, qrCodeString, bitmapWidth, bitmapHeight, color);
        }

        @Deprecated
        public static ImageBitmap getQrCodeImage(QrCodeProvider $this, String qrCodeString, int bitmapWidth, int bitmapHeight, int color) {
            Intrinsics.checkNotNullParameter(qrCodeString, "qrCodeString");
            return CC.$default$getQrCodeImage($this, qrCodeString, bitmapWidth, bitmapHeight, color);
        }
    }
}