package kntr.app.digital.preview.viewmore;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ViewMoreActionModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/app/digital/preview/viewmore/ViewMoreActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "viewMoreService", "Lkntr/app/digital/preview/viewmore/DigitalViewMoreService;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ViewMoreActionModule {
    public static final int $stable = 0;
    public static final ViewMoreActionModule INSTANCE = new ViewMoreActionModule();

    private ViewMoreActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final DigitalViewMoreService viewMoreService) {
        Intrinsics.checkNotNullParameter(viewMoreService, "viewMoreService");
        return new ActionModule<ViewMoreAction>() { // from class: kntr.app.digital.preview.viewmore.ViewMoreActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<ViewMoreAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(ViewMoreAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<ViewMoreAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                if (DigitalViewMoreService.this.getViewMorePopupItems() == null) {
                    DigitalViewMoreService.this.markViewMorePopupItems(action.getData().getItems());
                } else {
                    DigitalViewMoreService.this.markViewMorePopupItems(null);
                }
            }
        };
    }
}