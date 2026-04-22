package kntr.app.tribee.publish.core.v2.serviceImpl;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.di.OuroComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishDataConverterImpl_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl;", "ouroComponentProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/di/OuroComponent;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishDataConverterImpl_Factory implements Factory<TribeePublishDataConverterImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<OuroComponent> ouroComponentProvider;

    public TribeePublishDataConverterImpl_Factory(Provider<OuroComponent> provider) {
        Intrinsics.checkNotNullParameter(provider, "ouroComponentProvider");
        this.ouroComponentProvider = provider;
    }

    public TribeePublishDataConverterImpl get() {
        Companion companion = Companion;
        Object obj = this.ouroComponentProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((OuroComponent) obj);
    }

    /* compiled from: TribeePublishDataConverterImpl_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl_Factory;", "ouroComponentProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/di/OuroComponent;", "newInstance", "Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeePublishDataConverterImpl;", "ouroComponent", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishDataConverterImpl_Factory create(Provider<OuroComponent> provider) {
            Intrinsics.checkNotNullParameter(provider, "ouroComponentProvider");
            return new TribeePublishDataConverterImpl_Factory(provider);
        }

        @JvmStatic
        public final TribeePublishDataConverterImpl newInstance(OuroComponent ouroComponent) {
            Intrinsics.checkNotNullParameter(ouroComponent, "ouroComponent");
            return new TribeePublishDataConverterImpl(ouroComponent);
        }
    }

    @JvmStatic
    public static final TribeePublishDataConverterImpl_Factory create(Provider<OuroComponent> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final TribeePublishDataConverterImpl newInstance(OuroComponent ouroComponent) {
        return Companion.newInstance(ouroComponent);
    }
}