package tv.danmaku.bili.appwidget.hotword;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotWordAppWidgetUpdater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater", f = "HotWordAppWidgetUpdater.kt", i = {0, 0, 0, 1, 1}, l = {BR.checkContent, 103}, m = "updateAppWidgetInternal", n = {"context", "appWidgetManager", "appWidgetIds", "appWidgetManager", "appWidgetIds"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
public final class HotWordAppWidgetUpdater$updateAppWidgetInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HotWordAppWidgetUpdater this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotWordAppWidgetUpdater$updateAppWidgetInternal$1(HotWordAppWidgetUpdater hotWordAppWidgetUpdater, Continuation<? super HotWordAppWidgetUpdater$updateAppWidgetInternal$1> continuation) {
        super(continuation);
        this.this$0 = hotWordAppWidgetUpdater;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateAppWidgetInternal(null, null, null, false, (Continuation) this);
    }
}