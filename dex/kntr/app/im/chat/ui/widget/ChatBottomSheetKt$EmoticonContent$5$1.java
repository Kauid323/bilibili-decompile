package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.im.chat.sticker.StickerState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$EmoticonContent$5$1", f = "ChatBottomSheet.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatBottomSheetKt$EmoticonContent$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Float>> $progressUpdate;
    final /* synthetic */ StickerState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBottomSheetKt$EmoticonContent$5$1(State<? extends Function0<Float>> state, StickerState stickerState, Continuation<? super ChatBottomSheetKt$EmoticonContent$5$1> continuation) {
        super(2, continuation);
        this.$progressUpdate = state;
        this.$state = stickerState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBottomSheetKt$EmoticonContent$5$1(this.$progressUpdate, this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final State<Function0<Float>> state = this.$progressUpdate;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$EmoticonContent$5$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        float invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ChatBottomSheetKt$EmoticonContent$5$1.invokeSuspend$lambda$0(state);
                        return Float.valueOf(invokeSuspend$lambda$0);
                    }
                });
                final StickerState stickerState = this.$state;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$EmoticonContent$5$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Number) value).floatValue(), $completion);
                    }

                    public final Object emit(float it, Continuation<? super Unit> continuation) {
                        StickerState.this.getProgress().setValue(Boxing.boxFloat(it));
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
    public static final float invokeSuspend$lambda$0(State $progressUpdate) {
        return ((Number) ((Function0) $progressUpdate.getValue()).invoke()).floatValue();
    }
}