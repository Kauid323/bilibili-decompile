package kntr.app.game.base.ui.util;

import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ClipBoard.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.util.AndroidClipboardManagerImpl$copyText$2", f = "ClipBoard.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AndroidClipboardManagerImpl$copyText$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ AndroidClipboardManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidClipboardManagerImpl$copyText$2(AndroidClipboardManagerImpl androidClipboardManagerImpl, String str, Continuation<? super AndroidClipboardManagerImpl$copyText$2> continuation) {
        super(2, continuation);
        this.this$0 = androidClipboardManagerImpl;
        this.$text = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidClipboardManagerImpl$copyText$2(this.this$0, this.$text, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ClipboardManager clipboardManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    clipboardManager = this.this$0.context;
                    clipboardManager.setText(new AnnotatedString(this.$text, (List) null, 2, (DefaultConstructorMarker) null));
                    return Unit.INSTANCE;
                } catch (Exception e) {
                    throw new ClipboardException("Failed to copy text to clipboard", e);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}