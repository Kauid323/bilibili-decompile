package im.session.model;

import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bapis.bilibili.app.im.v1.KSessionFilterTypeSerializer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMSessionFilter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J#\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lim/session/model/IMSessionFilterConfig;", "", "filters", "", "Lim/session/model/IMSessionFilter;", "currentFilter", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "<init>", "(Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFilters$annotations", "()V", "getFilters", "()Ljava/util/List;", "getCurrentFilter$annotations", "getCurrentFilter", "()Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "isNotEmpty", "", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "$serializer", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMSessionFilterConfig {
    private final KSessionFilterType currentFilter;
    private final List<IMSessionFilter> filters;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.model.IMSessionFilterConfig$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = IMSessionFilterConfig._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMSessionFilterConfig copy$default(IMSessionFilterConfig iMSessionFilterConfig, List list, KSessionFilterType kSessionFilterType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = iMSessionFilterConfig.filters;
        }
        if ((i2 & 2) != 0) {
            kSessionFilterType = iMSessionFilterConfig.currentFilter;
        }
        return iMSessionFilterConfig.copy(list, kSessionFilterType);
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getCurrentFilter$annotations() {
    }

    @ProtoNumber(number = 1)
    @ProtoPacked
    public static /* synthetic */ void getFilters$annotations() {
    }

    public final List<IMSessionFilter> component1() {
        return this.filters;
    }

    public final KSessionFilterType component2() {
        return this.currentFilter;
    }

    public final IMSessionFilterConfig copy(List<IMSessionFilter> list, KSessionFilterType kSessionFilterType) {
        Intrinsics.checkNotNullParameter(list, "filters");
        Intrinsics.checkNotNullParameter(kSessionFilterType, "currentFilter");
        return new IMSessionFilterConfig(list, kSessionFilterType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionFilterConfig) {
            IMSessionFilterConfig iMSessionFilterConfig = (IMSessionFilterConfig) obj;
            return Intrinsics.areEqual(this.filters, iMSessionFilterConfig.filters) && Intrinsics.areEqual(this.currentFilter, iMSessionFilterConfig.currentFilter);
        }
        return false;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + this.currentFilter.hashCode();
    }

    public String toString() {
        List<IMSessionFilter> list = this.filters;
        return "IMSessionFilterConfig(filters=" + list + ", currentFilter=" + this.currentFilter + ")";
    }

    /* compiled from: IMSessionFilter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/model/IMSessionFilterConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMSessionFilterConfig;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMSessionFilterConfig> serializer() {
            return IMSessionFilterConfig$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ IMSessionFilterConfig(int seen0, List filters, KSessionFilterType currentFilter, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, IMSessionFilterConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.filters = filters;
        if ((seen0 & 2) == 0) {
            this.currentFilter = KSessionFilterType.Companion.fromValue(0);
        } else {
            this.currentFilter = currentFilter;
        }
    }

    public IMSessionFilterConfig(List<IMSessionFilter> list, KSessionFilterType currentFilter) {
        Intrinsics.checkNotNullParameter(list, "filters");
        Intrinsics.checkNotNullParameter(currentFilter, "currentFilter");
        this.filters = list;
        this.currentFilter = currentFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IMSessionFilter$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(IMSessionFilterConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) $childSerializers[0].getValue(), self.filters);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.currentFilter, KSessionFilterType.Companion.fromValue(0))) {
            output.encodeSerializableElement(serialDesc, 1, KSessionFilterTypeSerializer.INSTANCE, self.currentFilter);
        }
    }

    public /* synthetic */ IMSessionFilterConfig(List list, KSessionFilterType kSessionFilterType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? KSessionFilterType.Companion.fromValue(0) : kSessionFilterType);
    }

    public final List<IMSessionFilter> getFilters() {
        return this.filters;
    }

    public final KSessionFilterType getCurrentFilter() {
        return this.currentFilter;
    }

    public final boolean isNotEmpty() {
        return !this.filters.isEmpty();
    }
}