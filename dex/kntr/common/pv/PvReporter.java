package kntr.common.pv;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PvReporter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/pv/PvReporter;", "", "onPageVisible", "", "trigger", "Lkntr/common/pv/PvEventTrigger;", "loadType", "Lkntr/common/pv/PageLoadType;", "onPageInvisible", "updateExtra", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface PvReporter {
    void onPageInvisible(PvEventTrigger pvEventTrigger);

    void onPageVisible(PvEventTrigger pvEventTrigger, PageLoadType pageLoadType);

    void updateExtra(PvEventTrigger pvEventTrigger);
}