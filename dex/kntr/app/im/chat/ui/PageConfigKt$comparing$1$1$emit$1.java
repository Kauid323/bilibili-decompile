package kntr.app.im.chat.ui;

import kntr.app.im.chat.ui.PageConfigKt$comparing$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageConfig.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.PageConfigKt$comparing$1$1", f = "PageConfig.kt", i = {0, 1}, l = {86, 86}, m = "emit", n = {"it", "it"}, s = {"L$0", "L$0"}, v = 1)
public final class PageConfigKt$comparing$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageConfigKt$comparing$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PageConfigKt$comparing$1$1$emit$1(PageConfigKt$comparing$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super PageConfigKt$comparing$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (Continuation) this);
    }
}