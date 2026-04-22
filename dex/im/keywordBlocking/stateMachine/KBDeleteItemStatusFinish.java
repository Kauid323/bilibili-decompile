package im.keywordBlocking.stateMachine;

import im.keywordBlocking.KBListItem;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBDeleteItemStateMachine.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ(\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lim/keywordBlocking/stateMachine/KBDeleteItemStatusFinish;", "Lim/keywordBlocking/stateMachine/KBDeleteItemStatus;", "item", "Lim/keywordBlocking/KBListItem;", "result", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/im/v1/KKeywordBlockingDeleteReply;", "<init>", "(Lim/keywordBlocking/KBListItem;Ljava/lang/Object;)V", "getItem", "()Lim/keywordBlocking/KBListItem;", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-d1pmJ48", "copy", "(Lim/keywordBlocking/KBListItem;Ljava/lang/Object;)Lim/keywordBlocking/stateMachine/KBDeleteItemStatusFinish;", "equals", "", "other", "", "hashCode", "", "toString", "", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBDeleteItemStatusFinish implements KBDeleteItemStatus {
    private final KBListItem item;
    private final Object result;

    public static /* synthetic */ KBDeleteItemStatusFinish copy$default(KBDeleteItemStatusFinish kBDeleteItemStatusFinish, KBListItem kBListItem, Result result, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kBListItem = kBDeleteItemStatusFinish.item;
        }
        if ((i2 & 2) != 0) {
            result = Result.box-impl(kBDeleteItemStatusFinish.result);
        }
        return kBDeleteItemStatusFinish.copy(kBListItem, result.unbox-impl());
    }

    public final KBListItem component1() {
        return this.item;
    }

    /* renamed from: component2-d1pmJ48  reason: not valid java name */
    public final Object m3199component2d1pmJ48() {
        return this.result;
    }

    public final KBDeleteItemStatusFinish copy(KBListItem kBListItem, Object obj) {
        Intrinsics.checkNotNullParameter(kBListItem, "item");
        return new KBDeleteItemStatusFinish(kBListItem, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBDeleteItemStatusFinish) {
            KBDeleteItemStatusFinish kBDeleteItemStatusFinish = (KBDeleteItemStatusFinish) obj;
            return Intrinsics.areEqual(this.item, kBDeleteItemStatusFinish.item) && Result.equals-impl0(this.result, kBDeleteItemStatusFinish.result);
        }
        return false;
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + Result.hashCode-impl(this.result);
    }

    public String toString() {
        KBListItem kBListItem = this.item;
        return "KBDeleteItemStatusFinish(item=" + kBListItem + ", result=" + Result.toString-impl(this.result) + ")";
    }

    public KBDeleteItemStatusFinish(KBListItem item, Object result) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.result = result;
    }

    @Override // im.keywordBlocking.stateMachine.KBDeleteItemStatus
    public KBListItem getItem() {
        return this.item;
    }

    /* renamed from: getResult-d1pmJ48  reason: not valid java name */
    public final Object m3200getResultd1pmJ48() {
        return this.result;
    }
}