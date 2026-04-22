package leakcanary.internal.activity.db;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.activity.db.Db;

/* compiled from: Db.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0000¨\u0006\u0007"}, d2 = {"executeOnDb", "", "Landroid/view/View;", "block", "Lkotlin/Function1;", "Lleakcanary/internal/activity/db/Db$OnDb;", "Lkotlin/ExtensionFunctionType;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class DbKt {
    public static final void executeOnDb(View executeOnDb, Function1<? super Db.OnDb, Unit> block) {
        Intrinsics.checkParameterIsNotNull(executeOnDb, "$this$executeOnDb");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Db.INSTANCE.execute(executeOnDb, block);
    }
}