package io.ktor.util.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import com.bilibili.ship.theseus.playlist.util.PlayListIntentConstant;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001:\u0004NOPQB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\n\u0010\b\u001a\u00060\u0000j\u0002`\u00072\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0081\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\f\b\u0000\u0010\u0014*\u00060\u0000j\u0002`\u00072\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0018\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0000j\u0002`\u00072\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001c\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0000j\u0002`\u00072\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0007\u0012\u0004\u0012\u00020\n0\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJG\u0010\u001e\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0000j\u0002`\u00072\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0007\u0012\u0004\u0012\u00020\n0\u001a2\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010!\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0000j\u0002`\u00072\n\u0010 \u001a\u00060\u0000j\u0002`\u0007H\u0001¢\u0006\u0004\b!\u0010\"J/\u0010%\u001a\u00020$2\n\u0010\b\u001a\u00060\u0000j\u0002`\u00072\n\u0010 \u001a\u00060\u0000j\u0002`\u00072\u0006\u0010#\u001a\u00020\fH\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0011¢\u0006\u0004\b)\u0010\u0003J\u0011\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00070/¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0014\u0018\u0001H\u0086\b¢\u0006\u0004\b2\u00103J1\u00104\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001b\u00106\u001a\u00020\u00112\n\u0010 \u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b6\u0010\u0013J\u001b\u00107\u001a\u00020\u00112\n\u0010 \u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b7\u0010\u0013J\u0013\u00108\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b8\u0010.J\u0013\u00109\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b9\u0010.J\u000f\u0010:\u001a\u00020\u0011H\u0001¢\u0006\u0004\b:\u0010\u0003J-\u0010>\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00072\n\u0010;\u001a\u00060\u0000j\u0002`\u00072\b\u0010=\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0004\b>\u0010?J'\u0010C\u001a\u00020\u00112\n\u0010@\u001a\u00060\u0000j\u0002`\u00072\n\u0010 \u001a\u00060\u0000j\u0002`\u0007H\u0000¢\u0006\u0004\bA\u0010BJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bG\u0010(R\u0011\u0010 \u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bH\u00103R\u0015\u0010J\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\bI\u0010.R\u0011\u0010@\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bK\u00103R\u0015\u0010M\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\bL\u0010.\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006R"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "Lio/ktor/util/internal/Removed;", "removed", "()Lio/ktor/util/internal/Removed;", "Lio/ktor/util/internal/Node;", "node", "Lkotlin/Function0;", "", "condition", "Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "addOneIfEmpty", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Z", "", "addLast", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "T", "Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "addLastIf", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Z", "condAdd", "", "tryCondAddNext", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;)I", "remove", "()Z", "helpRemove", "Lio/ktor/util/internal/AtomicDesc;", "describeRemove", "()Lio/ktor/util/internal/AtomicDesc;", "removeFirstOrNull", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "removeFirstIfIsInstanceOf", "()Ljava/lang/Object;", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "finishAdd", "finishRemove", "markPrev", "findHead", "helpDelete", "_prev", "Lio/ktor/util/internal/OpDescriptor;", "op", "correctPrev", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "prev", "validateNode$ktor_utils", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "validateNode", "", "toString", "()Ljava/lang/String;", "isRemoved", "getNext", "getNextNode", "nextNode", "getPrev", "getPrevNode", "prevNode", "CondAddOp", "AddLastDesc", "RemoveFirstDesc", "AbstractAtomicDesc", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class LockFreeLinkedListNode {
    static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed == null) {
            Removed it = new Removed(this);
            _removedRef$FU.lazySet(this, it);
            return it;
        }
        return removed;
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u001e\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "Lio/ktor/util/internal/AtomicOp;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "newNode", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "", "complete", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "oldNext", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode newNode) {
            Intrinsics.checkNotNullParameter(newNode, "newNode");
            this.newNode = newNode;
        }

        @Override // io.ktor.util.internal.AtomicOp
        public void complete(LockFreeLinkedListNode affected, Object failure) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            boolean success = failure == null;
            LockFreeLinkedListNode update = success ? this.newNode : this.oldNext;
            if (update != null && AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, affected, this, update) && success) {
                LockFreeLinkedListNode lockFreeLinkedListNode = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.oldNext;
                Intrinsics.checkNotNull(lockFreeLinkedListNode2);
                lockFreeLinkedListNode.finishAdd(lockFreeLinkedListNode2);
            }
        }
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode node, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(function0, "condition");
        return new LockFreeLinkedListNode$makeCondAddOp$1(node, function0);
    }

    public final boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final Object getNext() {
        while (true) {
            Object next = this._next;
            if (!(next instanceof OpDescriptor)) {
                return next;
            }
            ((OpDescriptor) next).perform(this);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final Object getPrev() {
        while (true) {
            Object prev = this._prev;
            if (prev instanceof Removed) {
                return prev;
            }
            Intrinsics.checkNotNull(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
            if (((LockFreeLinkedListNode) prev).getNext() == this) {
                return prev;
            }
            correctPrev((LockFreeLinkedListNode) prev, null);
        }
    }

    public final LockFreeLinkedListNode getPrevNode() {
        return LockFreeLinkedListKt.unwrap(getPrev());
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0015 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean addOneIfEmpty(LockFreeLinkedListNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, this);
        while (next == this) {
            if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, this, node)) {
                node.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final void addLast(LockFreeLinkedListNode node) {
        LockFreeLinkedListNode prev;
        Intrinsics.checkNotNullParameter(node, "node");
        do {
            Object prev2 = getPrev();
            Intrinsics.checkNotNull(prev2, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            prev = (LockFreeLinkedListNode) prev2;
        } while (!prev.addNext(node, this));
    }

    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(T t) {
        Intrinsics.checkNotNullParameter(t, "node");
        return new AddLastDesc<>(this, t);
    }

    public final boolean addLastIf(LockFreeLinkedListNode node, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(function0, "condition");
        CondAddOp condAdd = new LockFreeLinkedListNode$makeCondAddOp$1(node, function0);
        while (true) {
            Object prev = getPrev();
            Intrinsics.checkNotNull(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode prev2 = (LockFreeLinkedListNode) prev;
            switch (prev2.tryCondAddNext(node, this, condAdd)) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
        }
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode node, Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        LockFreeLinkedListNode prev;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        do {
            Object prev2 = getPrev();
            Intrinsics.checkNotNull(prev2, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            prev = (LockFreeLinkedListNode) prev2;
            if (!((Boolean) function1.invoke(prev)).booleanValue()) {
                return false;
            }
        } while (!prev.addNext(node, this));
        return true;
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode node, Function1<? super LockFreeLinkedListNode, Boolean> function1, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Intrinsics.checkNotNullParameter(function0, "condition");
        CondAddOp condAdd = new LockFreeLinkedListNode$makeCondAddOp$1(node, function0);
        while (true) {
            Object prev = getPrev();
            Intrinsics.checkNotNull(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode prev2 = (LockFreeLinkedListNode) prev;
            if (((Boolean) function1.invoke(prev2)).booleanValue()) {
                switch (prev2.tryCondAddNext(node, this, condAdd)) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                }
            }
            return false;
        }
    }

    public final boolean addNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(next, "next");
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, next);
        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, next, node)) {
            node.finishAdd(next);
            return true;
        }
        return false;
    }

    public final int tryCondAddNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next, CondAddOp condAdd) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(next, "next");
        Intrinsics.checkNotNullParameter(condAdd, "condAdd");
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, next);
        condAdd.oldNext = next;
        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, next, condAdd)) {
            return condAdd.perform(this) == null ? 1 : 2;
        }
        return 0;
    }

    public boolean remove() {
        Object next;
        Removed removed;
        do {
            next = getNext();
            if ((next instanceof Removed) || next == this) {
                return false;
            }
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            removed = ((LockFreeLinkedListNode) next).removed();
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, next, removed));
        finishRemove((LockFreeLinkedListNode) next);
        return true;
    }

    public final void helpRemove() {
        Object next = getNext();
        Removed removed = next instanceof Removed ? (Removed) next : null;
        if (removed == null) {
            throw new IllegalStateException("Must be invoked on a removed node".toString());
        }
        finishRemove(removed.ref);
    }

    public AtomicDesc describeRemove() {
        if (isRemoved()) {
            return null;
        }
        return new AbstractAtomicDesc() { // from class: io.ktor.util.internal.LockFreeLinkedListNode$describeRemove$1
            private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode$describeRemove$1.class, Object.class, "_originalNext");
            private volatile /* synthetic */ Object _originalNext = null;

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected LockFreeLinkedListNode getAffectedNode() {
                return LockFreeLinkedListNode.this;
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected LockFreeLinkedListNode getOriginalNext() {
                return (LockFreeLinkedListNode) this._originalNext;
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected Object failure(LockFreeLinkedListNode affected, Object next) {
                Intrinsics.checkNotNullParameter(affected, "affected");
                Intrinsics.checkNotNullParameter(next, "next");
                if (next instanceof Removed) {
                    return LockFreeLinkedListKt.getALREADY_REMOVED();
                }
                return null;
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                Intrinsics.checkNotNullParameter(affected, "affected");
                Intrinsics.checkNotNullParameter(next, "next");
                AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_originalNext$FU, this, (Object) null, next);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            public Removed updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                Intrinsics.checkNotNullParameter(affected, "affected");
                Intrinsics.checkNotNullParameter(next, "next");
                return next.removed();
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                Intrinsics.checkNotNullParameter(affected, "affected");
                Intrinsics.checkNotNullParameter(next, "next");
                LockFreeLinkedListNode.this.finishRemove(next);
            }
        };
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode first = (LockFreeLinkedListNode) next;
            if (first == this) {
                return null;
            }
            if (first.remove()) {
                return first;
            }
            first.helpDelete();
        }
    }

    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, io.ktor.util.internal.LockFreeLinkedListNode] */
    public final /* synthetic */ <T> T removeFirstIfIsInstanceOf() {
        while (true) {
            Object next = getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            ?? r1 = (T) ((LockFreeLinkedListNode) next);
            if (r1 == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(r1 instanceof Object)) {
                return null;
            }
            if (r1.remove()) {
                return r1;
            }
            r1.helpDelete();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, io.ktor.util.internal.LockFreeLinkedListNode, java.lang.Object] */
    public final /* synthetic */ <T> T removeFirstIfIsInstanceOfOrPeekIf(Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        while (true) {
            Object next = getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            ?? r1 = (T) ((LockFreeLinkedListNode) next);
            if (r1 == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(r1 instanceof Object)) {
                return null;
            }
            if (((Boolean) function1.invoke((Object) r1)).booleanValue() || r1.remove()) {
                return r1;
            }
            r1.helpDelete();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0015\u0010\u0014J'\u0010\u0017\u001a\u00020\u00162\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\bR\u0018\u0010\u0005\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0006\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u001c\u0010\u001b\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u00060\u0001j\u0002`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001e"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "T", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "node", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "affected", "", "next", "", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "updatedNext", "", "finishOnSuccess", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile /* synthetic */ Object _affectedNode;
        public final T node;
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(LockFreeLinkedListNode queue, T t) {
            Intrinsics.checkNotNullParameter(queue, "queue");
            Intrinsics.checkNotNullParameter(t, "node");
            this.queue = queue;
            this.node = t;
            if (!(this.node._next == this.node && this.node._prev == this.node)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this._affectedNode = null;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            Intrinsics.checkNotNullParameter(op, "op");
            while (true) {
                Object obj = this.queue._prev;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                LockFreeLinkedListNode prev = (LockFreeLinkedListNode) obj;
                Object next = prev._next;
                if (next == this.queue || next == op) {
                    return prev;
                }
                if (!(next instanceof OpDescriptor)) {
                    LockFreeLinkedListNode affected = this.queue.correctPrev(prev, op);
                    if (affected != null) {
                        return affected;
                    }
                } else {
                    ((OpDescriptor) next).perform(prev);
                }
            }
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected boolean retry(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            return next != this.queue;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_affectedNode$FU, this, (Object) null, affected);
            return null;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._prev$FU, this.node, this.node, affected);
            AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, this.node, this.node, this.queue);
            return this.node;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            this.node.finishAdd(this.queue);
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00122\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001b\u001a\u00020\u001a2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0017\u0010\"\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010'\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006("}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "queue", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "affected", "", "next", "failure", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Ljava/lang/Object;", "node", "", "validatePrepared", "(Ljava/lang/Object;)Z", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "updatedNext", "", "finishOnSuccess", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile /* synthetic */ Object _affectedNode;
        private volatile /* synthetic */ Object _originalNext;
        public final LockFreeLinkedListNode queue;

        public static /* synthetic */ void getResult$annotations() {
        }

        public RemoveFirstDesc(LockFreeLinkedListNode queue) {
            Intrinsics.checkNotNullParameter(queue, "queue");
            this.queue = queue;
            this._affectedNode = null;
            this._originalNext = null;
        }

        public final T getResult() {
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return (T) affectedNode;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            Intrinsics.checkNotNullParameter(op, "op");
            Object next = this.queue.getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            return (LockFreeLinkedListNode) next;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            if (affected == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        protected boolean validatePrepared(T t) {
            return true;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final boolean retry(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            if (next instanceof Removed) {
                affected.helpDelete();
                return true;
            }
            return false;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Object obj;
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            if (affected instanceof LockFreeLinkedListHead) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!validatePrepared(affected)) {
                obj = LockFreeLinkedListKt.REMOVE_PREPARED;
                return obj;
            }
            AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_affectedNode$FU, this, (Object) null, affected);
            AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_originalNext$FU, this, (Object) null, next);
            return null;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            return next.removed();
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            affected.finishRemove(next);
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H$¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H$¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0016\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H$¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00152\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078$X¤\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lio/ktor/util/internal/AtomicDesc;", "<init>", "()V", "Lio/ktor/util/internal/OpDescriptor;", "op", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "affected", "", "next", "failure", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Ljava/lang/Object;", "", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "updatedNext", "", "finishOnSuccess", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/AtomicOp;", "prepare", "(Lio/ktor/util/internal/AtomicOp;)Ljava/lang/Object;", "complete", "(Lio/ktor/util/internal/AtomicOp;Ljava/lang/Object;)V", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "PrepareOp", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        protected abstract void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        protected abstract LockFreeLinkedListNode getAffectedNode();

        protected abstract LockFreeLinkedListNode getOriginalNext();

        protected abstract Object onPrepare(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        protected abstract Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        protected LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            Intrinsics.checkNotNullParameter(op, "op");
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return affectedNode;
        }

        protected Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            return null;
        }

        protected boolean retry(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkNotNullParameter(affected, "affected");
            Intrinsics.checkNotNullParameter(next, "next");
            return false;
        }

        /* compiled from: LockFreeLinkedList.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u001e\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc$PrepareOp;", "Lio/ktor/util/internal/OpDescriptor;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "next", "Lio/ktor/util/internal/AtomicOp;", "op", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", PlayListIntentConstant.EXTRA_JUMP_DESC, "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/AtomicOp;Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/AtomicOp;", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
        private static final class PrepareOp extends OpDescriptor {
            public final AbstractAtomicDesc desc;
            public final LockFreeLinkedListNode next;
            public final AtomicOp<LockFreeLinkedListNode> op;

            /* JADX WARN: Multi-variable type inference failed */
            public PrepareOp(LockFreeLinkedListNode next, AtomicOp<? super LockFreeLinkedListNode> atomicOp, AbstractAtomicDesc desc) {
                Intrinsics.checkNotNullParameter(next, "next");
                Intrinsics.checkNotNullParameter(atomicOp, "op");
                Intrinsics.checkNotNullParameter(desc, PlayListIntentConstant.EXTRA_JUMP_DESC);
                this.next = next;
                this.op = atomicOp;
                this.desc = desc;
            }

            @Override // io.ktor.util.internal.OpDescriptor
            public Object perform(Object affected) {
                Object obj;
                Intrinsics.checkNotNull(affected, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) affected;
                Object decision = this.desc.onPrepare((LockFreeLinkedListNode) affected, this.next);
                if (decision != null) {
                    obj = LockFreeLinkedListKt.REMOVE_PREPARED;
                    if (decision == obj) {
                        Removed removed = this.next.removed();
                        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, (LockFreeLinkedListNode) affected, this, removed)) {
                            ((LockFreeLinkedListNode) affected).helpDelete();
                        }
                    } else {
                        this.op.tryDecide(decision);
                        AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, (LockFreeLinkedListNode) affected, this, this.next);
                    }
                    return decision;
                }
                Object update = this.op.isDecided() ? this.next : this.op;
                AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, (LockFreeLinkedListNode) affected, this, update);
                return null;
            }
        }

        @Override // io.ktor.util.internal.AtomicDesc
        public final Object prepare(AtomicOp<?> atomicOp) {
            Object obj;
            Intrinsics.checkNotNullParameter(atomicOp, "op");
            while (true) {
                LockFreeLinkedListNode affected = takeAffectedNode(atomicOp);
                Object next = affected._next;
                if (next == atomicOp || atomicOp.isDecided()) {
                    return null;
                }
                if (next instanceof OpDescriptor) {
                    ((OpDescriptor) next).perform(affected);
                } else {
                    Object failure = failure(affected, next);
                    if (failure != null) {
                        return failure;
                    }
                    if (retry(affected, next)) {
                        continue;
                    } else {
                        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                        PrepareOp prepareOp = new PrepareOp((LockFreeLinkedListNode) next, atomicOp, this);
                        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, affected, next, prepareOp)) {
                            Object prepFail = prepareOp.perform(affected);
                            obj = LockFreeLinkedListKt.REMOVE_PREPARED;
                            if (prepFail != obj) {
                                return prepFail;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        @Override // io.ktor.util.internal.AtomicDesc
        public final void complete(AtomicOp<?> atomicOp, Object failure) {
            Intrinsics.checkNotNullParameter(atomicOp, "op");
            boolean success = failure == null;
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null) {
                if (!(success ? false : true)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            }
            LockFreeLinkedListNode originalNext = getOriginalNext();
            if (originalNext == null) {
                if (!(success ? false : true)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            }
            Object update = success ? updatedNext(affectedNode, originalNext) : originalNext;
            if (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode._next$FU, affectedNode, atomicOp, update) || !success) {
                return;
            }
            finishOnSuccess(affectedNode, originalNext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode next) {
        Object nextPrev;
        do {
            nextPrev = next._prev;
            if ((nextPrev instanceof Removed) || getNext() != next) {
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_prev$FU, next, nextPrev, this));
        if (getNext() instanceof Removed) {
            Intrinsics.checkNotNull(nextPrev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            next.correctPrev((LockFreeLinkedListNode) nextPrev, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishRemove(LockFreeLinkedListNode next) {
        helpDelete();
        next.correctPrev(LockFreeLinkedListKt.unwrap(this._prev), null);
    }

    private final LockFreeLinkedListNode markPrev() {
        Object prev;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Removed removedPrev;
        do {
            prev = this._prev;
            if (prev instanceof Removed) {
                return ((Removed) prev).ref;
            }
            if (prev == this) {
                lockFreeLinkedListNode = findHead();
            } else {
                Intrinsics.checkNotNull(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
            }
            removedPrev = lockFreeLinkedListNode.removed();
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_prev$FU, this, prev, removedPrev));
        return (LockFreeLinkedListNode) prev;
    }

    private final LockFreeLinkedListNode findHead() {
        boolean z;
        LockFreeLinkedListNode cur = this;
        while (!(cur instanceof LockFreeLinkedListHead)) {
            cur = cur.getNextNode();
            if (cur != this) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (!z) {
                throw new IllegalStateException("Cannot loop to this while looking for list head".toString());
            }
        }
        return cur;
    }

    public final void helpDelete() {
        LockFreeLinkedListNode last = null;
        LockFreeLinkedListNode prev = markPrev();
        Object obj = this._next;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.util.internal.Removed");
        LockFreeLinkedListNode next = ((Removed) obj).ref;
        while (true) {
            Object nextNext = next.getNext();
            if (nextNext instanceof Removed) {
                next.markPrev();
                next = ((Removed) nextNext).ref;
            } else {
                Object prevNext = prev.getNext();
                if (prevNext instanceof Removed) {
                    if (last != null) {
                        prev.markPrev();
                        AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$FU, last, prev, ((Removed) prevNext).ref);
                        prev = last;
                        last = null;
                    } else {
                        prev = LockFreeLinkedListKt.unwrap(prev._prev);
                    }
                } else if (prevNext != this) {
                    last = prev;
                    Intrinsics.checkNotNull(prevNext, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                    prev = (LockFreeLinkedListNode) prevNext;
                    if (prev == next) {
                        return;
                    }
                } else if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$FU, prev, this, next)) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LockFreeLinkedListNode correctPrev(LockFreeLinkedListNode _prev, OpDescriptor op) {
        LockFreeLinkedListNode prev = _prev;
        LockFreeLinkedListNode last = null;
        while (true) {
            Object prevNext = prev._next;
            if (prevNext == op) {
                return prev;
            }
            if (prevNext instanceof OpDescriptor) {
                ((OpDescriptor) prevNext).perform(prev);
            } else if (prevNext instanceof Removed) {
                if (last != null) {
                    prev.markPrev();
                    AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_next$FU, last, prev, ((Removed) prevNext).ref);
                    prev = last;
                    last = null;
                } else {
                    prev = LockFreeLinkedListKt.unwrap(prev._prev);
                }
            } else {
                Object oldPrev = this._prev;
                if (oldPrev instanceof Removed) {
                    return null;
                }
                if (prevNext != this) {
                    last = prev;
                    Intrinsics.checkNotNull(prevNext, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                    prev = (LockFreeLinkedListNode) prevNext;
                } else if (oldPrev == prev) {
                    return null;
                } else {
                    if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_prev$FU, this, oldPrev, prev) && !(prev._prev instanceof Removed)) {
                        return null;
                    }
                }
            }
        }
    }

    public final void validateNode$ktor_utils(LockFreeLinkedListNode prev, LockFreeLinkedListNode next) {
        Intrinsics.checkNotNullParameter(prev, "prev");
        Intrinsics.checkNotNullParameter(next, "next");
        if (!(prev == this._prev)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(next == this._next)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '@' + hashCode();
    }
}