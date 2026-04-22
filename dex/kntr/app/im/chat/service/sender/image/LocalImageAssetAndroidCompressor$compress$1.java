package kntr.app.im.chat.service.sender.image;

import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalImageAsset.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.LocalImageAssetAndroidCompressor", f = "LocalImageAsset.android.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {69, 71}, m = "compress-OkegGBo", n = {"asset", "expectResolution", "$v$c$kntr-common-photonic-ContentSize$-expectContentSize$0", "asset", "expectResolution", "byteArray", "$v$c$kntr-common-photonic-ContentSize$-expectContentSize$0"}, s = {"L$0", "L$1", "D$0", "L$0", "L$1", "L$2", "D$0"}, v = 1)
public final class LocalImageAssetAndroidCompressor$compress$1 extends ContinuationImpl {
    double D$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalImageAssetAndroidCompressor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalImageAssetAndroidCompressor$compress$1(LocalImageAssetAndroidCompressor localImageAssetAndroidCompressor, Continuation<? super LocalImageAssetAndroidCompressor$compress$1> continuation) {
        super(continuation);
        this.this$0 = localImageAssetAndroidCompressor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m1600compressOkegGBo = this.this$0.m1600compressOkegGBo((LocalImageAsset) null, (Resolution) null, 0.0d, (Continuation) this);
        return m1600compressOkegGBo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1600compressOkegGBo : Result.box-impl(m1600compressOkegGBo);
    }
}