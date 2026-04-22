package kntr.app.im.chat.ui.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatMediaSelectBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1", f = "ChatMediaSelectBottomSheet.kt", i = {0, 0}, l = {245}, m = "onPostFling-RZ2iAVY", n = {"$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0"}, s = {"J$0", "J$1"}, v = 1)
public final class ChatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1$onPostFling$1(ChatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1 chatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1, Continuation<? super ChatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = chatMediaSelectBottomSheetKt$preUpPostDownNestedScrollConnection$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1929onPostFlingRZ2iAVY(0L, 0L, (Continuation) this);
    }
}