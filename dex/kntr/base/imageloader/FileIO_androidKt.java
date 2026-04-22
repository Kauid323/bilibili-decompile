package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileIO.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"readFileAsByteArray", "", "path", "", "getCacheDirectory", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FileIO_androidKt {
    public static final byte[] readFileAsByteArray(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new NotImplementedError("An operation is not implemented: 安卓还用不到");
    }

    public static final String getCacheDirectory() {
        throw new NotImplementedError("An operation is not implemented: 安卓还用不到");
    }
}