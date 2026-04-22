package im.session.common;

import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.tencent.smtt.sdk.TbsListener;
import im.session.model.IMSessionPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSessionPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.common.IMSessionPageKt$IMSessionPageContent$1$1", f = "IMSessionPage.kt", i = {}, l = {TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionPageKt$IMSessionPageContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMSessionPageData $page;
    final /* synthetic */ SwipeCancellingToken $swipeCancellingToken;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionPageKt$IMSessionPageContent$1$1(IMSessionPageData iMSessionPageData, SwipeCancellingToken swipeCancellingToken, Continuation<? super IMSessionPageKt$IMSessionPageContent$1$1> continuation) {
        super(2, continuation);
        this.$page = iMSessionPageData;
        this.$swipeCancellingToken = swipeCancellingToken;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionPageKt$IMSessionPageContent$1$1(this.$page, this.$swipeCancellingToken, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$page.getSessionToDelete() == null) {
                    this.label = 1;
                    if (this.$swipeCancellingToken.cancelAll((Continuation) this) == coroutine_suspended) {
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