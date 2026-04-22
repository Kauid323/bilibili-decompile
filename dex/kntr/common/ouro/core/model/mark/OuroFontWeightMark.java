package kntr.common.ouro.core.model.mark;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroTextMark.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0017\u0018B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0003\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroFontWeightMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "key", "Lkntr/common/ouro/core/model/mark/OuroFontWeightMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroFontWeightMark$Key;", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Key", "Companion", "Lkntr/common/ouro/core/model/mark/OuroMediumMark;", "Lkntr/common/ouro/core/model/mark/OuroRegularMark;", "Lkntr/common/ouro/core/model/mark/OuroSemiBoldMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public abstract class OuroFontWeightMark implements OuroMark.BuiltIn, OuroTextMark {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroFontWeightMark$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = OuroFontWeightMark._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    public /* synthetic */ OuroFontWeightMark(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(OuroFontWeightMark ouroFontWeightMark, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroFontWeightMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroFontWeightMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) OuroFontWeightMark.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<OuroFontWeightMark> serializer() {
            return get$cachedSerializer();
        }
    }

    private OuroFontWeightMark() {
    }

    public /* synthetic */ OuroFontWeightMark(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("kntr.common.ouro.core.model.mark.OuroFontWeightMark", Reflection.getOrCreateKotlinClass(OuroFontWeightMark.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroMediumMark.class), Reflection.getOrCreateKotlinClass(OuroRegularMark.class), Reflection.getOrCreateKotlinClass(OuroSemiBoldMark.class)}, new KSerializer[]{new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroMediumMark", OuroMediumMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroRegularMark", OuroRegularMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroSemiBoldMark", OuroSemiBoldMark.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
    public /* bridge */ MergeRule.Override getMergeRule() {
        return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroFontWeightMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroFontWeightMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroFontWeightMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    public Key getKey() {
        return Key.INSTANCE;
    }

    public String toString() {
        return "FontWeight";
    }
}