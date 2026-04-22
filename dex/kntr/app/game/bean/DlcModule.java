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
import kotlin.time.Duration;
import kotlinx.datetime.Clock;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J6\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020\u001cHÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lkntr/app/game/bean/DlcModule;", RoomRecommendViewModel.EMPTY_CURSOR, "ownership", "Lkntr/app/game/bean/DlcOwnership;", "dlcs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/bean/DlcItem;", "dlcUpdateTime", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/game/bean/DlcOwnership;Ljava/util/List;Ljava/lang/Long;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/game/bean/DlcOwnership;Ljava/util/List;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOwnership$annotations", "()V", "getOwnership", "()Lkntr/app/game/bean/DlcOwnership;", "getDlcs$annotations", "getDlcs", "()Ljava/util/List;", "getDlcUpdateTime$annotations", "getDlcUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpdateTimeDesc", RoomRecommendViewModel.EMPTY_CURSOR, "shouldShowRefreshButton", RoomRecommendViewModel.EMPTY_CURSOR, "component1", "component2", "component3", "copy", "(Lkntr/app/game/bean/DlcOwnership;Ljava/util/List;Ljava/lang/Long;)Lkntr/app/game/bean/DlcModule;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class DlcModule {
    private final Long dlcUpdateTime;
    private final List<DlcItem> dlcs;
    private final DlcOwnership ownership;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.game.bean.DlcModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DlcModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public DlcModule() {
        this((DlcOwnership) null, (List) null, (Long) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DlcModule copy$default(DlcModule dlcModule, DlcOwnership dlcOwnership, List list, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            dlcOwnership = dlcModule.ownership;
        }
        if ((i & 2) != 0) {
            list = dlcModule.dlcs;
        }
        if ((i & 4) != 0) {
            l = dlcModule.dlcUpdateTime;
        }
        return dlcModule.copy(dlcOwnership, list, l);
    }

    @SerialName("dlc_update_time")
    public static /* synthetic */ void getDlcUpdateTime$annotations() {
    }

    @SerialName("dlcs")
    public static /* synthetic */ void getDlcs$annotations() {
    }

    @SerialName("ownership")
    public static /* synthetic */ void getOwnership$annotations() {
    }

    public final DlcOwnership component1() {
        return this.ownership;
    }

    public final List<DlcItem> component2() {
        return this.dlcs;
    }

    public final Long component3() {
        return this.dlcUpdateTime;
    }

    public final DlcModule copy(DlcOwnership dlcOwnership, List<DlcItem> list, Long l) {
        Intrinsics.checkNotNullParameter(list, "dlcs");
        return new DlcModule(dlcOwnership, list, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DlcModule) {
            DlcModule dlcModule = (DlcModule) obj;
            return Intrinsics.areEqual(this.ownership, dlcModule.ownership) && Intrinsics.areEqual(this.dlcs, dlcModule.dlcs) && Intrinsics.areEqual(this.dlcUpdateTime, dlcModule.dlcUpdateTime);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.ownership == null ? 0 : this.ownership.hashCode()) * 31) + this.dlcs.hashCode()) * 31) + (this.dlcUpdateTime != null ? this.dlcUpdateTime.hashCode() : 0);
    }

    public String toString() {
        DlcOwnership dlcOwnership = this.ownership;
        List<DlcItem> list = this.dlcs;
        return "DlcModule(ownership=" + dlcOwnership + ", dlcs=" + list + ", dlcUpdateTime=" + this.dlcUpdateTime + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/DlcModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/DlcModule;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DlcModule> serializer() {
            return DlcModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DlcModule(int seen0, DlcOwnership ownership, List dlcs, Long dlcUpdateTime, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.ownership = null;
        } else {
            this.ownership = ownership;
        }
        if ((seen0 & 2) == 0) {
            this.dlcs = CollectionsKt.emptyList();
        } else {
            this.dlcs = dlcs;
        }
        if ((seen0 & 4) == 0) {
            this.dlcUpdateTime = null;
        } else {
            this.dlcUpdateTime = dlcUpdateTime;
        }
    }

    public DlcModule(DlcOwnership ownership, List<DlcItem> list, Long dlcUpdateTime) {
        Intrinsics.checkNotNullParameter(list, "dlcs");
        this.ownership = ownership;
        this.dlcs = list;
        this.dlcUpdateTime = dlcUpdateTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(DlcItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(DlcModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ownership != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, DlcOwnership$$serializer.INSTANCE, self.ownership);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.dlcs, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.dlcs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.dlcUpdateTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.dlcUpdateTime);
        }
    }

    public /* synthetic */ DlcModule(DlcOwnership dlcOwnership, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dlcOwnership, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : l);
    }

    public final DlcOwnership getOwnership() {
        return this.ownership;
    }

    public final List<DlcItem> getDlcs() {
        return this.dlcs;
    }

    public final Long getDlcUpdateTime() {
        return this.dlcUpdateTime;
    }

    public final String getUpdateTimeDesc() {
        Long l = this.dlcUpdateTime;
        if (l != null) {
            long updateTime = l.longValue();
            if (updateTime <= 0) {
                return RoomRecommendViewModel.EMPTY_CURSOR;
            }
            Instant now = Clock.System.INSTANCE.now();
            Instant lastUpdate = Instant.Companion.fromEpochSeconds$default(Instant.Companion, updateTime, 0L, 2, (Object) null);
            long diff = now.minus-5sfh64U(lastUpdate);
            long seconds = Duration.getInWholeSeconds-impl(diff);
            long minutes = Duration.getInWholeMinutes-impl(diff);
            long hours = Duration.getInWholeHours-impl(diff);
            LocalDate today = TimeZoneKt.toLocalDateTime(now, TimeZone.Companion.currentSystemDefault()).getDate();
            LocalDate lastUpdateDate = TimeZoneKt.toLocalDateTime(lastUpdate, TimeZone.Companion.currentSystemDefault()).getDate();
            LocalDate yesterday = LocalDateKt.minus(today, new DatePeriod(0, 0, 1, 3, (DefaultConstructorMarker) null));
            LocalDate yearStart = new LocalDate(today.getYear(), 1, 1);
            if (seconds < 60) {
                return "刚刚更新";
            }
            if (minutes < 60) {
                return minutes + "分钟前更新";
            }
            if (hours < 24) {
                return hours + "小时前更新";
            }
            if (Intrinsics.areEqual(lastUpdateDate, yesterday)) {
                return "昨天更新";
            }
            if (lastUpdateDate.compareTo(yearStart) > 0) {
                int monthNumber = lastUpdateDate.getMonthNumber();
                return monthNumber + "月" + lastUpdateDate.getDayOfMonth() + "日更新";
            }
            int year = lastUpdateDate.getYear();
            int monthNumber2 = lastUpdateDate.getMonthNumber();
            return year + "年" + monthNumber2 + "月" + lastUpdateDate.getDayOfMonth() + "日更新";
        }
        return RoomRecommendViewModel.EMPTY_CURSOR;
    }

    public final boolean shouldShowRefreshButton() {
        Long updateTime = this.dlcUpdateTime;
        if (updateTime == null || updateTime.longValue() <= 0) {
            return true;
        }
        Instant now = Clock.System.INSTANCE.now();
        Instant lastUpdate = Instant.Companion.fromEpochSeconds$default(Instant.Companion, updateTime.longValue(), 0L, 2, (Object) null);
        long diff = now.minus-5sfh64U(lastUpdate);
        long minutes = Duration.getInWholeMinutes-impl(diff);
        return minutes >= 5;
    }
}