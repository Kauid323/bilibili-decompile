package kntr.app.tribee.publish;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"needConfirmPublish", "", "Lkntr/common/paragraph/input/RichTextContent;", "getNeedConfirmPublish", "(Lkntr/common/paragraph/input/RichTextContent;)Z", "trimTitle", "", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishStateMachineKt {
    public static final boolean getNeedConfirmPublish(RichTextContent $this$needConfirmPublish) {
        Intrinsics.checkNotNullParameter($this$needConfirmPublish, "<this>");
        return $this$needConfirmPublish.getAnyUploading() || $this$needConfirmPublish.getAnyUploadFailed();
    }

    public static final String trimTitle(String $this$trimTitle) {
        Intrinsics.checkNotNullParameter($this$trimTitle, "<this>");
        return new Regex("\\s+").replace(StringsKt.replace$default(StringsKt.trimStart($this$trimTitle).toString(), "\n", "", false, 4, (Object) null), " ");
    }
}