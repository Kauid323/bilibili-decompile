package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KConfigReply;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageDataLensKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.DeepSearchToast;
import kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModel;
import kntr.app.deepsearch.base.model.biz.PageStyle;
import kntr.app.deepsearch.base.model.biz.RequestModelLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStateLensKt;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.deepsearch.base.model.biz.TextConfigModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchTextConfigHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1", f = "DeepSearchTextConfigHandler.kt", i = {0}, l = {47}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1 extends SuspendLambda implements Function2<State<DeepSearchPageData>, Continuation<? super ChangedState<? extends DeepSearchPageData>>, Object> {
    final /* synthetic */ DeepSearchTimeoutService $timeoutService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1(DeepSearchTimeoutService deepSearchTimeoutService, Continuation<? super DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1> continuation) {
        super(2, continuation);
        this.$timeoutService = deepSearchTimeoutService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchTextConfigHandlerKt$bindTextConfigAction$4$1 = new DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1(this.$timeoutService, continuation);
        deepSearchTextConfigHandlerKt$bindTextConfigAction$4$1.L$0 = obj;
        return deepSearchTextConfigHandlerKt$bindTextConfigAction$4$1;
    }

    public final Object invoke(State<DeepSearchPageData> state, Continuation<? super ChangedState<DeepSearchPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object loadTextConfig;
        DeepSearchTreadPopModel createTreadModel;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = state;
                    this.label = 1;
                    loadTextConfig = DeepSearchTextConfigHandlerKt.loadTextConfig((Continuation) this);
                    if (loadTextConfig == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    loadTextConfig = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            KConfigReply response = (KConfigReply) loadTextConfig;
            this.$timeoutService.configTimeoutInterval(response.getBroadcastTimeout());
            String startText = response.getStartText();
            String completeText = response.getCompleteText();
            String streamingText = response.getStreamingText();
            String chatBotIcon = response.getChatBotIcon();
            long interval = response.getInterval();
            String navigationThinkingText = response.getNavigationThinkingText();
            String navigationAnsweringText = response.getNavigationAnsweringText();
            createTreadModel = DeepSearchTextConfigHandlerKt.createTreadModel(response.getTreadPop());
            final TextConfigModel textConfigModel = new TextConfigModel(startText, completeText, streamingText, chatBotIcon, navigationThinkingText, navigationAnsweringText, interval, createTreadModel);
            return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    DeepSearchPageData invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1.invokeSuspend$lambda$0(TextConfigModel.this, (DeepSearchPageData) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Exception e) {
            return state.mutate(new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    DeepSearchPageData invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1.invokeSuspend$lambda$1(e, (DeepSearchPageData) obj);
                    return invokeSuspend$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$0(final TextConfigModel $textConfigModel, DeepSearchPageData $this$mutate) {
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1.invokeSuspend$lambda$0$0(TextConfigModel.this, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(TextConfigModel $textConfigModel, CopyScope $this$copy) {
        $this$copy.set(DeepSearchPageDataLensKt.getTextConfigModel(DeepSearchPageData.Companion), $textConfigModel);
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getTextConfigReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), RequestStatus.Success.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepSearchPageData invokeSuspend$lambda$1(final Exception $e, DeepSearchPageData $this$mutate) {
        if (Intrinsics.areEqual($this$mutate.getPageStyle(), PageStyle.History.INSTANCE)) {
            return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit invokeSuspend$lambda$1$0;
                    invokeSuspend$lambda$1$0 = DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1.invokeSuspend$lambda$1$0($e, (CopyScope) obj);
                    return invokeSuspend$lambda$1$0;
                }
            });
        }
        return (DeepSearchPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.deepsearch.handler.DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$1;
                invokeSuspend$lambda$1$1 = DeepSearchTextConfigHandlerKt$bindTextConfigAction$4$1.invokeSuspend$lambda$1$1($e, (CopyScope) obj);
                return invokeSuspend$lambda$1$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(Exception $e, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getTextConfigReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error($e));
        $this$copy.set(DeepSearchPageDataLensKt.getDeepSearchToast(DeepSearchPageData.Companion), DeepSearchToast.Companion.create$default(DeepSearchToast.Companion, $e, null, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$1(Exception $e, CopyScope $this$copy) {
        $this$copy.set(RequestStateLensKt.getStatus(RequestModelLensKt.getTextConfigReqState(DeepSearchPageDataLensKt.getRequestModel(DeepSearchPageData.Companion))), new RequestStatus.Error($e));
        return Unit.INSTANCE;
    }
}