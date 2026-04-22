package kntr.common.ouro.core.pasteboard;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pasteboard.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/pasteboard/PasteboardData;", "", "text", "", "bytes", "", "<init>", "(Ljava/lang/String;[B)V", "getText", "()Ljava/lang/String;", "getBytes", "()[B", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PasteboardData {
    private final byte[] bytes;
    private final String text;

    public PasteboardData(String text, byte[] bytes) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.bytes = bytes;
    }

    public final String getText() {
        return this.text;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }
}