package tv.danmaku.bili.ui.main2.userprotocol;

import android.app.Activity;
import com.bilibili.homepage.ExperimentGroup;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.homepage.UserProtocolDialogService;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.delaytask.DelayTaskControllerDelegate;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: UserProtocolDialogServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/main2/userprotocol/UserProtocolDialogServiceImpl;", "Lcom/bilibili/homepage/UserProtocolDialogService;", "<init>", "()V", "showBlockDialog", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "from", "", "showBackground", "", "listener", "Lcom/bilibili/homepage/UserProtocolDialogListener;", "sendReportData", "data", "", "getExperimentGroup", "Lcom/bilibili/homepage/ExperimentGroup;", "hitVisitMode", "hitVipMode", "privacyAccess", "removeUserProtocolDialogListener", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserProtocolDialogServiceImpl implements UserProtocolDialogService {
    public static final int $stable = 0;

    public void showBlockDialog(Activity activity, String from, boolean showBackground, UserProtocolDialogListener listener) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(listener, "listener");
        UserProtocolHelper.showBlockDialog(activity, listener, from, showBackground);
    }

    public void sendReportData(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        BLog.i("UserProtocolDialogServiceImpl sendReportData:" + map);
        UserProtocolExperiment.INSTANCE.setBizReportData(map);
    }

    public ExperimentGroup getExperimentGroup() {
        return UserProtocolExperiment.INSTANCE.getGroup();
    }

    public boolean hitVisitMode() {
        return UserProtocolExperiment.hitVisitMode();
    }

    public boolean hitVipMode() {
        return UserProtocolExperiment.hitVipMode();
    }

    public boolean privacyAccess() {
        return DelayTaskControllerDelegate.Companion.isPrivacyAllow();
    }

    public void removeUserProtocolDialogListener(UserProtocolDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        UserProtocolBlockDialogEntrepot.INSTANCE.removeUserProtocolDialogListener(listener);
    }
}