package io.ktor.utils.io.charsets;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.mall.common.game.CustomFormContainer;
import io.ktor.utils.io.core.internal.CharArraySequence;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* compiled from: Encoding.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u001a1\u0010\b\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\b\u001a\u00020\r*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\u000e\u001a'\u0010\u0013\u001a\u00020\u0012*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0003\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014\u001a7\u0010\u0015\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a7\u0010\u0018\u001a\u00020\r*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", CustomFormContainer.INPUT_TYPE_INPUT, "", "fromIndex", "toIndex", "Lkotlinx/io/Source;", "encode", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)Lkotlinx/io/Source;", "", "Lkotlinx/io/Sink;", "dst", "", "(Ljava/nio/charset/CharsetEncoder;[CIILkotlinx/io/Sink;)V", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "max", "", "decode", "(Ljava/nio/charset/CharsetDecoder;Lkotlinx/io/Source;I)Ljava/lang/String;", "encodeArrayImpl", "(Ljava/nio/charset/CharsetEncoder;[CIILkotlinx/io/Sink;)I", "destination", "encodeToImpl", "(Ljava/nio/charset/CharsetEncoder;Lkotlinx/io/Sink;Ljava/lang/CharSequence;II)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class EncodingKt {
    public static /* synthetic */ Source encode$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encode(charsetEncoder, charSequence, i, i2);
    }

    public static final Source encode(CharsetEncoder $this$encode, CharSequence input, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$encode, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        Source buffer = new Buffer();
        Sink $this$encode_u24lambda_u240 = (Sink) buffer;
        encodeToImpl($this$encode, $this$encode_u24lambda_u240, input, fromIndex, toIndex);
        return buffer;
    }

    public static final void encode(CharsetEncoder $this$encode, char[] input, int fromIndex, int toIndex, Sink dst) {
        Intrinsics.checkNotNullParameter($this$encode, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        Intrinsics.checkNotNullParameter(dst, "dst");
        encodeArrayImpl($this$encode, input, fromIndex, toIndex, dst);
    }

    public static /* synthetic */ String decode$default(CharsetDecoder charsetDecoder, Source source, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decode(charsetDecoder, source, i);
    }

    public static final String decode(CharsetDecoder $this$decode, Source input, int max) {
        Intrinsics.checkNotNullParameter($this$decode, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        StringBuilder $this$decode_u24lambda_u241 = new StringBuilder((int) Math.min(max, input.getBuffer().getSize()));
        CharsetJVMKt.decode($this$decode, input, $this$decode_u24lambda_u241, max);
        String sb = $this$decode_u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final int encodeArrayImpl(CharsetEncoder $this$encodeArrayImpl, char[] input, int fromIndex, int toIndex, Sink dst) {
        Intrinsics.checkNotNullParameter($this$encodeArrayImpl, "<this>");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        Intrinsics.checkNotNullParameter(dst, "dst");
        int length = toIndex - fromIndex;
        return CharsetJVMKt.encodeImpl($this$encodeArrayImpl, new CharArraySequence(input, fromIndex, length), 0, length, dst);
    }

    public static final void encodeToImpl(CharsetEncoder $this$encodeToImpl, Sink destination, CharSequence input, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$encodeToImpl, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(input, CustomFormContainer.INPUT_TYPE_INPUT);
        int start = fromIndex;
        if (start >= toIndex) {
            return;
        }
        do {
            int rc = CharsetJVMKt.encodeImpl($this$encodeToImpl, input, start, toIndex, destination);
            if (!(rc >= 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            start += rc;
        } while (start < toIndex);
    }
}