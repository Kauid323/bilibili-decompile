package kntr.app.digital.preview.reshaping;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ReshapingAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/preview/reshaping/ReshapingActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "dismissRequest", "Lkntr/app/digital/preview/closing/DismissRequest;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ReshapingActionModule {
    public static final int $stable = 0;
    public static final ReshapingActionModule INSTANCE = new ReshapingActionModule();

    private ReshapingActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final DismissRequest dismissRequest, final KomponentScope<? super Unit> komponentScope) {
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
        return new ActionModule<ReshapingAction>() { // from class: kntr.app.digital.preview.reshaping.ReshapingActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<ReshapingAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(ReshapingAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<ReshapingAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                Reshape reshape = Reshape_androidKt.getReshape();
                KomponentScope<? super Unit> komponentScope2 = komponentScope;
                String link = action.getData().getLink();
                final DismissRequest dismissRequest2 = dismissRequest;
                reshape.invoke(komponentScope2, link, new Function0<Unit>() { // from class: kntr.app.digital.preview.reshaping.ReshapingActionModule$provide$1$1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m984invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m984invoke() {
                        DismissRequest.this.invoke();
                    }
                });
            }
        };
    }
}