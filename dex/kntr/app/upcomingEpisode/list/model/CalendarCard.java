package kntr.app.upcomingEpisode.list.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bapis.bilibili.community.interfacess.watch.v1.KArchiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType;
import com.bapis.bilibili.community.interfacess.watch.v1.KLiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KOgvCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KThreeMoreInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarCard.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001b¢\u0006\u0004\b!\u0010\"J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0015\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017HÆ\u0003J\t\u0010N\u001a\u00020\u0019HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bHÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bHÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bHÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bHÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020 0\u001bHÆ\u0003Jé\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001bHÆ\u0001J\u0013\u0010U\u001a\u00020\u00192\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020XHÖ\u0001J\t\u0010Y\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010>R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010>¨\u0006Z"}, d2 = {"Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "", "bizType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "bizId", "", "anchorTime", "", "calendarCardType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;", "upInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;", "threeMoreInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KThreeMoreInfo;", "archiveCardInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KArchiveCardInfo;", "liveCardInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KLiveCardInfo;", "reserveCardInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveCardInfo;", "ogvCardInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KOgvCardInfo;", "report", "", "hasReportCardShow", "", "hasCardClicked", "Landroidx/compose/runtime/MutableState;", "shouldCardShow", "hasCardReserved", "reservedCount", "cardUiType", "Lkntr/app/upcomingEpisode/list/model/CardUiType;", "<init>", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;Ljava/lang/String;JLcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;Lcom/bapis/bilibili/community/interfacess/watch/v1/KThreeMoreInfo;Lcom/bapis/bilibili/community/interfacess/watch/v1/KArchiveCardInfo;Lcom/bapis/bilibili/community/interfacess/watch/v1/KLiveCardInfo;Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveCardInfo;Lcom/bapis/bilibili/community/interfacess/watch/v1/KOgvCardInfo;Ljava/util/Map;ZLandroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getBizType", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "getBizId", "()Ljava/lang/String;", "getAnchorTime", "()J", "getCalendarCardType", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;", "getUpInfo", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;", "getThreeMoreInfo", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KThreeMoreInfo;", "getArchiveCardInfo", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KArchiveCardInfo;", "getLiveCardInfo", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KLiveCardInfo;", "getReserveCardInfo", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveCardInfo;", "getOgvCardInfo", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KOgvCardInfo;", "getReport", "()Ljava/util/Map;", "getHasReportCardShow", "()Z", "setHasReportCardShow", "(Z)V", "getHasCardClicked", "()Landroidx/compose/runtime/MutableState;", "getShouldCardShow", "getHasCardReserved", "getReservedCount", "getCardUiType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "", "toString", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CalendarCard {
    public static final int $stable = 8;
    private final long anchorTime;
    private final KArchiveCardInfo archiveCardInfo;
    private final String bizId;
    private final KWatchBizType bizType;
    private final KCalendarCardType calendarCardType;
    private final MutableState<CardUiType> cardUiType;
    private final MutableState<Boolean> hasCardClicked;
    private final MutableState<Boolean> hasCardReserved;
    private boolean hasReportCardShow;
    private final KLiveCardInfo liveCardInfo;
    private final KOgvCardInfo ogvCardInfo;
    private final Map<String, String> report;
    private final KReserveCardInfo reserveCardInfo;
    private final MutableState<Long> reservedCount;
    private final MutableState<Boolean> shouldCardShow;
    private final KThreeMoreInfo threeMoreInfo;
    private final KUpInfo upInfo;

    public CalendarCard() {
        this(null, null, 0L, null, null, null, null, null, null, null, null, false, null, null, null, null, null, 131071, null);
    }

    public final KWatchBizType component1() {
        return this.bizType;
    }

    public final KOgvCardInfo component10() {
        return this.ogvCardInfo;
    }

    public final Map<String, String> component11() {
        return this.report;
    }

    public final boolean component12() {
        return this.hasReportCardShow;
    }

    public final MutableState<Boolean> component13() {
        return this.hasCardClicked;
    }

    public final MutableState<Boolean> component14() {
        return this.shouldCardShow;
    }

    public final MutableState<Boolean> component15() {
        return this.hasCardReserved;
    }

    public final MutableState<Long> component16() {
        return this.reservedCount;
    }

    public final MutableState<CardUiType> component17() {
        return this.cardUiType;
    }

    public final String component2() {
        return this.bizId;
    }

    public final long component3() {
        return this.anchorTime;
    }

    public final KCalendarCardType component4() {
        return this.calendarCardType;
    }

    public final KUpInfo component5() {
        return this.upInfo;
    }

    public final KThreeMoreInfo component6() {
        return this.threeMoreInfo;
    }

    public final KArchiveCardInfo component7() {
        return this.archiveCardInfo;
    }

    public final KLiveCardInfo component8() {
        return this.liveCardInfo;
    }

    public final KReserveCardInfo component9() {
        return this.reserveCardInfo;
    }

    public final CalendarCard copy(KWatchBizType kWatchBizType, String str, long j, KCalendarCardType kCalendarCardType, KUpInfo kUpInfo, KThreeMoreInfo kThreeMoreInfo, KArchiveCardInfo kArchiveCardInfo, KLiveCardInfo kLiveCardInfo, KReserveCardInfo kReserveCardInfo, KOgvCardInfo kOgvCardInfo, Map<String, String> map, boolean z, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, MutableState<Long> mutableState4, MutableState<CardUiType> mutableState5) {
        Intrinsics.checkNotNullParameter(kWatchBizType, "bizType");
        Intrinsics.checkNotNullParameter(str, "bizId");
        Intrinsics.checkNotNullParameter(kCalendarCardType, "calendarCardType");
        Intrinsics.checkNotNullParameter(map, "report");
        Intrinsics.checkNotNullParameter(mutableState, "hasCardClicked");
        Intrinsics.checkNotNullParameter(mutableState2, "shouldCardShow");
        Intrinsics.checkNotNullParameter(mutableState3, "hasCardReserved");
        Intrinsics.checkNotNullParameter(mutableState4, "reservedCount");
        Intrinsics.checkNotNullParameter(mutableState5, "cardUiType");
        return new CalendarCard(kWatchBizType, str, j, kCalendarCardType, kUpInfo, kThreeMoreInfo, kArchiveCardInfo, kLiveCardInfo, kReserveCardInfo, kOgvCardInfo, map, z, mutableState, mutableState2, mutableState3, mutableState4, mutableState5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CalendarCard) {
            CalendarCard calendarCard = (CalendarCard) obj;
            return Intrinsics.areEqual(this.bizType, calendarCard.bizType) && Intrinsics.areEqual(this.bizId, calendarCard.bizId) && this.anchorTime == calendarCard.anchorTime && Intrinsics.areEqual(this.calendarCardType, calendarCard.calendarCardType) && Intrinsics.areEqual(this.upInfo, calendarCard.upInfo) && Intrinsics.areEqual(this.threeMoreInfo, calendarCard.threeMoreInfo) && Intrinsics.areEqual(this.archiveCardInfo, calendarCard.archiveCardInfo) && Intrinsics.areEqual(this.liveCardInfo, calendarCard.liveCardInfo) && Intrinsics.areEqual(this.reserveCardInfo, calendarCard.reserveCardInfo) && Intrinsics.areEqual(this.ogvCardInfo, calendarCard.ogvCardInfo) && Intrinsics.areEqual(this.report, calendarCard.report) && this.hasReportCardShow == calendarCard.hasReportCardShow && Intrinsics.areEqual(this.hasCardClicked, calendarCard.hasCardClicked) && Intrinsics.areEqual(this.shouldCardShow, calendarCard.shouldCardShow) && Intrinsics.areEqual(this.hasCardReserved, calendarCard.hasCardReserved) && Intrinsics.areEqual(this.reservedCount, calendarCard.reservedCount) && Intrinsics.areEqual(this.cardUiType, calendarCard.cardUiType);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.bizType.hashCode() * 31) + this.bizId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.anchorTime)) * 31) + this.calendarCardType.hashCode()) * 31) + (this.upInfo == null ? 0 : this.upInfo.hashCode())) * 31) + (this.threeMoreInfo == null ? 0 : this.threeMoreInfo.hashCode())) * 31) + (this.archiveCardInfo == null ? 0 : this.archiveCardInfo.hashCode())) * 31) + (this.liveCardInfo == null ? 0 : this.liveCardInfo.hashCode())) * 31) + (this.reserveCardInfo == null ? 0 : this.reserveCardInfo.hashCode())) * 31) + (this.ogvCardInfo != null ? this.ogvCardInfo.hashCode() : 0)) * 31) + this.report.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasReportCardShow)) * 31) + this.hasCardClicked.hashCode()) * 31) + this.shouldCardShow.hashCode()) * 31) + this.hasCardReserved.hashCode()) * 31) + this.reservedCount.hashCode()) * 31) + this.cardUiType.hashCode();
    }

    public String toString() {
        KWatchBizType kWatchBizType = this.bizType;
        String str = this.bizId;
        long j = this.anchorTime;
        KCalendarCardType kCalendarCardType = this.calendarCardType;
        KUpInfo kUpInfo = this.upInfo;
        KThreeMoreInfo kThreeMoreInfo = this.threeMoreInfo;
        KArchiveCardInfo kArchiveCardInfo = this.archiveCardInfo;
        KLiveCardInfo kLiveCardInfo = this.liveCardInfo;
        KReserveCardInfo kReserveCardInfo = this.reserveCardInfo;
        KOgvCardInfo kOgvCardInfo = this.ogvCardInfo;
        Map<String, String> map = this.report;
        boolean z = this.hasReportCardShow;
        MutableState<Boolean> mutableState = this.hasCardClicked;
        MutableState<Boolean> mutableState2 = this.shouldCardShow;
        MutableState<Boolean> mutableState3 = this.hasCardReserved;
        MutableState<Long> mutableState4 = this.reservedCount;
        return "CalendarCard(bizType=" + kWatchBizType + ", bizId=" + str + ", anchorTime=" + j + ", calendarCardType=" + kCalendarCardType + ", upInfo=" + kUpInfo + ", threeMoreInfo=" + kThreeMoreInfo + ", archiveCardInfo=" + kArchiveCardInfo + ", liveCardInfo=" + kLiveCardInfo + ", reserveCardInfo=" + kReserveCardInfo + ", ogvCardInfo=" + kOgvCardInfo + ", report=" + map + ", hasReportCardShow=" + z + ", hasCardClicked=" + mutableState + ", shouldCardShow=" + mutableState2 + ", hasCardReserved=" + mutableState3 + ", reservedCount=" + mutableState4 + ", cardUiType=" + this.cardUiType + ")";
    }

    public CalendarCard(KWatchBizType bizType, String bizId, long anchorTime, KCalendarCardType calendarCardType, KUpInfo upInfo, KThreeMoreInfo threeMoreInfo, KArchiveCardInfo archiveCardInfo, KLiveCardInfo liveCardInfo, KReserveCardInfo reserveCardInfo, KOgvCardInfo ogvCardInfo, Map<String, String> map, boolean hasReportCardShow, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, MutableState<Long> mutableState4, MutableState<CardUiType> mutableState5) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(calendarCardType, "calendarCardType");
        Intrinsics.checkNotNullParameter(map, "report");
        Intrinsics.checkNotNullParameter(mutableState, "hasCardClicked");
        Intrinsics.checkNotNullParameter(mutableState2, "shouldCardShow");
        Intrinsics.checkNotNullParameter(mutableState3, "hasCardReserved");
        Intrinsics.checkNotNullParameter(mutableState4, "reservedCount");
        Intrinsics.checkNotNullParameter(mutableState5, "cardUiType");
        this.bizType = bizType;
        this.bizId = bizId;
        this.anchorTime = anchorTime;
        this.calendarCardType = calendarCardType;
        this.upInfo = upInfo;
        this.threeMoreInfo = threeMoreInfo;
        this.archiveCardInfo = archiveCardInfo;
        this.liveCardInfo = liveCardInfo;
        this.reserveCardInfo = reserveCardInfo;
        this.ogvCardInfo = ogvCardInfo;
        this.report = map;
        this.hasReportCardShow = hasReportCardShow;
        this.hasCardClicked = mutableState;
        this.shouldCardShow = mutableState2;
        this.hasCardReserved = mutableState3;
        this.reservedCount = mutableState4;
        this.cardUiType = mutableState5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CalendarCard(KWatchBizType kWatchBizType, String str, long j, KCalendarCardType kCalendarCardType, KUpInfo kUpInfo, KThreeMoreInfo kThreeMoreInfo, KArchiveCardInfo kArchiveCardInfo, KLiveCardInfo kLiveCardInfo, KReserveCardInfo kReserveCardInfo, KOgvCardInfo kOgvCardInfo, Map map, boolean z, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r6, r3, r8, r10, r11, r12, r13, r14, r15, r40, r16, r17, r4, r18, r0);
        boolean z2;
        SnapshotMutationPolicy snapshotMutationPolicy;
        MutableState mutableState6;
        MutableState mutableState7;
        MutableState mutableState8;
        MutableState mutableState9;
        MutableState mutableState10;
        MutableState mutableState11;
        MutableState mutableState12;
        KWatchBizType kWatchBizType2 = (i & 1) != 0 ? (KWatchBizType) KWatchBizType.WATCH_BIZ_TYPE_DEFAULT.INSTANCE : kWatchBizType;
        String str2 = (i & 2) != 0 ? "" : str;
        long j2 = (i & 4) != 0 ? 0L : j;
        KCalendarCardType kCalendarCardType2 = (i & 8) != 0 ? (KCalendarCardType) KCalendarCardType.CALENDAR_CARD_TYPE_DEFAULT.INSTANCE : kCalendarCardType;
        KUpInfo kUpInfo2 = (i & 16) != 0 ? null : kUpInfo;
        KThreeMoreInfo kThreeMoreInfo2 = (i & 32) != 0 ? null : kThreeMoreInfo;
        KArchiveCardInfo kArchiveCardInfo2 = (i & 64) != 0 ? null : kArchiveCardInfo;
        KLiveCardInfo kLiveCardInfo2 = (i & 128) != 0 ? null : kLiveCardInfo;
        KReserveCardInfo kReserveCardInfo2 = (i & 256) != 0 ? null : kReserveCardInfo;
        KOgvCardInfo kOgvCardInfo2 = (i & 512) != 0 ? null : kOgvCardInfo;
        Map emptyMap = (i & 1024) != 0 ? MapsKt.emptyMap() : map;
        boolean z3 = (i & 2048) != 0 ? false : z;
        if ((i & 4096) != 0) {
            z2 = z3;
            snapshotMutationPolicy = null;
            mutableState6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        } else {
            z2 = z3;
            snapshotMutationPolicy = null;
            mutableState6 = mutableState;
        }
        if ((i & 8192) != 0) {
            mutableState7 = mutableState6;
            mutableState8 = SnapshotStateKt.mutableStateOf$default(true, snapshotMutationPolicy, 2, snapshotMutationPolicy);
        } else {
            mutableState7 = mutableState6;
            mutableState8 = mutableState2;
        }
        if ((i & 16384) != 0) {
            mutableState9 = mutableState8;
            mutableState10 = SnapshotStateKt.mutableStateOf$default(false, snapshotMutationPolicy, 2, snapshotMutationPolicy);
        } else {
            mutableState9 = mutableState8;
            mutableState10 = mutableState3;
        }
        MutableState mutableState13 = (32768 & i) != 0 ? (MutableState) SnapshotLongStateKt.mutableLongStateOf(0L) : mutableState4;
        if ((i & 65536) != 0) {
            mutableState11 = mutableState13;
            mutableState12 = SnapshotStateKt.mutableStateOf$default(CardUiType.TYPE_DIM, (SnapshotMutationPolicy) null, 2, (Object) null);
        } else {
            mutableState11 = mutableState13;
            mutableState12 = mutableState5;
        }
    }

    public final KWatchBizType getBizType() {
        return this.bizType;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final long getAnchorTime() {
        return this.anchorTime;
    }

    public final KCalendarCardType getCalendarCardType() {
        return this.calendarCardType;
    }

    public final KUpInfo getUpInfo() {
        return this.upInfo;
    }

    public final KThreeMoreInfo getThreeMoreInfo() {
        return this.threeMoreInfo;
    }

    public final KArchiveCardInfo getArchiveCardInfo() {
        return this.archiveCardInfo;
    }

    public final KLiveCardInfo getLiveCardInfo() {
        return this.liveCardInfo;
    }

    public final KReserveCardInfo getReserveCardInfo() {
        return this.reserveCardInfo;
    }

    public final KOgvCardInfo getOgvCardInfo() {
        return this.ogvCardInfo;
    }

    public final Map<String, String> getReport() {
        return this.report;
    }

    public final boolean getHasReportCardShow() {
        return this.hasReportCardShow;
    }

    public final void setHasReportCardShow(boolean z) {
        this.hasReportCardShow = z;
    }

    public final MutableState<Boolean> getHasCardClicked() {
        return this.hasCardClicked;
    }

    public final MutableState<Boolean> getShouldCardShow() {
        return this.shouldCardShow;
    }

    public final MutableState<Boolean> getHasCardReserved() {
        return this.hasCardReserved;
    }

    public final MutableState<Long> getReservedCount() {
        return this.reservedCount;
    }

    public final MutableState<CardUiType> getCardUiType() {
        return this.cardUiType;
    }
}