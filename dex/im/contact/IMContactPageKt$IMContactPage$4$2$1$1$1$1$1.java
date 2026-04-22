package im.contact;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.pager.PagerState;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactPageKt$IMContactPage$4$2$1$1$1$1$1", f = "IMContactPage.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactPageKt$IMContactPage$4$2$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactPageKt$IMContactPage$4$2$1$1$1$1$1(PagerState pagerState, int i2, Continuation<? super IMContactPageKt$IMContactPage$4$2$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$index = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMContactPageKt$IMContactPage$4$2$1$1$1$1$1(this.$pagerState, this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (PagerState.animateScrollToPage$default(this.$pagerState, this.$index, (float) CropImageView.DEFAULT_ASPECT_RATIO, (AnimationSpec) null, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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