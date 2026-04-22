package kntr.app.digital.preview.usage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DigitalUsageMenuDialogService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.usage.DigitalUsageMenuDialogService", f = "DigitalUsageMenuDialogService.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {49, 59}, m = "usage", n = {"cardIdInfo", "cardIdInfo", "$this$fold$iv", "result", "usingMenus", "$i$f$fold", "$i$a$-fold-DigitalUsageMenuDialogService$usage$2"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
public final class DigitalUsageMenuDialogService$usage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalUsageMenuDialogService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalUsageMenuDialogService$usage$1(DigitalUsageMenuDialogService digitalUsageMenuDialogService, Continuation<? super DigitalUsageMenuDialogService$usage$1> continuation) {
        super(continuation);
        this.this$0 = digitalUsageMenuDialogService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.usage((Continuation) this);
    }
}