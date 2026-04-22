package tv.danmaku.bili.ui.rank;

import android.net.Uri;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bapis.bilibili.app.show.rank.v1.RankRegionInfo;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.ui.rank.model.RankStatus;
import tv.danmaku.bili.ui.rank.model.RankType;
import tv.danmaku.bili.ui.rank.model.RankUiState;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/rank/RankViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/rank/model/RankUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadData", "", "handleScheme", "", "region", "Lcom/bapis/bilibili/app/show/rank/v1/RankRegionInfo;", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<RankUiState> _uiState = StateFlowKt.MutableStateFlow(new RankUiState(null, null, 3, null));
    private final StateFlow<RankUiState> uiState = FlowKt.asStateFlow(this._uiState);

    public final StateFlow<RankUiState> getUiState() {
        return this.uiState;
    }

    public final void loadData() {
        Object prevValue$iv;
        RankUiState it;
        MutableStateFlow $this$update$iv = this._uiState;
        do {
            prevValue$iv = $this$update$iv.getValue();
            it = (RankUiState) prevValue$iv;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, RankUiState.copy$default(it, RankStatus.LOADING, null, 2, null)));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new RankViewModel$loadData$2(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String handleScheme(RankRegionInfo region) {
        String typeParam;
        String uri = region.getUri();
        if (uri == null) {
            uri = "";
        }
        Uri.Builder uriBuilder = Uri.parse(uri).buildUpon().appendQueryParameter("tid", String.valueOf(region.getTid())).appendQueryParameter(RankRouter.BundleKey.ACTION_PARAM_TITLE, region.getName()).appendQueryParameter("from", "1");
        int regionType = region.getRegionType();
        if (regionType == RankType.ALL.getValue()) {
            typeParam = "2";
        } else {
            typeParam = regionType == RankType.UGC.getValue() ? "-1" : null;
        }
        if (typeParam != null) {
            String it = typeParam;
            uriBuilder.appendQueryParameter("type", it);
        }
        String uri2 = uriBuilder.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        return uri2;
    }
}