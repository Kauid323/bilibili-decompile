package tv.danmaku.bili.appwidget.upcard;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpCardAppWidgetUpdater.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.UpCardAppWidgetUpdaterKt", f = "UpCardAppWidgetUpdater.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {BR.followDescColor}, m = "updateWidgetBySizes", n = {"context", "appWidgetManager", "data", "coverBitmaps", "avatarBitmap", "$this$forEach$iv", "appStatus", "cardCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
public final class UpCardAppWidgetUpdaterKt$updateWidgetBySizes$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpCardAppWidgetUpdaterKt$updateWidgetBySizes$1(Continuation<? super UpCardAppWidgetUpdaterKt$updateWidgetBySizes$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object updateWidgetBySizes;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateWidgetBySizes = UpCardAppWidgetUpdaterKt.updateWidgetBySizes(null, null, null, null, null, 0, null, (Continuation) this);
        return updateWidgetBySizes;
    }
}