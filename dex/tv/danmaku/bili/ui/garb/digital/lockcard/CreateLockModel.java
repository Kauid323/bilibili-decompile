package tv.danmaku.bili.ui.garb.digital.lockcard;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.nft.api.DLCApiService;

/* compiled from: CreateLockModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/lockcard/CreateLockModel;", "", "context", "Landroid/content/Context;", "service", "Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;", "cardLockStateChangedFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/CoroutineScope;)V", "invoke", "Ltv/danmaku/bili/ui/garb/digital/lockcard/LockModel;", "cardLockStatus", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CreateLockModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Pair<Long, CardLockStatus>> cardLockStateChangedFlow;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private final DLCApiService service;

    public CreateLockModel(Context context, DLCApiService service, MutableStateFlow<Pair<Long, CardLockStatus>> mutableStateFlow, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(mutableStateFlow, "cardLockStateChangedFlow");
        this.context = context;
        this.service = service;
        this.cardLockStateChangedFlow = mutableStateFlow;
        this.coroutineScope = coroutineScope;
    }

    public final LockModel invoke(CardLockStatus cardLockStatus) {
        Intrinsics.checkNotNullParameter(cardLockStatus, "cardLockStatus");
        return new CreateLockModel$invoke$1(cardLockStatus, this);
    }
}