package io.grpc;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.tencent.open.SocialConstants;
import io.grpc.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class Status {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Throwable cause;
    private final Code code;
    private final String description;
    private static final String TEST_EQUALS_FAILURE_PROPERTY = "io.grpc.Status.failOnEqualsForTest";
    private static final boolean FAIL_ON_EQUALS_FOR_TEST = Boolean.parseBoolean(System.getProperty(TEST_EQUALS_FAILURE_PROPERTY, "false"));
    private static final List<Status> STATUS_LIST = buildStatusList();
    public static final Status OK = Code.OK.toStatus();
    public static final Status CANCELLED = Code.CANCELLED.toStatus();
    public static final Status UNKNOWN = Code.UNKNOWN.toStatus();
    public static final Status INVALID_ARGUMENT = Code.INVALID_ARGUMENT.toStatus();
    public static final Status DEADLINE_EXCEEDED = Code.DEADLINE_EXCEEDED.toStatus();
    public static final Status NOT_FOUND = Code.NOT_FOUND.toStatus();
    public static final Status ALREADY_EXISTS = Code.ALREADY_EXISTS.toStatus();
    public static final Status PERMISSION_DENIED = Code.PERMISSION_DENIED.toStatus();
    public static final Status UNAUTHENTICATED = Code.UNAUTHENTICATED.toStatus();
    public static final Status RESOURCE_EXHAUSTED = Code.RESOURCE_EXHAUSTED.toStatus();
    public static final Status FAILED_PRECONDITION = Code.FAILED_PRECONDITION.toStatus();
    public static final Status ABORTED = Code.ABORTED.toStatus();
    public static final Status OUT_OF_RANGE = Code.OUT_OF_RANGE.toStatus();
    public static final Status UNIMPLEMENTED = Code.UNIMPLEMENTED.toStatus();
    public static final Status INTERNAL = Code.INTERNAL.toStatus();
    public static final Status UNAVAILABLE = Code.UNAVAILABLE.toStatus();
    public static final Status DATA_LOSS = Code.DATA_LOSS.toStatus();
    static final Metadata.Key<Status> CODE_KEY = Metadata.Key.of("grpc-status", false, (Metadata.TrustedAsciiMarshaller) new StatusCodeMarshaller());
    private static final Metadata.TrustedAsciiMarshaller<String> STATUS_MESSAGE_MARSHALLER = new StatusMessageMarshaller();
    static final Metadata.Key<String> MESSAGE_KEY = Metadata.Key.of("grpc-message", false, (Metadata.TrustedAsciiMarshaller) STATUS_MESSAGE_MARSHALLER);

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        
        private final int value;
        private final byte[] valueAscii;

        Code(int value) {
            this.value = value;
            this.valueAscii = Integer.toString(value).getBytes(Charsets.US_ASCII);
        }

        public int value() {
            return this.value;
        }

        public Status toStatus() {
            return (Status) Status.STATUS_LIST.get(this.value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] valueAscii() {
            return this.valueAscii;
        }
    }

    private static List<Status> buildStatusList() {
        Code[] values;
        TreeMap<Integer, Status> canonicalizer = new TreeMap<>();
        for (Code code : Code.values()) {
            Status replaced = canonicalizer.put(Integer.valueOf(code.value()), new Status(code));
            if (replaced != null) {
                throw new IllegalStateException("Code value duplication between " + replaced.getCode().name() + " & " + code.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(canonicalizer.values()));
    }

    public static Status fromCodeValue(int codeValue) {
        if (codeValue < 0 || codeValue > STATUS_LIST.size()) {
            return UNKNOWN.withDescription("Unknown code " + codeValue);
        }
        return STATUS_LIST.get(codeValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status fromCodeValue(byte[] asciiCodeValue) {
        if (asciiCodeValue.length == 1 && asciiCodeValue[0] == 48) {
            return OK;
        }
        return fromCodeValueSlow(asciiCodeValue);
    }

    private static Status fromCodeValueSlow(byte[] asciiCodeValue) {
        int codeValue;
        int index = 0;
        int codeValue2 = 0;
        switch (asciiCodeValue.length) {
            case 1:
                if (asciiCodeValue[index] >= 48 && asciiCodeValue[index] <= 57 && (codeValue = codeValue2 + (asciiCodeValue[index] - 48)) < STATUS_LIST.size()) {
                    return STATUS_LIST.get(codeValue);
                }
                return UNKNOWN.withDescription("Unknown code " + new String(asciiCodeValue, Charsets.US_ASCII));
            case 2:
                if (asciiCodeValue[0] >= 48 && asciiCodeValue[0] <= 57) {
                    int index2 = 0 + 1;
                    int index3 = asciiCodeValue[0];
                    codeValue2 = 0 + ((index3 - 48) * 10);
                    index = index2;
                    if (asciiCodeValue[index] >= 48) {
                        return STATUS_LIST.get(codeValue);
                    }
                }
                return UNKNOWN.withDescription("Unknown code " + new String(asciiCodeValue, Charsets.US_ASCII));
            default:
                return UNKNOWN.withDescription("Unknown code " + new String(asciiCodeValue, Charsets.US_ASCII));
        }
    }

    public static Status fromCode(Code code) {
        return code.toStatus();
    }

    public static Status fromThrowable(Throwable t) {
        for (Throwable cause = (Throwable) Preconditions.checkNotNull(t, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                return ((StatusException) cause).getStatus();
            }
            if (cause instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) cause).getStatus();
            }
        }
        return UNKNOWN.withCause(t);
    }

    @Nullable
    public static Metadata trailersFromThrowable(Throwable t) {
        for (Throwable cause = (Throwable) Preconditions.checkNotNull(t, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                return ((StatusException) cause).getTrailers();
            }
            if (cause instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) cause).getTrailers();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String formatThrowableMessage(Status status) {
        if (status.description == null) {
            return status.code.toString();
        }
        return status.code + ": " + status.description;
    }

    private Status(Code code) {
        this(code, null, null);
    }

    private Status(Code code, @Nullable String description, @Nullable Throwable cause) {
        this.code = (Code) Preconditions.checkNotNull(code, "code");
        this.description = description;
        this.cause = cause;
    }

    public Status withCause(Throwable cause) {
        if (Objects.equal(this.cause, cause)) {
            return this;
        }
        return new Status(this.code, this.description, cause);
    }

    public Status withDescription(String description) {
        if (Objects.equal(this.description, description)) {
            return this;
        }
        return new Status(this.code, description, this.cause);
    }

    public Status augmentDescription(String additionalDetail) {
        if (additionalDetail == null) {
            return this;
        }
        if (this.description == null) {
            return new Status(this.code, additionalDetail, this.cause);
        }
        return new Status(this.code, this.description + "\n" + additionalDetail, this.cause);
    }

    public Code getCode() {
        return this.code;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    public boolean isOk() {
        return Code.OK == this.code;
    }

    public StatusRuntimeException asRuntimeException() {
        return new StatusRuntimeException(this);
    }

    public StatusRuntimeException asRuntimeException(@Nullable Metadata trailers) {
        return new StatusRuntimeException(this, trailers);
    }

    public StatusException asException() {
        return new StatusException(this);
    }

    public StatusException asException(@Nullable Metadata trailers) {
        return new StatusException(this, trailers);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("code", this.code.name()).add(SocialConstants.PARAM_COMMENT, this.description).add("cause", this.cause != null ? Throwables.getStackTraceAsString(this.cause) : this.cause).toString();
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class StatusCodeMarshaller implements Metadata.TrustedAsciiMarshaller<Status> {
        private StatusCodeMarshaller() {
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(Status status) {
            return status.getCode().valueAscii();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public Status parseAsciiString(byte[] serialized) {
            return Status.fromCodeValue(serialized);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class StatusMessageMarshaller implements Metadata.TrustedAsciiMarshaller<String> {
        private static final byte[] HEX = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        private StatusMessageMarshaller() {
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(String value) {
            byte[] valueBytes = value.getBytes(Charsets.UTF_8);
            for (int i2 = 0; i2 < valueBytes.length; i2++) {
                byte b = valueBytes[i2];
                if (isEscapingChar(b)) {
                    return toAsciiStringSlow(valueBytes, i2);
                }
            }
            return valueBytes;
        }

        private static boolean isEscapingChar(byte b) {
            return b < 32 || b >= 126 || b == 37;
        }

        private static byte[] toAsciiStringSlow(byte[] valueBytes, int ri) {
            byte[] escapedBytes = new byte[((valueBytes.length - ri) * 3) + ri];
            if (ri != 0) {
                System.arraycopy(valueBytes, 0, escapedBytes, 0, ri);
            }
            int wi = ri;
            while (ri < valueBytes.length) {
                byte b = valueBytes[ri];
                if (isEscapingChar(b)) {
                    escapedBytes[wi] = 37;
                    escapedBytes[wi + 1] = HEX[(b >> 4) & 15];
                    escapedBytes[wi + 2] = HEX[b & 15];
                    wi += 3;
                } else {
                    escapedBytes[wi] = b;
                    wi++;
                }
                ri++;
            }
            return Arrays.copyOf(escapedBytes, wi);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public String parseAsciiString(byte[] value) {
            for (int i2 = 0; i2 < value.length; i2++) {
                byte b = value[i2];
                if (b < 32 || b >= 126 || (b == 37 && i2 + 2 < value.length)) {
                    return parseAsciiStringSlow(value);
                }
            }
            return new String(value, 0);
        }

        private static String parseAsciiStringSlow(byte[] value) {
            ByteBuffer buf = ByteBuffer.allocate(value.length);
            int i2 = 0;
            while (i2 < value.length) {
                if (value[i2] == 37 && i2 + 2 < value.length) {
                    try {
                        buf.put((byte) Integer.parseInt(new String(value, i2 + 1, 2, Charsets.US_ASCII), 16));
                        i2 += 3;
                    } catch (NumberFormatException e2) {
                    }
                }
                buf.put(value[i2]);
                i2++;
            }
            return new String(buf.array(), 0, buf.position(), Charsets.UTF_8);
        }
    }

    public boolean equals(Object obj) {
        if (FAIL_ON_EQUALS_FOR_TEST) {
            throw new AssertionError("Status.equals called; disable this by setting io.grpc.Status.failOnEqualsForTest");
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}