package tv.danmaku.bili.ui.garb.digital.lockcard;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;

/* compiled from: CreateLockModel.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"tv/danmaku/bili/ui/garb/digital/lockcard/CreateLockModel$invoke$1", "Ltv/danmaku/bili/ui/garb/digital/lockcard/LockModel;", "toggleLockCard", "", "toggleCardLocked", "", "actId", "", "cardId", "cardTypeId", "cardNo", "", "<set-?>", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "lockStatus", "getLockStatus", "()Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "setLockStatus", "(Ltv/danmaku/bili/ui/garb/api/CardLockStatus;)V", "lockStatus$delegate", "Landroidx/compose/runtime/MutableState;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CreateLockModel$invoke$1 implements LockModel {
    private final MutableState lockStatus$delegate;
    final /* synthetic */ CreateLockModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateLockModel$invoke$1(CardLockStatus $cardLockStatus, CreateLockModel $receiver) {
        this.this$0 = $receiver;
        this.lockStatus$delegate = SnapshotStateKt.mutableStateOf$default($cardLockStatus, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.lockcard.LockModel
    public void toggleLockCard(boolean toggleCardLocked, long actId, long cardId, long cardTypeId, String cardNo) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        coroutineScope = this.this$0.coroutineScope;
        if (coroutineScope != null) {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CreateLockModel$invoke$1$toggleLockCard$1(this.this$0, toggleCardLocked, actId, cardTypeId, cardNo, cardId, this, null), 3, (Object) null);
        }
    }

    @Override // tv.danmaku.bili.ui.garb.digital.lockcard.LockModel
    public CardLockStatus getLockStatus() {
        State $this$getValue$iv = this.lockStatus$delegate;
        return (CardLockStatus) $this$getValue$iv.getValue();
    }

    @Override // tv.danmaku.bili.ui.garb.digital.lockcard.LockModel
    public void setLockStatus(CardLockStatus cardLockStatus) {
        Intrinsics.checkNotNullParameter(cardLockStatus, "<set-?>");
        MutableState $this$setValue$iv = this.lockStatus$delegate;
        $this$setValue$iv.setValue(cardLockStatus);
    }
}