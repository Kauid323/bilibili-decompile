package leakcanary.internal.activity.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScopedLeaksDb.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ-\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\r0\u000f¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\r0\u000f¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lleakcanary/internal/activity/db/ScopedLeaksDb;", "", "()V", "leaksDbHelper", "Lleakcanary/internal/activity/db/LeaksDbHelper;", "lock", "openCount", "", "open", "Lleakcanary/internal/activity/db/ScopedLeaksDb$DbOpener;", "context", "Landroid/content/Context;", "readableDatabase", "T", "block", "Lkotlin/Function1;", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableDatabase", "DbOpener", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class ScopedLeaksDb {
    private static volatile LeaksDbHelper leaksDbHelper;
    private static volatile int openCount;
    public static final ScopedLeaksDb INSTANCE = new ScopedLeaksDb();
    private static final Object lock = new Object();

    private ScopedLeaksDb() {
    }

    public static final /* synthetic */ LeaksDbHelper access$getLeaksDbHelper$p(ScopedLeaksDb $this) {
        LeaksDbHelper leaksDbHelper2 = leaksDbHelper;
        if (leaksDbHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leaksDbHelper");
        }
        return leaksDbHelper2;
    }

    public static final /* synthetic */ Object access$getLock$p(ScopedLeaksDb $this) {
        return lock;
    }

    public static final /* synthetic */ int access$getOpenCount$p(ScopedLeaksDb $this) {
        return openCount;
    }

    public final <T> T readableDatabase(Context context, Function1<? super SQLiteDatabase, ? extends T> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        DbOpener open = open(context);
        try {
            DbOpener it = open;
            T invoke = block.invoke(it.getReadableDatabase());
            CloseableKt.closeFinally(open, null);
            return invoke;
        } finally {
        }
    }

    public final <T> T writableDatabase(Context context, Function1<? super SQLiteDatabase, ? extends T> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        DbOpener open = open(context);
        try {
            DbOpener it = open;
            T invoke = block.invoke(it.getWritableDatabase());
            CloseableKt.closeFinally(open, null);
            return invoke;
        } finally {
        }
    }

    public final DbOpener open(Context context) {
        DbOpener dbOpener;
        Intrinsics.checkParameterIsNotNull(context, "context");
        synchronized (lock) {
            if (leaksDbHelper == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
                leaksDbHelper = new LeaksDbHelper(applicationContext);
            }
            openCount++;
            dbOpener = new DbOpener();
        }
        return dbOpener;
    }

    /* compiled from: ScopedLeaksDb.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lleakcanary/internal/activity/db/ScopedLeaksDb$DbOpener;", "Ljava/io/Closeable;", "()V", "closed", "", "readableDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getReadableDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "writableDatabase", "getWritableDatabase", "checkClosed", "", "close", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DbOpener implements Closeable {
        private boolean closed;

        public final SQLiteDatabase getReadableDatabase() {
            checkClosed();
            SQLiteDatabase readableDatabase = ScopedLeaksDb.access$getLeaksDbHelper$p(ScopedLeaksDb.INSTANCE).getReadableDatabase();
            Intrinsics.checkExpressionValueIsNotNull(readableDatabase, "leaksDbHelper.readableDatabase");
            return readableDatabase;
        }

        public final SQLiteDatabase getWritableDatabase() {
            checkClosed();
            SQLiteDatabase writableDatabase = ScopedLeaksDb.access$getLeaksDbHelper$p(ScopedLeaksDb.INSTANCE).getWritableDatabase();
            Intrinsics.checkExpressionValueIsNotNull(writableDatabase, "leaksDbHelper.writableDatabase");
            return writableDatabase;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (ScopedLeaksDb.access$getLock$p(ScopedLeaksDb.INSTANCE)) {
                checkClosed();
                this.closed = true;
                ScopedLeaksDb.openCount = ScopedLeaksDb.access$getOpenCount$p(ScopedLeaksDb.INSTANCE) - 1;
                if (ScopedLeaksDb.access$getOpenCount$p(ScopedLeaksDb.INSTANCE) == 0) {
                    ScopedLeaksDb.access$getLeaksDbHelper$p(ScopedLeaksDb.INSTANCE).close();
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void checkClosed() {
            if (this.closed) {
                throw new IllegalStateException("Already closed".toString());
            }
        }
    }
}