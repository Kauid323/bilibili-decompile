package im.session.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionHomeDataSourceService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionHomeDataSourceService", f = "IMSessionHomeDataSourceService.kt", i = {0, 0, 0}, l = {103}, m = "loadNext-gIAlu-s", n = {"param", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionHomeDataSourceService$loadNext$3"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class IMSessionHomeDataSourceService$loadNext$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionHomeDataSourceService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionHomeDataSourceService$loadNext$2(IMSessionHomeDataSourceService iMSessionHomeDataSourceService, Continuation<? super IMSessionHomeDataSourceService$loadNext$2> continuation) {
        super(continuation);
        this.this$0 = iMSessionHomeDataSourceService;
    }

    public final Object invokeSuspend(Object obj) {
        Object m3358loadNextgIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3358loadNextgIAlus = this.this$0.m3358loadNextgIAlus(null, (Continuation) this);
        return m3358loadNextgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3358loadNextgIAlus : Result.box-impl(m3358loadNextgIAlus);
    }
}