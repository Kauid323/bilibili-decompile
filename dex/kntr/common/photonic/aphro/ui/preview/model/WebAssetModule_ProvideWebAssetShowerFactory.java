package kntr.common.photonic.aphro.ui.preview.model;

import dagger.internal.Factory;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WebAssetModule_ProvideWebAssetShowerFactory.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¨\u0006\b"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WebAssetModule_ProvideWebAssetShowerFactory;", "Ldagger/internal/Factory;", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/Asset;", "<init>", "()V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WebAssetModule_ProvideWebAssetShowerFactory implements Factory<AssetShower<? extends Asset>> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final WebAssetModule_ProvideWebAssetShowerFactory INSTANCE = new WebAssetModule_ProvideWebAssetShowerFactory();

    public AssetShower<? extends Asset> get() {
        return Companion.provideWebAssetShower();
    }

    /* compiled from: WebAssetModule_ProvideWebAssetShowerFactory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/WebAssetModule_ProvideWebAssetShowerFactory$Companion;", "", "<init>", "()V", "INSTANCE", "Lkntr/common/photonic/aphro/ui/preview/model/WebAssetModule_ProvideWebAssetShowerFactory;", "create", "provideWebAssetShower", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/Asset;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WebAssetModule_ProvideWebAssetShowerFactory create() {
            return WebAssetModule_ProvideWebAssetShowerFactory.INSTANCE;
        }

        @JvmStatic
        public final AssetShower<? extends Asset> provideWebAssetShower() {
            return WebAssetModule.INSTANCE.provideWebAssetShower();
        }
    }

    @JvmStatic
    public static final WebAssetModule_ProvideWebAssetShowerFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final AssetShower<? extends Asset> provideWebAssetShower() {
        return Companion.provideWebAssetShower();
    }
}