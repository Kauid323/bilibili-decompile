package kntr.common.compose.launcher;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.common.router.GlobalInterceptor;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeContainer.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/common/compose/launcher/ComposableAsPageModule;", "", "<init>", "()V", "provide", "Lkntr/base/router/Interceptor;", CommonProjectType.APP, "Landroid/app/Application;", "compose-launcher_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module
public final class ComposableAsPageModule {
    public static final int $stable = 0;
    public static final ComposableAsPageModule INSTANCE = new ComposableAsPageModule();

    private ComposableAsPageModule() {
    }

    @Provides
    @GlobalInterceptor
    @IntoSet
    public final Interceptor provide(Application app) {
        Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
        return new ComposableAsPageModule$provide$1(app);
    }
}