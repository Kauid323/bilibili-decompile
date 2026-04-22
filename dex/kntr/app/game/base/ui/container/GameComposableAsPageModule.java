package kntr.app.game.base.ui.container;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Interceptor;
import kntr.common.router.GlobalInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameComposeContainer.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/app/game/base/ui/container/GameComposableAsPageModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provide", "Lkntr/base/router/Interceptor;", "app", "Landroid/app/Application;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class GameComposableAsPageModule {
    public static final int $stable = 0;
    public static final GameComposableAsPageModule INSTANCE = new GameComposableAsPageModule();

    private GameComposableAsPageModule() {
    }

    @Provides
    @GlobalInterceptor
    @IntoSet
    public final Interceptor provide(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        return new GameComposableAsPageModule$provide$1(app);
    }
}