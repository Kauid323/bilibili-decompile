package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import faceverify.q;
import io.grpc.ClientStreamTracer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class CallOptions {
    public static final CallOptions DEFAULT = new CallOptions();
    @Nullable
    private String authority;
    @Nullable
    private String compressorName;
    @Nullable
    private CallCredentials credentials;
    private Object[][] customOptions;
    @Nullable
    private Deadline deadline;
    @Nullable
    private Executor executor;
    @Nullable
    private Integer maxInboundMessageSize;
    @Nullable
    private Integer maxOutboundMessageSize;
    private List<ClientStreamTracer.Factory> streamTracerFactories;
    @Nullable
    private Boolean waitForReady;

    public CallOptions withAuthority(@Nullable String authority) {
        CallOptions newOptions = new CallOptions(this);
        newOptions.authority = authority;
        return newOptions;
    }

    public CallOptions withCallCredentials(@Nullable CallCredentials credentials) {
        CallOptions newOptions = new CallOptions(this);
        newOptions.credentials = credentials;
        return newOptions;
    }

    public CallOptions withCompression(@Nullable String compressorName) {
        CallOptions newOptions = new CallOptions(this);
        newOptions.compressorName = compressorName;
        return newOptions;
    }

    public CallOptions withDeadline(@Nullable Deadline deadline) {
        CallOptions newOptions = new CallOptions(this);
        newOptions.deadline = deadline;
        return newOptions;
    }

    public CallOptions withDeadlineAfter(long duration, TimeUnit unit) {
        return withDeadline(Deadline.after(duration, unit));
    }

    @Nullable
    public Deadline getDeadline() {
        return this.deadline;
    }

    public CallOptions withWaitForReady() {
        CallOptions newOptions = new CallOptions(this);
        newOptions.waitForReady = Boolean.TRUE;
        return newOptions;
    }

    public CallOptions withoutWaitForReady() {
        CallOptions newOptions = new CallOptions(this);
        newOptions.waitForReady = Boolean.FALSE;
        return newOptions;
    }

    @Nullable
    public String getCompressor() {
        return this.compressorName;
    }

    @Nullable
    public String getAuthority() {
        return this.authority;
    }

    @Nullable
    public CallCredentials getCredentials() {
        return this.credentials;
    }

    public CallOptions withExecutor(@Nullable Executor executor) {
        CallOptions newOptions = new CallOptions(this);
        newOptions.executor = executor;
        return newOptions;
    }

    public CallOptions withStreamTracerFactory(ClientStreamTracer.Factory factory) {
        CallOptions newOptions = new CallOptions(this);
        ArrayList<ClientStreamTracer.Factory> newList = new ArrayList<>(this.streamTracerFactories.size() + 1);
        newList.addAll(this.streamTracerFactories);
        newList.add(factory);
        newOptions.streamTracerFactories = Collections.unmodifiableList(newList);
        return newOptions;
    }

    public List<ClientStreamTracer.Factory> getStreamTracerFactories() {
        return this.streamTracerFactories;
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Key<T> {
        private final String debugString;
        private final T defaultValue;

        private Key(String debugString, T defaultValue) {
            this.debugString = debugString;
            this.defaultValue = defaultValue;
        }

        public T getDefault() {
            return this.defaultValue;
        }

        public String toString() {
            return this.debugString;
        }

        @Deprecated
        public static <T> Key<T> of(String debugString, T defaultValue) {
            Preconditions.checkNotNull(debugString, "debugString");
            return new Key<>(debugString, defaultValue);
        }

        public static <T> Key<T> create(String debugString) {
            Preconditions.checkNotNull(debugString, "debugString");
            return new Key<>(debugString, null);
        }

        public static <T> Key<T> createWithDefault(String debugString, T defaultValue) {
            Preconditions.checkNotNull(debugString, "debugString");
            return new Key<>(debugString, defaultValue);
        }
    }

    public <T> CallOptions withOption(Key<T> key, T value) {
        Preconditions.checkNotNull(key, q.KEY_RES_9_KEY);
        Preconditions.checkNotNull(value, "value");
        CallOptions newOptions = new CallOptions(this);
        int existingIdx = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= this.customOptions.length) {
                break;
            } else if (!key.equals(this.customOptions[i2][0])) {
                i2++;
            } else {
                existingIdx = i2;
                break;
            }
        }
        newOptions.customOptions = (Object[][]) Array.newInstance(Object.class, this.customOptions.length + (existingIdx == -1 ? 1 : 0), 2);
        System.arraycopy(this.customOptions, 0, newOptions.customOptions, 0, this.customOptions.length);
        if (existingIdx == -1) {
            Object[][] objArr = newOptions.customOptions;
            int length = this.customOptions.length;
            Object[] objArr2 = new Object[2];
            objArr2[0] = key;
            objArr2[1] = value;
            objArr[length] = objArr2;
        } else {
            Object[][] objArr3 = newOptions.customOptions;
            Object[] objArr4 = new Object[2];
            objArr4[0] = key;
            objArr4[1] = value;
            objArr3[existingIdx] = objArr4;
        }
        return newOptions;
    }

    public <T> T getOption(Key<T> key) {
        Preconditions.checkNotNull(key, q.KEY_RES_9_KEY);
        for (int i2 = 0; i2 < this.customOptions.length; i2++) {
            if (key.equals(this.customOptions[i2][0])) {
                return (T) this.customOptions[i2][1];
            }
        }
        return (T) ((Key) key).defaultValue;
    }

    @Nullable
    public Executor getExecutor() {
        return this.executor;
    }

    private CallOptions() {
        this.streamTracerFactories = Collections.emptyList();
        this.customOptions = (Object[][]) Array.newInstance(Object.class, 0, 2);
    }

    public boolean isWaitForReady() {
        return Boolean.TRUE.equals(this.waitForReady);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Boolean getWaitForReady() {
        return this.waitForReady;
    }

    public CallOptions withMaxInboundMessageSize(int maxSize) {
        Preconditions.checkArgument(maxSize >= 0, "invalid maxsize %s", maxSize);
        CallOptions newOptions = new CallOptions(this);
        newOptions.maxInboundMessageSize = Integer.valueOf(maxSize);
        return newOptions;
    }

    public CallOptions withMaxOutboundMessageSize(int maxSize) {
        Preconditions.checkArgument(maxSize >= 0, "invalid maxsize %s", maxSize);
        CallOptions newOptions = new CallOptions(this);
        newOptions.maxOutboundMessageSize = Integer.valueOf(maxSize);
        return newOptions;
    }

    @Nullable
    public Integer getMaxInboundMessageSize() {
        return this.maxInboundMessageSize;
    }

    @Nullable
    public Integer getMaxOutboundMessageSize() {
        return this.maxOutboundMessageSize;
    }

    private CallOptions(CallOptions other) {
        this.streamTracerFactories = Collections.emptyList();
        this.deadline = other.deadline;
        this.authority = other.authority;
        this.credentials = other.credentials;
        this.executor = other.executor;
        this.compressorName = other.compressorName;
        this.customOptions = other.customOptions;
        this.waitForReady = other.waitForReady;
        this.maxInboundMessageSize = other.maxInboundMessageSize;
        this.maxOutboundMessageSize = other.maxOutboundMessageSize;
        this.streamTracerFactories = other.streamTracerFactories;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("deadline", this.deadline).add("authority", this.authority).add("callCredentials", this.credentials).add("executor", this.executor != null ? this.executor.getClass() : null).add("compressorName", this.compressorName).add("customOptions", Arrays.deepToString(this.customOptions)).add("waitForReady", isWaitForReady()).add("maxInboundMessageSize", this.maxInboundMessageSize).add("maxOutboundMessageSize", this.maxOutboundMessageSize).add("streamTracerFactories", this.streamTracerFactories).toString();
    }
}