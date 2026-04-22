package io.ktor.util.internal;

import io.ktor.util.internal.LockFreeLinkedListNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"io/ktor/util/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "affected", "", "prepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 176)
public final class LockFreeLinkedListNode$makeCondAddOp$1 extends LockFreeLinkedListNode.CondAddOp {
    final /* synthetic */ Function0<Boolean> $condition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockFreeLinkedListNode$makeCondAddOp$1(LockFreeLinkedListNode $node, Function0<Boolean> function0) {
        super($node);
        this.$condition = function0;
    }

    @Override // io.ktor.util.internal.AtomicOp
    public Object prepare(LockFreeLinkedListNode affected) {
        Intrinsics.checkNotNullParameter(affected, "affected");
        if (((Boolean) this.$condition.invoke()).booleanValue()) {
            return null;
        }
        return LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}