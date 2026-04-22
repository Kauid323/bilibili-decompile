package im.session.summary;

import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: DraftPrefixString.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"getDraftPrefixString", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session-room_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DraftPrefixStringKt {
    public static final Object getDraftPrefixString(Continuation<? super String> continuation) {
        return StringResourcesKt.getString(String1_commonMainKt.getIm_global_string_754(Res.string.INSTANCE), continuation);
    }
}