package kntr.app.digital.preview.toast;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToastActionModule_ProvideFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \t2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/toast/ToastActionModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/action/ActionModule;", "toasterProvider", "Ljavax/inject/Provider;", "Lkntr/common/trio/toast/Toaster;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ToastActionModule_ProvideFactory implements Factory<ActionModule<?>> {
    private final Provider<Toaster> toasterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ToastActionModule_ProvideFactory(Provider<Toaster> provider) {
        Intrinsics.checkNotNullParameter(provider, "toasterProvider");
        this.toasterProvider = provider;
    }

    public ActionModule<?> get() {
        Companion companion = Companion;
        Toaster toaster = this.toasterProvider.get();
        Intrinsics.checkNotNullExpressionValue(toaster, "get(...)");
        return companion.provide(toaster);
    }

    /* compiled from: ToastActionModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0014\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/toast/ToastActionModule_ProvideFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/toast/ToastActionModule_ProvideFactory;", "toasterProvider", "Ljavax/inject/Provider;", "Lkntr/common/trio/toast/Toaster;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "toaster", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ToastActionModule_ProvideFactory create(Provider<Toaster> provider) {
            Intrinsics.checkNotNullParameter(provider, "toasterProvider");
            return new ToastActionModule_ProvideFactory(provider);
        }

        @JvmStatic
        public final ActionModule<?> provide(Toaster toaster) {
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            return ToastActionModule.INSTANCE.provide(toaster);
        }
    }

    @JvmStatic
    public static final ToastActionModule_ProvideFactory create(Provider<Toaster> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final ActionModule<?> provide(Toaster toaster) {
        return Companion.provide(toaster);
    }
}