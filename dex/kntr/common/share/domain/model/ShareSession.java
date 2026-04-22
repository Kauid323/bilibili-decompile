package kntr.common.share.domain.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareParams;
import kntr.common.share.common.UtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareOnlineParams.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lkntr/common/share/domain/model/ShareSession;", "", "params", "Lkntr/common/share/common/ShareParams;", "identifier", "", "actionId", "pageType", "<init>", "(Lkntr/common/share/common/ShareParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParams", "()Lkntr/common/share/common/ShareParams;", "getIdentifier", "()Ljava/lang/String;", "getActionId", "getPageType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareSession {
    public static final int $stable = ShareParams.$stable;
    private final String actionId;
    private final String identifier;
    private final String pageType;
    private final ShareParams params;

    public static /* synthetic */ ShareSession copy$default(ShareSession shareSession, ShareParams shareParams, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            shareParams = shareSession.params;
        }
        if ((i & 2) != 0) {
            str = shareSession.identifier;
        }
        if ((i & 4) != 0) {
            str2 = shareSession.actionId;
        }
        if ((i & 8) != 0) {
            str3 = shareSession.pageType;
        }
        return shareSession.copy(shareParams, str, str2, str3);
    }

    public final ShareParams component1() {
        return this.params;
    }

    public final String component2() {
        return this.identifier;
    }

    public final String component3() {
        return this.actionId;
    }

    public final String component4() {
        return this.pageType;
    }

    public final ShareSession copy(ShareParams shareParams, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(shareParams, "params");
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "actionId");
        Intrinsics.checkNotNullParameter(str3, "pageType");
        return new ShareSession(shareParams, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareSession) {
            ShareSession shareSession = (ShareSession) obj;
            return Intrinsics.areEqual(this.params, shareSession.params) && Intrinsics.areEqual(this.identifier, shareSession.identifier) && Intrinsics.areEqual(this.actionId, shareSession.actionId) && Intrinsics.areEqual(this.pageType, shareSession.pageType);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.params.hashCode() * 31) + this.identifier.hashCode()) * 31) + this.actionId.hashCode()) * 31) + this.pageType.hashCode();
    }

    public String toString() {
        ShareParams shareParams = this.params;
        String str = this.identifier;
        String str2 = this.actionId;
        return "ShareSession(params=" + shareParams + ", identifier=" + str + ", actionId=" + str2 + ", pageType=" + this.pageType + ")";
    }

    public ShareSession(ShareParams params, String identifier, String actionId, String pageType) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        this.params = params;
        this.identifier = identifier;
        this.actionId = actionId;
        this.pageType = pageType;
    }

    public /* synthetic */ ShareSession(ShareParams shareParams, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(shareParams, (i & 2) != 0 ? UtilKt.generateUUID() : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "1" : str3);
    }

    public final ShareParams getParams() {
        return this.params;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final String getPageType() {
        return this.pageType;
    }
}