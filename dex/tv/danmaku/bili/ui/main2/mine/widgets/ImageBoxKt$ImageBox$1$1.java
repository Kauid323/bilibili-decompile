package tv.danmaku.bili.ui.main2.mine.widgets;

import androidx.compose.runtime.MutableState;
import com.bilibili.app.comm.list.widget.image.ImageResource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;

/* compiled from: ImageBox.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.widgets.ImageBoxKt$ImageBox$1$1", f = "ImageBox.kt", i = {}, l = {BR.bgBarVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ImageBoxKt$ImageBox$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $alpha;
    final /* synthetic */ ImageResource $flatten;
    final /* synthetic */ MutableState<Pair<ImageResource, Float>> $last;
    final /* synthetic */ MutableState<Boolean> $toDelay;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageBoxKt$ImageBox$1$1(MutableState<Boolean> mutableState, MutableState<Pair<ImageResource, Float>> mutableState2, ImageResource imageResource, float f, Continuation<? super ImageBoxKt$ImageBox$1$1> continuation) {
        super(2, continuation);
        this.$toDelay = mutableState;
        this.$last = mutableState2;
        this.$flatten = imageResource;
        this.$alpha = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageBoxKt$ImageBox$1$1(this.$toDelay, this.$last, this.$flatten, this.$alpha, continuation);
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
                if (DelayKt.delay(100L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$toDelay.setValue(Boxing.boxBoolean(false));
        this.$last.setValue(TuplesKt.to(this.$flatten, Boxing.boxFloat(this.$alpha)));
        return Unit.INSTANCE;
    }
}