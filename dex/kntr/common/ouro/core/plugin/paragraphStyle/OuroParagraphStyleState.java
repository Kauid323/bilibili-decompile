package kntr.common.ouro.core.plugin.paragraphStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignEndMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignJustifyMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignStartMark;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroParagraphStyleState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0015\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r\u0082\u0001\u0002\u0017\u0018¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "type", "Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "getType", "()Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "isTextAlignStart", "", "()Z", "isTextAlignCenter", "isTextAlignEnd", "isTextAlignJustify", "isH1", "isH2", "isH3", "isText", "Active", "Preview", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState$Active;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState$Preview;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroParagraphStyleState extends OuroPluginState {
    OuroMarks<OuroParagraphMark> getMarks();

    ParagraphType getType();

    boolean isH1();

    boolean isH2();

    boolean isH3();

    boolean isText();

    boolean isTextAlignCenter();

    boolean isTextAlignEnd();

    boolean isTextAlignJustify();

    boolean isTextAlignStart();

    /* compiled from: OuroParagraphStyleState.kt */
    /* renamed from: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$isTextAlignStart(OuroParagraphStyleState _this) {
            OuroTextAlignMark mark = (OuroTextAlignMark) _this.getMarks().get(OuroTextAlignMark.Key.INSTANCE);
            return mark == null || Intrinsics.areEqual(mark, OuroTextAlignStartMark.INSTANCE);
        }

        public static boolean $default$isTextAlignCenter(OuroParagraphStyleState _this) {
            return Intrinsics.areEqual(_this.getMarks().get(OuroTextAlignMark.Key.INSTANCE), OuroTextAlignCenterMark.INSTANCE);
        }

        public static boolean $default$isTextAlignEnd(OuroParagraphStyleState _this) {
            return Intrinsics.areEqual(_this.getMarks().get(OuroTextAlignMark.Key.INSTANCE), OuroTextAlignEndMark.INSTANCE);
        }

        public static boolean $default$isTextAlignJustify(OuroParagraphStyleState _this) {
            return Intrinsics.areEqual(_this.getMarks().get(OuroTextAlignMark.Key.INSTANCE), OuroTextAlignJustifyMark.INSTANCE);
        }

        public static boolean $default$isH1(OuroParagraphStyleState _this) {
            return _this.getType() == ParagraphType.H1;
        }

        public static boolean $default$isH2(OuroParagraphStyleState _this) {
            return _this.getType() == ParagraphType.H2;
        }

        public static boolean $default$isH3(OuroParagraphStyleState _this) {
            return _this.getType() == ParagraphType.H3;
        }

        public static boolean $default$isText(OuroParagraphStyleState _this) {
            return _this.getType() == ParagraphType.TEXT;
        }
    }

    /* compiled from: OuroParagraphStyleState.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isTextAlignStart(OuroParagraphStyleState $this) {
            return CC.$default$isTextAlignStart($this);
        }

        @Deprecated
        public static boolean isTextAlignCenter(OuroParagraphStyleState $this) {
            return CC.$default$isTextAlignCenter($this);
        }

        @Deprecated
        public static boolean isTextAlignEnd(OuroParagraphStyleState $this) {
            return CC.$default$isTextAlignEnd($this);
        }

        @Deprecated
        public static boolean isTextAlignJustify(OuroParagraphStyleState $this) {
            return CC.$default$isTextAlignJustify($this);
        }

        @Deprecated
        public static boolean isH1(OuroParagraphStyleState $this) {
            return CC.$default$isH1($this);
        }

        @Deprecated
        public static boolean isH2(OuroParagraphStyleState $this) {
            return CC.$default$isH2($this);
        }

        @Deprecated
        public static boolean isH3(OuroParagraphStyleState $this) {
            return CC.$default$isH3($this);
        }

        @Deprecated
        public static boolean isText(OuroParagraphStyleState $this) {
            return CC.$default$isText($this);
        }
    }

    /* compiled from: OuroParagraphStyleState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState$Active;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "type", "Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;)V", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "getType", "()Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Active implements OuroParagraphStyleState {
        private final OuroMarks<OuroParagraphMark> marks;
        private final ParagraphType type;

        public Active() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Active copy$default(Active active, OuroMarks ouroMarks, ParagraphType paragraphType, int i, Object obj) {
            if ((i & 1) != 0) {
                ouroMarks = active.marks;
            }
            if ((i & 2) != 0) {
                paragraphType = active.type;
            }
            return active.copy(ouroMarks, paragraphType);
        }

        public final OuroMarks<OuroParagraphMark> component1() {
            return this.marks;
        }

        public final ParagraphType component2() {
            return this.type;
        }

        public final Active copy(OuroMarks<OuroParagraphMark> ouroMarks, ParagraphType paragraphType) {
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            return new Active(ouroMarks, paragraphType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Active) {
                Active active = (Active) obj;
                return Intrinsics.areEqual(this.marks, active.marks) && this.type == active.type;
            }
            return false;
        }

        public int hashCode() {
            return (this.marks.hashCode() * 31) + (this.type == null ? 0 : this.type.hashCode());
        }

        public String toString() {
            OuroMarks<OuroParagraphMark> ouroMarks = this.marks;
            return "Active(marks=" + ouroMarks + ", type=" + this.type + ")";
        }

        public Active(OuroMarks<OuroParagraphMark> ouroMarks, ParagraphType type) {
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            this.marks = ouroMarks;
            this.type = type;
        }

        public /* synthetic */ Active(OuroMarks<OuroParagraphMark> ouroMarks, ParagraphType paragraphType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? OuroMarks.Empty.INSTANCE.getParagraphMarks() : ouroMarks, (i & 2) != 0 ? null : paragraphType);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isH1() {
            return CC.$default$isH1(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isH2() {
            return CC.$default$isH2(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isH3() {
            return CC.$default$isH3(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isText() {
            return CC.$default$isText(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignCenter() {
            return CC.$default$isTextAlignCenter(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignEnd() {
            return CC.$default$isTextAlignEnd(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignJustify() {
            return CC.$default$isTextAlignJustify(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignStart() {
            return CC.$default$isTextAlignStart(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public OuroMarks<OuroParagraphMark> getMarks() {
            return this.marks;
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public ParagraphType getType() {
            return this.type;
        }
    }

    /* compiled from: OuroParagraphStyleState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState$Preview;", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroParagraphStyleState;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "type", "Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;)V", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "getType", "()Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Preview implements OuroParagraphStyleState {
        private final OuroMarks<OuroParagraphMark> marks;
        private final ParagraphType type;

        public Preview() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Preview copy$default(Preview preview, OuroMarks ouroMarks, ParagraphType paragraphType, int i, Object obj) {
            if ((i & 1) != 0) {
                ouroMarks = preview.marks;
            }
            if ((i & 2) != 0) {
                paragraphType = preview.type;
            }
            return preview.copy(ouroMarks, paragraphType);
        }

        public final OuroMarks<OuroParagraphMark> component1() {
            return this.marks;
        }

        public final ParagraphType component2() {
            return this.type;
        }

        public final Preview copy(OuroMarks<OuroParagraphMark> ouroMarks, ParagraphType paragraphType) {
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            Intrinsics.checkNotNullParameter(paragraphType, "type");
            return new Preview(ouroMarks, paragraphType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Preview) {
                Preview preview = (Preview) obj;
                return Intrinsics.areEqual(this.marks, preview.marks) && this.type == preview.type;
            }
            return false;
        }

        public int hashCode() {
            return (this.marks.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            OuroMarks<OuroParagraphMark> ouroMarks = this.marks;
            return "Preview(marks=" + ouroMarks + ", type=" + this.type + ")";
        }

        public Preview(OuroMarks<OuroParagraphMark> ouroMarks, ParagraphType type) {
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            Intrinsics.checkNotNullParameter(type, "type");
            this.marks = ouroMarks;
            this.type = type;
        }

        public /* synthetic */ Preview(OuroMarks<OuroParagraphMark> ouroMarks, ParagraphType paragraphType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? OuroMarks.Empty.INSTANCE.getParagraphMarks() : ouroMarks, (i & 2) != 0 ? ParagraphType.TEXT : paragraphType);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isH1() {
            return CC.$default$isH1(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isH2() {
            return CC.$default$isH2(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isH3() {
            return CC.$default$isH3(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isText() {
            return CC.$default$isText(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignCenter() {
            return CC.$default$isTextAlignCenter(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignEnd() {
            return CC.$default$isTextAlignEnd(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignJustify() {
            return CC.$default$isTextAlignJustify(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public /* bridge */ boolean isTextAlignStart() {
            return CC.$default$isTextAlignStart(this);
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public OuroMarks<OuroParagraphMark> getMarks() {
            return this.marks;
        }

        @Override // kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStyleState
        public ParagraphType getType() {
            return this.type;
        }
    }
}