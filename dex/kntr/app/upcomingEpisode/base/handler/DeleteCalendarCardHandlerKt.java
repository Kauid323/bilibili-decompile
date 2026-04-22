package kntr.app.upcomingEpisode.base.handler;

import com.bapis.bilibili.community.interfacess.watch.v1.KDelCalendarCardReq;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DeleteCalendarCardHandler.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0083@¢\u0006\u0002\u0010\u0007\u001a\u001e\u0010\b\u001a\u00020\u0003*\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TAG", "", "deleteCalendarCard", "", "bizType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "bizId", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindDeleteAction", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DeleteCalendarCardHandlerKt {
    private static final String TAG = "DeleteCalendarCardHandler";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object deleteCalendarCard(KWatchBizType bizType, String bizId, Continuation<? super Unit> continuation) {
        KDelCalendarCardReq request = new KDelCalendarCardReq(bizType, bizId);
        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new DeleteCalendarCardHandlerKt$deleteCalendarCard$2(request, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public static final void bindDeleteAction(InStateBuilderBlock<UpcomingEpisodeData, UpcomingEpisodeData, UpcomingEpisodeAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindDeleteAction$lambda$0;
                bindDeleteAction$lambda$0 = DeleteCalendarCardHandlerKt.bindDeleteAction$lambda$0((UpcomingEpisodeData) obj);
                return Boolean.valueOf(bindDeleteAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindDeleteAction$lambda$1;
                bindDeleteAction$lambda$1 = DeleteCalendarCardHandlerKt.bindDeleteAction$lambda$1((ConditionBuilderBlock) obj);
                return bindDeleteAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindDeleteAction$lambda$2;
                bindDeleteAction$lambda$2 = DeleteCalendarCardHandlerKt.bindDeleteAction$lambda$2((UpcomingEpisodeData) obj);
                return Boolean.valueOf(bindDeleteAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.DeleteCalendarCardHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindDeleteAction$lambda$3;
                bindDeleteAction$lambda$3 = DeleteCalendarCardHandlerKt.bindDeleteAction$lambda$3((ConditionBuilderBlock) obj);
                return bindDeleteAction$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindDeleteAction$lambda$0(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getDelCalendarCardReqState().getState() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindDeleteAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new DeleteCalendarCardHandlerKt$bindDeleteAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(UpcomingEpisodeAction.DeleteCalendarCard.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindDeleteAction$lambda$2(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getDelCalendarCardReqState().getState() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindDeleteAction$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new DeleteCalendarCardHandlerKt$bindDeleteAction$4$1(null));
        return Unit.INSTANCE;
    }
}