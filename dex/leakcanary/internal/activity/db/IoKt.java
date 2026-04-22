package leakcanary.internal.activity.db;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.activity.db.Io;

/* compiled from: Io.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0000¨\u0006\u0007"}, d2 = {"executeOnIo", "", "Landroid/view/View;", "block", "Lkotlin/Function1;", "Lleakcanary/internal/activity/db/Io$OnIo;", "Lkotlin/ExtensionFunctionType;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class IoKt {
    public static final void executeOnIo(View executeOnIo, Function1<? super Io.OnIo, Unit> block) {
        Intrinsics.checkParameterIsNotNull(executeOnIo, "$this$executeOnIo");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Io.INSTANCE.execute(executeOnIo, block);
    }
}