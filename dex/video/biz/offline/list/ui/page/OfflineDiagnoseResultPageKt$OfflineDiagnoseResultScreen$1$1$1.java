package video.biz.offline.list.ui.page;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.list.ResolveUploadProvider;
import video.biz.offline.list.logic.statemachine.OfflineResolveState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnoseResultPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$OfflineDiagnoseResultScreen$1$1$1", f = "OfflineDiagnoseResultPage.kt", i = {}, l = {Player.PLAYER_QUALITY_DOLBY_VISION}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineDiagnoseResultPageKt$OfflineDiagnoseResultScreen$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $buttonText$delegate;
    final /* synthetic */ OfflineResolveState $state;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDiagnoseResultPageKt$OfflineDiagnoseResultScreen$1$1$1(OfflineResolveState offlineResolveState, MutableState<String> mutableState, Continuation<? super OfflineDiagnoseResultPageKt$OfflineDiagnoseResultScreen$1$1$1> continuation) {
        super(2, continuation);
        this.$state = offlineResolveState;
        this.$buttonText$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineDiagnoseResultPageKt$OfflineDiagnoseResultScreen$1$1$1(this.$state, this.$buttonText$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object content;
        MutableState<String> mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableState<String> mutableState2 = this.$buttonText$delegate;
                OfflineVideoEntity entity = ((OfflineResolveState.OfflineResolvePageUiState) this.$state).getEntity();
                Intrinsics.checkNotNull(entity);
                this.L$0 = mutableState2;
                this.label = 1;
                content = new ResolveUploadProvider(entity).content((Continuation) this);
                if (content == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState = mutableState2;
                break;
            case 1:
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure($result);
                content = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableState.setValue((String) content);
        return Unit.INSTANCE;
    }
}