package tv.danmaku.bili.ui.garb.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionImageColorHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.utils.CollectionImageColorHelper", f = "CollectionImageColorHelper.kt", i = {0, 0}, l = {BR.bottomDisplay3, BR.btnTryAgainText}, m = "getColorFromSource", n = {"hsbConverter", "defaultColor"}, s = {"L$0", "I$0"}, v = 1)
public final class CollectionImageColorHelper$getColorFromSource$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectionImageColorHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionImageColorHelper$getColorFromSource$1(CollectionImageColorHelper collectionImageColorHelper, Continuation<? super CollectionImageColorHelper$getColorFromSource$1> continuation) {
        super(continuation);
        this.this$0 = collectionImageColorHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getColorFromSource(null, null, 0, null, 0, 0, (Continuation) this);
    }
}