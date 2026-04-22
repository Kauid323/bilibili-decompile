package tv.danmaku.bili.ui.splash.ad.config;

import android.os.Build;
import com.bilibili.app.comm.list.common.utils.BLRemoteConfigUtilKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LowerPhoneConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0002¨\u0006\u0005"}, d2 = {"isInLowerPerformancePhoneList", "", "()Z", "isInLowerPerformancePhoneList$delegate", "Lkotlin/Lazy;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LowerPhoneConfigKt {
    private static final Lazy isInLowerPerformancePhoneList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.config.LowerPhoneConfigKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean isInLowerPerformancePhoneList_delegate$lambda$0;
            isInLowerPerformancePhoneList_delegate$lambda$0 = LowerPhoneConfigKt.isInLowerPerformancePhoneList_delegate$lambda$0();
            return Boolean.valueOf(isInLowerPerformancePhoneList_delegate$lambda$0);
        }
    });

    public static final boolean isInLowerPerformancePhoneList() {
        return ((Boolean) isInLowerPerformancePhoneList$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LowerPerformancePhoneConfig isInLowerPerformancePhoneList_delegate$lambda$0$0() {
        return new LowerPerformancePhoneConfig(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isInLowerPerformancePhoneList_delegate$lambda$0() {
        List<String> modelList = ((LowerPerformancePhoneConfig) BLRemoteConfigUtilKt.getFawkesConfigObjectByGson("splash.splash_lower_performance_config", LowerPerformancePhoneConfig.class, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.config.LowerPhoneConfigKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                LowerPerformancePhoneConfig isInLowerPerformancePhoneList_delegate$lambda$0$0;
                isInLowerPerformancePhoneList_delegate$lambda$0$0 = LowerPhoneConfigKt.isInLowerPerformancePhoneList_delegate$lambda$0$0();
                return isInLowerPerformancePhoneList_delegate$lambda$0$0;
            }
        })).getModelList();
        return modelList != null && modelList.contains(Build.MODEL);
    }
}