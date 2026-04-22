package kntr.app.game.bean;

import androidx.collection.DoubleList$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameAchievementBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lkntr/app/game/bean/AchievementStats;", RoomRecommendViewModel.EMPTY_CURSOR, "unlockedCount", RoomRecommendViewModel.EMPTY_CURSOR, "totalCount", "completionPercent", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IID)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUnlockedCount$annotations", "()V", "getUnlockedCount", "()I", "getTotalCount$annotations", "getTotalCount", "getCompletionPercent$annotations", "getCompletionPercent", "()D", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AchievementStats {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final double completionPercent;
    private final int totalCount;
    private final int unlockedCount;

    public AchievementStats() {
        this(0, 0, 0.0d, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AchievementStats copy$default(AchievementStats achievementStats, int i, int i2, double d, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = achievementStats.unlockedCount;
        }
        if ((i3 & 2) != 0) {
            i2 = achievementStats.totalCount;
        }
        if ((i3 & 4) != 0) {
            d = achievementStats.completionPercent;
        }
        return achievementStats.copy(i, i2, d);
    }

    @SerialName("completion_percent")
    public static /* synthetic */ void getCompletionPercent$annotations() {
    }

    @SerialName("total_count")
    public static /* synthetic */ void getTotalCount$annotations() {
    }

    @SerialName("unlocked_count")
    public static /* synthetic */ void getUnlockedCount$annotations() {
    }

    public final int component1() {
        return this.unlockedCount;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final double component3() {
        return this.completionPercent;
    }

    public final AchievementStats copy(int i, int i2, double d) {
        return new AchievementStats(i, i2, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AchievementStats) {
            AchievementStats achievementStats = (AchievementStats) obj;
            return this.unlockedCount == achievementStats.unlockedCount && this.totalCount == achievementStats.totalCount && Double.compare(this.completionPercent, achievementStats.completionPercent) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((this.unlockedCount * 31) + this.totalCount) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.completionPercent);
    }

    public String toString() {
        int i = this.unlockedCount;
        int i2 = this.totalCount;
        return "AchievementStats(unlockedCount=" + i + ", totalCount=" + i2 + ", completionPercent=" + this.completionPercent + ")";
    }

    /* compiled from: SteamGameAchievementBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/AchievementStats$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/AchievementStats;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AchievementStats> serializer() {
            return AchievementStats$$serializer.INSTANCE;
        }
    }

    public AchievementStats(int unlockedCount, int totalCount, double completionPercent) {
        this.unlockedCount = unlockedCount;
        this.totalCount = totalCount;
        this.completionPercent = completionPercent;
    }

    public /* synthetic */ AchievementStats(int seen0, int unlockedCount, int totalCount, double completionPercent, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.unlockedCount = 0;
        } else {
            this.unlockedCount = unlockedCount;
        }
        if ((seen0 & 2) == 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
        if ((seen0 & 4) == 0) {
            this.completionPercent = 0.0d;
        } else {
            this.completionPercent = completionPercent;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(AchievementStats self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.unlockedCount != 0) {
            output.encodeIntElement(serialDesc, 0, self.unlockedCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.totalCount != 0) {
            output.encodeIntElement(serialDesc, 1, self.totalCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.completionPercent, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 2, self.completionPercent);
        }
    }

    public /* synthetic */ AchievementStats(int i, int i2, double d, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? 0.0d : d);
    }

    public final int getUnlockedCount() {
        return this.unlockedCount;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final double getCompletionPercent() {
        return this.completionPercent;
    }
}