package kotlinx.datetime.internal.format;

import kotlin.Metadata;

/* compiled from: FieldSpec.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tR\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/datetime/internal/format/FieldSign;", "Target", "", "isNegative", "Lkotlinx/datetime/internal/format/Accessor;", "", "()Lkotlinx/datetime/internal/format/Accessor;", "isZero", "obj", "(Ljava/lang/Object;)Z", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FieldSign<Target> {
    Accessor<Target, Boolean> isNegative();

    boolean isZero(Target target);
}