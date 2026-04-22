package tv.danmaku.bili.ui.main2.mine;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: HomeUserCenterViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_mineData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/main2/mine/AccountMineData;", "_visibility", "", "mineData", "Lkotlinx/coroutines/flow/StateFlow;", "getMineData", "()Lkotlinx/coroutines/flow/StateFlow;", "pageVisibility", "getPageVisibility", "mineInfo", "Ltv/danmaku/bili/ui/main2/api/AccountMine;", "getMineInfo", "()Ltv/danmaku/bili/ui/main2/api/AccountMine;", "onAction", "", "action", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeUserCenterViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private MutableStateFlow<AccountMineData> _mineData;
    private final MutableStateFlow<Boolean> _visibility;
    private final Application app;
    private final StateFlow<AccountMineData> mineData;
    private final StateFlow<Boolean> pageVisibility;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this._mineData = StateFlowKt.MutableStateFlow(new AccountMineData(true, null, false, GarbEnum.PURE_WHITE, 0L));
        HomeUserCenterViewModelKt.mineLog("viewModel created");
        this._visibility = StateFlowKt.MutableStateFlow(false);
        this.mineData = FlowKt.asStateFlow(this._mineData);
        this.pageVisibility = FlowKt.asStateFlow(this._visibility);
    }

    public final StateFlow<AccountMineData> getMineData() {
        return this.mineData;
    }

    public final StateFlow<Boolean> getPageVisibility() {
        return this.pageVisibility;
    }

    public final AccountMine getMineInfo() {
        return ((AccountMineData) this.mineData.getValue()).getAccountMine();
    }

    public final void onAction(HomeUserCenterAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterViewModel$onAction$1(action, this, null), 3, (Object) null);
    }
}