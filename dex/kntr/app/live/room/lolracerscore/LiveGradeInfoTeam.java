package kntr.app.live.room.lolracerscore;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: LiveGradeInfo.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lkntr/app/live/room/lolracerscore/LiveGradeInfoTeam;", RoomRecommendViewModel.EMPTY_CURSOR, "playerGradeDetail", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/live/room/lolracerscore/LiveGradeInfoPlayerGradeDetail;", "<init>", "(Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlayerGradeDetail$annotations", "()V", "getPlayerGradeDetail", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$lolracerscore_debug", "$serializer", "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class LiveGradeInfoTeam {
    private final List<LiveGradeInfoPlayerGradeDetail> playerGradeDetail;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.live.room.lolracerscore.LiveGradeInfoTeam$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = LiveGradeInfoTeam._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveGradeInfoTeam copy$default(LiveGradeInfoTeam liveGradeInfoTeam, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = liveGradeInfoTeam.playerGradeDetail;
        }
        return liveGradeInfoTeam.copy(list);
    }

    @SerialName("player_grade_detail")
    public static /* synthetic */ void getPlayerGradeDetail$annotations() {
    }

    public final List<LiveGradeInfoPlayerGradeDetail> component1() {
        return this.playerGradeDetail;
    }

    public final LiveGradeInfoTeam copy(List<LiveGradeInfoPlayerGradeDetail> list) {
        Intrinsics.checkNotNullParameter(list, "playerGradeDetail");
        return new LiveGradeInfoTeam(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveGradeInfoTeam) && Intrinsics.areEqual(this.playerGradeDetail, ((LiveGradeInfoTeam) obj).playerGradeDetail);
    }

    public int hashCode() {
        return this.playerGradeDetail.hashCode();
    }

    public String toString() {
        return "LiveGradeInfoTeam(playerGradeDetail=" + this.playerGradeDetail + ")";
    }

    /* compiled from: LiveGradeInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/lolracerscore/LiveGradeInfoTeam$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/live/room/lolracerscore/LiveGradeInfoTeam;", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LiveGradeInfoTeam> serializer() {
            return LiveGradeInfoTeam$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LiveGradeInfoTeam(int seen0, List playerGradeDetail, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, LiveGradeInfoTeam$$serializer.INSTANCE.getDescriptor());
        }
        this.playerGradeDetail = playerGradeDetail;
    }

    public LiveGradeInfoTeam(List<LiveGradeInfoPlayerGradeDetail> list) {
        Intrinsics.checkNotNullParameter(list, "playerGradeDetail");
        this.playerGradeDetail = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(LiveGradeInfoPlayerGradeDetail$$serializer.INSTANCE);
    }

    public final List<LiveGradeInfoPlayerGradeDetail> getPlayerGradeDetail() {
        return this.playerGradeDetail;
    }
}