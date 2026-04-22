package tv.danmaku.bili.push.innerpush.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushUploadMessage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/push/innerpush/model/InnerPushUploadMessage;", "", "job", "", "bid", "", "<init>", "(JI)V", "getJob", "()J", "setJob", "(J)V", "getBid", "()I", "setBid", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushUploadMessage {
    public static final int $stable = 8;
    @SerializedName("bid")
    private int bid;
    @SerializedName("job")
    private long job;

    public InnerPushUploadMessage() {
        this(0L, 0, 3, null);
    }

    public static /* synthetic */ InnerPushUploadMessage copy$default(InnerPushUploadMessage innerPushUploadMessage, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = innerPushUploadMessage.job;
        }
        if ((i2 & 2) != 0) {
            i = innerPushUploadMessage.bid;
        }
        return innerPushUploadMessage.copy(j, i);
    }

    public final long component1() {
        return this.job;
    }

    public final int component2() {
        return this.bid;
    }

    public final InnerPushUploadMessage copy(long j, int i) {
        return new InnerPushUploadMessage(j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InnerPushUploadMessage) {
            InnerPushUploadMessage innerPushUploadMessage = (InnerPushUploadMessage) obj;
            return this.job == innerPushUploadMessage.job && this.bid == innerPushUploadMessage.bid;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.job) * 31) + this.bid;
    }

    public String toString() {
        long j = this.job;
        return "InnerPushUploadMessage(job=" + j + ", bid=" + this.bid + ")";
    }

    public InnerPushUploadMessage(long job, int bid) {
        this.job = job;
        this.bid = bid;
    }

    public /* synthetic */ InnerPushUploadMessage(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0 : i);
    }

    public final long getJob() {
        return this.job;
    }

    public final void setJob(long j) {
        this.job = j;
    }

    public final int getBid() {
        return this.bid;
    }

    public final void setBid(int i) {
        this.bid = i;
    }
}