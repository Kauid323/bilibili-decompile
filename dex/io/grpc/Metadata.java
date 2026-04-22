package io.grpc;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import com.tencent.smtt.sdk.TbsListener;
import faceverify.q;
import io.ktor.http.ContentDisposition;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

public final class Metadata {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String BINARY_HEADER_SUFFIX = "-bin";
    private Object[] namesAndValues;
    private int size;
    public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER = new BinaryMarshaller<byte[]>() { // from class: io.grpc.Metadata.1
        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(byte[] value) {
            return value;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] parseBytes(byte[] serialized) {
            return serialized;
        }
    };
    public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() { // from class: io.grpc.Metadata.2
        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(String value) {
            return value;
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String parseAsciiString(String serialized) {
            return serialized;
        }
    };
    static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = BaseEncoding.base64().omitPadding();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface AsciiMarshaller<T> {
        T parseAsciiString(String str);

        String toAsciiString(T t);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface BinaryMarshaller<T> {
        T parseBytes(byte[] bArr);

        byte[] toBytes(T t);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface BinaryStreamMarshaller<T> {
        T parseStream(InputStream inputStream);

        InputStream toStream(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface TrustedAsciiMarshaller<T> {
        T parseAsciiString(byte[] bArr);

        byte[] toAsciiString(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(byte[]... binaryValues) {
        this(binaryValues.length / 2, binaryValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(int usedNames, byte[]... binaryValues) {
        this(usedNames, (Object[]) binaryValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(int usedNames, Object[] namesAndValues) {
        if ((namesAndValues.length & 1) != 0) {
            throw new AssertionError("Odd number of key-value pairs " + namesAndValues.length);
        }
        this.size = usedNames;
        this.namesAndValues = namesAndValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] name(int i2) {
        return (byte[]) this.namesAndValues[i2 * 2];
    }

    private void name(int i2, byte[] name) {
        this.namesAndValues[i2 * 2] = name;
    }

    private Object value(int i2) {
        return this.namesAndValues[(i2 * 2) + 1];
    }

    private void value(int i2, byte[] value) {
        this.namesAndValues[(i2 * 2) + 1] = value;
    }

    private void value(int i2, Object value) {
        if (this.namesAndValues instanceof byte[][]) {
            expand(cap());
        }
        this.namesAndValues[(i2 * 2) + 1] = value;
    }

    private byte[] valueAsBytes(int i2) {
        Object value = value(i2);
        if (value instanceof byte[]) {
            return (byte[]) value;
        }
        return ((LazyValue) value).toBytes();
    }

    private Object valueAsBytesOrStream(int i2) {
        Object value = value(i2);
        if (value instanceof byte[]) {
            return value;
        }
        return ((LazyValue) value).toStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T valueAsT(int i2, Key<T> key) {
        Object value = value(i2);
        if (value instanceof byte[]) {
            return key.parseBytes((byte[]) value);
        }
        return (T) ((LazyValue) value).toObject(key);
    }

    private int cap() {
        if (this.namesAndValues != null) {
            return this.namesAndValues.length;
        }
        return 0;
    }

    private int len() {
        return this.size * 2;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public Metadata() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int headerCount() {
        return this.size;
    }

    public boolean containsKey(Key<?> key) {
        for (int i2 = 0; i2 < this.size; i2++) {
            if (bytesEqual(key.asciiName(), name(i2))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public <T> T get(Key<T> key) {
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            if (bytesEqual(key.asciiName(), name(i2))) {
                return (T) valueAsT(i2, key);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class IterableAt<T> implements Iterable<T> {
        private final Key<T> key;
        private int startIdx;

        private IterableAt(Key<T> key, int startIdx) {
            this.key = key;
            this.startIdx = startIdx;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: io.grpc.Metadata.IterableAt.1
                private boolean hasNext = true;
                private int idx;

                {
                    this.idx = IterableAt.this.startIdx;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.hasNext) {
                        return true;
                    }
                    while (this.idx < Metadata.this.size) {
                        if (!Metadata.this.bytesEqual(IterableAt.this.key.asciiName(), Metadata.this.name(this.idx))) {
                            this.idx++;
                        } else {
                            this.hasNext = true;
                            return this.hasNext;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public T next() {
                    if (hasNext()) {
                        this.hasNext = false;
                        Metadata metadata = Metadata.this;
                        int i2 = this.idx;
                        this.idx = i2 + 1;
                        return (T) metadata.valueAsT(i2, IterableAt.this.key);
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    @Nullable
    public <T> Iterable<T> getAll(Key<T> key) {
        for (int i2 = 0; i2 < this.size; i2++) {
            if (bytesEqual(key.asciiName(), name(i2))) {
                return new IterableAt(key, i2);
            }
        }
        return null;
    }

    public Set<String> keys() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> ks = new HashSet<>(this.size);
        for (int i2 = 0; i2 < this.size; i2++) {
            ks.add(new String(name(i2), 0));
        }
        return Collections.unmodifiableSet(ks);
    }

    public <T> void put(Key<T> key, T value) {
        Preconditions.checkNotNull(key, q.KEY_RES_9_KEY);
        Preconditions.checkNotNull(value, "value");
        maybeExpand();
        name(this.size, key.asciiName());
        if (key.serializesToStreams()) {
            value(this.size, LazyValue.create(key, value));
        } else {
            value(this.size, key.toBytes(value));
        }
        this.size++;
    }

    private void maybeExpand() {
        if (len() == 0 || len() == cap()) {
            expand(Math.max(len() * 2, 8));
        }
    }

    private void expand(int newCapacity) {
        Object[] newNamesAndValues = new Object[newCapacity];
        if (!isEmpty()) {
            System.arraycopy(this.namesAndValues, 0, newNamesAndValues, 0, len());
        }
        this.namesAndValues = newNamesAndValues;
    }

    public <T> boolean remove(Key<T> key, T value) {
        Preconditions.checkNotNull(key, q.KEY_RES_9_KEY);
        Preconditions.checkNotNull(value, "value");
        for (int i2 = 0; i2 < this.size; i2++) {
            if (bytesEqual(key.asciiName(), name(i2)) && value.equals(valueAsT(i2, key))) {
                int writeIdx = i2 * 2;
                int readIdx = (i2 + 1) * 2;
                int readLen = len() - readIdx;
                System.arraycopy(this.namesAndValues, readIdx, this.namesAndValues, writeIdx, readLen);
                this.size--;
                name(this.size, null);
                value(this.size, (byte[]) null);
                return true;
            }
        }
        return false;
    }

    public <T> Iterable<T> removeAll(Key<T> key) {
        if (isEmpty()) {
            return null;
        }
        int writeIdx = 0;
        ArrayList arrayList = null;
        for (int readIdx = 0; readIdx < this.size; readIdx++) {
            if (bytesEqual(key.asciiName(), name(readIdx))) {
                arrayList = arrayList != null ? arrayList : new ArrayList();
                arrayList.add(valueAsT(readIdx, key));
            } else {
                name(writeIdx, name(readIdx));
                value(writeIdx, value(readIdx));
                writeIdx++;
            }
        }
        int newSize = writeIdx;
        Arrays.fill(this.namesAndValues, writeIdx * 2, len(), (Object) null);
        this.size = newSize;
        return arrayList;
    }

    public <T> void discardAll(Key<T> key) {
        if (isEmpty()) {
            return;
        }
        int writeIdx = 0;
        for (int readIdx = 0; readIdx < this.size; readIdx++) {
            if (!bytesEqual(key.asciiName(), name(readIdx))) {
                name(writeIdx, name(readIdx));
                value(writeIdx, value(readIdx));
                writeIdx++;
            }
        }
        int newSize = writeIdx;
        Arrays.fill(this.namesAndValues, writeIdx * 2, len(), (Object) null);
        this.size = newSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public byte[][] serialize() {
        byte[][] serialized = new byte[len()];
        if (this.namesAndValues instanceof byte[][]) {
            System.arraycopy(this.namesAndValues, 0, serialized, 0, len());
        } else {
            for (int i2 = 0; i2 < this.size; i2++) {
                serialized[i2 * 2] = name(i2);
                serialized[(i2 * 2) + 1] = valueAsBytes(i2);
            }
        }
        return serialized;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object[] serializePartial() {
        Object[] serialized = new Object[len()];
        for (int i2 = 0; i2 < this.size; i2++) {
            serialized[i2 * 2] = name(i2);
            serialized[(i2 * 2) + 1] = valueAsBytesOrStream(i2);
        }
        return serialized;
    }

    public void merge(Metadata other) {
        if (other.isEmpty()) {
            return;
        }
        int remaining = cap() - len();
        if (isEmpty() || remaining < other.len()) {
            expand(len() + other.len());
        }
        System.arraycopy(other.namesAndValues, 0, this.namesAndValues, len(), other.len());
        this.size += other.size;
    }

    public void merge(Metadata other, Set<Key<?>> keys) {
        Preconditions.checkNotNull(other, "other");
        Map<ByteBuffer, Key<?>> asciiKeys = new HashMap<>(keys.size());
        for (Key<?> key : keys) {
            asciiKeys.put(ByteBuffer.wrap(key.asciiName()), key);
        }
        for (int i2 = 0; i2 < other.size; i2++) {
            ByteBuffer wrappedNamed = ByteBuffer.wrap(other.name(i2));
            if (asciiKeys.containsKey(wrappedNamed)) {
                maybeExpand();
                name(this.size, other.name(i2));
                value(this.size, other.value(i2));
                this.size++;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i2 = 0; i2 < this.size; i2++) {
            if (i2 != 0) {
                sb.append(',');
            }
            String headerName = new String(name(i2), Charsets.US_ASCII);
            sb.append(headerName).append('=');
            if (headerName.endsWith(BINARY_HEADER_SUFFIX)) {
                sb.append(BASE64_ENCODING_OMIT_PADDING.encode(valueAsBytes(i2)));
            } else {
                String headerValue = new String(valueAsBytes(i2), Charsets.US_ASCII);
                sb.append(headerValue);
            }
        }
        return sb.append(')').toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytesEqual(byte[] left, byte[] right) {
        return Arrays.equals(left, right);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Key<T> {
        private static final BitSet VALID_T_CHARS = generateValidTChars();
        private final Object marshaller;
        private final String name;
        private final byte[] nameBytes;
        private final String originalName;

        abstract T parseBytes(byte[] bArr);

        abstract byte[] toBytes(T t);

        public static <T> Key<T> of(String name, BinaryMarshaller<T> marshaller) {
            return new BinaryKey(name, marshaller);
        }

        public static <T> Key<T> of(String name, BinaryStreamMarshaller<T> marshaller) {
            return new LazyStreamBinaryKey(name, marshaller);
        }

        public static <T> Key<T> of(String name, AsciiMarshaller<T> marshaller) {
            return of(name, false, (AsciiMarshaller) marshaller);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> Key<T> of(String name, boolean pseudo, AsciiMarshaller<T> marshaller) {
            return new AsciiKey(name, pseudo, marshaller);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> Key<T> of(String name, boolean pseudo, TrustedAsciiMarshaller<T> marshaller) {
            return new TrustedAsciiKey(name, pseudo, marshaller);
        }

        private static BitSet generateValidTChars() {
            BitSet valid = new BitSet(TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME);
            valid.set(45);
            valid.set(95);
            valid.set(46);
            for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
                valid.set(c);
            }
            for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
                valid.set(c2);
            }
            return valid;
        }

        private static String validateName(String n, boolean pseudo) {
            Preconditions.checkNotNull(n, ContentDisposition.Parameters.Name);
            Preconditions.checkArgument(!n.isEmpty(), "token must have at least 1 tchar");
            for (int i2 = 0; i2 < n.length(); i2++) {
                char tChar = n.charAt(i2);
                if (!pseudo || tChar != ':' || i2 != 0) {
                    Preconditions.checkArgument(VALID_T_CHARS.get(tChar), "Invalid character '%s' in key name '%s'", tChar, n);
                }
            }
            return n;
        }

        private Key(String name, boolean pseudo, Object marshaller) {
            this.originalName = (String) Preconditions.checkNotNull(name, ContentDisposition.Parameters.Name);
            this.name = validateName(this.originalName.toLowerCase(Locale.ROOT), pseudo);
            this.nameBytes = this.name.getBytes(Charsets.US_ASCII);
            this.marshaller = marshaller;
        }

        public final String originalName() {
            return this.originalName;
        }

        public final String name() {
            return this.name;
        }

        byte[] asciiName() {
            return this.nameBytes;
        }

        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Key<?> key = (Key) o;
            return this.name.equals(key.name);
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Key{name='" + this.name + "'}";
        }

        boolean serializesToStreams() {
            return false;
        }

        @Nullable
        final <M> M getMarshaller(Class<M> marshallerClass) {
            if (marshallerClass.isInstance(this.marshaller)) {
                return marshallerClass.cast(this.marshaller);
            }
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static class BinaryKey<T> extends Key<T> {
        private final BinaryMarshaller<T> marshaller;

        private BinaryKey(String name, BinaryMarshaller<T> marshaller) {
            super(name, false, marshaller);
            Preconditions.checkArgument(name.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", name, Metadata.BINARY_HEADER_SUFFIX);
            Preconditions.checkArgument(name.length() > Metadata.BINARY_HEADER_SUFFIX.length(), "empty key name");
            this.marshaller = (BinaryMarshaller) Preconditions.checkNotNull(marshaller, "marshaller is null");
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T value) {
            return this.marshaller.toBytes(value);
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] serialized) {
            return this.marshaller.parseBytes(serialized);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static class LazyStreamBinaryKey<T> extends Key<T> {
        private final BinaryStreamMarshaller<T> marshaller;

        private LazyStreamBinaryKey(String name, BinaryStreamMarshaller<T> marshaller) {
            super(name, false, marshaller);
            Preconditions.checkArgument(name.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", name, Metadata.BINARY_HEADER_SUFFIX);
            Preconditions.checkArgument(name.length() > Metadata.BINARY_HEADER_SUFFIX.length(), "empty key name");
            this.marshaller = (BinaryStreamMarshaller) Preconditions.checkNotNull(marshaller, "marshaller is null");
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T value) {
            return Metadata.streamToBytes(this.marshaller.toStream(value));
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] serialized) {
            return this.marshaller.parseStream(new ByteArrayInputStream(serialized));
        }

        @Override // io.grpc.Metadata.Key
        boolean serializesToStreams() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LazyValue<T> {
        private final BinaryStreamMarshaller<T> marshaller;
        private volatile byte[] serialized;
        private final T value;

        static <T> LazyValue<T> create(Key<T> key, T value) {
            return new LazyValue<>((BinaryStreamMarshaller) Preconditions.checkNotNull(getBinaryStreamMarshaller(key)), value);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LazyValue(BinaryStreamMarshaller<T> marshaller, T value) {
            this.marshaller = marshaller;
            this.value = value;
        }

        InputStream toStream() {
            return this.marshaller.toStream(this.value);
        }

        byte[] toBytes() {
            if (this.serialized == null) {
                synchronized (this) {
                    if (this.serialized == null) {
                        this.serialized = Metadata.streamToBytes(toStream());
                    }
                }
            }
            return this.serialized;
        }

        <T2> T2 toObject(Key<T2> key) {
            BinaryStreamMarshaller<T2> marshaller;
            if (key.serializesToStreams() && (marshaller = getBinaryStreamMarshaller(key)) != null) {
                return marshaller.parseStream(toStream());
            }
            return key.parseBytes(toBytes());
        }

        @Nullable
        private static <T> BinaryStreamMarshaller<T> getBinaryStreamMarshaller(Key<T> key) {
            return (BinaryStreamMarshaller) key.getMarshaller(BinaryStreamMarshaller.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static class AsciiKey<T> extends Key<T> {
        private final AsciiMarshaller<T> marshaller;

        private AsciiKey(String name, boolean pseudo, AsciiMarshaller<T> marshaller) {
            super(name, pseudo, marshaller);
            Preconditions.checkArgument(!name.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", name, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (AsciiMarshaller) Preconditions.checkNotNull(marshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T value) {
            return this.marshaller.toAsciiString(value).getBytes(Charsets.US_ASCII);
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] serialized) {
            return this.marshaller.parseAsciiString(new String(serialized, Charsets.US_ASCII));
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    private static final class TrustedAsciiKey<T> extends Key<T> {
        private final TrustedAsciiMarshaller<T> marshaller;

        private TrustedAsciiKey(String name, boolean pseudo, TrustedAsciiMarshaller<T> marshaller) {
            super(name, pseudo, marshaller);
            Preconditions.checkArgument(!name.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", name, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (TrustedAsciiMarshaller) Preconditions.checkNotNull(marshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T value) {
            return this.marshaller.toAsciiString(value);
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] serialized) {
            return this.marshaller.parseAsciiString(serialized);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] streamToBytes(InputStream stream) {
        try {
            return ByteStreams.toByteArray(stream);
        } catch (IOException ioe) {
            throw new RuntimeException("failure reading serialized stream", ioe);
        }
    }
}