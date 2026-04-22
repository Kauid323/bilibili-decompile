package kntr.common.ouro.core.plugin.textStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroTextStyleState.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0001\u0002\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "displayPanelStyle", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "getDisplayPanelStyle", "()Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "insertTextStyle", "getInsertTextStyle", "Active", "Preview", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState$Active;", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState$Preview;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroTextStyleState extends OuroPluginState {
    OuroTextStyle getDisplayPanelStyle();

    OuroTextStyle getInsertTextStyle();

    /* compiled from: OuroTextStyleState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState$Active;", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState;", "displayPanelStyle", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "insertTextStyle", "<init>", "(Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;)V", "getDisplayPanelStyle", "()Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "getInsertTextStyle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Active implements OuroTextStyleState {
        private final OuroTextStyle displayPanelStyle;
        private final OuroTextStyle insertTextStyle;

        public Active() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Active copy$default(Active active, OuroTextStyle ouroTextStyle, OuroTextStyle ouroTextStyle2, int i, Object obj) {
            if ((i & 1) != 0) {
                ouroTextStyle = active.displayPanelStyle;
            }
            if ((i & 2) != 0) {
                ouroTextStyle2 = active.insertTextStyle;
            }
            return active.copy(ouroTextStyle, ouroTextStyle2);
        }

        public final OuroTextStyle component1() {
            return this.displayPanelStyle;
        }

        public final OuroTextStyle component2() {
            return this.insertTextStyle;
        }

        public final Active copy(OuroTextStyle ouroTextStyle, OuroTextStyle ouroTextStyle2) {
            Intrinsics.checkNotNullParameter(ouroTextStyle, "displayPanelStyle");
            Intrinsics.checkNotNullParameter(ouroTextStyle2, "insertTextStyle");
            return new Active(ouroTextStyle, ouroTextStyle2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Active) {
                Active active = (Active) obj;
                return Intrinsics.areEqual(this.displayPanelStyle, active.displayPanelStyle) && Intrinsics.areEqual(this.insertTextStyle, active.insertTextStyle);
            }
            return false;
        }

        public int hashCode() {
            return (this.displayPanelStyle.hashCode() * 31) + this.insertTextStyle.hashCode();
        }

        public String toString() {
            OuroTextStyle ouroTextStyle = this.displayPanelStyle;
            return "Active(displayPanelStyle=" + ouroTextStyle + ", insertTextStyle=" + this.insertTextStyle + ")";
        }

        public Active(OuroTextStyle displayPanelStyle, OuroTextStyle insertTextStyle) {
            Intrinsics.checkNotNullParameter(displayPanelStyle, "displayPanelStyle");
            Intrinsics.checkNotNullParameter(insertTextStyle, "insertTextStyle");
            this.displayPanelStyle = displayPanelStyle;
            this.insertTextStyle = insertTextStyle;
        }

        public /* synthetic */ Active(OuroTextStyle ouroTextStyle, OuroTextStyle ouroTextStyle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new OuroTextStyle(OuroMarks.Empty.INSTANCE.getTextMarks()) : ouroTextStyle, (i & 2) != 0 ? new OuroTextStyle(OuroMarks.Empty.INSTANCE.getTextMarks()) : ouroTextStyle2);
        }

        @Override // kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState
        public OuroTextStyle getDisplayPanelStyle() {
            return this.displayPanelStyle;
        }

        @Override // kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState
        public OuroTextStyle getInsertTextStyle() {
            return this.insertTextStyle;
        }
    }

    /* compiled from: OuroTextStyleState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0017\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0005\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState$Preview;", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleState;", "displayPanelStyle", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "insertTextStyle", "<init>", "(Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;)V", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "(Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "getDisplayPanelStyle", "()Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "getInsertTextStyle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Preview implements OuroTextStyleState {
        private final OuroTextStyle displayPanelStyle;
        private final OuroTextStyle insertTextStyle;

        public Preview() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Preview copy$default(Preview preview, OuroTextStyle ouroTextStyle, OuroTextStyle ouroTextStyle2, int i, Object obj) {
            if ((i & 1) != 0) {
                ouroTextStyle = preview.displayPanelStyle;
            }
            if ((i & 2) != 0) {
                ouroTextStyle2 = preview.insertTextStyle;
            }
            return preview.copy(ouroTextStyle, ouroTextStyle2);
        }

        public final OuroTextStyle component1() {
            return this.displayPanelStyle;
        }

        public final OuroTextStyle component2() {
            return this.insertTextStyle;
        }

        public final Preview copy(OuroTextStyle ouroTextStyle, OuroTextStyle ouroTextStyle2) {
            Intrinsics.checkNotNullParameter(ouroTextStyle, "displayPanelStyle");
            Intrinsics.checkNotNullParameter(ouroTextStyle2, "insertTextStyle");
            return new Preview(ouroTextStyle, ouroTextStyle2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Preview) {
                Preview preview = (Preview) obj;
                return Intrinsics.areEqual(this.displayPanelStyle, preview.displayPanelStyle) && Intrinsics.areEqual(this.insertTextStyle, preview.insertTextStyle);
            }
            return false;
        }

        public int hashCode() {
            return (this.displayPanelStyle.hashCode() * 31) + this.insertTextStyle.hashCode();
        }

        public String toString() {
            OuroTextStyle ouroTextStyle = this.displayPanelStyle;
            return "Preview(displayPanelStyle=" + ouroTextStyle + ", insertTextStyle=" + this.insertTextStyle + ")";
        }

        public Preview(OuroTextStyle displayPanelStyle, OuroTextStyle insertTextStyle) {
            Intrinsics.checkNotNullParameter(displayPanelStyle, "displayPanelStyle");
            Intrinsics.checkNotNullParameter(insertTextStyle, "insertTextStyle");
            this.displayPanelStyle = displayPanelStyle;
            this.insertTextStyle = insertTextStyle;
        }

        public /* synthetic */ Preview(OuroTextStyle ouroTextStyle, OuroTextStyle ouroTextStyle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new OuroTextStyle(OuroMarks.Empty.INSTANCE.getTextMarks()) : ouroTextStyle, (i & 2) != 0 ? new OuroTextStyle(OuroMarks.Empty.INSTANCE.getTextMarks()) : ouroTextStyle2);
        }

        @Override // kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState
        public OuroTextStyle getDisplayPanelStyle() {
            return this.displayPanelStyle;
        }

        @Override // kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState
        public OuroTextStyle getInsertTextStyle() {
            return this.insertTextStyle;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Preview(OuroMarks<OuroTextMark> ouroMarks) {
            this(new OuroTextStyle(ouroMarks), new OuroTextStyle(ouroMarks));
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        }
    }
}