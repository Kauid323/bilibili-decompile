package kntr.app.im.chat.ui.utils;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PictureLifecycleKeyHandle.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$2$1", f = "PictureLifecycleKeyHandle.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PictureLifecycleKeyHandle$register$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PictureLifecycleKeyHandle this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureLifecycleKeyHandle$register$2$1(PictureLifecycleKeyHandle pictureLifecycleKeyHandle, Continuation<? super PictureLifecycleKeyHandle$register$2$1> continuation) {
        super(2, continuation);
        this.this$0 = pictureLifecycleKeyHandle;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureLifecycleKeyHandle$register$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PictureLifecycleKeyHandle pictureLifecycleKeyHandle = this.this$0;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = PictureLifecycleKeyHandle$register$2$1.invokeSuspend$lambda$0(PictureLifecycleKeyHandle.this);
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                });
                final PictureLifecycleKeyHandle pictureLifecycleKeyHandle2 = this.this$0;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle$register$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Boolean) value).booleanValue(), $completion);
                    }

                    public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                        MutableIntState mutableIntState;
                        if (it) {
                            mutableIntState = PictureLifecycleKeyHandle.this.innerInt;
                            mutableIntState.setValue(mutableIntState.getValue().intValue() + 1);
                        }
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(PictureLifecycleKeyHandle this$0) {
        MutableState mutableState;
        mutableState = this$0.innerState;
        return ((Boolean) mutableState.getValue()).booleanValue();
    }
}