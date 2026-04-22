package tv.danmaku.bili.ui.main2.basic;

import com.bilibili.lib.homepage.home.model.ToolbarEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.basic.BaseMainFrameComponentKt$observerAppbar$1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMainFrameComponent.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.basic.BaseMainFrameComponentKt$observerAppbar$1$1", f = "BaseMainFrameComponent.kt", i = {}, l = {BR.backgroundDrawable}, m = "emit", n = {}, s = {}, v = 1)
public final class BaseMainFrameComponentKt$observerAppbar$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseMainFrameComponentKt$observerAppbar$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseMainFrameComponentKt$observerAppbar$1$1$emit$1(BaseMainFrameComponentKt$observerAppbar$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super BaseMainFrameComponentKt$observerAppbar$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ToolbarEvent) null, (Continuation) this);
    }
}