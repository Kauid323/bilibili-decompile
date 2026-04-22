package kntr.app.im.chat.ui;

import kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageConfig.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.PageConfigKt$configPageScroll$1$1$4", f = "PageConfig.kt", i = {0, 1}, l = {38, 40}, m = "emit", n = {"it", "it"}, s = {"Z$0", "Z$0"}, v = 1)
public final class PageConfigKt$configPageScroll$1$1$4$emit$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageConfigKt$configPageScroll$1$1.AnonymousClass4<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PageConfigKt$configPageScroll$1$1$4$emit$1(PageConfigKt$configPageScroll$1$1.AnonymousClass4<? super T> anonymousClass4, Continuation<? super PageConfigKt$configPageScroll$1$1$4$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass4;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(false, (Continuation) this);
    }
}