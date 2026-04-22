package kntr.common.compose.launcher;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposableAsPageModule_ProvideFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/common/compose/launcher/ComposableAsPageModule_ProvideFactory;", "Ldagger/internal/Factory;", "Lkntr/base/router/Interceptor;", "appProvider", "Ljavax/inject/Provider;", "Landroid/app/Application;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "compose-launcher_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableAsPageModule_ProvideFactory implements Factory<Interceptor> {
    private final Provider<Application> appProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ComposableAsPageModule_ProvideFactory(Provider<Application> provider) {
        Intrinsics.checkNotNullParameter(provider, "appProvider");
        this.appProvider = provider;
    }

    public Interceptor get() {
        Companion companion = Companion;
        Object obj = this.appProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.provide((Application) obj);
    }

    /* compiled from: ComposableAsPageModule_ProvideFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/common/compose/launcher/ComposableAsPageModule_ProvideFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/compose/launcher/ComposableAsPageModule_ProvideFactory;", "appProvider", "Ljavax/inject/Provider;", "Landroid/app/Application;", "provide", "Lkntr/base/router/Interceptor;", CommonProjectType.APP, "compose-launcher_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ComposableAsPageModule_ProvideFactory create(Provider<Application> provider) {
            Intrinsics.checkNotNullParameter(provider, "appProvider");
            return new ComposableAsPageModule_ProvideFactory(provider);
        }

        @JvmStatic
        public final Interceptor provide(Application app) {
            Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
            return ComposableAsPageModule.INSTANCE.provide(app);
        }
    }

    @JvmStatic
    public static final ComposableAsPageModule_ProvideFactory create(Provider<Application> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final Interceptor provide(Application app) {
        return Companion.provide(app);
    }
}