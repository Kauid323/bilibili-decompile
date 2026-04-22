package kntr.app.live.room.lolracerscore;

import ComposableSingletons$CustomBottomSheetKt$;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LiveGradeInfo.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lkntr/app/live/room/lolracerscore/LiveGradeInfoPlayerGradeDetail;", RoomRecommendViewModel.EMPTY_CURSOR, "playerId", RoomRecommendViewModel.EMPTY_CURSOR, "userGrade", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLjava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlayerId$annotations", "()V", "getPlayerId", "()J", "getUserGrade$annotations", "getUserGrade", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$lolracerscore_debug", "$serializer", "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class LiveGradeInfoPlayerGradeDetail {
    public static final Companion Companion = new Companion(null);
    private final long playerId;
    private final String userGrade;

    public static /* synthetic */ LiveGradeInfoPlayerGradeDetail copy$default(LiveGradeInfoPlayerGradeDetail liveGradeInfoPlayerGradeDetail, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = liveGradeInfoPlayerGradeDetail.playerId;
        }
        if ((i & 2) != 0) {
            str = liveGradeInfoPlayerGradeDetail.userGrade;
        }
        return liveGradeInfoPlayerGradeDetail.copy(j2, str);
    }

    @SerialName("player_id")
    public static /* synthetic */ void getPlayerId$annotations() {
    }

    @SerialName("user_grade")
    public static /* synthetic */ void getUserGrade$annotations() {
    }

    public final long component1() {
        return this.playerId;
    }

    public final String component2() {
        return this.userGrade;
    }

    public final LiveGradeInfoPlayerGradeDetail copy(long j2, String str) {
        return new LiveGradeInfoPlayerGradeDetail(j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGradeInfoPlayerGradeDetail) {
            LiveGradeInfoPlayerGradeDetail liveGradeInfoPlayerGradeDetail = (LiveGradeInfoPlayerGradeDetail) obj;
            return this.playerId == liveGradeInfoPlayerGradeDetail.playerId && Intrinsics.areEqual(this.userGrade, liveGradeInfoPlayerGradeDetail.userGrade);
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.playerId) * 31) + (this.userGrade == null ? 0 : this.userGrade.hashCode());
    }

    public String toString() {
        long j2 = this.playerId;
        return "LiveGradeInfoPlayerGradeDetail(playerId=" + j2 + ", userGrade=" + this.userGrade + ")";
    }

    /* compiled from: LiveGradeInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/lolracerscore/LiveGradeInfoPlayerGradeDetail$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/live/room/lolracerscore/LiveGradeInfoPlayerGradeDetail;", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LiveGradeInfoPlayerGradeDetail> serializer() {
            return LiveGradeInfoPlayerGradeDetail$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LiveGradeInfoPlayerGradeDetail(int seen0, long playerId, String userGrade, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, LiveGradeInfoPlayerGradeDetail$$serializer.INSTANCE.getDescriptor());
        }
        this.playerId = playerId;
        if ((seen0 & 2) == 0) {
            this.userGrade = null;
        } else {
            this.userGrade = userGrade;
        }
    }

    public LiveGradeInfoPlayerGradeDetail(long playerId, String userGrade) {
        this.playerId = playerId;
        this.userGrade = userGrade;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$lolracerscore_debug(LiveGradeInfoPlayerGradeDetail self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.playerId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.userGrade != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.userGrade);
        }
    }

    public /* synthetic */ LiveGradeInfoPlayerGradeDetail(long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, (i & 2) != 0 ? null : str);
    }

    public final long getPlayerId() {
        return this.playerId;
    }

    public final String getUserGrade() {
        return this.userGrade;
    }
}