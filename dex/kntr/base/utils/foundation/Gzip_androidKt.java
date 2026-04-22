package kntr.base.utils.foundation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gzip.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"zip", "", "data", "unzip", "zipped", "foundation_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Gzip_androidKt {
    public static final byte[] zip(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            GZIPOutputStream gos = gZIPOutputStream;
            gos.write(data);
            gos.finish();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(gZIPOutputStream, (Throwable) null);
            byte[] byteArray = outputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        } finally {
        }
    }

    public static final byte[] unzip(byte[] zipped) {
        Intrinsics.checkNotNullParameter(zipped, "zipped");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(zipped);
        return ByteStreamsKt.readBytes(new GZIPInputStream(inputStream));
    }
}