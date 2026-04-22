package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Week;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeekCalendarLayoutInfo.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u0012\u0010\u001f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u0010R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\r¨\u0006*"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/WeekCalendarLayoutInfo;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "info", "getIndexData", "Lkotlin/Function1;", "", "Lkntr/app/upcomingEpisode/calendar/model/Week;", "<init>", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlin/jvm/functions/Function1;)V", "visibleWeeksInfo", "", "Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarItemInfo;", "getVisibleWeeksInfo", "()Ljava/util/List;", "afterContentPadding", "getAfterContentPadding", "()I", "beforeContentPadding", "getBeforeContentPadding", "mainAxisItemSpacing", "getMainAxisItemSpacing", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "totalItemsCount", "getTotalItemsCount", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WeekCalendarLayoutInfo implements LazyListLayoutInfo {
    public static final int $stable = 8;
    private final /* synthetic */ LazyListLayoutInfo $$delegate_0;
    private final Function1<Integer, Week> getIndexData;

    public int getAfterContentPadding() {
        return this.$$delegate_0.getAfterContentPadding();
    }

    public int getBeforeContentPadding() {
        return this.$$delegate_0.getBeforeContentPadding();
    }

    public int getMainAxisItemSpacing() {
        return this.$$delegate_0.getMainAxisItemSpacing();
    }

    public Orientation getOrientation() {
        return this.$$delegate_0.getOrientation();
    }

    public boolean getReverseLayout() {
        return this.$$delegate_0.getReverseLayout();
    }

    public int getTotalItemsCount() {
        return this.$$delegate_0.getTotalItemsCount();
    }

    public int getViewportEndOffset() {
        return this.$$delegate_0.getViewportEndOffset();
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m1224getViewportSizeYbymL2g() {
        return this.$$delegate_0.getViewportSize-YbymL2g();
    }

    public int getViewportStartOffset() {
        return this.$$delegate_0.getViewportStartOffset();
    }

    public List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.$$delegate_0.getVisibleItemsInfo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WeekCalendarLayoutInfo(LazyListLayoutInfo info, Function1<? super Integer, Week> function1) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(function1, "getIndexData");
        this.$$delegate_0 = info;
        this.getIndexData = function1;
    }

    public final List<BiliWeekCalendarItemInfo> getVisibleWeeksInfo() {
        Iterable $this$map$iv = getVisibleItemsInfo();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LazyListItemInfo info = (LazyListItemInfo) item$iv$iv;
            destination$iv$iv.add(new BiliWeekCalendarItemInfo(info, (Week) this.getIndexData.invoke(Integer.valueOf(info.getIndex()))));
        }
        return (List) destination$iv$iv;
    }
}