package kntr.app.digital.preview.lock;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import javax.inject.Inject;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.digital.preview.ActivityId;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.api.CardData;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: LockStateService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0017\u001a\u00020\u00142\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkntr/app/digital/preview/lock/LockStateService;", RoomRecommendViewModel.EMPTY_CURSOR, "toggleLockCard", "Lkntr/app/digital/preview/lock/ToggleLockCard;", "activityId", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "toaster", "Lkntr/common/trio/toast/Toaster;", "<init>", "(Lkntr/app/digital/preview/lock/ToggleLockCard;ILkotlinx/coroutines/CoroutineScope;Lkntr/common/trio/toast/Toaster;)V", "lockStatusMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;", "lockStatus", "card", "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "mark", RoomRecommendViewModel.EMPTY_CURSOR, "cardUniqueId", AdAlarmExtraKey.STATUS, "toggleDlcLockCard", "shouldLock", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LockStateService {
    public static final int $stable = 8;
    private final int activityId;
    private final CoroutineScope coroutineScope;
    private final SnapshotStateMap<String, CardData.Data.CardLockStatus> lockStatusMap;
    private final Toaster toaster;
    private final ToggleLockCard toggleLockCard;

    @Inject
    public LockStateService(ToggleLockCard toggleLockCard, @ActivityId int activityId, @BusinessCoroutineScope CoroutineScope coroutineScope, Toaster toaster) {
        Intrinsics.checkNotNullParameter(toggleLockCard, "toggleLockCard");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(toaster, "toaster");
        this.toggleLockCard = toggleLockCard;
        this.activityId = activityId;
        this.coroutineScope = coroutineScope;
        this.toaster = toaster;
        this.lockStatusMap = SnapshotStateKt.mutableStateMapOf();
    }

    public final CardData.Data.CardLockStatus lockStatus(CardItem<?> cardItem) {
        Intrinsics.checkNotNullParameter(cardItem, "card");
        return (CardData.Data.CardLockStatus) this.lockStatusMap.get(cardItem.getBasic().getUniqueId());
    }

    public final void mark(String cardUniqueId, CardData.Data.CardLockStatus status) {
        Intrinsics.checkNotNullParameter(cardUniqueId, "cardUniqueId");
        this.lockStatusMap.put(cardUniqueId, status);
    }

    public final void toggleDlcLockCard(CardItem<?> cardItem, boolean shouldLock) {
        Intrinsics.checkNotNullParameter(cardItem, "card");
        final CardBasic cardBasic = cardItem.getBasic();
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "operate", Integer.valueOf(shouldLock ? 1 : 2));
        JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv2, "act_id", Integer.valueOf(this.activityId));
        JsonElementBuildersKt.put(builder$iv2, "card_type_id", Long.valueOf(cardBasic.getCardIdInfo().getCardTypeId()));
        JsonElementBuildersKt.put(builder$iv2, "card_number", cardBasic.getCardIdInfo().getCardNo());
        Unit unit = Unit.INSTANCE;
        builder$iv.put("card_uk_to_lock", builder$iv2.build());
        JsonElementBuildersKt.putJsonArray(builder$iv, "card_ids_to_lock", new Function1() { // from class: kntr.app.digital.preview.lock.LockStateService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit unit2;
                unit2 = LockStateService.toggleDlcLockCard$lambda$0$1(CardBasic.this, (JsonArrayBuilder) obj);
                return unit2;
            }
        });
        JsonObject json = builder$iv.build();
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LockStateService$toggleDlcLockCard$1(this, json, cardBasic, shouldLock, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toggleDlcLockCard$lambda$0$1(CardBasic $cardBasic, JsonArrayBuilder $this$putJsonArray) {
        Intrinsics.checkNotNullParameter($this$putJsonArray, "$this$putJsonArray");
        JsonElementBuildersKt.add($this$putJsonArray, Long.valueOf($cardBasic.getCardIdInfo().getCardId()));
        return Unit.INSTANCE;
    }
}