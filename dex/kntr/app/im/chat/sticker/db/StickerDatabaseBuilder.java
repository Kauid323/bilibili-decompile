package kntr.app.im.chat.sticker.db;

import androidx.room.RoomDatabaseConstructor;
import kotlin.Metadata;

/* compiled from: StickerDatabaseBuilder.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/sticker/db/StickerDatabaseBuilder;", "Landroidx/room/RoomDatabaseConstructor;", "Lkntr/app/im/chat/sticker/db/StickerDatabase;", "<init>", "()V", "initialize", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StickerDatabaseBuilder implements RoomDatabaseConstructor<StickerDatabase> {
    public static final int $stable = 0;
    public static final StickerDatabaseBuilder INSTANCE = new StickerDatabaseBuilder();

    private StickerDatabaseBuilder() {
    }

    public StickerDatabase initialize() {
        return new StickerDatabase_Impl();
    }
}