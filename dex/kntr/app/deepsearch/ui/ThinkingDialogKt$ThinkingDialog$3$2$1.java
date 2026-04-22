package kntr.app.deepsearch.ui;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ScrollState;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThinkingDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.ThinkingDialogKt$ThinkingDialog$3$2$1", f = "ThinkingDialog.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ThinkingDialogKt$ThinkingDialog$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeepSearchPageData $data;
    final /* synthetic */ ScrollState $scrollState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThinkingDialogKt$ThinkingDialog$3$2$1(DeepSearchPageData deepSearchPageData, ScrollState scrollState, Continuation<? super ThinkingDialogKt$ThinkingDialog$3$2$1> continuation) {
        super(2, continuation);
        this.$data = deepSearchPageData;
        this.$scrollState = scrollState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThinkingDialogKt$ThinkingDialog$3$2$1(this.$data, this.$scrollState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DeepSearchThinkPopContent thinkPopContent = this.$data.getThinkPopContent();
                if (Intrinsics.areEqual(thinkPopContent != null ? thinkPopContent.getThinkStatus() : null, KThinking.KStatus.THINKING.INSTANCE)) {
                    this.label = 1;
                    if (ScrollState.animateScrollTo$default(this.$scrollState, this.$scrollState.getMaxValue(), (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
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