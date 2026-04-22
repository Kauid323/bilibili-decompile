package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/model/node/EmoteParseResult;", "Lkntr/common/ouro/core/model/node/RemoteParseResult;", "raw", "", "url", "emoteSize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "getUrl", "getEmoteSize", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EmoteParseResult extends RemoteParseResult {
    private final String emoteSize;
    private final String raw;
    private final String url;

    public static /* synthetic */ EmoteParseResult copy$default(EmoteParseResult emoteParseResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emoteParseResult.raw;
        }
        if ((i & 2) != 0) {
            str2 = emoteParseResult.url;
        }
        if ((i & 4) != 0) {
            str3 = emoteParseResult.emoteSize;
        }
        return emoteParseResult.copy(str, str2, str3);
    }

    public final String component1() {
        return this.raw;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.emoteSize;
    }

    public final EmoteParseResult copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "raw");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "emoteSize");
        return new EmoteParseResult(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmoteParseResult) {
            EmoteParseResult emoteParseResult = (EmoteParseResult) obj;
            return Intrinsics.areEqual(this.raw, emoteParseResult.raw) && Intrinsics.areEqual(this.url, emoteParseResult.url) && Intrinsics.areEqual(this.emoteSize, emoteParseResult.emoteSize);
        }
        return false;
    }

    public int hashCode() {
        return (((this.raw.hashCode() * 31) + this.url.hashCode()) * 31) + this.emoteSize.hashCode();
    }

    public String toString() {
        String str = this.raw;
        String str2 = this.url;
        return "EmoteParseResult(raw=" + str + ", url=" + str2 + ", emoteSize=" + this.emoteSize + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmoteParseResult(String raw, String url, String emoteSize) {
        super(null);
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(emoteSize, "emoteSize");
        this.raw = raw;
        this.url = url;
        this.emoteSize = emoteSize;
    }

    @Override // kntr.common.ouro.core.model.node.RemoteParseResult
    public String getRaw() {
        return this.raw;
    }

    @Override // kntr.common.ouro.core.model.node.RemoteParseResult
    public String getUrl() {
        return this.url;
    }

    public final String getEmoteSize() {
        return this.emoteSize;
    }
}