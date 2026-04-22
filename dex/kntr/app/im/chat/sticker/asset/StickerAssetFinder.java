package kntr.app.im.chat.sticker.asset;

import java.util.NoSuchElementException;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.sticker.db.StickerDao;
import kntr.app.im.chat.sticker.db.StickerDatabase;
import kntr.app.im.chat.sticker.entity.StickerEntity;
import kntr.app.im.chat.sticker.model.StickerAsset;
import kntr.app.im.chat.sticker.model.StickerAssetKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.account.model.UserInfo;
import kntr.base.utils.foundation.AppDirectory;
import kntr.common.photonic.finder.AssetFinder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.JobKt;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: StickerAssetFinder.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/sticker/asset/StickerAssetFinder;", "Lkntr/common/photonic/finder/AssetFinder;", "Lkntr/app/im/chat/sticker/model/StickerAsset;", "database", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "accountStore", "Lkntr/base/account/KAccountStore;", "<init>", "(Lkntr/app/im/chat/sticker/db/StickerDatabase;Lkntr/base/account/KAccountStore;)V", "dao", "Lkntr/app/im/chat/sticker/db/StickerDao;", ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "getMid", "()J", "acceptType", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "findAssetByIdentifier", "Lkotlin/Result;", "identifier", RoomRecommendViewModel.EMPTY_CURSOR, "findAssetByIdentifier-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerAssetFinder implements AssetFinder<StickerAsset> {
    private final KAccountStore accountStore;
    private final StickerDao dao;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public StickerAssetFinder(StickerDatabase database, KAccountStore accountStore) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        this.accountStore = accountStore;
        this.dao = database.stickerDao();
    }

    /* compiled from: StickerAssetFinder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/sticker/asset/StickerAssetFinder$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getStickerSaveRoot", "Lkotlinx/io/files/Path;", "appDirectory", "getRelativeStickerSaveDir", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Path getStickerSaveRoot$default(Companion companion, Path path, int i, Object obj) {
            if ((i & 1) != 0) {
                path = AppDirectory.INSTANCE.getDataDirectory();
            }
            return companion.getStickerSaveRoot(path);
        }

        public final Path getStickerSaveRoot(Path appDirectory) {
            Intrinsics.checkNotNullParameter(appDirectory, "appDirectory");
            Path path = PathsKt.Path(appDirectory, new String[]{getRelativeStickerSaveDir().toString()});
            FileSystemJvmKt.SystemFileSystem.createDirectories(path, false);
            return path;
        }

        private final Path getRelativeStickerSaveDir() {
            return PathsKt.Path("im", new String[]{"sticker"});
        }
    }

    private final long getMid() {
        UserInfo userInfo;
        Object value = this.accountStore.getState().getValue();
        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
        if (logged == null || (userInfo = logged.getUserInfo()) == null) {
            return 0L;
        }
        return userInfo.getMid();
    }

    public Set<KClass<? extends StickerAsset>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(StickerAsset.class));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|44|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
        r2 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #1 {all -> 0x004c, blocks: (B:36:0x0098, B:37:0x00b0, B:16:0x0047, B:25:0x006f, B:27:0x0073), top: B:44:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090 A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #0 {all -> 0x00b1, blocks: (B:13:0x0039, B:31:0x008c, B:33:0x0090, B:21:0x0053), top: B:42:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /* renamed from: findAssetByIdentifier-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1647findAssetByIdentifiergIAlus(String identifier, Continuation<? super Result<StickerAsset>> continuation) {
        StickerAssetFinder$findAssetByIdentifier$1 stickerAssetFinder$findAssetByIdentifier$1;
        Object obj;
        Object findWithFile;
        int $i$f$runSuspendCatching;
        int $i$f$runSuspendCatching2;
        StickerEntity entity;
        Object asAsset;
        int i;
        int $i$f$runSuspendCatching3;
        StickerEntity entity2;
        StickerAsset stickerAsset;
        if (continuation instanceof StickerAssetFinder$findAssetByIdentifier$1) {
            stickerAssetFinder$findAssetByIdentifier$1 = (StickerAssetFinder$findAssetByIdentifier$1) continuation;
            if ((stickerAssetFinder$findAssetByIdentifier$1.label & Integer.MIN_VALUE) != 0) {
                stickerAssetFinder$findAssetByIdentifier$1.label -= Integer.MIN_VALUE;
                Object $result = stickerAssetFinder$findAssetByIdentifier$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerAssetFinder$findAssetByIdentifier$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        StickerDao stickerDao = this.dao;
                        long mid = getMid();
                        stickerAssetFinder$findAssetByIdentifier$1.L$0 = identifier;
                        stickerAssetFinder$findAssetByIdentifier$1.I$0 = 0;
                        stickerAssetFinder$findAssetByIdentifier$1.I$1 = 0;
                        stickerAssetFinder$findAssetByIdentifier$1.label = 1;
                        findWithFile = stickerDao.findWithFile(identifier, mid, stickerAssetFinder$findAssetByIdentifier$1);
                        if (findWithFile == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$runSuspendCatching = 0;
                        $i$f$runSuspendCatching2 = 0;
                        entity = (StickerEntity) findWithFile;
                        if (entity != null) {
                            stickerAssetFinder$findAssetByIdentifier$1.L$0 = identifier;
                            stickerAssetFinder$findAssetByIdentifier$1.L$1 = SpillingKt.nullOutSpilledVariable(entity);
                            stickerAssetFinder$findAssetByIdentifier$1.I$0 = $i$f$runSuspendCatching;
                            stickerAssetFinder$findAssetByIdentifier$1.I$1 = $i$f$runSuspendCatching2;
                            stickerAssetFinder$findAssetByIdentifier$1.label = 2;
                            asAsset = StickerAssetKt.asAsset(entity, stickerAssetFinder$findAssetByIdentifier$1);
                            if (asAsset == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i = $i$f$runSuspendCatching2;
                            $i$f$runSuspendCatching3 = $i$f$runSuspendCatching;
                            entity2 = entity;
                            stickerAsset = (StickerAsset) asAsset;
                            if (stickerAsset == null) {
                                obj = Result.constructor-impl(stickerAsset);
                                JobKt.ensureActive(stickerAssetFinder$findAssetByIdentifier$1.getContext());
                                return obj;
                            }
                            $i$f$runSuspendCatching = $i$f$runSuspendCatching3;
                        }
                        throw new NoSuchElementException("Sticker asset not found for identifier: " + identifier);
                    case 1:
                        $i$f$runSuspendCatching2 = stickerAssetFinder$findAssetByIdentifier$1.I$1;
                        $i$f$runSuspendCatching = stickerAssetFinder$findAssetByIdentifier$1.I$0;
                        identifier = (String) stickerAssetFinder$findAssetByIdentifier$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            findWithFile = $result;
                            entity = (StickerEntity) findWithFile;
                            if (entity != null) {
                            }
                            throw new NoSuchElementException("Sticker asset not found for identifier: " + identifier);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(stickerAssetFinder$findAssetByIdentifier$1.getContext());
                            return obj;
                        }
                    case 2:
                        i = stickerAssetFinder$findAssetByIdentifier$1.I$1;
                        $i$f$runSuspendCatching3 = stickerAssetFinder$findAssetByIdentifier$1.I$0;
                        entity2 = (StickerEntity) stickerAssetFinder$findAssetByIdentifier$1.L$1;
                        identifier = (String) stickerAssetFinder$findAssetByIdentifier$1.L$0;
                        ResultKt.throwOnFailure($result);
                        asAsset = $result;
                        stickerAsset = (StickerAsset) asAsset;
                        if (stickerAsset == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        stickerAssetFinder$findAssetByIdentifier$1 = new StickerAssetFinder$findAssetByIdentifier$1(this, continuation);
        Object $result2 = stickerAssetFinder$findAssetByIdentifier$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerAssetFinder$findAssetByIdentifier$1.label) {
        }
    }
}