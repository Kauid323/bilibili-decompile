package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lkntr/common/ouro/core/model/node/OpusParseResult;", "Lkntr/common/ouro/core/model/node/LinkParseResult;", "raw", "", "url", "title", "type", "", "bizId", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "getUrl", "getTitle", "getType", "()I", "getBizId", "getIcon", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OpusParseResult extends LinkParseResult {
    private final String bizId;
    private final String icon;
    private final String raw;
    private final String title;
    private final int type;
    private final String url;

    public static /* synthetic */ OpusParseResult copy$default(OpusParseResult opusParseResult, String str, String str2, String str3, int i, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = opusParseResult.raw;
        }
        if ((i2 & 2) != 0) {
            str2 = opusParseResult.url;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = opusParseResult.title;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            i = opusParseResult.type;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = opusParseResult.bizId;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = opusParseResult.icon;
        }
        return opusParseResult.copy(str, str6, str7, i3, str8, str5);
    }

    public final String component1() {
        return this.raw;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.bizId;
    }

    public final String component6() {
        return this.icon;
    }

    public final OpusParseResult copy(String str, String str2, String str3, int i, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "raw");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "bizId");
        Intrinsics.checkNotNullParameter(str5, "icon");
        return new OpusParseResult(str, str2, str3, i, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OpusParseResult) {
            OpusParseResult opusParseResult = (OpusParseResult) obj;
            return Intrinsics.areEqual(this.raw, opusParseResult.raw) && Intrinsics.areEqual(this.url, opusParseResult.url) && Intrinsics.areEqual(this.title, opusParseResult.title) && this.type == opusParseResult.type && Intrinsics.areEqual(this.bizId, opusParseResult.bizId) && Intrinsics.areEqual(this.icon, opusParseResult.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.raw.hashCode() * 31) + this.url.hashCode()) * 31) + this.title.hashCode()) * 31) + this.type) * 31) + this.bizId.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        String str = this.raw;
        String str2 = this.url;
        String str3 = this.title;
        int i = this.type;
        String str4 = this.bizId;
        return "OpusParseResult(raw=" + str + ", url=" + str2 + ", title=" + str3 + ", type=" + i + ", bizId=" + str4 + ", icon=" + this.icon + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpusParseResult(String raw, String url, String title, int type, String bizId, String icon) {
        super(null);
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.raw = raw;
        this.url = url;
        this.title = title;
        this.type = type;
        this.bizId = bizId;
        this.icon = icon;
    }

    @Override // kntr.common.ouro.core.model.node.RemoteParseResult
    public String getRaw() {
        return this.raw;
    }

    @Override // kntr.common.ouro.core.model.node.RemoteParseResult
    public String getUrl() {
        return this.url;
    }

    @Override // kntr.common.ouro.core.model.node.LinkParseResult
    public String getTitle() {
        return this.title;
    }

    @Override // kntr.common.ouro.core.model.node.LinkParseResult
    public int getType() {
        return this.type;
    }

    @Override // kntr.common.ouro.core.model.node.LinkParseResult
    public String getBizId() {
        return this.bizId;
    }

    @Override // kntr.common.ouro.core.model.node.LinkParseResult
    public String getIcon() {
        return this.icon;
    }
}