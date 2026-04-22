package io.ktor.http.content;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Multipart.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class MultipartKt$sam$kotlinx_coroutines_flow_FlowCollector$0 implements FlowCollector, FunctionAdapter {
    private final /* synthetic */ Function2<P1, Continuation<? super R>, Object> function;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public MultipartKt$sam$kotlinx_coroutines_flow_FlowCollector$0(Function2<? super P1, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "function");
        this.function = function2;
    }

    public final /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return this.function.invoke(obj, continuation);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}