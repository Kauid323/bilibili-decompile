package tv.danmaku.bili.ui.garb.utils;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionImageColorHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.utils.CollectionImageColorHelper", f = "CollectionImageColorHelper.kt", i = {0}, l = {BR.followDescColor}, m = "await-gIAlu-s", n = {"$this$await_u2dgIAlu_u2ds"}, s = {"L$0"}, v = 1)
public final class CollectionImageColorHelper$await$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectionImageColorHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionImageColorHelper$await$1(CollectionImageColorHelper collectionImageColorHelper, Continuation<? super CollectionImageColorHelper$await$1> continuation) {
        super(continuation);
        this.this$0 = collectionImageColorHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1783awaitgIAlus = this.this$0.m1783awaitgIAlus(null, (Continuation) this);
        return m1783awaitgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1783awaitgIAlus : Result.box-impl(m1783awaitgIAlus);
    }
}