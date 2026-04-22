package kntr.common.ouro.core.model.mark;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroScriptMark;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: OuroTextMark.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroSubscriptMark;", "Lkntr/common/ouro/core/model/mark/OuroScriptMark;", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroSubscriptMark implements OuroScriptMark {
    public static final OuroSubscriptMark INSTANCE = new OuroSubscriptMark();
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroSubscriptMark$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = OuroSubscriptMark._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    private OuroSubscriptMark() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroSubscriptMark", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return $cachedSerializer$delegate.getValue();
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    public /* bridge */ OuroScriptMark.Key getKey() {
        return OuroScriptMark.CC.m1990$default$getKey((OuroScriptMark) this);
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
    public /* bridge */ MergeRule.Override getMergeRule() {
        return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
    }

    public final KSerializer<OuroSubscriptMark> serializer() {
        return get$cachedSerializer();
    }
}