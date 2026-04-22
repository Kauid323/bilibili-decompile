package home.sidecenter.tabs;

import com.bapis.bilibili.app.home.v1.KHomeMoss;
import com.bapis.bilibili.app.home.v1.KTopLeftTabReq;
import com.bapis.bilibili.app.home.v1.KTopLeftTabRes;
import java.util.List;
import kntr.base.moss.api.KBusinessException;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: SideCenterTabsHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.tabs.SideCenterTabsHolder$loadTabs$1", f = "SideCenterTabsHolder.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SideCenterTabsHolder$loadTabs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SideCenterTabsHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideCenterTabsHolder$loadTabs$1(SideCenterTabsHolder sideCenterTabsHolder, Continuation<? super SideCenterTabsHolder$loadTabs$1> continuation) {
        super(2, continuation);
        this.this$0 = sideCenterTabsHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SideCenterTabsHolder$loadTabs$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        SideCenterTabsState currentState;
        String message;
        Object obj;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    obj = new KHomeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).topLeftTab(new KTopLeftTabReq(), (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            KTopLeftTabRes result = (KTopLeftTabRes) obj;
            mutableStateFlow2 = this.this$0._stateFlow;
            mutableStateFlow2.setValue(new SideCenterTabsState(result));
        } catch (Exception e2) {
            mutableStateFlow = this.this$0._stateFlow;
            currentState = this.this$0.getCurrentState();
            List listOf = CollectionsKt.listOf(SideCenterTab.RECENT);
            SideCenterTabsStatus sideCenterTabsStatus = SideCenterTabsStatus.Error;
            String str = "";
            if ((e2 instanceof KBusinessException) && (message = e2.getMessage()) != null) {
                str = message;
            }
            mutableStateFlow.setValue(SideCenterTabsState.copy$default(currentState, sideCenterTabsStatus, str, listOf, null, false, 24, null));
        }
        return Unit.INSTANCE;
    }
}