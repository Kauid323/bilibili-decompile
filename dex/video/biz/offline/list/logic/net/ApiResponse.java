package video.biz.offline.list.logic.net;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IpTask.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 -*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002,-B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0015J>\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001JE\u0010\"\u001a\u00020#\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00010*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lvideo/biz/offline/list/logic/net/ApiResponse;", "T", "", "code", "", "message", "", "ttl", "data", "<init>", "(ILjava/lang/String;ILjava/lang/Object;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;ILjava/lang/Object;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getTtl", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;ILjava/lang/Object;)Lvideo/biz/offline/list/logic/net/ApiResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$logic_debug", "$serializer", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class ApiResponse<T> {
    private static final SerialDescriptor $cachedDescriptor;
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int code;
    private final T data;
    private final String message;
    private final int ttl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, int i, String str, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i = apiResponse.code;
        }
        if ((i3 & 2) != 0) {
            str = apiResponse.message;
        }
        if ((i3 & 4) != 0) {
            i2 = apiResponse.ttl;
        }
        if ((i3 & 8) != 0) {
            obj = apiResponse.data;
        }
        return apiResponse.copy(i, str, i2, obj);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.ttl;
    }

    public final T component4() {
        return this.data;
    }

    public final ApiResponse<T> copy(int i, String str, int i2, T t) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new ApiResponse<>(i, str, i2, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApiResponse) {
            ApiResponse apiResponse = (ApiResponse) obj;
            return this.code == apiResponse.code && Intrinsics.areEqual(this.message, apiResponse.message) && this.ttl == apiResponse.ttl && Intrinsics.areEqual(this.data, apiResponse.data);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.code * 31) + this.message.hashCode()) * 31) + this.ttl) * 31) + (this.data == null ? 0 : this.data.hashCode());
    }

    public String toString() {
        int i = this.code;
        String str = this.message;
        int i2 = this.ttl;
        return "ApiResponse(code=" + i + ", message=" + str + ", ttl=" + i2 + ", data=" + this.data + ")";
    }

    /* compiled from: IpTask.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¨\u0006\t"}, d2 = {"Lvideo/biz/offline/list/logic/net/ApiResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/list/logic/net/ApiResponse;", "T", "typeSerial0", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> KSerializer<ApiResponse<T>> serializer(KSerializer<T> kSerializer) {
            Intrinsics.checkNotNullParameter(kSerializer, "typeSerial0");
            return new ApiResponse$$serializer<>(kSerializer);
        }
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.list.logic.net.ApiResponse", (GeneratedSerializer) null, 4);
        pluginGeneratedSerialDescriptor.addElement("code", false);
        pluginGeneratedSerialDescriptor.addElement("message", false);
        pluginGeneratedSerialDescriptor.addElement("ttl", false);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ApiResponse(int seen0, int code, String message, int ttl, Object data, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, $cachedDescriptor);
        }
        this.code = code;
        this.message = message;
        this.ttl = ttl;
        this.data = data;
    }

    public ApiResponse(int code, String message, int ttl, T t) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = code;
        this.message = message;
        this.ttl = ttl;
        this.data = t;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$logic_debug(ApiResponse self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
        output.encodeIntElement(serialDesc, 0, self.code);
        output.encodeStringElement(serialDesc, 1, self.message);
        output.encodeIntElement(serialDesc, 2, self.ttl);
        output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) typeSerial0, self.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getTtl() {
        return this.ttl;
    }

    public final T getData() {
        return this.data;
    }
}