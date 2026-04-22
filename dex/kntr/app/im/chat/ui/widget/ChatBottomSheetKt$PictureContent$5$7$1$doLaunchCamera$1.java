package kntr.app.im.chat.ui.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt", f = "ChatBottomSheet.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {398, 411, 418}, m = "PictureContent$lambda$10$6$0$doLaunchCamera", n = {"cameraCaptureLauncher", "$actionHandler", "cameraCaptureLauncher", "$actionHandler", "result", "cameraCaptureLauncher", "$actionHandler", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class ChatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1(Continuation<? super ChatBottomSheetKt$PictureContent$5$7$1$doLaunchCamera$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object PictureContent$lambda$10$6$0$doLaunchCamera;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        PictureContent$lambda$10$6$0$doLaunchCamera = ChatBottomSheetKt.PictureContent$lambda$10$6$0$doLaunchCamera(null, null, (Continuation) this);
        return PictureContent$lambda$10$6$0$doLaunchCamera;
    }
}