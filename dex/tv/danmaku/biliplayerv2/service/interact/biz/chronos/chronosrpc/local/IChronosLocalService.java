package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local;

import android.view.MotionEvent;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.AdDanmakuDelegate;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.model.DanmakuFilterContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.render.core.TransformParams;

/* compiled from: LocalServiceHandler.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016Jd\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\tH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H&J\b\u0010\"\u001a\u00020\u000bH&J\b\u0010#\u001a\u00020\u0010H&J\b\u0010$\u001a\u00020\u000bH&J\b\u0010%\u001a\u00020\u000bH&J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020)H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/IChronosLocalService;", "", "getNetWorkState", "", "getSceneAndBiz", "Lkotlin/Pair;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "getPackageSandBoxDirectory", "", "getChronosAbConfig", "", "key", "getAdDanmakuDelegate", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/AdDanmakuDelegate;", "reportDanmaku", "", "danmakuId", "reason", "shieldUser", "shieldUserId", "oid", "needReportAndGetBlockData", "blockUser", "rResponse", "Lcom/bilibili/okretro/GeneralResponse;", "dmContent", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "syncUIMode", "uiMode", "getViewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "needShowChronosProgress", "hideControlContainer", "forcedChapterGuide", "eyesProtectionMode", "getDanmakuTransformParams", "Ltv/danmaku/render/core/TransformParams;", "getDanmakuFilterContainer", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/DanmakuFilterContainer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IChronosLocalService {
    void dispatchTouchEvent(MotionEvent motionEvent);

    boolean eyesProtectionMode();

    boolean forcedChapterGuide();

    AdDanmakuDelegate getAdDanmakuDelegate();

    boolean getChronosAbConfig(String str);

    DanmakuFilterContainer getDanmakuFilterContainer();

    TransformParams getDanmakuTransformParams();

    int getNetWorkState();

    String getPackageSandBoxDirectory();

    Pair<ChronosScene, ChronosBiz> getSceneAndBiz();

    ViewProgressDetail getViewProgressDetail();

    void hideControlContainer();

    boolean needShowChronosProgress();

    void reportDanmaku(String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, GeneralResponse<String> generalResponse, String str5);

    void syncUIMode(String str);

    /* compiled from: LocalServiceHandler.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.IChronosLocalService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static AdDanmakuDelegate $default$getAdDanmakuDelegate(IChronosLocalService _this) {
            return null;
        }

        public static /* synthetic */ void reportDanmaku$default(IChronosLocalService iChronosLocalService, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, GeneralResponse generalResponse, String str5, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDanmaku");
            }
            iChronosLocalService.reportDanmaku(str, str2, z, str3, str4, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? null : generalResponse, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : str5);
        }

        public static void $default$reportDanmaku(IChronosLocalService _this, String danmakuId, String reason, boolean shieldUser, String shieldUserId, String oid, boolean needReportAndGetBlockData, boolean blockUser, GeneralResponse rResponse, String dmContent) {
            Intrinsics.checkNotNullParameter(danmakuId, "danmakuId");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(shieldUserId, "shieldUserId");
        }

        public static void $default$dispatchTouchEvent(IChronosLocalService _this, MotionEvent event) {
        }

        public static TransformParams $default$getDanmakuTransformParams(IChronosLocalService _this) {
            return null;
        }
    }
}