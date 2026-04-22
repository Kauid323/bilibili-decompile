package kntr.app.im.chat.sticker.db;

import androidx.room.RoomDatabase;
import kotlin.Metadata;

/* compiled from: StickerDatabaseBuilder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/sticker/db/StickerDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "stickerDao", "Lkntr/app/im/chat/sticker/db/StickerDao;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class StickerDatabase extends RoomDatabase {
    public static final int $stable = 8;

    public abstract StickerDao stickerDao();
}