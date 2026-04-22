package tv.danmaku.bili.appwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoAddAppWidgetServiceImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.AutoAddAppWidgetServiceImpl", f = "AutoAddAppWidgetServiceImpl.kt", i = {}, l = {BR.danmukuTvText}, m = "tryToAddAppWidgetFromMainSpace", n = {}, s = {}, v = 1)
public final class AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutoAddAppWidgetServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1(AutoAddAppWidgetServiceImpl autoAddAppWidgetServiceImpl, Continuation<? super AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1> continuation) {
        super(continuation);
        this.this$0 = autoAddAppWidgetServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object tryToAddAppWidgetFromMainSpace;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        tryToAddAppWidgetFromMainSpace = this.this$0.tryToAddAppWidgetFromMainSpace(null, null, (Continuation) this);
        return tryToAddAppWidgetFromMainSpace;
    }
}