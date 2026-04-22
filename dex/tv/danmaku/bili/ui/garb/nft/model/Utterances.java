package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCSubtitles.kt */
@Bson
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/Utterances;", "", "endTime", "", "startTime", "transcript", "", "<init>", "(IILjava/lang/String;)V", "getEndTime", "()I", "getStartTime", "getTranscript", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Utterances {
    public static final int $stable = 0;
    @SerializedName("end_time")
    private final int endTime;
    @SerializedName("start_time")
    private final int startTime;
    @SerializedName("transcript")
    private final String transcript;

    public static /* synthetic */ Utterances copy$default(Utterances utterances, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = utterances.endTime;
        }
        if ((i3 & 2) != 0) {
            i2 = utterances.startTime;
        }
        if ((i3 & 4) != 0) {
            str = utterances.transcript;
        }
        return utterances.copy(i, i2, str);
    }

    public final int component1() {
        return this.endTime;
    }

    public final int component2() {
        return this.startTime;
    }

    public final String component3() {
        return this.transcript;
    }

    public final Utterances copy(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "transcript");
        return new Utterances(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Utterances) {
            Utterances utterances = (Utterances) obj;
            return this.endTime == utterances.endTime && this.startTime == utterances.startTime && Intrinsics.areEqual(this.transcript, utterances.transcript);
        }
        return false;
    }

    public int hashCode() {
        return (((this.endTime * 31) + this.startTime) * 31) + this.transcript.hashCode();
    }

    public String toString() {
        int i = this.endTime;
        int i2 = this.startTime;
        return "Utterances(endTime=" + i + ", startTime=" + i2 + ", transcript=" + this.transcript + ")";
    }

    public Utterances(int endTime, int startTime, String transcript) {
        Intrinsics.checkNotNullParameter(transcript, "transcript");
        this.endTime = endTime;
        this.startTime = startTime;
        this.transcript = transcript;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final String getTranscript() {
        return this.transcript;
    }
}