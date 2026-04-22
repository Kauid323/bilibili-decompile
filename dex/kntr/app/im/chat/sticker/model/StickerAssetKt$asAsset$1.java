package kntr.app.im.chat.sticker.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerAsset.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.model.StickerAssetKt", f = "StickerAsset.kt", i = {0, 0}, l = {46}, m = "asAsset", n = {"$this$asAsset", "path"}, s = {"L$0", "L$1"}, v = 1)
public final class StickerAssetKt$asAsset$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerAssetKt$asAsset$1(Continuation<? super StickerAssetKt$asAsset$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StickerAssetKt.asAsset(null, (Continuation) this);
    }
}