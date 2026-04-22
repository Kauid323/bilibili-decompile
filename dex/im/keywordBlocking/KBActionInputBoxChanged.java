package im.keywordBlocking;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBAction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lim/keywordBlocking/KBActionInputBoxChanged;", "Lim/keywordBlocking/KBAction;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBActionInputBoxChanged implements KBAction {
    private final String text;

    public static /* synthetic */ KBActionInputBoxChanged copy$default(KBActionInputBoxChanged kBActionInputBoxChanged, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kBActionInputBoxChanged.text;
        }
        return kBActionInputBoxChanged.copy(str);
    }

    public final String component1() {
        return this.text;
    }

    public final KBActionInputBoxChanged copy(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new KBActionInputBoxChanged(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KBActionInputBoxChanged) && Intrinsics.areEqual(this.text, ((KBActionInputBoxChanged) obj).text);
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    public String toString() {
        return "KBActionInputBoxChanged(text=" + this.text + ")";
    }

    public KBActionInputBoxChanged(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }
}