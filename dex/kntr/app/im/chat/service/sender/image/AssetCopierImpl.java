package kntr.app.im.chat.service.sender.image;

import im.base.IMLog;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.base.utils.foundation.AppCacheDirectory;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.BuildersKt;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: AssetCopier.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u0007*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/service/sender/image/AssetCopierImpl;", "Lkntr/app/im/chat/service/sender/image/AssetCopier;", "cacheDir", "Lkotlinx/io/files/Path;", "<init>", "(Lkotlinx/io/files/Path;)V", "copyToCache", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "asset", "Lkntr/common/photonic/Asset;", "(Lkntr/common/photonic/Asset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCache", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyTo", "target", "(Lkntr/common/photonic/Asset;Lkotlinx/io/files/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetCopierImpl implements AssetCopier {
    public static final int $stable = 8;
    private final Path cacheDir;

    @Inject
    public AssetCopierImpl(@AppCacheDirectory Path cacheDir) {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        this.cacheDir = cacheDir;
    }

    @Override // kntr.app.im.chat.service.sender.image.AssetCopier
    public Object copyToCache(Asset asset, Continuation<? super LocalImageAsset> continuation) {
        Path path = this.cacheDir;
        Uuid random = Uuid.Companion.random();
        Path target = PathsKt.Path(path, new String[]{"chat", "image", random + "." + asset.getMimeType().getSubType()});
        Path it = target.getParent();
        if (it != null) {
            FileSystemJvmKt.SystemFileSystem.createDirectories(it, false);
        }
        IMLog.Companion.i("ImageSender", "Copying asset " + asset.getIdentifier() + " to " + target);
        return copyTo(asset, target, continuation);
    }

    @Override // kntr.app.im.chat.service.sender.image.AssetCopier
    public Object removeCache(LocalImageAsset asset, Continuation<? super Unit> continuation) {
        IMLog.Companion.i("ImageSender", "Removing asset " + asset.getIdentifier() + " from cache");
        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new AssetCopierImpl$removeCache$2(asset, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object copyTo(Asset $this$copyTo, Path target, Continuation<? super LocalImageAsset> continuation) {
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new AssetCopierImpl$copyTo$2(target, $this$copyTo, null), continuation);
    }
}