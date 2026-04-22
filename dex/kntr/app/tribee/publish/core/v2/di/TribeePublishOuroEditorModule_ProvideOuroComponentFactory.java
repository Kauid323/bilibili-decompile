package kntr.app.tribee.publish.core.v2.di;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.di.OuroComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishOuroEditorModule_ProvideOuroComponentFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishOuroEditorModule_ProvideOuroComponentFactory;", "Ldagger/internal/Factory;", "Lkntr/common/ouro/core/di/OuroComponent;", "ouroComponentFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/di/OuroComponent$Factory;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "initialStateProvider", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishOuroEditorModule_ProvideOuroComponentFactory implements Factory<OuroComponent> {
    public static final Companion Companion = new Companion(null);
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<OuroState> initialStateProvider;
    private final Provider<OuroComponent.Factory> ouroComponentFactoryProvider;

    public TribeePublishOuroEditorModule_ProvideOuroComponentFactory(Provider<OuroComponent.Factory> provider, Provider<CoroutineScope> provider2, Provider<OuroState> provider3) {
        Intrinsics.checkNotNullParameter(provider, "ouroComponentFactoryProvider");
        Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider3, "initialStateProvider");
        this.ouroComponentFactoryProvider = provider;
        this.coroutineScopeProvider = provider2;
        this.initialStateProvider = provider3;
    }

    public OuroComponent get() {
        Companion companion = Companion;
        Object obj = this.ouroComponentFactoryProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.initialStateProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.provideOuroComponent((OuroComponent.Factory) obj, (CoroutineScope) obj2, (OuroState) obj3);
    }

    /* compiled from: TribeePublishOuroEditorModule_ProvideOuroComponentFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/TribeePublishOuroEditorModule_ProvideOuroComponentFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/core/v2/di/TribeePublishOuroEditorModule_ProvideOuroComponentFactory;", "ouroComponentFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/di/OuroComponent$Factory;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "initialStateProvider", "Lkntr/common/ouro/core/OuroState;", "provideOuroComponent", "Lkntr/common/ouro/core/di/OuroComponent;", "ouroComponentFactory", "coroutineScope", "initialState", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishOuroEditorModule_ProvideOuroComponentFactory create(Provider<OuroComponent.Factory> provider, Provider<CoroutineScope> provider2, Provider<OuroState> provider3) {
            Intrinsics.checkNotNullParameter(provider, "ouroComponentFactoryProvider");
            Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider3, "initialStateProvider");
            return new TribeePublishOuroEditorModule_ProvideOuroComponentFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final OuroComponent provideOuroComponent(OuroComponent.Factory ouroComponentFactory, CoroutineScope coroutineScope, OuroState initialState) {
            Intrinsics.checkNotNullParameter(ouroComponentFactory, "ouroComponentFactory");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            return TribeePublishOuroEditorModule.INSTANCE.provideOuroComponent(ouroComponentFactory, coroutineScope, initialState);
        }
    }

    @JvmStatic
    public static final TribeePublishOuroEditorModule_ProvideOuroComponentFactory create(Provider<OuroComponent.Factory> provider, Provider<CoroutineScope> provider2, Provider<OuroState> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final OuroComponent provideOuroComponent(OuroComponent.Factory ouroComponentFactory, CoroutineScope coroutineScope, OuroState initialState) {
        return Companion.provideOuroComponent(ouroComponentFactory, coroutineScope, initialState);
    }
}