package kntr.app.im.chat.ui;

import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.ui.widget.InputBoxState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ChatPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$3$1", f = "ChatPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ChatPageKt$ChatPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InputBoxState $inputBoxState;
    final /* synthetic */ ChatPageData $pageData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatPageKt$ChatPage$3$1(InputBoxState inputBoxState, ChatPageData chatPageData, Continuation<? super ChatPageKt$ChatPage$3$1> continuation) {
        super(2, continuation);
        this.$inputBoxState = inputBoxState;
        this.$pageData = chatPageData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatPageKt$ChatPage$3$1(this.$inputBoxState, this.$pageData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                InputBoxState inputBoxState = this.$inputBoxState;
                ChatInfo chatInfo = this.$pageData.getChatInfo();
                inputBoxState.setInputBoxConfig(chatInfo != null ? chatInfo.getInputBoxConfig() : null);
                this.$inputBoxState.setInputBoxContent(this.$pageData.getInputContent());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}