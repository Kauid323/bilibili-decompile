package kntr.common.photonic.compressor;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetCompressorHolder_Factory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/photonic/compressor/AssetCompressorHolder_Factory;", "Ldagger/internal/Factory;", "Lkntr/common/photonic/compressor/AssetCompressorHolder;", "compressorSetProvider", "Ljavax/inject/Provider;", "", "Lkntr/common/photonic/compressor/AssetCompressor;", "Lkntr/common/photonic/Asset;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetCompressorHolder_Factory implements Factory<AssetCompressorHolder> {
    private final Provider<Set<AssetCompressor<? extends Asset>>> compressorSetProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AssetCompressorHolder_Factory(Provider<Set<AssetCompressor<? extends Asset>>> provider) {
        Intrinsics.checkNotNullParameter(provider, "compressorSetProvider");
        this.compressorSetProvider = provider;
    }

    public AssetCompressorHolder get() {
        Companion companion = Companion;
        Object obj = this.compressorSetProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((Set) obj);
    }

    /* compiled from: AssetCompressorHolder_Factory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b0\u0007H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\bH\u0007¨\u0006\u000e"}, d2 = {"Lkntr/common/photonic/compressor/AssetCompressorHolder_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/photonic/compressor/AssetCompressorHolder_Factory;", "compressorSetProvider", "Ljavax/inject/Provider;", "", "Lkntr/common/photonic/compressor/AssetCompressor;", "Lkntr/common/photonic/Asset;", "newInstance", "Lkntr/common/photonic/compressor/AssetCompressorHolder;", "compressorSet", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssetCompressorHolder_Factory create(Provider<Set<AssetCompressor<? extends Asset>>> provider) {
            Intrinsics.checkNotNullParameter(provider, "compressorSetProvider");
            return new AssetCompressorHolder_Factory(provider);
        }

        @JvmStatic
        public final AssetCompressorHolder newInstance(Set<? extends AssetCompressor<? extends Asset>> set) {
            Intrinsics.checkNotNullParameter(set, "compressorSet");
            return new AssetCompressorHolder(set);
        }
    }

    @JvmStatic
    public static final AssetCompressorHolder_Factory create(Provider<Set<AssetCompressor<? extends Asset>>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final AssetCompressorHolder newInstance(Set<? extends AssetCompressor<? extends Asset>> set) {
        return Companion.newInstance(set);
    }
}