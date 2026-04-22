package video.biz.offline.base.model.db;

import android.app.Application;
import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.util.KClassUtil;
import java.io.File;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineDatabase.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getDatabaseBuilder", "Landroidx/room/RoomDatabase$Builder;", "Lvideo/biz/offline/base/model/db/AppDatabase;", "deleteDB", "", "model_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDatabase_androidKt {
    public static final RoomDatabase.Builder<AppDatabase> getDatabaseBuilder() {
        if (!(Gripper_component_holder_androidKt.getRootGripperComponent() instanceof Application)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Object rootGripperComponent = Gripper_component_holder_androidKt.getRootGripperComponent();
        Intrinsics.checkNotNull(rootGripperComponent, "null cannot be cast to non-null type android.app.Application");
        Context appContext = ((Application) rootGripperComponent).getApplicationContext();
        File dbFile = appContext.getDatabasePath(OfflineDatabaseKt.DB_FILE);
        Room room = Room.INSTANCE;
        Intrinsics.checkNotNull(appContext);
        String name$iv = dbFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(name$iv, "getAbsolutePath(...)");
        Function0 factory$iv = new Function0<AppDatabase>() { // from class: video.biz.offline.base.model.db.OfflineDatabase_androidKt$getDatabaseBuilder$$inlined$databaseBuilder$default$1
            /* JADX WARN: Type inference failed for: r0v2, types: [androidx.room.RoomDatabase, video.biz.offline.base.model.db.AppDatabase] */
            /* renamed from: invoke */
            public final AppDatabase m2765invoke() {
                return (RoomDatabase) KClassUtil.findAndInstantiateDatabaseImpl$default(AppDatabase.class, (String) null, 2, (Object) null);
            }
        };
        if (StringsKt.isBlank(name$iv)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().".toString());
        }
        if (Intrinsics.areEqual(name$iv, ":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().".toString());
        }
        return new RoomDatabase.Builder<>(Reflection.getOrCreateKotlinClass(AppDatabase.class), name$iv, factory$iv, appContext);
    }

    public static final void deleteDB() {
        Object rootGripperComponent = Gripper_component_holder_androidKt.getRootGripperComponent();
        Intrinsics.checkNotNull(rootGripperComponent, "null cannot be cast to non-null type android.app.Application");
        Context appContext = ((Application) rootGripperComponent).getApplicationContext();
        appContext.deleteDatabase(OfflineDatabaseKt.DB_FILE);
    }
}