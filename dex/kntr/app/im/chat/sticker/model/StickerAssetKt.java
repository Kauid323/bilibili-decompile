package kntr.app.im.chat.sticker.model;

import kntr.app.im.chat.sticker.asset.StickerAssetFinder;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.common.photonic.ContentSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: StickerAsset.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"asAsset", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "(Lkntr/app/im/chat/sticker/entity/StickerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sticker_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickerAssetKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object asAsset(StickerEntity $this$asAsset, Continuation<? super StickerAsset> continuation) {
        StickerAssetKt$asAsset$1 stickerAssetKt$asAsset$1;
        Object withContext;
        if (continuation instanceof StickerAssetKt$asAsset$1) {
            stickerAssetKt$asAsset$1 = (StickerAssetKt$asAsset$1) continuation;
            if ((stickerAssetKt$asAsset$1.label & Integer.MIN_VALUE) != 0) {
                stickerAssetKt$asAsset$1.label -= Integer.MIN_VALUE;
                Object $result = stickerAssetKt$asAsset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerAssetKt$asAsset$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Path path = PathsKt.Path(StickerAssetFinder.Companion.getStickerSaveRoot$default(StickerAssetFinder.Companion, null, 1, null), new String[]{$this$asAsset.getFileName()});
                        stickerAssetKt$asAsset$1.L$0 = $this$asAsset;
                        stickerAssetKt$asAsset$1.L$1 = SpillingKt.nullOutSpilledVariable(path);
                        stickerAssetKt$asAsset$1.label = 1;
                        withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new StickerAssetKt$asAsset$contentSize$1(path, null), stickerAssetKt$asAsset$1);
                        if (withContext != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        Path path2 = (Path) stickerAssetKt$asAsset$1.L$1;
                        $this$asAsset = (StickerEntity) stickerAssetKt$asAsset$1.L$0;
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                double contentSize = ((ContentSize) withContext).unbox-impl();
                return new StickerAsset($this$asAsset, contentSize, null);
            }
        }
        stickerAssetKt$asAsset$1 = new StickerAssetKt$asAsset$1(continuation);
        Object $result2 = stickerAssetKt$asAsset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerAssetKt$asAsset$1.label) {
        }
        double contentSize2 = ((ContentSize) withContext).unbox-impl();
        return new StickerAsset($this$asAsset, contentSize2, null);
    }
}