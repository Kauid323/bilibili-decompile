package video.biz.offline.list.ui.page;

import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDownloadingPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineDownloadingPageKt$OfflineDownloadingView$1$1", f = "OfflineDownloadingPage.kt", i = {}, l = {103, 104}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineDownloadingPageKt$OfflineDownloadingView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfflineDownloadingPageStateMachine $machine;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDownloadingPageKt$OfflineDownloadingView$1$1(OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine, Toaster toaster, Continuation<? super OfflineDownloadingPageKt$OfflineDownloadingView$1$1> continuation) {
        super(2, continuation);
        this.$machine = offlineDownloadingPageStateMachine;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineDownloadingPageKt$OfflineDownloadingView$1$1(this.$machine, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow<String> toastFlow;
        final Toaster toaster;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$machine.dispatch(OfflineListAction.LoadData.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                toastFlow = this.$machine.getToastFlow();
                toaster = this.$toaster;
                this.label = 2;
                if (toastFlow.collect(new FlowCollector() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$OfflineDownloadingView$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((String) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(String it, Continuation<? super Unit> continuation) {
                        if (!StringsKt.isBlank(it)) {
                            Toaster.-CC.showToast$default(toaster, it, (ToastDuration) null, 2, (Object) null);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw new KotlinNothingValueException();
            case 1:
                ResultKt.throwOnFailure($result);
                toastFlow = this.$machine.getToastFlow();
                toaster = this.$toaster;
                this.label = 2;
                if (toastFlow.collect(new FlowCollector() { // from class: video.biz.offline.list.ui.page.OfflineDownloadingPageKt$OfflineDownloadingView$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((String) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(String it, Continuation<? super Unit> continuation) {
                        if (!StringsKt.isBlank(it)) {
                            Toaster.-CC.showToast$default(toaster, it, (ToastDuration) null, 2, (Object) null);
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                }
                throw new KotlinNothingValueException();
            case 2:
                ResultKt.throwOnFailure($result);
                throw new KotlinNothingValueException();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}