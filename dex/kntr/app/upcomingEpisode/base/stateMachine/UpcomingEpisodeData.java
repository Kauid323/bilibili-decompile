package kntr.app.upcomingEpisode.base.stateMachine;

import BottomSheetItemData$;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import com.bapis.bilibili.community.interfacess.watch.v1.KRecommend;
import com.bilibili.blens.Lens;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kntr.app.upcomingEpisode.base.stateMachine.PageStatus;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: UpcomingEpisodeData.kt */
@Lens
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 92\u00020\u0001:\u00019B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u001b\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007HÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u008d\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0013\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001a¨\u0006:"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "", "hasRequestCalendarApi", "", "calendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "cardListMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Lkotlinx/datetime/LocalDate;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "pointTypeMap", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "pageSet", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "requestModel", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel;", "pageStatus", "Lkntr/app/upcomingEpisode/base/stateMachine/PageStatus;", "recommendData", "", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KRecommend;", "feature", "<init>", "(ZLkntr/app/upcomingEpisode/base/handler/CalendarType;Landroidx/compose/runtime/snapshots/SnapshotStateMap;Landroidx/compose/runtime/snapshots/SnapshotStateMap;Landroidx/compose/runtime/snapshots/SnapshotStateSet;Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel;Lkntr/app/upcomingEpisode/base/stateMachine/PageStatus;Ljava/util/List;Z)V", "getHasRequestCalendarApi", "()Z", "getCalendarType", "()Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "getCardListMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "getPointTypeMap", "getPageSet", "()Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getRequestModel", "()Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel;", "getPageStatus", "()Lkntr/app/upcomingEpisode/base/stateMachine/PageStatus;", "getRecommendData", "()Ljava/util/List;", "getFeature", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeData {
    private final CalendarType calendarType;
    private final SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> cardListMap;
    private final boolean feature;
    private final boolean hasRequestCalendarApi;
    private final SnapshotStateSet<LocalDate> pageSet;
    private final PageStatus pageStatus;
    private final SnapshotStateMap<LocalDate, KCalendarPointType> pointTypeMap;
    private final List<KRecommend> recommendData;
    private final RequestModel requestModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UpcomingEpisodeData() {
        this(false, null, null, null, null, null, null, null, false, 511, null);
    }

    public final boolean component1() {
        return this.hasRequestCalendarApi;
    }

    public final CalendarType component2() {
        return this.calendarType;
    }

    public final SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> component3() {
        return this.cardListMap;
    }

    public final SnapshotStateMap<LocalDate, KCalendarPointType> component4() {
        return this.pointTypeMap;
    }

    public final SnapshotStateSet<LocalDate> component5() {
        return this.pageSet;
    }

    public final RequestModel component6() {
        return this.requestModel;
    }

    public final PageStatus component7() {
        return this.pageStatus;
    }

    public final List<KRecommend> component8() {
        return this.recommendData;
    }

    public final boolean component9() {
        return this.feature;
    }

    public final UpcomingEpisodeData copy(boolean z, CalendarType calendarType, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap, SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap2, SnapshotStateSet<LocalDate> snapshotStateSet, RequestModel requestModel, PageStatus pageStatus, List<KRecommend> list, boolean z2) {
        Intrinsics.checkNotNullParameter(calendarType, "calendarType");
        Intrinsics.checkNotNullParameter(snapshotStateMap, "cardListMap");
        Intrinsics.checkNotNullParameter(snapshotStateMap2, "pointTypeMap");
        Intrinsics.checkNotNullParameter(snapshotStateSet, "pageSet");
        Intrinsics.checkNotNullParameter(requestModel, "requestModel");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "recommendData");
        return new UpcomingEpisodeData(z, calendarType, snapshotStateMap, snapshotStateMap2, snapshotStateSet, requestModel, pageStatus, list, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpcomingEpisodeData) {
            UpcomingEpisodeData upcomingEpisodeData = (UpcomingEpisodeData) obj;
            return this.hasRequestCalendarApi == upcomingEpisodeData.hasRequestCalendarApi && this.calendarType == upcomingEpisodeData.calendarType && Intrinsics.areEqual(this.cardListMap, upcomingEpisodeData.cardListMap) && Intrinsics.areEqual(this.pointTypeMap, upcomingEpisodeData.pointTypeMap) && Intrinsics.areEqual(this.pageSet, upcomingEpisodeData.pageSet) && Intrinsics.areEqual(this.requestModel, upcomingEpisodeData.requestModel) && Intrinsics.areEqual(this.pageStatus, upcomingEpisodeData.pageStatus) && Intrinsics.areEqual(this.recommendData, upcomingEpisodeData.recommendData) && this.feature == upcomingEpisodeData.feature;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasRequestCalendarApi) * 31) + this.calendarType.hashCode()) * 31) + this.cardListMap.hashCode()) * 31) + this.pointTypeMap.hashCode()) * 31) + this.pageSet.hashCode()) * 31) + this.requestModel.hashCode()) * 31) + this.pageStatus.hashCode()) * 31) + this.recommendData.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.feature);
    }

    public String toString() {
        boolean z = this.hasRequestCalendarApi;
        CalendarType calendarType = this.calendarType;
        SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap = this.cardListMap;
        SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap2 = this.pointTypeMap;
        SnapshotStateSet<LocalDate> snapshotStateSet = this.pageSet;
        RequestModel requestModel = this.requestModel;
        PageStatus pageStatus = this.pageStatus;
        List<KRecommend> list = this.recommendData;
        return "UpcomingEpisodeData(hasRequestCalendarApi=" + z + ", calendarType=" + calendarType + ", cardListMap=" + snapshotStateMap + ", pointTypeMap=" + snapshotStateMap2 + ", pageSet=" + snapshotStateSet + ", requestModel=" + requestModel + ", pageStatus=" + pageStatus + ", recommendData=" + list + ", feature=" + this.feature + ")";
    }

    public UpcomingEpisodeData(boolean hasRequestCalendarApi, CalendarType calendarType, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap, SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap2, SnapshotStateSet<LocalDate> snapshotStateSet, RequestModel requestModel, PageStatus pageStatus, List<KRecommend> list, boolean feature) {
        Intrinsics.checkNotNullParameter(calendarType, "calendarType");
        Intrinsics.checkNotNullParameter(snapshotStateMap, "cardListMap");
        Intrinsics.checkNotNullParameter(snapshotStateMap2, "pointTypeMap");
        Intrinsics.checkNotNullParameter(snapshotStateSet, "pageSet");
        Intrinsics.checkNotNullParameter(requestModel, "requestModel");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "recommendData");
        this.hasRequestCalendarApi = hasRequestCalendarApi;
        this.calendarType = calendarType;
        this.cardListMap = snapshotStateMap;
        this.pointTypeMap = snapshotStateMap2;
        this.pageSet = snapshotStateSet;
        this.requestModel = requestModel;
        this.pageStatus = pageStatus;
        this.recommendData = list;
        this.feature = feature;
    }

    public /* synthetic */ UpcomingEpisodeData(boolean z, CalendarType calendarType, SnapshotStateMap snapshotStateMap, SnapshotStateMap snapshotStateMap2, SnapshotStateSet snapshotStateSet, RequestModel requestModel, PageStatus pageStatus, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CalendarType.WEEK : calendarType, (i & 4) != 0 ? SnapshotStateKt.mutableStateMapOf() : snapshotStateMap, (i & 8) != 0 ? SnapshotStateKt.mutableStateMapOf() : snapshotStateMap2, (i & 16) != 0 ? SnapshotStateKt.mutableStateSetOf() : snapshotStateSet, (i & 32) != 0 ? new RequestModel(null, null, null, null, 15, null) : requestModel, (i & 64) != 0 ? PageStatus.Idle.INSTANCE : pageStatus, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? true : z2);
    }

    public final boolean getHasRequestCalendarApi() {
        return this.hasRequestCalendarApi;
    }

    public final CalendarType getCalendarType() {
        return this.calendarType;
    }

    public final SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> getCardListMap() {
        return this.cardListMap;
    }

    public final SnapshotStateMap<LocalDate, KCalendarPointType> getPointTypeMap() {
        return this.pointTypeMap;
    }

    public final SnapshotStateSet<LocalDate> getPageSet() {
        return this.pageSet;
    }

    public final RequestModel getRequestModel() {
        return this.requestModel;
    }

    public final PageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final List<KRecommend> getRecommendData() {
        return this.recommendData;
    }

    public final boolean getFeature() {
        return this.feature;
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData$Companion;", "", "<init>", "()V", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}