package leakcanary.internal.activity.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.db.ScopedLeaksDb;

/* compiled from: Db.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lleakcanary/internal/activity/db/Db;", "", "()V", "dbHelper", "Lleakcanary/internal/activity/db/ScopedLeaksDb$DbOpener;", "closeDatabase", "", "execute", "view", "Landroid/view/View;", "block", "Lkotlin/Function1;", "Lleakcanary/internal/activity/db/Db$OnDb;", "Lkotlin/ExtensionFunctionType;", "DbContext", "OnDb", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class Db {
    public static final Db INSTANCE = new Db();
    private static ScopedLeaksDb.DbOpener dbHelper;

    /* compiled from: Db.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lleakcanary/internal/activity/db/Db$OnDb;", "Lleakcanary/internal/activity/db/Io$OnIo;", "db", "Landroid/database/sqlite/SQLiteDatabase;", "getDb", "()Landroid/database/sqlite/SQLiteDatabase;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface OnDb extends Io.OnIo {
        SQLiteDatabase getDb();
    }

    private Db() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Db.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0007\u001a\u00020\n2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R-\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lleakcanary/internal/activity/db/Db$DbContext;", "Lleakcanary/internal/activity/db/Db$OnDb;", "db", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "getDb", "()Landroid/database/sqlite/SQLiteDatabase;", "updateUi", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getUpdateUi", "()Lkotlin/jvm/functions/Function1;", "setUpdateUi", "(Lkotlin/jvm/functions/Function1;)V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DbContext implements OnDb {
        private final SQLiteDatabase db;
        private Function1<? super View, Unit> updateUi;

        public DbContext(SQLiteDatabase db) {
            Intrinsics.checkParameterIsNotNull(db, "db");
            this.db = db;
        }

        @Override // leakcanary.internal.activity.db.Db.OnDb
        public SQLiteDatabase getDb() {
            return this.db;
        }

        public final Function1<View, Unit> getUpdateUi() {
            return this.updateUi;
        }

        public final void setUpdateUi(Function1<? super View, Unit> function1) {
            this.updateUi = function1;
        }

        @Override // leakcanary.internal.activity.db.Io.OnIo
        public void updateUi(Function1<? super View, Unit> updateUi) {
            Intrinsics.checkParameterIsNotNull(updateUi, "updateUi");
            this.updateUi = updateUi;
        }
    }

    public final void execute(View view, final Function1<? super OnDb, Unit> block) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
        final Context appContext = context.getApplicationContext();
        Io.INSTANCE.execute(view, new Function1<Io.OnIo, Unit>() { // from class: leakcanary.internal.activity.db.Db$execute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Io.OnIo onIo) {
                invoke2(onIo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Io.OnIo receiver) {
                ScopedLeaksDb.DbOpener dbOpener;
                ScopedLeaksDb.DbOpener dbOpener2;
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                Db db = Db.INSTANCE;
                dbOpener = Db.dbHelper;
                if (dbOpener == null) {
                    Db db2 = Db.INSTANCE;
                    ScopedLeaksDb scopedLeaksDb = ScopedLeaksDb.INSTANCE;
                    Context appContext2 = appContext;
                    Intrinsics.checkExpressionValueIsNotNull(appContext2, "appContext");
                    Db.dbHelper = scopedLeaksDb.open(appContext2);
                }
                Db db3 = Db.INSTANCE;
                dbOpener2 = Db.dbHelper;
                if (dbOpener2 == null) {
                    Intrinsics.throwNpe();
                }
                Db.DbContext dbBlock = new Db.DbContext(dbOpener2.getWritableDatabase());
                block.invoke(dbBlock);
                Function1 updateUi = dbBlock.getUpdateUi();
                if (updateUi != null) {
                    receiver.updateUi(updateUi);
                }
            }
        });
    }

    public final void closeDatabase() {
        Io.INSTANCE.execute(new Function0<Unit>() { // from class: leakcanary.internal.activity.db.Db$closeDatabase$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ScopedLeaksDb.DbOpener dbOpener;
                Db db = Db.INSTANCE;
                dbOpener = Db.dbHelper;
                if (dbOpener != null) {
                    dbOpener.close();
                }
                Db db2 = Db.INSTANCE;
                Db.dbHelper = null;
            }
        });
    }
}