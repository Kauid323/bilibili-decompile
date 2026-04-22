package video.biz.offline.base.model.db;

import androidx.room.RoomDatabaseConstructor;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AppDatabaseConstructor.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lvideo/biz/offline/base/model/db/AppDatabaseConstructor;", "Landroidx/room/RoomDatabaseConstructor;", "Lvideo/biz/offline/base/model/db/AppDatabase;", "<init>", "()V", "initialize", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AppDatabaseConstructor implements RoomDatabaseConstructor<AppDatabase> {
    public static final int $stable = 0;
    public static final AppDatabaseConstructor INSTANCE = new AppDatabaseConstructor();

    private AppDatabaseConstructor() {
    }

    public AppDatabase initialize() {
        return new AppDatabase_Impl();
    }
}