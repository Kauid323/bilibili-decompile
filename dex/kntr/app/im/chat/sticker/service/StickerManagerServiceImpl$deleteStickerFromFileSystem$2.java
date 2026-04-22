package kntr.app.im.chat.sticker.service;

import kntr.app.im.chat.sticker.asset.StickerAssetFinder;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl$deleteStickerFromFileSystem$2", f = "StickerManagerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerManagerServiceImpl$deleteStickerFromFileSystem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ StickerAsset $sticker;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$deleteStickerFromFileSystem$2(StickerAsset stickerAsset, Continuation<? super StickerManagerServiceImpl$deleteStickerFromFileSystem$2> continuation) {
        super(2, continuation);
        this.$sticker = stickerAsset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagerServiceImpl$deleteStickerFromFileSystem$2(this.$sticker, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StickerAsset stickerAsset = this.$sticker;
                try {
                    Result.Companion companion = Result.Companion;
                    Path filePath = PathsKt.Path(StickerAssetFinder.Companion.getStickerSaveRoot$default(StickerAssetFinder.Companion, null, 1, null), new String[]{stickerAsset.getEntity$sticker_debug().getFileName()});
                    FileSystemJvmKt.SystemFileSystem.delete(filePath, false);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                JobKt.ensureActive(getContext());
                return Result.box-impl(obj);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}