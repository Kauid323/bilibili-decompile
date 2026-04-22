package kntr.app.im.chat.service.sender.image;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalImageAsset.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.LocalImageAssetFinder", f = "LocalImageAsset.kt", i = {0, 0, 0, 0}, l = {55}, m = "findAssetByIdentifier-gIAlu-s", n = {"identifier", "path", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-LocalImageAssetFinder$findAssetByIdentifier$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class LocalImageAssetFinder$findAssetByIdentifier$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalImageAssetFinder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalImageAssetFinder$findAssetByIdentifier$1(LocalImageAssetFinder localImageAssetFinder, Continuation<? super LocalImageAssetFinder$findAssetByIdentifier$1> continuation) {
        super(continuation);
        this.this$0 = localImageAssetFinder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1605findAssetByIdentifiergIAlus = this.this$0.m1605findAssetByIdentifiergIAlus(null, (Continuation) this);
        return m1605findAssetByIdentifiergIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1605findAssetByIdentifiergIAlus : Result.box-impl(m1605findAssetByIdentifiergIAlus);
    }
}