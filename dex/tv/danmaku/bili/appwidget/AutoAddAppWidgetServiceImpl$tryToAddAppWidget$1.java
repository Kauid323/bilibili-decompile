package tv.danmaku.bili.appwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoAddAppWidgetServiceImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.AutoAddAppWidgetServiceImpl", f = "AutoAddAppWidgetServiceImpl.kt", i = {0, 0}, l = {BR.check, 102}, m = "tryToAddAppWidget", n = {AudioIntentHelper.FROM_ACTIVITY, "scene"}, s = {"L$0", "L$1"}, v = 1)
public final class AutoAddAppWidgetServiceImpl$tryToAddAppWidget$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutoAddAppWidgetServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoAddAppWidgetServiceImpl$tryToAddAppWidget$1(AutoAddAppWidgetServiceImpl autoAddAppWidgetServiceImpl, Continuation<? super AutoAddAppWidgetServiceImpl$tryToAddAppWidget$1> continuation) {
        super(continuation);
        this.this$0 = autoAddAppWidgetServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object tryToAddAppWidget;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        tryToAddAppWidget = this.this$0.tryToAddAppWidget(null, null, (Continuation) this);
        return tryToAddAppWidget;
    }
}