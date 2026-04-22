package kntr.app.tribee.publish.service;

import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.TribeePublishState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeeInitService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/service/TribeeInitService;", "", "initBlock", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/app/tribee/publish/TribeePublishState;", "Lkntr/app/tribee/publish/TribeePublishAction;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeInitService {
    void initBlock(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder);
}