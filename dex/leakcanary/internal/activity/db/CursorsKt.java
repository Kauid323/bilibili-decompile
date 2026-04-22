package leakcanary.internal.activity.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cursors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00030\u0006¢\u0006\u0002\b\u0007H\u0080\b¢\u0006\u0002\u0010\b\u001a,\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\n0\u0006H\u0080\b¢\u0006\u0002\u0010\f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"inTransaction", "Ljava/lang/ThreadLocal;", "", "T", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "use", "R", "Landroid/database/Cursor;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class CursorsKt {
    private static final ThreadLocal<Boolean> inTransaction = new ThreadLocal<>();

    public static final <R> R use(Cursor use, Function1<? super Cursor, ? extends R> block) {
        Intrinsics.checkParameterIsNotNull(use, "$this$use");
        Intrinsics.checkParameterIsNotNull(block, "block");
        try {
            R invoke = block.invoke(use);
            InlineMarker.finallyStart(1);
            use.close();
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable e) {
            try {
                throw e;
            } catch (Throwable e2) {
                InlineMarker.finallyStart(1);
                try {
                    use.close();
                } catch (Throwable th) {
                }
                InlineMarker.finallyEnd(1);
                throw e2;
            }
        }
    }

    public static final <T> T inTransaction(SQLiteDatabase inTransaction2, Function1<? super SQLiteDatabase, ? extends T> block) {
        Intrinsics.checkParameterIsNotNull(inTransaction2, "$this$inTransaction");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ThreadLocal threadLocal = inTransaction;
        Object obj = threadLocal.get();
        if (obj == null) {
            threadLocal.set(false);
            obj = false;
        }
        if (((Boolean) obj).booleanValue()) {
            return block.invoke(inTransaction2);
        }
        try {
            inTransaction.set(true);
            inTransaction2.beginTransaction();
            T invoke = block.invoke(inTransaction2);
            inTransaction2.setTransactionSuccessful();
            return invoke;
        } finally {
            InlineMarker.finallyStart(1);
            inTransaction2.endTransaction();
            inTransaction.set(false);
            InlineMarker.finallyEnd(1);
        }
    }
}