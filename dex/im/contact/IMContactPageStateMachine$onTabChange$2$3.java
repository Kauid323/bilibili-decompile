package im.contact;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.contact.model.IMContactActionTabChange;
import im.contact.model.IMContactPageData;
import im.contact.model.IMContactPageDataLensKt;
import im.contact.model.IMContactSearchingTabData;
import im.contact.model.IMContactTab;
import im.contact.model.IMContactTabData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactPageData;", AuthActivity.ACTION_KEY, "Lim/contact/model/IMContactActionTabChange;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactPageStateMachine$onTabChange$2$3", f = "IMContactPageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactPageStateMachine$onTabChange$2$3 extends SuspendLambda implements Function3<IMContactActionTabChange, State<IMContactPageData>, Continuation<? super ChangedState<? extends IMContactPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMContactPageStateMachine$onTabChange$2$3(Continuation<? super IMContactPageStateMachine$onTabChange$2$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMContactActionTabChange iMContactActionTabChange, State<IMContactPageData> state, Continuation<? super ChangedState<IMContactPageData>> continuation) {
        IMContactPageStateMachine$onTabChange$2$3 iMContactPageStateMachine$onTabChange$2$3 = new IMContactPageStateMachine$onTabChange$2$3(continuation);
        iMContactPageStateMachine$onTabChange$2$3.L$0 = iMContactActionTabChange;
        iMContactPageStateMachine$onTabChange$2$3.L$1 = state;
        return iMContactPageStateMachine$onTabChange$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final IMContactActionTabChange action = (IMContactActionTabChange) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.contact.IMContactPageStateMachine$onTabChange$2$3$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        IMContactPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMContactPageStateMachine$onTabChange$2$3.invokeSuspend$lambda$0(IMContactActionTabChange.this, (IMContactPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactPageData invokeSuspend$lambda$0(final IMContactActionTabChange $action, IMContactPageData $this$mutate) {
        return (IMContactPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: im.contact.IMContactPageStateMachine$onTabChange$2$3$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = IMContactPageStateMachine$onTabChange$2$3.invokeSuspend$lambda$0$0(IMContactActionTabChange.this, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(IMContactActionTabChange $action, CopyScope $this$copy) {
        $this$copy.set(IMContactPageDataLensKt.getCurrentTab(IMContactPageData.Companion), $action.getTab());
        $this$copy.transform(IMContactPageDataLensKt.getTabList(IMContactPageData.Companion), new Function1() { // from class: im.contact.IMContactPageStateMachine$onTabChange$2$3$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                List invokeSuspend$lambda$0$0$0;
                invokeSuspend$lambda$0$0$0 = IMContactPageStateMachine$onTabChange$2$3.invokeSuspend$lambda$0$0$0((List) obj);
                return invokeSuspend$lambda$0$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$0$0$0(List it) {
        IMContactTabData iMContactTabData;
        List $this$map$iv = it;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMContactTab tab = (IMContactTab) item$iv$iv;
            if (tab instanceof IMContactSearchingTabData) {
                iMContactTabData = ((IMContactSearchingTabData) tab).toNormalData();
            } else {
                iMContactTabData = tab;
            }
            destination$iv$iv.add(iMContactTabData);
        }
        return (List) destination$iv$iv;
    }
}