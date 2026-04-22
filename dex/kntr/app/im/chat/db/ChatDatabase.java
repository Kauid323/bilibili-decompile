package kntr.app.im.chat.db;

import androidx.room.RoomDatabase;
import kntr.app.im.chat.db.combinedDao.DeletingDao;
import kntr.app.im.chat.db.dao.ChatInfoDao;
import kntr.app.im.chat.db.dao.DraftDao;
import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.dao.PushInfoMessageDao;
import kntr.app.im.chat.db.dao.RangeDao;
import kntr.app.im.chat.db.dao.SessionIdDao;
import kntr.app.im.chat.db.dao.SessionMessageDao;
import kotlin.Metadata;

/* compiled from: DatabaseBuilder.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/db/ChatDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "chatInfoDao", "Lkntr/app/im/chat/db/dao/ChatInfoDao;", "messageDao", "Lkntr/app/im/chat/db/dao/MessageDao;", "rangeDao", "Lkntr/app/im/chat/db/dao/RangeDao;", "sessionIdDao", "Lkntr/app/im/chat/db/dao/SessionIdDao;", "sessionMessageDao", "Lkntr/app/im/chat/db/dao/SessionMessageDao;", "draftDao", "Lkntr/app/im/chat/db/dao/DraftDao;", "deletingDao", "Lkntr/app/im/chat/db/combinedDao/DeletingDao;", "pushInfoDao", "Lkntr/app/im/chat/db/dao/PushInfoMessageDao;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ChatDatabase extends RoomDatabase {
    public abstract ChatInfoDao chatInfoDao();

    public abstract DeletingDao deletingDao();

    public abstract DraftDao draftDao();

    public abstract MessageDao messageDao();

    public abstract PushInfoMessageDao pushInfoDao();

    public abstract RangeDao rangeDao();

    public abstract SessionIdDao sessionIdDao();

    public abstract SessionMessageDao sessionMessageDao();
}