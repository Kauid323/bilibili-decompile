package kntr.app.im.chat.sticker.model;

import kntr.common.photonic.ContentSize;
import kntr.common.photonic.ContentSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerAsset.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/common/photonic/ContentSize;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.model.StickerAssetKt$asAsset$contentSize$1", f = "StickerAsset.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerAssetKt$asAsset$contentSize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ContentSize>, Object> {
    final /* synthetic */ Path $path;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAssetKt$asAsset$contentSize$1(Path path, Continuation<? super StickerAssetKt$asAsset$contentSize$1> continuation) {
        super(2, continuation);
        this.$path = path;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerAssetKt$asAsset$contentSize$1(this.$path, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ContentSize> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FileMetadata metadataOrNull = FileSystemJvmKt.SystemFileSystem.metadataOrNull(this.$path);
                return ContentSize.box-impl(metadataOrNull != null ? ContentSizeKt.bytes(Boxing.boxLong(metadataOrNull.getSize())) : ContentSize.Companion.getUNKNOWN-QJZHGII());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}