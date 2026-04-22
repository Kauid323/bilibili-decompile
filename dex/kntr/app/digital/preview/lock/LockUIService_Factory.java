package kntr.app.digital.preview.lock;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LockUIService_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/lock/LockUIService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/lock/LockUIService;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "unlockCardDialogServiceProvider", "Lkntr/app/digital/preview/lock/UnlockCardDialogService;", "lockStateServiceProvider", "Lkntr/app/digital/preview/lock/LockStateService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LockUIService_Factory implements Factory<LockUIService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<LockStateService> lockStateServiceProvider;
    private final Provider<UnlockCardDialogService> unlockCardDialogServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public LockUIService_Factory(Provider<CoroutineScope> provider, Provider<UnlockCardDialogService> provider2, Provider<LockStateService> provider3, Provider<DigitalCardStateService> provider4) {
        Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "unlockCardDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "lockStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
        this.coroutineScopeProvider = provider;
        this.unlockCardDialogServiceProvider = provider2;
        this.lockStateServiceProvider = provider3;
        this.cardStateServiceProvider = provider4;
    }

    public LockUIService get() {
        Companion companion = Companion;
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        UnlockCardDialogService unlockCardDialogService = this.unlockCardDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(unlockCardDialogService, "get(...)");
        LockStateService lockStateService = this.lockStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(lockStateService, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        return companion.newInstance(coroutineScope, unlockCardDialogService, lockStateService, digitalCardStateService);
    }

    /* compiled from: LockUIService_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/preview/lock/LockUIService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/lock/LockUIService_Factory;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "unlockCardDialogServiceProvider", "Lkntr/app/digital/preview/lock/UnlockCardDialogService;", "lockStateServiceProvider", "Lkntr/app/digital/preview/lock/LockStateService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "newInstance", "Lkntr/app/digital/preview/lock/LockUIService;", "coroutineScope", "unlockCardDialogService", "lockStateService", "cardStateService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LockUIService_Factory create(Provider<CoroutineScope> provider, Provider<UnlockCardDialogService> provider2, Provider<LockStateService> provider3, Provider<DigitalCardStateService> provider4) {
            Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "unlockCardDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "lockStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
            return new LockUIService_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final LockUIService newInstance(CoroutineScope coroutineScope, UnlockCardDialogService unlockCardDialogService, LockStateService lockStateService, DigitalCardStateService cardStateService) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(unlockCardDialogService, "unlockCardDialogService");
            Intrinsics.checkNotNullParameter(lockStateService, "lockStateService");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            return new LockUIService(coroutineScope, unlockCardDialogService, lockStateService, cardStateService);
        }
    }

    @JvmStatic
    public static final LockUIService_Factory create(Provider<CoroutineScope> provider, Provider<UnlockCardDialogService> provider2, Provider<LockStateService> provider3, Provider<DigitalCardStateService> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final LockUIService newInstance(CoroutineScope coroutineScope, UnlockCardDialogService unlockCardDialogService, LockStateService lockStateService, DigitalCardStateService cardStateService) {
        return Companion.newInstance(coroutineScope, unlockCardDialogService, lockStateService, cardStateService);
    }
}