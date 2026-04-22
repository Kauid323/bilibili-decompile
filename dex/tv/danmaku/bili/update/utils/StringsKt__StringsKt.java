package tv.danmaku.bili.update.utils;

import android.text.TextUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a \u0010\u0005\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\u0001H\u0000\u001a%\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\tH\u0080\b\u001a\u0019\u0010\u000e\u001a\u00020\t*\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0080\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"EMPTY_STRING", "", "NULL_STRING", "INDEX_NOT_FOUND", "", "substringAfter", "delimiter", "missingDelimiterValue", "isBlank", "", "startsWith", "str", "prefix", "ignoreCase", "equalsIgnoreCase", "other", "updater_debug"}, k = 5, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT, xs = "tv/danmaku/bili/update/utils/StringsKt")
public final /* synthetic */ class StringsKt__StringsKt {
    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfter(str, str2, str3);
    }

    public static final String substringAfter(String $this$substringAfter, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter($this$substringAfter, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        if (TextUtils.isEmpty(delimiter)) {
            return missingDelimiterValue;
        }
        Intrinsics.checkNotNull(delimiter);
        int index = kotlin.text.StringsKt.indexOf$default($this$substringAfter, delimiter, 0, false, 6, (Object) null);
        if (index == -1) {
            return "";
        }
        String substring = $this$substringAfter.substring(delimiter.length() + index);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final boolean isBlank(String $this$isBlank) {
        Iterable $this$all$iv;
        if ($this$isBlank == null || kotlin.text.StringsKt.equals(StringsKt.NULL_STRING, $this$isBlank, true) || $this$isBlank.length() == 0) {
            return true;
        }
        Iterable $this$all$iv2 = kotlin.text.StringsKt.getIndices($this$isBlank);
        if (($this$all$iv2 instanceof Collection) && ((Collection) $this$all$iv2).isEmpty()) {
            $this$all$iv = 1;
        } else {
            IntIterator it = $this$all$iv2.iterator();
            while (true) {
                if (it.hasNext()) {
                    int element$iv = it.nextInt();
                    if (!CharsKt.isWhitespace($this$isBlank.charAt(element$iv))) {
                        $this$all$iv = null;
                        break;
                    }
                } else {
                    $this$all$iv = 1;
                    break;
                }
            }
        }
        return $this$all$iv != null;
    }

    public static final boolean startsWith(String str, String prefix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return str != null && kotlin.text.StringsKt.startsWith(str, prefix, ignoreCase);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String prefix, boolean ignoreCase, int i, Object obj) {
        if ((i & 4) != 0) {
            ignoreCase = false;
        }
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return str != null && kotlin.text.StringsKt.startsWith(str, prefix, ignoreCase);
    }

    public static final boolean equalsIgnoreCase(String $this$equalsIgnoreCase, String other) {
        return Intrinsics.areEqual($this$equalsIgnoreCase, other);
    }
}