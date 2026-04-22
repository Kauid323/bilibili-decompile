package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0081T¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\u00020\u00058\u0000X\u0081T¢\u0006\f\n\u0004\b\n\u0010\u0007\u0012\u0004\b\u000b\u0010\t\"\u001a\u0010\f\u001a\u00020\u00058\u0000X\u0081T¢\u0006\f\n\u0004\b\f\u0010\u0007\u0012\u0004\b\r\u0010\t\" \u0010\u000e\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011\" \u0010\u0013\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0011\" \u0010\u0016\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u000f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0011\"\u0014\u0010\u0019\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000f\"\u0014\u0010\u001a\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u000f*\f\b\u0002\u0010\u001b\"\u00020\u00012\u00020\u0001*\u001c\u0010\u001e\u001a\u0004\b\u0000\u0010\u001c\"\b\u0012\u0004\u0012\u00028\u00000\u001d2\b\u0012\u0004\u0012\u00028\u00000\u001d*\u001c\u0010 \u001a\u0004\b\u0000\u0010\u001c\"\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\u0012\u0004\u0012\u00028\u00000\u001f*\n\u0010\"\"\u00020!2\u00020!¨\u0006#"}, d2 = {"", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "unwrap", "(Ljava/lang/Object;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "", "UNDECIDED", "I", "getUNDECIDED$annotations", "()V", "SUCCESS", "getSUCCESS$annotations", "FAILURE", "getFAILURE$annotations", "CONDITION_FALSE", "Ljava/lang/Object;", "getCONDITION_FALSE", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "ALREADY_REMOVED", "getALREADY_REMOVED", "getALREADY_REMOVED$annotations", "LIST_EMPTY", "getLIST_EMPTY", "getLIST_EMPTY$annotations", "REMOVE_PREPARED", "NO_DECISION", "Node", "T", "Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "RemoveFirstDesc", "Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "AddLastDesc", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AbstractAtomicDesc", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LockFreeLinkedListKt {
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");
    private static final Object ALREADY_REMOVED = new Symbol("ALREADY_REMOVED");
    private static final Object LIST_EMPTY = new Symbol("LIST_EMPTY");
    private static final Object REMOVE_PREPARED = new Symbol("REMOVE_PREPARED");
    private static final Object NO_DECISION = new Symbol("NO_DECISION");

    public static final /* synthetic */ Object access$getNO_DECISION$p() {
        return NO_DECISION;
    }

    public static /* synthetic */ void getALREADY_REMOVED$annotations() {
    }

    public static /* synthetic */ void getCONDITION_FALSE$annotations() {
    }

    public static /* synthetic */ void getFAILURE$annotations() {
    }

    public static /* synthetic */ void getLIST_EMPTY$annotations() {
    }

    public static /* synthetic */ void getSUCCESS$annotations() {
    }

    public static /* synthetic */ void getUNDECIDED$annotations() {
    }

    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    public static final Object getALREADY_REMOVED() {
        return ALREADY_REMOVED;
    }

    public static final Object getLIST_EMPTY() {
        return LIST_EMPTY;
    }

    public static final LockFreeLinkedListNode unwrap(Object $this$unwrap) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Intrinsics.checkNotNullParameter($this$unwrap, "<this>");
        Removed removed = $this$unwrap instanceof Removed ? (Removed) $this$unwrap : null;
        return (removed == null || (lockFreeLinkedListNode = removed.ref) == null) ? (LockFreeLinkedListNode) $this$unwrap : lockFreeLinkedListNode;
    }
}