package io.grpc;

import com.google.common.io.BaseEncoding;
import io.grpc.Metadata;
import java.nio.charset.Charset;

public final class InternalMetadata {
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = Metadata.BASE64_ENCODING_OMIT_PADDING;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface TrustedAsciiMarshaller<T> extends Metadata.TrustedAsciiMarshaller<T> {
    }

    public static <T> Metadata.Key<T> keyOf(String name, TrustedAsciiMarshaller<T> marshaller) {
        boolean isPseudo = false;
        if (name != null && !name.isEmpty() && name.charAt(0) == ':') {
            isPseudo = true;
        }
        return Metadata.Key.of(name, isPseudo, marshaller);
    }

    public static <T> Metadata.Key<T> keyOf(String name, Metadata.AsciiMarshaller<T> marshaller) {
        boolean isPseudo = false;
        if (name != null && !name.isEmpty() && name.charAt(0) == ':') {
            isPseudo = true;
        }
        return Metadata.Key.of(name, isPseudo, marshaller);
    }

    public static Metadata newMetadata(byte[]... binaryValues) {
        return new Metadata(binaryValues);
    }

    public static Metadata newMetadata(int usedNames, byte[]... binaryValues) {
        return new Metadata(usedNames, binaryValues);
    }

    public static byte[][] serialize(Metadata md) {
        return md.serialize();
    }

    public static int headerCount(Metadata md) {
        return md.headerCount();
    }

    public static Object[] serializePartial(Metadata md) {
        return md.serializePartial();
    }

    public static <T> Object parsedValue(Metadata.BinaryStreamMarshaller<T> marshaller, T value) {
        return new Metadata.LazyValue(marshaller, value);
    }

    public static Metadata newMetadataWithParsedValues(int usedNames, Object[] namesAndValues) {
        return new Metadata(usedNames, namesAndValues);
    }
}