package video.biz.offline.list.ui.page;

import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineResolveDataStore;
import video.biz.offline.list.logic.statemachine.OfflineResultPageUiEvent;

/* compiled from: OfflineDiagnoseResultPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1", f = "OfflineDiagnoseResultPage.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OfflineResolveDataStore $resultDataStore;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1(OfflineResolveDataStore offlineResolveDataStore, Toaster toaster, Continuation<? super OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1> continuation) {
        super(2, continuation);
        this.$resultDataStore = offlineResolveDataStore;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1(this.$resultDataStore, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineDiagnoseResultPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1$1", f = "OfflineDiagnoseResultPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<OfflineResultPageUiEvent, Continuation<? super Unit>, Object> {
        final /* synthetic */ Toaster $toaster;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Toaster toaster, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$toaster = toaster;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$toaster, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(OfflineResultPageUiEvent offlineResultPageUiEvent, Continuation<? super Unit> continuation) {
            return create(offlineResultPageUiEvent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            OfflineResultPageUiEvent event = (OfflineResultPageUiEvent) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!(event instanceof OfflineResultPageUiEvent.ShowToast)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Toaster.-CC.showToast$default(this.$toaster, ((OfflineResultPageUiEvent.ShowToast) event).getToast(), (ToastDuration) null, 2, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.collectLatest(this.$resultDataStore.getUiEventsChannel(), new AnonymousClass1(this.$toaster, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
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