package kntr.app.deepsearch.handler;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchContainerWidthChangeHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"bindContainerWidthChangeChangeAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "dataProcessService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchContainerWidthChangeHandlerKt {
    public static final void bindContainerWidthChangeChangeAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock, final DeepSearchDataProcessService dataProcessService) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new DeepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.ContainerWidthChange.class), executionPolicy$iv, handler$iv);
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchContainerWidthChangeHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Object bindContainerWidthChangeChangeAction$lambda$0;
                bindContainerWidthChangeChangeAction$lambda$0 = DeepSearchContainerWidthChangeHandlerKt.bindContainerWidthChangeChangeAction$lambda$0((DeepSearchPageData) obj);
                return bindContainerWidthChangeChangeAction$lambda$0;
            }
        }, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchContainerWidthChangeHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindContainerWidthChangeChangeAction$lambda$1;
                bindContainerWidthChangeChangeAction$lambda$1 = DeepSearchContainerWidthChangeHandlerKt.bindContainerWidthChangeChangeAction$lambda$1(DeepSearchDataProcessService.this, (IdentityBuilderBlock) obj);
                return bindContainerWidthChangeChangeAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindContainerWidthChangeChangeAction$lambda$0(DeepSearchPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Double.valueOf(it.getContainerWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindContainerWidthChangeChangeAction$lambda$1(DeepSearchDataProcessService $dataProcessService, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnter(new DeepSearchContainerWidthChangeHandlerKt$bindContainerWidthChangeChangeAction$3$1($dataProcessService, null));
        return Unit.INSTANCE;
    }
}