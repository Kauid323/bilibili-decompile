package video.biz.offline.list.ui.page;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDownloadingPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$6$1$1", f = "OfflineDownloadingPage.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$6$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ OfflineDownloadingPageStateMachine $machine;
    final /* synthetic */ OfflinePageOperation $operations;
    int label;

    /* compiled from: OfflineDownloadingPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflinePageOperation.values().length];
            try {
                iArr[OfflinePageOperation.DELETE_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$6$1$1(OfflinePageOperation offlinePageOperation, OfflineDownloadingPageStateMachine offlineDownloadingPageStateMachine, String str, Continuation<? super OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$6$1$1> continuation) {
        super(2, continuation);
        this.$operations = offlinePageOperation;
        this.$machine = offlineDownloadingPageStateMachine;
        this.$key = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineDownloadingPageKt$OfflineDownloadingView$2$3$1$6$1$1(this.$operations, this.$machine, this.$key, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (WhenMappings.$EnumSwitchMapping$0[this.$operations.ordinal()] == 1) {
                    this.label = 1;
                    if (this.$machine.dispatch(new OfflineListAction.DeleteConfirmed(CollectionsKt.listOf(this.$key)), (Continuation) this) == coroutine_suspended) {
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