package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpandablePanelState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0004\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;", "", "initialValue", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;", "isEnableExpand", "", "normalAnchor", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;", "expandedAnchor", "<init>", "(Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;ZLkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;)V", "getNormalAnchor$ui_debug", "()Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;", "getExpandedAnchor$ui_debug", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getAnchoredDraggableState", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "setAnchoredDraggableState", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;)V", "<set-?>", "()Z", "setEnableExpand", "(Z)V", "isEnableExpand$delegate", "Landroidx/compose/runtime/MutableState;", "progress", "", "getProgress", "()F", "Anchor", "Style", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExpandablePanelState {
    public static final int $stable = 0;
    private AnchoredDraggableState<Style> anchoredDraggableState;
    private final Anchor expandedAnchor;
    private final MutableState isEnableExpand$delegate;
    private final Anchor normalAnchor;

    /* compiled from: ExpandablePanelState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Expanded", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Style {
        Normal,
        Expanded;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }
    }

    public ExpandablePanelState(Style initialValue, boolean isEnableExpand, Anchor normalAnchor, Anchor expandedAnchor) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(normalAnchor, "normalAnchor");
        Intrinsics.checkNotNullParameter(expandedAnchor, "expandedAnchor");
        this.normalAnchor = normalAnchor;
        this.expandedAnchor = expandedAnchor;
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue);
        this.isEnableExpand$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isEnableExpand), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ ExpandablePanelState(Style style, boolean z, Anchor anchor, Anchor anchor2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(style, (i & 2) != 0 ? true : z, anchor, anchor2);
    }

    public final Anchor getNormalAnchor$ui_debug() {
        return this.normalAnchor;
    }

    public final Anchor getExpandedAnchor$ui_debug() {
        return this.expandedAnchor;
    }

    /* compiled from: ExpandablePanelState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;", "", "AbsoluteHeight", "PaddingFromTop", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor$AbsoluteHeight;", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor$PaddingFromTop;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Anchor {

        /* compiled from: ExpandablePanelState.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor$AbsoluteHeight;", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;", "height", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor$AbsoluteHeight;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class AbsoluteHeight implements Anchor {
            public static final int $stable = 0;
            private final float height;

            public /* synthetic */ AbsoluteHeight(float f, DefaultConstructorMarker defaultConstructorMarker) {
                this(f);
            }

            /* renamed from: copy-0680j_4$default  reason: not valid java name */
            public static /* synthetic */ AbsoluteHeight m1914copy0680j_4$default(AbsoluteHeight absoluteHeight, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = absoluteHeight.height;
                }
                return absoluteHeight.m1916copy0680j_4(f);
            }

            /* renamed from: component1-D9Ej5fM  reason: not valid java name */
            public final float m1915component1D9Ej5fM() {
                return this.height;
            }

            /* renamed from: copy-0680j_4  reason: not valid java name */
            public final AbsoluteHeight m1916copy0680j_4(float f) {
                return new AbsoluteHeight(f, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AbsoluteHeight) && Dp.equals-impl0(this.height, ((AbsoluteHeight) obj).height);
            }

            public int hashCode() {
                return Dp.hashCode-impl(this.height);
            }

            public String toString() {
                return "AbsoluteHeight(height=" + Dp.toString-impl(this.height) + ")";
            }

            private AbsoluteHeight(float height) {
                this.height = height;
            }

            /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
            public final float m1917getHeightD9Ej5fM() {
                return this.height;
            }
        }

        /* compiled from: ExpandablePanelState.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor$PaddingFromTop;", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor;", "padding", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPadding-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Anchor$PaddingFromTop;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class PaddingFromTop implements Anchor {
            public static final int $stable = 0;
            private final float padding;

            public /* synthetic */ PaddingFromTop(float f, DefaultConstructorMarker defaultConstructorMarker) {
                this(f);
            }

            /* renamed from: copy-0680j_4$default  reason: not valid java name */
            public static /* synthetic */ PaddingFromTop m1918copy0680j_4$default(PaddingFromTop paddingFromTop, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = paddingFromTop.padding;
                }
                return paddingFromTop.m1920copy0680j_4(f);
            }

            /* renamed from: component1-D9Ej5fM  reason: not valid java name */
            public final float m1919component1D9Ej5fM() {
                return this.padding;
            }

            /* renamed from: copy-0680j_4  reason: not valid java name */
            public final PaddingFromTop m1920copy0680j_4(float f) {
                return new PaddingFromTop(f, null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof PaddingFromTop) && Dp.equals-impl0(this.padding, ((PaddingFromTop) obj).padding);
            }

            public int hashCode() {
                return Dp.hashCode-impl(this.padding);
            }

            public String toString() {
                return "PaddingFromTop(padding=" + Dp.toString-impl(this.padding) + ")";
            }

            private PaddingFromTop(float padding) {
                this.padding = padding;
            }

            /* renamed from: getPadding-D9Ej5fM  reason: not valid java name */
            public final float m1921getPaddingD9Ej5fM() {
                return this.padding;
            }
        }
    }

    public final AnchoredDraggableState<Style> getAnchoredDraggableState() {
        return this.anchoredDraggableState;
    }

    public final void setAnchoredDraggableState(AnchoredDraggableState<Style> anchoredDraggableState) {
        Intrinsics.checkNotNullParameter(anchoredDraggableState, "<set-?>");
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public final boolean isEnableExpand() {
        State $this$getValue$iv = this.isEnableExpand$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setEnableExpand(boolean z) {
        MutableState $this$setValue$iv = this.isEnableExpand$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    public final float getProgress() {
        if (isEnableExpand()) {
            return this.anchoredDraggableState.progress(Style.Normal, Style.Expanded);
        }
        return 0.0f;
    }
}