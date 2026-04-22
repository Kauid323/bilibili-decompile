package tv.danmaku.bili.push.innerpush.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushReplayMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Ltv/danmaku/bili/push/innerpush/model/InnerPushReplayMessage;", "", "job", "", "bid", "type", "", "filterType", "", "<init>", "(JJILjava/lang/String;)V", "getJob", "()J", "setJob", "(J)V", "getBid", "setBid", "getType", "()I", "setType", "(I)V", "getFilterType", "()Ljava/lang/String;", "setFilterType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushReplayMessage {
    public static final int $stable = 8;
    @SerializedName("bid")
    private long bid;
    @SerializedName("filter_type")
    private String filterType;
    @SerializedName("job")
    private long job;
    @SerializedName("type")
    private int type;

    public InnerPushReplayMessage() {
        this(0L, 0L, 0, null, 15, null);
    }

    public static /* synthetic */ InnerPushReplayMessage copy$default(InnerPushReplayMessage innerPushReplayMessage, long j, long j2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = innerPushReplayMessage.job;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = innerPushReplayMessage.bid;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = innerPushReplayMessage.type;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str = innerPushReplayMessage.filterType;
        }
        return innerPushReplayMessage.copy(j3, j4, i3, str);
    }

    public final long component1() {
        return this.job;
    }

    public final long component2() {
        return this.bid;
    }

    public final int component3() {
        return this.type;
    }

    public final String component4() {
        return this.filterType;
    }

    public final InnerPushReplayMessage copy(long j, long j2, int i, String str) {
        return new InnerPushReplayMessage(j, j2, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InnerPushReplayMessage) {
            InnerPushReplayMessage innerPushReplayMessage = (InnerPushReplayMessage) obj;
            return this.job == innerPushReplayMessage.job && this.bid == innerPushReplayMessage.bid && this.type == innerPushReplayMessage.type && Intrinsics.areEqual(this.filterType, innerPushReplayMessage.filterType);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.job) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.bid)) * 31) + this.type) * 31) + (this.filterType == null ? 0 : this.filterType.hashCode());
    }

    public String toString() {
        long j = this.job;
        long j2 = this.bid;
        int i = this.type;
        return "InnerPushReplayMessage(job=" + j + ", bid=" + j2 + ", type=" + i + ", filterType=" + this.filterType + ")";
    }

    public InnerPushReplayMessage(long job, long bid, int type, String filterType) {
        this.job = job;
        this.bid = bid;
        this.type = type;
        this.filterType = filterType;
    }

    public /* synthetic */ InnerPushReplayMessage(long j, long j2, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) == 0 ? j2 : 0L, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str);
    }

    public final long getJob() {
        return this.job;
    }

    public final void setJob(long j) {
        this.job = j;
    }

    public final long getBid() {
        return this.bid;
    }

    public final void setBid(long j) {
        this.bid = j;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getFilterType() {
        return this.filterType;
    }

    public final void setFilterType(String str) {
        this.filterType = str;
    }
}