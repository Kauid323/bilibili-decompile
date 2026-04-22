package kntr.app.digital.preview.share;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.card.video.DigitalVideoPlayService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ShareActionModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/share/ShareActionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "videoPlayService", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", "shareDialogService", "Lkntr/app/digital/preview/share/ShareDialogService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ShareActionModule {
    public static final int $stable = 0;
    public static final ShareActionModule INSTANCE = new ShareActionModule();

    private ShareActionModule() {
    }

    @Provides
    @IntoSet
    public final ActionModule<?> provide(final DigitalVideoPlayService videoPlayService, final ShareDialogService shareDialogService, @BusinessCoroutineScope final CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(videoPlayService, "videoPlayService");
        Intrinsics.checkNotNullParameter(shareDialogService, "shareDialogService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return new ActionModule<ShareAction>() { // from class: kntr.app.digital.preview.share.ShareActionModule$provide$$inlined$ActionModule$1
            @Override // kntr.app.digital.preview.action.ActionModule
            public KClass<ShareAction> getActionType() {
                return Reflection.getOrCreateKotlinClass(ShareAction.class);
            }

            @Override // kntr.app.digital.preview.action.ActionModule
            public void run(Action<ShareAction> action) {
                Intrinsics.checkNotNullParameter(action, "<this>");
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ShareActionModule$provide$1$1(videoPlayService, shareDialogService, action, null), 3, (Object) null);
            }
        };
    }
}