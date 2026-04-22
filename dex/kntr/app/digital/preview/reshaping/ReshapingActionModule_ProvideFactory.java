package kntr.app.digital.preview.reshaping;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReshapingActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \f2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\fB)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/digital/preview/reshaping/ReshapingActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "dismissRequestProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/closing/DismissRequest;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReshapingActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<DismissRequest> dismissRequestProvider;
    private final Provider<KomponentScope<Unit>> komponentScopeProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ReshapingActionModule_ProvideFactory(Provider<DismissRequest> provider, Provider<KomponentScope<Unit>> provider2) {
        Intrinsics.checkNotNullParameter(provider, "dismissRequestProvider");
        Intrinsics.checkNotNullParameter(provider2, "komponentScopeProvider");
        this.dismissRequestProvider = provider;
        this.komponentScopeProvider = provider2;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        DismissRequest dismissRequest = this.dismissRequestProvider.get();
        Intrinsics.checkNotNullExpressionValue(dismissRequest, "get(...)");
        KomponentScope<Unit> komponentScope = this.komponentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(komponentScope, "get(...)");
        return companion.provide(dismissRequest, komponentScope);
    }

    /* compiled from: ReshapingActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007H\u0007J\"\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/reshaping/ReshapingActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/reshaping/ReshapingActionModule_ProvideFactory;", "dismissRequestProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/closing/DismissRequest;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "provide", "Lkntr/app/digital/preview/action/ActionModule;", "dismissRequest", "komponentScope", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReshapingActionModule_ProvideFactory create(Provider<DismissRequest> provider, Provider<KomponentScope<Unit>> provider2) {
            Intrinsics.checkNotNullParameter(provider, "dismissRequestProvider");
            Intrinsics.checkNotNullParameter(provider2, "komponentScopeProvider");
            return new ReshapingActionModule_ProvideFactory(provider, provider2);
        }

        @JvmStatic
        public final ActionModule<?> provide(DismissRequest dismissRequest, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return ReshapingActionModule.INSTANCE.provide(dismissRequest, komponentScope);
        }
    }

    @JvmStatic
    public static final ReshapingActionModule_ProvideFactory create(Provider<DismissRequest> provider, Provider<KomponentScope<Unit>> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final ActionModule<?> provide(DismissRequest dismissRequest, KomponentScope<? super Unit> komponentScope) {
        return Companion.provide(dismissRequest, komponentScope);
    }
}