package kntr.app.ad.domain.report.internal.cache;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CacheUtils.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"generateFileName", RoomRecommendViewModel.EMPTY_CURSOR, "uuid", "nameToTsSafe", RoomRecommendViewModel.EMPTY_CURSOR, "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CacheUtilsKt {
    public static final String generateFileName(String $this$generateFileName, String uuid) {
        Intrinsics.checkNotNullParameter($this$generateFileName, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return $this$generateFileName + "_" + uuid;
    }

    public static final long nameToTsSafe(String $this$nameToTsSafe) {
        long parseLong;
        Intrinsics.checkNotNullParameter($this$nameToTsSafe, "<this>");
        int index = StringsKt.indexOf$default($this$nameToTsSafe, '_', 0, false, 6, (Object) null);
        try {
            if (index == -1) {
                parseLong = Long.parseLong($this$nameToTsSafe);
            } else {
                String substring = $this$nameToTsSafe.substring(0, index);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                parseLong = Long.parseLong(substring);
            }
            return parseLong;
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}