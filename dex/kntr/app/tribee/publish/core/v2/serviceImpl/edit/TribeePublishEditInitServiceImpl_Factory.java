package kntr.app.tribee.publish.core.v2.serviceImpl.edit;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishEditInitServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/edit/TribeePublishEditInitServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/core/v2/serviceImpl/edit/TribeePublishEditInitServiceImpl;", "tribeeInfoProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "converterProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "ouroStoreProvider", "Lkntr/common/ouro/core/OuroStore;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishEditInitServiceImpl_Factory implements Factory<TribeePublishEditInitServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<TribeePublishDataConverter> converterProvider;
    private final Provider<OuroStore> ouroStoreProvider;
    private final Provider<TribeeInfo> tribeeInfoProvider;

    public TribeePublishEditInitServiceImpl_Factory(Provider<TribeeInfo> provider, Provider<TribeePublishDataConverter> provider2, Provider<OuroStore> provider3) {
        Intrinsics.checkNotNullParameter(provider, "tribeeInfoProvider");
        Intrinsics.checkNotNullParameter(provider2, "converterProvider");
        Intrinsics.checkNotNullParameter(provider3, "ouroStoreProvider");
        this.tribeeInfoProvider = provider;
        this.converterProvider = provider2;
        this.ouroStoreProvider = provider3;
    }

    public TribeePublishEditInitServiceImpl get() {
        Companion companion = Companion;
        Object obj = this.tribeeInfoProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.converterProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.ouroStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.newInstance((TribeeInfo) obj, (TribeePublishDataConverter) obj2, (OuroStore) obj3);
    }

    /* compiled from: TribeePublishEditInitServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/edit/TribeePublishEditInitServiceImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/core/v2/serviceImpl/edit/TribeePublishEditInitServiceImpl_Factory;", "tribeeInfoProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "converterProvider", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "ouroStoreProvider", "Lkntr/common/ouro/core/OuroStore;", "newInstance", "Lkntr/app/tribee/publish/core/v2/serviceImpl/edit/TribeePublishEditInitServiceImpl;", "tribeeInfo", "converter", "ouroStore", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishEditInitServiceImpl_Factory create(Provider<TribeeInfo> provider, Provider<TribeePublishDataConverter> provider2, Provider<OuroStore> provider3) {
            Intrinsics.checkNotNullParameter(provider, "tribeeInfoProvider");
            Intrinsics.checkNotNullParameter(provider2, "converterProvider");
            Intrinsics.checkNotNullParameter(provider3, "ouroStoreProvider");
            return new TribeePublishEditInitServiceImpl_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final TribeePublishEditInitServiceImpl newInstance(TribeeInfo tribeeInfo, TribeePublishDataConverter converter, OuroStore ouroStore) {
            Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
            return new TribeePublishEditInitServiceImpl(tribeeInfo, converter, ouroStore);
        }
    }

    @JvmStatic
    public static final TribeePublishEditInitServiceImpl_Factory create(Provider<TribeeInfo> provider, Provider<TribeePublishDataConverter> provider2, Provider<OuroStore> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final TribeePublishEditInitServiceImpl newInstance(TribeeInfo tribeeInfo, TribeePublishDataConverter converter, OuroStore ouroStore) {
        return Companion.newInstance(tribeeInfo, converter, ouroStore);
    }
}