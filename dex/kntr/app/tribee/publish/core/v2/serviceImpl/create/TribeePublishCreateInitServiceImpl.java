package kntr.app.tribee.publish.core.v2.serviceImpl.create;

import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.di.TribeePublishOuroStore;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishNewContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.tribee.publish.core.v2.service.TribeePublishInitService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TribeePublishCreateInitServiceImpl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeePublishCreateInitServiceImpl;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishInitService;", "draftService", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "converter", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "<init>", "(Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;Lkntr/common/ouro/core/OuroStore;)V", "initBlock", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishCreateInitServiceImpl implements TribeePublishInitService {
    private final TribeePublishDataConverter converter;
    private final TribeePublishDraftService draftService;
    private final OuroStore ouroStore;
    private final TribeeInfo tribeeInfo;

    @Inject
    public TribeePublishCreateInitServiceImpl(TribeePublishDraftService draftService, TribeeInfo tribeeInfo, TribeePublishDataConverter converter, @TribeePublishOuroStore OuroStore ouroStore) {
        Intrinsics.checkNotNullParameter(draftService, "draftService");
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        this.draftService = draftService;
        this.tribeeInfo = tribeeInfo;
        this.converter = converter;
        this.ouroStore = ouroStore;
    }

    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishInitService
    public void initBlock(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeePublishCreateInitServiceImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit initBlock$lambda$0;
                initBlock$lambda$0 = TribeePublishCreateInitServiceImpl.initBlock$lambda$0(TribeePublishCreateInitServiceImpl.this, (InStateBuilderBlock) obj);
                return initBlock$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishNewContent.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initBlock$lambda$0(TribeePublishCreateInitServiceImpl this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeePublishCreateInitServiceImpl$initBlock$1$1(this$0, null));
        return Unit.INSTANCE;
    }
}