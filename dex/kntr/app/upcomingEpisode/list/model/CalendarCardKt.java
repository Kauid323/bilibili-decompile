package kntr.app.upcomingEpisode.list.model;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bapis.bilibili.community.interfacess.watch.v1.KArchiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCard;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarDate;
import com.bapis.bilibili.community.interfacess.watch.v1.KLiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KOgvCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KThreeMoreInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarCard.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0001H\u0002\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"transformToDates", "", "Lkntr/app/upcomingEpisode/list/model/CalendarDate;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarDate;", "transformToCards", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCard;", "transform", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CalendarCardKt {
    public static final List<CalendarDate> transformToDates(List<KCalendarDate> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<KCalendarDate> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KCalendarDate it = (KCalendarDate) item$iv$iv;
            destination$iv$iv.add(new CalendarDate(it.getItemDate(), it.getPointType(), transformToCards(it.getCardList())));
        }
        return (List) destination$iv$iv;
    }

    private static final SnapshotStateList<CalendarCard> transformToCards(List<KCalendarCard> list) {
        List<KCalendarCard> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KCalendarCard it = (KCalendarCard) item$iv$iv;
            destination$iv$iv.add(transform(it));
        }
        return SnapshotStateKt.toMutableStateList((List) destination$iv$iv);
    }

    private static final CalendarCard transform(KCalendarCard $this$transform) {
        KWatchBizType bizType = $this$transform.getBizType();
        String bizId = $this$transform.getBizId();
        long anchorTime = $this$transform.getAnchorTime();
        KCalendarCardType calendarCardType = $this$transform.getCalendarCardType();
        KUpInfo upInfo = $this$transform.getUpInfo();
        KThreeMoreInfo threeMoreInfo = $this$transform.getThreeMoreInfo();
        KArchiveCardInfo archiveCardInfo = $this$transform.getArchiveCardInfo();
        KLiveCardInfo liveCardInfo = $this$transform.getLiveCardInfo();
        KReserveCardInfo reserveCardInfo = $this$transform.getReserveCardInfo();
        KOgvCardInfo ogvCardInfo = $this$transform.getOgvCardInfo();
        Map report = $this$transform.getReport();
        KReserveCardInfo reserveCardInfo2 = $this$transform.getReserveCardInfo();
        boolean z = false;
        if (reserveCardInfo2 != null && reserveCardInfo2.getReserveState() == 1) {
            z = true;
        }
        MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
        KReserveCardInfo reserveCardInfo3 = $this$transform.getReserveCardInfo();
        return new CalendarCard(bizType, bizId, anchorTime, calendarCardType, upInfo, threeMoreInfo, archiveCardInfo, liveCardInfo, reserveCardInfo, ogvCardInfo, report, false, null, null, mutableStateOf$default, SnapshotStateKt.mutableStateOf$default(Long.valueOf(reserveCardInfo3 != null ? reserveCardInfo3.getReserveTotal() : 0L), (SnapshotMutationPolicy) null, 2, (Object) null), null, 79872, null);
    }
}