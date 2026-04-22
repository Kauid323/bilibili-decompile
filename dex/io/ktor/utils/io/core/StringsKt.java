package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.PropsConstants;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;
import kotlinx.io.Utf8Kt;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u000e\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u0011\u001a)\u0010\u0013\u001a\u00020\u0000*\u00020\r2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a)\u0010\u0016\u001a\u00020\u0000*\u00020\r2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0015\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0014\u001a'\u0010\u0018\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0017\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010 \u001a\u00020\u001f*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b \u0010!\u001a;\u0010 \u001a\u00020\u001f*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\"2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b \u0010#\u001a\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "", "toByteArray", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", "bytes", "", "offset", "length", "String", "([BIILjava/nio/charset/Charset;)Ljava/lang/String;", "Lkotlinx/io/Source;", "readBytes", "(Lkotlinx/io/Source;)[B", "count", "(Lkotlinx/io/Source;I)[B", "max", "readText", "(Lkotlinx/io/Source;Ljava/nio/charset/Charset;I)Ljava/lang/String;", "n", "readTextExact", "charactersCount", "readTextExactCharacters", "(Lkotlinx/io/Source;ILjava/nio/charset/Charset;)Ljava/lang/String;", "Lkotlinx/io/Sink;", "", PropsConstants.TEXT, "fromIndex", "toIndex", "", "writeText", "(Lkotlinx/io/Sink;Ljava/lang/CharSequence;IILjava/nio/charset/Charset;)V", "", "(Lkotlinx/io/Sink;[CIILjava/nio/charset/Charset;)V", "", "prematureEndOfStreamToReadChars", "(I)Ljava/lang/Void;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class StringsKt {
    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return toByteArray(str, charset);
    }

    public static final byte[] toByteArray(String $this$toByteArray, Charset charset) {
        Intrinsics.checkNotNullParameter($this$toByteArray, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return Intrinsics.areEqual(charset, Charsets.UTF_8) ? kotlin.text.StringsKt.encodeToByteArray$default($this$toByteArray, 0, 0, true, 3, (Object) null) : CharsetJVMKt.encodeToByteArray(charset.newEncoder(), $this$toByteArray, 0, $this$toByteArray.length());
    }

    public static /* synthetic */ String String$default(byte[] bArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        return String(bArr, i, i2, charset);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use decodeToString instead", replaceWith = @ReplaceWith(expression = "bytes.decodeToString(offset, offset + length)", imports = {}))
    public static final String String(byte[] bytes, int offset, int length, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.decodeToString$default(bytes, offset, offset + length, false, 4, (Object) null);
        }
        Source buffer = new Buffer();
        Sink $this$String_u24lambda_u240 = (Sink) buffer;
        BytePacketBuilderKt.writeFully($this$String_u24lambda_u240, bytes, offset, length);
        return readText$default(buffer, charset, 0, 2, null);
    }

    @Deprecated(message = "Use readByteArray instead", replaceWith = @ReplaceWith(expression = "this.readByteArray()", imports = {"kotlinx.io.readByteArray"}))
    public static final byte[] readBytes(Source $this$readBytes) {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        return SourcesKt.readByteArray($this$readBytes);
    }

    @Deprecated(message = "Use readByteArray instead", replaceWith = @ReplaceWith(expression = "this.readByteArray(count)", imports = {}))
    public static final byte[] readBytes(Source $this$readBytes, int count) {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        return SourcesKt.readByteArray($this$readBytes, count);
    }

    public static /* synthetic */ String readText$default(Source source, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(source, charset, i);
    }

    public static final String readText(Source $this$readText, Charset charset, int max) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            if (max == Integer.MAX_VALUE) {
                return Utf8Kt.readString($this$readText);
            }
            long count = Math.min($this$readText.getBuffer().getSize(), max);
            return Utf8Kt.readString($this$readText, count);
        }
        return EncodingKt.decode(charset.newDecoder(), $this$readText, max);
    }

    public static /* synthetic */ String readTextExact$default(Source source, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExact(source, charset, i);
    }

    @Deprecated(message = "Use readTextExactCharacters instead.", replaceWith = @ReplaceWith(expression = "readTextExactCharacters(n, charset)", imports = {}))
    public static final String readTextExact(Source $this$readTextExact, Charset charset, int n) {
        Intrinsics.checkNotNullParameter($this$readTextExact, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactCharacters($this$readTextExact, n, charset);
    }

    public static /* synthetic */ String readTextExactCharacters$default(Source source, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactCharacters(source, i, charset);
    }

    public static final String readTextExactCharacters(Source $this$readTextExactCharacters, int charactersCount, Charset charset) {
        Intrinsics.checkNotNullParameter($this$readTextExactCharacters, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String s = readText($this$readTextExactCharacters, charset, charactersCount);
        if (s.length() < charactersCount) {
            prematureEndOfStreamToReadChars(charactersCount);
            throw new KotlinNothingValueException();
        }
        return s;
    }

    public static /* synthetic */ void writeText$default(Sink sink, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(sink, charSequence, i, i2, charset);
    }

    public static final void writeText(Sink $this$writeText, CharSequence text, int fromIndex, int toIndex, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, PropsConstants.TEXT);
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            Utf8Kt.writeString($this$writeText, text.toString(), fromIndex, toIndex);
        } else {
            EncodingKt.encodeToImpl(charset.newEncoder(), $this$writeText, text, fromIndex, toIndex);
        }
    }

    public static /* synthetic */ void writeText$default(Sink sink, char[] cArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(sink, cArr, i, i2, charset);
    }

    public static final void writeText(Sink $this$writeText, char[] text, int fromIndex, int toIndex, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, PropsConstants.TEXT);
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            String string = kotlin.text.StringsKt.concatToString(text, fromIndex, fromIndex + toIndex);
            Utf8Kt.writeString($this$writeText, string, 0, toIndex - fromIndex);
            return;
        }
        EncodingKt.encode(charset.newEncoder(), text, fromIndex, toIndex, $this$writeText);
    }

    private static final Void prematureEndOfStreamToReadChars(int charactersCount) {
        throw new EOFException("Not enough input bytes to read " + charactersCount + " characters.");
    }
}