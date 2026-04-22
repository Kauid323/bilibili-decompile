package kntr.common.photonic.compressor;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetCompressor.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.compressor.AssetCompressorKt", f = "AssetCompressor.kt", i = {0, 0, 0, 0, 0}, l = {46}, m = "compress", n = {"$this$compress", "asset", "expectResolution", "expectRatio", "expectContentSize"}, s = {"L$0", "L$1", "L$2", "D$0", "D$1"}, v = 1)
public final class AssetCompressorKt$compress$1<T extends Asset> extends ContinuationImpl {
    double D$0;
    double D$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetCompressorKt$compress$1(Continuation<? super AssetCompressorKt$compress$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object compress = AssetCompressorKt.compress(null, null, null, 0.0d, (Continuation) this);
        return compress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? compress : Result.m2635boximpl(compress);
    }
}