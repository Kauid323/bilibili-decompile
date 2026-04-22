package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.State;
import kntr.app.im.chat.sticker.StickerState;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$EmoticonContent$6$1", f = "ChatBottomSheet.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatBottomSheetKt$EmoticonContent$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StickerState $state;
    final /* synthetic */ State<Function1<StickerAsset, Unit>> $stickerClick;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBottomSheetKt$EmoticonContent$6$1(StickerState stickerState, State<? extends Function1<? super StickerAsset, Unit>> state, Continuation<? super ChatBottomSheetKt$EmoticonContent$6$1> continuation) {
        super(2, continuation);
        this.$state = stickerState;
        this.$stickerClick = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBottomSheetKt$EmoticonContent$6$1(this.$state, this.$stickerClick, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableSharedFlow<StickerAsset> selectedEvent = this.$state.getSelectedEvent();
                final State<Function1<StickerAsset, Unit>> state = this.$stickerClick;
                this.label = 1;
                if (selectedEvent.collect(new FlowCollector() { // from class: kntr.app.im.chat.ui.widget.ChatBottomSheetKt$EmoticonContent$6$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((StickerAsset) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(StickerAsset it, Continuation<? super Unit> continuation) {
                        ((Function1) state.getValue()).invoke(it);
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