package kotlinx.io.bytestring;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;

/* compiled from: Hex.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\b\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"toHexString", "", "Lkotlinx/io/bytestring/ByteString;", "format", "Lkotlin/text/HexFormat;", "startIndex", "", "endIndex", "hexToByteString", "kotlinx-io-bytestring"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HexKt {
    public static /* synthetic */ String toHexString$default(ByteString byteString, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(byteString, hexFormat);
    }

    public static final String toHexString(ByteString $this$toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString.getBackingArrayReference(), 0, $this$toHexString.getBackingArrayReference().length, format);
    }

    public static /* synthetic */ String toHexString$default(ByteString byteString, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.getSize();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(byteString, i, i2, hexFormat);
    }

    public static final String toHexString(ByteString $this$toHexString, int startIndex, int endIndex, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString($this$toHexString.getBackingArrayReference(), startIndex, endIndex, format);
    }

    public static /* synthetic */ ByteString hexToByteString$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByteString(str, hexFormat);
    }

    public static final ByteString hexToByteString(String $this$hexToByteString, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToByteString, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ByteString.Companion.wrap$kotlinx_io_bytestring(HexExtensionsKt.hexToByteArray($this$hexToByteString, format));
    }
}