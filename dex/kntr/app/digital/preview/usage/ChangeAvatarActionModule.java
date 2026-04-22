package kntr.app.digital.preview.usage;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ChangeAvatarActionModule.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/digital/preview/usage/ChangeAvatarActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "usingLimitedDialogService", "Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChangeAvatarActionModule {
    public static final int $stable = 0;
    public static final ChangeAvatarActionModule INSTANCE = new ChangeAvatarActionModule();

    private ChangeAvatarActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final DigitalUsageRestrictionDialogService usingLimitedDialogService, @BusinessCoroutineScope final CoroutineScope coroutineScope, final KomponentScope<? super Unit> komponentScope, final DigitalCardStateService cardStateService) {
        Intrinsics.checkNotNullParameter(usingLimitedDialogService, "usingLimitedDialogService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        return new ActionModule<ChangeAvatarAction>() { // from class: kntr.app.digital.preview.usage.ChangeAvatarActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<ChangeAvatarAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(ChangeAvatarAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<ChangeAvatarAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChangeAvatarActionModule$provide$1$1(cardStateService, action, usingLimitedDialogService, komponentScope, null), 3, (Object) null);
            }
        };
    }
}