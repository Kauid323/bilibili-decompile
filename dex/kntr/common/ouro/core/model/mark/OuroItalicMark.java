package kntr.common.ouro.core.model.mark;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: OuroTextMark.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fR\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroItalicMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "<init>", "()V", "key", "Lkntr/common/ouro/core/model/mark/OuroItalicMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroItalicMark$Key;", "toString", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Key", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroItalicMark implements OuroMark.BuiltIn, OuroTextMark {
    public static final OuroItalicMark INSTANCE = new OuroItalicMark();
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.OuroItalicMark$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = OuroItalicMark._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    private OuroItalicMark() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroItalicMark", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return $cachedSerializer$delegate.getValue();
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
    public /* bridge */ MergeRule.Override getMergeRule() {
        return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
    }

    public final KSerializer<OuroItalicMark> serializer() {
        return get$cachedSerializer();
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroItalicMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroItalicMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroItalicMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    public Key getKey() {
        return Key.INSTANCE;
    }

    public String toString() {
        return "Italic";
    }
}