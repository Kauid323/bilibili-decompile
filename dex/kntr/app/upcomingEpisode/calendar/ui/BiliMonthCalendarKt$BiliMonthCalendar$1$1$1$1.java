package kntr.app.upcomingEpisode.calendar.ui;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Month;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarDataStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliMonthCalendar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class BiliMonthCalendarKt$BiliMonthCalendar$1$1$1$1 extends FunctionReferenceImpl implements Function1<Integer, Month> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliMonthCalendarKt$BiliMonthCalendar$1$1$1$1(Object obj) {
        super(1, obj, BiliCalendarDataStore.class, "get", "get(I)Ljava/lang/Object;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).intValue());
    }

    public final Month invoke(int p0) {
        return (Month) ((BiliCalendarDataStore) this.receiver).get(Integer.valueOf(p0));
    }
}