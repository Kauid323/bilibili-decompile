package kntr.app.im.chat.sticker.db;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.util.KClassUtil;
import kntr.base.utils.foundation.AppDatabaseDirectory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* compiled from: StickerDatabaseProvider.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"buildStickerDatabase", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "application", "Landroid/app/Application;", "databasePath", "Lkotlinx/io/files/Path;", "sticker_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickerDatabaseProvider_androidKt {
    public static final StickerDatabase buildStickerDatabase(Application application, @AppDatabaseDirectory Path databasePath) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(databasePath, "databasePath");
        Path dbFile = PathsKt.Path(databasePath, new String[]{"im_sticker.db"});
        Room room = Room.INSTANCE;
        Application context$iv = application;
        String name$iv = dbFile.toString();
        Function0 factory$iv = new Function0<StickerDatabase>() { // from class: kntr.app.im.chat.sticker.db.StickerDatabaseProvider_androidKt$buildStickerDatabase$$inlined$databaseBuilder$default$1
            /* JADX WARN: Type inference failed for: r0v2, types: [androidx.room.RoomDatabase, kntr.app.im.chat.sticker.db.StickerDatabase] */
            /* renamed from: invoke */
            public final StickerDatabase m1657invoke() {
                return (RoomDatabase) KClassUtil.findAndInstantiateDatabaseImpl$default(StickerDatabase.class, (String) null, 2, (Object) null);
            }
        };
        if (StringsKt.isBlank(name$iv)) {
            throw new IllegalArgumentException("Cannot build a database with empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().".toString());
        }
        if (!Intrinsics.areEqual(name$iv, ":memory:")) {
            return (StickerDatabase) new RoomDatabase.Builder(Reflection.getOrCreateKotlinClass(StickerDatabase.class), name$iv, factory$iv, context$iv).build();
        }
        throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder().".toString());
    }
}