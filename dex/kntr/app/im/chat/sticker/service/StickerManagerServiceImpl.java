package kntr.app.im.chat.sticker.service;

import im.base.IMLog;
import io.ktor.client.HttpClient;
import java.util.List;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.sticker.asset.StickerAssetFinder;
import kntr.app.im.chat.sticker.db.StickerDao;
import kntr.app.im.chat.sticker.db.StickerDatabase;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.common.photonic.Asset;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: StickerManagerService.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012H\u0096@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012H\u0096@¢\u0006\u0002\u0010\u0018J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0004\b\"\u0010#J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010%\u001a\u00020\u0017H\u0082@¢\u0006\u0004\b&\u0010'J&\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0082@¢\u0006\u0004\b+\u0010,J6\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0004\b.\u0010/R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lkntr/app/im/chat/sticker/service/StickerManagerServiceImpl;", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "stickerDatabase", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "client", "Lio/ktor/client/HttpClient;", "accountStore", "Lkntr/base/account/KAccountStore;", "<init>", "(Lkntr/app/im/chat/sticker/db/StickerDatabase;Lio/ktor/client/HttpClient;Lkntr/base/account/KAccountStore;)V", "limitedIODispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "stickerDao", "Lkntr/app/im/chat/sticker/db/StickerDao;", "accountState", "Lkntr/base/account/AccountState;", "getAllStickerOfUser", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/sticker/entity/StickerEntity;", "deleteStickers", RoomRecommendViewModel.EMPTY_CURSOR, "stickers", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStickers", "Lkntr/common/photonic/Asset;", "saveSticker", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "imageUrl", RoomRecommendViewModel.EMPTY_CURSOR, "resolution", "Lkntr/common/photonic/Resolution;", "saveSticker-0E7RQCE", "(Ljava/lang/String;Lkntr/common/photonic/Resolution;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteStickerFromFileSystem", "sticker", "deleteStickerFromFileSystem-gIAlu-s", "(Lkntr/app/im/chat/sticker/model/StickerAsset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStickerIntoFileSystem", ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "saveStickerIntoFileSystem-0E7RQCE", "(Lkntr/common/photonic/Asset;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadSticker", "downloadSticker-yxL6bBk", "(Lio/ktor/client/HttpClient;JLjava/lang/String;Lkntr/common/photonic/Resolution;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerManagerServiceImpl implements StickerManagerService {
    public static final int $stable = 8;
    private final AccountState accountState;
    private final KAccountStore accountStore;
    private final HttpClient client;
    private final CoroutineDispatcher limitedIODispatcher;
    private final StickerDao stickerDao;

    @Inject
    public StickerManagerServiceImpl(StickerDatabase stickerDatabase, HttpClient client, KAccountStore accountStore) {
        Intrinsics.checkNotNullParameter(stickerDatabase, "stickerDatabase");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        this.client = client;
        this.accountStore = accountStore;
        this.limitedIODispatcher = Dispatchers.getIO().limitedParallelism(3);
        this.stickerDao = stickerDatabase.stickerDao();
        this.accountState = (AccountState) this.accountStore.getState().getValue();
    }

    @Override // kntr.app.im.chat.sticker.service.StickerManagerService
    public Flow<List<StickerEntity>> getAllStickerOfUser() {
        Flow $this$flatMapLatest$iv = this.accountStore.getState();
        return FlowKt.transformLatest($this$flatMapLatest$iv, new StickerManagerServiceImpl$getAllStickerOfUser$$inlined$flatMapLatest$1(null, this));
    }

    @Override // kntr.app.im.chat.sticker.service.StickerManagerService
    public Object deleteStickers(List<StickerAsset> list, Continuation<? super Integer> continuation) {
        return CoroutineScopeKt.coroutineScope(new StickerManagerServiceImpl$deleteStickers$2(list, this, null), continuation);
    }

    @Override // kntr.app.im.chat.sticker.service.StickerManagerService
    public Object saveStickers(List<? extends Asset> list, Continuation<? super Integer> continuation) {
        return CoroutineScopeKt.coroutineScope(new StickerManagerServiceImpl$saveStickers$2(list, this, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    @Override // kntr.app.im.chat.sticker.service.StickerManagerService
    /* renamed from: saveSticker-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1691saveSticker0E7RQCE(String imageUrl, Resolution resolution, Continuation<? super Result<Unit>> continuation) {
        Continuation<? super Unit> stickerManagerServiceImpl$saveSticker$1;
        Object m1696downloadStickeryxL6bBk;
        if (continuation instanceof StickerManagerServiceImpl$saveSticker$1) {
            stickerManagerServiceImpl$saveSticker$1 = (StickerManagerServiceImpl$saveSticker$1) continuation;
            if ((stickerManagerServiceImpl$saveSticker$1.label & Integer.MIN_VALUE) != 0) {
                stickerManagerServiceImpl$saveSticker$1.label -= Integer.MIN_VALUE;
                Object $result = stickerManagerServiceImpl$saveSticker$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerManagerServiceImpl$saveSticker$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (this.accountState instanceof AccountState.Logged) {
                            HttpClient httpClient = this.client;
                            long mid = this.accountState.getUserInfo().getMid();
                            stickerManagerServiceImpl$saveSticker$1.L$0 = SpillingKt.nullOutSpilledVariable(imageUrl);
                            stickerManagerServiceImpl$saveSticker$1.L$1 = SpillingKt.nullOutSpilledVariable(resolution);
                            stickerManagerServiceImpl$saveSticker$1.label = 1;
                            m1696downloadStickeryxL6bBk = m1696downloadStickeryxL6bBk(httpClient, mid, imageUrl, resolution, stickerManagerServiceImpl$saveSticker$1);
                            if (m1696downloadStickeryxL6bBk == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            Result.Companion companion = Result.Companion;
                            return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("User not logged in")));
                        }
                        break;
                    case 1:
                        resolution = (Resolution) stickerManagerServiceImpl$saveSticker$1.L$1;
                        imageUrl = (String) stickerManagerServiceImpl$saveSticker$1.L$0;
                        ResultKt.throwOnFailure($result);
                        m1696downloadStickeryxL6bBk = ((Result) $result).unbox-impl();
                        break;
                    case 2:
                        int i = stickerManagerServiceImpl$saveSticker$1.I$0;
                        StickerEntity stickerEntity = (StickerEntity) stickerManagerServiceImpl$saveSticker$1.L$2;
                        Resolution resolution2 = (Resolution) stickerManagerServiceImpl$saveSticker$1.L$1;
                        String str = (String) stickerManagerServiceImpl$saveSticker$1.L$0;
                        ResultKt.throwOnFailure($result);
                        m1696downloadStickeryxL6bBk = Unit.INSTANCE;
                        return Result.constructor-impl(m1696downloadStickeryxL6bBk);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (Result.isSuccess-impl(m1696downloadStickeryxL6bBk)) {
                    Result.Companion companion2 = Result.Companion;
                    StickerEntity it = (StickerEntity) m1696downloadStickeryxL6bBk;
                    IMLog.Companion.i("StickerSaver", "Inserting sticker entity: " + it);
                    StickerDao stickerDao = this.stickerDao;
                    stickerManagerServiceImpl$saveSticker$1.L$0 = SpillingKt.nullOutSpilledVariable(imageUrl);
                    stickerManagerServiceImpl$saveSticker$1.L$1 = SpillingKt.nullOutSpilledVariable(resolution);
                    stickerManagerServiceImpl$saveSticker$1.L$2 = SpillingKt.nullOutSpilledVariable(it);
                    stickerManagerServiceImpl$saveSticker$1.I$0 = 0;
                    stickerManagerServiceImpl$saveSticker$1.label = 2;
                    if (stickerDao.add(it, stickerManagerServiceImpl$saveSticker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    m1696downloadStickeryxL6bBk = Unit.INSTANCE;
                }
                return Result.constructor-impl(m1696downloadStickeryxL6bBk);
            }
        }
        stickerManagerServiceImpl$saveSticker$1 = new StickerManagerServiceImpl$saveSticker$1(this, continuation);
        Object $result2 = stickerManagerServiceImpl$saveSticker$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerManagerServiceImpl$saveSticker$1.label) {
        }
        if (Result.isSuccess-impl(m1696downloadStickeryxL6bBk)) {
        }
        return Result.constructor-impl(m1696downloadStickeryxL6bBk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* renamed from: deleteStickerFromFileSystem-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1695deleteStickerFromFileSystemgIAlus(StickerAsset sticker, Continuation<? super Result<Unit>> continuation) {
        StickerManagerServiceImpl$deleteStickerFromFileSystem$1 stickerManagerServiceImpl$deleteStickerFromFileSystem$1;
        Object withContext;
        if (continuation instanceof StickerManagerServiceImpl$deleteStickerFromFileSystem$1) {
            stickerManagerServiceImpl$deleteStickerFromFileSystem$1 = (StickerManagerServiceImpl$deleteStickerFromFileSystem$1) continuation;
            if ((stickerManagerServiceImpl$deleteStickerFromFileSystem$1.label & Integer.MIN_VALUE) != 0) {
                stickerManagerServiceImpl$deleteStickerFromFileSystem$1.label -= Integer.MIN_VALUE;
                Object $result = stickerManagerServiceImpl$deleteStickerFromFileSystem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerManagerServiceImpl$deleteStickerFromFileSystem$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        stickerManagerServiceImpl$deleteStickerFromFileSystem$1.L$0 = SpillingKt.nullOutSpilledVariable(sticker);
                        stickerManagerServiceImpl$deleteStickerFromFileSystem$1.label = 1;
                        withContext = BuildersKt.withContext(Dispatchers.getIO(), new StickerManagerServiceImpl$deleteStickerFromFileSystem$2(sticker, null), stickerManagerServiceImpl$deleteStickerFromFileSystem$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        StickerAsset stickerAsset = (StickerAsset) stickerManagerServiceImpl$deleteStickerFromFileSystem$1.L$0;
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) withContext).unbox-impl();
            }
        }
        stickerManagerServiceImpl$deleteStickerFromFileSystem$1 = new StickerManagerServiceImpl$deleteStickerFromFileSystem$1(this, continuation);
        Object $result2 = stickerManagerServiceImpl$deleteStickerFromFileSystem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerManagerServiceImpl$deleteStickerFromFileSystem$1.label) {
        }
        return ((Result) withContext).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* renamed from: saveStickerIntoFileSystem-0E7RQCE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1697saveStickerIntoFileSystem0E7RQCE(Asset sticker, long mid, Continuation<? super Result<StickerEntity>> continuation) {
        StickerManagerServiceImpl$saveStickerIntoFileSystem$1 stickerManagerServiceImpl$saveStickerIntoFileSystem$1;
        Object withContext;
        if (continuation instanceof StickerManagerServiceImpl$saveStickerIntoFileSystem$1) {
            stickerManagerServiceImpl$saveStickerIntoFileSystem$1 = (StickerManagerServiceImpl$saveStickerIntoFileSystem$1) continuation;
            if ((stickerManagerServiceImpl$saveStickerIntoFileSystem$1.label & Integer.MIN_VALUE) != 0) {
                stickerManagerServiceImpl$saveStickerIntoFileSystem$1.label -= Integer.MIN_VALUE;
                Object $result = stickerManagerServiceImpl$saveStickerIntoFileSystem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerManagerServiceImpl$saveStickerIntoFileSystem$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MimeType mimeType = !Intrinsics.areEqual(sticker.getMimeType(), MimeType.Companion.getUNKNOWN()) ? sticker.getMimeType() : MimeType.Companion.getPNG();
                        String extension = mimeType.getSubType();
                        String fileName = "sticker_" + Uuid.Companion.random() + "." + extension;
                        Path savePath = PathsKt.Path(StickerAssetFinder.Companion.getStickerSaveRoot$default(StickerAssetFinder.Companion, null, 1, null), new String[]{fileName});
                        IMLog.Companion.i("StickerSaver", "Saving sticker " + sticker.getIdentifier() + " to " + savePath);
                        stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$0 = SpillingKt.nullOutSpilledVariable(sticker);
                        stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$1 = SpillingKt.nullOutSpilledVariable(mimeType);
                        stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$2 = SpillingKt.nullOutSpilledVariable(extension);
                        stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$3 = SpillingKt.nullOutSpilledVariable(fileName);
                        stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$4 = SpillingKt.nullOutSpilledVariable(savePath);
                        stickerManagerServiceImpl$saveStickerIntoFileSystem$1.J$0 = mid;
                        stickerManagerServiceImpl$saveStickerIntoFileSystem$1.label = 1;
                        withContext = BuildersKt.withContext(this.limitedIODispatcher, new StickerManagerServiceImpl$saveStickerIntoFileSystem$2(savePath, sticker, fileName, mid, mimeType, null), stickerManagerServiceImpl$saveStickerIntoFileSystem$1);
                        if (withContext != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        long j2 = stickerManagerServiceImpl$saveStickerIntoFileSystem$1.J$0;
                        Path path = (Path) stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$4;
                        String str = (String) stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$3;
                        String str2 = (String) stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$2;
                        MimeType mimeType2 = (MimeType) stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$1;
                        Asset asset = (Asset) stickerManagerServiceImpl$saveStickerIntoFileSystem$1.L$0;
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) withContext).unbox-impl();
            }
        }
        stickerManagerServiceImpl$saveStickerIntoFileSystem$1 = new StickerManagerServiceImpl$saveStickerIntoFileSystem$1(this, continuation);
        Object $result2 = stickerManagerServiceImpl$saveStickerIntoFileSystem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerManagerServiceImpl$saveStickerIntoFileSystem$1.label) {
        }
        return ((Result) withContext).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* renamed from: downloadSticker-yxL6bBk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1696downloadStickeryxL6bBk(HttpClient client, long mid, String imageUrl, Resolution resolution, Continuation<? super Result<StickerEntity>> continuation) {
        StickerManagerServiceImpl$downloadSticker$1 stickerManagerServiceImpl$downloadSticker$1;
        StickerManagerServiceImpl$downloadSticker$1 stickerManagerServiceImpl$downloadSticker$12;
        Object withContext;
        if (continuation instanceof StickerManagerServiceImpl$downloadSticker$1) {
            stickerManagerServiceImpl$downloadSticker$1 = (StickerManagerServiceImpl$downloadSticker$1) continuation;
            if ((stickerManagerServiceImpl$downloadSticker$1.label & Integer.MIN_VALUE) != 0) {
                stickerManagerServiceImpl$downloadSticker$1.label -= Integer.MIN_VALUE;
                stickerManagerServiceImpl$downloadSticker$12 = stickerManagerServiceImpl$downloadSticker$1;
                Object $result = stickerManagerServiceImpl$downloadSticker$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerManagerServiceImpl$downloadSticker$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String extension = StringsKt.substringAfterLast(imageUrl, '.', "png");
                        String fileName = "sticker_" + Uuid.Companion.random() + "." + extension;
                        Path savePath = PathsKt.Path(StickerAssetFinder.Companion.getStickerSaveRoot$default(StickerAssetFinder.Companion, null, 1, null), new String[]{fileName});
                        IMLog.Companion.i("StickerSaver", "Saving sticker " + imageUrl + " to " + savePath);
                        stickerManagerServiceImpl$downloadSticker$12.L$0 = SpillingKt.nullOutSpilledVariable(client);
                        stickerManagerServiceImpl$downloadSticker$12.L$1 = SpillingKt.nullOutSpilledVariable(imageUrl);
                        stickerManagerServiceImpl$downloadSticker$12.L$2 = SpillingKt.nullOutSpilledVariable(resolution);
                        stickerManagerServiceImpl$downloadSticker$12.L$3 = SpillingKt.nullOutSpilledVariable(extension);
                        stickerManagerServiceImpl$downloadSticker$12.L$4 = SpillingKt.nullOutSpilledVariable(fileName);
                        stickerManagerServiceImpl$downloadSticker$12.L$5 = SpillingKt.nullOutSpilledVariable(savePath);
                        stickerManagerServiceImpl$downloadSticker$12.J$0 = mid;
                        stickerManagerServiceImpl$downloadSticker$12.label = 1;
                        withContext = BuildersKt.withContext(this.limitedIODispatcher, new StickerManagerServiceImpl$downloadSticker$2(client, imageUrl, savePath, fileName, mid, resolution, null), stickerManagerServiceImpl$downloadSticker$12);
                        if (withContext != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        long j2 = stickerManagerServiceImpl$downloadSticker$12.J$0;
                        Path path = (Path) stickerManagerServiceImpl$downloadSticker$12.L$5;
                        String str = (String) stickerManagerServiceImpl$downloadSticker$12.L$4;
                        String str2 = (String) stickerManagerServiceImpl$downloadSticker$12.L$3;
                        Resolution resolution2 = (Resolution) stickerManagerServiceImpl$downloadSticker$12.L$2;
                        String str3 = (String) stickerManagerServiceImpl$downloadSticker$12.L$1;
                        HttpClient httpClient = (HttpClient) stickerManagerServiceImpl$downloadSticker$12.L$0;
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) withContext).unbox-impl();
            }
        }
        stickerManagerServiceImpl$downloadSticker$1 = new StickerManagerServiceImpl$downloadSticker$1(this, continuation);
        stickerManagerServiceImpl$downloadSticker$12 = stickerManagerServiceImpl$downloadSticker$1;
        Object $result2 = stickerManagerServiceImpl$downloadSticker$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerManagerServiceImpl$downloadSticker$12.label) {
        }
        return ((Result) withContext).unbox-impl();
    }
}