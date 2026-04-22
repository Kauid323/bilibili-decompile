package kntr.base.utils.foundation;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.io.files.Path;

/* compiled from: AppDirectory.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/base/utils/foundation/AppDirEntrypoint;", "", "appDataDirectory", "Lkotlinx/io/files/Path;", "appCacheDirectory", "appDatabaseDirectory", "foundation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AppDirEntrypoint {
    @AppCacheDirectory
    Path appCacheDirectory();

    @AppDataDirectory
    Path appDataDirectory();

    @AppDatabaseDirectory
    Path appDatabaseDirectory();
}