package kntr.app.tribee.publish.core.v2.di;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.di.AssetUploaderComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory;", "Ldagger/internal/Factory;", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "assetUploaderComponentBuilderProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/di/AssetUploaderComponent$Builder;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory implements Factory<AssetUploader> {
    public static final Companion Companion = new Companion(null);
    private final Provider<AssetUploaderComponent.Builder> assetUploaderComponentBuilderProvider;
    private final Provider<CoroutineScope> scopeProvider;

    public TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory(Provider<AssetUploaderComponent.Builder> provider, Provider<CoroutineScope> provider2) {
        Intrinsics.checkNotNullParameter(provider, "assetUploaderComponentBuilderProvider");
        Intrinsics.checkNotNullParameter(provider2, "scopeProvider");
        this.assetUploaderComponentBuilderProvider = provider;
        this.scopeProvider = provider2;
    }

    public AssetUploader get() {
        Companion companion = Companion;
        Object obj = this.assetUploaderComponentBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.scopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.provideOuroAssetUploader((AssetUploaderComponent.Builder) obj, (CoroutineScope) obj2);
    }

    /* compiled from: TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/core/v2/di/TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory;", "assetUploaderComponentBuilderProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/di/AssetUploaderComponent$Builder;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "provideOuroAssetUploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "assetUploaderComponentBuilder", "scope", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory create(Provider<AssetUploaderComponent.Builder> provider, Provider<CoroutineScope> provider2) {
            Intrinsics.checkNotNullParameter(provider, "assetUploaderComponentBuilderProvider");
            Intrinsics.checkNotNullParameter(provider2, "scopeProvider");
            return new TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory(provider, provider2);
        }

        @JvmStatic
        public final AssetUploader provideOuroAssetUploader(AssetUploaderComponent.Builder assetUploaderComponentBuilder, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(assetUploaderComponentBuilder, "assetUploaderComponentBuilder");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return TribeePublishOuroEditorModule.INSTANCE.provideOuroAssetUploader(assetUploaderComponentBuilder, scope);
        }
    }

    @JvmStatic
    public static final TribeePublishOuroEditorModule_ProvideOuroAssetUploaderFactory create(Provider<AssetUploaderComponent.Builder> provider, Provider<CoroutineScope> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final AssetUploader provideOuroAssetUploader(AssetUploaderComponent.Builder assetUploaderComponentBuilder, CoroutineScope scope) {
        return Companion.provideOuroAssetUploader(assetUploaderComponentBuilder, scope);
    }
}