package kntr.app.deepsearch.base.model.biz;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KBusinessException;
import kntr.base.moss.api.KNetworkException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeepSearchToast.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toDisplayString", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "default", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchToastKt {
    public static /* synthetic */ String toDisplayString$default(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return toDisplayString(th, str);
    }

    public static final String toDisplayString(Throwable $this$toDisplayString, String str) {
        Intrinsics.checkNotNullParameter($this$toDisplayString, "<this>");
        Intrinsics.checkNotNullParameter(str, "default");
        if ($this$toDisplayString instanceof DeepSearchException) {
            return ((DeepSearchException) $this$toDisplayString).getErrorMsg();
        }
        if (!($this$toDisplayString instanceof KBusinessException)) {
            if ($this$toDisplayString instanceof KNetworkException) {
                String str2 = !StringsKt.isBlank(str) ? str : null;
                return str2 == null ? "似乎已断开与互联网的连接" : str2;
            }
            return str;
        }
        String message = $this$toDisplayString.getMessage();
        if (message == null) {
            String str3 = !StringsKt.isBlank(str) ? str : null;
            return str3 == null ? "似乎已断开与互联网的连接" : str3;
        }
        return message;
    }
}