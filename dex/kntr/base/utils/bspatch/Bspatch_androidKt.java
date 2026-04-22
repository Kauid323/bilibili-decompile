package kntr.base.utils.bspatch;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bspatch.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¨\u0006\u0006"}, d2 = {"patchNative", "", "oldFilePath", "", "newFilePath", "patchFilePath", "bspatch_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Bspatch_androidKt {
    public static final int patchNative(String oldFilePath, String newFilePath, String patchFilePath) {
        Intrinsics.checkNotNullParameter(oldFilePath, "oldFilePath");
        Intrinsics.checkNotNullParameter(newFilePath, "newFilePath");
        Intrinsics.checkNotNullParameter(patchFilePath, "patchFilePath");
        return NativeBsPatch.patch(oldFilePath, newFilePath, patchFilePath);
    }
}