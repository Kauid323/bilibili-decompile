package kntr.app.tribee.publish.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/tribee/publish/service/PublishResult;", "", "dynId", "", "toast", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDynId", "()Ljava/lang/String;", "getToast", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PublishResult {
    private final String dynId;
    private final String toast;

    public static /* synthetic */ PublishResult copy$default(PublishResult publishResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publishResult.dynId;
        }
        if ((i & 2) != 0) {
            str2 = publishResult.toast;
        }
        return publishResult.copy(str, str2);
    }

    public final String component1() {
        return this.dynId;
    }

    public final String component2() {
        return this.toast;
    }

    public final PublishResult copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "dynId");
        return new PublishResult(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PublishResult) {
            PublishResult publishResult = (PublishResult) obj;
            return Intrinsics.areEqual(this.dynId, publishResult.dynId) && Intrinsics.areEqual(this.toast, publishResult.toast);
        }
        return false;
    }

    public int hashCode() {
        return (this.dynId.hashCode() * 31) + (this.toast == null ? 0 : this.toast.hashCode());
    }

    public String toString() {
        String str = this.dynId;
        return "PublishResult(dynId=" + str + ", toast=" + this.toast + ")";
    }

    public PublishResult(String dynId, String toast) {
        Intrinsics.checkNotNullParameter(dynId, "dynId");
        this.dynId = dynId;
        this.toast = toast;
    }

    public /* synthetic */ PublishResult(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getDynId() {
        return this.dynId;
    }

    public final String getToast() {
        return this.toast;
    }
}