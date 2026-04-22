package kntr.app.game.base.ui;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.ExposerKt$reportOnExposure$1$1$1", f = "Exposer.kt", i = {}, l = {57, 60}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ExposerKt$reportOnExposure$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IExposureCollector $collector;
    final /* synthetic */ Function0<Unit> $onExpose;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposerKt$reportOnExposure$1$1$1(IExposureCollector iExposureCollector, Function0<Unit> function0, Continuation<? super ExposerKt$reportOnExposure$1$1$1> continuation) {
        super(2, continuation);
        this.$collector = iExposureCollector;
        this.$onExpose = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExposerKt$reportOnExposure$1$1$1(this.$collector, this.$onExpose, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$collector.start(this.$onExpose, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 2;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    throw new KotlinNothingValueException();
                case 1:
                    ResultKt.throwOnFailure($result);
                    this.label = 2;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                    }
                    throw new KotlinNothingValueException();
                case 2:
                    ResultKt.throwOnFailure($result);
                    throw new KotlinNothingValueException();
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            this.$collector.onCollect(null);
            throw th;
        }
    }
}