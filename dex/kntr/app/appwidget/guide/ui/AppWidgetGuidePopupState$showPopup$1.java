package kntr.app.appwidget.guide.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetGuidePopupState.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.appwidget.guide.ui.AppWidgetGuidePopupState", f = "AppWidgetGuidePopupState.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {137}, m = "showPopup$guide_debug", n = {"avatar", "title", "subtitle", "forceDark", "offset", "duration", "outsideTouchable", "style", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$2", "Z$0", "I$0", "J$0", "Z$1", "I$1", "I$2"}, v = 1)
public final class AppWidgetGuidePopupState$showPopup$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppWidgetGuidePopupState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetGuidePopupState$showPopup$1(AppWidgetGuidePopupState appWidgetGuidePopupState, Continuation<? super AppWidgetGuidePopupState$showPopup$1> continuation) {
        super(continuation);
        this.this$0 = appWidgetGuidePopupState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showPopup$guide_debug(null, null, null, false, 0, 0L, false, 0, (Continuation) this);
    }
}