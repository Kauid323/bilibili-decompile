package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockFreeLinkedList.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/util/internal/Removed;", "", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "ref", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Removed {
    public final LockFreeLinkedListNode ref;

    public Removed(LockFreeLinkedListNode ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.ref = ref;
    }

    public String toString() {
        return "Removed[" + this.ref + ']';
    }
}