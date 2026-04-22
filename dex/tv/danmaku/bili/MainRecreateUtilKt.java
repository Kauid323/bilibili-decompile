package tv.danmaku.bili;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: MainRecreateUtil.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"MAIN_PAGE_STATE", "", "reportPageState", "", "rebuild", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MainRecreateUtilKt {
    public static final String MAIN_PAGE_STATE = "main.public.page.state";

    public static final void reportPageState(boolean rebuild) {
        Map params = new HashMap();
        params.put("is_rebuild", String.valueOf(rebuild));
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new MainRecreateUtilKt$reportPageState$1(params, rebuild, null), 2, (Object) null);
    }
}