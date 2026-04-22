package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhoneOrPasswordLoginIdlePage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IPhoneOrPasswordLoginPage;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/PhoneOrPasswordLoginIdlePage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginStateMachine$1$1$1", f = "PhoneOrPasswordLoginIdlePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PhoneOrPasswordLoginStateMachine$1$1$1 extends SuspendLambda implements Function2<State<PhoneOrPasswordLoginIdlePage>, Continuation<? super ChangedState<? extends IPhoneOrPasswordLoginPage>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneOrPasswordLoginStateMachine$1$1$1(Continuation<? super PhoneOrPasswordLoginStateMachine$1$1$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> phoneOrPasswordLoginStateMachine$1$1$1 = new PhoneOrPasswordLoginStateMachine$1$1$1(continuation);
        phoneOrPasswordLoginStateMachine$1$1$1.L$0 = obj;
        return phoneOrPasswordLoginStateMachine$1$1$1;
    }

    public final Object invoke(State<PhoneOrPasswordLoginIdlePage> state, Continuation<? super ChangedState<? extends IPhoneOrPasswordLoginPage>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                State it = (State) this.L$0;
                return it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginStateMachine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        PhoneOrPasswordLoginPage invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PhoneOrPasswordLoginStateMachine$1$1$1.invokeSuspend$lambda$0((PhoneOrPasswordLoginIdlePage) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PhoneOrPasswordLoginPage invokeSuspend$lambda$0(PhoneOrPasswordLoginIdlePage $this$override) {
        return PhoneOrPasswordLoginPage.INSTANCE;
    }
}