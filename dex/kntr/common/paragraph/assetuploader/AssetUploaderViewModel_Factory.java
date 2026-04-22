package kntr.common.paragraph.assetuploader;

import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachineFactory;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AssetUploaderViewModel_Factory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/common/paragraph/assetuploader/AssetUploaderViewModel_Factory;", "", "stateMachineFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Lkntr/common/paragraph/assetuploader/AssetUploaderViewModel;", "asset", "Lkntr/common/photonic/Asset;", "useOrigin", "", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderViewModel_Factory {
    public static final Companion Companion = new Companion(null);
    private final Provider<CoroutineScope> scopeProvider;
    private final Provider<AssetUploaderStateMachineFactory> stateMachineFactoryProvider;

    public AssetUploaderViewModel_Factory(Provider<AssetUploaderStateMachineFactory> provider, Provider<CoroutineScope> provider2) {
        Intrinsics.checkNotNullParameter(provider, "stateMachineFactoryProvider");
        Intrinsics.checkNotNullParameter(provider2, "scopeProvider");
        this.stateMachineFactoryProvider = provider;
        this.scopeProvider = provider2;
    }

    public final AssetUploaderViewModel get(Asset asset, boolean useOrigin) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Companion companion = Companion;
        Object obj = this.stateMachineFactoryProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.scopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance(asset, useOrigin, (AssetUploaderStateMachineFactory) obj, (CoroutineScope) obj2);
    }

    /* compiled from: AssetUploaderViewModel_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0007¨\u0006\u0013"}, d2 = {"Lkntr/common/paragraph/assetuploader/AssetUploaderViewModel_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/paragraph/assetuploader/AssetUploaderViewModel_Factory;", "stateMachineFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "newInstance", "Lkntr/common/paragraph/assetuploader/AssetUploaderViewModel;", "asset", "Lkntr/common/photonic/Asset;", "useOrigin", "", "stateMachineFactory", "scope", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssetUploaderViewModel_Factory create(Provider<AssetUploaderStateMachineFactory> provider, Provider<CoroutineScope> provider2) {
            Intrinsics.checkNotNullParameter(provider, "stateMachineFactoryProvider");
            Intrinsics.checkNotNullParameter(provider2, "scopeProvider");
            return new AssetUploaderViewModel_Factory(provider, provider2);
        }

        @JvmStatic
        public final AssetUploaderViewModel newInstance(Asset asset, boolean useOrigin, AssetUploaderStateMachineFactory stateMachineFactory, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            Intrinsics.checkNotNullParameter(stateMachineFactory, "stateMachineFactory");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new AssetUploaderViewModel(asset, useOrigin, stateMachineFactory, scope);
        }
    }

    @JvmStatic
    public static final AssetUploaderViewModel_Factory create(Provider<AssetUploaderStateMachineFactory> provider, Provider<CoroutineScope> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final AssetUploaderViewModel newInstance(Asset asset, boolean useOrigin, AssetUploaderStateMachineFactory stateMachineFactory, CoroutineScope scope) {
        return Companion.newInstance(asset, useOrigin, stateMachineFactory, scope);
    }
}