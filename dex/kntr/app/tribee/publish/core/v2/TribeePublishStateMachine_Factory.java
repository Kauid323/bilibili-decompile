package kntr.app.tribee.publish.core.v2;

import com.google.common.base.Optional;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.tribee.publish.core.v2.service.TribeePublishInitService;
import kntr.app.tribee.publish.core.v2.service.TribeePublishService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014Ba\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine;", "initProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "ouroStoreProvider", "Lkntr/common/ouro/core/OuroStore;", "initServiceProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishInitService;", "publishServiceProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;", "draftServiceProvider", "Lcom/google/common/base/Optional;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "converterProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishStateMachine_Factory implements Factory<TribeePublishStateMachine> {
    public static final Companion Companion = new Companion(null);
    private final Provider<TribeePublishDataConverter> converterProvider;
    private final Provider<Optional<TribeePublishDraftService>> draftServiceProvider;
    private final Provider<TribeePublishState> initProvider;
    private final Provider<TribeePublishInitService> initServiceProvider;
    private final Provider<OuroStore> ouroStoreProvider;
    private final Provider<TribeePublishService> publishServiceProvider;

    public TribeePublishStateMachine_Factory(Provider<TribeePublishState> provider, Provider<OuroStore> provider2, Provider<TribeePublishInitService> provider3, Provider<TribeePublishService> provider4, Provider<Optional<TribeePublishDraftService>> provider5, Provider<TribeePublishDataConverter> provider6) {
        Intrinsics.checkNotNullParameter(provider, "initProvider");
        Intrinsics.checkNotNullParameter(provider2, "ouroStoreProvider");
        Intrinsics.checkNotNullParameter(provider3, "initServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "publishServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "draftServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "converterProvider");
        this.initProvider = provider;
        this.ouroStoreProvider = provider2;
        this.initServiceProvider = provider3;
        this.publishServiceProvider = provider4;
        this.draftServiceProvider = provider5;
        this.converterProvider = provider6;
    }

    public TribeePublishStateMachine get() {
        Companion companion = Companion;
        Object obj = this.initProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.ouroStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.initServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.publishServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        Object obj5 = this.draftServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj5, "get(...)");
        Object obj6 = this.converterProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj6, "get(...)");
        return companion.newInstance((TribeePublishState) obj, (OuroStore) obj2, (TribeePublishInitService) obj3, (TribeePublishService) obj4, (Optional) obj5, (TribeePublishDataConverter) obj6);
    }

    /* compiled from: TribeePublishStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007H\u0007J>\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001b\u001a\u00020\u0013H\u0007¨\u0006\u001c"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine_Factory;", "initProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "ouroStoreProvider", "Lkntr/common/ouro/core/OuroStore;", "initServiceProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishInitService;", "publishServiceProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;", "draftServiceProvider", "Lcom/google/common/base/Optional;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "converterProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "newInstance", "Lkntr/app/tribee/publish/core/v2/TribeePublishStateMachine;", "init", "ouroStore", "initService", "publishService", "draftService", "converter", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishStateMachine_Factory create(Provider<TribeePublishState> provider, Provider<OuroStore> provider2, Provider<TribeePublishInitService> provider3, Provider<TribeePublishService> provider4, Provider<Optional<TribeePublishDraftService>> provider5, Provider<TribeePublishDataConverter> provider6) {
            Intrinsics.checkNotNullParameter(provider, "initProvider");
            Intrinsics.checkNotNullParameter(provider2, "ouroStoreProvider");
            Intrinsics.checkNotNullParameter(provider3, "initServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "publishServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "draftServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "converterProvider");
            return new TribeePublishStateMachine_Factory(provider, provider2, provider3, provider4, provider5, provider6);
        }

        @JvmStatic
        public final TribeePublishStateMachine newInstance(TribeePublishState init, OuroStore ouroStore, TribeePublishInitService initService, TribeePublishService publishService, Optional<TribeePublishDraftService> optional, TribeePublishDataConverter converter) {
            Intrinsics.checkNotNullParameter(init, "init");
            Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
            Intrinsics.checkNotNullParameter(initService, "initService");
            Intrinsics.checkNotNullParameter(publishService, "publishService");
            Intrinsics.checkNotNullParameter(optional, "draftService");
            Intrinsics.checkNotNullParameter(converter, "converter");
            return new TribeePublishStateMachine(init, ouroStore, initService, publishService, optional, converter);
        }
    }

    @JvmStatic
    public static final TribeePublishStateMachine_Factory create(Provider<TribeePublishState> provider, Provider<OuroStore> provider2, Provider<TribeePublishInitService> provider3, Provider<TribeePublishService> provider4, Provider<Optional<TribeePublishDraftService>> provider5, Provider<TribeePublishDataConverter> provider6) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @JvmStatic
    public static final TribeePublishStateMachine newInstance(TribeePublishState init, OuroStore ouroStore, TribeePublishInitService initService, TribeePublishService publishService, Optional<TribeePublishDraftService> optional, TribeePublishDataConverter converter) {
        return Companion.newInstance(init, ouroStore, initService, publishService, optional, converter);
    }
}