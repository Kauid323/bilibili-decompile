package leakcanary.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeapDumpTrigger.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final class HeapDumpTrigger$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeapDumpTrigger$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}