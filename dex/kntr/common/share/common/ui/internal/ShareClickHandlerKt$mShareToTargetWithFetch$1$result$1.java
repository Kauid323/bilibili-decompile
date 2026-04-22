package kntr.common.share.common.ui.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.ShareRawResult;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ShareClickHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/common/share/common/ShareRawResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.common.ui.internal.ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1", f = "ShareClickHandler.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ShareRawResult>, Object> {
    final /* synthetic */ ShareLocalContext $context;
    final /* synthetic */ ShareTarget $target;
    final /* synthetic */ Ref.ObjectRef<ShareContent> $targetContent;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1(ShareTarget shareTarget, Ref.ObjectRef<ShareContent> objectRef, ShareLocalContext shareLocalContext, Continuation<? super ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1> continuation) {
        super(2, continuation);
        this.$target = shareTarget;
        this.$targetContent = objectRef;
        this.$context = shareLocalContext;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1(this.$target, this.$targetContent, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ShareRawResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object shareToTarget = ShareKt.gShare().shareToTarget(this.$target, (ShareContent) this.$targetContent.element, this.$context, (Continuation) this);
                if (shareToTarget == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return shareToTarget;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}