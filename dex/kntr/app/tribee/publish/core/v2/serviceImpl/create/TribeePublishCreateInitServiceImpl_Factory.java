package kntr.app.tribee.publish.core.v2.serviceImpl.create;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishCreateInitServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeePublishCreateInitServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeePublishCreateInitServiceImpl;", "draftServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "tribeeInfoProvider", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "converterProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "ouroStoreProvider", "Lkntr/common/ouro/core/OuroStore;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishCreateInitServiceImpl_Factory implements Factory<TribeePublishCreateInitServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<TribeePublishDataConverter> converterProvider;
    private final Provider<TribeePublishDraftService> draftServiceProvider;
    private final Provider<OuroStore> ouroStoreProvider;
    private final Provider<TribeeInfo> tribeeInfoProvider;

    public TribeePublishCreateInitServiceImpl_Factory(Provider<TribeePublishDraftService> provider, Provider<TribeeInfo> provider2, Provider<TribeePublishDataConverter> provider3, Provider<OuroStore> provider4) {
        Intrinsics.checkNotNullParameter(provider, "draftServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "tribeeInfoProvider");
        Intrinsics.checkNotNullParameter(provider3, "converterProvider");
        Intrinsics.checkNotNullParameter(provider4, "ouroStoreProvider");
        this.draftServiceProvider = provider;
        this.tribeeInfoProvider = provider2;
        this.converterProvider = provider3;
        this.ouroStoreProvider = provider4;
    }

    public TribeePublishCreateInitServiceImpl get() {
        Companion companion = Companion;
        Object obj = this.draftServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.tribeeInfoProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.converterProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.ouroStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        return companion.newInstance((TribeePublishDraftService) obj, (TribeeInfo) obj2, (TribeePublishDataConverter) obj3, (OuroStore) obj4);
    }

    /* compiled from: TribeePublishCreateInitServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeePublishCreateInitServiceImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeePublishCreateInitServiceImpl_Factory;", "draftServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "tribeeInfoProvider", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "converterProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "ouroStoreProvider", "Lkntr/common/ouro/core/OuroStore;", "newInstance", "Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeePublishCreateInitServiceImpl;", "draftService", "tribeeInfo", "converter", "ouroStore", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishCreateInitServiceImpl_Factory create(Provider<TribeePublishDraftService> provider, Provider<TribeeInfo> provider2, Provider<TribeePublishDataConverter> provider3, Provider<OuroStore> provider4) {
            Intrinsics.checkNotNullParameter(provider, "draftServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "tribeeInfoProvider");
            Intrinsics.checkNotNullParameter(provider3, "converterProvider");
            Intrinsics.checkNotNullParameter(provider4, "ouroStoreProvider");
            return new TribeePublishCreateInitServiceImpl_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final TribeePublishCreateInitServiceImpl newInstance(TribeePublishDraftService draftService, TribeeInfo tribeeInfo, TribeePublishDataConverter converter, OuroStore ouroStore) {
            Intrinsics.checkNotNullParameter(draftService, "draftService");
            Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
            return new TribeePublishCreateInitServiceImpl(draftService, tribeeInfo, converter, ouroStore);
        }
    }

    @JvmStatic
    public static final TribeePublishCreateInitServiceImpl_Factory create(Provider<TribeePublishDraftService> provider, Provider<TribeeInfo> provider2, Provider<TribeePublishDataConverter> provider3, Provider<OuroStore> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final TribeePublishCreateInitServiceImpl newInstance(TribeePublishDraftService draftService, TribeeInfo tribeeInfo, TribeePublishDataConverter converter, OuroStore ouroStore) {
        return Companion.newInstance(draftService, tribeeInfo, converter, ouroStore);
    }
}