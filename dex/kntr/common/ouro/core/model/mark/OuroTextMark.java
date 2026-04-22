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

/* compiled from: OuroTextMark.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$Override;", "Companion", "Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroFontSizeMark;", "Lkntr/common/ouro/core/model/mark/OuroFontWeightMark;", "Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroItalicMark;", "Lkntr/common/ouro/core/model/mark/OuroScriptMark;", "Lkntr/common/ouro/core/model/mark/OuroStrikethroughMark;", "Lkntr/common/ouro/core/model/mark/OuroTextSpacingMark;", "Lkntr/common/ouro/core/model/mark/OuroUnderlineMark;", "Lkntr/common/ouro/core/model/mark/OuroUnmergableMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface OuroTextMark extends OuroMark.Override {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: OuroTextMark.kt */
    /* renamed from: kntr.common.ouro.core.model.mark.OuroTextMark$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = OuroTextMark.Companion;
        }
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<OuroTextMark> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.mark.OuroTextMark", Reflection.getOrCreateKotlinClass(OuroTextMark.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroBackgroundColorMark.class), Reflection.getOrCreateKotlinClass(OuroFontSizeMark.class), Reflection.getOrCreateKotlinClass(OuroMediumMark.class), Reflection.getOrCreateKotlinClass(OuroRegularMark.class), Reflection.getOrCreateKotlinClass(OuroSemiBoldMark.class), Reflection.getOrCreateKotlinClass(OuroForegroundColorMark.class), Reflection.getOrCreateKotlinClass(OuroItalicMark.class), Reflection.getOrCreateKotlinClass(OuroSubscriptMark.class), Reflection.getOrCreateKotlinClass(OuroSuperscriptMark.class), Reflection.getOrCreateKotlinClass(OuroStrikethroughMark.class), Reflection.getOrCreateKotlinClass(OuroTextSpacingMark.class), Reflection.getOrCreateKotlinClass(OuroUnderlineMark.class), Reflection.getOrCreateKotlinClass(OuroUnmergableMark.class)}, new KSerializer[]{OuroBackgroundColorMark$$serializer.INSTANCE, OuroFontSizeMark$$serializer.INSTANCE, new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroMediumMark", OuroMediumMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroRegularMark", OuroRegularMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroSemiBoldMark", OuroSemiBoldMark.INSTANCE, new Annotation[0]), OuroForegroundColorMark$$serializer.INSTANCE, new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroItalicMark", OuroItalicMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroSubscriptMark", OuroSubscriptMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroSuperscriptMark", OuroSuperscriptMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroStrikethroughMark", OuroStrikethroughMark.INSTANCE, new Annotation[0]), OuroTextSpacingMark$$serializer.INSTANCE, new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroUnderlineMark", OuroUnderlineMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroUnmergableMark", OuroUnmergableMark.INSTANCE, new Annotation[0])}, new Annotation[0]);
        }
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static MergeRule.Override getMergeRule(OuroTextMark $this) {
            return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) $this);
        }
    }
}