package kntr.common.ouro.core.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OuroTextRange.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001b\u0010\f\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0010\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\nR\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lkntr/common/ouro/core/model/OuroTextRange;", "", "start", "", "end", "<init>", "(II)V", "pos", "(I)V", "getStart", "()I", "getEnd", "min", "getMin", "min$delegate", "Lkotlin/Lazy;", "max", "getMax", "max$delegate", "length", "getLength", "collapsed", "", "getCollapsed", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextRange {
    public static final Companion Companion = new Companion(null);
    private static final OuroTextRange Zero = new OuroTextRange(0, 0);
    private final int end;
    private final Lazy max$delegate;
    private final Lazy min$delegate;
    private final int start;

    public static /* synthetic */ OuroTextRange copy$default(OuroTextRange ouroTextRange, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ouroTextRange.start;
        }
        if ((i3 & 2) != 0) {
            i2 = ouroTextRange.end;
        }
        return ouroTextRange.copy(i, i2);
    }

    public final int component1() {
        return this.start;
    }

    public final int component2() {
        return this.end;
    }

    public final OuroTextRange copy(int i, int i2) {
        return new OuroTextRange(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroTextRange) {
            OuroTextRange ouroTextRange = (OuroTextRange) obj;
            return this.start == ouroTextRange.start && this.end == ouroTextRange.end;
        }
        return false;
    }

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    public String toString() {
        int i = this.start;
        return "OuroTextRange(start=" + i + ", end=" + this.end + ")";
    }

    public OuroTextRange(int start, int end) {
        this.start = start;
        this.end = end;
        this.min$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroTextRange$$ExternalSyntheticLambda0
            public final Object invoke() {
                int min_delegate$lambda$0;
                min_delegate$lambda$0 = OuroTextRange.min_delegate$lambda$0(OuroTextRange.this);
                return Integer.valueOf(min_delegate$lambda$0);
            }
        });
        this.max$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroTextRange$$ExternalSyntheticLambda1
            public final Object invoke() {
                int max_delegate$lambda$0;
                max_delegate$lambda$0 = OuroTextRange.max_delegate$lambda$0(OuroTextRange.this);
                return Integer.valueOf(max_delegate$lambda$0);
            }
        });
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }

    public OuroTextRange(int pos) {
        this(pos, pos);
    }

    /* compiled from: OuroTextRange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/common/ouro/core/model/OuroTextRange$Companion;", "", "<init>", "()V", "Zero", "Lkntr/common/ouro/core/model/OuroTextRange;", "getZero", "()Lkntr/common/ouro/core/model/OuroTextRange;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OuroTextRange getZero() {
            return OuroTextRange.Zero;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int min_delegate$lambda$0(OuroTextRange this$0) {
        return Math.min(this$0.start, this$0.end);
    }

    public final int getMin() {
        return ((Number) this.min$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int max_delegate$lambda$0(OuroTextRange this$0) {
        return Math.max(this$0.start, this$0.end);
    }

    public final int getMax() {
        return ((Number) this.max$delegate.getValue()).intValue();
    }

    public final int getLength() {
        return getMax() - getMin();
    }

    public final boolean getCollapsed() {
        return this.start == this.end;
    }
}