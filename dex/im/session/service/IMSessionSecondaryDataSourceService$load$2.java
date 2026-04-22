package im.session.service;

import host.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionSecondaryDataSourceService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionSecondaryDataSourceService", f = "IMSessionSecondaryDataSourceService.kt", i = {0, 0, 0}, l = {R.styleable.CameraView_cameraSnapshotMaxWidth}, m = "load-gIAlu-s", n = {"param", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionSecondaryDataSourceService$load$3"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class IMSessionSecondaryDataSourceService$load$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionSecondaryDataSourceService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionSecondaryDataSourceService$load$2(IMSessionSecondaryDataSourceService iMSessionSecondaryDataSourceService, Continuation<? super IMSessionSecondaryDataSourceService$load$2> continuation) {
        super(continuation);
        this.this$0 = iMSessionSecondaryDataSourceService;
    }

    public final Object invokeSuspend(Object obj) {
        Object m3362loadgIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3362loadgIAlus = this.this$0.m3362loadgIAlus(null, (Continuation) this);
        return m3362loadgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3362loadgIAlus : Result.box-impl(m3362loadgIAlus);
    }
}