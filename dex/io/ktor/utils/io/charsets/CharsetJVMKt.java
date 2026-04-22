package io.ktor.utils.io.charsets;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.PropsConstants;
import com.mall.common.game.CustomFormContainer;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.ByteStringsKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.bytestring.ByteStringJvmExtKt;

/* compiled from: CharsetJVM.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a!\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\u00020\b*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\u0013\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0015\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0014\u001a7\u0010\u0018\u001a\u00020\u000f*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001a\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001a\u0010\u0014\u001a1\u0010!\u001a\u00020\u000f*\u00060\u001bj\u0002`\u001c2\u0006\u0010\u000e\u001a\u00020\u001d2\n\u0010\u0017\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010 \u001a\u00020\u000f¢\u0006\u0004\b!\u0010\"\"\u0019\u0010\u0003\u001a\u00020\u0002*\u00060\u0004j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001d\u0010'\u001a\u00060\u0004j\u0002`\u0005*\u00060\u000bj\u0002`\f8F¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u001d\u0010'\u001a\u00060\u0004j\u0002`\u0005*\u00060\u001bj\u0002`\u001c8F¢\u0006\u0006\u001a\u0004\b%\u0010(*\n\u0010)\"\u00020\u00042\u00020\u0004*\n\u0010*\"\u00020\u000b2\u00020\u000b*\n\u0010+\"\u00020\u001b2\u00020\u001b*\n\u0010,\"\u00020\u00002\u00020\u0000¨\u0006-"}, d2 = {"Lkotlin/text/Charsets;", "Lio/ktor/utils/io/charsets/Charsets;", "", PropsConstants.NAME, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "forName", "(Lkotlin/text/Charsets;Ljava/lang/String;)Ljava/nio/charset/Charset;", "", "isSupported", "(Lkotlin/text/Charsets;Ljava/lang/String;)Z", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", CustomFormContainer.INPUT_TYPE_INPUT, "", "fromIndex", "toIndex", "", "encodeToByteArray", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)[B", "encodeToByteArraySlow", "Lkotlinx/io/Sink;", "dst", "encodeImpl", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;IILkotlinx/io/Sink;)I", "encodeToByteArrayImpl", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "Lkotlinx/io/Source;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "decode", "(Ljava/nio/charset/CharsetDecoder;Lkotlinx/io/Source;Ljava/lang/Appendable;I)I", "getName", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "getCharset", "(Ljava/nio/charset/CharsetEncoder;)Ljava/nio/charset/Charset;", "charset", "(Ljava/nio/charset/CharsetDecoder;)Ljava/nio/charset/Charset;", "Charset", "CharsetEncoder", "CharsetDecoder", "Charsets", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class CharsetJVMKt {
    public static /* synthetic */ void Charset$annotations() {
    }

    public static final Charset forName(Charsets $this$forName, String name) {
        Intrinsics.checkNotNullParameter($this$forName, "<this>");
        Intrinsics.checkNotNullParameter(name, PropsConstants.NAME);
        Charset forName = Charset.forName(name);
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        return forName;
    }

    public static final boolean isSupported(Charsets $this$isSupported, String name) {
        Intrinsics.checkNotNullParameter($this$isSupported, "<this>");
        Intrinsics.checkNotNullParameter(name, PropsConstants.NAME);
        return Charset.isSupported(name);
    }

    public static final String getName(Charset $this$name) {
        Intrinsics.checkNotNullParameter($this$name, "<this>");
        String name = $this$name.name();
        Intrinsics.checkNotNullExpressionValue(name, "name(...)");
        return name;
    }

    public static final Charset getCharset(CharsetEncoder $this$charset) {
        Intrinsics.checkNotNullParameter($this$charset, "<this>");
        Charset charset = $this$charset.charset();
        Intrinsics.checkNotNullExpressionValue(charset, "charset(...)");
        return charset;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArray(charsetEncoder, charSequence, i, i2);
    }

    public static final byte[] encodeToByteArray(CharsetEncoder $this$encodeToByteArray, CharSequence input, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        if (input instanceof String) {
            if (fromIndex == 0 && toIndex == ((String) input).length()) {
                byte[] bytes = ((String) input).getBytes($this$encodeToByteArray.charset());
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
            }
            String substring = ((String) input).substring(fromIndex, toIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes2 = substring.getBytes($this$encodeToByteArray.charset());
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return bytes2;
        }
        return encodeToByteArraySlow($this$encodeToByteArray, input, fromIndex, toIndex);
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder $this$encodeToByteArraySlow, CharSequence input, int fromIndex, int toIndex) {
        ByteBuffer result = $this$encodeToByteArraySlow.encode(CharBuffer.wrap(input, fromIndex, toIndex));
        byte[] bArr = null;
        if (result.hasArray() && result.arrayOffset() == 0) {
            byte[] it = result.array();
            if (it.length == result.remaining()) {
                bArr = it;
            }
        }
        byte[] existingArray = bArr;
        if (existingArray == null) {
            byte[] it2 = new byte[result.remaining()];
            result.get(it2);
            return it2;
        }
        return existingArray;
    }

    public static final int encodeImpl(CharsetEncoder $this$encodeImpl, CharSequence input, int fromIndex, int toIndex, Sink dst) {
        Intrinsics.checkNotNullParameter($this$encodeImpl, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        Intrinsics.checkNotNullParameter(dst, "dst");
        byte[] result = encodeToByteArray($this$encodeImpl, input, fromIndex, toIndex);
        Sink.-CC.write$default(dst, result, 0, 0, 6, (Object) null);
        return result.length;
    }

    public static /* synthetic */ byte[] encodeToByteArrayImpl$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArrayImpl(charsetEncoder, charSequence, i, i2);
    }

    public static final byte[] encodeToByteArrayImpl(CharsetEncoder $this$encodeToByteArrayImpl, CharSequence input, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArrayImpl, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        throw new IllegalStateException("Not needed on jvm".toString());
    }

    public static final Charset getCharset(CharsetDecoder $this$charset) {
        Intrinsics.checkNotNullParameter($this$charset, "<this>");
        Charset charset = $this$charset.charset();
        Intrinsics.checkNotNull(charset);
        return charset;
    }

    public static final int decode(CharsetDecoder $this$decode, Source input, Appendable dst, int max) {
        Intrinsics.checkNotNullParameter($this$decode, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (Intrinsics.areEqual(getCharset($this$decode), Charsets.UTF_8)) {
            String it = Utf8Kt.readString(input);
            dst.append(it);
            return it.length();
        }
        long result = ByteReadPacketKt.getRemaining(input);
        dst.append(ByteStringJvmExtKt.decodeToString(ByteStringsKt.readByteString(input), getCharset($this$decode)));
        return (int) result;
    }
}