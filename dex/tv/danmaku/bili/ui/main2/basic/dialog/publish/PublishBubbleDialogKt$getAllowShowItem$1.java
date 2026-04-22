package tv.danmaku.bili.ui.main2.basic.dialog.publish;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PublishBubbleDialog.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubbleDialogKt", f = "PublishBubbleDialog.kt", i = {0}, l = {BR.hasPendant}, m = "getAllowShowItem", n = {"showTimeInSevenDays"}, s = {"I$0"}, v = 1)
public final class PublishBubbleDialogKt$getAllowShowItem$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublishBubbleDialogKt$getAllowShowItem$1(Continuation<? super PublishBubbleDialogKt$getAllowShowItem$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object allowShowItem;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        allowShowItem = PublishBubbleDialogKt.getAllowShowItem((Continuation) this);
        return allowShowItem;
    }
}