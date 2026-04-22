package kntr.app.digital.preview.gift;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.ActivityId;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: GiftActionModule.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006\u0014"}, d2 = {"Lkntr/app/digital/preview/gift/GiftActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "activityId", RoomRecommendViewModel.EMPTY_CURSOR, "requestGiftInfo", "Lkntr/app/digital/preview/gift/RequestGiftInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "toaster", "Lkntr/common/trio/toast/Toaster;", "router", "Lkntr/base/router/Router;", "giftErrorDialogService", "Lkntr/app/digital/preview/gift/DigitalGiftErrorDialogService;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class GiftActionModule {
    public static final int $stable = 0;
    public static final GiftActionModule INSTANCE = new GiftActionModule();

    private GiftActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(@ActivityId final int activityId, final RequestGiftInfo requestGiftInfo, @BusinessCoroutineScope final CoroutineScope coroutineScope, final DigitalCardStateService cardStateService, final Toaster toaster, final Router router, final DigitalGiftErrorDialogService giftErrorDialogService) {
        Intrinsics.checkNotNullParameter(requestGiftInfo, "requestGiftInfo");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(giftErrorDialogService, "giftErrorDialogService");
        return new ActionModule<GiftAction>() { // from class: kntr.app.digital.preview.gift.GiftActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<GiftAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(GiftAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<GiftAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new GiftActionModule$provide$1$1(requestGiftInfo, activityId, cardStateService, router, coroutineScope, giftErrorDialogService, toaster, null), 3, (Object) null);
            }
        };
    }
}