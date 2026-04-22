package kntr.app.tribee.publish.service.edit;

import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.tribee.publish.TribeePublishEditContent;
import kntr.app.tribee.publish.TribeePublishState;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.tribee.publish.service.TribeeInitService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: TribeeInitEditServiceImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/tribee/publish/service/edit/TribeeInitEditServiceImpl;", "Lkntr/app/tribee/publish/service/TribeeInitService;", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "converter", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "<init>", "(Lkntr/app/tribee/publish/TribeeInfo;Lkntr/app/tribee/publish/service/TribeeContentConverter;)V", "initBlock", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/app/tribee/publish/TribeePublishState;", "Lkntr/app/tribee/publish/TribeePublishAction;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInitEditServiceImpl implements TribeeInitService {
    private final TribeeContentConverter converter;
    private final TribeeInfo tribeeInfo;

    @Inject
    public TribeeInitEditServiceImpl(TribeeInfo tribeeInfo, TribeeContentConverter converter) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(converter, "converter");
        this.tribeeInfo = tribeeInfo;
        this.converter = converter;
    }

    @Override // kntr.app.tribee.publish.service.TribeeInitService
    public void initBlock(FlowReduxStoreBuilder<TribeePublishState, TribeePublishAction> flowReduxStoreBuilder) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.publish.service.edit.TribeeInitEditServiceImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit initBlock$lambda$0;
                initBlock$lambda$0 = TribeeInitEditServiceImpl.initBlock$lambda$0(TribeeInitEditServiceImpl.this, (InStateBuilderBlock) obj);
                return initBlock$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(TribeePublishEditContent.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initBlock$lambda$0(TribeeInitEditServiceImpl this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeInitEditServiceImpl$initBlock$1$1(this$0, null));
        return Unit.INSTANCE;
    }
}