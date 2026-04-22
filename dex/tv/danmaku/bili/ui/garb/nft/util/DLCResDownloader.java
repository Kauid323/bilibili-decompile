package tv.danmaku.bili.ui.garb.nft.util;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.okdownloader.BiliDownloader;
import com.bilibili.lib.okdownloader.DownloadListener;
import com.bilibili.lib.okdownloader.Task;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.filechooser.FileUtils;
import tv.danmaku.bili.ui.garb.nft.model.DLCSubtitles;

/* compiled from: DLCResDownloader.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fJ.\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fJ\u001e\u0010\u0010\u001a\u00020\r2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0011j\b\u0012\u0004\u0012\u00020\n`\u0012¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/util/DLCResDownloader;", "", "<init>", "()V", "downloadRes", "", "ctx", "Landroid/content/Context;", "urls", "", "", "completeAction", "Lkotlin/Function1;", "", "downloadSingleRes", "url", "checkFilesExists", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCResDownloader {
    public static final int $stable = 0;
    public static final String RESOURCES_DIR_PATH = "/earn/animation/";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(DLCResDownloader.class).getSimpleName();
    private static final Map<String, DLCSubtitles> subtitleMap = new LinkedHashMap();
    private static final List<String> downloadingList = new ArrayList();

    /* compiled from: DLCResDownloader.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u0018\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0005J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ \u0010 \u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/util/DLCResDownloader$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "RESOURCES_DIR_PATH", "subtitleMap", "", "Ltv/danmaku/bili/ui/garb/nft/model/DLCSubtitles;", "getSubtitleMap", "()Ljava/util/Map;", "downloadingList", "", "getDownloadingList", "()Ljava/util/List;", "getFileFromAssets", "Ljava/io/File;", "context", "Landroid/content/Context;", "assetName", "getResPathByUrl", "url", "getDelayQueryParam", "", "param", "downloadJson", "", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/garb/nft/util/DLCDownlaodCallback;", "realDownload", "fileToMap", "file", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return DLCResDownloader.TAG;
        }

        public final Map<String, DLCSubtitles> getSubtitleMap() {
            return DLCResDownloader.subtitleMap;
        }

        public final List<String> getDownloadingList() {
            return DLCResDownloader.downloadingList;
        }

        public final File getFileFromAssets(Context context, String assetName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(assetName, "assetName");
            File it = new File(context.getCacheDir(), assetName);
            if (!it.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(it);
                try {
                    FileOutputStream outStream = fileOutputStream;
                    InputStream open = context.getAssets().open(assetName);
                    InputStream inStream = open;
                    Intrinsics.checkNotNull(inStream);
                    ByteStreamsKt.copyTo$default(inStream, outStream, 0, 2, (Object) null);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(open, (Throwable) null);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                } finally {
                }
            }
            return it;
        }

        public final String getResPathByUrl(String url) {
            File filesDir;
            Intrinsics.checkNotNullParameter(url, "url");
            Application application = BiliContext.application();
            String finalDir = ((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + "/earn/animation/";
            String suffix = (String) CollectionsKt.last(StringsKt.split$default(url, new String[]{FileUtils.HIDDEN_PREFIX}, false, 0, 6, (Object) null));
            String fileName = DigestUtils.md5(url) + FileUtils.HIDDEN_PREFIX + suffix;
            return finalDir + fileName;
        }

        public final int getDelayQueryParam(String url, String param) {
            Intrinsics.checkNotNullParameter(param, "param");
            try {
                String queryParameter = Uri.parse(url).getQueryParameter(param);
                int delay = queryParameter != null ? Integer.parseInt(queryParameter) : 0;
                return delay;
            } catch (Exception e) {
                return 0;
            }
        }

        public final void downloadJson(Context context, String url, DLCDownlaodCallback callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
            try {
                if (TextUtils.isEmpty(url)) {
                    return;
                }
                if (getSubtitleMap().containsKey(url)) {
                    callback.success(getSubtitleMap().get(url));
                } else if (CollectionsKt.contains(getDownloadingList(), url)) {
                } else {
                    Intrinsics.checkNotNull(url);
                    realDownload(context, url, callback);
                }
            } catch (Throwable t) {
                BLog.e(getTAG(), "downloadJson throw exception:" + t);
            }
        }

        private final void realDownload(Context context, final String url, final DLCDownlaodCallback callback) {
            File filesDir;
            Application application = BiliContext.application();
            String finalDir = ((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + "/earn/subtitle";
            BiliDownloader.Companion.get(context).create(url, "subtitles.json").fileName(StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null)).into(finalDir).rejectedWhenFileExists().retryTime(3).networkOn(3).priority(10).addListener(new DownloadListener() { // from class: tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader$Companion$realDownload$1
                public /* synthetic */ void onCancel(String str) {
                    DownloadListener.-CC.$default$onCancel(this, str);
                }

                public /* synthetic */ void onCheck(String str) {
                    DownloadListener.-CC.$default$onCheck(this, str);
                }

                public /* synthetic */ void onLoading(String str, long j, long j2, long j3, int i) {
                    DownloadListener.-CC.$default$onLoading(this, str, j, j2, j3, i);
                }

                public /* synthetic */ void onPause(String str, long j, long j2) {
                    DownloadListener.-CC.$default$onPause(this, str, j, j2);
                }

                public /* synthetic */ void onWait(String str) {
                    DownloadListener.-CC.$default$onWait(this, str);
                }

                public void onStart(String taskId) {
                    Intrinsics.checkNotNullParameter(taskId, "taskId");
                    DownloadListener.-CC.$default$onStart(this, taskId);
                }

                public void onError(String taskId, List<Integer> list, long totalSize, long loadedSize) {
                    Intrinsics.checkNotNullParameter(taskId, "taskId");
                    DownloadListener.-CC.$default$onError(this, taskId, list, totalSize, loadedSize);
                    BLog.e(DLCResDownloader.Companion.getTAG(), "download error, code " + list);
                }

                public void onFinish(String taskId, String dir, String name) {
                    Intrinsics.checkNotNullParameter(taskId, "taskId");
                    DownloadListener.-CC.$default$onFinish(this, taskId, dir, name);
                    File file = new File(dir, name);
                    DLCSubtitles res = DLCResDownloader.Companion.fileToMap(file);
                    if (res != null) {
                        DLCDownlaodCallback.this.success(res);
                        DLCResDownloader.Companion.getSubtitleMap().put(url, res);
                        return;
                    }
                    DLCDownlaodCallback.this.fail(new Exception("res parse error"));
                }

                public void onRetry(String taskId, int retryTimes) {
                    Intrinsics.checkNotNullParameter(taskId, "taskId");
                    DownloadListener.-CC.$default$onRetry(this, taskId, retryTimes);
                }
            }).build().enqueue();
        }

        /* JADX WARN: Type inference failed for: r8v0, types: [tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader$Companion$fileToMap$$inlined$parseJson$1] */
        public final DLCSubtitles fileToMap(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            DLCSubtitles dLCSubtitles = null;
            if (!file.canRead()) {
                BLog.e(getTAG(), "downloadJson json to memory file cannot read");
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            FileInputStream stream = null;
            BufferedReader bufferedReader = null;
            try {
                try {
                    stream = new FileInputStream(file);
                    bufferedReader = new BufferedReader(new InputStreamReader(stream));
                    while (true) {
                        String it = bufferedReader.readLine();
                        if (it == null) {
                            break;
                        }
                        stringBuffer.append(it);
                    }
                    String jsonString = stringBuffer.toString();
                    Intrinsics.checkNotNullExpressionValue(jsonString, "toString(...)");
                    if (!TextUtils.isEmpty(jsonString)) {
                        Type type = new TypeToken<DLCSubtitles>() { // from class: tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader$Companion$fileToMap$$inlined$parseJson$1
                        }.getType();
                        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                        dLCSubtitles = (DLCSubtitles) JsonUtilKt.parseJson(jsonString, type);
                    }
                } catch (Exception e) {
                    BLog.e(getTAG(), "downloadJson json to memory error");
                }
                return dLCSubtitles;
            } finally {
                IOUtils.closeQuietly(bufferedReader);
                IOUtils.closeQuietly(stream);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void downloadRes$default(DLCResDownloader dLCResDownloader, Context context, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        dLCResDownloader.downloadRes(context, list, function1);
    }

    public final void downloadRes(Context ctx, List<String> list, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(list, "urls");
        List<String> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            downloadSingleRes(ctx, it, function1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void downloadSingleRes$default(DLCResDownloader dLCResDownloader, Context context, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        dLCResDownloader.downloadSingleRes(context, str, function1);
    }

    public final void downloadSingleRes(Context ctx, final String url, final Function1<? super Boolean, Unit> function1) {
        File filesDir;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(url, "url");
        Application application = BiliContext.application();
        String finalDir = ((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + "/earn/animation/";
        String suffix = (String) CollectionsKt.last(StringsKt.split$default(url, new String[]{FileUtils.HIDDEN_PREFIX}, false, 0, 6, (Object) null));
        String fileName = DigestUtils.md5(url) + FileUtils.HIDDEN_PREFIX + suffix;
        final Ref.LongRef startTime = new Ref.LongRef();
        final Ref.LongRef endTime = new Ref.LongRef();
        Task task = BiliDownloader.Companion.get(ctx).create(url, "dlc").into(finalDir).fileName(fileName).rejectedWhenFileExists().retryTime(3).networkOn(3).priority(10).addListener(new DownloadListener() { // from class: tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader$downloadSingleRes$task$1
            public /* synthetic */ void onCancel(String str) {
                DownloadListener.-CC.$default$onCancel(this, str);
            }

            public /* synthetic */ void onCheck(String str) {
                DownloadListener.-CC.$default$onCheck(this, str);
            }

            public /* synthetic */ void onLoading(String str, long j, long j2, long j3, int i) {
                DownloadListener.-CC.$default$onLoading(this, str, j, j2, j3, i);
            }

            public /* synthetic */ void onPause(String str, long j, long j2) {
                DownloadListener.-CC.$default$onPause(this, str, j, j2);
            }

            public /* synthetic */ void onWait(String str) {
                DownloadListener.-CC.$default$onWait(this, str);
            }

            public void onStart(String taskId) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onStart(this, taskId);
                BLog.d(DLCResDownloader.Companion.getTAG(), "downloadResource start url:" + url);
                startTime.element = System.currentTimeMillis();
            }

            public void onError(String taskId, List<Integer> list, long totalSize, long loadedSize) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onError(this, taskId, list, totalSize, loadedSize);
                Function1<Boolean, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(false);
                }
                BLog.e(DLCResDownloader.Companion.getTAG(), "download error, code " + list);
            }

            public void onFinish(String taskId, String dir, String name) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onFinish(this, taskId, dir, name);
                Function1<Boolean, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(true);
                }
                endTime.element = System.currentTimeMillis();
                String tag = DLCResDownloader.Companion.getTAG();
                long j = endTime.element - startTime.element;
                BLog.i(tag, "download success cost time " + j + "ms url:" + url + " path:" + dir + "/" + name);
            }

            public void onRetry(String taskId, int retryTimes) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onRetry(this, taskId, retryTimes);
                BLog.d(DLCResDownloader.Companion.getTAG(), "downloadResource retry url:" + url + " retryTime:" + retryTimes);
            }
        }).build();
        startTime.element = System.currentTimeMillis();
        task.enqueue();
    }

    public final boolean checkFilesExists(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "urls");
        ArrayList<String> $this$all$iv = arrayList;
        if (($this$all$iv instanceof Collection) && $this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            String it = (String) element$iv;
            if (!new File(Companion.getResPathByUrl(it)).exists()) {
                return false;
            }
        }
        return true;
    }
}