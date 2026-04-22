package kntr.app.game.base.ui;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "visible", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.DefaultExposureCollector$start$3", f = "Exposer.kt", i = {0}, l = {100}, m = "invokeSuspend", n = {"visible"}, s = {"Z$0"}, v = 1)
final class DefaultExposureCollector$start$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DefaultExposureCollector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultExposureCollector$start$3(DefaultExposureCollector defaultExposureCollector, Continuation<? super DefaultExposureCollector$start$3> continuation) {
        super(2, continuation);
        this.this$0 = defaultExposureCollector;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultExposureCollector$start$3 = new DefaultExposureCollector$start$3(this.this$0, continuation);
        defaultExposureCollector$start$3.Z$0 = ((Boolean) obj).booleanValue();
        return defaultExposureCollector$start$3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ExposureConfig exposureConfig;
        ExposureConfig exposureConfig2;
        boolean visible = this.Z$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (visible) {
                    exposureConfig = this.this$0.config;
                    if (exposureConfig.getVisibleDuration() > 0) {
                        exposureConfig2 = this.this$0.config;
                        this.Z$0 = visible;
                        this.label = 1;
                        if (DelayKt.delay(exposureConfig2.getVisibleDuration(), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    this.this$0.mVisible = false;
                    return null;
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