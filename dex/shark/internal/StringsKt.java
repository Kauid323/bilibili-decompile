package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Strings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"createSHA1Hash", "", "lastSegment", "segmentingChar", "", "shark"}, k = 2, mv = {1, 4, 1})
public final class StringsKt {
    public static final String lastSegment(String $this$lastSegment, char segmentingChar) {
        Intrinsics.checkParameterIsNotNull($this$lastSegment, "$this$lastSegment");
        int separator = kotlin.text.StringsKt.lastIndexOf$default($this$lastSegment, segmentingChar, 0, false, 6, (Object) null);
        if (separator == -1) {
            return $this$lastSegment;
        }
        String substring = $this$lastSegment.substring(separator + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String createSHA1Hash(String $this$createSHA1Hash) {
        Intrinsics.checkParameterIsNotNull($this$createSHA1Hash, "$this$createSHA1Hash");
        return ByteStringCompat.encodeUtf8($this$createSHA1Hash).sha1().hex();
    }
}