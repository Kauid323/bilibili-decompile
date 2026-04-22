package tv.danmaku.bili.update.utils;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Strings.kt */
@Metadata(d1 = {"tv/danmaku/bili/update/utils/StringsKt__StringsKt"}, k = 4, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StringsKt {
    public static final String EMPTY_STRING = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String NULL_STRING = "null";

    public static final boolean equalsIgnoreCase(String $this$equalsIgnoreCase, String other) {
        return StringsKt__StringsKt.equalsIgnoreCase($this$equalsIgnoreCase, other);
    }

    public static final boolean isBlank(String $this$isBlank) {
        return StringsKt__StringsKt.isBlank($this$isBlank);
    }

    public static final boolean startsWith(String str, String prefix, boolean ignoreCase) {
        return StringsKt__StringsKt.startsWith(str, prefix, ignoreCase);
    }

    public static final String substringAfter(String $this$substringAfter, String delimiter, String missingDelimiterValue) {
        return StringsKt__StringsKt.substringAfter($this$substringAfter, delimiter, missingDelimiterValue);
    }
}