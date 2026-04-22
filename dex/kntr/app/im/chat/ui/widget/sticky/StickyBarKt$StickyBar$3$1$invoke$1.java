package kntr.app.im.chat.ui.widget.sticky;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickyBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.sticky.StickyBarKt$StickyBar$3$1", f = "StickyBar.kt", i = {0}, l = {132}, m = "invoke", n = {"action"}, s = {"L$0"}, v = 1)
public final class StickyBarKt$StickyBar$3$1$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickyBarKt$StickyBar$3$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickyBarKt$StickyBar$3$1$invoke$1(StickyBarKt$StickyBar$3$1 stickyBarKt$StickyBar$3$1, Continuation<? super StickyBarKt$StickyBar$3$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = stickyBarKt$StickyBar$3$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, (Continuation) this);
    }
}