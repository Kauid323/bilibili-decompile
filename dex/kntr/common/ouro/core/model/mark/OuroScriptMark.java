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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0002\u0007\bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroScriptMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "key", "Lkntr/common/ouro/core/model/mark/OuroScriptMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroScriptMark$Key;", "Key", "Companion", "Lkntr/common/ouro/core/model/mark/OuroSubscriptMark;", "Lkntr/common/ouro/core/model/mark/OuroSuperscriptMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface OuroScriptMark extends OuroMark.BuiltIn, OuroTextMark {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    Key getKey();

    /* compiled from: OuroTextMark.kt */
    /* renamed from: kntr.common.ouro.core.model.mark.OuroScriptMark$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = OuroScriptMark.Companion;
        }

        /* renamed from: $default$getKey  reason: collision with other method in class */
        public static Key m1990$default$getKey(OuroScriptMark _this) {
            return Key.INSTANCE;
        }
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroScriptMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroScriptMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<OuroScriptMark> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.mark.OuroScriptMark", Reflection.getOrCreateKotlinClass(OuroScriptMark.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroSubscriptMark.class), Reflection.getOrCreateKotlinClass(OuroSuperscriptMark.class)}, new KSerializer[]{new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroSubscriptMark", OuroSubscriptMark.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.OuroSuperscriptMark", OuroSuperscriptMark.INSTANCE, new Annotation[0])}, new Annotation[0]);
        }
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static MergeRule.Override getMergeRule(OuroScriptMark $this) {
            return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) $this);
        }

        @Deprecated
        public static Key getKey(OuroScriptMark $this) {
            return CC.m1990$default$getKey($this);
        }
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroScriptMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroScriptMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroScriptMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }
}