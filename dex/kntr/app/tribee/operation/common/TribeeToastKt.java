package kntr.app.tribee.operation.common;

import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KBusinessException;
import kntr.base.moss.api.KNetworkException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeToast.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0087@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"toDisplayString", "", "", "default", "(Ljava/lang/Throwable;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "operation_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeToastKt {
    public static /* synthetic */ Object toDisplayString$default(Throwable th, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return toDisplayString(th, str, continuation);
    }

    public static final Object toDisplayString(Throwable $this$toDisplayString, String str, Continuation<? super String> continuation) {
        String str2;
        if ($this$toDisplayString instanceof KBusinessException) {
            String message = $this$toDisplayString.getMessage();
            if (message == null) {
                str2 = StringsKt.isBlank(str) ? null : str;
                if (str2 != null) {
                    return str2;
                }
                return StringResourcesKt.getString(String0_commonMainKt.getCommon_global_string_378(Res.string.INSTANCE), continuation);
            }
            return message;
        } else if ($this$toDisplayString instanceof KNetworkException) {
            str2 = StringsKt.isBlank(str) ? null : str;
            if (str2 != null) {
                return str2;
            }
            return StringResourcesKt.getString(String0_commonMainKt.getCommon_global_string_378(Res.string.INSTANCE), continuation);
        } else {
            return str;
        }
    }
}