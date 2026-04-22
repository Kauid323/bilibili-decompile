package kntr.common.ouro.core.action;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kotlin.Metadata;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: OuroAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/action/OuroSyncAction;", "Lkntr/common/ouro/core/action/OuroAction;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroSyncAction extends OuroAction {
    CompletableDeferred<OuroState> getDeferred();
}