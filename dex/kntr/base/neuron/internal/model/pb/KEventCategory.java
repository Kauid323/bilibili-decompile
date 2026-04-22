package kntr.base.neuron.internal.model.pb;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.internal.model.pb.KEventCategory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \f2\u00020\u0001:\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\n\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory;", "", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "Companion", "OTHER", "PAGEVIEW", "CLICK", "EXPOSURE", "SYSTEM", "TRACKER", "CUSTOM", "COMPATIBLE", "PLAYER", "UNRECOGNIZED", "Lkntr/base/neuron/internal/model/pb/KEventCategory$CLICK;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$COMPATIBLE;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$CUSTOM;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$EXPOSURE;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$OTHER;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$PAGEVIEW;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$PLAYER;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$SYSTEM;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$TRACKER;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$UNRECOGNIZED;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable(with = KEventCategorySerializer.class)
public abstract class KEventCategory {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<List<KEventCategory>> values$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$$ExternalSyntheticLambda0
        public final Object invoke() {
            List values_delegate$lambda$0;
            values_delegate$lambda$0 = KEventCategory.values_delegate$lambda$0();
            return values_delegate$lambda$0;
        }
    });

    public /* synthetic */ KEventCategory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getName();

    public abstract int getValue();

    private KEventCategory() {
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013R'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$Companion;", "", "<init>", "()V", "values", "", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "getValues$annotations", "getValues", "()Ljava/util/List;", "values$delegate", "Lkotlin/Lazy;", "fromValue", "value", "", "fromName", "name", "", "serializer", "Lkotlinx/serialization/KSerializer;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getValues$annotations() {
        }

        private Companion() {
        }

        public final KSerializer<KEventCategory> serializer() {
            return KEventCategorySerializer.INSTANCE;
        }

        public final List<KEventCategory> getValues() {
            return (List) KEventCategory.values$delegate.getValue();
        }

        public final KEventCategory fromValue(int value) {
            Object element$iv;
            boolean z;
            Iterable $this$firstOrNull$iv = getValues();
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    KEventCategory it2 = (KEventCategory) element$iv;
                    if (it2.getValue() == value) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            KEventCategory kEventCategory = (KEventCategory) element$iv;
            return kEventCategory == null ? new UNRECOGNIZED(value) : kEventCategory;
        }

        public final KEventCategory fromName(String name) {
            Object element$iv;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterable $this$firstOrNull$iv = getValues();
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    KEventCategory it2 = (KEventCategory) element$iv;
                    if (Intrinsics.areEqual(it2.getName(), name)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            KEventCategory kEventCategory = (KEventCategory) element$iv;
            if (kEventCategory != null) {
                return kEventCategory;
            }
            throw new IllegalArgumentException("No KEventCategory with name: " + name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List values_delegate$lambda$0() {
        return CollectionsKt.listOf(new KEventCategory[]{OTHER.INSTANCE, PAGEVIEW.INSTANCE, CLICK.INSTANCE, EXPOSURE.INSTANCE, SYSTEM.INSTANCE, TRACKER.INSTANCE, CUSTOM.INSTANCE, COMPATIBLE.INSTANCE, PLAYER.INSTANCE});
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$OTHER;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OTHER extends KEventCategory {
        private static final int value = 0;
        public static final OTHER INSTANCE = new OTHER();
        private static final String name = "OTHER";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$OTHER$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.OTHER._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OTHER) {
                OTHER other = (OTHER) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 180127392;
        }

        public String toString() {
            return "OTHER";
        }

        private OTHER() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.OTHER", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<OTHER> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$PAGEVIEW;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PAGEVIEW extends KEventCategory {
        public static final PAGEVIEW INSTANCE = new PAGEVIEW();
        private static final int value = 1;
        private static final String name = "PAGEVIEW";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$PAGEVIEW$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.PAGEVIEW._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PAGEVIEW) {
                PAGEVIEW pageview = (PAGEVIEW) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -502312956;
        }

        public String toString() {
            return "PAGEVIEW";
        }

        private PAGEVIEW() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.PAGEVIEW", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<PAGEVIEW> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$CLICK;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CLICK extends KEventCategory {
        public static final CLICK INSTANCE = new CLICK();
        private static final int value = 2;
        private static final String name = "CLICK";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$CLICK$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.CLICK._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CLICK) {
                CLICK click = (CLICK) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 168807704;
        }

        public String toString() {
            return "CLICK";
        }

        private CLICK() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.CLICK", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CLICK> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$EXPOSURE;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EXPOSURE extends KEventCategory {
        public static final EXPOSURE INSTANCE = new EXPOSURE();
        private static final int value = 3;
        private static final String name = "EXPOSURE";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$EXPOSURE$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.EXPOSURE._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EXPOSURE) {
                EXPOSURE exposure = (EXPOSURE) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1006178135;
        }

        public String toString() {
            return "EXPOSURE";
        }

        private EXPOSURE() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.EXPOSURE", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<EXPOSURE> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$SYSTEM;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SYSTEM extends KEventCategory {
        public static final SYSTEM INSTANCE = new SYSTEM();
        private static final int value = 4;
        private static final String name = "SYSTEM";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$SYSTEM$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.SYSTEM._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SYSTEM) {
                SYSTEM system = (SYSTEM) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1408457855;
        }

        public String toString() {
            return "SYSTEM";
        }

        private SYSTEM() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.SYSTEM", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SYSTEM> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$TRACKER;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TRACKER extends KEventCategory {
        public static final TRACKER INSTANCE = new TRACKER();
        private static final int value = 5;
        private static final String name = "TRACKER";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$TRACKER$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.TRACKER._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TRACKER) {
                TRACKER tracker = (TRACKER) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1382495944;
        }

        public String toString() {
            return "TRACKER";
        }

        private TRACKER() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.TRACKER", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<TRACKER> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$CUSTOM;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CUSTOM extends KEventCategory {
        public static final CUSTOM INSTANCE = new CUSTOM();
        private static final int value = 7;
        private static final String name = "CUSTOM";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$CUSTOM$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.CUSTOM._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CUSTOM) {
                CUSTOM custom = (CUSTOM) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 946697665;
        }

        public String toString() {
            return "CUSTOM";
        }

        private CUSTOM() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.CUSTOM", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CUSTOM> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$COMPATIBLE;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class COMPATIBLE extends KEventCategory {
        public static final COMPATIBLE INSTANCE = new COMPATIBLE();
        private static final int value = 8;
        private static final String name = "COMPATIBLE";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$COMPATIBLE$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.COMPATIBLE._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof COMPATIBLE) {
                COMPATIBLE compatible = (COMPATIBLE) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -512682716;
        }

        public String toString() {
            return "COMPATIBLE";
        }

        private COMPATIBLE() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.COMPATIBLE", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<COMPATIBLE> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$PLAYER;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PLAYER extends KEventCategory {
        public static final PLAYER INSTANCE = new PLAYER();
        private static final int value = 9;
        private static final String name = "PLAYER";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KEventCategory$PLAYER$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KEventCategory.PLAYER._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PLAYER) {
                PLAYER player = (PLAYER) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1310033201;
        }

        public String toString() {
            return "PLAYER";
        }

        private PLAYER() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KEventCategory.PLAYER", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<PLAYER> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B-\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$UNRECOGNIZED;", "Lkntr/base/neuron/internal/model/pb/KEventCategory;", "value", "", "<init>", "(I)V", "seen0", "name", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()I", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UNRECOGNIZED extends KEventCategory {
        public static final Companion Companion = new Companion(null);
        private final String name;
        private final int value;

        public static /* synthetic */ UNRECOGNIZED copy$default(UNRECOGNIZED unrecognized, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unrecognized.value;
            }
            return unrecognized.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final UNRECOGNIZED copy(int i) {
            return new UNRECOGNIZED(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UNRECOGNIZED) && this.value == ((UNRECOGNIZED) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "UNRECOGNIZED(value=" + this.value + ")";
        }

        public UNRECOGNIZED(int value) {
            super(null);
            this.value = value;
            this.name = "UNRECOGNIZED";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UNRECOGNIZED(int seen0, int value, String name, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (seen0 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 1, KEventCategory$UNRECOGNIZED$$serializer.INSTANCE.getDescriptor());
            }
            this.value = value;
            if ((seen0 & 2) == 0) {
                this.name = "UNRECOGNIZED";
            } else {
                this.name = name;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$neuron_debug(UNRECOGNIZED self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.getValue());
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.getName(), "UNRECOGNIZED")) {
                output.encodeStringElement(serialDesc, 1, self.getName());
            }
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public int getValue() {
            return this.value;
        }

        /* compiled from: info_raw.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KEventCategory$UNRECOGNIZED$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KEventCategory$UNRECOGNIZED;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UNRECOGNIZED> serializer() {
                return KEventCategory$UNRECOGNIZED$$serializer.INSTANCE;
            }
        }

        @Override // kntr.base.neuron.internal.model.pb.KEventCategory
        public String getName() {
            return this.name;
        }
    }
}