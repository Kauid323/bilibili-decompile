package kntr.app.im.chat.db.dao;

import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.converter.InstantConverter;
import kntr.app.im.chat.db.dao.SessionMessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Instant;

/* compiled from: SessionMessageDao_Impl.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JD\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0013JL\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/im/chat/db/dao/SessionMessageDao_Impl;", "Lkntr/app/im/chat/db/dao/SessionMessageDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__instantConverter", "Lkntr/app/im/chat/db/converter/InstantConverter;", "queryInRangeAsList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/entity/MessageEntity;", "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "start", "end", "(IJJJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInRangeAndLatestAsFlow", "Lkotlinx/coroutines/flow/Flow;", "baselineTime", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionMessageDao_Impl implements SessionMessageDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final InstantConverter __instantConverter;

    public SessionMessageDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__instantConverter = new InstantConverter();
        this.__db = __db;
    }

    @Override // kntr.app.im.chat.db.dao.SessionMessageDao
    public /* bridge */ Flow<List<MessageEntity>> queryInRangeAndLatestAsFlow(SessionIdEntity sessionId, long start, long end, long baselineTime) {
        return SessionMessageDao.CC.$default$queryInRangeAndLatestAsFlow(this, sessionId, start, end, baselineTime);
    }

    @Override // kntr.app.im.chat.db.dao.SessionMessageDao
    public Object queryInRangeAsList(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final long start, final long end, Continuation<? super List<MessageEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, true, new Function1() { // from class: kntr.app.im.chat.db.dao.SessionMessageDao_Impl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                List queryInRangeAsList$lambda$0;
                queryInRangeAsList$lambda$0 = SessionMessageDao_Impl.queryInRangeAsList$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, start, end, this, (SQLiteConnection) obj);
                return queryInRangeAsList$lambda$0;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List queryInRangeAsList$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, long $start, long $end, SessionMessageDao_Impl this$0, SQLiteConnection _connection) {
        String _tmpToken;
        int _cursorIndexOfId;
        Long _tmp;
        Long _tmp2;
        Long _tmp_2;
        SessionMessageDao_Impl sessionMessageDao_Impl = this$0;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            _stmt.bindLong(2, $primaryId);
            _stmt.bindLong(3, $secondaryId);
            _stmt.bindLong(4, $thirdId);
            _stmt.bindLong(5, $start);
            _stmt.bindLong(6, $end);
            int _cursorIndexOfId2 = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
            int _tmpSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg_key");
            int _cursorIndexOfSequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sequence_number");
            int _cursorIndexOfSubsequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sub_sequence_number");
            int _cursorIndexOfToken = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "token");
            int _cursorIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
            int _cursorIndexOfSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "send_status");
            int _cursorIndexOfCreateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "c_time");
            int _cursorIndexOfUpdateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "m_time");
            int _cursorIndexOfDeleteTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "d_time");
            int _cursorIndexOfIsRealtimeMessage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "is_realtime_message");
            int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
            int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
            int _tmpSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
            int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_cursorIndexOfId2);
                long _tmpMsgKey = _stmt.getLong(_tmpSendStatus);
                long _tmpSequenceNumber = _stmt.getLong(_cursorIndexOfSequenceNumber);
                long _tmpSubsequenceNumber = _stmt.getLong(_cursorIndexOfSubsequenceNumber);
                if (_stmt.isNull(_cursorIndexOfToken)) {
                    _tmpToken = null;
                } else {
                    _tmpToken = _stmt.getText(_cursorIndexOfToken);
                }
                String _tmpContent = _stmt.getText(_cursorIndexOfContent);
                int _cursorIndexOfMsgKey = _tmpSendStatus;
                int _cursorIndexOfSequenceNumber2 = _cursorIndexOfSequenceNumber;
                int _tmpSendStatus2 = (int) _stmt.getLong(_cursorIndexOfSendStatus);
                if (_stmt.isNull(_cursorIndexOfCreateTime)) {
                    _cursorIndexOfId = _cursorIndexOfId2;
                    _tmp = null;
                } else {
                    Long _tmp3 = Long.valueOf(_stmt.getLong(_cursorIndexOfCreateTime));
                    _cursorIndexOfId = _cursorIndexOfId2;
                    _tmp = _tmp3;
                }
                Instant _tmp_1 = sessionMessageDao_Impl.__instantConverter.longToInstant(_tmp);
                if (_tmp_1 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfUpdateTime)) {
                    _tmp2 = null;
                } else {
                    Long _tmp_22 = Long.valueOf(_stmt.getLong(_cursorIndexOfUpdateTime));
                    _tmp2 = _tmp_22;
                }
                Instant _tmp_3 = sessionMessageDao_Impl.__instantConverter.longToInstant(_tmp2);
                if (_tmp_3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfDeleteTime)) {
                    _tmp_2 = null;
                } else {
                    Long _tmp_4 = Long.valueOf(_stmt.getLong(_cursorIndexOfDeleteTime));
                    _tmp_2 = _tmp_4;
                }
                Instant _tmpDeleteTime = sessionMessageDao_Impl.__instantConverter.longToInstant(_tmp_2);
                int _tmp_5 = (int) _stmt.getLong(_cursorIndexOfIsRealtimeMessage);
                boolean _tmpIsRealtimeMessage = _tmp_5 != 0;
                int _tmpSessionType2 = (int) _stmt.getLong(_cursorIndexOfSessionType);
                long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                int _cursorIndexOfSecondaryId = _tmpSessionType;
                long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType2, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                MessageEntity _item = new MessageEntity(_tmpId, _tmpSessionId, _tmpMsgKey, _tmpSequenceNumber, _tmpSubsequenceNumber, _tmpToken, _tmpContent, _tmpSendStatus2, _tmp_1, _tmp_3, _tmpDeleteTime, _tmpIsRealtimeMessage);
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _tmpSessionType = _cursorIndexOfSecondaryId;
                _tmpSendStatus = _cursorIndexOfMsgKey;
                _cursorIndexOfSequenceNumber = _cursorIndexOfSequenceNumber2;
                _cursorIndexOfId2 = _cursorIndexOfId;
                sessionMessageDao_Impl = this$0;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    @Override // kntr.app.im.chat.db.dao.SessionMessageDao
    public Flow<List<MessageEntity>> queryInRangeAndLatestAsFlow(final int sessionType, final long primaryId, final long secondaryId, final long thirdId, final long start, final long end, final long baselineTime) {
        return FlowUtil.createFlow(this.__db, true, new String[]{"message_table"}, new Function1() { // from class: kntr.app.im.chat.db.dao.SessionMessageDao_Impl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                List queryInRangeAndLatestAsFlow$lambda$0;
                queryInRangeAndLatestAsFlow$lambda$0 = SessionMessageDao_Impl.queryInRangeAndLatestAsFlow$lambda$0(r1, sessionType, primaryId, secondaryId, thirdId, start, end, baselineTime, this, (SQLiteConnection) obj);
                return queryInRangeAndLatestAsFlow$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List queryInRangeAndLatestAsFlow$lambda$0(String $_sql, int $sessionType, long $primaryId, long $secondaryId, long $thirdId, long $start, long $end, long $baselineTime, SessionMessageDao_Impl this$0, SQLiteConnection _connection) {
        String _tmpToken;
        int _cursorIndexOfId;
        Long _tmp;
        Long _tmp2;
        Long _tmp_2;
        SessionMessageDao_Impl sessionMessageDao_Impl = this$0;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement _stmt = _connection.prepare($_sql);
        try {
            _stmt.bindLong(1, $sessionType);
            _stmt.bindLong(2, $primaryId);
            _stmt.bindLong(3, $secondaryId);
            _stmt.bindLong(4, $thirdId);
            _stmt.bindLong(5, $start);
            _stmt.bindLong(6, $end);
            _stmt.bindLong(7, $baselineTime);
            int _cursorIndexOfId2 = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, ReportBuildInParam.ID);
            int _tmpSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg_key");
            int _cursorIndexOfSequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sequence_number");
            int _cursorIndexOfSubsequenceNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sub_sequence_number");
            int _cursorIndexOfToken = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "token");
            int _cursorIndexOfContent = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "content");
            int _cursorIndexOfSendStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "send_status");
            int _cursorIndexOfCreateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "c_time");
            int _cursorIndexOfUpdateTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "m_time");
            int _cursorIndexOfDeleteTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "d_time");
            int _cursorIndexOfIsRealtimeMessage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "is_realtime_message");
            int _cursorIndexOfSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "session_type");
            int _cursorIndexOfPrimaryId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "primary_id");
            int _tmpSessionType = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "secondary_id");
            int _cursorIndexOfThirdId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "third_id");
            List _result = new ArrayList();
            while (_stmt.step()) {
                long _tmpId = _stmt.getLong(_cursorIndexOfId2);
                long _tmpMsgKey = _stmt.getLong(_tmpSendStatus);
                long _tmpSequenceNumber = _stmt.getLong(_cursorIndexOfSequenceNumber);
                long _tmpSubsequenceNumber = _stmt.getLong(_cursorIndexOfSubsequenceNumber);
                if (_stmt.isNull(_cursorIndexOfToken)) {
                    _tmpToken = null;
                } else {
                    _tmpToken = _stmt.getText(_cursorIndexOfToken);
                }
                String _tmpContent = _stmt.getText(_cursorIndexOfContent);
                int _cursorIndexOfMsgKey = _tmpSendStatus;
                int _cursorIndexOfSequenceNumber2 = _cursorIndexOfSequenceNumber;
                int _tmpSendStatus2 = (int) _stmt.getLong(_cursorIndexOfSendStatus);
                if (_stmt.isNull(_cursorIndexOfCreateTime)) {
                    _cursorIndexOfId = _cursorIndexOfId2;
                    _tmp = null;
                } else {
                    Long _tmp3 = Long.valueOf(_stmt.getLong(_cursorIndexOfCreateTime));
                    _cursorIndexOfId = _cursorIndexOfId2;
                    _tmp = _tmp3;
                }
                Instant _tmp_1 = sessionMessageDao_Impl.__instantConverter.longToInstant(_tmp);
                if (_tmp_1 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfUpdateTime)) {
                    _tmp2 = null;
                } else {
                    Long _tmp_22 = Long.valueOf(_stmt.getLong(_cursorIndexOfUpdateTime));
                    _tmp2 = _tmp_22;
                }
                Instant _tmp_3 = sessionMessageDao_Impl.__instantConverter.longToInstant(_tmp2);
                if (_tmp_3 == null) {
                    throw new IllegalStateException("Expected NON-NULL 'kotlinx.datetime.Instant', but it was NULL.".toString());
                }
                if (_stmt.isNull(_cursorIndexOfDeleteTime)) {
                    _tmp_2 = null;
                } else {
                    Long _tmp_4 = Long.valueOf(_stmt.getLong(_cursorIndexOfDeleteTime));
                    _tmp_2 = _tmp_4;
                }
                Instant _tmpDeleteTime = sessionMessageDao_Impl.__instantConverter.longToInstant(_tmp_2);
                int _tmp_5 = (int) _stmt.getLong(_cursorIndexOfIsRealtimeMessage);
                boolean _tmpIsRealtimeMessage = _tmp_5 != 0;
                int _tmpSessionType2 = (int) _stmt.getLong(_cursorIndexOfSessionType);
                long _tmpPrimaryId = _stmt.getLong(_cursorIndexOfPrimaryId);
                int _cursorIndexOfSecondaryId = _tmpSessionType;
                long _tmpSecondaryId = _stmt.getLong(_cursorIndexOfSecondaryId);
                long _tmpThirdId = _stmt.getLong(_cursorIndexOfThirdId);
                SessionIdEntity _tmpSessionId = new SessionIdEntity(_tmpSessionType2, _tmpPrimaryId, _tmpSecondaryId, _tmpThirdId);
                MessageEntity _item = new MessageEntity(_tmpId, _tmpSessionId, _tmpMsgKey, _tmpSequenceNumber, _tmpSubsequenceNumber, _tmpToken, _tmpContent, _tmpSendStatus2, _tmp_1, _tmp_3, _tmpDeleteTime, _tmpIsRealtimeMessage);
                List _result2 = _result;
                _result2.add(_item);
                _result = _result2;
                _tmpSessionType = _cursorIndexOfSecondaryId;
                _tmpSendStatus = _cursorIndexOfMsgKey;
                _cursorIndexOfSequenceNumber = _cursorIndexOfSequenceNumber2;
                _cursorIndexOfId2 = _cursorIndexOfId;
                sessionMessageDao_Impl = this$0;
            }
            return _result;
        } finally {
            _stmt.close();
        }
    }

    /* compiled from: SessionMessageDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/dao/SessionMessageDao_Impl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getRequiredConverters", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}