package kntr.base.utils.foundation;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.io.files.Path;

/* compiled from: AppDirectory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lkntr/base/utils/foundation/AppDirectory;", "", "<init>", "()V", "entrypoint", "Lkntr/base/utils/foundation/AppDirEntrypoint;", "dataDirectory", "Lkotlinx/io/files/Path;", "getDataDirectory", "()Lkotlinx/io/files/Path;", "cacheDirectory", "getCacheDirectory", "databaseDirectory", "getDatabaseDirectory", "foundation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AppDirectory {
    public static final AppDirectory INSTANCE = new AppDirectory();
    private static final AppDirEntrypoint entrypoint;

    private AppDirectory() {
    }

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        entrypoint = (AppDirEntrypoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AppDirEntrypoint.class));
    }

    public final Path getDataDirectory() {
        return entrypoint.appDataDirectory();
    }

    public final Path getCacheDirectory() {
        return entrypoint.appCacheDirectory();
    }

    public final Path getDatabaseDirectory() {
        return entrypoint.appDatabaseDirectory();
    }
}