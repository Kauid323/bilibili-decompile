package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\f¨\u0006 "}, d2 = {"Lkntr/common/ouro/core/model/node/WhitelistUrlParseResult;", "Lkntr/common/ouro/core/model/node/LinkParseResult;", "raw", "", "url", "title", "type", "", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "getUrl", "getTitle", "getType", "()I", "getIcon", "bizId", "getBizId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WhitelistUrlParseResult extends LinkParseResult {
    private final String icon;
    private final String raw;
    private final String title;
    private final int type;
    private final String url;

    public static /* synthetic */ WhitelistUrlParseResult copy$default(WhitelistUrlParseResult whitelistUrlParseResult, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = whitelistUrlParseResult.raw;
        }
        if ((i2 & 2) != 0) {
            str2 = whitelistUrlParseResult.url;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = whitelistUrlParseResult.title;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = whitelistUrlParseResult.type;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = whitelistUrlParseResult.icon;
        }
        return whitelistUrlParseResult.copy(str, str5, str6, i3, str4);
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
        return this.icon;
    }

    public final WhitelistUrlParseResult copy(String str, String str2, String str3, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "raw");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "icon");
        return new WhitelistUrlParseResult(str, str2, str3, i, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WhitelistUrlParseResult) {
            WhitelistUrlParseResult whitelistUrlParseResult = (WhitelistUrlParseResult) obj;
            return Intrinsics.areEqual(this.raw, whitelistUrlParseResult.raw) && Intrinsics.areEqual(this.url, whitelistUrlParseResult.url) && Intrinsics.areEqual(this.title, whitelistUrlParseResult.title) && this.type == whitelistUrlParseResult.type && Intrinsics.areEqual(this.icon, whitelistUrlParseResult.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.raw.hashCode() * 31) + this.url.hashCode()) * 31) + this.title.hashCode()) * 31) + this.type) * 31) + this.icon.hashCode();
    }

    public String toString() {
        String str = this.raw;
        String str2 = this.url;
        String str3 = this.title;
        int i = this.type;
        return "WhitelistUrlParseResult(raw=" + str + ", url=" + str2 + ", title=" + str3 + ", type=" + i + ", icon=" + this.icon + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WhitelistUrlParseResult(String raw, String url, String title, int type, String icon) {
        super(null);
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.raw = raw;
        this.url = url;
        this.title = title;
        this.type = type;
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
    public String getIcon() {
        return this.icon;
    }

    @Override // kntr.common.ouro.core.model.node.LinkParseResult
    public String getBizId() {
        return "";
    }
}