package kntr.common.paragraph.assetuploader.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MossAssetUploaderImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.assetuploader.impl.MossAssetUploaderImpl", f = "MossAssetUploaderImpl.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {251, 69}, m = "uploadAsset", n = {"asset", "params", "$this$withLock_u24default$iv", "useOriginImage", "assetIndex", "$i$f$withLock", "asset", "params", "$this$withLock_u24default$iv", "useOriginImage", "assetIndex", "$i$f$withLock", "$i$a$-withLock$default-MossAssetUploaderImpl$uploadAsset$dataToUpload$1"}, s = {"L$0", "L$1", "L$2", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "Z$0", "I$0", "I$1", "I$2"}, v = 1)
public final class MossAssetUploaderImpl$uploadAsset$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MossAssetUploaderImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MossAssetUploaderImpl$uploadAsset$1(MossAssetUploaderImpl mossAssetUploaderImpl, Continuation<? super MossAssetUploaderImpl$uploadAsset$1> continuation) {
        super(continuation);
        this.this$0 = mossAssetUploaderImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadAsset(null, false, null, (Continuation) this);
    }
}