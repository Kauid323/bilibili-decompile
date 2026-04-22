package kntr.app.im.chat.db;

import androidx.room.RoomDatabase;
import java.util.Arrays;
import java.util.List;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SqlLogger.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/db/SqlLogger;", "Landroidx/room/RoomDatabase$QueryCallback;", "<init>", "()V", "onQuery", RoomRecommendViewModel.EMPTY_CURSOR, "sqlQuery", RoomRecommendViewModel.EMPTY_CURSOR, "bindArgs", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "buildFullSql", "sql", "escapeSqlValue", "value", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SqlLogger implements RoomDatabase.QueryCallback {
    public void onQuery(String sqlQuery, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(sqlQuery, "sqlQuery");
        Intrinsics.checkNotNullParameter(list, "bindArgs");
        try {
            String fullSql = buildFullSql(sqlQuery, list);
            KLog_androidKt.getKLog().d("Database", fullSql);
        } catch (Exception e) {
            KLog_androidKt.getKLog().d("Database", "Querying " + sqlQuery + ", args " + CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.db.SqlLogger$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    CharSequence onQuery$lambda$0;
                    onQuery$lambda$0 = SqlLogger.onQuery$lambda$0(obj);
                    return onQuery$lambda$0;
                }
            }, 31, (Object) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onQuery$lambda$0(Object it) {
        return String.valueOf(it);
    }

    private final String buildFullSql(String sql, List<? extends Object> list) {
        StringBuilder $this$buildFullSql_u24lambda_u240 = new StringBuilder();
        int argIndex = 0;
        String $this$forEach$iv = sql;
        for (int i = 0; i < $this$forEach$iv.length(); i++) {
            char element$iv = $this$forEach$iv.charAt(i);
            if (element$iv == '?' && argIndex < list.size()) {
                $this$buildFullSql_u24lambda_u240.append(escapeSqlValue(list.get(argIndex)));
                argIndex++;
            } else {
                $this$buildFullSql_u24lambda_u240.append(element$iv);
            }
        }
        if (argIndex < list.size()) {
            $this$buildFullSql_u24lambda_u240.append(" /* WARNING: UNBOUND PARAMETERS: ");
            int size = list.size();
            for (int i2 = argIndex; i2 < size; i2++) {
                if (i2 > argIndex) {
                    $this$buildFullSql_u24lambda_u240.append(", ");
                }
                $this$buildFullSql_u24lambda_u240.append(escapeSqlValue(list.get(i2)));
            }
            $this$buildFullSql_u24lambda_u240.append(" */");
        }
        return $this$buildFullSql_u24lambda_u240.toString();
    }

    private final String escapeSqlValue(Object value) {
        if (value == null) {
            return "NULL";
        }
        if (value instanceof String) {
            return "'" + StringsKt.replace$default((String) value, "'", "''", false, 4, (Object) null) + "'";
        } else if (value instanceof byte[]) {
            return "X'" + ArraysKt.joinToString$default((byte[]) value, RoomRecommendViewModel.EMPTY_CURSOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.db.SqlLogger$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    CharSequence escapeSqlValue$lambda$0;
                    escapeSqlValue$lambda$0 = SqlLogger.escapeSqlValue$lambda$0(((Byte) obj).byteValue());
                    return escapeSqlValue$lambda$0;
                }
            }, 30, (Object) null) + "'";
        } else if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue() ? "1" : AdSearchSubCardType.CARD_TYPE_NONE;
        } else {
            return value.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence escapeSqlValue$lambda$0(byte it) {
        String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}