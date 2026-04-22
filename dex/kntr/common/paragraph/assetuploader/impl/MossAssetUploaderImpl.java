package kntr.common.paragraph.assetuploader.impl;

import io.ktor.client.HttpClient;
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.UploadTask;
import kntr.common.paragraph.assetuploader.base.AssetUploaderParams;
import kntr.common.paragraph.assetuploader.di.AssetUploadBucket;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: MossAssetUploaderImpl.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl;", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "client", "Lio/ktor/client/HttpClient;", "bucket", "", "<init>", "(Lio/ktor/client/HttpClient;Ljava/lang/String;)V", "index", "Lkotlinx/atomicfu/AtomicInt;", "uploadAsset", "Lkntr/common/paragraph/assetuploader/UploadTask;", "asset", "Lkntr/common/photonic/Asset;", "useOriginImage", "", "params", "Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "(Lkntr/common/photonic/Asset;ZLkntr/common/paragraph/assetuploader/base/AssetUploaderParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MossAssetUploaderImpl implements AssetUploader {
    public static final String TAG = "MossAssetUploader";
    private final String bucket;
    private final HttpClient client;
    private final AtomicInt index;
    public static final Companion Companion = new Companion(null);
    private static final Mutex uploadMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @Inject
    public MossAssetUploaderImpl(HttpClient client, @AssetUploadBucket String bucket) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        this.client = client;
        this.bucket = bucket;
        this.index = AtomicFU.atomic(0);
    }

    /* compiled from: MossAssetUploaderImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkntr/common/paragraph/assetuploader/impl/MossAssetUploaderImpl$Companion;", "", "<init>", "()V", "uploadMutex", "Lkotlinx/coroutines/sync/Mutex;", "TAG", "", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    @Override // kntr.common.paragraph.assetuploader.AssetUploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object uploadAsset(Asset asset, boolean useOriginImage, AssetUploaderParams params, Continuation<? super UploadTask> continuation) {
        MossAssetUploaderImpl$uploadAsset$1 mossAssetUploaderImpl$uploadAsset$1;
        MossAssetUploaderImpl$uploadAsset$1 mossAssetUploaderImpl$uploadAsset$12;
        AssetUploaderParams params2;
        int assetIndex;
        int $i$f$withLock;
        Object owner$iv;
        boolean useOriginImage2;
        Asset asset2;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv2;
        Mutex $this$withLock_u24default$iv2;
        Object withContext;
        AssetUploaderParams params3;
        Asset asset3;
        int assetIndex2;
        boolean useOriginImage3;
        if (continuation instanceof MossAssetUploaderImpl$uploadAsset$1) {
            mossAssetUploaderImpl$uploadAsset$1 = (MossAssetUploaderImpl$uploadAsset$1) continuation;
            if ((mossAssetUploaderImpl$uploadAsset$1.label & Integer.MIN_VALUE) != 0) {
                mossAssetUploaderImpl$uploadAsset$1.label -= Integer.MIN_VALUE;
                mossAssetUploaderImpl$uploadAsset$12 = mossAssetUploaderImpl$uploadAsset$1;
                Object $result = mossAssetUploaderImpl$uploadAsset$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (mossAssetUploaderImpl$uploadAsset$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int assetIndex3 = this.index.getAndIncrement();
                        Mutex $this$withLock_u24default$iv3 = uploadMutex;
                        mossAssetUploaderImpl$uploadAsset$12.L$0 = asset;
                        params2 = params;
                        mossAssetUploaderImpl$uploadAsset$12.L$1 = params2;
                        mossAssetUploaderImpl$uploadAsset$12.L$2 = $this$withLock_u24default$iv3;
                        mossAssetUploaderImpl$uploadAsset$12.Z$0 = useOriginImage;
                        mossAssetUploaderImpl$uploadAsset$12.I$0 = assetIndex3;
                        mossAssetUploaderImpl$uploadAsset$12.I$1 = 0;
                        mossAssetUploaderImpl$uploadAsset$12.label = 1;
                        if ($this$withLock_u24default$iv3.lock((Object) null, mossAssetUploaderImpl$uploadAsset$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        assetIndex = assetIndex3;
                        $i$f$withLock = 0;
                        owner$iv = null;
                        useOriginImage2 = useOriginImage;
                        asset2 = asset;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                        try {
                            CoroutineContext io = Dispatchers.getIO();
                            if (useOriginImage2) {
                                z = false;
                            }
                            mossAssetUploaderImpl$uploadAsset$12.L$0 = SpillingKt.nullOutSpilledVariable(asset2);
                            mossAssetUploaderImpl$uploadAsset$12.L$1 = params2;
                            mossAssetUploaderImpl$uploadAsset$12.L$2 = $this$withLock_u24default$iv;
                            mossAssetUploaderImpl$uploadAsset$12.Z$0 = useOriginImage2;
                            mossAssetUploaderImpl$uploadAsset$12.I$0 = assetIndex;
                            mossAssetUploaderImpl$uploadAsset$12.I$1 = $i$f$withLock;
                            mossAssetUploaderImpl$uploadAsset$12.I$2 = 0;
                            mossAssetUploaderImpl$uploadAsset$12.label = 2;
                            withContext = BuildersKt.withContext(io, new MossAssetUploaderImpl$uploadAsset$dataToUpload$1$1(assetIndex, asset2, z, null), mossAssetUploaderImpl$uploadAsset$12);
                            if (withContext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            params3 = params2;
                            asset3 = asset2;
                            assetIndex2 = assetIndex;
                            useOriginImage3 = useOriginImage2;
                            owner$iv2 = owner$iv;
                            $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                            try {
                                Asset dataToUpload = (Asset) withContext;
                                $this$withLock_u24default$iv2.unlock(owner$iv2);
                                return new KtorUploadTask(dataToUpload, assetIndex2, this.client, this.bucket, params3 != null ? AssetUploaderParams.Companion.getDefault() : params3);
                            } catch (Throwable th) {
                                th = th;
                                $this$withLock_u24default$iv2.unlock(owner$iv2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            owner$iv2 = owner$iv;
                            $this$withLock_u24default$iv2 = $this$withLock_u24default$iv;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th;
                        }
                    case 1:
                        $i$f$withLock = mossAssetUploaderImpl$uploadAsset$12.I$1;
                        assetIndex = mossAssetUploaderImpl$uploadAsset$12.I$0;
                        useOriginImage2 = mossAssetUploaderImpl$uploadAsset$12.Z$0;
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) mossAssetUploaderImpl$uploadAsset$12.L$2;
                        params2 = (AssetUploaderParams) mossAssetUploaderImpl$uploadAsset$12.L$1;
                        asset2 = (Asset) mossAssetUploaderImpl$uploadAsset$12.L$0;
                        ResultKt.throwOnFailure($result);
                        CoroutineContext io2 = Dispatchers.getIO();
                        if (useOriginImage2) {
                        }
                        mossAssetUploaderImpl$uploadAsset$12.L$0 = SpillingKt.nullOutSpilledVariable(asset2);
                        mossAssetUploaderImpl$uploadAsset$12.L$1 = params2;
                        mossAssetUploaderImpl$uploadAsset$12.L$2 = $this$withLock_u24default$iv;
                        mossAssetUploaderImpl$uploadAsset$12.Z$0 = useOriginImage2;
                        mossAssetUploaderImpl$uploadAsset$12.I$0 = assetIndex;
                        mossAssetUploaderImpl$uploadAsset$12.I$1 = $i$f$withLock;
                        mossAssetUploaderImpl$uploadAsset$12.I$2 = 0;
                        mossAssetUploaderImpl$uploadAsset$12.label = 2;
                        withContext = BuildersKt.withContext(io2, new MossAssetUploaderImpl$uploadAsset$dataToUpload$1$1(assetIndex, asset2, z, null), mossAssetUploaderImpl$uploadAsset$12);
                        if (withContext != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i = mossAssetUploaderImpl$uploadAsset$12.I$2;
                        int i2 = mossAssetUploaderImpl$uploadAsset$12.I$1;
                        int assetIndex4 = mossAssetUploaderImpl$uploadAsset$12.I$0;
                        boolean useOriginImage4 = mossAssetUploaderImpl$uploadAsset$12.Z$0;
                        owner$iv2 = null;
                        $this$withLock_u24default$iv2 = (Mutex) mossAssetUploaderImpl$uploadAsset$12.L$2;
                        AssetUploaderParams params4 = (AssetUploaderParams) mossAssetUploaderImpl$uploadAsset$12.L$1;
                        Asset asset4 = (Asset) mossAssetUploaderImpl$uploadAsset$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            withContext = $result;
                            assetIndex2 = assetIndex4;
                            useOriginImage3 = useOriginImage4;
                            params3 = params4;
                            asset3 = asset4;
                            Asset dataToUpload2 = (Asset) withContext;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            return new KtorUploadTask(dataToUpload2, assetIndex2, this.client, this.bucket, params3 != null ? AssetUploaderParams.Companion.getDefault() : params3);
                        } catch (Throwable th3) {
                            th = th3;
                            $this$withLock_u24default$iv2.unlock(owner$iv2);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        mossAssetUploaderImpl$uploadAsset$1 = new MossAssetUploaderImpl$uploadAsset$1(this, continuation);
        mossAssetUploaderImpl$uploadAsset$12 = mossAssetUploaderImpl$uploadAsset$1;
        Object $result2 = mossAssetUploaderImpl$uploadAsset$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (mossAssetUploaderImpl$uploadAsset$12.label) {
        }
    }
}