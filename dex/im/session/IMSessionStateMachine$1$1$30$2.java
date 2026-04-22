package im.session;

import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.tencent.tauth.AuthActivity;
import im.session.model.IMQuickLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", AuthActivity.ACTION_KEY, "Lim/session/IMActionClickQuickLinkItem;", "stateSnapshot", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$30$2", f = "IMSessionStateMachine.kt", i = {0, 0}, l = {440}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY, "stateSnapshot"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$1$1$30$2 extends SuspendLambda implements Function3<IMActionClickQuickLinkItem, IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$30$2(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$30$2> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionClickQuickLinkItem iMActionClickQuickLinkItem, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$1$1$30$2 iMSessionStateMachine$1$1$30$2 = new IMSessionStateMachine$1$1$30$2(this.this$0, continuation);
        iMSessionStateMachine$1$1$30$2.L$0 = iMActionClickQuickLinkItem;
        iMSessionStateMachine$1$1$30$2.L$1 = iMState;
        return iMSessionStateMachine$1$1$30$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KQuickLinkItemType kQuickLinkItemType;
        KQuickLinkBubble bubble;
        IMActionClickQuickLinkItem action = (IMActionClickQuickLinkItem) this.L$0;
        IMState stateSnapshot = (IMState) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KQuickLinkItemType type = action.getItem().getType();
                IMQuickLink quickLinks = stateSnapshot.getData().getQuickLinks();
                if (quickLinks == null || (bubble = quickLinks.getBubble()) == null) {
                    kQuickLinkItemType = null;
                } else {
                    kQuickLinkItemType = bubble.getQuickLinkItem();
                }
                if (Intrinsics.areEqual(type, kQuickLinkItemType)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(stateSnapshot);
                    this.label = 1;
                    if (this.this$0.dispatch(IMActionDismissQuickLinkBubble.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}