package kntr.app.im.chat.ui.widget;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$PictureContent$5$7$1$1", f = "ChatBottomSheet.kt", i = {0, 0, 0, 0}, l = {428}, m = "invokeSuspend$checkStatusAndPerform", n = {"showCameraPermissionDialog", "cameraCaptureLauncher", "$actionHandler", AdAlarmExtraKey.STATUS}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class ChatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1(Continuation<? super ChatBottomSheetKt$PictureContent$5$7$1$1$checkStatusAndPerform$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object invokeSuspend$checkStatusAndPerform;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeSuspend$checkStatusAndPerform = ChatBottomSheetKt$PictureContent$5$7$1$1.invokeSuspend$checkStatusAndPerform(null, null, null, null, (Continuation) this);
        return invokeSuspend$checkStatusAndPerform;
    }
}