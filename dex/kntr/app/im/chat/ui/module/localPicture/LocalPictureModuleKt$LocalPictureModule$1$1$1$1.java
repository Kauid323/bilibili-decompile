package kntr.app.im.chat.ui.module.localPicture;

import androidx.compose.ui.unit.IntRect;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalPictureModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "imageSource", "Lkntr/base/imageloader/ImageSource;", "frameInWindow", "Landroidx/compose/ui/unit/IntRect;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$LocalPictureModule$1$1$1$1", f = "LocalPictureModule.kt", i = {0, 0}, l = {104}, m = "invokeSuspend", n = {"imageSource", "frameInWindow"}, s = {"L$0", "L$1"}, v = 1)
public final class LocalPictureModuleKt$LocalPictureModule$1$1$1$1 extends SuspendLambda implements Function3<ImageSource, IntRect, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ EntityMessage $message;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPictureModuleKt$LocalPictureModule$1$1$1$1(ChatActionHandler chatActionHandler, EntityMessage entityMessage, Continuation<? super LocalPictureModuleKt$LocalPictureModule$1$1$1$1> continuation) {
        super(3, continuation);
        this.$actionHandler = chatActionHandler;
        this.$message = entityMessage;
    }

    public final Object invoke(ImageSource imageSource, IntRect intRect, Continuation<? super Unit> continuation) {
        LocalPictureModuleKt$LocalPictureModule$1$1$1$1 localPictureModuleKt$LocalPictureModule$1$1$1$1 = new LocalPictureModuleKt$LocalPictureModule$1$1$1$1(this.$actionHandler, this.$message, continuation);
        localPictureModuleKt$LocalPictureModule$1$1$1$1.L$0 = imageSource;
        localPictureModuleKt$LocalPictureModule$1$1$1$1.L$1 = intRect;
        return localPictureModuleKt$LocalPictureModule$1$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ImageSource imageSource = (ImageSource) this.L$0;
        IntRect frameInWindow = (IntRect) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(imageSource);
                this.L$1 = SpillingKt.nullOutSpilledVariable(frameInWindow);
                this.label = 1;
                if (this.$actionHandler.invoke(new ChatAction.ImagePreviewClicked(this.$message, 0, frameInWindow, imageSource), (Continuation) this) == coroutine_suspended) {
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
}