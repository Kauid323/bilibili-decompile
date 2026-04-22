package nl.adaptivity.xmlutil.core.impl.multiplatform;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlUtilInternal;

/* compiled from: multiplatform.jvm.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e*\n\u0010\u000f\"\u00020\u00102\u00020\u0010*\u0010\b\u0007\u0010\u0011\"\u00020\u00122\u00020\u0012B\u0002\b\u0013*\u0010\b\u0007\u0010\u0014\"\u00020\u00152\u00020\u0015B\u0002\b\u0013*\n\u0010\u0016\"\u00020\u00172\u00020\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "use", "R", "T", "Ljava/io/Closeable;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Language", "Lorg/intellij/lang/annotations/Language;", "MpJvmDefaultWithoutCompatibility", "Lkotlin/jvm/JvmDefaultWithoutCompatibility;", "Lnl/adaptivity/xmlutil/XmlUtilInternal;", "MpJvmDefaultWithCompatibility", "Lkotlin/jvm/JvmDefaultWithCompatibility;", "Throws", "Lkotlin/jvm/Throws;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Multiplatform_jvmKt {
    @XmlUtilInternal
    public static /* synthetic */ void MpJvmDefaultWithCompatibility$annotations() {
    }

    @XmlUtilInternal
    public static /* synthetic */ void MpJvmDefaultWithoutCompatibility$annotations() {
    }

    /* renamed from: assert  reason: not valid java name */
    public static final void m1631assert(boolean value, Function0<String> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (!value) {
            throw new AssertionError(lazyMessage.invoke());
        }
    }

    /* renamed from: assert  reason: not valid java name */
    public static final void m1630assert(boolean value) {
        if (!value) {
            throw new AssertionError("Assertion failed");
        }
    }

    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            R invoke = block.invoke(t);
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(t, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }
}