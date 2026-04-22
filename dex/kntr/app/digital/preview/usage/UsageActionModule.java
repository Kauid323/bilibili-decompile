package kntr.app.digital.preview.usage;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: UsageActionModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/usage/UsageActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "usingMenuDialogService", "Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService;", "toaster", "Lkntr/common/trio/toast/Toaster;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class UsageActionModule {
    public static final int $stable = 0;
    public static final UsageActionModule INSTANCE = new UsageActionModule();

    private UsageActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(@BusinessCoroutineScope final CoroutineScope coroutineScope, final DigitalUsageMenuDialogService usingMenuDialogService, final Toaster toaster) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(usingMenuDialogService, "usingMenuDialogService");
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        return new ActionModule<UsageAction>() { // from class: kntr.app.digital.preview.usage.UsageActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<UsageAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(UsageAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<UsageAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                String toast = action.getData().getToast();
                String str = toast;
                if (!(str == null || StringsKt.isBlank(str))) {
                    Toaster.-CC.showToast$default(toaster, toast, (ToastDuration) null, 2, (Object) null);
                } else {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UsageActionModule$provide$1$1(usingMenuDialogService, null), 3, (Object) null);
                }
            }
        };
    }
}