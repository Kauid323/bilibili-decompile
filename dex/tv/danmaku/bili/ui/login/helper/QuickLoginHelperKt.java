package tv.danmaku.bili.ui.login.helper;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.helper.reducer.ExperimentCheckReducer;
import tv.danmaku.bili.ui.login.helper.reducer.LoginTypeCheckerReducer;
import tv.danmaku.bili.ui.login.helper.reducer.LoginWayInjectReducer;
import tv.danmaku.bili.ui.login.helper.reducer.NetworkCheckReducer;
import tv.danmaku.bili.ui.login.helper.reducer.PhoneInfoCheckReducer;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003*\u0016\u0010\u0004\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0005"}, d2 = {"defaultReducerMap", "", "Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "Ltv/danmaku/bili/ui/login/helper/Reducers;", "Reducers", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class QuickLoginHelperKt {
    public static final List<QuickLoginCheckReducer> defaultReducerMap() {
        return CollectionsKt.listOf(new QuickLoginCheckReducer[]{new LoginTypeCheckerReducer(), new ExperimentCheckReducer(null, 1, null), new LoginWayInjectReducer(), new NetworkCheckReducer(), new PhoneInfoCheckReducer()});
    }
}