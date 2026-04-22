package kntr.app.upcomingEpisode.base.handler;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeAction;
import kntr.app.upcomingEpisode.base.stateMachine.UpcomingEpisodeData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: CancelReserveCardHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "bindCancelReserveCardAction", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeData;", "Lkntr/app/upcomingEpisode/base/stateMachine/UpcomingEpisodeAction;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CancelReserveCardHandlerKt {
    private static final String TAG = "CancelReserveCardHandler";

    public static final void bindCancelReserveCardAction(InStateBuilderBlock<UpcomingEpisodeData, UpcomingEpisodeData, UpcomingEpisodeAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.CancelReserveCardHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean bindCancelReserveCardAction$lambda$0;
                bindCancelReserveCardAction$lambda$0 = CancelReserveCardHandlerKt.bindCancelReserveCardAction$lambda$0((UpcomingEpisodeData) obj);
                return Boolean.valueOf(bindCancelReserveCardAction$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.CancelReserveCardHandlerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindCancelReserveCardAction$lambda$1;
                bindCancelReserveCardAction$lambda$1 = CancelReserveCardHandlerKt.bindCancelReserveCardAction$lambda$1((ConditionBuilderBlock) obj);
                return bindCancelReserveCardAction$lambda$1;
            }
        });
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.CancelReserveCardHandlerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindCancelReserveCardAction$lambda$2;
                bindCancelReserveCardAction$lambda$2 = CancelReserveCardHandlerKt.bindCancelReserveCardAction$lambda$2((UpcomingEpisodeData) obj);
                return Boolean.valueOf(bindCancelReserveCardAction$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.upcomingEpisode.base.handler.CancelReserveCardHandlerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindCancelReserveCardAction$lambda$3;
                bindCancelReserveCardAction$lambda$3 = CancelReserveCardHandlerKt.bindCancelReserveCardAction$lambda$3((ConditionBuilderBlock) obj);
                return bindCancelReserveCardAction$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindCancelReserveCardAction$lambda$0(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it.getRequestModel().getCancelReserveCardReqState().getState() instanceof RequestStatus.Loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCancelReserveCardAction$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new CancelReserveCardHandlerKt$bindCancelReserveCardAction$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(UpcomingEpisodeAction.CancelReserveCard.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindCancelReserveCardAction$lambda$2(UpcomingEpisodeData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRequestModel().getCancelReserveCardReqState().getState() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCancelReserveCardAction$lambda$3(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new CancelReserveCardHandlerKt$bindCancelReserveCardAction$4$1(null));
        return Unit.INSTANCE;
    }
}