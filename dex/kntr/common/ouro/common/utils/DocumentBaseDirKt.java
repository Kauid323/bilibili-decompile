package kntr.common.ouro.common.utils;

import com.bilibili.lib.foundation.FoundationAlias;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentBaseDir.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"documentBaseDir", "", "utils_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DocumentBaseDirKt {
    public static final String documentBaseDir() {
        String path = FoundationAlias.getFapp().getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }
}