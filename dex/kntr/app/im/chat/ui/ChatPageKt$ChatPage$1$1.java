package kntr.app.im.chat.ui;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import im.base.IMToast;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
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
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$1$1", f = "ChatPage.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatPageKt$ChatPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<StickerManagerData> $stickerManagerState$delegate;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatPageKt$ChatPage$1$1(State<StickerManagerData> state, Toaster toaster, Continuation<? super ChatPageKt$ChatPage$1$1> continuation) {
        super(2, continuation);
        this.$stickerManagerState$delegate = state;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatPageKt$ChatPage$1$1(this.$stickerManagerState$delegate, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final State<StickerManagerData> state = this.$stickerManagerState$delegate;
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.filterNotNull(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.im.chat.ui.ChatPageKt$ChatPage$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        IMToast invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ChatPageKt$ChatPage$1$1.invokeSuspend$lambda$0(state);
                        return invokeSuspend$lambda$0;
                    }
                })));
                final Toaster toaster = this.$toaster;
                this.label = 1;
                if (distinctUntilChanged.collect(new FlowCollector() { // from class: kntr.app.im.chat.ui.ChatPageKt$ChatPage$1$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((IMToast) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(IMToast it, Continuation<? super Unit> continuation) {
                        Toaster.-CC.showToast$default(toaster, it.getContent(), (ToastDuration) null, 2, (Object) null);
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
    public static final IMToast invokeSuspend$lambda$0(State $stickerManagerState$delegate) {
        StickerManagerData ChatPage$lambda$1;
        ChatPage$lambda$1 = ChatPageKt.ChatPage$lambda$1($stickerManagerState$delegate);
        return ChatPage$lambda$1.getToast();
    }
}