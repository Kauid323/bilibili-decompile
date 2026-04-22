package im.keywordBlocking;

import com.yalantis.ucrop.UCrop;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBPageData.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.KBPageData", f = "KBPageData.kt", i = {0, 0, 0}, l = {UCrop.REQUEST_CROP}, m = "receive$keyword_blocking_debug", n = {"result", "it", "$i$a$-fold-KBPageData$receive$3"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class KBPageData$receive$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KBPageData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBPageData$receive$1(KBPageData kBPageData, Continuation<? super KBPageData$receive$1> continuation) {
        super(continuation);
        this.this$0 = kBPageData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.receive$keyword_blocking_debug(null, (Continuation) this);
    }
}