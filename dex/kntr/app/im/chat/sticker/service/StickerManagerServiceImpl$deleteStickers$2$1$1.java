package kntr.app.im.chat.sticker.service;

import kntr.app.im.chat.sticker.db.StickerDao;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl$deleteStickers$2$1$1", f = "StickerManagerService.kt", i = {}, l = {86, 87}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerManagerServiceImpl$deleteStickers$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ StickerAsset $sticker;
    int label;
    final /* synthetic */ StickerManagerServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$deleteStickers$2$1$1(StickerManagerServiceImpl stickerManagerServiceImpl, StickerAsset stickerAsset, Continuation<? super StickerManagerServiceImpl$deleteStickers$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerManagerServiceImpl;
        this.$sticker = stickerAsset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagerServiceImpl$deleteStickers$2$1$1(this.this$0, this.$sticker, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        StickerDao stickerDao;
        Object m1695deleteStickerFromFileSystemgIAlus;
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                stickerDao = this.this$0.stickerDao;
                this.label = 1;
                if (stickerDao.remove(this.$sticker.getEntity$sticker_debug(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                m1695deleteStickerFromFileSystemgIAlus = this.this$0.m1695deleteStickerFromFileSystemgIAlus(this.$sticker, (Continuation) this);
                if (m1695deleteStickerFromFileSystemgIAlus != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = m1695deleteStickerFromFileSystemgIAlus;
                return Result.box-impl(obj);
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                m1695deleteStickerFromFileSystemgIAlus = this.this$0.m1695deleteStickerFromFileSystemgIAlus(this.$sticker, (Continuation) this);
                if (m1695deleteStickerFromFileSystemgIAlus != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).unbox-impl();
                return Result.box-impl(obj);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}