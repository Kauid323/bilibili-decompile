package tv.danmaku.bili.splash.ad.player.dataprovider;

import android.os.Build;
import com.bilibili.app.comm.list.common.utils.BLRemoteConfigUtilKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* compiled from: SplashCardPlayerConfig.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"TAG", "", "KEY_BLACK_LIST", "isDeviceInPlayerBlackList", "", "playerBlackDeviceList", "Ltv/danmaku/bili/splash/ad/player/dataprovider/SplashSurfacePlayerBlackList;", "getPlayerBlackDeviceList", "()Ltv/danmaku/bili/splash/ad/player/dataprovider/SplashSurfacePlayerBlackList;", "playerBlackDeviceList$delegate", "Lkotlin/Lazy;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashCardPlayerConfigKt {
    private static final String KEY_BLACK_LIST = "splash.splash_surface_player_black_list";
    private static final String TAG = "SplashCardPlayerConfig";
    private static final Lazy playerBlackDeviceList$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.player.dataprovider.SplashCardPlayerConfigKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            SplashSurfacePlayerBlackList playerBlackDeviceList_delegate$lambda$0;
            playerBlackDeviceList_delegate$lambda$0 = SplashCardPlayerConfigKt.playerBlackDeviceList_delegate$lambda$0();
            return playerBlackDeviceList_delegate$lambda$0;
        }
    });

    public static final boolean isDeviceInPlayerBlackList() {
        String cpuName = IjkCpuInfo.getCpuName();
        String model = Build.MODEL;
        List<String> cpuBlackList = getPlayerBlackDeviceList().getCpuBlackList();
        boolean z = true;
        if (!(cpuBlackList != null && cpuBlackList.contains(cpuName))) {
            List<String> modelBlackList = getPlayerBlackDeviceList().getModelBlackList();
            if (!(modelBlackList != null && modelBlackList.contains(model))) {
                z = false;
            }
        }
        boolean isInBlackList = z;
        BLog.i(TAG, "isDeviceInPlayerBlackList = " + isInBlackList);
        return isInBlackList;
    }

    private static final SplashSurfacePlayerBlackList getPlayerBlackDeviceList() {
        return (SplashSurfacePlayerBlackList) playerBlackDeviceList$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashSurfacePlayerBlackList playerBlackDeviceList_delegate$lambda$0() {
        return (SplashSurfacePlayerBlackList) BLRemoteConfigUtilKt.getFawkesConfigObjectByGson(KEY_BLACK_LIST, SplashSurfacePlayerBlackList.class, new Function0() { // from class: tv.danmaku.bili.splash.ad.player.dataprovider.SplashCardPlayerConfigKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                SplashSurfacePlayerBlackList playerBlackDeviceList_delegate$lambda$0$0;
                playerBlackDeviceList_delegate$lambda$0$0 = SplashCardPlayerConfigKt.playerBlackDeviceList_delegate$lambda$0$0();
                return playerBlackDeviceList_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashSurfacePlayerBlackList playerBlackDeviceList_delegate$lambda$0$0() {
        return new SplashSurfacePlayerBlackList(null, null, 3, null);
    }
}