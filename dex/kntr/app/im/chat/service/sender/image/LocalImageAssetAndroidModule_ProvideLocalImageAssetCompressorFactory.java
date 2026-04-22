package kntr.app.im.chat.service.sender.image;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kntr.common.photonic.compressor.AssetCompressor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;

/* compiled from: LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory;", "Ldagger/internal/Factory;", "Lkntr/common/photonic/compressor/AssetCompressor;", "Lkntr/common/photonic/Asset;", "cacheDirProvider", "Ljavax/inject/Provider;", "Lkotlinx/io/files/Path;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory implements Factory<AssetCompressor<? extends Asset>> {
    private final Provider<Path> cacheDirProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory(Provider<Path> provider) {
        Intrinsics.checkNotNullParameter(provider, "cacheDirProvider");
        this.cacheDirProvider = provider;
    }

    public AssetCompressor<? extends Asset> get() {
        Companion companion = Companion;
        Path path = this.cacheDirProvider.get();
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return companion.provideLocalImageAssetCompressor(path);
    }

    /* compiled from: LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0018\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/service/sender/image/LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory;", "cacheDirProvider", "Ljavax/inject/Provider;", "Lkotlinx/io/files/Path;", "provideLocalImageAssetCompressor", "Lkntr/common/photonic/compressor/AssetCompressor;", "Lkntr/common/photonic/Asset;", "cacheDir", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory create(Provider<Path> provider) {
            Intrinsics.checkNotNullParameter(provider, "cacheDirProvider");
            return new LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory(provider);
        }

        @JvmStatic
        public final AssetCompressor<? extends Asset> provideLocalImageAssetCompressor(Path cacheDir) {
            Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
            return LocalImageAssetAndroidModule.INSTANCE.provideLocalImageAssetCompressor(cacheDir);
        }
    }

    @JvmStatic
    public static final LocalImageAssetAndroidModule_ProvideLocalImageAssetCompressorFactory create(Provider<Path> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final AssetCompressor<? extends Asset> provideLocalImageAssetCompressor(Path cacheDir) {
        return Companion.provideLocalImageAssetCompressor(cacheDir);
    }
}