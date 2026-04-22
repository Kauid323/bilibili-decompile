package io.grpc.protobuf.lite;

import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.KnownLength;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class ProtoLiteUtils {
    private static final int BUF_SIZE = 8192;
    static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
    static volatile ExtensionRegistryLite globalRegistry = ExtensionRegistryLite.getEmptyRegistry();

    public static void setExtensionRegistry(ExtensionRegistryLite newRegistry) {
        globalRegistry = (ExtensionRegistryLite) Preconditions.checkNotNull(newRegistry, "newRegistry");
    }

    public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshaller(T defaultInstance) {
        return new MessageMarshaller(defaultInstance);
    }

    public static <T extends MessageLite> Metadata.BinaryMarshaller<T> metadataMarshaller(T defaultInstance) {
        return new MetadataMarshaller(defaultInstance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long copy(InputStream from, OutputStream to) throws IOException {
        Preconditions.checkNotNull(from, "inputStream cannot be null!");
        Preconditions.checkNotNull(to, "outputStream cannot be null!");
        byte[] buf = new byte[8192];
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r != -1) {
                to.write(buf, 0, r);
                total += r;
            } else {
                return total;
            }
        }
    }

    private ProtoLiteUtils() {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class MessageMarshaller<T extends MessageLite> implements MethodDescriptor.PrototypeMarshaller<T> {
        private static final ThreadLocal<Reference<byte[]>> bufs = new ThreadLocal<>();
        private final T defaultInstance;
        private final Parser<T> parser;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.MethodDescriptor.Marshaller
        public /* bridge */ /* synthetic */ InputStream stream(Object obj) {
            return stream((MessageMarshaller<T>) ((MessageLite) obj));
        }

        MessageMarshaller(T defaultInstance) {
            this.defaultInstance = defaultInstance;
            this.parser = defaultInstance.getParserForType();
        }

        @Override // io.grpc.MethodDescriptor.ReflectableMarshaller
        public Class<T> getMessageClass() {
            return (Class<T>) this.defaultInstance.getClass();
        }

        @Override // io.grpc.MethodDescriptor.PrototypeMarshaller
        public T getMessagePrototype() {
            return this.defaultInstance;
        }

        public InputStream stream(T value) {
            return new ProtoInputStream(value, this.parser);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
            if (r4.length >= r1) goto L25;
         */
        @Override // io.grpc.MethodDescriptor.Marshaller
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public T parse(InputStream stream) {
            byte[] buf;
            if (stream instanceof ProtoInputStream) {
                ProtoInputStream protoStream = (ProtoInputStream) stream;
                if (protoStream.parser() == this.parser) {
                    try {
                        T message = (T) ((ProtoInputStream) stream).message();
                        return message;
                    } catch (IllegalStateException e2) {
                    }
                }
            }
            CodedInputStream cis = null;
            try {
                if (stream instanceof KnownLength) {
                    int size = stream.available();
                    if (size > 0 && size <= 4194304) {
                        Reference<byte[]> ref = bufs.get();
                        if (ref != null) {
                            byte[] bArr = ref.get();
                            buf = bArr;
                            if (bArr != null) {
                            }
                        }
                        buf = new byte[size];
                        bufs.set(new WeakReference(buf));
                        int remaining = size;
                        while (remaining > 0) {
                            int position = size - remaining;
                            int count = stream.read(buf, position, remaining);
                            if (count == -1) {
                                break;
                            }
                            remaining -= count;
                        }
                        if (remaining != 0) {
                            int position2 = size - remaining;
                            throw new RuntimeException("size inaccurate: " + size + " != " + position2);
                        }
                        cis = CodedInputStream.newInstance(buf, 0, size);
                    } else if (size == 0) {
                        return this.defaultInstance;
                    }
                }
                if (cis == null) {
                    cis = CodedInputStream.newInstance(stream);
                }
                cis.setSizeLimit(Integer.MAX_VALUE);
                try {
                    return parseFrom(cis);
                } catch (InvalidProtocolBufferException e3) {
                    throw Status.INTERNAL.withDescription("Invalid protobuf byte sequence").withCause(e3).asRuntimeException();
                }
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }

        private T parseFrom(CodedInputStream stream) throws InvalidProtocolBufferException {
            T message = (T) this.parser.parseFrom(stream, ProtoLiteUtils.globalRegistry);
            try {
                stream.checkLastTagWas(0);
                return message;
            } catch (InvalidProtocolBufferException e2) {
                e2.setUnfinishedMessage(message);
                throw e2;
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class MetadataMarshaller<T extends MessageLite> implements Metadata.BinaryMarshaller<T> {
        private final T defaultInstance;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.Metadata.BinaryMarshaller
        public /* bridge */ /* synthetic */ byte[] toBytes(Object obj) {
            return toBytes((MetadataMarshaller<T>) ((MessageLite) obj));
        }

        MetadataMarshaller(T defaultInstance) {
            this.defaultInstance = defaultInstance;
        }

        public byte[] toBytes(T value) {
            return value.toByteArray();
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public T parseBytes(byte[] serialized) {
            try {
                return (T) this.defaultInstance.getParserForType().parseFrom(serialized, ProtoLiteUtils.globalRegistry);
            } catch (InvalidProtocolBufferException ipbe) {
                throw new IllegalArgumentException((Throwable) ipbe);
            }
        }
    }
}