package tv.danmaku.biliplayerv2.service.interact.helper;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.droid.thread.HandlerThreads;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.ThumbnailFetcherCallback;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoGuide;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoShot;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoViewPoint;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader;
import tv.danmaku.biliplayerv2.utils.BitmapCacheHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailLoader.kt */
@Deprecated(message = "use ThumbnailLoader2")
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0003IJKB\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010,\u001a\u00020#J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0016J\u0018\u0010/\u001a\u00020#2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002J\u001e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020#06H\u0002J\u0006\u00107\u001a\u00020#J\u0006\u00108\u001a\u00020#J\b\u00109\u001a\u00020'H\u0016J\u001a\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001bH\u0002J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=H\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010;2\u0006\u0010A\u001a\u00020\u001bH\u0002J\u001a\u0010B\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001d2\b\u0010C\u001a\u0004\u0018\u00010;H\u0002J\u0016\u0010D\u001a\u00020\u001b2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0002J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020HH\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader;", "Ljava/lang/Runnable;", "Ltv/danmaku/biliplayerv2/service/ThumbnailLoader;", "mServiceWeakRef", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer;", "playableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "<init>", "(Ljava/lang/ref/WeakReference;Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;)V", "mState", "", "getMState", "()I", "setMState", "(I)V", "thumbnailInfo", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo;", "getThumbnailInfo", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo;", "setThumbnailInfo", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo;)V", "thumbnailConfig", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "videoShot", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoShot;", "mCacheDir", "", "mIndexList", "", "mWorker", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader$Worker;", "mFetcherCallback", "Ltv/danmaku/biliplayerv2/service/ThumbnailFetcherCallback;", "fetch", "", "position", "duration", "waitFetchRes", "", "setResponseCallback", "callback", "setConfig", "config", "load", "clearCache", "run", "sortAndIndexWatchpoints", "pointsList", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "fetchSourceImage", "index", "fetchCallback", "Lcom/bilibili/lib/image2/bean/BaseImageDataSubscriber;", SplashCustomReporterKt.STATE_CANCEL, "release", "hasThumbnails", "getIndexFileStream", "Ljava/io/InputStream;", "context", "Landroid/content/Context;", "pvdata", "getCacheDirectory", "getIndexFileRemoteStream", "url", "parseIndexFile", "inputStream", "printIndexList", "list", "bytesToInt", "src", "", "ThumbnailMessage", "Worker", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ThumbnailLoader implements Runnable, tv.danmaku.biliplayerv2.service.ThumbnailLoader {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ThumbnailLoader";
    private String mCacheDir;
    private ThumbnailFetcherCallback mFetcherCallback;
    private List<Integer> mIndexList;
    private final WeakReference<ChronosInteractContainer> mServiceWeakRef;
    private volatile int mState;
    private Worker mWorker;
    private final Video.PlayableParams playableParams;
    private ThumbnailConfig thumbnailConfig;
    private volatile ChronosThumbnailInfo thumbnailInfo;
    private VideoShot videoShot;

    public ThumbnailLoader(WeakReference<ChronosInteractContainer> weakReference, Video.PlayableParams playableParams) {
        Intrinsics.checkNotNullParameter(weakReference, "mServiceWeakRef");
        Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        this.mServiceWeakRef = weakReference;
        this.playableParams = playableParams;
        this.mState = -1;
        this.mCacheDir = "";
    }

    public final int getMState() {
        return this.mState;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final ChronosThumbnailInfo getThumbnailInfo() {
        return this.thumbnailInfo;
    }

    public final void setThumbnailInfo(ChronosThumbnailInfo chronosThumbnailInfo) {
        this.thumbnailInfo = chronosThumbnailInfo;
    }

    /* compiled from: ThumbnailLoader.kt */
    @Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0014\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0002J2\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J(\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J \u0010(\u001a\u00020\u00052\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006,"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader$Worker;", "Ljava/lang/Thread;", "<init>", "(Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader;)V", "msgDisplayImg", "", "msgFetchFinish", "msgFetchFailed", "queue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader$ThumbnailMessage;", "quit", "", "lock", "Ljava/lang/Object;", "hasBarrier", "lastMessage", "removeBarrierRunnable", "Ljava/lang/Runnable;", "mHandler", "tv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader$Worker$mHandler$1", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader$Worker$mHandler$1;", "run", "", "post", "msg", "release", "work", "cropFromSourceImage", "Landroid/graphics/Bitmap;", "cache", "Ljava/io/File;", "xCount", "yCount", "row", "col", "generateCacheKey", "", "url", "index", "binarySearch", "src", "", "des", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class Worker extends Thread {
        private boolean hasBarrier;
        private ThumbnailMessage lastMessage;
        private final Object lock;
        private final ThumbnailLoader$Worker$mHandler$1 mHandler;
        private final int msgDisplayImg;
        private final int msgFetchFailed;
        private final int msgFetchFinish;
        private final LinkedBlockingQueue<ThumbnailMessage> queue;
        private boolean quit;
        private final Runnable removeBarrierRunnable;

        private static BitmapRegionDecoder __Ghost$Insertion$com_bilibili_lib_util_AvifBitmapRegionCheckUtil_newInstance(InputStream is, boolean isShareable) throws IOException {
            InputStream input = UtilKt.processAvif(is);
            return BitmapRegionDecoder.newInstance(input, Boolean.valueOf(isShareable).booleanValue());
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$Worker$mHandler$1] */
        public Worker() {
            super("Seek-Thumbnail");
            this.msgFetchFinish = 1;
            this.msgFetchFailed = 2;
            this.queue = new LinkedBlockingQueue<>();
            this.lock = new Object();
            this.removeBarrierRunnable = new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$Worker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ThumbnailLoader.Worker.removeBarrierRunnable$lambda$0(ThumbnailLoader.Worker.this);
                }
            };
            final ThumbnailLoader thumbnailLoader = ThumbnailLoader.this;
            this.mHandler = new Handler() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$Worker$mHandler$1
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
                    r2 = r2.mFetcherCallback;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
                    r0 = r2.mFetcherCallback;
                 */
                @Override // android.os.Handler
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void handleMessage(Message msg) {
                    boolean z;
                    int i;
                    int i2;
                    int i3;
                    ThumbnailFetcherCallback thumbnailFetcherCallback;
                    ThumbnailFetcherCallback thumbnailFetcherCallback2;
                    ThumbnailFetcherCallback thumbnailFetcherCallback3;
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    z = ThumbnailLoader.Worker.this.quit;
                    if (z) {
                        return;
                    }
                    int i4 = msg.what;
                    i = ThumbnailLoader.Worker.this.msgDisplayImg;
                    if (i4 != i) {
                        i2 = ThumbnailLoader.Worker.this.msgFetchFinish;
                        if (i4 != i2) {
                            i3 = ThumbnailLoader.Worker.this.msgFetchFailed;
                            if (i4 != i3 || thumbnailFetcherCallback == null) {
                                return;
                            }
                            thumbnailFetcherCallback.onFailed();
                            return;
                        } else if (msg.obj instanceof ThumbnailLoader.ThumbnailMessage) {
                            Object obj = msg.obj;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader.ThumbnailMessage");
                            ThumbnailLoader.ThumbnailMessage msg2 = (ThumbnailLoader.ThumbnailMessage) obj;
                            if (msg2.getBitmap() == null) {
                                thumbnailFetcherCallback2 = thumbnailLoader.mFetcherCallback;
                                if (thumbnailFetcherCallback2 != null) {
                                    thumbnailFetcherCallback2.onResultWithoutBitmap(msg2.getForbidden(), msg2.getContent());
                                    return;
                                }
                                return;
                            }
                            Bitmap it = msg2.getBitmap();
                            if (it == null || thumbnailFetcherCallback3 == null) {
                                return;
                            }
                            thumbnailFetcherCallback3.onResult(it);
                            return;
                        } else {
                            return;
                        }
                    }
                    ThumbnailLoader.Worker worker = ThumbnailLoader.Worker.this;
                    Object obj2 = msg.obj;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader.ThumbnailMessage");
                    worker.post((ThumbnailLoader.ThumbnailMessage) obj2);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void removeBarrierRunnable$lambda$0(Worker this$0) {
            this$0.hasBarrier = false;
            this$0.post(this$0.lastMessage);
            this$0.lastMessage = null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.quit) {
                ThumbnailMessage msg = this.queue.poll();
                if (msg != null) {
                    try {
                        work(msg);
                    } catch (Exception e) {
                        BLog.e(ThumbnailLoader.TAG, "error -> " + e);
                    }
                } else {
                    synchronized (this.lock) {
                        this.lock.wait();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            BLog.d(ThumbnailLoader.TAG, "worker quitting......");
        }

        public final void post(ThumbnailMessage msg) {
            if (msg == null || this.hasBarrier) {
                this.lastMessage = msg;
                return;
            }
            this.hasBarrier = true;
            postDelayed(this.removeBarrierRunnable, 100L);
            try {
                this.queue.put(msg);
                synchronized (this.lock) {
                    this.lock.notify();
                    Unit unit = Unit.INSTANCE;
                }
            } catch (InterruptedException e) {
            }
        }

        public final void release() {
            this.quit = true;
            synchronized (this.lock) {
                this.lock.notify();
                Unit unit = Unit.INSTANCE;
            }
            this.queue.clear();
            removeMessages(this.msgFetchFinish);
            removeMessages(this.msgDisplayImg);
            removeMessages(this.msgFetchFailed);
            removeCallbacks(this.removeBarrierRunnable);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
            if (r2.getBitmapCrop() == true) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00ec A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00ed  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void work(final ThumbnailMessage msg) {
            VideoShot info;
            boolean forbidden;
            List indexList;
            String key;
            Bitmap bmp;
            Application application;
            Context context;
            String content;
            DurationConstraint duration;
            if (!ThumbnailLoader.this.hasThumbnails() || (info = ThumbnailLoader.this.videoShot) == null) {
                return;
            }
            if (ThumbnailLoader.this.thumbnailConfig != null) {
                long currentDuration = DurationKt.toDuration(msg.getSeconds(), DurationUnit.SECONDS);
                ThumbnailConfig thumbnailConfig = ThumbnailLoader.this.thumbnailConfig;
                if (thumbnailConfig == null || (duration = thumbnailConfig.getDurationConstraint()) == null) {
                    return;
                }
                if (duration.mo2265containsLRDsOJo(currentDuration)) {
                    forbidden = true;
                    String str = "";
                    if (forbidden) {
                        ThumbnailConfig thumbnailConfig2 = ThumbnailLoader.this.thumbnailConfig;
                        boolean z = thumbnailConfig2 != null;
                        if (!z) {
                            msg.setForbidden(forbidden);
                            ThumbnailConfig thumbnailConfig3 = ThumbnailLoader.this.thumbnailConfig;
                            if (thumbnailConfig3 != null && (content = thumbnailConfig3.getContent()) != null) {
                                str = content;
                            }
                            msg.setContent(str);
                            Message.obtain(this.mHandler, this.msgFetchFinish, msg).sendToTarget();
                            return;
                        }
                    }
                    if (ThumbnailLoader.this.mIndexList == null) {
                        InputStream inputStream = null;
                        try {
                            try {
                                application = BiliContext.application();
                            } catch (Exception e) {
                                BLog.e(ThumbnailLoader.TAG, e);
                                InputStream inputStream2 = null;
                                ThumbnailLoader.this.mIndexList = null;
                            }
                            if (application != null && (context = application.getApplicationContext()) != null) {
                                ThumbnailLoader thumbnailLoader = ThumbnailLoader.this;
                                String pvData = info.getPvData();
                                if (pvData != null) {
                                    str = pvData;
                                }
                                inputStream = thumbnailLoader.getIndexFileStream(context, str);
                                if (inputStream == null) {
                                    BLog.e(ThumbnailLoader.TAG, "could found index file");
                                    ThumbnailLoader.this.setMState(2);
                                    return;
                                }
                                ThumbnailLoader.this.mIndexList = ThumbnailLoader.this.parseIndexFile(inputStream);
                            }
                            return;
                        } finally {
                            IOUtils.closeQuietly(inputStream);
                        }
                    }
                    indexList = ThumbnailLoader.this.mIndexList;
                    if (indexList != null) {
                        return;
                    }
                    int num = binarySearch(indexList, msg.getSeconds());
                    final int index = num / (info.getImgXLen() * info.getImgYLen());
                    int numInCurrentImg = num - ((info.getImgXLen() * info.getImgYLen()) * index);
                    int row = numInCurrentImg / info.getImgXLen();
                    int col = numInCurrentImg - (info.getImgXLen() * row);
                    BLog.d(ThumbnailLoader.TAG, "fetchThumbnail: -----> " + msg.getSeconds() + "s, " + index + ": " + row + ", " + col);
                    String url = (String) CollectionsKt.getOrNull(info.getImageList(), index);
                    if (url == null) {
                        removeMessages(this.msgFetchFailed);
                        if (this.quit) {
                            return;
                        }
                        Message.obtain(this.mHandler, this.msgFetchFailed).sendToTarget();
                        return;
                    }
                    String key2 = generateCacheKey(url, index, row, col);
                    int cacheLevel = 0;
                    Bitmap bmp2 = BitmapCacheHelper.INSTANCE.getBitmap(key2);
                    if (bmp2 == null) {
                        if (ThumbnailLoader.this.hasThumbnails()) {
                            File cache = BiliImageLoaderHelper.getDiskCacheFile$default(url, false, 2, (Object) null);
                            if (cache == null) {
                                BLog.e(ThumbnailLoader.TAG, "source image not found!" + index);
                                ThumbnailLoader.this.fetchSourceImage(index, new BaseImageDataSubscriber<Unit>() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$Worker$work$1
                                    protected void onNewResultImpl(ImageDataSource<Unit> imageDataSource) {
                                        boolean z2;
                                        z2 = ThumbnailLoader.Worker.this.quit;
                                        if (z2) {
                                            return;
                                        }
                                        BLog.i(ThumbnailLoader.TAG, "onNewResultImpl: " + index + ", " + (imageDataSource != null ? Boolean.valueOf(imageDataSource.isFinished()) : null));
                                        msg.setTryTime(0);
                                        ThumbnailLoader.Worker.this.post(msg);
                                    }

                                    protected void onFailureImpl(ImageDataSource<Unit> imageDataSource) {
                                        boolean z2;
                                        ThumbnailLoader$Worker$mHandler$1 thumbnailLoader$Worker$mHandler$1;
                                        int i;
                                        ThumbnailLoader$Worker$mHandler$1 thumbnailLoader$Worker$mHandler$12;
                                        int i2;
                                        z2 = ThumbnailLoader.Worker.this.quit;
                                        if (z2) {
                                            return;
                                        }
                                        BLog.i(ThumbnailLoader.TAG, "onFailureImpl: " + index + ", " + imageDataSource);
                                        thumbnailLoader$Worker$mHandler$1 = ThumbnailLoader.Worker.this.mHandler;
                                        i = ThumbnailLoader.Worker.this.msgFetchFailed;
                                        thumbnailLoader$Worker$mHandler$1.removeMessages(i);
                                        thumbnailLoader$Worker$mHandler$12 = ThumbnailLoader.Worker.this.mHandler;
                                        i2 = ThumbnailLoader.Worker.this.msgFetchFailed;
                                        Message.obtain(thumbnailLoader$Worker$mHandler$12, i2).sendToTarget();
                                    }
                                });
                                if (msg.getTryTime() > 0) {
                                    return;
                                }
                                key = key2;
                            } else {
                                int imgXLen = info.getImgXLen();
                                int imgYLen = info.getImgYLen();
                                key = key2;
                                bmp2 = cropFromSourceImage(cache, imgXLen, imgYLen, row, col);
                            }
                        } else {
                            key = key2;
                        }
                        cacheLevel = 0 + 1;
                        bmp = bmp2;
                    } else {
                        key = key2;
                        bmp = bmp2;
                    }
                    if (bmp == null) {
                        removeMessages(this.msgFetchFailed);
                        if (this.quit) {
                            return;
                        }
                        Message.obtain(this.mHandler, this.msgFetchFailed).sendToTarget();
                        return;
                    }
                    msg.setForbidden(forbidden);
                    msg.setBitmap(bmp);
                    removeMessages(this.msgFetchFinish);
                    if (this.quit) {
                        return;
                    }
                    Message.obtain(this.mHandler, this.msgFetchFinish, msg).sendToTarget();
                    if (bmp.isRecycled() || cacheLevel <= 0) {
                        return;
                    }
                    BitmapCacheHelper.INSTANCE.saveBitmap(key, bmp);
                    return;
                }
            }
            forbidden = false;
            String str2 = "";
            if (forbidden) {
            }
            if (ThumbnailLoader.this.mIndexList == null) {
            }
            indexList = ThumbnailLoader.this.mIndexList;
            if (indexList != null) {
            }
        }

        private final Bitmap cropFromSourceImage(File cache, int xCount, int yCount, int row, int col) {
            BitmapRegionDecoder decoder;
            int thumbWidth;
            InputStream inputStream = null;
            try {
                try {
                    inputStream = new FileInputStream(cache);
                    decoder = __Ghost$Insertion$com_bilibili_lib_util_AvifBitmapRegionCheckUtil_newInstance(inputStream, true);
                    Intrinsics.checkNotNull(decoder);
                    thumbWidth = (int) ((decoder.getWidth() * 1.0f) / xCount);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
                try {
                    int thumbHeight = (int) ((decoder.getHeight() * 1.0f) / yCount);
                    try {
                        Rect rect = new Rect(col * thumbWidth, row * thumbHeight, (col + 1) * thumbWidth, (row + 1) * thumbHeight);
                        if (!decoder.isRecycled() && new Rect(0, 0, decoder.getWidth(), decoder.getHeight()).contains(rect)) {
                            Bitmap decodeRegion = decoder.decodeRegion(rect, null);
                            IOUtils.closeQuietly(inputStream);
                            return decodeRegion;
                        }
                        int i = rect.left;
                        int i2 = rect.top;
                        int i3 = rect.right;
                        BLog.e(ThumbnailLoader.TAG, "crop thumbnail rect error -> " + i + "," + i2 + "," + i3 + "," + rect.bottom);
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (Exception e) {
                        e = e;
                        BLog.e(ThumbnailLoader.TAG, "crop thumbnail error -> " + e);
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    BLog.e(ThumbnailLoader.TAG, "crop thumbnail error -> " + e);
                    IOUtils.closeQuietly(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private final String generateCacheKey(String url, int index, int row, int col) {
            ChronosThumbnailInfo thumbnailInfo = ThumbnailLoader.this.getThumbnailInfo();
            return (thumbnailInfo != null ? thumbnailInfo.getCid() : null) + "_" + DigestUtils.md5(url) + "_" + index + "_" + row + "_" + col;
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
    }

    @Override // tv.danmaku.biliplayerv2.service.ThumbnailLoader
    public void fetch(int position, int duration, boolean waitFetchRes) {
        if (this.mState == 3) {
            Worker worker = this.mWorker;
            if (worker != null) {
                worker.post(new ThumbnailMessage(position, null, waitFetchRes ? 1 : 0, false, null, 26, null));
                return;
            }
            return;
        }
        ThumbnailFetcherCallback thumbnailFetcherCallback = this.mFetcherCallback;
        if (thumbnailFetcherCallback != null) {
            thumbnailFetcherCallback.onFailed();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.ThumbnailLoader
    public void setResponseCallback(ThumbnailFetcherCallback callback) {
        this.mFetcherCallback = callback;
    }

    @Override // tv.danmaku.biliplayerv2.service.ThumbnailLoader
    public void setConfig(ThumbnailConfig config) {
        this.thumbnailConfig = config;
    }

    public final void load() {
        this.mState = 0;
        HandlerThreads.post(3, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearCache() {
        File[] cacheFiles;
        if (TextUtils.isEmpty(this.mCacheDir)) {
            return;
        }
        File file = new File(this.mCacheDir);
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

    @Override // java.lang.Runnable
    public void run() {
        final ChronosInteractContainer service;
        VideoGuide videoGuide;
        VideoViewPoint videoPoint;
        Iterable videoPointList;
        VideoGuide videoGuide2;
        VideoViewPoint videoPoint2;
        if (this.mState == 1 || (service = this.mServiceWeakRef.get()) == null) {
            return;
        }
        String cid = String.valueOf(this.playableParams.getDisplayParams().getCid());
        try {
            this.thumbnailInfo = new ChronosThumbnailInfo();
            ViewProgressDetail viewProgressDetail = service.getViewProgressDetail();
            this.videoShot = viewProgressDetail != null ? viewProgressDetail.getVideoShot() : null;
            ChronosThumbnailInfo chronosThumbnailInfo = this.thumbnailInfo;
            if (chronosThumbnailInfo != null) {
                ViewProgressDetail viewProgressDetail2 = service.getViewProgressDetail();
                chronosThumbnailInfo.setSegmentSwitchVisibility((viewProgressDetail2 == null || (videoGuide2 = viewProgressDetail2.getVideoGuide()) == null || (videoPoint2 = videoGuide2.getVideoPoint()) == null) ? false : videoPoint2.getPointPermanent());
            }
            List watchPoints = new ArrayList();
            ViewProgressDetail viewProgressDetail3 = service.getViewProgressDetail();
            if (viewProgressDetail3 != null && (videoGuide = viewProgressDetail3.getVideoGuide()) != null && (videoPoint = videoGuide.getVideoPoint()) != null && (videoPointList = videoPoint.getVideoPointList()) != null) {
                Iterable $this$forEach$iv = videoPointList;
                for (Object element$iv : $this$forEach$iv) {
                    VideoPoint it = (VideoPoint) element$iv;
                    if (it.getFrom() <= it.getTo() && it.getFrom() >= 0) {
                        ChronosThumbnailInfo.WatchPoint watchPoint = new ChronosThumbnailInfo.WatchPoint();
                        watchPoint.setVideoPoint(it);
                        watchPoints.add(watchPoint);
                    }
                }
            }
            ChronosThumbnailInfo chronosThumbnailInfo2 = this.thumbnailInfo;
            if (chronosThumbnailInfo2 != null) {
                chronosThumbnailInfo2.setWatchPoints(CollectionsKt.toList(watchPoints));
            }
            if (hasThumbnails()) {
                ChronosThumbnailInfo chronosThumbnailInfo3 = this.thumbnailInfo;
                if (chronosThumbnailInfo3 != null) {
                    chronosThumbnailInfo3.setCid(cid);
                }
                HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ThumbnailLoader.run$lambda$1(ThumbnailLoader.this);
                    }
                });
            } else {
                this.mState = 2;
                BLog.e(TAG, "not found thumbnail");
            }
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ThumbnailLoader.run$lambda$2(ThumbnailLoader.this, service);
                }
            });
        } catch (Exception e) {
            this.mState = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$1(ThumbnailLoader this$0) {
        if (this$0.mState == 1) {
            return;
        }
        this$0.mWorker = new Worker();
        Worker worker = this$0.mWorker;
        if (worker != null) {
            worker.start();
        }
        this$0.mState = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$2(ThumbnailLoader this$0, ChronosInteractContainer $service) {
        List pointsList;
        List<ChronosThumbnailInfo.WatchPoint> watchPoints;
        if (RestrictedMode.isRestrictedMode()) {
            pointsList = null;
        } else {
            ChronosThumbnailInfo chronosThumbnailInfo = this$0.thumbnailInfo;
            pointsList = (chronosThumbnailInfo == null || (watchPoints = chronosThumbnailInfo.getWatchPoints()) == null) ? null : CollectionsKt.toMutableList(watchPoints);
            this$0.sortAndIndexWatchpoints(pointsList);
        }
        ChronosThumbnailInfo chronosThumbnailInfo2 = this$0.thumbnailInfo;
        if (chronosThumbnailInfo2 != null) {
            chronosThumbnailInfo2.setWatchPoints(pointsList);
        }
        $service.notifyWatchPointsLoaded(pointsList);
    }

    private final void sortAndIndexWatchpoints(List<ChronosThumbnailInfo.WatchPoint> list) {
        if (list == null) {
            return;
        }
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$sortAndIndexWatchpoints$$inlined$sortBy$1
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchSourceImage(int index, BaseImageDataSubscriber<Unit> baseImageDataSubscriber) {
        ArrayList<String> imageList;
        String url;
        PlayerContainer playerContainer;
        Context context;
        FragmentActivity it;
        VideoShot videoShot = this.videoShot;
        if (videoShot == null || (imageList = videoShot.getImageList()) == null || (url = imageList.get(index)) == null) {
            return;
        }
        BLog.i(TAG, "fetchSourceImage: " + index + ", " + url);
        ChronosInteractContainer chronosInteractContainer = this.mServiceWeakRef.get();
        if (chronosInteractContainer != null && (playerContainer = chronosInteractContainer.getPlayerContainer()) != null && (context = playerContainer.getContext()) != null && (it = ContextUtilKt.findFragmentActivityOrNull(context)) != null) {
            if (ConfigManager.Companion.ab2().getWithDefault("ff_noavif_enable", false)) {
                BiliImageLoader.INSTANCE.acquire(it).useRaw().preload().url(url).noAvif().fetchToDiskCache().subscribe((ImageDataSubscriber) baseImageDataSubscriber);
            } else {
                BiliImageLoader.INSTANCE.acquire(it).useRaw().preload().url(url).fetchToDiskCache().subscribe((ImageDataSubscriber) baseImageDataSubscriber);
            }
        }
    }

    public final void cancel() {
        this.mState = 1;
        release();
    }

    public final void release() {
        this.thumbnailInfo = null;
        Worker worker = this.mWorker;
        if (worker != null) {
            worker.release();
        }
        this.mWorker = null;
        this.mFetcherCallback = null;
        HandlerThreads.remove(3, this);
        HandlerThreads.post(3, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ThumbnailLoader.this.clearCache();
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.ThumbnailLoader
    public boolean hasThumbnails() {
        ArrayList<String> imageList;
        VideoShot videoShot = this.videoShot;
        if ((videoShot == null || (imageList = videoShot.getImageList()) == null || !(imageList.isEmpty() ^ true)) ? false : true) {
            VideoShot videoShot2 = this.videoShot;
            if ((videoShot2 != null ? videoShot2.getImgXLen() : -1) > 0) {
                VideoShot videoShot3 = this.videoShot;
                return (videoShot3 != null ? videoShot3.getImgYLen() : -1) > 0;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream getIndexFileStream(Context context, String pvdata) throws IOException {
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
        Intrinsics.checkNotNull(cache);
        this.mCacheDir = cache.getAbsolutePath() + "/bin";
        return this.mCacheDir;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Integer> parseIndexFile(InputStream inputStream) throws IOException {
        if (inputStream == null) {
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
        BLog.d(TAG, "index: " + printIndexList(list));
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

    /* compiled from: ThumbnailLoader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader$ThumbnailMessage;", "", "seconds", "", "bitmap", "Landroid/graphics/Bitmap;", "tryTime", "forbidden", "", "content", "", "<init>", "(ILandroid/graphics/Bitmap;IZLjava/lang/String;)V", "getSeconds", "()I", "setSeconds", "(I)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getTryTime", "setTryTime", "getForbidden", "()Z", "setForbidden", "(Z)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ThumbnailMessage {
        private Bitmap bitmap;
        private String content;
        private boolean forbidden;
        private int seconds;
        private int tryTime;

        public ThumbnailMessage() {
            this(0, null, 0, false, null, 31, null);
        }

        public ThumbnailMessage(int seconds, Bitmap bitmap, int tryTime, boolean forbidden, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.seconds = seconds;
            this.bitmap = bitmap;
            this.tryTime = tryTime;
            this.forbidden = forbidden;
            this.content = content;
        }

        public /* synthetic */ ThumbnailMessage(int i, Bitmap bitmap, int i2, boolean z, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : bitmap, (i3 & 4) != 0 ? 1 : i2, (i3 & 8) == 0 ? z : false, (i3 & 16) != 0 ? "" : str);
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final String getContent() {
            return this.content;
        }

        public final boolean getForbidden() {
            return this.forbidden;
        }

        public final int getSeconds() {
            return this.seconds;
        }

        public final int getTryTime() {
            return this.tryTime;
        }

        public final void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        public final void setContent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }

        public final void setForbidden(boolean z) {
            this.forbidden = z;
        }

        public final void setSeconds(int i) {
            this.seconds = i;
        }

        public final void setTryTime(int i) {
            this.tryTime = i;
        }
    }

    /* compiled from: ThumbnailLoader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailLoader$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}