package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: Builder.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"Lkotlin/Function1;", "Lkotlinx/io/Sink;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/io/Source;", "buildPacket", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/io/Source;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class BuilderKt {
    public static final Source buildPacket(Function1<? super Sink, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Source buffer = new Buffer();
        function1.invoke(buffer);
        return buffer;
    }
}