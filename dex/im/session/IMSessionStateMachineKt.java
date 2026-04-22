package im.session;

import com.bapis.bilibili.app.im.v1.KRestrictedMode;
import kntr.common.restricted.KRestrictedModeKt;
import kntr.common.restricted.KRestrictedModeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006*0\b\u0002\u0010\u0000\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0007"}, d2 = {"BaseIMBlock", "Lcom/freeletics/flowredux/dsl/BaseBuilderBlock;", "Lim/session/IMState;", "Lim/session/IMAction;", "imMode", "Lcom/bapis/bilibili/app/im/v1/KRestrictedMode;", "Lcom/bapis/bilibili/app/im/v1/KRestrictedMode$Companion;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionStateMachineKt {
    private static /* synthetic */ void BaseIMBlock$annotations() {
    }

    public static final KRestrictedMode imMode(KRestrictedMode.Companion $this$imMode) {
        Intrinsics.checkNotNullParameter($this$imMode, "<this>");
        return new KRestrictedMode(KRestrictedModeKt.getKRestrictedMode().checkModeEnabled(KRestrictedModeType.TEENAGERS, "im"), KRestrictedModeKt.getKRestrictedMode().checkModeEnabled(KRestrictedModeType.LESSONS, "im"));
    }
}