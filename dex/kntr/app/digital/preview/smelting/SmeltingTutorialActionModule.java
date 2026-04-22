package kntr.app.digital.preview.smelting;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: SmeltingTutorialAction.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/app/digital/preview/smelting/SmeltingTutorialActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "router", "Lkntr/base/router/Router;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class SmeltingTutorialActionModule {
    public static final int $stable = 0;
    public static final SmeltingTutorialActionModule INSTANCE = new SmeltingTutorialActionModule();

    private SmeltingTutorialActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        return new ActionModule<SmeltingTutorialAction>() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<SmeltingTutorialAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(SmeltingTutorialAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<SmeltingTutorialAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                router.launch(UrisKt.toUri(action.getData().getLink()));
            }
        };
    }
}