package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DLCSubtitles.kt */
@Bson
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCSubtitles;", "", "utterances", "", "Ltv/danmaku/bili/ui/garb/nft/model/Utterances;", "<init>", "(Ljava/util/List;)V", "getUtterances", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCSubtitles {
    public static final int $stable = 8;
    @SerializedName("utterances")
    private final List<Utterances> utterances;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DLCSubtitles copy$default(DLCSubtitles dLCSubtitles, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dLCSubtitles.utterances;
        }
        return dLCSubtitles.copy(list);
    }

    public final List<Utterances> component1() {
        return this.utterances;
    }

    public final DLCSubtitles copy(List<Utterances> list) {
        Intrinsics.checkNotNullParameter(list, "utterances");
        return new DLCSubtitles(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DLCSubtitles) && Intrinsics.areEqual(this.utterances, ((DLCSubtitles) obj).utterances);
    }

    public int hashCode() {
        return this.utterances.hashCode();
    }

    public String toString() {
        return "DLCSubtitles(utterances=" + this.utterances + ")";
    }

    public DLCSubtitles(List<Utterances> list) {
        Intrinsics.checkNotNullParameter(list, "utterances");
        this.utterances = list;
    }

    public final List<Utterances> getUtterances() {
        return this.utterances;
    }
}