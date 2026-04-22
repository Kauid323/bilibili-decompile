package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroParagraphMark.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0006012345B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J8\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00066"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle;", "", "alignment", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Alignment;", "trim", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Trim;", "mode", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Mode;", "unit", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Unit;", "<init>", "(FLkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Trim;Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Mode;Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Unit;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Alignment;Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Trim;Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Mode;Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Unit;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PqGQbD4", "()F", "F", "getTrim", "()Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Trim;", "getMode", "()Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Mode;", "getUnit", "()Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Unit;", "component1", "component1-PqGQbD4", "component2", "component3", "component4", "copy", "copy-M-i2REQ", "(FLkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Trim;Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Mode;Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Unit;)Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Companion", "Alignment", "Trim", "Mode", "Unit", "$serializer", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroLineHeightStyle {
    private final float alignment;
    private final Mode mode;
    private final Trim trim;
    private final Unit unit;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroLineHeightStyle$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = OuroLineHeightStyle._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroLineHeightStyle$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = OuroLineHeightStyle._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroLineHeightStyle$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = OuroLineHeightStyle._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};
    private static final OuroLineHeightStyle Default = new OuroLineHeightStyle(0.0f, (Trim) null, (Mode) null, (Unit) null, 15, (DefaultConstructorMarker) null);

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "Fixed", "Minimum", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Mode {
        Fixed,
        Minimum;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Trim;", "", "<init>", "(Ljava/lang/String;I)V", "FirstLineTop", "LastLineBottom", "Both", "None", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Trim {
        FirstLineTop,
        LastLineBottom,
        Both,
        None;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Trim> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Unit;", "", "<init>", "(Ljava/lang/String;I)V", "DP", "FACTOR", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum Unit {
        DP,
        FACTOR;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Unit> getEntries() {
            return $ENTRIES;
        }
    }

    public /* synthetic */ OuroLineHeightStyle(float f, Trim trim, Mode mode, Unit unit, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, trim, mode, unit);
    }

    public /* synthetic */ OuroLineHeightStyle(int i, Alignment alignment, Trim trim, Mode mode, Unit unit, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, alignment, trim, mode, unit, serializationConstructorMarker);
    }

    /* renamed from: copy-M-i2REQ$default  reason: not valid java name */
    public static /* synthetic */ OuroLineHeightStyle m1965copyMi2REQ$default(OuroLineHeightStyle ouroLineHeightStyle, float f, Trim trim, Mode mode, Unit unit, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ouroLineHeightStyle.alignment;
        }
        if ((i & 2) != 0) {
            trim = ouroLineHeightStyle.trim;
        }
        if ((i & 4) != 0) {
            mode = ouroLineHeightStyle.mode;
        }
        if ((i & 8) != 0) {
            unit = ouroLineHeightStyle.unit;
        }
        return ouroLineHeightStyle.m1967copyMi2REQ(f, trim, mode, unit);
    }

    /* renamed from: component1-PqGQbD4  reason: not valid java name */
    public final float m1966component1PqGQbD4() {
        return this.alignment;
    }

    public final Trim component2() {
        return this.trim;
    }

    public final Mode component3() {
        return this.mode;
    }

    public final Unit component4() {
        return this.unit;
    }

    /* renamed from: copy-M-i2REQ  reason: not valid java name */
    public final OuroLineHeightStyle m1967copyMi2REQ(float f, Trim trim, Mode mode, Unit unit) {
        Intrinsics.checkNotNullParameter(trim, "trim");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new OuroLineHeightStyle(f, trim, mode, unit, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroLineHeightStyle) {
            OuroLineHeightStyle ouroLineHeightStyle = (OuroLineHeightStyle) obj;
            return Alignment.m1976equalsimpl0(this.alignment, ouroLineHeightStyle.alignment) && this.trim == ouroLineHeightStyle.trim && this.mode == ouroLineHeightStyle.mode && this.unit == ouroLineHeightStyle.unit;
        }
        return false;
    }

    public int hashCode() {
        return (((((Alignment.m1977hashCodeimpl(this.alignment) * 31) + this.trim.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.unit.hashCode();
    }

    public String toString() {
        String m1978toStringimpl = Alignment.m1978toStringimpl(this.alignment);
        Trim trim = this.trim;
        Mode mode = this.mode;
        return "OuroLineHeightStyle(alignment=" + m1978toStringimpl + ", trim=" + trim + ", mode=" + mode + ", unit=" + this.unit + ")";
    }

    private OuroLineHeightStyle(float alignment, Trim trim, Mode mode, Unit unit) {
        Intrinsics.checkNotNullParameter(trim, "trim");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.alignment = alignment;
        this.trim = trim;
        this.mode = mode;
        this.unit = unit;
    }

    private /* synthetic */ OuroLineHeightStyle(int seen0, Alignment alignment, Trim trim, Mode mode, Unit unit, SerializationConstructorMarker serializationConstructorMarker) {
        this.alignment = (seen0 & 1) == 0 ? Alignment.Companion.m1983getProportionalPqGQbD4() : alignment.m1979unboximpl();
        if ((seen0 & 2) == 0) {
            this.trim = Trim.None;
        } else {
            this.trim = trim;
        }
        if ((seen0 & 4) == 0) {
            this.mode = Mode.Minimum;
        } else {
            this.mode = mode;
        }
        if ((seen0 & 8) == 0) {
            this.unit = Unit.DP;
        } else {
            this.unit = unit;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("kntr.common.ouro.core.model.mark.OuroLineHeightStyle.Trim", Trim.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createSimpleEnumSerializer("kntr.common.ouro.core.model.mark.OuroLineHeightStyle.Mode", Mode.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return EnumsKt.createSimpleEnumSerializer("kntr.common.ouro.core.model.mark.OuroLineHeightStyle.Unit", Unit.values());
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroLineHeightStyle self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Alignment.m1976equalsimpl0(self.alignment, Alignment.Companion.m1983getProportionalPqGQbD4())) {
            output.encodeSerializableElement(serialDesc, 0, OuroLineHeightStyle$Alignment$$serializer.INSTANCE, Alignment.m1973boximpl(self.alignment));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.trim != Trim.None) {
            output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.trim);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.mode != Mode.Minimum) {
            output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.mode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.unit != Unit.DP) {
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.unit);
        }
    }

    public /* synthetic */ OuroLineHeightStyle(float f, Trim trim, Mode mode, Unit unit, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Alignment.Companion.m1983getProportionalPqGQbD4() : f, (i & 2) != 0 ? Trim.None : trim, (i & 4) != 0 ? Mode.Minimum : mode, (i & 8) != 0 ? Unit.DP : unit, null);
    }

    /* renamed from: getAlignment-PqGQbD4  reason: not valid java name */
    public final float m1968getAlignmentPqGQbD4() {
        return this.alignment;
    }

    public final Trim getTrim() {
        return this.trim;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final Unit getUnit() {
        return this.unit;
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Companion;", "", "<init>", "()V", "Default", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle;", "getDefault", "()Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle;", "serializer", "Lkotlinx/serialization/KSerializer;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroLineHeightStyle> serializer() {
            return OuroLineHeightStyle$$serializer.INSTANCE;
        }

        public final OuroLineHeightStyle getDefault() {
            return OuroLineHeightStyle.Default;
        }
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "getTopRatio", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "$serializer", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    @JvmInline
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Alignment {
        private final float topRatio;
        public static final Companion Companion = new Companion(null);
        private static final float Top = m1974constructorimpl(0.0f);
        private static final float Center = m1974constructorimpl(0.5f);
        private static final float Bottom = m1974constructorimpl(1.0f);
        private static final float Proportional = m1974constructorimpl(-1.0f);

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Alignment m1973boximpl(float f) {
            return new Alignment(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: constructor-impl  reason: not valid java name */
        public static float m1974constructorimpl(float f) {
            return f;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m1975equalsimpl(float f, Object obj) {
            return (obj instanceof Alignment) && Float.compare(f, ((Alignment) obj).m1979unboximpl()) == 0;
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1976equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m1977hashCodeimpl(float f) {
            return Float.floatToIntBits(f);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m1978toStringimpl(float f) {
            return "Alignment(topRatio=" + f + ")";
        }

        public boolean equals(Object obj) {
            return m1975equalsimpl(this.topRatio, obj);
        }

        public int hashCode() {
            return m1977hashCodeimpl(this.topRatio);
        }

        public String toString() {
            return m1978toStringimpl(this.topRatio);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ float m1979unboximpl() {
            return this.topRatio;
        }

        private /* synthetic */ Alignment(float topRatio) {
            this.topRatio = topRatio;
        }

        public final float getTopRatio() {
            return this.topRatio;
        }

        /* compiled from: OuroParagraphMark.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0016"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Alignment$Companion;", "", "<init>", "()V", "Top", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle$Alignment;", "getTop-PqGQbD4", "()F", "F", "Center", "getCenter-PqGQbD4", "Bottom", "getBottom-PqGQbD4", "Proportional", "getProportional-PqGQbD4", "fromRatio", "ratio", "", "fromRatio-xJrq4TY", "(F)F", "serializer", "Lkotlinx/serialization/KSerializer;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Alignment> serializer() {
                return OuroLineHeightStyle$Alignment$$serializer.INSTANCE;
            }

            /* renamed from: getTop-PqGQbD4  reason: not valid java name */
            public final float m1984getTopPqGQbD4() {
                return Alignment.Top;
            }

            /* renamed from: getCenter-PqGQbD4  reason: not valid java name */
            public final float m1982getCenterPqGQbD4() {
                return Alignment.Center;
            }

            /* renamed from: getBottom-PqGQbD4  reason: not valid java name */
            public final float m1981getBottomPqGQbD4() {
                return Alignment.Bottom;
            }

            /* renamed from: getProportional-PqGQbD4  reason: not valid java name */
            public final float m1983getProportionalPqGQbD4() {
                return Alignment.Proportional;
            }

            /* renamed from: fromRatio-xJrq4TY  reason: not valid java name */
            public final float m1980fromRatioxJrq4TY(float ratio) {
                return Alignment.m1974constructorimpl(RangesKt.coerceIn(ratio, 0.0f, 1.0f));
            }
        }
    }
}