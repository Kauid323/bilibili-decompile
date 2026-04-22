package kntr.app.digital.preview.usage;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ChangeAvatarActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00102\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0010BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeAvatarActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "usingLimitedDialogServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChangeAvatarActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<KomponentScope<Unit>> komponentScopeProvider;
    private final Provider<DigitalUsageRestrictionDialogService> usingLimitedDialogServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChangeAvatarActionModule_ProvideFactory(Provider<DigitalUsageRestrictionDialogService> provider, Provider<CoroutineScope> provider2, Provider<KomponentScope<Unit>> provider3, Provider<DigitalCardStateService> provider4) {
        Intrinsics.checkNotNullParameter(provider, "usingLimitedDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider3, "komponentScopeProvider");
        Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
        this.usingLimitedDialogServiceProvider = provider;
        this.coroutineScopeProvider = provider2;
        this.komponentScopeProvider = provider3;
        this.cardStateServiceProvider = provider4;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        DigitalUsageRestrictionDialogService digitalUsageRestrictionDialogService = this.usingLimitedDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalUsageRestrictionDialogService, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        KomponentScope<Unit> komponentScope = this.komponentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(komponentScope, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        return companion.provide(digitalUsageRestrictionDialogService, coroutineScope, komponentScope, digitalCardStateService);
    }

    /* compiled from: ChangeAvatarActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0007J2\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0007¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeAvatarActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/usage/ChangeAvatarActionModule_ProvideFactory;", "usingLimitedDialogServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "usingLimitedDialogService", "coroutineScope", "komponentScope", "cardStateService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChangeAvatarActionModule_ProvideFactory create(Provider<DigitalUsageRestrictionDialogService> provider, Provider<CoroutineScope> provider2, Provider<KomponentScope<Unit>> provider3, Provider<DigitalCardStateService> provider4) {
            Intrinsics.checkNotNullParameter(provider, "usingLimitedDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider3, "komponentScopeProvider");
            Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
            return new ChangeAvatarActionModule_ProvideFactory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final ActionModule<?> provide(DigitalUsageRestrictionDialogService usingLimitedDialogService, CoroutineScope coroutineScope, KomponentScope<? super Unit> komponentScope, DigitalCardStateService cardStateService) {
            Intrinsics.checkNotNullParameter(usingLimitedDialogService, "usingLimitedDialogService");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            return ChangeAvatarActionModule.INSTANCE.provide(usingLimitedDialogService, coroutineScope, komponentScope, cardStateService);
        }
    }

    @JvmStatic
    public static final ChangeAvatarActionModule_ProvideFactory create(Provider<DigitalUsageRestrictionDialogService> provider, Provider<CoroutineScope> provider2, Provider<KomponentScope<Unit>> provider3, Provider<DigitalCardStateService> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final ActionModule<?> provide(DigitalUsageRestrictionDialogService usingLimitedDialogService, CoroutineScope coroutineScope, KomponentScope<? super Unit> komponentScope, DigitalCardStateService cardStateService) {
        return Companion.provide(usingLimitedDialogService, coroutineScope, komponentScope, cardStateService);
    }
}