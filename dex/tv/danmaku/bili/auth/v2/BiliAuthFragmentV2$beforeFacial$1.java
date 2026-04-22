package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliAuthFragmentV2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2", f = "BiliAuthFragmentV2.kt", i = {}, l = {BR.isFullScreen}, m = "beforeFacial", n = {}, s = {}, v = 1)
public final class BiliAuthFragmentV2$beforeFacial$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BiliAuthFragmentV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliAuthFragmentV2$beforeFacial$1(BiliAuthFragmentV2 biliAuthFragmentV2, Continuation<? super BiliAuthFragmentV2$beforeFacial$1> continuation) {
        super(continuation);
        this.this$0 = biliAuthFragmentV2;
    }

    public final Object invokeSuspend(Object obj) {
        Object beforeFacial;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        beforeFacial = this.this$0.beforeFacial((Continuation) this);
        return beforeFacial;
    }
}