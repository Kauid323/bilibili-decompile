package kntr.app.game.bean;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameDLCBean.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ@\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lkntr/app/game/bean/GameDLCsData;", RoomRecommendViewModel.EMPTY_CURSOR, "header", "Lkntr/app/game/bean/DLCHeader;", "totalCount", RoomRecommendViewModel.EMPTY_CURSOR, "dlcs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/bean/DLCDetail;", "dlcUpdateTime", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/game/bean/DLCHeader;ILjava/util/List;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/game/bean/DLCHeader;ILjava/util/List;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHeader$annotations", "()V", "getHeader", "()Lkntr/app/game/bean/DLCHeader;", "getTotalCount$annotations", "getTotalCount", "()I", "getDlcs$annotations", "getDlcs", "()Ljava/util/List;", "getDlcUpdateTime$annotations", "getDlcUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Lkntr/app/game/bean/DLCHeader;ILjava/util/List;Ljava/lang/Long;)Lkntr/app/game/bean/GameDLCsData;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class GameDLCsData {
    private final Long dlcUpdateTime;
    private final List<DLCDetail> dlcs;
    private final DLCHeader header;
    private final int totalCount;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.GameDLCsData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = GameDLCsData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public GameDLCsData() {
        this((DLCHeader) null, 0, (List) null, (Long) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameDLCsData copy$default(GameDLCsData gameDLCsData, DLCHeader dLCHeader, int i, List list, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dLCHeader = gameDLCsData.header;
        }
        if ((i2 & 2) != 0) {
            i = gameDLCsData.totalCount;
        }
        if ((i2 & 4) != 0) {
            list = gameDLCsData.dlcs;
        }
        if ((i2 & 8) != 0) {
            l = gameDLCsData.dlcUpdateTime;
        }
        return gameDLCsData.copy(dLCHeader, i, list, l);
    }

    @SerialName("dlc_update_time")
    public static /* synthetic */ void getDlcUpdateTime$annotations() {
    }

    @SerialName("dlcs")
    public static /* synthetic */ void getDlcs$annotations() {
    }

    @SerialName("header")
    public static /* synthetic */ void getHeader$annotations() {
    }

    @SerialName("total_count")
    public static /* synthetic */ void getTotalCount$annotations() {
    }

    public final DLCHeader component1() {
        return this.header;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final List<DLCDetail> component3() {
        return this.dlcs;
    }

    public final Long component4() {
        return this.dlcUpdateTime;
    }

    public final GameDLCsData copy(DLCHeader dLCHeader, int i, List<DLCDetail> list, Long l) {
        Intrinsics.checkNotNullParameter(list, "dlcs");
        return new GameDLCsData(dLCHeader, i, list, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameDLCsData) {
            GameDLCsData gameDLCsData = (GameDLCsData) obj;
            return Intrinsics.areEqual(this.header, gameDLCsData.header) && this.totalCount == gameDLCsData.totalCount && Intrinsics.areEqual(this.dlcs, gameDLCsData.dlcs) && Intrinsics.areEqual(this.dlcUpdateTime, gameDLCsData.dlcUpdateTime);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.header == null ? 0 : this.header.hashCode()) * 31) + this.totalCount) * 31) + this.dlcs.hashCode()) * 31) + (this.dlcUpdateTime != null ? this.dlcUpdateTime.hashCode() : 0);
    }

    public String toString() {
        DLCHeader dLCHeader = this.header;
        int i = this.totalCount;
        List<DLCDetail> list = this.dlcs;
        return "GameDLCsData(header=" + dLCHeader + ", totalCount=" + i + ", dlcs=" + list + ", dlcUpdateTime=" + this.dlcUpdateTime + ")";
    }

    /* compiled from: SteamGameDLCBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/GameDLCsData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/GameDLCsData;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GameDLCsData> serializer() {
            return GameDLCsData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GameDLCsData(int seen0, DLCHeader header, int totalCount, List dlcs, Long dlcUpdateTime, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.header = null;
        } else {
            this.header = header;
        }
        if ((seen0 & 2) == 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
        if ((seen0 & 4) == 0) {
            this.dlcs = CollectionsKt.emptyList();
        } else {
            this.dlcs = dlcs;
        }
        if ((seen0 & 8) == 0) {
            this.dlcUpdateTime = null;
        } else {
            this.dlcUpdateTime = dlcUpdateTime;
        }
    }

    public GameDLCsData(DLCHeader header, int totalCount, List<DLCDetail> list, Long dlcUpdateTime) {
        Intrinsics.checkNotNullParameter(list, "dlcs");
        this.header = header;
        this.totalCount = totalCount;
        this.dlcs = list;
        this.dlcUpdateTime = dlcUpdateTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(DLCDetail$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(GameDLCsData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.header != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, DLCHeader$$serializer.INSTANCE, self.header);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.totalCount != 0) {
            output.encodeIntElement(serialDesc, 1, self.totalCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.dlcs, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.dlcs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.dlcUpdateTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.dlcUpdateTime);
        }
    }

    public /* synthetic */ GameDLCsData(DLCHeader dLCHeader, int i, List list, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : dLCHeader, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? null : l);
    }

    public final DLCHeader getHeader() {
        return this.header;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<DLCDetail> getDlcs() {
        return this.dlcs;
    }

    public final Long getDlcUpdateTime() {
        return this.dlcUpdateTime;
    }
}