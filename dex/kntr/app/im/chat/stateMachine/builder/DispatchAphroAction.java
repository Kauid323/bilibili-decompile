package kntr.app.im.chat.stateMachine.builder;

import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.aphro.core.AphroAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchAphroAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/stateMachine/builder/DispatchAphroAction;", "Lkntr/app/im/chat/core/model/ChatAction;", "subAction", "Lkntr/common/photonic/aphro/core/AphroAction;", "<init>", "(Lkntr/common/photonic/aphro/core/AphroAction;)V", "getSubAction", "()Lkntr/common/photonic/aphro/core/AphroAction;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DispatchAphroAction implements ChatAction {
    public static final int $stable = 0;
    private final AphroAction subAction;

    public static /* synthetic */ DispatchAphroAction copy$default(DispatchAphroAction dispatchAphroAction, AphroAction aphroAction, int i, Object obj) {
        if ((i & 1) != 0) {
            aphroAction = dispatchAphroAction.subAction;
        }
        return dispatchAphroAction.copy(aphroAction);
    }

    public final AphroAction component1() {
        return this.subAction;
    }

    public final DispatchAphroAction copy(AphroAction aphroAction) {
        Intrinsics.checkNotNullParameter(aphroAction, "subAction");
        return new DispatchAphroAction(aphroAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DispatchAphroAction) && Intrinsics.areEqual(this.subAction, ((DispatchAphroAction) obj).subAction);
    }

    public int hashCode() {
        return this.subAction.hashCode();
    }

    public String toString() {
        return "DispatchAphroAction(subAction=" + this.subAction + ")";
    }

    public DispatchAphroAction(AphroAction subAction) {
        Intrinsics.checkNotNullParameter(subAction, "subAction");
        this.subAction = subAction;
    }

    public final AphroAction getSubAction() {
        return this.subAction;
    }
}