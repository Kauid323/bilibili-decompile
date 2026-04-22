package kntr.app.appwidget.guide;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetGuideHolder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.appwidget.guide.AppWidgetGuideHolder", f = "AppWidgetGuideHolder.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {57, 95}, m = "showGuide", n = {"context", "component", "spmid", "upperMid", "type", "offset", "duration", "outsideTouchable", AdAlarmExtraKey.AID, "context", "component", "spmid", "reply", "it", "params", "avatars", "upperMid", "type", "offset", "duration", "outsideTouchable", AdAlarmExtraKey.AID, "$i$a$-let-AppWidgetGuideHolder$showGuide$2"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "I$1", "J$1", "Z$0", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1", "J$1", "Z$0", "J$2", "I$2"}, v = 1)
public final class AppWidgetGuideHolder$showGuide$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppWidgetGuideHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetGuideHolder$showGuide$1(AppWidgetGuideHolder appWidgetGuideHolder, Continuation<? super AppWidgetGuideHolder$showGuide$1> continuation) {
        super(continuation);
        this.this$0 = appWidgetGuideHolder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showGuide(null, null, null, 0L, 0, 0, 0L, false, 0L, (Continuation) this);
    }
}