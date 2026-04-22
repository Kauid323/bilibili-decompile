package kotlinx.io.bytestring;

import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Base64.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a:\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a(\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001aC\u0010\r\u001a\u0002H\u000e\"\f\b\u0000\u0010\u000e*\u00060\u000fj\u0002`\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u0002H\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0011\u001a(\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a(\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a:\u0010\u0015\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a(\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a(\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\u0016"}, d2 = {"encodeToByteArray", "", "Lkotlin/io/encoding/Base64;", "source", "Lkotlinx/io/bytestring/ByteString;", "startIndex", "", "endIndex", "encodeIntoByteArray", "destination", "destinationOffset", "encode", "", "encodeToAppendable", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Lkotlin/io/encoding/Base64;Lkotlinx/io/bytestring/ByteString;Ljava/lang/Appendable;II)Ljava/lang/Appendable;", "decode", "decodeToByteString", "", "decodeIntoByteArray", "kotlinx-io-bytestring"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Base64Kt {
    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 base64, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.getSize();
        }
        return encodeToByteArray(base64, byteString, i, i2);
    }

    public static final byte[] encodeToByteArray(Base64 $this$encodeToByteArray, ByteString source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return $this$encodeToByteArray.encodeToByteArray(source.getBackingArrayReference(), startIndex, endIndex);
    }

    public static final int encodeIntoByteArray(Base64 $this$encodeIntoByteArray, ByteString source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$encodeIntoByteArray, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return $this$encodeIntoByteArray.encodeIntoByteArray(source.getBackingArrayReference(), destination, destinationOffset, startIndex, endIndex);
    }

    public static /* synthetic */ String encode$default(Base64 base64, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.getSize();
        }
        return encode(base64, byteString, i, i2);
    }

    public static final String encode(Base64 $this$encode, ByteString source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$encode, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return $this$encode.encode(source.getBackingArrayReference(), startIndex, endIndex);
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 base64, ByteString byteString, Appendable appendable, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = byteString.getSize();
        }
        return encodeToAppendable(base64, byteString, appendable, i, i2);
    }

    public static final <A extends Appendable> A encodeToAppendable(Base64 $this$encodeToAppendable, ByteString source, A destination, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$encodeToAppendable, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return (A) $this$encodeToAppendable.encodeToAppendable(source.getBackingArrayReference(), destination, startIndex, endIndex);
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.getSize();
        }
        return decode(base64, byteString, i, i2);
    }

    public static final byte[] decode(Base64 $this$decode, ByteString source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$decode, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return $this$decode.decode(source.getBackingArrayReference(), startIndex, endIndex);
    }

    public static /* synthetic */ ByteString decodeToByteString$default(Base64 base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return decodeToByteString(base64, charSequence, i, i2);
    }

    public static final ByteString decodeToByteString(Base64 $this$decodeToByteString, CharSequence source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$decodeToByteString, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return ByteString.Companion.wrap$kotlinx_io_bytestring($this$decodeToByteString.decode(source, startIndex, endIndex));
    }

    public static final int decodeIntoByteArray(Base64 $this$decodeIntoByteArray, ByteString source, byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$decodeIntoByteArray, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return $this$decodeIntoByteArray.decodeIntoByteArray(source.getBackingArrayReference(), destination, destinationOffset, startIndex, endIndex);
    }

    public static /* synthetic */ ByteString decodeToByteString$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return decodeToByteString(base64, bArr, i, i2);
    }

    public static final ByteString decodeToByteString(Base64 $this$decodeToByteString, byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$decodeToByteString, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return ByteString.Companion.wrap$kotlinx_io_bytestring($this$decodeToByteString.decode(source, startIndex, endIndex));
    }

    public static /* synthetic */ ByteString decodeToByteString$default(Base64 base64, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.getSize();
        }
        return decodeToByteString(base64, byteString, i, i2);
    }

    public static final ByteString decodeToByteString(Base64 $this$decodeToByteString, ByteString source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$decodeToByteString, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        return ByteString.Companion.wrap$kotlinx_io_bytestring($this$decodeToByteString.decode(source.getBackingArrayReference(), startIndex, endIndex));
    }
}