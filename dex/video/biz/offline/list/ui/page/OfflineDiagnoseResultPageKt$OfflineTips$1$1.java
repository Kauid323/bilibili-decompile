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
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.list.ResolveTipProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnoseResultPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.ui.page.OfflineDiagnoseResultPageKt$OfflineTips$1$1", f = "OfflineDiagnoseResultPage.kt", i = {}, l = {273, 274}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineDiagnoseResultPageKt$OfflineTips$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $content$delegate;
    final /* synthetic */ MutableState<String> $title$delegate;
    final /* synthetic */ OfflineVideoEntity $videoEntity;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDiagnoseResultPageKt$OfflineTips$1$1(OfflineVideoEntity offlineVideoEntity, MutableState<String> mutableState, MutableState<String> mutableState2, Continuation<? super OfflineDiagnoseResultPageKt$OfflineTips$1$1> continuation) {
        super(2, continuation);
        this.$videoEntity = offlineVideoEntity;
        this.$title$delegate = mutableState;
        this.$content$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineDiagnoseResultPageKt$OfflineTips$1$1(this.$videoEntity, this.$title$delegate, this.$content$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableState<String> mutableState;
        Object title;
        Object content;
        MutableState<String> mutableState2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableState = this.$title$delegate;
                this.L$0 = mutableState;
                this.label = 1;
                title = new ResolveTipProvider(this.$videoEntity).title((Continuation) this);
                if (title == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState.setValue((String) title);
                MutableState<String> mutableState3 = this.$content$delegate;
                this.L$0 = mutableState3;
                this.label = 2;
                content = new ResolveTipProvider(this.$videoEntity).content((Continuation) this);
                if (content != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState2 = mutableState3;
                mutableState2.setValue((String) content);
                return Unit.INSTANCE;
            case 1:
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure($result);
                title = $result;
                mutableState.setValue((String) title);
                MutableState<String> mutableState32 = this.$content$delegate;
                this.L$0 = mutableState32;
                this.label = 2;
                content = new ResolveTipProvider(this.$videoEntity).content((Continuation) this);
                if (content != coroutine_suspended) {
                }
                break;
            case 2:
                mutableState2 = (MutableState) this.L$0;
                ResultKt.throwOnFailure($result);
                content = $result;
                mutableState2.setValue((String) content);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}