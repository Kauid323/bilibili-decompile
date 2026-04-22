package kntr.app.digital.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterParams.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jo\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lkntr/app/digital/preview/RouterParams;", RoomRecommendViewModel.EMPTY_CURSOR, "actId", RoomRecommendViewModel.EMPTY_CURSOR, "vmid", RoomRecommendViewModel.EMPTY_CURSOR, "anchorId", RoomRecommendViewModel.EMPTY_CURSOR, "lotteryId", "extra", "direction", "fSource", "from", "fromId", "simpleCard", "Lkntr/app/digital/preview/SimpleCard;", "<init>", "(IJLjava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/digital/preview/SimpleCard;)V", "getActId", "()I", "getVmid", "()J", "getAnchorId", "()Ljava/lang/String;", "getLotteryId", "getExtra", "getDirection", "getFSource", "getFrom", "getFromId", "getSimpleCard", "()Lkntr/app/digital/preview/SimpleCard;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RouterParams {
    public static final int $stable = 0;
    private final int actId;
    private final String anchorId;
    private final int direction;
    private final String extra;
    private final String fSource;
    private final String from;
    private final String fromId;
    private final long lotteryId;
    private final SimpleCard simpleCard;
    private final long vmid;

    public final int component1() {
        return this.actId;
    }

    public final SimpleCard component10() {
        return this.simpleCard;
    }

    public final long component2() {
        return this.vmid;
    }

    public final String component3() {
        return this.anchorId;
    }

    public final long component4() {
        return this.lotteryId;
    }

    public final String component5() {
        return this.extra;
    }

    public final int component6() {
        return this.direction;
    }

    public final String component7() {
        return this.fSource;
    }

    public final String component8() {
        return this.from;
    }

    public final String component9() {
        return this.fromId;
    }

    public final RouterParams copy(int i, long j2, String str, long j3, String str2, int i2, String str3, String str4, String str5, SimpleCard simpleCard) {
        Intrinsics.checkNotNullParameter(str, "anchorId");
        Intrinsics.checkNotNullParameter(str2, "extra");
        Intrinsics.checkNotNullParameter(str3, "fSource");
        Intrinsics.checkNotNullParameter(str4, "from");
        Intrinsics.checkNotNullParameter(str5, "fromId");
        return new RouterParams(i, j2, str, j3, str2, i2, str3, str4, str5, simpleCard);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RouterParams) {
            RouterParams routerParams = (RouterParams) obj;
            return this.actId == routerParams.actId && this.vmid == routerParams.vmid && Intrinsics.areEqual(this.anchorId, routerParams.anchorId) && this.lotteryId == routerParams.lotteryId && Intrinsics.areEqual(this.extra, routerParams.extra) && this.direction == routerParams.direction && Intrinsics.areEqual(this.fSource, routerParams.fSource) && Intrinsics.areEqual(this.from, routerParams.from) && Intrinsics.areEqual(this.fromId, routerParams.fromId) && Intrinsics.areEqual(this.simpleCard, routerParams.simpleCard);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.actId * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.vmid)) * 31) + this.anchorId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.lotteryId)) * 31) + this.extra.hashCode()) * 31) + this.direction) * 31) + this.fSource.hashCode()) * 31) + this.from.hashCode()) * 31) + this.fromId.hashCode()) * 31) + (this.simpleCard == null ? 0 : this.simpleCard.hashCode());
    }

    public String toString() {
        int i = this.actId;
        long j2 = this.vmid;
        String str = this.anchorId;
        long j3 = this.lotteryId;
        String str2 = this.extra;
        int i2 = this.direction;
        String str3 = this.fSource;
        String str4 = this.from;
        String str5 = this.fromId;
        return "RouterParams(actId=" + i + ", vmid=" + j2 + ", anchorId=" + str + ", lotteryId=" + j3 + ", extra=" + str2 + ", direction=" + i2 + ", fSource=" + str3 + ", from=" + str4 + ", fromId=" + str5 + ", simpleCard=" + this.simpleCard + ")";
    }

    public RouterParams(int actId, long vmid, String anchorId, long lotteryId, String extra, int direction, String fSource, String from, String fromId, SimpleCard simpleCard) {
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        this.actId = actId;
        this.vmid = vmid;
        this.anchorId = anchorId;
        this.lotteryId = lotteryId;
        this.extra = extra;
        this.direction = direction;
        this.fSource = fSource;
        this.from = from;
        this.fromId = fromId;
        this.simpleCard = simpleCard;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RouterParams(int i, long j2, String str, long j3, String str2, int i2, String str3, String str4, String str5, SimpleCard simpleCard, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, j2, str, j3, str2, i2, str3, str4, str5, r13);
        SimpleCard simpleCard2;
        if ((i3 & 512) == 0) {
            simpleCard2 = simpleCard;
        } else {
            simpleCard2 = null;
        }
    }

    public final int getActId() {
        return this.actId;
    }

    public final long getVmid() {
        return this.vmid;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final long getLotteryId() {
        return this.lotteryId;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final String getFSource() {
        return this.fSource;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getFromId() {
        return this.fromId;
    }

    public final SimpleCard getSimpleCard() {
        return this.simpleCard;
    }
}