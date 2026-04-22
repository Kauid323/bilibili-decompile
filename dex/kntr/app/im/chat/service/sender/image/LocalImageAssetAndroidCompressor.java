package kntr.app.im.chat.service.sender.image;

import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImage_androidKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.foundation.AppCacheDirectory;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.compressor.AssetCompressor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.uuid.Uuid;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: LocalImageAsset.android.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J.\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAssetAndroidCompressor;", "Lkntr/common/photonic/compressor/AssetCompressor;", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "cacheDir", "Lkotlinx/io/files/Path;", "<init>", "(Lkotlinx/io/files/Path;)V", "acceptType", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "compress", "Lkotlin/Result;", "Lkntr/common/photonic/Asset;", "asset", "expectResolution", "Lkntr/common/photonic/Resolution;", "expectContentSize", "Lkntr/common/photonic/ContentSize;", "compress-OkegGBo", "(Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Lkntr/common/photonic/Resolution;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalImageAssetAndroidCompressor implements AssetCompressor<LocalImageAsset> {
    public static final int $stable = 8;
    private final Path cacheDir;

    public LocalImageAssetAndroidCompressor(@AppCacheDirectory Path cacheDir) {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        this.cacheDir = cacheDir;
    }

    /* renamed from: compress-OkegGBo  reason: not valid java name */
    public /* bridge */ /* synthetic */ Object m1601compressOkegGBo(Asset asset, Resolution expectResolution, double d, Continuation $completion) {
        return m1600compressOkegGBo((LocalImageAsset) asset, expectResolution, d, (Continuation<? super Result<? extends Asset>>) $completion);
    }

    public Set<KClass<? extends LocalImageAsset>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(LocalImageAsset.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0196  */
    /* renamed from: compress-OkegGBo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1600compressOkegGBo(LocalImageAsset asset, Resolution expectResolution, double d, Continuation<? super Result<? extends Asset>> continuation) {
        LocalImageAssetAndroidCompressor$compress$1 localImageAssetAndroidCompressor$compress$1;
        double d2;
        Object obj;
        Resolution expectResolution2;
        Object compressImage;
        LocalImageAsset asset2;
        Throwable th;
        LocalImageAsset asset3 = asset;
        if (continuation instanceof LocalImageAssetAndroidCompressor$compress$1) {
            localImageAssetAndroidCompressor$compress$1 = (LocalImageAssetAndroidCompressor$compress$1) continuation;
            if ((localImageAssetAndroidCompressor$compress$1.label & Integer.MIN_VALUE) != 0) {
                localImageAssetAndroidCompressor$compress$1.label -= Integer.MIN_VALUE;
                Object $result = localImageAssetAndroidCompressor$compress$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (localImageAssetAndroidCompressor$compress$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        localImageAssetAndroidCompressor$compress$1.L$0 = asset3;
                        localImageAssetAndroidCompressor$compress$1.L$1 = SpillingKt.nullOutSpilledVariable(expectResolution);
                        d2 = d;
                        localImageAssetAndroidCompressor$compress$1.D$0 = d2;
                        localImageAssetAndroidCompressor$compress$1.label = 1;
                        Object reader = asset3.reader(localImageAssetAndroidCompressor$compress$1);
                        if (reader == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = reader;
                        expectResolution2 = expectResolution;
                        byte[] byteArray = SourcesKt.readByteArray((Source) obj);
                        int coerceAtMost = RangesKt.coerceAtMost(MathKt.roundToInt(ContentSize.div-4yfSoQ8(d2, asset3.m1599getContentSizeQJZHGII()) * 100), 100);
                        localImageAssetAndroidCompressor$compress$1.L$0 = asset3;
                        localImageAssetAndroidCompressor$compress$1.L$1 = SpillingKt.nullOutSpilledVariable(expectResolution2);
                        localImageAssetAndroidCompressor$compress$1.L$2 = SpillingKt.nullOutSpilledVariable(byteArray);
                        localImageAssetAndroidCompressor$compress$1.D$0 = d2;
                        localImageAssetAndroidCompressor$compress$1.label = 2;
                        compressImage = BiliImage_androidKt.compressImage(byteArray, coerceAtMost, localImageAssetAndroidCompressor$compress$1);
                        if (compressImage != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        asset2 = asset3;
                        if (Result.isSuccess-impl(compressImage)) {
                            return Result.constructor-impl(compressImage);
                        }
                        Result.Companion companion = Result.Companion;
                        byte[] it = (byte[]) compressImage;
                        Path cacheFile = PathsKt.Path(this.cacheDir, new String[]{"compress", Uuid.Companion.random() + "." + asset2.getMimeType().getSubType()});
                        Path parent = cacheFile.getParent();
                        if (parent != null) {
                            FileSystemJvmKt.SystemFileSystem.createDirectories(parent, false);
                        }
                        Sink sink = (AutoCloseable) CoreKt.buffered(FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, cacheFile, false, 2, (Object) null));
                        try {
                            Sink sink2 = sink;
                            try {
                                Sink.-CC.write$default(sink2, it, 0, 0, 6, (Object) null);
                                Unit unit = Unit.INSTANCE;
                                AutoCloseableKt.closeFinally(sink, (Throwable) null);
                                KLog_androidKt.getKLog().i("LocalImageAssetAndroidCompressor", "Compressed image " + asset2.getIdentifier() + " saved to " + cacheFile);
                                return Result.constructor-impl(new LocalImageAsset(cacheFile, ContentSizeKt.bytes(Boxing.boxInt(it.length)), asset2.getMimeType(), asset2.getResolution(), asset2.getOrientation(), null));
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    AutoCloseableKt.closeFinally(sink, th);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    case 1:
                        d2 = localImageAssetAndroidCompressor$compress$1.D$0;
                        expectResolution2 = (Resolution) localImageAssetAndroidCompressor$compress$1.L$1;
                        asset3 = (LocalImageAsset) localImageAssetAndroidCompressor$compress$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        byte[] byteArray2 = SourcesKt.readByteArray((Source) obj);
                        int coerceAtMost2 = RangesKt.coerceAtMost(MathKt.roundToInt(ContentSize.div-4yfSoQ8(d2, asset3.m1599getContentSizeQJZHGII()) * 100), 100);
                        localImageAssetAndroidCompressor$compress$1.L$0 = asset3;
                        localImageAssetAndroidCompressor$compress$1.L$1 = SpillingKt.nullOutSpilledVariable(expectResolution2);
                        localImageAssetAndroidCompressor$compress$1.L$2 = SpillingKt.nullOutSpilledVariable(byteArray2);
                        localImageAssetAndroidCompressor$compress$1.D$0 = d2;
                        localImageAssetAndroidCompressor$compress$1.label = 2;
                        compressImage = BiliImage_androidKt.compressImage(byteArray2, coerceAtMost2, localImageAssetAndroidCompressor$compress$1);
                        if (compressImage != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        double d3 = localImageAssetAndroidCompressor$compress$1.D$0;
                        byte[] bArr = (byte[]) localImageAssetAndroidCompressor$compress$1.L$2;
                        Resolution resolution = (Resolution) localImageAssetAndroidCompressor$compress$1.L$1;
                        LocalImageAsset asset4 = (LocalImageAsset) localImageAssetAndroidCompressor$compress$1.L$0;
                        ResultKt.throwOnFailure($result);
                        compressImage = ((Result) $result).unbox-impl();
                        asset2 = asset4;
                        if (Result.isSuccess-impl(compressImage)) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        localImageAssetAndroidCompressor$compress$1 = new LocalImageAssetAndroidCompressor$compress$1(this, continuation);
        Object $result2 = localImageAssetAndroidCompressor$compress$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (localImageAssetAndroidCompressor$compress$1.label) {
        }
    }
}