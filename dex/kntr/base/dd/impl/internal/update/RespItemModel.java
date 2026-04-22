package kntr.base.dd.impl.internal.update;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateInfoModel.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 /2\u00020\u0001:\u0002./B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lkntr/base/dd/impl/internal/update/RespItemModel;", "", "md5", "", "curl", AppKey.VERSION, "", "diffs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMd5$annotations", "()V", "getMd5", "()Ljava/lang/String;", "getCurl$annotations", "getCurl", "getVersion$annotations", "getVersion", "()J", "getDiffs$annotations", "getDiffs", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_debug", "$serializer", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class RespItemModel {
    private final String curl;
    private final Map<String, String> diffs;
    private final String md5;
    private final long version;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.dd.impl.internal.update.RespItemModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = RespItemModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ RespItemModel copy$default(RespItemModel respItemModel, String str, String str2, long j, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = respItemModel.md5;
        }
        if ((i & 2) != 0) {
            str2 = respItemModel.curl;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = respItemModel.version;
        }
        long j2 = j;
        Map<String, String> map2 = map;
        if ((i & 8) != 0) {
            map2 = respItemModel.diffs;
        }
        return respItemModel.copy(str, str3, j2, map2);
    }

    @SerialName("u")
    public static /* synthetic */ void getCurl$annotations() {
    }

    @SerialName("d")
    public static /* synthetic */ void getDiffs$annotations() {
    }

    @SerialName("m")
    public static /* synthetic */ void getMd5$annotations() {
    }

    @SerialName("v")
    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.md5;
    }

    public final String component2() {
        return this.curl;
    }

    public final long component3() {
        return this.version;
    }

    public final Map<String, String> component4() {
        return this.diffs;
    }

    public final RespItemModel copy(String str, String str2, long j, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "md5");
        Intrinsics.checkNotNullParameter(str2, "curl");
        return new RespItemModel(str, str2, j, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RespItemModel) {
            RespItemModel respItemModel = (RespItemModel) obj;
            return Intrinsics.areEqual(this.md5, respItemModel.md5) && Intrinsics.areEqual(this.curl, respItemModel.curl) && this.version == respItemModel.version && Intrinsics.areEqual(this.diffs, respItemModel.diffs);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.md5.hashCode() * 31) + this.curl.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version)) * 31) + (this.diffs == null ? 0 : this.diffs.hashCode());
    }

    public String toString() {
        String str = this.md5;
        String str2 = this.curl;
        long j = this.version;
        return "RespItemModel(md5=" + str + ", curl=" + str2 + ", version=" + j + ", diffs=" + this.diffs + ")";
    }

    /* compiled from: UpdateInfoModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/dd/impl/internal/update/RespItemModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/dd/impl/internal/update/RespItemModel;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RespItemModel> serializer() {
            return RespItemModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RespItemModel(int seen0, String md5, String curl, long version, Map diffs, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, RespItemModel$$serializer.INSTANCE.getDescriptor());
        }
        this.md5 = md5;
        this.curl = curl;
        this.version = version;
        if ((seen0 & 8) == 0) {
            this.diffs = null;
        } else {
            this.diffs = diffs;
        }
    }

    public RespItemModel(String md5, String curl, long version, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(curl, "curl");
        this.md5 = md5;
        this.curl = curl;
        this.version = version;
        this.diffs = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_debug(RespItemModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.md5);
        output.encodeStringElement(serialDesc, 1, self.curl);
        output.encodeLongElement(serialDesc, 2, self.version);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.diffs != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.diffs);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RespItemModel(String str, String str2, long j, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, r5);
        Map map2;
        if ((i & 8) == 0) {
            map2 = map;
        } else {
            map2 = null;
        }
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getCurl() {
        return this.curl;
    }

    public final long getVersion() {
        return this.version;
    }

    public final Map<String, String> getDiffs() {
        return this.diffs;
    }
}