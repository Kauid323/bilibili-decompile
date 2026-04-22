package kntr.base.utils.foundation;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;

/* compiled from: AppDirectoryModule_AppDatabaseDirectoryFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/base/utils/foundation/AppDirectoryModule_AppDatabaseDirectoryFactory;", "Ldagger/internal/Factory;", "Lkotlinx/io/files/Path;", "appProvider", "Ljavax/inject/Provider;", "Landroid/app/Application;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "foundation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AppDirectoryModule_AppDatabaseDirectoryFactory implements Factory<Path> {
    public static final Companion Companion = new Companion(null);
    private final Provider<Application> appProvider;

    public AppDirectoryModule_AppDatabaseDirectoryFactory(Provider<Application> provider) {
        Intrinsics.checkNotNullParameter(provider, "appProvider");
        this.appProvider = provider;
    }

    public Path get() {
        Companion companion = Companion;
        Object obj = this.appProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.appDatabaseDirectory((Application) obj);
    }

    /* compiled from: AppDirectoryModule_AppDatabaseDirectoryFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/base/utils/foundation/AppDirectoryModule_AppDatabaseDirectoryFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/base/utils/foundation/AppDirectoryModule_AppDatabaseDirectoryFactory;", "appProvider", "Ljavax/inject/Provider;", "Landroid/app/Application;", "appDatabaseDirectory", "Lkotlinx/io/files/Path;", CommonProjectType.APP, "foundation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AppDirectoryModule_AppDatabaseDirectoryFactory create(Provider<Application> provider) {
            Intrinsics.checkNotNullParameter(provider, "appProvider");
            return new AppDirectoryModule_AppDatabaseDirectoryFactory(provider);
        }

        @JvmStatic
        public final Path appDatabaseDirectory(Application app) {
            Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
            return AppDirectoryModule.INSTANCE.appDatabaseDirectory(app);
        }
    }

    @JvmStatic
    public static final AppDirectoryModule_AppDatabaseDirectoryFactory create(Provider<Application> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final Path appDatabaseDirectory(Application app) {
        return Companion.appDatabaseDirectory(app);
    }
}