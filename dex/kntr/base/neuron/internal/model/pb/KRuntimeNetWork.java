package kntr.base.neuron.internal.model.pb;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.internal.model.pb.KRuntimeNetWork;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \f2\u00020\u0001:\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "Companion", "UNKNOWN", "WIFI", "CELLULAR", "OFFLINE", "OTHERNET", "ETHERNET", "UNRECOGNIZED", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$CELLULAR;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$ETHERNET;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$OFFLINE;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$OTHERNET;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$UNKNOWN;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$UNRECOGNIZED;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$WIFI;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable(with = KRuntimeNetWorkSerializer.class)
public abstract class KRuntimeNetWork {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<List<KRuntimeNetWork>> values$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWork$$ExternalSyntheticLambda0
        public final Object invoke() {
            List values_delegate$lambda$0;
            values_delegate$lambda$0 = KRuntimeNetWork.values_delegate$lambda$0();
            return values_delegate$lambda$0;
        }
    });

    public /* synthetic */ KRuntimeNetWork(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getName();

    public abstract int getValue();

    private KRuntimeNetWork() {
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013R'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$Companion;", "", "<init>", "()V", "values", "", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "getValues$annotations", "getValues", "()Ljava/util/List;", "values$delegate", "Lkotlin/Lazy;", "fromValue", "value", "", "fromName", "name", "", "serializer", "Lkotlinx/serialization/KSerializer;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getValues$annotations() {
        }

        private Companion() {
        }

        public final KSerializer<KRuntimeNetWork> serializer() {
            return KRuntimeNetWorkSerializer.INSTANCE;
        }

        public final List<KRuntimeNetWork> getValues() {
            return (List) KRuntimeNetWork.values$delegate.getValue();
        }

        public final KRuntimeNetWork fromValue(int value) {
            Object element$iv;
            boolean z;
            Iterable $this$firstOrNull$iv = getValues();
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    KRuntimeNetWork it2 = (KRuntimeNetWork) element$iv;
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
            KRuntimeNetWork kRuntimeNetWork = (KRuntimeNetWork) element$iv;
            return kRuntimeNetWork == null ? new UNRECOGNIZED(value) : kRuntimeNetWork;
        }

        public final KRuntimeNetWork fromName(String name) {
            Object element$iv;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterable $this$firstOrNull$iv = getValues();
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    KRuntimeNetWork it2 = (KRuntimeNetWork) element$iv;
                    if (Intrinsics.areEqual(it2.getName(), name)) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            KRuntimeNetWork kRuntimeNetWork = (KRuntimeNetWork) element$iv;
            if (kRuntimeNetWork != null) {
                return kRuntimeNetWork;
            }
            throw new IllegalArgumentException("No KRuntimeNetWork with name: " + name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List values_delegate$lambda$0() {
        return CollectionsKt.listOf(new KRuntimeNetWork[]{UNKNOWN.INSTANCE, WIFI.INSTANCE, CELLULAR.INSTANCE, OFFLINE.INSTANCE, OTHERNET.INSTANCE, ETHERNET.INSTANCE});
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$UNKNOWN;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UNKNOWN extends KRuntimeNetWork {
        private static final int value = 0;
        public static final UNKNOWN INSTANCE = new UNKNOWN();
        private static final String name = "UNKNOWN";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWork$UNKNOWN$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KRuntimeNetWork.UNKNOWN._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UNKNOWN) {
                UNKNOWN unknown = (UNKNOWN) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1211416684;
        }

        public String toString() {
            return "UNKNOWN";
        }

        private UNKNOWN() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KRuntimeNetWork.UNKNOWN", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<UNKNOWN> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$WIFI;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class WIFI extends KRuntimeNetWork {
        public static final WIFI INSTANCE = new WIFI();
        private static final int value = 1;
        private static final String name = "WIFI";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWork$WIFI$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KRuntimeNetWork.WIFI._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WIFI) {
                WIFI wifi = (WIFI) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -595470829;
        }

        public String toString() {
            return "WIFI";
        }

        private WIFI() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KRuntimeNetWork.WIFI", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<WIFI> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$CELLULAR;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CELLULAR extends KRuntimeNetWork {
        public static final CELLULAR INSTANCE = new CELLULAR();
        private static final int value = 2;
        private static final String name = "CELLULAR";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWork$CELLULAR$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KRuntimeNetWork.CELLULAR._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CELLULAR) {
                CELLULAR cellular = (CELLULAR) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1777251992;
        }

        public String toString() {
            return "CELLULAR";
        }

        private CELLULAR() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KRuntimeNetWork.CELLULAR", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<CELLULAR> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$OFFLINE;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OFFLINE extends KRuntimeNetWork {
        public static final OFFLINE INSTANCE = new OFFLINE();
        private static final int value = 3;
        private static final String name = "OFFLINE";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWork$OFFLINE$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KRuntimeNetWork.OFFLINE._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OFFLINE) {
                OFFLINE offline = (OFFLINE) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -52354555;
        }

        public String toString() {
            return "OFFLINE";
        }

        private OFFLINE() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KRuntimeNetWork.OFFLINE", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<OFFLINE> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$OTHERNET;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OTHERNET extends KRuntimeNetWork {
        public static final OTHERNET INSTANCE = new OTHERNET();
        private static final int value = 4;
        private static final String name = "OTHERNET";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWork$OTHERNET$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KRuntimeNetWork.OTHERNET._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OTHERNET) {
                OTHERNET othernet = (OTHERNET) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2031779701;
        }

        public String toString() {
            return "OTHERNET";
        }

        private OTHERNET() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KRuntimeNetWork.OTHERNET", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<OTHERNET> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012J\t\u0010\u0013\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$ETHERNET;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "<init>", "()V", "value", "", "getValue", "()I", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ETHERNET extends KRuntimeNetWork {
        public static final ETHERNET INSTANCE = new ETHERNET();
        private static final int value = 5;
        private static final String name = "ETHERNET";
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.neuron.internal.model.pb.KRuntimeNetWork$ETHERNET$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = KRuntimeNetWork.ETHERNET._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ETHERNET) {
                ETHERNET ethernet = (ETHERNET) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2014953429;
        }

        public String toString() {
            return "ETHERNET";
        }

        private ETHERNET() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.base.neuron.internal.model.pb.KRuntimeNetWork.ETHERNET", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<ETHERNET> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public int getValue() {
            return value;
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public String getName() {
            return name;
        }
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B-\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$UNRECOGNIZED;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork;", "value", "", "<init>", "(I)V", "seen0", "name", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()I", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UNRECOGNIZED extends KRuntimeNetWork {
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
                PluginExceptionsKt.throwMissingFieldException(seen0, 1, KRuntimeNetWork$UNRECOGNIZED$$serializer.INSTANCE.getDescriptor());
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

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public int getValue() {
            return this.value;
        }

        /* compiled from: info_raw.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$UNRECOGNIZED$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KRuntimeNetWork$UNRECOGNIZED;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UNRECOGNIZED> serializer() {
                return KRuntimeNetWork$UNRECOGNIZED$$serializer.INSTANCE;
            }
        }

        @Override // kntr.base.neuron.internal.model.pb.KRuntimeNetWork
        public String getName() {
            return this.name;
        }
    }
}