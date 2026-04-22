package kntr.app.im.chat.sticker.service;

import kntr.app.im.chat.sticker.db.StickerDao;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.base.account.AccountState;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl$saveStickers$2$1$1", f = "StickerManagerService.kt", i = {1, 1}, l = {100, 104}, m = "invokeSuspend", n = {"stickerEntity", "$i$a$-onSuccess-StickerManagerServiceImpl$saveStickers$2$1$1$1"}, s = {"L$1", "I$0"}, v = 1)
public final class StickerManagerServiceImpl$saveStickers$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends StickerEntity>>, Object> {
    final /* synthetic */ Asset $asset;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StickerManagerServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$saveStickers$2$1$1(StickerManagerServiceImpl stickerManagerServiceImpl, Asset asset, Continuation<? super StickerManagerServiceImpl$saveStickers$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerManagerServiceImpl;
        this.$asset = asset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagerServiceImpl$saveStickers$2$1$1(this.this$0, this.$asset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<StickerEntity>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        AccountState accountState;
        Object obj;
        AccountState.Logged logged;
        Object m1697saveStickerIntoFileSystem0E7RQCE;
        StickerDao stickerDao;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                accountState = this.this$0.accountState;
                if (accountState instanceof AccountState.Logged) {
                    StickerManagerServiceImpl stickerManagerServiceImpl = this.this$0;
                    Asset asset = this.$asset;
                    logged = this.this$0.accountState;
                    this.label = 1;
                    m1697saveStickerIntoFileSystem0E7RQCE = stickerManagerServiceImpl.m1697saveStickerIntoFileSystem0E7RQCE(asset, logged.getUserInfo().getMid(), (Continuation) this);
                    if (m1697saveStickerIntoFileSystem0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = m1697saveStickerIntoFileSystem0E7RQCE;
                    StickerManagerServiceImpl stickerManagerServiceImpl2 = this.this$0;
                    if (Result.isSuccess-impl(obj)) {
                        StickerEntity stickerEntity = (StickerEntity) obj;
                        stickerDao = stickerManagerServiceImpl2.stickerDao;
                        this.L$0 = obj;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(stickerEntity);
                        this.I$0 = 0;
                        this.label = 2;
                        if (stickerDao.add(stickerEntity, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Result.box-impl(obj);
                }
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("User not logged in")));
                return Result.box-impl(obj);
            case 1:
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).unbox-impl();
                StickerManagerServiceImpl stickerManagerServiceImpl22 = this.this$0;
                if (Result.isSuccess-impl(obj)) {
                }
                return Result.box-impl(obj);
            case 2:
                int i = this.I$0;
                StickerEntity stickerEntity2 = (StickerEntity) this.L$1;
                obj = this.L$0;
                ResultKt.throwOnFailure($result);
                return Result.box-impl(obj);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}