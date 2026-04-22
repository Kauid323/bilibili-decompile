package kntr.app.digital.preview.share;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.DialogService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ShareDialogService_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/preview/share/ShareDialogService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/share/ShareDialogService;", "toasterProvider", "Ljavax/inject/Provider;", "Lkntr/common/trio/toast/Toaster;", "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShareDialogService_Factory implements Factory<ShareDialogService> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<DialogService> dialogServiceProvider;
    private final Provider<Toaster> toasterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ShareDialogService_Factory(Provider<Toaster> provider, Provider<DialogService> provider2, Provider<CoroutineScope> provider3) {
        Intrinsics.checkNotNullParameter(provider, "toasterProvider");
        Intrinsics.checkNotNullParameter(provider2, "dialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
        this.toasterProvider = provider;
        this.dialogServiceProvider = provider2;
        this.coroutineScopeProvider = provider3;
    }

    public ShareDialogService get() {
        Companion companion = Companion;
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        DialogService dialogService = this.dialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(dialogService, "get(...)");
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        return companion.newInstance(toaster, dialogService, coroutineScope);
    }

    /* compiled from: ShareDialogService_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/share/ShareDialogService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/share/ShareDialogService_Factory;", "toasterProvider", "Ljavax/inject/Provider;", "Lkntr/common/trio/toast/Toaster;", "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "newInstance", "Lkntr/app/digital/preview/share/ShareDialogService;", "toaster", "dialogService", "coroutineScope", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShareDialogService_Factory create(Provider<Toaster> provider, Provider<DialogService> provider2, Provider<CoroutineScope> provider3) {
            Intrinsics.checkNotNullParameter(provider, "toasterProvider");
            Intrinsics.checkNotNullParameter(provider2, "dialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
            return new ShareDialogService_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ShareDialogService newInstance(Toaster toaster, DialogService dialogService, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            Intrinsics.checkNotNullParameter(dialogService, "dialogService");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            return new ShareDialogService(toaster, dialogService, coroutineScope);
        }
    }

    @JvmStatic
    public static final ShareDialogService_Factory create(Provider<Toaster> provider, Provider<DialogService> provider2, Provider<CoroutineScope> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ShareDialogService newInstance(Toaster toaster, DialogService dialogService, CoroutineScope coroutineScope) {
        return Companion.newInstance(toaster, dialogService, coroutineScope);
    }
}