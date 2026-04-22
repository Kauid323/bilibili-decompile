package im.session.home;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMQuickLink.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.home.QuickLinkState", f = "IMQuickLink.kt", i = {0}, l = {TbsListener.ErrorCode.RENAME_NO_NEED_SENDREQUEST}, m = "onBubbleClick", n = {"item"}, s = {"L$0"}, v = 1)
public final class QuickLinkState$onBubbleClick$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickLinkState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLinkState$onBubbleClick$1(QuickLinkState quickLinkState, Continuation<? super QuickLinkState$onBubbleClick$1> continuation) {
        super(continuation);
        this.this$0 = quickLinkState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onBubbleClick((Continuation) this);
    }
}