package kntr.common.ouro.core.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroSelection.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u000b\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\t\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u000fR\u001b\u0010\n\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u000f¨\u0006("}, d2 = {"Lkntr/common/ouro/core/model/OuroSelection;", "", "anchor", "Lkntr/common/ouro/core/model/OuroPoint;", "focus", "<init>", "(Lkntr/common/ouro/core/model/OuroPoint;Lkntr/common/ouro/core/model/OuroPoint;)V", "point", "(Lkntr/common/ouro/core/model/OuroPoint;)V", "start", "end", "isForward", "", "(Lkntr/common/ouro/core/model/OuroPoint;Lkntr/common/ouro/core/model/OuroPoint;Z)V", "getAnchor", "()Lkntr/common/ouro/core/model/OuroPoint;", "getFocus", "isCollapsed", "()Z", "isCollapsed$delegate", "Lkotlin/Lazy;", "isExpanded", "isExpanded$delegate", "isForward$delegate", "isBackward", "isBackward$delegate", "getStart", "start$delegate", "getEnd", "end$delegate", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroSelection {
    public static final Companion Companion = new Companion(null);
    private static final OuroSelection Start = new OuroSelection(OuroPoint.Companion.getZero());
    private final OuroPoint anchor;
    private final Lazy end$delegate;
    private final OuroPoint focus;
    private final Lazy isBackward$delegate;
    private final Lazy isCollapsed$delegate;
    private final Lazy isExpanded$delegate;
    private final Lazy isForward$delegate;
    private final Lazy start$delegate;

    public static /* synthetic */ OuroSelection copy$default(OuroSelection ouroSelection, OuroPoint ouroPoint, OuroPoint ouroPoint2, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroPoint = ouroSelection.anchor;
        }
        if ((i & 2) != 0) {
            ouroPoint2 = ouroSelection.focus;
        }
        return ouroSelection.copy(ouroPoint, ouroPoint2);
    }

    public final OuroPoint component1() {
        return this.anchor;
    }

    public final OuroPoint component2() {
        return this.focus;
    }

    public final OuroSelection copy(OuroPoint ouroPoint, OuroPoint ouroPoint2) {
        Intrinsics.checkNotNullParameter(ouroPoint, "anchor");
        Intrinsics.checkNotNullParameter(ouroPoint2, "focus");
        return new OuroSelection(ouroPoint, ouroPoint2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroSelection) {
            OuroSelection ouroSelection = (OuroSelection) obj;
            return Intrinsics.areEqual(this.anchor, ouroSelection.anchor) && Intrinsics.areEqual(this.focus, ouroSelection.focus);
        }
        return false;
    }

    public int hashCode() {
        return (this.anchor.hashCode() * 31) + this.focus.hashCode();
    }

    public String toString() {
        OuroPoint ouroPoint = this.anchor;
        return "OuroSelection(anchor=" + ouroPoint + ", focus=" + this.focus + ")";
    }

    public OuroSelection(OuroPoint anchor, OuroPoint focus) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(focus, "focus");
        this.anchor = anchor;
        this.focus = focus;
        this.isCollapsed$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroSelection$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean isCollapsed_delegate$lambda$0;
                isCollapsed_delegate$lambda$0 = OuroSelection.isCollapsed_delegate$lambda$0(OuroSelection.this);
                return Boolean.valueOf(isCollapsed_delegate$lambda$0);
            }
        });
        this.isExpanded$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroSelection$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean isExpanded_delegate$lambda$0;
                isExpanded_delegate$lambda$0 = OuroSelection.isExpanded_delegate$lambda$0(OuroSelection.this);
                return Boolean.valueOf(isExpanded_delegate$lambda$0);
            }
        });
        this.isForward$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroSelection$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean isForward_delegate$lambda$0;
                isForward_delegate$lambda$0 = OuroSelection.isForward_delegate$lambda$0(OuroSelection.this);
                return Boolean.valueOf(isForward_delegate$lambda$0);
            }
        });
        this.isBackward$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroSelection$$ExternalSyntheticLambda3
            public final Object invoke() {
                boolean isBackward_delegate$lambda$0;
                isBackward_delegate$lambda$0 = OuroSelection.isBackward_delegate$lambda$0(OuroSelection.this);
                return Boolean.valueOf(isBackward_delegate$lambda$0);
            }
        });
        this.start$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroSelection$$ExternalSyntheticLambda4
            public final Object invoke() {
                OuroPoint start_delegate$lambda$0;
                start_delegate$lambda$0 = OuroSelection.start_delegate$lambda$0(OuroSelection.this);
                return start_delegate$lambda$0;
            }
        });
        this.end$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.OuroSelection$$ExternalSyntheticLambda5
            public final Object invoke() {
                OuroPoint end_delegate$lambda$0;
                end_delegate$lambda$0 = OuroSelection.end_delegate$lambda$0(OuroSelection.this);
                return end_delegate$lambda$0;
            }
        });
    }

    public final OuroPoint getAnchor() {
        return this.anchor;
    }

    public final OuroPoint getFocus() {
        return this.focus;
    }

    /* compiled from: OuroSelection.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/common/ouro/core/model/OuroSelection$Companion;", "", "<init>", "()V", "Start", "Lkntr/common/ouro/core/model/OuroSelection;", "getStart", "()Lkntr/common/ouro/core/model/OuroSelection;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OuroSelection getStart() {
            return OuroSelection.Start;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroSelection(OuroPoint point) {
        this(point, point);
        Intrinsics.checkNotNullParameter(point, "point");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroSelection(OuroPoint start, OuroPoint end, boolean isForward) {
        this(isForward ? start : end, isForward ? end : start);
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCollapsed_delegate$lambda$0(OuroSelection this$0) {
        return Intrinsics.areEqual(this$0.anchor, this$0.focus);
    }

    public final boolean isCollapsed() {
        return ((Boolean) this.isCollapsed$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isExpanded_delegate$lambda$0(OuroSelection this$0) {
        return !this$0.isCollapsed();
    }

    public final boolean isExpanded() {
        return ((Boolean) this.isExpanded$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isForward_delegate$lambda$0(OuroSelection this$0) {
        return this$0.anchor.compareTo(this$0.focus) < 0;
    }

    public final boolean isForward() {
        return ((Boolean) this.isForward$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBackward_delegate$lambda$0(OuroSelection this$0) {
        return this$0.anchor.compareTo(this$0.focus) > 0;
    }

    public final boolean isBackward() {
        return ((Boolean) this.isBackward$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroPoint start_delegate$lambda$0(OuroSelection this$0) {
        return (OuroPoint) ComparisonsKt.minOf(this$0.anchor, this$0.focus);
    }

    public final OuroPoint getStart() {
        return (OuroPoint) this.start$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroPoint end_delegate$lambda$0(OuroSelection this$0) {
        return (OuroPoint) ComparisonsKt.maxOf(this$0.anchor, this$0.focus);
    }

    public final OuroPoint getEnd() {
        return (OuroPoint) this.end$delegate.getValue();
    }
}