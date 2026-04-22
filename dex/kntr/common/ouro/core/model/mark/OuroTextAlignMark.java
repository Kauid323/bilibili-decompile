package kntr.common.ouro.core.model.mark;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: OuroParagraphMark.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \t2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\b\tR\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$Override;", "key", "Lkntr/common/ouro/core/model/mark/OuroTextAlignMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroTextAlignMark$Key;", "Key", "Companion", "Lkntr/common/ouro/core/model/mark/OuroTextAlignCenterMark;", "Lkntr/common/ouro/core/model/mark/OuroTextAlignEndMark;", "Lkntr/common/ouro/core/model/mark/OuroTextAlignJustifyMark;", "Lkntr/common/ouro/core/model/mark/OuroTextAlignStartMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface OuroTextAlignMark extends OuroMark.BuiltIn, OuroParagraphMark, OuroMark.Override {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    Key getKey();

    /* compiled from: OuroParagraphMark.kt */
    /* renamed from: kntr.common.ouro.core.model.mark.OuroTextAlignMark$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = OuroTextAlignMark.Companion;
        }

        /* renamed from: $default$getKey */
        public static Key m1993$default$getKey(OuroTextAlignMark _this) {
            return Key.INSTANCE;
        }
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextAlignMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<OuroTextAlignMark> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.mark.OuroTextAlignMark", Reflection.getOrCreateKotlinClass(OuroTextAlignMark.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroTextAlignCenterMark.class), Reflection.getOrCreateKotlinClass(OuroTextAlignEndMark.class), Reflection.getOrCreateKotlinClass(OuroTextAlignJustifyMark.class), Reflection.getOrCreateKotlinClass(OuroTextAlignStartMark.class)}, new KSerializer[]{new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark", OuroTextAlignCenterMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignEndMark", OuroTextAlignEndMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignJustifyMark", OuroTextAlignJustifyMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignStartMark", OuroTextAlignStartMark.INSTANCE, new Annotation[0])}, new Annotation[0]);
        }
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static MergeRule.Override getMergeRule(OuroTextAlignMark $this) {
            return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) $this);
        }

        @Deprecated
        public static Key getKey(OuroTextAlignMark $this) {
            return CC.m1993$default$getKey($this);
        }
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextAlignMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroTextAlignMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }
}