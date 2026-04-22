package kntr.common.ouro.core.model.mark;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: OuroParagraphMark.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0003\u0003\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "Companion", "Lkntr/common/ouro/core/model/mark/OuroLineHeightMark;", "Lkntr/common/ouro/core/model/mark/OuroTextAlignMark;", "Lkntr/common/ouro/core/model/mark/OuroTextIndentMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface OuroParagraphMark extends OuroMark {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroParagraphMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<OuroParagraphMark> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.mark.OuroParagraphMark", Reflection.getOrCreateKotlinClass(OuroParagraphMark.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroLineHeightMark.class), Reflection.getOrCreateKotlinClass(OuroTextAlignCenterMark.class), Reflection.getOrCreateKotlinClass(OuroTextAlignEndMark.class), Reflection.getOrCreateKotlinClass(OuroTextAlignJustifyMark.class), Reflection.getOrCreateKotlinClass(OuroTextAlignStartMark.class), Reflection.getOrCreateKotlinClass(OuroTextIndentMark.class)}, new KSerializer[]{OuroLineHeightMark$$serializer.INSTANCE, new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark", OuroTextAlignCenterMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignEndMark", OuroTextAlignEndMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignJustifyMark", OuroTextAlignJustifyMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroTextAlignStartMark", OuroTextAlignStartMark.INSTANCE, new Annotation[0]), OuroTextIndentMark$$serializer.INSTANCE}, new Annotation[0]);
        }
    }
}