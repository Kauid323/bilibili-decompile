package nl.adaptivity.xmlutil.core.impl;

import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharsequenceReader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a)\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0080\nø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"CharsequenceReader", "Ljava/io/Reader;", "sequence", "", "invoke", "R", "Ljava/util/concurrent/locks/Lock;", "body", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CharsequenceReaderKt {
    public static final Reader CharsequenceReader(CharSequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        return sequence instanceof String ? new StringReader((String) sequence) : new CharsequenceReader(sequence, 0);
    }

    public static final <R> R invoke(Lock $this$invoke, Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter($this$invoke, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        $this$invoke.lock();
        try {
            return body.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$invoke.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
}