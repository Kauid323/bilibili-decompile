package tv.danmaku.bili.ui.main2.mine.topleft;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: ActivityAnswer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.topleft.ActivityAnswerKt$ActivityAnswer$1$1", f = "ActivityAnswer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ActivityAnswerKt$ActivityAnswer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityAnswerKt$ActivityAnswer$1$1(Continuation<? super ActivityAnswerKt$ActivityAnswer$1$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityAnswerKt$ActivityAnswer$1$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Neurons.reportExposure$default(false, "main.my-information.answer-in-guide.0.show", MapsKt.mapOf(TuplesKt.to("type", AudioIntentHelper.FROM_ACTIVITY)), (List) null, 8, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}