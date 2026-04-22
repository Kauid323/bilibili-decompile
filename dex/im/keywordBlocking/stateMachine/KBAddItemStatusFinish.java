package im.keywordBlocking.stateMachine;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBAddItemStateMachine.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ(\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lim/keywordBlocking/stateMachine/KBAddItemStatusFinish;", "Lim/keywordBlocking/stateMachine/KBAddItemStatus;", "text", "", "result", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/im/v1/KKeywordBlockingAddReply;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getText", "()Ljava/lang/String;", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-d1pmJ48", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lim/keywordBlocking/stateMachine/KBAddItemStatusFinish;", "equals", "", "other", "", "hashCode", "", "toString", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBAddItemStatusFinish implements KBAddItemStatus {
    private final Object result;
    private final String text;

    public static /* synthetic */ KBAddItemStatusFinish copy$default(KBAddItemStatusFinish kBAddItemStatusFinish, String str, Result result, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kBAddItemStatusFinish.text;
        }
        if ((i2 & 2) != 0) {
            result = Result.box-impl(kBAddItemStatusFinish.result);
        }
        return kBAddItemStatusFinish.copy(str, result.unbox-impl());
    }

    public final String component1() {
        return this.text;
    }

    /* renamed from: component2-d1pmJ48  reason: not valid java name */
    public final Object m3197component2d1pmJ48() {
        return this.result;
    }

    public final KBAddItemStatusFinish copy(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new KBAddItemStatusFinish(str, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBAddItemStatusFinish) {
            KBAddItemStatusFinish kBAddItemStatusFinish = (KBAddItemStatusFinish) obj;
            return Intrinsics.areEqual(this.text, kBAddItemStatusFinish.text) && Result.equals-impl0(this.result, kBAddItemStatusFinish.result);
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + Result.hashCode-impl(this.result);
    }

    public String toString() {
        String str = this.text;
        return "KBAddItemStatusFinish(text=" + str + ", result=" + Result.toString-impl(this.result) + ")";
    }

    public KBAddItemStatusFinish(String text, Object result) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.result = result;
    }

    @Override // im.keywordBlocking.stateMachine.KBAddItemStatus
    public String getText() {
        return this.text;
    }

    /* renamed from: getResult-d1pmJ48  reason: not valid java name */
    public final Object m3198getResultd1pmJ48() {
        return this.result;
    }
}