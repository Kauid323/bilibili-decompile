package kntr.app.im.chat.stateMachine.builder;

import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.clipboard.ClipboardService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitLoad.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/core/model/ChatAction$CopyTextIntoClipBoard;", "state", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.InitLoadKt$bindClipboardAction$1", f = "InitLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InitLoadKt$bindClipboardAction$1 extends SuspendLambda implements Function3<ChatAction.CopyTextIntoClipBoard, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClipboardService $clipboardService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitLoadKt$bindClipboardAction$1(ClipboardService clipboardService, Continuation<? super InitLoadKt$bindClipboardAction$1> continuation) {
        super(3, continuation);
        this.$clipboardService = clipboardService;
    }

    public final Object invoke(ChatAction.CopyTextIntoClipBoard copyTextIntoClipBoard, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        InitLoadKt$bindClipboardAction$1 initLoadKt$bindClipboardAction$1 = new InitLoadKt$bindClipboardAction$1(this.$clipboardService, continuation);
        initLoadKt$bindClipboardAction$1.L$0 = copyTextIntoClipBoard;
        return initLoadKt$bindClipboardAction$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ChatAction.CopyTextIntoClipBoard action = (ChatAction.CopyTextIntoClipBoard) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$clipboardService.writeTextIntoClipBoard(action.getText());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}