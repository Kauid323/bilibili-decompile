package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OuroComposeTextField.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/ui/textField/BlockQuoteLayout;", "", "startOffset", "", "endOffset", "startLine", "endLine", "indentPx", "", "<init>", "(IIIIF)V", "getStartOffset", "()I", "getEndOffset", "getStartLine", "getEndLine", "getIndentPx", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BlockQuoteLayout {
    public static final int $stable = 0;
    private final int endLine;
    private final int endOffset;
    private final float indentPx;
    private final int startLine;
    private final int startOffset;

    public static /* synthetic */ BlockQuoteLayout copy$default(BlockQuoteLayout blockQuoteLayout, int i, int i2, int i3, int i4, float f, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = blockQuoteLayout.startOffset;
        }
        if ((i5 & 2) != 0) {
            i2 = blockQuoteLayout.endOffset;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = blockQuoteLayout.startLine;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = blockQuoteLayout.endLine;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            f = blockQuoteLayout.indentPx;
        }
        return blockQuoteLayout.copy(i, i6, i7, i8, f);
    }

    public final int component1() {
        return this.startOffset;
    }

    public final int component2() {
        return this.endOffset;
    }

    public final int component3() {
        return this.startLine;
    }

    public final int component4() {
        return this.endLine;
    }

    public final float component5() {
        return this.indentPx;
    }

    public final BlockQuoteLayout copy(int i, int i2, int i3, int i4, float f) {
        return new BlockQuoteLayout(i, i2, i3, i4, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlockQuoteLayout) {
            BlockQuoteLayout blockQuoteLayout = (BlockQuoteLayout) obj;
            return this.startOffset == blockQuoteLayout.startOffset && this.endOffset == blockQuoteLayout.endOffset && this.startLine == blockQuoteLayout.startLine && this.endLine == blockQuoteLayout.endLine && Float.compare(this.indentPx, blockQuoteLayout.indentPx) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.startOffset * 31) + this.endOffset) * 31) + this.startLine) * 31) + this.endLine) * 31) + Float.floatToIntBits(this.indentPx);
    }

    public String toString() {
        int i = this.startOffset;
        int i2 = this.endOffset;
        int i3 = this.startLine;
        int i4 = this.endLine;
        return "BlockQuoteLayout(startOffset=" + i + ", endOffset=" + i2 + ", startLine=" + i3 + ", endLine=" + i4 + ", indentPx=" + this.indentPx + ")";
    }

    public BlockQuoteLayout(int startOffset, int endOffset, int startLine, int endLine, float indentPx) {
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.startLine = startLine;
        this.endLine = endLine;
        this.indentPx = indentPx;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BlockQuoteLayout(int i, int i2, int i3, int i4, float f, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, r5);
        float f2;
        if ((i5 & 16) == 0) {
            f2 = f;
        } else {
            f2 = 16.0f;
        }
    }

    public final int getStartOffset() {
        return this.startOffset;
    }

    public final int getEndOffset() {
        return this.endOffset;
    }

    public final int getStartLine() {
        return this.startLine;
    }

    public final int getEndLine() {
        return this.endLine;
    }

    public final float getIndentPx() {
        return this.indentPx;
    }
}