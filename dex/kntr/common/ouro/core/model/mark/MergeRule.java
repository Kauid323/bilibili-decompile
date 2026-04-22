package kntr.common.ouro.core.model.mark;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: OuroMark.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bJ(\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00032\u0006\u0010\u0006\u001a\u0002H\u0003H¦\u0002¢\u0006\u0002\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/MergeRule;", "", "invoke", "T", "Lkntr/common/ouro/core/model/mark/OuroMark;", "current", "parent", "(Lkntr/common/ouro/core/model/mark/OuroMark;Lkntr/common/ouro/core/model/mark/OuroMark;)Lkntr/common/ouro/core/model/mark/OuroMark;", "Override", "Inherit", "Custom", "Companion", "Lkntr/common/ouro/core/model/mark/MergeRule$Custom;", "Lkntr/common/ouro/core/model/mark/MergeRule$Inherit;", "Lkntr/common/ouro/core/model/mark/MergeRule$Override;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface MergeRule {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/MergeRule$Custom;", "Lkntr/common/ouro/core/model/mark/MergeRule;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Custom extends MergeRule {
    }

    <T extends OuroMark> T invoke(T t, T t2);

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/MergeRule$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/MergeRule;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<MergeRule> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.mark.MergeRule", Reflection.getOrCreateKotlinClass(MergeRule.class), new KClass[]{Reflection.getOrCreateKotlinClass(Custom.class), Reflection.getOrCreateKotlinClass(Inherit.class), Reflection.getOrCreateKotlinClass(Override.class)}, new KSerializer[]{new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Custom.class), new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.MergeRule.Inherit", Inherit.INSTANCE, new Annotation[0]), new ObjectSerializer("kntr.common.ouro.core.model.mark.MergeRule.Override", Override.INSTANCE, new Annotation[0])}, new Annotation[0]);
        }
    }

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u0002H\u0005H\u0096\u0002¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/core/model/mark/MergeRule$Override;", "Lkntr/common/ouro/core/model/mark/MergeRule;", "<init>", "()V", "invoke", "T", "Lkntr/common/ouro/core/model/mark/OuroMark;", "current", "parent", "(Lkntr/common/ouro/core/model/mark/OuroMark;Lkntr/common/ouro/core/model/mark/OuroMark;)Lkntr/common/ouro/core/model/mark/OuroMark;", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Override implements MergeRule {
        public static final Override INSTANCE = new Override();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.MergeRule$Override$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = MergeRule.Override._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Override) {
                Override override = (Override) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2039527192;
        }

        public String toString() {
            return "Override";
        }

        private Override() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.common.ouro.core.model.mark.MergeRule.Override", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Override> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.common.ouro.core.model.mark.MergeRule
        public <T extends OuroMark> T invoke(T t, T t2) {
            Intrinsics.checkNotNullParameter(t, "current");
            Intrinsics.checkNotNullParameter(t2, "parent");
            return t;
        }
    }

    /* compiled from: OuroMark.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u0002H\u0005H\u0096\u0002¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/core/model/mark/MergeRule$Inherit;", "Lkntr/common/ouro/core/model/mark/MergeRule;", "<init>", "()V", "invoke", "T", "Lkntr/common/ouro/core/model/mark/OuroMark;", "current", "parent", "(Lkntr/common/ouro/core/model/mark/OuroMark;Lkntr/common/ouro/core/model/mark/OuroMark;)Lkntr/common/ouro/core/model/mark/OuroMark;", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Inherit implements MergeRule {
        public static final Inherit INSTANCE = new Inherit();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.mark.MergeRule$Inherit$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = MergeRule.Inherit._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Inherit) {
                Inherit inherit = (Inherit) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1322495905;
        }

        public String toString() {
            return "Inherit";
        }

        private Inherit() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.common.ouro.core.model.mark.MergeRule.Inherit", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Inherit> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.common.ouro.core.model.mark.MergeRule
        public <T extends OuroMark> T invoke(T t, T t2) {
            Intrinsics.checkNotNullParameter(t, "current");
            Intrinsics.checkNotNullParameter(t2, "parent");
            return t2;
        }
    }
}