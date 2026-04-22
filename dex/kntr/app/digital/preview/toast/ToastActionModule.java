package kntr.app.digital.preview.toast;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: ToastActionModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/app/digital/preview/toast/ToastActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "toaster", "Lkntr/common/trio/toast/Toaster;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ToastActionModule {
    public static final int $stable = 0;
    public static final ToastActionModule INSTANCE = new ToastActionModule();

    private ToastActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final Toaster toaster) {
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        return new ActionModule<ToastAction>() { // from class: kntr.app.digital.preview.toast.ToastActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<ToastAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(ToastAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<ToastAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                if (!StringsKt.isBlank(action.getData().getToast())) {
                    Toaster.-CC.showToast$default(toaster, action.getData().getToast(), (ToastDuration) null, 2, (Object) null);
                }
            }
        };
    }
}