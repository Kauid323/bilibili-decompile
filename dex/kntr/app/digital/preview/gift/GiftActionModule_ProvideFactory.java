package kntr.app.digital.preview.gift;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GiftActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00152\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u0015Bi\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/digital/preview/gift/GiftActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "activityIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "requestGiftInfoProvider", "Lkntr/app/digital/preview/gift/RequestGiftInfo;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "routerProvider", "Lkntr/base/router/Router;", "giftErrorDialogServiceProvider", "Lkntr/app/digital/preview/gift/DigitalGiftErrorDialogService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GiftActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<Integer> activityIdProvider;
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<DigitalGiftErrorDialogService> giftErrorDialogServiceProvider;
    private final Provider<RequestGiftInfo> requestGiftInfoProvider;
    private final Provider<Router> routerProvider;
    private final Provider<Toaster> toasterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public GiftActionModule_ProvideFactory(Provider<Integer> provider, Provider<RequestGiftInfo> provider2, Provider<CoroutineScope> provider3, Provider<DigitalCardStateService> provider4, Provider<Toaster> provider5, Provider<Router> provider6, Provider<DigitalGiftErrorDialogService> provider7) {
        Intrinsics.checkNotNullParameter(provider, "activityIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "requestGiftInfoProvider");
        Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "toasterProvider");
        Intrinsics.checkNotNullParameter(provider6, "routerProvider");
        Intrinsics.checkNotNullParameter(provider7, "giftErrorDialogServiceProvider");
        this.activityIdProvider = provider;
        this.requestGiftInfoProvider = provider2;
        this.coroutineScopeProvider = provider3;
        this.cardStateServiceProvider = provider4;
        this.toasterProvider = provider5;
        this.routerProvider = provider6;
        this.giftErrorDialogServiceProvider = provider7;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        Integer num = this.activityIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        int intValue = num.intValue();
        RequestGiftInfo requestGiftInfo = this.requestGiftInfoProvider.get();
        Intrinsics.checkNotNullExpressionValue(requestGiftInfo, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        Router router = this.routerProvider.get();
        Intrinsics.checkNotNullExpressionValue(router, "get(...)");
        DigitalGiftErrorDialogService digitalGiftErrorDialogService = this.giftErrorDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalGiftErrorDialogService, "get(...)");
        return companion.provide(intValue, requestGiftInfo, coroutineScope, digitalCardStateService, toaster, router, digitalGiftErrorDialogService);
    }

    /* compiled from: GiftActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0007JD\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0014H\u0007¨\u0006\u001e"}, d2 = {"Lkntr/app/digital/preview/gift/GiftActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/gift/GiftActionModule_ProvideFactory;", "activityIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "requestGiftInfoProvider", "Lkntr/app/digital/preview/gift/RequestGiftInfo;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "routerProvider", "Lkntr/base/router/Router;", "giftErrorDialogServiceProvider", "Lkntr/app/digital/preview/gift/DigitalGiftErrorDialogService;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "activityId", "requestGiftInfo", "coroutineScope", "cardStateService", "toaster", "router", "giftErrorDialogService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GiftActionModule_ProvideFactory create(Provider<Integer> provider, Provider<RequestGiftInfo> provider2, Provider<CoroutineScope> provider3, Provider<DigitalCardStateService> provider4, Provider<Toaster> provider5, Provider<Router> provider6, Provider<DigitalGiftErrorDialogService> provider7) {
            Intrinsics.checkNotNullParameter(provider, "activityIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "requestGiftInfoProvider");
            Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "toasterProvider");
            Intrinsics.checkNotNullParameter(provider6, "routerProvider");
            Intrinsics.checkNotNullParameter(provider7, "giftErrorDialogServiceProvider");
            return new GiftActionModule_ProvideFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        }

        @JvmStatic
        public final ActionModule<?> provide(int activityId, RequestGiftInfo requestGiftInfo, CoroutineScope coroutineScope, DigitalCardStateService cardStateService, Toaster toaster, Router router, DigitalGiftErrorDialogService giftErrorDialogService) {
            Intrinsics.checkNotNullParameter(requestGiftInfo, "requestGiftInfo");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            Intrinsics.checkNotNullParameter(router, "router");
            Intrinsics.checkNotNullParameter(giftErrorDialogService, "giftErrorDialogService");
            return GiftActionModule.INSTANCE.provide(activityId, requestGiftInfo, coroutineScope, cardStateService, toaster, router, giftErrorDialogService);
        }
    }

    @JvmStatic
    public static final GiftActionModule_ProvideFactory create(Provider<Integer> provider, Provider<RequestGiftInfo> provider2, Provider<CoroutineScope> provider3, Provider<DigitalCardStateService> provider4, Provider<Toaster> provider5, Provider<Router> provider6, Provider<DigitalGiftErrorDialogService> provider7) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @JvmStatic
    public static final ActionModule<?> provide(int activityId, RequestGiftInfo requestGiftInfo, CoroutineScope coroutineScope, DigitalCardStateService cardStateService, Toaster toaster, Router router, DigitalGiftErrorDialogService giftErrorDialogService) {
        return Companion.provide(activityId, requestGiftInfo, coroutineScope, cardStateService, toaster, router, giftErrorDialogService);
    }
}