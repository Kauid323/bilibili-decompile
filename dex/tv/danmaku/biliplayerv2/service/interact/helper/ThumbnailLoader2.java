package tv.danmaku.biliplayerv2.service.interact.helper;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.biliid.utils.Md5Utils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.bean.BaseImageDataSubscriber;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.lib.util.UtilKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoFragmentRes;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoGuide;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoShot;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoViewPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2;
import tv.danmaku.biliplayerv2.utils.BitmapCacheHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailLoader2.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \\2\u00020\u0001:\u0005XYZ[\\B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0019J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(J \u0010)\u001a\u00020*2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001f2\b\b\u0002\u0010,\u001a\u00020\u001fJ\u0006\u0010-\u001a\u00020*J\u0010\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u00010\u0010J\u0010\u00100\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010\u000eJ\u0016\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u00104J\u001a\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001bH\u0002J\u0010\u0010:\u001a\u00020\u001b2\u0006\u00107\u001a\u000208H\u0002J\b\u0010;\u001a\u00020*H\u0002J\u0012\u0010<\u001a\u0004\u0018\u0001062\u0006\u0010=\u001a\u00020\u001bH\u0002J\u001a\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\u0010?\u001a\u0004\u0018\u000106H\u0002J\u0016\u0010@\u001a\u00020\u001b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020DH\u0002J2\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001fH\u0002J(\u0010M\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001fH\u0002J \u0010O\u001a\u00020\u001f2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010P\u001a\u00020\u001fH\u0002J\u0018\u0010Q\u001a\u00020*2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010SH\u0002J&\u0010U\u001a\u00020*2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u001f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020*0WH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u001c\u001a.\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e0\u001dj\u0016\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e` X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001dj\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\"` X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "state", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailState;", "value", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo;", "thumbnailInfo", "getThumbnailInfo", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo;", "thumbnailConfig", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "fetcherCallback", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailFetcherCallback;", "thumbnailRequestFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailFetchRequest;", "job", "Lkotlinx/coroutines/Job;", "quit", "", "currentThumbId", "", "cacheDir", "", "thumbIndexMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "videoShotMap", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoShot;", "hasThumbnails", "canUpdateThumbnail", "cid", "updateThumbnailInfo", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "fetch", "", "position", "tryTime", "reset", "setFetchCallback", "callback", "setConfig", "config", "work", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "(Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailFetchRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexFileStream", "Ljava/io/InputStream;", "context", "Landroid/content/Context;", "pvdata", "getCacheDirectory", "clearCache", "getIndexFileRemoteStream", "url", "parseIndexFile", "inputStream", "printIndexList", "list", "bytesToInt", "src", "", "cropFromSourceImage", "Landroid/graphics/Bitmap;", "cache", "Ljava/io/File;", "xCount", "yCount", "row", "col", "generateCacheKey", "index", "binarySearch", "des", "sortAndIndexWatchpoints", "pointsList", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "fetchSourceImage", "fetchCallback", "Lcom/bilibili/lib/image2/bean/BaseImageDataSubscriber;", "ThumbnailFetchRequest", "ThumbnailFetchResult", "ThumbnailState", "ThumbnailFetcherCallback", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ThumbnailLoader2 {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ThumbnailLoader2";
    private final FragmentActivity activity;
    private String cacheDir;
    private long currentThumbId;
    private ThumbnailFetcherCallback fetcherCallback;
    private final Job job;
    private boolean quit;
    private volatile ThumbnailState state;
    private final HashMap<Long, List<Integer>> thumbIndexMap;
    private ThumbnailConfig thumbnailConfig;
    private volatile ChronosThumbnailInfo thumbnailInfo;
    private final MutableSharedFlow<ThumbnailFetchRequest> thumbnailRequestFlow;
    private final HashMap<Long, VideoShot> videoShotMap;

    /* compiled from: ThumbnailLoader2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailFetcherCallback;", "", "onResult", "", "result", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailFetchResult;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ThumbnailFetcherCallback {
        void onResult(ThumbnailFetchResult thumbnailFetchResult);
    }

    /* compiled from: ThumbnailLoader2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "CANCEL", "FAILED", "SUCCEED", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum ThumbnailState {
        IDLE,
        LOADING,
        CANCEL,
        FAILED,
        SUCCEED;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<ThumbnailState> getEntries() {
            return $ENTRIES;
        }
    }

    public ThumbnailLoader2(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.state = ThumbnailState.IDLE;
        this.thumbnailRequestFlow = SharedFlowKt.MutableSharedFlow$default(0, 2, BufferOverflow.DROP_OLDEST, 1, (Object) null);
        this.job = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), Dispatchers.getIO(), (CoroutineStart) null, new ThumbnailLoader2$job$1(this, null), 2, (Object) null);
        this.currentThumbId = -1L;
        this.cacheDir = "";
        this.thumbIndexMap = new HashMap<>();
        this.videoShotMap = new HashMap<>();
    }

    public final ChronosThumbnailInfo getThumbnailInfo() {
        return this.thumbnailInfo;
    }

    private static BitmapRegionDecoder __Ghost$Insertion$com_bilibili_lib_util_AvifBitmapRegionCheckUtil_newInstance(InputStream is, boolean isShareable) throws IOException {
        InputStream input = UtilKt.processAvif(is);
        return BitmapRegionDecoder.newInstance(input, Boolean.valueOf(isShareable).booleanValue());
    }

    public final boolean hasThumbnails() {
        if (this.videoShotMap.isEmpty()) {
            return false;
        }
        Map $this$forEach$iv = this.videoShotMap;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            VideoShot info = element$iv.getValue();
            if (info != null && !info.getImageList().isEmpty() && info.getImgXLen() > 0 && info.getImgYLen() > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean canUpdateThumbnail(long cid) {
        boolean validState = this.state == ThumbnailState.LOADING || this.state == ThumbnailState.FAILED || this.state == ThumbnailState.SUCCEED;
        return cid == this.currentThumbId && validState;
    }

    public final boolean updateThumbnailInfo(long cid, ViewProgressDetail viewProgressDetail) {
        List pointsList;
        List<ChronosThumbnailInfo.WatchPoint> watchPoints;
        VideoFragmentRes fragmentRes;
        HashMap it;
        VideoGuide videoGuide;
        VideoViewPoint videoPoint;
        Iterable videoPointList;
        VideoGuide videoGuide2;
        VideoViewPoint videoPoint2;
        this.currentThumbId = cid;
        try {
            this.thumbnailInfo = new ChronosThumbnailInfo();
            ChronosThumbnailInfo chronosThumbnailInfo = this.thumbnailInfo;
            if (chronosThumbnailInfo != null) {
                chronosThumbnailInfo.setSegmentSwitchVisibility((viewProgressDetail == null || (videoGuide2 = viewProgressDetail.getVideoGuide()) == null || (videoPoint2 = videoGuide2.getVideoPoint()) == null) ? false : videoPoint2.getPointPermanent());
            }
            List watchPoints2 = new ArrayList();
            if (viewProgressDetail != null && (videoGuide = viewProgressDetail.getVideoGuide()) != null && (videoPoint = videoGuide.getVideoPoint()) != null && (videoPointList = videoPoint.getVideoPointList()) != null) {
                Iterable $this$forEach$iv = videoPointList;
                for (Object element$iv : $this$forEach$iv) {
                    VideoPoint it2 = (VideoPoint) element$iv;
                    if (it2.getFrom() <= it2.getTo() && it2.getFrom() >= 0) {
                        ChronosThumbnailInfo.WatchPoint watchPoint = new ChronosThumbnailInfo.WatchPoint();
                        watchPoint.setVideoPoint(it2);
                        watchPoints2.add(watchPoint);
                    }
                }
            }
            List list = null;
            this.videoShotMap.put(Long.valueOf(cid), viewProgressDetail != null ? viewProgressDetail.getVideoShot() : null);
            if (viewProgressDetail != null && (fragmentRes = viewProgressDetail.getFragmentRes()) != null && (it = fragmentRes.getVideoShotMap()) != null) {
                this.videoShotMap.putAll(it);
            }
            ChronosThumbnailInfo chronosThumbnailInfo2 = this.thumbnailInfo;
            if (chronosThumbnailInfo2 != null) {
                chronosThumbnailInfo2.setWatchPoints(CollectionsKt.toList(watchPoints2));
            }
            if (hasThumbnails()) {
                ChronosThumbnailInfo chronosThumbnailInfo3 = this.thumbnailInfo;
                if (chronosThumbnailInfo3 != null) {
                    chronosThumbnailInfo3.setCid(String.valueOf(cid));
                }
                if (this.state != ThumbnailState.CANCEL) {
                    this.state = ThumbnailState.SUCCEED;
                }
            } else {
                this.state = ThumbnailState.FAILED;
                BLog.e(TAG, "not found thumbnail");
            }
            if (RestrictedMode.isRestrictedMode()) {
                pointsList = null;
            } else {
                ChronosThumbnailInfo chronosThumbnailInfo4 = this.thumbnailInfo;
                if (chronosThumbnailInfo4 != null && (watchPoints = chronosThumbnailInfo4.getWatchPoints()) != null) {
                    list = CollectionsKt.toMutableList(watchPoints);
                }
                pointsList = list;
                sortAndIndexWatchpoints(pointsList);
            }
            ChronosThumbnailInfo chronosThumbnailInfo5 = this.thumbnailInfo;
            if (chronosThumbnailInfo5 != null) {
                chronosThumbnailInfo5.setWatchPoints(pointsList);
                return true;
            }
            return true;
        } catch (Exception e) {
            this.state = ThumbnailState.FAILED;
            return false;
        }
    }

    public static /* synthetic */ void fetch$default(ThumbnailLoader2 thumbnailLoader2, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        thumbnailLoader2.fetch(j, i, i2);
    }

    public final void fetch(long cid, int position, int tryTime) {
        BLog.i(TAG, "fetch, " + cid + " " + position + " " + tryTime);
        this.thumbnailRequestFlow.tryEmit(new ThumbnailFetchRequest(cid, position, tryTime));
    }

    public final void reset() {
        this.quit = true;
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        this.thumbnailInfo = null;
        this.thumbnailConfig = null;
        this.videoShotMap.clear();
        this.thumbIndexMap.clear();
        this.currentThumbId = -1L;
        clearCache();
    }

    public final void setFetchCallback(ThumbnailFetcherCallback callback) {
        this.fetcherCallback = callback;
    }

    public final void setConfig(ThumbnailConfig config) {
        this.thumbnailConfig = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object work(final ThumbnailFetchRequest request, Continuation<? super Unit> continuation) {
        ThumbnailLoader2$work$1 thumbnailLoader2$work$1;
        ThumbnailLoader2$work$1 thumbnailLoader2$work$12;
        Ref.ObjectRef bmp;
        int cacheLevel;
        String key;
        Ref.ObjectRef bmp2;
        Application application;
        Context applicationContext;
        DurationConstraint duration;
        if (continuation instanceof ThumbnailLoader2$work$1) {
            thumbnailLoader2$work$1 = (ThumbnailLoader2$work$1) continuation;
            if ((thumbnailLoader2$work$1.label & Integer.MIN_VALUE) != 0) {
                thumbnailLoader2$work$1.label -= Integer.MIN_VALUE;
                thumbnailLoader2$work$12 = thumbnailLoader2$work$1;
                Object $result = thumbnailLoader2$work$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (thumbnailLoader2$work$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!hasThumbnails()) {
                            BLog.e(TAG, "thumbnails is empty");
                            thumbnailLoader2$work$12.label = 1;
                            if (work$dispatchFailResult(this, request, thumbnailLoader2$work$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        VideoShot shot = this.videoShotMap.get(Boxing.boxLong(request.getCid()));
                        if (shot != null) {
                            String pvData = shot.getPvData();
                            if (!(pvData == null || pvData.length() == 0)) {
                                Ref.BooleanRef forbidden = new Ref.BooleanRef();
                                if (this.thumbnailConfig != null) {
                                    long currentDuration = DurationKt.toDuration(request.getPosition(), DurationUnit.SECONDS);
                                    ThumbnailConfig thumbnailConfig = this.thumbnailConfig;
                                    if (thumbnailConfig == null || (duration = thumbnailConfig.getDurationConstraint()) == null) {
                                        return Unit.INSTANCE;
                                    }
                                    if (duration.mo2265containsLRDsOJo(currentDuration)) {
                                        forbidden.element = true;
                                    }
                                }
                                if (forbidden.element) {
                                    ThumbnailConfig thumbnailConfig2 = this.thumbnailConfig;
                                    if (!(thumbnailConfig2 != null && thumbnailConfig2.getBitmapCrop())) {
                                        thumbnailLoader2$work$12.label = 7;
                                        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new ThumbnailLoader2$work$4(this, request, forbidden, null), thumbnailLoader2$work$12);
                                        return withContext == coroutine_suspended ? coroutine_suspended : withContext;
                                    }
                                }
                                List indexList = this.thumbIndexMap.get(Boxing.boxLong(request.getCid()));
                                if (indexList == null) {
                                    InputStream inputStream = null;
                                    try {
                                        try {
                                            application = BiliContext.application();
                                        } catch (Exception e) {
                                            BLog.e(TAG, "get indexList error " + e);
                                        }
                                        if (application != null && (applicationContext = application.getApplicationContext()) != null) {
                                            String pvData2 = shot.getPvData();
                                            if (pvData2 == null) {
                                                pvData2 = "";
                                            }
                                            inputStream = getIndexFileStream(applicationContext, pvData2);
                                            indexList = parseIndexFile(inputStream);
                                            this.thumbIndexMap.put(Boxing.boxLong(request.getCid()), indexList);
                                        }
                                        return Unit.INSTANCE;
                                    } finally {
                                        IOUtils.closeQuietly((InputStream) null);
                                    }
                                }
                                List list = indexList;
                                if (list == null || list.isEmpty()) {
                                    BLog.e(TAG, "indexList isNullOrEmpty");
                                    thumbnailLoader2$work$12.label = 3;
                                    if (work$dispatchFailResult(this, request, thumbnailLoader2$work$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                int num = binarySearch(indexList, request.getPosition());
                                final int index = num / (shot.getImgXLen() * shot.getImgYLen());
                                int numInCurrentImg = num - ((shot.getImgXLen() * shot.getImgYLen()) * index);
                                int row = numInCurrentImg / shot.getImgXLen();
                                int col = numInCurrentImg - (shot.getImgXLen() * row);
                                BLog.d(TAG, "fetchThumbnail: -----> cid:" + request.getCid() + " position:" + request.getPosition() + " " + index + " " + row + " " + col);
                                String url = (String) CollectionsKt.getOrNull(shot.getImageList(), index);
                                if (url == null) {
                                    if (this.quit) {
                                        return Unit.INSTANCE;
                                    }
                                    thumbnailLoader2$work$12.label = 4;
                                    if (work$dispatchFailResult(this, request, thumbnailLoader2$work$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                String key2 = generateCacheKey(url, index, row, col);
                                Ref.ObjectRef bmp3 = new Ref.ObjectRef();
                                bmp3.element = BitmapCacheHelper.INSTANCE.getBitmap(key2);
                                if (bmp3.element == null) {
                                    if (hasThumbnails()) {
                                        File cache = BiliImageLoaderHelper.getDiskCacheFile$default(url, false, 2, (Object) null);
                                        if (cache == null) {
                                            BLog.e(TAG, "source image not found!" + index);
                                            fetchSourceImage(request.getCid(), index, new BaseImageDataSubscriber<Unit>() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2$work$2
                                                protected void onNewResultImpl(ImageDataSource<Unit> imageDataSource) {
                                                    boolean z;
                                                    boolean z2;
                                                    MutableSharedFlow mutableSharedFlow;
                                                    z = ThumbnailLoader2.this.quit;
                                                    BLog.i("ThumbnailLoader2", "onNewResultImpl: " + z + ", " + index + ", " + (imageDataSource != null ? Boolean.valueOf(imageDataSource.isFinished()) : null));
                                                    z2 = ThumbnailLoader2.this.quit;
                                                    if (!z2) {
                                                        mutableSharedFlow = ThumbnailLoader2.this.thumbnailRequestFlow;
                                                        mutableSharedFlow.tryEmit(ThumbnailLoader2.ThumbnailFetchRequest.copy$default(request, 0L, 0, 0, 3, null));
                                                    }
                                                }

                                                /* JADX WARN: Code restructure failed: missing block: B:5:0x003b, code lost:
                                                    r0 = r11.this$0.fetcherCallback;
                                                 */
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                protected void onFailureImpl(ImageDataSource<Unit> imageDataSource) {
                                                    boolean z;
                                                    boolean z2;
                                                    ThumbnailLoader2.ThumbnailFetcherCallback thumbnailFetcherCallback;
                                                    z = ThumbnailLoader2.this.quit;
                                                    BLog.i("ThumbnailLoader2", "onFailureImpl:  " + z + ", " + index + ", " + imageDataSource);
                                                    z2 = ThumbnailLoader2.this.quit;
                                                    if (!z2 && thumbnailFetcherCallback != null) {
                                                        thumbnailFetcherCallback.onResult(new ThumbnailLoader2.ThumbnailFetchResult(request.getCid(), request.getPosition(), null, false, null, 28, null));
                                                    }
                                                }
                                            });
                                            if (request.getTryTime() > 0) {
                                                BLog.i(TAG, "fetchSourceImage, tryTime > 0");
                                                return Unit.INSTANCE;
                                            }
                                            bmp = bmp3;
                                        } else {
                                            bmp = bmp3;
                                            bmp.element = cropFromSourceImage(cache, shot.getImgXLen(), shot.getImgYLen(), row, col);
                                        }
                                    } else {
                                        bmp = bmp3;
                                    }
                                    cacheLevel = 0 + 1;
                                    Boxing.boxInt(0);
                                } else {
                                    bmp = bmp3;
                                    BLog.i(TAG, "load from cache");
                                    cacheLevel = 0;
                                }
                                if (this.quit) {
                                    return Unit.INSTANCE;
                                }
                                if (bmp.element == null) {
                                    thumbnailLoader2$work$12.label = 5;
                                    if (work$dispatchFailResult(this, request, thumbnailLoader2$work$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                thumbnailLoader2$work$12.L$0 = key2;
                                thumbnailLoader2$work$12.L$1 = bmp;
                                thumbnailLoader2$work$12.I$0 = cacheLevel;
                                thumbnailLoader2$work$12.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new ThumbnailLoader2$work$3(this, request, bmp, forbidden, null), thumbnailLoader2$work$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                key = key2;
                                bmp2 = bmp;
                                if (!((Bitmap) bmp2.element).isRecycled() && cacheLevel > 0) {
                                    BitmapCacheHelper.INSTANCE.saveBitmap(key, (Bitmap) bmp2.element);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        BLog.e(TAG, "thumbnails is empty");
                        thumbnailLoader2$work$12.label = 2;
                        if (work$dispatchFailResult(this, request, thumbnailLoader2$work$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 5:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 6:
                        cacheLevel = thumbnailLoader2$work$12.I$0;
                        bmp2 = (Ref.ObjectRef) thumbnailLoader2$work$12.L$1;
                        key = (String) thumbnailLoader2$work$12.L$0;
                        ResultKt.throwOnFailure($result);
                        if (!((Bitmap) bmp2.element).isRecycled()) {
                            BitmapCacheHelper.INSTANCE.saveBitmap(key, (Bitmap) bmp2.element);
                        }
                        return Unit.INSTANCE;
                    case 7:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        thumbnailLoader2$work$1 = new ThumbnailLoader2$work$1(this, continuation);
        thumbnailLoader2$work$12 = thumbnailLoader2$work$1;
        Object $result2 = thumbnailLoader2$work$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (thumbnailLoader2$work$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object work$dispatchFailResult(ThumbnailLoader2 this$0, ThumbnailFetchRequest $request, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new ThumbnailLoader2$work$dispatchFailResult$2(this$0, $request, null), continuation);
    }

    private final InputStream getIndexFileStream(Context context, String pvdata) throws IOException {
        InputStream connInputStream;
        File file;
        String cacheDir = getCacheDirectory(context);
        if (TextUtils.isEmpty(cacheDir)) {
            return getIndexFileRemoteStream(pvdata);
        }
        String key = Md5Utils.encoderByMd5(pvdata);
        File cache = new File(cacheDir);
        if (!cache.exists()) {
            cache.mkdirs();
        }
        File[] listFiles = cache.listFiles();
        FileInputStream result = null;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    file = null;
                    break;
                }
                file = listFiles[i];
                if (Intrinsics.areEqual(file.getName(), key)) {
                    break;
                }
                i++;
            }
            if (file != null) {
                File $this$getIndexFileStream_u24lambda_u241 = file;
                result = new FileInputStream($this$getIndexFileStream_u24lambda_u241);
            }
        }
        InputStream result2 = result;
        if (result2 != null || (connInputStream = getIndexFileRemoteStream(pvdata)) == null) {
            return result2;
        }
        String name = cache.getAbsolutePath() + File.separator + key;
        FileOutputStream fileOutputStream = new FileOutputStream(name);
        IOUtils.copy(connInputStream, fileOutputStream);
        connInputStream.close();
        fileOutputStream.close();
        return new FileInputStream(name);
    }

    private final String getCacheDirectory(Context context) {
        File cache = context.getApplicationContext().getExternalCacheDir();
        if (cache == null) {
            cache = context.getApplicationContext().getCacheDir();
        }
        this.cacheDir = (cache != null ? cache.getAbsolutePath() : null) + "/bin";
        return this.cacheDir;
    }

    private final void clearCache() {
        File[] cacheFiles;
        if (TextUtils.isEmpty(this.cacheDir)) {
            return;
        }
        File file = new File(this.cacheDir);
        if (file.exists() && file.isDirectory() && (cacheFiles = file.listFiles()) != null) {
            if (cacheFiles.length == 0) {
                return;
            }
            long now = System.currentTimeMillis();
            for (File cache : cacheFiles) {
                long lastModifiedTime = cache.lastModified();
                if (Math.abs(now - lastModifiedTime) >= 259200000) {
                    cache.delete();
                }
            }
        }
    }

    private final InputStream getIndexFileRemoteStream(String url) {
        OkHttpClient client = OkHttpClientWrapper.get().newBuilder().readTimeout(10L, TimeUnit.SECONDS).connectTimeout(10L, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(url).get().build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            return body.byteStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final List<Integer> parseIndexFile(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            BLog.i(TAG, "parseIndexFile, inputStream is null");
            return EnhancedUnmodifiabilityKt.unmodifiable((List) null);
        }
        byte[] temp = new byte[2];
        ArrayList list = new ArrayList();
        while (true) {
            int readCount = inputStream.read(temp);
            if (readCount == -1) {
                break;
            } else if (readCount != 0) {
                if (readCount == 1) {
                    BLog.e(TAG, "read count incorrect: " + readCount);
                    temp[1] = (byte) inputStream.read();
                    if (temp[1] == -1) {
                        break;
                    }
                }
                list.add(Integer.valueOf(bytesToInt(temp)));
            }
        }
        if (!list.isEmpty()) {
            list.remove(0);
        }
        BLog.i(TAG, "index: " + printIndexList(list));
        return EnhancedUnmodifiabilityKt.unmodifiable(list);
    }

    private final String printIndexList(List<Integer> list) {
        List<Number> list2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        StringBuilder builder = new StringBuilder();
        for (Number number : list2) {
            int i = number.intValue();
            builder.append(", ").append(i);
        }
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    private final int bytesToInt(byte[] src) {
        return (src[1] & 255) | ((src[0] << 8) & 65280);
    }

    private final Bitmap cropFromSourceImage(File cache, int xCount, int yCount, int row, int col) {
        Bitmap bitmap;
        Bitmap bitmap2;
        InputStream inputStream = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
            try {
                inputStream = new FileInputStream(cache);
                BitmapRegionDecoder decoder = __Ghost$Insertion$com_bilibili_lib_util_AvifBitmapRegionCheckUtil_newInstance(inputStream, true);
                Intrinsics.checkNotNull(decoder);
                int thumbWidth = (int) ((decoder.getWidth() * 1.0f) / xCount);
                try {
                    int thumbHeight = (int) ((decoder.getHeight() * 1.0f) / yCount);
                    try {
                        bitmap = null;
                        try {
                            Rect rect = new Rect(col * thumbWidth, row * thumbHeight, (col + 1) * thumbWidth, (row + 1) * thumbHeight);
                            if (!decoder.isRecycled() && new Rect(0, 0, decoder.getWidth(), decoder.getHeight()).contains(rect)) {
                                bitmap2 = decoder.decodeRegion(rect, null);
                                IOUtils.closeQuietly(inputStream);
                                return bitmap2;
                            }
                            BLog.e(TAG, "crop thumbnail rect error -> " + rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom);
                            bitmap2 = null;
                            IOUtils.closeQuietly(inputStream);
                            return bitmap2;
                        } catch (Exception e) {
                            e = e;
                            BLog.e(TAG, "crop thumbnail error -> " + e);
                            IOUtils.closeQuietly(inputStream);
                            return bitmap;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bitmap = null;
                        BLog.e(TAG, "crop thumbnail error -> " + e);
                        IOUtils.closeQuietly(inputStream);
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap = null;
                    BLog.e(TAG, "crop thumbnail error -> " + e);
                    IOUtils.closeQuietly(inputStream);
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                bitmap = null;
                BLog.e(TAG, "crop thumbnail error -> " + e);
                IOUtils.closeQuietly(inputStream);
                return bitmap;
            } catch (Throwable th4) {
                th = th4;
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private final String generateCacheKey(String url, int index, int row, int col) {
        ChronosThumbnailInfo chronosThumbnailInfo = this.thumbnailInfo;
        return (chronosThumbnailInfo != null ? chronosThumbnailInfo.getCid() : null) + "_" + DigestUtils.md5(url) + "_" + index + "_" + row + "_" + col;
    }

    private final int binarySearch(List<Integer> list, int des) {
        List src = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List list2 = src;
        if (list2 == null || list2.isEmpty()) {
            throw new RuntimeException("The list is empty!");
        }
        if (des <= ((Number) src.get(0)).intValue()) {
            return 0;
        }
        int length = src.size();
        if (des >= ((Number) src.get(length - 1)).intValue()) {
            return length - 1;
        }
        int pos = Collections.binarySearch(src, Integer.valueOf(des));
        return pos < 0 ? ((-pos) - 1) - 1 : pos;
    }

    private final void sortAndIndexWatchpoints(List<ChronosThumbnailInfo.WatchPoint> list) {
        if (list == null) {
            return;
        }
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader2$sortAndIndexWatchpoints$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    ChronosThumbnailInfo.WatchPoint it = (ChronosThumbnailInfo.WatchPoint) t;
                    ChronosThumbnailInfo.WatchPoint it2 = (ChronosThumbnailInfo.WatchPoint) t2;
                    return ComparisonsKt.compareValues(Integer.valueOf(it.getFrom()), Integer.valueOf(it2.getFrom()));
                }
            });
        }
        int i = 0;
        for (ChronosThumbnailInfo.WatchPoint point : list) {
            int index = i;
            i++;
            point.setIndex(index);
        }
    }

    private final void fetchSourceImage(long cid, int index, BaseImageDataSubscriber<Unit> baseImageDataSubscriber) {
        ArrayList<String> imageList;
        String url;
        VideoShot videoShot = this.videoShotMap.get(Long.valueOf(cid));
        if (videoShot == null || (imageList = videoShot.getImageList()) == null || (url = imageList.get(index)) == null) {
            return;
        }
        BLog.i(TAG, "fetchSourceImage: " + index + ", " + url);
        if (ConfigManager.Companion.ab2().getWithDefault("ff_noavif_enable", false)) {
            BiliImageLoader.INSTANCE.acquire(this.activity).useRaw().preload().url(url).noAvif().fetchToDiskCache().subscribe((ImageDataSubscriber) baseImageDataSubscriber);
        } else {
            BiliImageLoader.INSTANCE.acquire(this.activity).useRaw().preload().url(url).fetchToDiskCache().subscribe((ImageDataSubscriber) baseImageDataSubscriber);
        }
    }

    /* compiled from: ThumbnailLoader2.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailFetchRequest;", "", "cid", "", "position", "", "tryTime", "<init>", "(JII)V", "getCid", "()J", "getPosition", "()I", "getTryTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ThumbnailFetchRequest {
        private final long cid;
        private final int position;
        private final int tryTime;

        public static /* synthetic */ ThumbnailFetchRequest copy$default(ThumbnailFetchRequest thumbnailFetchRequest, long j, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j = thumbnailFetchRequest.cid;
            }
            if ((i3 & 2) != 0) {
                i = thumbnailFetchRequest.position;
            }
            if ((i3 & 4) != 0) {
                i2 = thumbnailFetchRequest.tryTime;
            }
            return thumbnailFetchRequest.copy(j, i, i2);
        }

        public final long component1() {
            return this.cid;
        }

        public final int component2() {
            return this.position;
        }

        public final int component3() {
            return this.tryTime;
        }

        public final ThumbnailFetchRequest copy(long j, int i, int i2) {
            return new ThumbnailFetchRequest(j, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ThumbnailFetchRequest) {
                ThumbnailFetchRequest thumbnailFetchRequest = (ThumbnailFetchRequest) obj;
                return this.cid == thumbnailFetchRequest.cid && this.position == thumbnailFetchRequest.position && this.tryTime == thumbnailFetchRequest.tryTime;
            }
            return false;
        }

        public int hashCode() {
            return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid) * 31) + this.position) * 31) + this.tryTime;
        }

        public String toString() {
            long j = this.cid;
            int i = this.position;
            return "ThumbnailFetchRequest(cid=" + j + ", position=" + i + ", tryTime=" + this.tryTime + ")";
        }

        public ThumbnailFetchRequest(long cid, int position, int tryTime) {
            this.cid = cid;
            this.position = position;
            this.tryTime = tryTime;
        }

        public /* synthetic */ ThumbnailFetchRequest(long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i, (i3 & 4) != 0 ? 0 : i2);
        }

        public final long getCid() {
            return this.cid;
        }

        public final int getPosition() {
            return this.position;
        }

        public final int getTryTime() {
            return this.tryTime;
        }
    }

    /* compiled from: ThumbnailLoader2.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$ThumbnailFetchResult;", "", "cid", "", "position", "", "bitmap", "Landroid/graphics/Bitmap;", "forbidden", "", "content", "", "<init>", "(JILandroid/graphics/Bitmap;ZLjava/lang/String;)V", "getCid", "()J", "getPosition", "()I", "getBitmap", "()Landroid/graphics/Bitmap;", "getForbidden", "()Z", "getContent", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ThumbnailFetchResult {
        private final Bitmap bitmap;
        private final long cid;
        private final String content;
        private final boolean forbidden;
        private final int position;

        public static /* synthetic */ ThumbnailFetchResult copy$default(ThumbnailFetchResult thumbnailFetchResult, long j, int i, Bitmap bitmap, boolean z, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = thumbnailFetchResult.cid;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                i = thumbnailFetchResult.position;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                bitmap = thumbnailFetchResult.bitmap;
            }
            Bitmap bitmap2 = bitmap;
            if ((i2 & 8) != 0) {
                z = thumbnailFetchResult.forbidden;
            }
            boolean z2 = z;
            if ((i2 & 16) != 0) {
                str = thumbnailFetchResult.content;
            }
            return thumbnailFetchResult.copy(j2, i3, bitmap2, z2, str);
        }

        public final long component1() {
            return this.cid;
        }

        public final int component2() {
            return this.position;
        }

        public final Bitmap component3() {
            return this.bitmap;
        }

        public final boolean component4() {
            return this.forbidden;
        }

        public final String component5() {
            return this.content;
        }

        public final ThumbnailFetchResult copy(long j, int i, Bitmap bitmap, boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new ThumbnailFetchResult(j, i, bitmap, z, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ThumbnailFetchResult) {
                ThumbnailFetchResult thumbnailFetchResult = (ThumbnailFetchResult) obj;
                return this.cid == thumbnailFetchResult.cid && this.position == thumbnailFetchResult.position && Intrinsics.areEqual(this.bitmap, thumbnailFetchResult.bitmap) && this.forbidden == thumbnailFetchResult.forbidden && Intrinsics.areEqual(this.content, thumbnailFetchResult.content);
            }
            return false;
        }

        public int hashCode() {
            return (((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid) * 31) + this.position) * 31) + (this.bitmap == null ? 0 : this.bitmap.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forbidden)) * 31) + this.content.hashCode();
        }

        public String toString() {
            long j = this.cid;
            int i = this.position;
            Bitmap bitmap = this.bitmap;
            boolean z = this.forbidden;
            return "ThumbnailFetchResult(cid=" + j + ", position=" + i + ", bitmap=" + bitmap + ", forbidden=" + z + ", content=" + this.content + ")";
        }

        public ThumbnailFetchResult(long cid, int position, Bitmap bitmap, boolean forbidden, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.cid = cid;
            this.position = position;
            this.bitmap = bitmap;
            this.forbidden = forbidden;
            this.content = content;
        }

        public /* synthetic */ ThumbnailFetchResult(long j, int i, Bitmap bitmap, boolean z, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i, (i2 & 4) != 0 ? null : bitmap, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "" : str);
        }

        public final long getCid() {
            return this.cid;
        }

        public final int getPosition() {
            return this.position;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final boolean getForbidden() {
            return this.forbidden;
        }

        public final String getContent() {
            return this.content;
        }
    }

    /* compiled from: ThumbnailLoader2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader2$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}