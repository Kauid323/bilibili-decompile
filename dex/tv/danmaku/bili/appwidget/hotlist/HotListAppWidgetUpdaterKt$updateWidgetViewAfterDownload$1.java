package tv.danmaku.bili.appwidget.hotlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotListAppWidgetUpdater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.HotListAppWidgetUpdaterKt", f = "HotListAppWidgetUpdater.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {BR.endIcon, 192, BR.eventHandle, BR.follow, BR.followIconDrawable, BR.followed, BR.foregroundViewVisible}, m = "updateWidgetViewAfterDownload", n = {"context", "data", "coverBitmaps", "appWidgetManager", "appWidgetIds", "appStatus", "context", "data", "coverBitmaps", "appWidgetManager", "appWidgetIds", "appStatus", "appWidgetManager", "appWidgetIds", "context", "data", "coverBitmaps", "appWidgetManager", "$this$forEach$iv", "appStatus", "context", "data", "coverBitmaps", "appWidgetManager", "$this$forEach$iv", "appStatus", "context", "data", "coverBitmaps", "appWidgetManager", "$this$forEach$iv", "appStatus", "context", "data", "coverBitmaps", "appWidgetManager", "$this$forEach$iv", "appStatus"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class HotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1(Continuation<? super HotListAppWidgetUpdaterKt$updateWidgetViewAfterDownload$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object updateWidgetViewAfterDownload;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateWidgetViewAfterDownload = HotListAppWidgetUpdaterKt.updateWidgetViewAfterDownload(null, null, null, 0, null, null, (Continuation) this);
        return updateWidgetViewAfterDownload;
    }
}