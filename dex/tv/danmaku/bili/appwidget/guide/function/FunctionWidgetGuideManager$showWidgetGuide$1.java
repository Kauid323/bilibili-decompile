package tv.danmaku.bili.appwidget.guide.function;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FunctionWidgetGuideManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideManager", f = "FunctionWidgetGuideManager.kt", i = {}, l = {BR.currentItem}, m = "showWidgetGuide", n = {}, s = {}, v = 1)
public final class FunctionWidgetGuideManager$showWidgetGuide$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FunctionWidgetGuideManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionWidgetGuideManager$showWidgetGuide$1(FunctionWidgetGuideManager functionWidgetGuideManager, Continuation<? super FunctionWidgetGuideManager$showWidgetGuide$1> continuation) {
        super(continuation);
        this.this$0 = functionWidgetGuideManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object showWidgetGuide;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showWidgetGuide = this.this$0.showWidgetGuide(null, null, (Continuation) this);
        return showWidgetGuide;
    }
}