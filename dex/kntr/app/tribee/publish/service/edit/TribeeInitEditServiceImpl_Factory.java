package kntr.app.tribee.publish.service.edit;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInitEditServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/service/edit/TribeeInitEditServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/service/edit/TribeeInitEditServiceImpl;", "tribeeInfoProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/TribeeInfo;", "converterProvider", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInitEditServiceImpl_Factory implements Factory<TribeeInitEditServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<TribeeContentConverter> converterProvider;
    private final Provider<TribeeInfo> tribeeInfoProvider;

    public TribeeInitEditServiceImpl_Factory(Provider<TribeeInfo> provider, Provider<TribeeContentConverter> provider2) {
        Intrinsics.checkNotNullParameter(provider, "tribeeInfoProvider");
        Intrinsics.checkNotNullParameter(provider2, "converterProvider");
        this.tribeeInfoProvider = provider;
        this.converterProvider = provider2;
    }

    public TribeeInitEditServiceImpl get() {
        Companion companion = Companion;
        Object obj = this.tribeeInfoProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.converterProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance((TribeeInfo) obj, (TribeeContentConverter) obj2);
    }

    /* compiled from: TribeeInitEditServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/tribee/publish/service/edit/TribeeInitEditServiceImpl_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/service/edit/TribeeInitEditServiceImpl_Factory;", "tribeeInfoProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/TribeeInfo;", "converterProvider", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "newInstance", "Lkntr/app/tribee/publish/service/edit/TribeeInitEditServiceImpl;", "tribeeInfo", "converter", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeInitEditServiceImpl_Factory create(Provider<TribeeInfo> provider, Provider<TribeeContentConverter> provider2) {
            Intrinsics.checkNotNullParameter(provider, "tribeeInfoProvider");
            Intrinsics.checkNotNullParameter(provider2, "converterProvider");
            return new TribeeInitEditServiceImpl_Factory(provider, provider2);
        }

        @JvmStatic
        public final TribeeInitEditServiceImpl newInstance(TribeeInfo tribeeInfo, TribeeContentConverter converter) {
            Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
            Intrinsics.checkNotNullParameter(converter, "converter");
            return new TribeeInitEditServiceImpl(tribeeInfo, converter);
        }
    }

    @JvmStatic
    public static final TribeeInitEditServiceImpl_Factory create(Provider<TribeeInfo> provider, Provider<TribeeContentConverter> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final TribeeInitEditServiceImpl newInstance(TribeeInfo tribeeInfo, TribeeContentConverter converter) {
        return Companion.newInstance(tribeeInfo, converter);
    }
}