package kntr.common.ouro.core.model.mark;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroDrawableMark.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00052\u00020\u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0005\u0006\u0007\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$Override;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Padding", "Size", "Companion", "Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroBoxContainerMark;", "Lkntr/common/ouro/core/model/mark/OuroColumnContainerMark;", "Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroRowContainerMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface OuroDrawableMark extends OuroMark.Override, OuroMark.BuiltIn {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: OuroDrawableMark.kt */
    /* renamed from: kntr.common.ouro.core.model.mark.OuroDrawableMark$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = OuroDrawableMark.Companion;
        }
    }

    /* compiled from: OuroDrawableMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<OuroDrawableMark> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.mark.OuroDrawableMark", Reflection.getOrCreateKotlinClass(OuroDrawableMark.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroBackgroundColorMark.class), Reflection.getOrCreateKotlinClass(Padding.class), Reflection.getOrCreateKotlinClass(Size.AspectRatio.class), Reflection.getOrCreateKotlinClass(Size.BiliBlockImageSize.class), Reflection.getOrCreateKotlinClass(Size.FillWidth.class), Reflection.getOrCreateKotlinClass(Size.ScaledByFontSize.class), Reflection.getOrCreateKotlinClass(Size.Specified.class), Reflection.getOrCreateKotlinClass(Padding.class), Reflection.getOrCreateKotlinClass(Size.AspectRatio.class), Reflection.getOrCreateKotlinClass(Size.BiliBlockImageSize.class), Reflection.getOrCreateKotlinClass(Size.FillWidth.class), Reflection.getOrCreateKotlinClass(Size.ScaledByFontSize.class), Reflection.getOrCreateKotlinClass(Size.Specified.class), Reflection.getOrCreateKotlinClass(OuroForegroundColorMark.class), Reflection.getOrCreateKotlinClass(Padding.class), Reflection.getOrCreateKotlinClass(Size.AspectRatio.class), Reflection.getOrCreateKotlinClass(Size.BiliBlockImageSize.class), Reflection.getOrCreateKotlinClass(Size.FillWidth.class), Reflection.getOrCreateKotlinClass(Size.ScaledByFontSize.class), Reflection.getOrCreateKotlinClass(Size.Specified.class)}, new KSerializer[]{OuroBackgroundColorMark$$serializer.INSTANCE, OuroDrawableMark$Padding$$serializer.INSTANCE, OuroDrawableMark$Size$AspectRatio$$serializer.INSTANCE, OuroDrawableMark$Size$BiliBlockImageSize$$serializer.INSTANCE, OuroDrawableMark$Size$FillWidth$$serializer.INSTANCE, OuroDrawableMark$Size$ScaledByFontSize$$serializer.INSTANCE, OuroDrawableMark$Size$Specified$$serializer.INSTANCE, OuroDrawableMark$Padding$$serializer.INSTANCE, OuroDrawableMark$Size$AspectRatio$$serializer.INSTANCE, OuroDrawableMark$Size$BiliBlockImageSize$$serializer.INSTANCE, OuroDrawableMark$Size$FillWidth$$serializer.INSTANCE, OuroDrawableMark$Size$ScaledByFontSize$$serializer.INSTANCE, OuroDrawableMark$Size$Specified$$serializer.INSTANCE, OuroForegroundColorMark$$serializer.INSTANCE, OuroDrawableMark$Padding$$serializer.INSTANCE, OuroDrawableMark$Size$AspectRatio$$serializer.INSTANCE, OuroDrawableMark$Size$BiliBlockImageSize$$serializer.INSTANCE, OuroDrawableMark$Size$FillWidth$$serializer.INSTANCE, OuroDrawableMark$Size$ScaledByFontSize$$serializer.INSTANCE, OuroDrawableMark$Size$Specified$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    /* compiled from: OuroDrawableMark.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static MergeRule.Override getMergeRule(OuroDrawableMark $this) {
            return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) $this);
        }
    }

    /* compiled from: OuroDrawableMark.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u0003567B/\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\fB\u001d\b\u0016\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u000fB;\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\t\u0010\u0014J\u0011\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005H\u0086\u0002J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J1\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0011HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00068"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding;", "Lkntr/common/ouro/core/model/mark/OuroBoxContainerMark;", "Lkntr/common/ouro/core/model/mark/OuroRowContainerMark;", "Lkntr/common/ouro/core/model/mark/OuroColumnContainerMark;", "left", "", "right", "top", "bottom", "<init>", "(FFFF)V", "all", "(F)V", "horizontal", "vertical", "(FF)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFFFFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLeft", "()F", "getRight", "getTop", "getBottom", "key", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "times", "factor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Key", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Padding implements OuroBoxContainerMark, OuroRowContainerMark, OuroColumnContainerMark {
        public static final Companion Companion = new Companion(null);
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public Padding() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Padding copy$default(Padding padding, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = padding.left;
            }
            if ((i & 2) != 0) {
                f2 = padding.right;
            }
            if ((i & 4) != 0) {
                f3 = padding.top;
            }
            if ((i & 8) != 0) {
                f4 = padding.bottom;
            }
            return padding.copy(f, f2, f3, f4);
        }

        public final float component1() {
            return this.left;
        }

        public final float component2() {
            return this.right;
        }

        public final float component3() {
            return this.top;
        }

        public final float component4() {
            return this.bottom;
        }

        public final Padding copy(float f, float f2, float f3, float f4) {
            return new Padding(f, f2, f3, f4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Padding) {
                Padding padding = (Padding) obj;
                return Float.compare(this.left, padding.left) == 0 && Float.compare(this.right, padding.right) == 0 && Float.compare(this.top, padding.top) == 0 && Float.compare(this.bottom, padding.bottom) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.bottom);
        }

        public String toString() {
            float f = this.left;
            float f2 = this.right;
            float f3 = this.top;
            return "Padding(left=" + f + ", right=" + f2 + ", top=" + f3 + ", bottom=" + this.bottom + ")";
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Padding> serializer() {
                return OuroDrawableMark$Padding$$serializer.INSTANCE;
            }
        }

        public Padding(float left, float right, float top, float bottom) {
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
        }

        public /* synthetic */ Padding(int seen0, float left, float right, float top, float bottom, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.left = 0.0f;
            } else {
                this.left = left;
            }
            if ((seen0 & 2) == 0) {
                this.right = 0.0f;
            } else {
                this.right = right;
            }
            if ((seen0 & 4) == 0) {
                this.top = 0.0f;
            } else {
                this.top = top;
            }
            if ((seen0 & 8) == 0) {
                this.bottom = 0.0f;
            } else {
                this.bottom = bottom;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(Padding self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || Float.compare(self.left, 0.0f) != 0) {
                output.encodeFloatElement(serialDesc, 0, self.left);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || Float.compare(self.right, 0.0f) != 0) {
                output.encodeFloatElement(serialDesc, 1, self.right);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || Float.compare(self.top, 0.0f) != 0) {
                output.encodeFloatElement(serialDesc, 2, self.top);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || Float.compare(self.bottom, 0.0f) != 0) {
                output.encodeFloatElement(serialDesc, 3, self.bottom);
            }
        }

        @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
        public /* bridge */ MergeRule.Override getMergeRule() {
            return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
        }

        public /* synthetic */ Padding(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3, (i & 8) != 0 ? 0.0f : f4);
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getTop() {
            return this.top;
        }

        public final float getBottom() {
            return this.bottom;
        }

        public Padding(float all) {
            this(all, all, all, all);
        }

        public Padding(float horizontal, float vertical) {
            this(horizontal, horizontal, vertical, vertical);
        }

        public /* synthetic */ Padding(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Key implements OuroMark.Key<Padding> {
            public static final Key INSTANCE = new Key();

            private Key() {
            }
        }

        @Override // kntr.common.ouro.core.model.mark.OuroMark
        public OuroMark.Key<? extends OuroDrawableMark> getKey() {
            return Key.INSTANCE;
        }

        public final Padding times(float factor) {
            return copy(this.left * factor, this.right * factor, this.top * factor, this.bottom * factor);
        }
    }

    /* compiled from: OuroDrawableMark.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0007\b\t\n\u000b\f\r\u000eR\u001c\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "Lkntr/common/ouro/core/model/mark/OuroBoxContainerMark;", "Lkntr/common/ouro/core/model/mark/OuroRowContainerMark;", "Lkntr/common/ouro/core/model/mark/OuroColumnContainerMark;", "key", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Key", "Specified", "AspectRatio", "FillWidth", "ScaledByFontSize", "BiliBlockImageSize", "Companion", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$AspectRatio;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$BiliBlockImageSize;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$FillWidth;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$ScaledByFontSize;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$Specified;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Size extends OuroBoxContainerMark, OuroRowContainerMark, OuroColumnContainerMark {
        public static final Companion Companion = Companion.$$INSTANCE;

        @Override // kntr.common.ouro.core.model.mark.OuroMark
        OuroMark.Key<? extends Size> getKey();

        /* compiled from: OuroDrawableMark.kt */
        /* renamed from: kntr.common.ouro.core.model.mark.OuroDrawableMark$Size$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            static {
                Companion companion = Size.Companion;
            }

            public static OuroMark.Key $default$getKey(Size _this) {
                return Key.INSTANCE;
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Size> serializer() {
                return new SealedClassSerializer<>("kntr.common.ouro.core.model.mark.OuroDrawableMark.Size", Reflection.getOrCreateKotlinClass(Size.class), new KClass[]{Reflection.getOrCreateKotlinClass(AspectRatio.class), Reflection.getOrCreateKotlinClass(BiliBlockImageSize.class), Reflection.getOrCreateKotlinClass(FillWidth.class), Reflection.getOrCreateKotlinClass(ScaledByFontSize.class), Reflection.getOrCreateKotlinClass(Specified.class)}, new KSerializer[]{OuroDrawableMark$Size$AspectRatio$$serializer.INSTANCE, OuroDrawableMark$Size$BiliBlockImageSize$$serializer.INSTANCE, OuroDrawableMark$Size$FillWidth$$serializer.INSTANCE, OuroDrawableMark$Size$ScaledByFontSize$$serializer.INSTANCE, OuroDrawableMark$Size$Specified$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static MergeRule.Override getMergeRule(Size $this) {
                return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) $this);
            }

            @Deprecated
            public static OuroMark.Key<? extends Size> getKey(Size $this) {
                return CC.$default$getKey($this);
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Key implements OuroMark.Key<Size> {
            public static final Key INSTANCE = new Key();

            private Key() {
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006#"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$Specified;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "width", "", "height", "<init>", "(FF)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWidth", "()F", "getHeight", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Specified implements Size {
            public static final Companion Companion = new Companion(null);
            private final float height;
            private final float width;

            public static /* synthetic */ Specified copy$default(Specified specified, float f, float f2, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = specified.width;
                }
                if ((i & 2) != 0) {
                    f2 = specified.height;
                }
                return specified.copy(f, f2);
            }

            public final float component1() {
                return this.width;
            }

            public final float component2() {
                return this.height;
            }

            public final Specified copy(float f, float f2) {
                return new Specified(f, f2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Specified) {
                    Specified specified = (Specified) obj;
                    return Float.compare(this.width, specified.width) == 0 && Float.compare(this.height, specified.height) == 0;
                }
                return false;
            }

            public int hashCode() {
                return (Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.height);
            }

            public String toString() {
                float f = this.width;
                return "Specified(width=" + f + ", height=" + this.height + ")";
            }

            /* compiled from: OuroDrawableMark.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$Specified$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$Specified;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Specified> serializer() {
                    return OuroDrawableMark$Size$Specified$$serializer.INSTANCE;
                }
            }

            public Specified(float width, float height) {
                this.width = width;
                this.height = height;
            }

            public /* synthetic */ Specified(int seen0, float width, float height, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (seen0 & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(seen0, 3, OuroDrawableMark$Size$Specified$$serializer.INSTANCE.getDescriptor());
                }
                this.width = width;
                this.height = height;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$core_debug(Specified self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeFloatElement(serialDesc, 0, self.width);
                output.encodeFloatElement(serialDesc, 1, self.height);
            }

            @Override // kntr.common.ouro.core.model.mark.OuroDrawableMark.Size, kntr.common.ouro.core.model.mark.OuroMark
            public /* bridge */ OuroMark.Key<? extends Size> getKey() {
                return CC.$default$getKey(this);
            }

            @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
            public /* bridge */ MergeRule.Override getMergeRule() {
                return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
            }

            public final float getWidth() {
                return this.width;
            }

            public final float getHeight() {
                return this.height;
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$AspectRatio;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "aspectRatio", "", "<init>", "(F)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAspectRatio", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class AspectRatio implements Size {
            public static final Companion Companion = new Companion(null);
            private final float aspectRatio;

            public static /* synthetic */ AspectRatio copy$default(AspectRatio aspectRatio, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = aspectRatio.aspectRatio;
                }
                return aspectRatio.copy(f);
            }

            public final float component1() {
                return this.aspectRatio;
            }

            public final AspectRatio copy(float f) {
                return new AspectRatio(f);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AspectRatio) && Float.compare(this.aspectRatio, ((AspectRatio) obj).aspectRatio) == 0;
            }

            public int hashCode() {
                return Float.floatToIntBits(this.aspectRatio);
            }

            public String toString() {
                return "AspectRatio(aspectRatio=" + this.aspectRatio + ")";
            }

            /* compiled from: OuroDrawableMark.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$AspectRatio$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$AspectRatio;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<AspectRatio> serializer() {
                    return OuroDrawableMark$Size$AspectRatio$$serializer.INSTANCE;
                }
            }

            public AspectRatio(float aspectRatio) {
                this.aspectRatio = aspectRatio;
            }

            public /* synthetic */ AspectRatio(int seen0, float aspectRatio, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (seen0 & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroDrawableMark$Size$AspectRatio$$serializer.INSTANCE.getDescriptor());
                }
                this.aspectRatio = aspectRatio;
            }

            @Override // kntr.common.ouro.core.model.mark.OuroDrawableMark.Size, kntr.common.ouro.core.model.mark.OuroMark
            public /* bridge */ OuroMark.Key<? extends Size> getKey() {
                return CC.$default$getKey(this);
            }

            @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
            public /* bridge */ MergeRule.Override getMergeRule() {
                return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
            }

            public final float getAspectRatio() {
                return this.aspectRatio;
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$FillWidth;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "height", "", "<init>", "(F)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHeight", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class FillWidth implements Size {
            public static final Companion Companion = new Companion(null);
            private final float height;

            public static /* synthetic */ FillWidth copy$default(FillWidth fillWidth, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = fillWidth.height;
                }
                return fillWidth.copy(f);
            }

            public final float component1() {
                return this.height;
            }

            public final FillWidth copy(float f) {
                return new FillWidth(f);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FillWidth) && Float.compare(this.height, ((FillWidth) obj).height) == 0;
            }

            public int hashCode() {
                return Float.floatToIntBits(this.height);
            }

            public String toString() {
                return "FillWidth(height=" + this.height + ")";
            }

            /* compiled from: OuroDrawableMark.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$FillWidth$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$FillWidth;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<FillWidth> serializer() {
                    return OuroDrawableMark$Size$FillWidth$$serializer.INSTANCE;
                }
            }

            public FillWidth(float height) {
                this.height = height;
            }

            public /* synthetic */ FillWidth(int seen0, float height, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (seen0 & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroDrawableMark$Size$FillWidth$$serializer.INSTANCE.getDescriptor());
                }
                this.height = height;
            }

            @Override // kntr.common.ouro.core.model.mark.OuroDrawableMark.Size, kntr.common.ouro.core.model.mark.OuroMark
            public /* bridge */ OuroMark.Key<? extends Size> getKey() {
                return CC.$default$getKey(this);
            }

            @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
            public /* bridge */ MergeRule.Override getMergeRule() {
                return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
            }

            public final float getHeight() {
                return this.height;
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006)"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$ScaledByFontSize;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "widthScale", "", "heightScale", "widthModifier", "heightModifier", "<init>", "(FFFF)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFFFFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWidthScale", "()F", "getHeightScale", "getWidthModifier", "getHeightModifier", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ScaledByFontSize implements Size {
            public static final Companion Companion = new Companion(null);
            private final float heightModifier;
            private final float heightScale;
            private final float widthModifier;
            private final float widthScale;

            public static /* synthetic */ ScaledByFontSize copy$default(ScaledByFontSize scaledByFontSize, float f, float f2, float f3, float f4, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = scaledByFontSize.widthScale;
                }
                if ((i & 2) != 0) {
                    f2 = scaledByFontSize.heightScale;
                }
                if ((i & 4) != 0) {
                    f3 = scaledByFontSize.widthModifier;
                }
                if ((i & 8) != 0) {
                    f4 = scaledByFontSize.heightModifier;
                }
                return scaledByFontSize.copy(f, f2, f3, f4);
            }

            public final float component1() {
                return this.widthScale;
            }

            public final float component2() {
                return this.heightScale;
            }

            public final float component3() {
                return this.widthModifier;
            }

            public final float component4() {
                return this.heightModifier;
            }

            public final ScaledByFontSize copy(float f, float f2, float f3, float f4) {
                return new ScaledByFontSize(f, f2, f3, f4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ScaledByFontSize) {
                    ScaledByFontSize scaledByFontSize = (ScaledByFontSize) obj;
                    return Float.compare(this.widthScale, scaledByFontSize.widthScale) == 0 && Float.compare(this.heightScale, scaledByFontSize.heightScale) == 0 && Float.compare(this.widthModifier, scaledByFontSize.widthModifier) == 0 && Float.compare(this.heightModifier, scaledByFontSize.heightModifier) == 0;
                }
                return false;
            }

            public int hashCode() {
                return (((((Float.floatToIntBits(this.widthScale) * 31) + Float.floatToIntBits(this.heightScale)) * 31) + Float.floatToIntBits(this.widthModifier)) * 31) + Float.floatToIntBits(this.heightModifier);
            }

            public String toString() {
                float f = this.widthScale;
                float f2 = this.heightScale;
                float f3 = this.widthModifier;
                return "ScaledByFontSize(widthScale=" + f + ", heightScale=" + f2 + ", widthModifier=" + f3 + ", heightModifier=" + this.heightModifier + ")";
            }

            /* compiled from: OuroDrawableMark.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$ScaledByFontSize$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$ScaledByFontSize;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ScaledByFontSize> serializer() {
                    return OuroDrawableMark$Size$ScaledByFontSize$$serializer.INSTANCE;
                }
            }

            public ScaledByFontSize(float widthScale, float heightScale, float widthModifier, float heightModifier) {
                this.widthScale = widthScale;
                this.heightScale = heightScale;
                this.widthModifier = widthModifier;
                this.heightModifier = heightModifier;
            }

            public /* synthetic */ ScaledByFontSize(int seen0, float widthScale, float heightScale, float widthModifier, float heightModifier, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (seen0 & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(seen0, 3, OuroDrawableMark$Size$ScaledByFontSize$$serializer.INSTANCE.getDescriptor());
                }
                this.widthScale = widthScale;
                this.heightScale = heightScale;
                if ((seen0 & 4) == 0) {
                    this.widthModifier = 0.0f;
                } else {
                    this.widthModifier = widthModifier;
                }
                if ((seen0 & 8) == 0) {
                    this.heightModifier = 0.0f;
                } else {
                    this.heightModifier = heightModifier;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$core_debug(ScaledByFontSize self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeFloatElement(serialDesc, 0, self.widthScale);
                output.encodeFloatElement(serialDesc, 1, self.heightScale);
                if (output.shouldEncodeElementDefault(serialDesc, 2) || Float.compare(self.widthModifier, 0.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 2, self.widthModifier);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || Float.compare(self.heightModifier, 0.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 3, self.heightModifier);
                }
            }

            @Override // kntr.common.ouro.core.model.mark.OuroDrawableMark.Size, kntr.common.ouro.core.model.mark.OuroMark
            public /* bridge */ OuroMark.Key<? extends Size> getKey() {
                return CC.$default$getKey(this);
            }

            @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
            public /* bridge */ MergeRule.Override getMergeRule() {
                return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
            }

            public /* synthetic */ ScaledByFontSize(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(f, f2, (i & 4) != 0 ? 0.0f : f3, (i & 8) != 0 ? 0.0f : f4);
            }

            public final float getWidthScale() {
                return this.widthScale;
            }

            public final float getHeightScale() {
                return this.heightScale;
            }

            public final float getWidthModifier() {
                return this.widthModifier;
            }

            public final float getHeightModifier() {
                return this.heightModifier;
            }
        }

        /* compiled from: OuroDrawableMark.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\""}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$BiliBlockImageSize;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "imageWidth", "", "imageHeight", "<init>", "(II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageWidth", "()I", "getImageHeight", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class BiliBlockImageSize implements Size {
            public static final Companion Companion = new Companion(null);
            private final int imageHeight;
            private final int imageWidth;

            public static /* synthetic */ BiliBlockImageSize copy$default(BiliBlockImageSize biliBlockImageSize, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = biliBlockImageSize.imageWidth;
                }
                if ((i3 & 2) != 0) {
                    i2 = biliBlockImageSize.imageHeight;
                }
                return biliBlockImageSize.copy(i, i2);
            }

            public final int component1() {
                return this.imageWidth;
            }

            public final int component2() {
                return this.imageHeight;
            }

            public final BiliBlockImageSize copy(int i, int i2) {
                return new BiliBlockImageSize(i, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BiliBlockImageSize) {
                    BiliBlockImageSize biliBlockImageSize = (BiliBlockImageSize) obj;
                    return this.imageWidth == biliBlockImageSize.imageWidth && this.imageHeight == biliBlockImageSize.imageHeight;
                }
                return false;
            }

            public int hashCode() {
                return (this.imageWidth * 31) + this.imageHeight;
            }

            public String toString() {
                int i = this.imageWidth;
                return "BiliBlockImageSize(imageWidth=" + i + ", imageHeight=" + this.imageHeight + ")";
            }

            /* compiled from: OuroDrawableMark.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$BiliBlockImageSize$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$BiliBlockImageSize;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<BiliBlockImageSize> serializer() {
                    return OuroDrawableMark$Size$BiliBlockImageSize$$serializer.INSTANCE;
                }
            }

            public BiliBlockImageSize(int imageWidth, int imageHeight) {
                this.imageWidth = imageWidth;
                this.imageHeight = imageHeight;
            }

            public /* synthetic */ BiliBlockImageSize(int seen0, int imageWidth, int imageHeight, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (seen0 & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(seen0, 3, OuroDrawableMark$Size$BiliBlockImageSize$$serializer.INSTANCE.getDescriptor());
                }
                this.imageWidth = imageWidth;
                this.imageHeight = imageHeight;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$core_debug(BiliBlockImageSize self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeIntElement(serialDesc, 0, self.imageWidth);
                output.encodeIntElement(serialDesc, 1, self.imageHeight);
            }

            @Override // kntr.common.ouro.core.model.mark.OuroDrawableMark.Size, kntr.common.ouro.core.model.mark.OuroMark
            public /* bridge */ OuroMark.Key<? extends Size> getKey() {
                return CC.$default$getKey(this);
            }

            @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
            public /* bridge */ MergeRule.Override getMergeRule() {
                return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
            }

            public final int getImageWidth() {
                return this.imageWidth;
            }

            public final int getImageHeight() {
                return this.imageHeight;
            }
        }
    }
}