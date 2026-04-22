package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GShare.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/share/common/ShareRawResult;", "", "result", "Lkntr/common/share/common/ShareResult;", "errorMessage", "", "<init>", "(Lkntr/common/share/common/ShareResult;Ljava/lang/String;)V", "getResult", "()Lkntr/common/share/common/ShareResult;", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareRawResult {
    public static final int $stable = 0;
    private final String errorMessage;
    private final ShareResult result;

    public ShareRawResult() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ShareRawResult copy$default(ShareRawResult shareRawResult, ShareResult shareResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            shareResult = shareRawResult.result;
        }
        if ((i & 2) != 0) {
            str = shareRawResult.errorMessage;
        }
        return shareRawResult.copy(shareResult, str);
    }

    public final ShareResult component1() {
        return this.result;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final ShareRawResult copy(ShareResult shareResult, String str) {
        Intrinsics.checkNotNullParameter(shareResult, "result");
        return new ShareRawResult(shareResult, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareRawResult) {
            ShareRawResult shareRawResult = (ShareRawResult) obj;
            return this.result == shareRawResult.result && Intrinsics.areEqual(this.errorMessage, shareRawResult.errorMessage);
        }
        return false;
    }

    public int hashCode() {
        return (this.result.hashCode() * 31) + (this.errorMessage == null ? 0 : this.errorMessage.hashCode());
    }

    public String toString() {
        ShareResult shareResult = this.result;
        return "ShareRawResult(result=" + shareResult + ", errorMessage=" + this.errorMessage + ")";
    }

    public ShareRawResult(ShareResult result, String errorMessage) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public /* synthetic */ ShareRawResult(ShareResult shareResult, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ShareResult.Success : shareResult, (i & 2) != 0 ? null : str);
    }

    public final ShareResult getResult() {
        return this.result;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}