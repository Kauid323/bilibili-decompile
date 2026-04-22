package kntr.app.digital.preview.lock;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LockStateService_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/lock/LockStateService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/lock/LockStateService;", "toggleLockCardProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/lock/ToggleLockCard;", "activityIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LockStateService_Factory implements Factory<LockStateService> {
    private final Provider<Integer> activityIdProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<Toaster> toasterProvider;
    private final Provider<ToggleLockCard> toggleLockCardProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public LockStateService_Factory(Provider<ToggleLockCard> provider, Provider<Integer> provider2, Provider<CoroutineScope> provider3, Provider<Toaster> provider4) {
        Intrinsics.checkNotNullParameter(provider, "toggleLockCardProvider");
        Intrinsics.checkNotNullParameter(provider2, "activityIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider4, "toasterProvider");
        this.toggleLockCardProvider = provider;
        this.activityIdProvider = provider2;
        this.coroutineScopeProvider = provider3;
        this.toasterProvider = provider4;
    }

    public LockStateService get() {
        Companion companion = Companion;
        ToggleLockCard toggleLockCard = this.toggleLockCardProvider.get();
        Intrinsics.checkNotNullExpressionValue(toggleLockCard, "get(...)");
        Integer num = this.activityIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        int intValue = num.intValue();
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        return companion.newInstance(toggleLockCard, intValue, coroutineScope, toaster);
    }

    /* compiled from: LockStateService_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/preview/lock/LockStateService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/lock/LockStateService_Factory;", "toggleLockCardProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/lock/ToggleLockCard;", "activityIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "toasterProvider", "Lkntr/common/trio/toast/Toaster;", "newInstance", "Lkntr/app/digital/preview/lock/LockStateService;", "toggleLockCard", "activityId", "coroutineScope", "toaster", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LockStateService_Factory create(Provider<ToggleLockCard> provider, Provider<Integer> provider2, Provider<CoroutineScope> provider3, Provider<Toaster> provider4) {
            Intrinsics.checkNotNullParameter(provider, "toggleLockCardProvider");
            Intrinsics.checkNotNullParameter(provider2, "activityIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider4, "toasterProvider");
            return new LockStateService_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final LockStateService newInstance(ToggleLockCard toggleLockCard, int activityId, CoroutineScope coroutineScope, Toaster toaster) {
            Intrinsics.checkNotNullParameter(toggleLockCard, "toggleLockCard");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            return new LockStateService(toggleLockCard, activityId, coroutineScope, toaster);
        }
    }

    @JvmStatic
    public static final LockStateService_Factory create(Provider<ToggleLockCard> provider, Provider<Integer> provider2, Provider<CoroutineScope> provider3, Provider<Toaster> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final LockStateService newInstance(ToggleLockCard toggleLockCard, int activityId, CoroutineScope coroutineScope, Toaster toaster) {
        return Companion.newInstance(toggleLockCard, activityId, coroutineScope, toaster);
    }
}