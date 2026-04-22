package im.session.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionSecondaryDataSourceService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionSecondaryDataSourceService", f = "IMSessionSecondaryDataSourceService.kt", i = {0, 0}, l = {35}, m = "loadNext-0E7RQCE", n = {"pageType", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSessionSecondaryDataSourceService$loadNext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionSecondaryDataSourceService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionSecondaryDataSourceService$loadNext$1(IMSessionSecondaryDataSourceService iMSessionSecondaryDataSourceService, Continuation<? super IMSessionSecondaryDataSourceService$loadNext$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionSecondaryDataSourceService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo3356loadNext0E7RQCE = this.this$0.mo3356loadNext0E7RQCE(null, null, (Continuation) this);
        return mo3356loadNext0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo3356loadNext0E7RQCE : Result.box-impl(mo3356loadNext0E7RQCE);
    }
}