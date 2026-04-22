package kntr.app.tribee.publish.core.v2.di.create;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishServiceModule_InitStateFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/create/TribeePublishServiceModule_InitStateFactory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "tribeeInfoProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishServiceModule_InitStateFactory implements Factory<TribeePublishState> {
    public static final Companion Companion = new Companion(null);
    private final Provider<TribeeInfo> tribeeInfoProvider;

    public TribeePublishServiceModule_InitStateFactory(Provider<TribeeInfo> provider) {
        Intrinsics.checkNotNullParameter(provider, "tribeeInfoProvider");
        this.tribeeInfoProvider = provider;
    }

    public TribeePublishState get() {
        Companion companion = Companion;
        Object obj = this.tribeeInfoProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.initState((TribeeInfo) obj);
    }

    /* compiled from: TribeePublishServiceModule_InitStateFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/create/TribeePublishServiceModule_InitStateFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/publish/core/v2/di/create/TribeePublishServiceModule_InitStateFactory;", "tribeeInfoProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "initState", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "tribeeInfo", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeePublishServiceModule_InitStateFactory create(Provider<TribeeInfo> provider) {
            Intrinsics.checkNotNullParameter(provider, "tribeeInfoProvider");
            return new TribeePublishServiceModule_InitStateFactory(provider);
        }

        @JvmStatic
        public final TribeePublishState initState(TribeeInfo tribeeInfo) {
            Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
            return TribeePublishServiceModule.INSTANCE.initState(tribeeInfo);
        }
    }

    @JvmStatic
    public static final TribeePublishServiceModule_InitStateFactory create(Provider<TribeeInfo> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final TribeePublishState initState(TribeeInfo tribeeInfo) {
        return Companion.initState(tribeeInfo);
    }
}