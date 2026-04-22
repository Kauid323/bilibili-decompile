package tv.danmaku.bili.ui.main2;

import android.os.Bundle;
import com.bilibili.droid.StringUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.bili.BR;

/* compiled from: MainTransaction.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/MainTransaction;", "", "<init>", "()V", "ARGS_ANCHOR_TAB", "", "ARGS_ANCHOR_TAB_ID", "ARGS_BOTTOM_ANCHOR_TAB", "ARGS_BOTTOM_ANCHOR_TAB_ID", "ARGS_FROM_CHANNEL", "ARGS_NEED_CHARGE", "getBottomAnchorName", "bundle", "Landroid/os/Bundle;", "getBottomAnchorId", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MainTransaction {
    public static final int $stable = 0;
    public static final String ARGS_ANCHOR_TAB = "tab_name";
    public static final String ARGS_ANCHOR_TAB_ID = "tab_id";
    public static final String ARGS_BOTTOM_ANCHOR_TAB = "bottom_tab_name";
    public static final String ARGS_BOTTOM_ANCHOR_TAB_ID = "bottom_tab_id";
    public static final String ARGS_FROM_CHANNEL = "from_channel";
    public static final String ARGS_NEED_CHARGE = "need_charge";
    public static final MainTransaction INSTANCE = new MainTransaction();

    private MainTransaction() {
    }

    @JvmStatic
    public static final String getBottomAnchorName(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String result = bundle.getString(ARGS_BOTTOM_ANCHOR_TAB);
        if (StringUtil.isBlank(result)) {
            return bundle.getString("tab_name");
        }
        return result;
    }

    @JvmStatic
    public static final String getBottomAnchorId(Bundle bundle) {
        if (bundle != null) {
            return bundle.getString(ARGS_BOTTOM_ANCHOR_TAB_ID);
        }
        return null;
    }
}