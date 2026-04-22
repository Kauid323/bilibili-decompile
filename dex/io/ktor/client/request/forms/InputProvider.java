package io.ktor.client.request.forms;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: formDsl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR!\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/request/forms/InputProvider;", "", "", ContentDisposition.Parameters.Size, "Lkotlin/Function0;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "block", "<init>", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "Ljava/lang/Long;", "getSize", "()Ljava/lang/Long;", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputProvider {
    private final Function0<Source> block;
    private final Long size;

    public InputProvider(Long size, Function0<? extends Source> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.size = size;
        this.block = function0;
    }

    public /* synthetic */ InputProvider(Long l, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, function0);
    }

    public final Function0<Source> getBlock() {
        return this.block;
    }

    public final Long getSize() {
        return this.size;
    }
}