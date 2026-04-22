package im.contact;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.contact.model.IMContactClickedHolder;
import im.contact.model.IMContactOnContactClick;
import im.contact.model.IMContactPageData;
import im.contact.model.IMContactPageDataLensKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactPageData;", AuthActivity.ACTION_KEY, "Lim/contact/model/IMContactOnContactClick;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactPageStateMachine$onClick$1", f = "IMContactPageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMContactPageStateMachine$onClick$1 extends SuspendLambda implements Function3<IMContactOnContactClick, State<IMContactPageData>, Continuation<? super ChangedState<? extends IMContactPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMContactPageStateMachine$onClick$1(Continuation<? super IMContactPageStateMachine$onClick$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMContactOnContactClick iMContactOnContactClick, State<IMContactPageData> state, Continuation<? super ChangedState<IMContactPageData>> continuation) {
        IMContactPageStateMachine$onClick$1 iMContactPageStateMachine$onClick$1 = new IMContactPageStateMachine$onClick$1(continuation);
        iMContactPageStateMachine$onClick$1.L$0 = iMContactOnContactClick;
        iMContactPageStateMachine$onClick$1.L$1 = state;
        return iMContactPageStateMachine$onClick$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final IMContactOnContactClick action = (IMContactOnContactClick) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.contact.IMContactPageStateMachine$onClick$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMContactPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMContactPageStateMachine$onClick$1.invokeSuspend$lambda$0(IMContactOnContactClick.this, (IMContactPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactPageData invokeSuspend$lambda$0(IMContactOnContactClick $action, IMContactPageData $this$mutate) {
        return (IMContactPageData) IMContactPageDataLensKt.getClickedContact(IMContactPageData.Companion).set($this$mutate, new IMContactClickedHolder($action.getContact(), Intrinsics.areEqual($this$mutate.getCurrentTab(), KContactTabType.TAB_GROUP.INSTANCE), 0L, 4, null));
    }
}