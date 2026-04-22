package kntr.app.im.chat.ui.module.picture;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntRect;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.PictureMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.neuron.CardReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PictureModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.module.picture.PictureModuleKt$PictureModule$4$1$1", f = "PictureModule.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PictureModuleKt$PictureModule$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<ChatActionHandler> $actionHandlerState;
    final /* synthetic */ IntRect $frameInWindow;
    final /* synthetic */ ChatMsgFrameScope $frameScope;
    final /* synthetic */ MutableState<ImageSource> $imageSource$delegate;
    final /* synthetic */ EntityMessage $message;
    final /* synthetic */ PictureMsgModule $module;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PictureModuleKt$PictureModule$4$1$1(State<? extends ChatActionHandler> state, PictureMsgModule pictureMsgModule, EntityMessage entityMessage, IntRect intRect, ChatMsgFrameScope chatMsgFrameScope, MutableState<ImageSource> mutableState, Continuation<? super PictureModuleKt$PictureModule$4$1$1> continuation) {
        super(2, continuation);
        this.$actionHandlerState = state;
        this.$module = pictureMsgModule;
        this.$message = entityMessage;
        this.$frameInWindow = intRect;
        this.$frameScope = chatMsgFrameScope;
        this.$imageSource$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureModuleKt$PictureModule$4$1$1(this.$actionHandlerState, this.$module, this.$message, this.$frameInWindow, this.$frameScope, this.$imageSource$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ImageSource PictureModule$lambda$4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int index = this.$module.getIndex();
                PictureModule$lambda$4 = PictureModuleKt.PictureModule$lambda$4(this.$imageSource$delegate);
                this.label = 1;
                if (((ChatActionHandler) this.$actionHandlerState.getValue()).invoke(new ChatAction.ImagePreviewClicked(this.$message, index, this.$frameInWindow, PictureModule$lambda$4), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CardReporter.CC.reportMsgClick$default(this.$frameScope.getCardReporter(), null, 1, null);
        return Unit.INSTANCE;
    }
}