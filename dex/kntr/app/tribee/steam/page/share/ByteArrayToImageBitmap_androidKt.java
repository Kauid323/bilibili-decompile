package kntr.app.tribee.steam.page.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayToImageBitmap.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"byteArrayToImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "byteArray", "", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ByteArrayToImageBitmap_androidKt {
    public static final ImageBitmap byteArrayToImageBitmap(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            Intrinsics.checkNotNullExpressionValue(decodeByteArray, "decodeByteArray(...)");
            return AndroidImageBitmap_androidKt.asImageBitmap(decodeByteArray);
        } catch (Exception e) {
            return null;
        }
    }
}