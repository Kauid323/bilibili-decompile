package kntr.app.digital.backpack.aggregate;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.backpack.aggregate.BackpackPageComponent;
import kntr.app.digital.backpack.dismiss.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackpackPageComponent_Impl_ProvideDismissRequestFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackPageComponent_Impl_ProvideDismissRequestFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/dismiss/DismissRequest;", "komponentScopeProvider", "Ljavax/inject/Provider;", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BackpackPageComponent_Impl_ProvideDismissRequestFactory implements Factory<DismissRequest> {
    private final Provider<KomponentScope<Unit>> komponentScopeProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BackpackPageComponent_Impl_ProvideDismissRequestFactory(Provider<KomponentScope<Unit>> provider) {
        Intrinsics.checkNotNullParameter(provider, "komponentScopeProvider");
        this.komponentScopeProvider = provider;
    }

    public DismissRequest get() {
        Companion companion = Companion;
        KomponentScope<Unit> komponentScope = this.komponentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(komponentScope, "get(...)");
        return companion.provideDismissRequest(komponentScope);
    }

    /* compiled from: BackpackPageComponent_Impl_ProvideDismissRequestFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackPageComponent_Impl_ProvideDismissRequestFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent_Impl_ProvideDismissRequestFactory;", "komponentScopeProvider", "Ljavax/inject/Provider;", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "provideDismissRequest", "Lkntr/app/digital/backpack/dismiss/DismissRequest;", "komponentScope", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BackpackPageComponent_Impl_ProvideDismissRequestFactory create(Provider<KomponentScope<Unit>> provider) {
            Intrinsics.checkNotNullParameter(provider, "komponentScopeProvider");
            return new BackpackPageComponent_Impl_ProvideDismissRequestFactory(provider);
        }

        @JvmStatic
        public final DismissRequest provideDismissRequest(KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return BackpackPageComponent.Impl.INSTANCE.provideDismissRequest(komponentScope);
        }
    }

    @JvmStatic
    public static final BackpackPageComponent_Impl_ProvideDismissRequestFactory create(Provider<KomponentScope<Unit>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final DismissRequest provideDismissRequest(KomponentScope<? super Unit> komponentScope) {
        return Companion.provideDismissRequest(komponentScope);
    }
}