package kntr.app.digital.preview.wallpaper;

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

/* compiled from: WallpaperActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00102\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0010BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "wallpaperDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WallpaperActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<KomponentScope<Unit>> komponentScopeProvider;
    private final Provider<WallpaperSettingsDialogService> wallpaperDialogServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public WallpaperActionModule_ProvideFactory(Provider<CoroutineScope> provider, Provider<WallpaperSettingsDialogService> provider2, Provider<DigitalCardStateService> provider3, Provider<KomponentScope<Unit>> provider4) {
        Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "wallpaperDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "komponentScopeProvider");
        this.coroutineScopeProvider = provider;
        this.wallpaperDialogServiceProvider = provider2;
        this.cardStateServiceProvider = provider3;
        this.komponentScopeProvider = provider4;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        WallpaperSettingsDialogService wallpaperSettingsDialogService = this.wallpaperDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(wallpaperSettingsDialogService, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        KomponentScope<Unit> komponentScope = this.komponentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(komponentScope, "get(...)");
        return companion.provide(coroutineScope, wallpaperSettingsDialogService, digitalCardStateService, komponentScope);
    }

    /* compiled from: WallpaperActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007H\u0007J2\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/preview/wallpaper/WallpaperActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/wallpaper/WallpaperActionModule_ProvideFactory;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "wallpaperDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "komponentScopeProvider", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "provide", "Lkntr/app/digital/preview/action/ActionModule;", "coroutineScope", "wallpaperDialogService", "cardStateService", "komponentScope", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WallpaperActionModule_ProvideFactory create(Provider<CoroutineScope> provider, Provider<WallpaperSettingsDialogService> provider2, Provider<DigitalCardStateService> provider3, Provider<KomponentScope<Unit>> provider4) {
            Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "wallpaperDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "komponentScopeProvider");
            return new WallpaperActionModule_ProvideFactory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final ActionModule<?> provide(CoroutineScope coroutineScope, WallpaperSettingsDialogService wallpaperDialogService, DigitalCardStateService cardStateService, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(wallpaperDialogService, "wallpaperDialogService");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return WallpaperActionModule.INSTANCE.provide(coroutineScope, wallpaperDialogService, cardStateService, komponentScope);
        }
    }

    @JvmStatic
    public static final WallpaperActionModule_ProvideFactory create(Provider<CoroutineScope> provider, Provider<WallpaperSettingsDialogService> provider2, Provider<DigitalCardStateService> provider3, Provider<KomponentScope<Unit>> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final ActionModule<?> provide(CoroutineScope coroutineScope, WallpaperSettingsDialogService wallpaperDialogService, DigitalCardStateService cardStateService, KomponentScope<? super Unit> komponentScope) {
        return Companion.provide(coroutineScope, wallpaperDialogService, cardStateService, komponentScope);
    }
}