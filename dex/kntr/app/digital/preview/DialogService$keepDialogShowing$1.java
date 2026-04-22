package kntr.app.digital.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.DialogService", f = "DialogService.kt", i = {0, 0, 0, 0}, l = {31}, m = "keepDialogShowing", n = {"block", "dismissRequest", "scope", "dialogContent"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class DialogService$keepDialogShowing$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DialogService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogService$keepDialogShowing$1(DialogService dialogService, Continuation<? super DialogService$keepDialogShowing$1> continuation) {
        super(continuation);
        this.this$0 = dialogService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.keepDialogShowing(null, (Continuation) this);
    }
}