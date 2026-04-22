package tv.danmaku.bili.appwidget.upcard;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpCardAppWidgetUpdater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.UpCardAppWidgetUpdaterKt", f = "UpCardAppWidgetUpdater.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {BR.danmakuOpen}, m = "updateWidgetView", n = {"$this$updateWidgetView", "context", "appWidgetManager", "appWidgetIds", "data", "appStatus", "cardCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
public final class UpCardAppWidgetUpdaterKt$updateWidgetView$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpCardAppWidgetUpdaterKt$updateWidgetView$1(Continuation<? super UpCardAppWidgetUpdaterKt$updateWidgetView$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object updateWidgetView;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateWidgetView = UpCardAppWidgetUpdaterKt.updateWidgetView(null, null, null, null, null, 0, (Continuation) this);
        return updateWidgetView;
    }
}