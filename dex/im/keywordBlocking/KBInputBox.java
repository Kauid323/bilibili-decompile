package im.keywordBlocking;

import com.bilibili.blens.Lens;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageData.kt */
@Lens
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001c"}, d2 = {"Lim/keywordBlocking/KBInputBox;", "", "text", "", "charLimit", "", "<init>", "(Ljava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getCharLimit", "()I", "textCount", "getTextCount", "buttonEnable", "", "getButtonEnable", "()Z", "lengthExceed", "getLengthExceed", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "Companion", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBInputBox {
    public static final Companion Companion = new Companion(null);
    private final int charLimit;
    private final String text;

    public static /* synthetic */ KBInputBox copy$default(KBInputBox kBInputBox, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = kBInputBox.text;
        }
        if ((i3 & 2) != 0) {
            i2 = kBInputBox.charLimit;
        }
        return kBInputBox.copy(str, i2);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.charLimit;
    }

    public final KBInputBox copy(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new KBInputBox(str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBInputBox) {
            KBInputBox kBInputBox = (KBInputBox) obj;
            return Intrinsics.areEqual(this.text, kBInputBox.text) && this.charLimit == kBInputBox.charLimit;
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.charLimit;
    }

    public String toString() {
        String str = this.text;
        return "KBInputBox(text=" + str + ", charLimit=" + this.charLimit + ")";
    }

    public KBInputBox(String text, int charLimit) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.charLimit = charLimit;
    }

    public final String getText() {
        return this.text;
    }

    public final int getCharLimit() {
        return this.charLimit;
    }

    public final int getTextCount() {
        return this.text.length();
    }

    public final boolean getButtonEnable() {
        int i2 = this.charLimit;
        int textCount = getTextCount();
        return 1 <= textCount && textCount <= i2;
    }

    public final boolean getLengthExceed() {
        return getTextCount() >= this.charLimit;
    }

    /* compiled from: KBPageData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/keywordBlocking/KBInputBox$Companion;", "", "<init>", "()V", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}