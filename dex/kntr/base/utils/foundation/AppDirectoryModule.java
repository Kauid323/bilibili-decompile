package kntr.base.utils.foundation;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import kotlinx.io.files.PathsKt;

/* compiled from: AppDirectoryModule.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\n"}, d2 = {"Lkntr/base/utils/foundation/AppDirectoryModule;", "", "<init>", "()V", "appDataDirectory", "Lkotlinx/io/files/Path;", CommonProjectType.APP, "Landroid/app/Application;", "appCacheDirectory", "appDatabaseDirectory", "foundation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module
public final class AppDirectoryModule {
    public static final AppDirectoryModule INSTANCE = new AppDirectoryModule();

    private AppDirectoryModule() {
    }

    @Provides
    @AppDataDirectory
    public final Path appDataDirectory(Application app) {
        Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
        String path = app.getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return PathsJvmKt.Path(path);
    }

    @Provides
    @AppCacheDirectory
    public final Path appCacheDirectory(Application app) {
        Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
        String path = app.getCacheDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return PathsJvmKt.Path(path);
    }

    @Provides
    @AppDatabaseDirectory
    public final Path appDatabaseDirectory(Application app) {
        Path Path;
        Intrinsics.checkNotNullParameter(app, CommonProjectType.APP);
        String it = app.getDatabasePath("tmp").getParent();
        if (it == null || (Path = PathsJvmKt.Path(it)) == null) {
            String path = app.getFilesDir().getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            return PathsKt.Path(path, new String[]{"databases"});
        }
        return Path;
    }
}