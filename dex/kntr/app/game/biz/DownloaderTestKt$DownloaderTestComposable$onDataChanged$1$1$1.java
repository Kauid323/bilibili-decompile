package kntr.app.game.biz;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import java.util.List;
import kntr.app.game.base.event.GameEventManager;
import kntr.app.game.base.event.KntrGameStatusEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloaderTest.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.biz.DownloaderTestKt$DownloaderTestComposable$onDataChanged$1$1$1", f = "DownloaderTest.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DownloaderTestKt$DownloaderTestComposable$onDataChanged$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<KBiligame> $data;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloaderTestKt$DownloaderTestComposable$onDataChanged$1$1$1(List<? extends KBiligame> list, Continuation<? super DownloaderTestKt$DownloaderTestComposable$onDataChanged$1$1$1> continuation) {
        super(2, continuation);
        this.$data = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloaderTestKt$DownloaderTestComposable$onDataChanged$1$1$1(this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<KntrGameStatusEvent> eventFlow = GameEventManager.INSTANCE.getEventFlow();
                final List<KBiligame> list = this.$data;
                this.label = 1;
                if (eventFlow.collect(new FlowCollector() { // from class: kntr.app.game.biz.DownloaderTestKt$DownloaderTestComposable$onDataChanged$1$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((KntrGameStatusEvent) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(KntrGameStatusEvent it, Continuation<? super Unit> continuation) {
                        DownloaderTestKt.handleGameStatusEvent(list, it);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}