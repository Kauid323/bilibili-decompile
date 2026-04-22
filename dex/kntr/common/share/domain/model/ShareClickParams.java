package kntr.common.share.domain.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareMode;
import kntr.common.share.common.ShareTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareOnlineParams.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006#"}, d2 = {"Lkntr/common/share/domain/model/ShareClickParams;", "", "mode", "Lkntr/common/share/common/ShareMode;", "target", "Lkntr/common/share/common/ShareTarget;", "title", "", "content", "pattern", "tid", "<init>", "(Lkntr/common/share/common/ShareMode;Lkntr/common/share/common/ShareTarget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Lkntr/common/share/common/ShareMode;", "getTarget", "()Lkntr/common/share/common/ShareTarget;", "getTitle", "()Ljava/lang/String;", "getContent", "getPattern", "getTid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareClickParams {
    public static final int $stable = ShareTarget.$stable;
    private final String content;
    private final ShareMode mode;
    private final String pattern;
    private final ShareTarget target;
    private final String tid;
    private final String title;

    public static /* synthetic */ ShareClickParams copy$default(ShareClickParams shareClickParams, ShareMode shareMode, ShareTarget shareTarget, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            shareMode = shareClickParams.mode;
        }
        if ((i & 2) != 0) {
            shareTarget = shareClickParams.target;
        }
        ShareTarget shareTarget2 = shareTarget;
        if ((i & 4) != 0) {
            str = shareClickParams.title;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = shareClickParams.content;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = shareClickParams.pattern;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = shareClickParams.tid;
        }
        return shareClickParams.copy(shareMode, shareTarget2, str5, str6, str7, str4);
    }

    public final ShareMode component1() {
        return this.mode;
    }

    public final ShareTarget component2() {
        return this.target;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.pattern;
    }

    public final String component6() {
        return this.tid;
    }

    public final ShareClickParams copy(ShareMode shareMode, ShareTarget shareTarget, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(shareMode, "mode");
        Intrinsics.checkNotNullParameter(shareTarget, "target");
        return new ShareClickParams(shareMode, shareTarget, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareClickParams) {
            ShareClickParams shareClickParams = (ShareClickParams) obj;
            return this.mode == shareClickParams.mode && Intrinsics.areEqual(this.target, shareClickParams.target) && Intrinsics.areEqual(this.title, shareClickParams.title) && Intrinsics.areEqual(this.content, shareClickParams.content) && Intrinsics.areEqual(this.pattern, shareClickParams.pattern) && Intrinsics.areEqual(this.tid, shareClickParams.tid);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.mode.hashCode() * 31) + this.target.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.content == null ? 0 : this.content.hashCode())) * 31) + (this.pattern == null ? 0 : this.pattern.hashCode())) * 31) + (this.tid != null ? this.tid.hashCode() : 0);
    }

    public String toString() {
        ShareMode shareMode = this.mode;
        ShareTarget shareTarget = this.target;
        String str = this.title;
        String str2 = this.content;
        String str3 = this.pattern;
        return "ShareClickParams(mode=" + shareMode + ", target=" + shareTarget + ", title=" + str + ", content=" + str2 + ", pattern=" + str3 + ", tid=" + this.tid + ")";
    }

    public ShareClickParams(ShareMode mode, ShareTarget target, String title, String content, String pattern, String tid) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mode = mode;
        this.target = target;
        this.title = title;
        this.content = content;
        this.pattern = pattern;
        this.tid = tid;
    }

    public /* synthetic */ ShareClickParams(ShareMode shareMode, ShareTarget shareTarget, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shareMode, shareTarget, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final ShareMode getMode() {
        return this.mode;
    }

    public final ShareTarget getTarget() {
        return this.target;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final String getTid() {
        return this.tid;
    }
}