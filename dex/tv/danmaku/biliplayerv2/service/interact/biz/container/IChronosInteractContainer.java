package tv.danmaku.biliplayerv2.service.interact.biz.container;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bapis.bilibili.app.viewunite.v1.FragmentParam;
import com.bilibili.common.chronoscommon.EnhancedChronosView;
import com.bilibili.cron.ChronosPackage;
import com.bilibili.okretro.GeneralResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.service.FrameRenderedInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.DanmakuCommandPanelsObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.DanmakuInteractionObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IWatchPointsLoadListener;
import tv.danmaku.biliplayerv2.service.interact.biz.OnChronosReadyCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.ViewProgressObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.AdDanmakuDelegate;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.IMultiDanmakuCallback;
import tv.danmaku.biliplayerv2.service.interact.biz.multi.MultiDanmakuPlayer;
import tv.danmaku.biliplayerv2.service.interact.core.command.CommandsPanel;
import tv.danmaku.biliplayerv2.service.interact.core.container.IInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailConfig;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: IChronosInteractContainer.kt */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0007H&J,\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H&J$\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H&J:\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020'\u0018\u00010&H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020\u0003H&J\u0012\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010.H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&J\u001a\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;H&J\n\u0010<\u001a\u0004\u0018\u00010=H&J\n\u0010>\u001a\u0004\u0018\u00010?H&J\n\u0010@\u001a\u0004\u0018\u00010AH&J\n\u0010B\u001a\u0004\u0018\u00010CH&J\n\u0010D\u001a\u0004\u0018\u00010EH&J\b\u0010F\u001a\u00020\u0007H&J:\u0010G\u001a\u00020\u00032\b\u0010H\u001a\u0004\u0018\u00010I2\b\b\u0002\u0010J\u001a\u00020\u001b2\b\b\u0002\u0010K\u001a\u00020\u00072\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190&H&J\b\u0010L\u001a\u00020\u0003H&J\b\u0010M\u001a\u00020\u0003H&J\b\u0010N\u001a\u00020\u0003H&Jd\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00192\b\u0010T\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010U\u001a\u00020\u00072\b\b\u0002\u0010V\u001a\u00020\u00072\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010X2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0019H&J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0007H&J\n\u0010\\\u001a\u0004\u0018\u00010]H&J\n\u0010^\u001a\u0004\u0018\u00010_H&J\b\u0010`\u001a\u00020\u0007H&J\b\u0010a\u001a\u00020\u0007H&J\u0010\u0010b\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0007H&J\u0010\u0010c\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0007H&J\u0018\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u0019H&J\b\u0010g\u001a\u00020\u0003H&J\u0010\u0010h\u001a\u00020\u00032\u0006\u00100\u001a\u00020iH&J\u0010\u0010j\u001a\u00020\u00032\u0006\u00100\u001a\u00020iH&J\u0010\u0010k\u001a\u00020\u00032\u0006\u00100\u001a\u00020lH&J\b\u0010m\u001a\u00020\u0003H&J\u0010\u0010n\u001a\u00020\u00032\u0006\u0010o\u001a\u00020\u0007H&J\b\u0010p\u001a\u00020\u0007H&J\u0016\u0010q\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070rH&J\u0016\u0010s\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070rH&J\u0010\u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u00020vH&J\u0010\u0010w\u001a\u00020\u00032\u0006\u0010u\u001a\u00020vH&J\u0010\u0010x\u001a\u00020\u00032\u0006\u0010o\u001a\u00020\u0007H&J\u0010\u0010y\u001a\u00020\u00032\u0006\u0010z\u001a\u00020\u0007H&J\u0010\u0010{\u001a\u00020\u00032\u0006\u0010|\u001a\u00020}H&J\b\u0010~\u001a\u00020\u007fH&J\u0015\u0010\u0080\u0001\u001a\u00020\u00032\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H&J\f\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H&J\u001c\u0010\u0085\u0001\u001a\u00020\u00032\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0089\u0001À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/container/IChronosInteractContainer;", "Ltv/danmaku/biliplayerv2/service/interact/core/container/IInteractContainer;", "init", "", "restore", "releaseChronos", "saveState", "", "onStart", "onStop", "getPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "setSceneAndBizParams", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "getSceneAndBizParams", "Lkotlin/Pair;", "clearChronosPackage", "isChronosValid", "runChronosPackage", "chronosPackage", "Lcom/bilibili/cron/ChronosPackage;", "md5", "", "aid", "", "cid", "runPackageForLive", "pkg", "addDanmaku", "dmId", "type", "", "extra", "", "emoExtra", "", "", "registerChronosReadyCallback", "callback", "Ltv/danmaku/biliplayerv2/service/interact/biz/OnChronosReadyCallback;", "unregisterChronosReadyCallback", "setThumbnailConfig", "config", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "registerViewProgressObserver", "observer", "Ltv/danmaku/biliplayerv2/service/interact/biz/ViewProgressObserver;", "unregisterViewProgressObserver", "cloneMultiDanmaku", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/MultiDanmakuPlayer;", "content", "Landroid/content/Context;", "multiDanmakuCallback", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/IMultiDanmakuCallback;", "setDanmakuViewOffset", "offsetY", "", "getLocalHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ILocalHandler;", "getRemoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "getAdDanmakuDelegate", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/AdDanmakuDelegate;", "getDanmakuCommandPanelList", "Ltv/danmaku/biliplayerv2/service/interact/core/command/CommandsPanel;", "getChronosView", "Lcom/bilibili/common/chronoscommon/EnhancedChronosView;", "hasPackageResult", "loadViewProgress", "fragmentParam", "Lcom/bapis/bilibili/app/viewunite/v1/FragmentParam;", "fragmentOffset", "simplify", "loadCommandPanel", "loadThumbnailIfNeed", "loadThumbnailIfNeed2", "reportDanmaku", "danmakuId", "reason", "shieldUser", "shieldUserId", "oid", "needReportAndGetBlockData", "blockUser", "rResponse", "Lcom/bilibili/okretro/GeneralResponse;", "dmContent", "setChronosEnable", "enable", "getThumbnailFetcher", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader;", "getThumbnailFetcher2", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2;", "hasThumbnails", "hasThumbnails2", "setThumbnailEnable", "setThumbnail2Enable", "onWorkInfoChange", "workId", "videoId", "clearInteractContainer", "addDanmakuCommandPanelsObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuCommandPanelsObserver;", "removeDanmakuCommandPanelsObserver", "addDanmakuInteractionObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuInteractionObserver;", "removeDanmakuInteractionObserver", "setSegmentSwitchValue", "value", "getSegmentSwitchValue", "addSegmentSwitchObserver", "Landroidx/lifecycle/Observer;", "removeSegmentSwitchObserver", "addWatchPointsLoadListener", "listener", "Ltv/danmaku/biliplayerv2/service/interact/biz/IWatchPointsLoadListener;", "removeWatchPointsLoadListener", "setForcedChapterGuide", "setEyesProtectionMode", "mode", "bindChronosContainer", "container", "Landroid/widget/FrameLayout;", "getChronosContainer", "Landroid/view/ViewGroup;", "onAttachByShared", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "getViewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "onIJKFrameRendered", "info", "Ltv/danmaku/biliplayerv2/service/FrameRenderedInfo;", "isHdr", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IChronosInteractContainer extends IInteractContainer {
    void addDanmaku(String str, int i, Object obj);

    void addDanmaku(String str, int i, Object obj, Map<String, byte[]> map);

    void addDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver danmakuCommandPanelsObserver);

    void addDanmakuInteractionObserver(DanmakuInteractionObserver danmakuInteractionObserver);

    void addSegmentSwitchObserver(Observer<Boolean> observer);

    void addWatchPointsLoadListener(IWatchPointsLoadListener iWatchPointsLoadListener);

    void bindChronosContainer(FrameLayout frameLayout);

    void clearChronosPackage();

    void clearInteractContainer();

    MultiDanmakuPlayer cloneMultiDanmaku(Context context, IMultiDanmakuCallback iMultiDanmakuCallback);

    AdDanmakuDelegate getAdDanmakuDelegate();

    ViewGroup getChronosContainer();

    EnhancedChronosView getChronosView();

    CommandsPanel getDanmakuCommandPanelList();

    ILocalHandler getLocalHandler();

    PlayerContainer getPlayerContainer();

    IRemoteHandler getRemoteHandler();

    Pair<ChronosScene, ChronosBiz> getSceneAndBizParams();

    boolean getSegmentSwitchValue();

    ThumbnailLoader getThumbnailFetcher();

    ThumbnailLoader2 getThumbnailFetcher2();

    ViewProgressDetail getViewProgressDetail();

    boolean hasPackageResult();

    boolean hasThumbnails();

    boolean hasThumbnails2();

    void init();

    boolean isChronosValid();

    void loadCommandPanel();

    void loadThumbnailIfNeed();

    void loadThumbnailIfNeed2();

    void loadViewProgress(FragmentParam fragmentParam, long j, boolean z, Map<String, String> map);

    void onAttachByShared(PlayerSharingBundle playerSharingBundle);

    void onIJKFrameRendered(FrameRenderedInfo frameRenderedInfo, boolean z);

    void onStart();

    void onStop();

    void onWorkInfoChange(String str, String str2);

    void registerChronosReadyCallback(OnChronosReadyCallback onChronosReadyCallback);

    void registerViewProgressObserver(ViewProgressObserver viewProgressObserver);

    void releaseChronos(boolean z);

    void removeDanmakuCommandPanelsObserver(DanmakuCommandPanelsObserver danmakuCommandPanelsObserver);

    void removeDanmakuInteractionObserver();

    void removeSegmentSwitchObserver(Observer<Boolean> observer);

    void removeWatchPointsLoadListener(IWatchPointsLoadListener iWatchPointsLoadListener);

    void reportDanmaku(String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, GeneralResponse<String> generalResponse, String str5);

    void restore();

    void runChronosPackage(ChronosPackage chronosPackage, String str, long j, long j2);

    void runPackageForLive(ChronosPackage chronosPackage);

    void setChronosEnable(boolean z);

    void setDanmakuViewOffset(float f);

    void setEyesProtectionMode(boolean z);

    void setForcedChapterGuide(boolean z);

    void setSceneAndBizParams(ChronosScene chronosScene, ChronosBiz chronosBiz);

    void setSegmentSwitchValue(boolean z);

    void setThumbnail2Enable(boolean z);

    void setThumbnailConfig(ThumbnailConfig thumbnailConfig);

    void setThumbnailEnable(boolean z);

    void unregisterChronosReadyCallback();

    void unregisterViewProgressObserver(ViewProgressObserver viewProgressObserver);

    /* compiled from: IChronosInteractContainer.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.container.IChronosInteractContainer$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void releaseChronos$default(IChronosInteractContainer iChronosInteractContainer, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: releaseChronos");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iChronosInteractContainer.releaseChronos(z);
        }

        public static /* synthetic */ void loadViewProgress$default(IChronosInteractContainer iChronosInteractContainer, FragmentParam fragmentParam, long j, boolean z, Map map, int i, Object obj) {
            long j2;
            boolean z2;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadViewProgress");
            }
            if ((i & 2) == 0) {
                j2 = j;
            } else {
                j2 = 0;
            }
            if ((i & 4) == 0) {
                z2 = z;
            } else {
                z2 = false;
            }
            iChronosInteractContainer.loadViewProgress(fragmentParam, j2, z2, map);
        }

        public static /* synthetic */ void reportDanmaku$default(IChronosInteractContainer iChronosInteractContainer, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, GeneralResponse generalResponse, String str5, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDanmaku");
            }
            iChronosInteractContainer.reportDanmaku(str, str2, z, str3, str4, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? null : generalResponse, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : str5);
        }
    }
}