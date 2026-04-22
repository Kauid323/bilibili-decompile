package kntr.app.tribee.publish.core.v2;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"trimTitle", "", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishStateMachineKt {
    public static final String trimTitle(String $this$trimTitle) {
        Intrinsics.checkNotNullParameter($this$trimTitle, "<this>");
        return new Regex("\\s+").replace(StringsKt.replace$default(StringsKt.trimStart($this$trimTitle).toString(), "\n", "", false, 4, (Object) null), " ");
    }
}