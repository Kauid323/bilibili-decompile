package kntr.app.game.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lkntr/app/game/bean/ProgressInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "completedCount", RoomRecommendViewModel.EMPTY_CURSOR, "totalCount", "progressPercent", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCompletedCount$annotations", "()V", "getCompletedCount", "()I", "getTotalCount$annotations", "getTotalCount", "getProgressPercent$annotations", "getProgressPercent", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ProgressInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int completedCount;
    private final String progressPercent;
    private final int totalCount;

    public ProgressInfo() {
        this(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ProgressInfo copy$default(ProgressInfo progressInfo, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = progressInfo.completedCount;
        }
        if ((i3 & 2) != 0) {
            i2 = progressInfo.totalCount;
        }
        if ((i3 & 4) != 0) {
            str = progressInfo.progressPercent;
        }
        return progressInfo.copy(i, i2, str);
    }

    @SerialName("completed_count")
    public static /* synthetic */ void getCompletedCount$annotations() {
    }

    @SerialName("progress_percent")
    public static /* synthetic */ void getProgressPercent$annotations() {
    }

    @SerialName("total_count")
    public static /* synthetic */ void getTotalCount$annotations() {
    }

    public final int component1() {
        return this.completedCount;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final String component3() {
        return this.progressPercent;
    }

    public final ProgressInfo copy(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "progressPercent");
        return new ProgressInfo(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProgressInfo) {
            ProgressInfo progressInfo = (ProgressInfo) obj;
            return this.completedCount == progressInfo.completedCount && this.totalCount == progressInfo.totalCount && Intrinsics.areEqual(this.progressPercent, progressInfo.progressPercent);
        }
        return false;
    }

    public int hashCode() {
        return (((this.completedCount * 31) + this.totalCount) * 31) + this.progressPercent.hashCode();
    }

    public String toString() {
        int i = this.completedCount;
        int i2 = this.totalCount;
        return "ProgressInfo(completedCount=" + i + ", totalCount=" + i2 + ", progressPercent=" + this.progressPercent + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/ProgressInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/ProgressInfo;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProgressInfo> serializer() {
            return ProgressInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ProgressInfo(int seen0, int completedCount, int totalCount, String progressPercent, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.completedCount = 0;
        } else {
            this.completedCount = completedCount;
        }
        if ((seen0 & 2) == 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
        if ((seen0 & 4) == 0) {
            this.progressPercent = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.progressPercent = progressPercent;
        }
    }

    public ProgressInfo(int completedCount, int totalCount, String progressPercent) {
        Intrinsics.checkNotNullParameter(progressPercent, "progressPercent");
        this.completedCount = completedCount;
        this.totalCount = totalCount;
        this.progressPercent = progressPercent;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(ProgressInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.completedCount != 0) {
            output.encodeIntElement(serialDesc, 0, self.completedCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.totalCount != 0) {
            output.encodeIntElement(serialDesc, 1, self.totalCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.progressPercent, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.progressPercent);
        }
    }

    public /* synthetic */ ProgressInfo(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str);
    }

    public final int getCompletedCount() {
        return this.completedCount;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final String getProgressPercent() {
        return this.progressPercent;
    }
}