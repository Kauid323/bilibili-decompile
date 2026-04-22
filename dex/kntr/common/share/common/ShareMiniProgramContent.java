package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareContent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lkntr/common/share/common/ShareMiniProgramContent;", "", "identifier", "", "path", "header", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "getPath", "getHeader", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMiniProgramContent {
    public static final int $stable = 0;
    private final String header;
    private final String identifier;
    private final String path;

    public static /* synthetic */ ShareMiniProgramContent copy$default(ShareMiniProgramContent shareMiniProgramContent, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareMiniProgramContent.identifier;
        }
        if ((i & 2) != 0) {
            str2 = shareMiniProgramContent.path;
        }
        if ((i & 4) != 0) {
            str3 = shareMiniProgramContent.header;
        }
        return shareMiniProgramContent.copy(str, str2, str3);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.header;
    }

    public final ShareMiniProgramContent copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "path");
        return new ShareMiniProgramContent(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareMiniProgramContent) {
            ShareMiniProgramContent shareMiniProgramContent = (ShareMiniProgramContent) obj;
            return Intrinsics.areEqual(this.identifier, shareMiniProgramContent.identifier) && Intrinsics.areEqual(this.path, shareMiniProgramContent.path) && Intrinsics.areEqual(this.header, shareMiniProgramContent.header);
        }
        return false;
    }

    public int hashCode() {
        return (((this.identifier.hashCode() * 31) + this.path.hashCode()) * 31) + (this.header == null ? 0 : this.header.hashCode());
    }

    public String toString() {
        String str = this.identifier;
        String str2 = this.path;
        return "ShareMiniProgramContent(identifier=" + str + ", path=" + str2 + ", header=" + this.header + ")";
    }

    public ShareMiniProgramContent(String identifier, String path, String header) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(path, "path");
        this.identifier = identifier;
        this.path = path;
        this.header = header;
    }

    public /* synthetic */ ShareMiniProgramContent(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getHeader() {
        return this.header;
    }
}