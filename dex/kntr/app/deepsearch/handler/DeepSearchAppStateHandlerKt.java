package kntr.app.deepsearch.handler;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchAppStateHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"bindAppStateAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "timeoutService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchAppStateHandlerKt {
    public static final void bindAppStateAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock, DeepSearchTimeoutService timeoutService) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        Intrinsics.checkNotNullParameter(timeoutService, "timeoutService");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new DeepSearchAppStateHandlerKt$bindAppStateAction$1(timeoutService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.AppStateAction.EnterBackground.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new DeepSearchAppStateHandlerKt$bindAppStateAction$2(timeoutService, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.AppStateAction.EnterForeground.class), executionPolicy$iv2, handler$iv2);
    }
}