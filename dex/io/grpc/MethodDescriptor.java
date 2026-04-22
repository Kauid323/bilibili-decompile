package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class MethodDescriptor<ReqT, RespT> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String fullMethodName;
    private final boolean idempotent;
    private final AtomicReferenceArray<Object> rawMethodNames;
    private final Marshaller<ReqT> requestMarshaller;
    private final Marshaller<RespT> responseMarshaller;
    private final boolean safe;
    private final boolean sampledToLocalTracing;
    @Nullable
    private final Object schemaDescriptor;
    @Nullable
    private final String serviceName;
    private final MethodType type;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface Marshaller<T> {
        T parse(InputStream inputStream);

        InputStream stream(T t);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface PrototypeMarshaller<T> extends ReflectableMarshaller<T> {
        @Nullable
        T getMessagePrototype();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface ReflectableMarshaller<T> extends Marshaller<T> {
        Class<T> getMessageClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object getRawMethodName(int transportOrdinal) {
        return this.rawMethodNames.get(transportOrdinal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRawMethodName(int transportOrdinal, Object o) {
        this.rawMethodNames.lazySet(transportOrdinal, o);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum MethodType {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean clientSendsOneMessage() {
            return this == UNARY || this == SERVER_STREAMING;
        }

        public final boolean serverSendsOneMessage() {
            return this == UNARY || this == CLIENT_STREAMING;
        }
    }

    @Deprecated
    public static <RequestT, ResponseT> MethodDescriptor<RequestT, ResponseT> create(MethodType type, String fullMethodName, Marshaller<RequestT> requestMarshaller, Marshaller<ResponseT> responseMarshaller) {
        return new MethodDescriptor<>(type, fullMethodName, requestMarshaller, responseMarshaller, null, false, false, false);
    }

    private MethodDescriptor(MethodType type, String fullMethodName, Marshaller<ReqT> requestMarshaller, Marshaller<RespT> responseMarshaller, Object schemaDescriptor, boolean idempotent, boolean safe, boolean sampledToLocalTracing) {
        this.rawMethodNames = new AtomicReferenceArray<>(2);
        if (safe && !idempotent) {
            throw new AssertionError("safe should imply idempotent");
        }
        this.type = (MethodType) Preconditions.checkNotNull(type, "type");
        this.fullMethodName = (String) Preconditions.checkNotNull(fullMethodName, "fullMethodName");
        this.serviceName = extractFullServiceName(fullMethodName);
        this.requestMarshaller = (Marshaller) Preconditions.checkNotNull(requestMarshaller, "requestMarshaller");
        this.responseMarshaller = (Marshaller) Preconditions.checkNotNull(responseMarshaller, "responseMarshaller");
        this.schemaDescriptor = schemaDescriptor;
        this.idempotent = idempotent;
        this.safe = safe;
        this.sampledToLocalTracing = sampledToLocalTracing;
    }

    public MethodType getType() {
        return this.type;
    }

    public String getFullMethodName() {
        return this.fullMethodName;
    }

    @Nullable
    public String getServiceName() {
        return this.serviceName;
    }

    @Nullable
    public String getBareMethodName() {
        return extractBareMethodName(this.fullMethodName);
    }

    public RespT parseResponse(InputStream input) {
        return this.responseMarshaller.parse(input);
    }

    public InputStream streamRequest(ReqT requestMessage) {
        return this.requestMarshaller.stream(requestMessage);
    }

    public ReqT parseRequest(InputStream input) {
        return this.requestMarshaller.parse(input);
    }

    public InputStream streamResponse(RespT response) {
        return this.responseMarshaller.stream(response);
    }

    public Marshaller<ReqT> getRequestMarshaller() {
        return this.requestMarshaller;
    }

    public Marshaller<RespT> getResponseMarshaller() {
        return this.responseMarshaller;
    }

    @Nullable
    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    public boolean isIdempotent() {
        return this.idempotent;
    }

    public boolean isSafe() {
        return this.safe;
    }

    public boolean isSampledToLocalTracing() {
        return this.sampledToLocalTracing;
    }

    public static String generateFullMethodName(String fullServiceName, String methodName) {
        return ((String) Preconditions.checkNotNull(fullServiceName, "fullServiceName")) + "/" + ((String) Preconditions.checkNotNull(methodName, "methodName"));
    }

    @Nullable
    public static String extractFullServiceName(String fullMethodName) {
        int index = ((String) Preconditions.checkNotNull(fullMethodName, "fullMethodName")).lastIndexOf(47);
        if (index == -1) {
            return null;
        }
        return fullMethodName.substring(0, index);
    }

    @Nullable
    public static String extractBareMethodName(String fullMethodName) {
        int index = ((String) Preconditions.checkNotNull(fullMethodName, "fullMethodName")).lastIndexOf(47);
        if (index == -1) {
            return null;
        }
        return fullMethodName.substring(index + 1);
    }

    @CheckReturnValue
    public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder() {
        return newBuilder(null, null);
    }

    @CheckReturnValue
    public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder(Marshaller<ReqT> requestMarshaller, Marshaller<RespT> responseMarshaller) {
        return new Builder().setRequestMarshaller(requestMarshaller).setResponseMarshaller(responseMarshaller);
    }

    @CheckReturnValue
    public Builder<ReqT, RespT> toBuilder() {
        return (Builder<ReqT, RespT>) toBuilder((Marshaller<ReqT>) this.requestMarshaller, (Marshaller<RespT>) this.responseMarshaller);
    }

    @CheckReturnValue
    public <NewReqT, NewRespT> Builder<NewReqT, NewRespT> toBuilder(Marshaller<NewReqT> requestMarshaller, Marshaller<NewRespT> responseMarshaller) {
        return (Builder<ReqT, RespT>) newBuilder().setRequestMarshaller(requestMarshaller).setResponseMarshaller(responseMarshaller).setType(this.type).setFullMethodName(this.fullMethodName).setIdempotent(this.idempotent).setSafe(this.safe).setSampledToLocalTracing(this.sampledToLocalTracing).setSchemaDescriptor(this.schemaDescriptor);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Builder<ReqT, RespT> {
        private String fullMethodName;
        private boolean idempotent;
        private Marshaller<ReqT> requestMarshaller;
        private Marshaller<RespT> responseMarshaller;
        private boolean safe;
        private boolean sampledToLocalTracing;
        private Object schemaDescriptor;
        private MethodType type;

        private Builder() {
        }

        public Builder<ReqT, RespT> setRequestMarshaller(Marshaller<ReqT> requestMarshaller) {
            this.requestMarshaller = requestMarshaller;
            return this;
        }

        public Builder<ReqT, RespT> setResponseMarshaller(Marshaller<RespT> responseMarshaller) {
            this.responseMarshaller = responseMarshaller;
            return this;
        }

        public Builder<ReqT, RespT> setType(MethodType type) {
            this.type = type;
            return this;
        }

        public Builder<ReqT, RespT> setFullMethodName(String fullMethodName) {
            this.fullMethodName = fullMethodName;
            return this;
        }

        public Builder<ReqT, RespT> setSchemaDescriptor(@Nullable Object schemaDescriptor) {
            this.schemaDescriptor = schemaDescriptor;
            return this;
        }

        public Builder<ReqT, RespT> setIdempotent(boolean idempotent) {
            this.idempotent = idempotent;
            if (!idempotent) {
                this.safe = false;
            }
            return this;
        }

        public Builder<ReqT, RespT> setSafe(boolean safe) {
            this.safe = safe;
            if (safe) {
                this.idempotent = true;
            }
            return this;
        }

        public Builder<ReqT, RespT> setSampledToLocalTracing(boolean value) {
            this.sampledToLocalTracing = value;
            return this;
        }

        @CheckReturnValue
        public MethodDescriptor<ReqT, RespT> build() {
            return new MethodDescriptor<>(this.type, this.fullMethodName, this.requestMarshaller, this.responseMarshaller, this.schemaDescriptor, this.idempotent, this.safe, this.sampledToLocalTracing);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("fullMethodName", this.fullMethodName).add("type", this.type).add("idempotent", this.idempotent).add("safe", this.safe).add("sampledToLocalTracing", this.sampledToLocalTracing).add("requestMarshaller", this.requestMarshaller).add("responseMarshaller", this.responseMarshaller).add("schemaDescriptor", this.schemaDescriptor).omitNullValues().toString();
    }
}