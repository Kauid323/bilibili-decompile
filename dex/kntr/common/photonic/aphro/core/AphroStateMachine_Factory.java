package kntr.common.photonic.aphro.core;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.assets.AphroAssetsBuilder;
import kntr.common.photonic.gallery.Gallery;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/common/photonic/aphro/core/AphroStateMachine;", "initStateProvider", "Ljavax/inject/Provider;", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "galleryProvider", "Lkntr/common/photonic/gallery/Gallery;", "assetsFactoryProvider", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsBuilder;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroStateMachine_Factory implements Factory<AphroStateMachine> {
    private final Provider<AphroAssetsBuilder> assetsFactoryProvider;
    private final Provider<Gallery> galleryProvider;
    private final Provider<AphroState.Init> initStateProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AphroStateMachine_Factory(Provider<AphroState.Init> provider, Provider<Gallery> provider2, Provider<AphroAssetsBuilder> provider3) {
        Intrinsics.checkNotNullParameter(provider, "initStateProvider");
        Intrinsics.checkNotNullParameter(provider2, "galleryProvider");
        Intrinsics.checkNotNullParameter(provider3, "assetsFactoryProvider");
        this.initStateProvider = provider;
        this.galleryProvider = provider2;
        this.assetsFactoryProvider = provider3;
    }

    public AphroStateMachine get() {
        Companion companion = Companion;
        Object obj = this.initStateProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.galleryProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.assetsFactoryProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.newInstance((AphroState.Init) obj, (Gallery) obj2, (AphroAssetsBuilder) obj3);
    }

    /* compiled from: AphroStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/photonic/aphro/core/AphroStateMachine_Factory;", "initStateProvider", "Ljavax/inject/Provider;", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "galleryProvider", "Lkntr/common/photonic/gallery/Gallery;", "assetsFactoryProvider", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsBuilder;", "newInstance", "Lkntr/common/photonic/aphro/core/AphroStateMachine;", "initState", "gallery", "assetsFactory", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AphroStateMachine_Factory create(Provider<AphroState.Init> provider, Provider<Gallery> provider2, Provider<AphroAssetsBuilder> provider3) {
            Intrinsics.checkNotNullParameter(provider, "initStateProvider");
            Intrinsics.checkNotNullParameter(provider2, "galleryProvider");
            Intrinsics.checkNotNullParameter(provider3, "assetsFactoryProvider");
            return new AphroStateMachine_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final AphroStateMachine newInstance(AphroState.Init initState, Gallery gallery, AphroAssetsBuilder assetsFactory) {
            Intrinsics.checkNotNullParameter(initState, "initState");
            Intrinsics.checkNotNullParameter(gallery, "gallery");
            Intrinsics.checkNotNullParameter(assetsFactory, "assetsFactory");
            return new AphroStateMachine(initState, gallery, assetsFactory);
        }
    }

    @JvmStatic
    public static final AphroStateMachine_Factory create(Provider<AphroState.Init> provider, Provider<Gallery> provider2, Provider<AphroAssetsBuilder> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final AphroStateMachine newInstance(AphroState.Init initState, Gallery gallery, AphroAssetsBuilder assetsFactory) {
        return Companion.newInstance(initState, gallery, assetsFactory);
    }
}