package tv.danmaku.bili.services.videodownload.utils;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.documentfile.provider.DocumentFile;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.StringUtil;
import com.bilibili.videodownloader.db.DownloadDatabase;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.utils.DBUtilsKt;
import com.bilibili.videodownloader.utils.Jsonable;
import com.bilibili.videodownloader.utils.log.LogHelper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;

/* compiled from: DocumentTransfer.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J&\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0002J$\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#J2\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020\fH\u0002J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0007H\u0002J1\u0010-\u001a\u0004\u0018\u0001H.\"\n\b\u0000\u0010.*\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010!2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00¢\u0006\u0002\u00101J\u001a\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0007H\u0002J%\u00104\u001a\b\u0012\u0004\u0012\u00020+0**\b\u0012\u0004\u0012\u00020\n052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u00106¨\u00067"}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/DocumentTransfer;", "Ltv/danmaku/bili/services/videodownload/utils/DownloadTransfer;", "<init>", "()V", "transfer", "", "src", "Landroid/net/Uri;", "deleteDirectory", "dir", "Landroidx/documentfile/provider/DocumentFile;", "preCopyCheck", "", "from", "cacheRoot", "to", "insertToDb", LoginActivityV2.LOGIN_ENTRY_KEY, "Lcom/bilibili/videodownloader/utils/Jsonable;", "root", "child", "checkAimParent", "privateDownloadDir", "getAimDir", "copyDir", "ctx", "Landroid/content/Context;", "fromFile", "aimFile", "copyFile", "aim", "copy", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "getChild", "displayName", "", "create", "isDir", "findDownloadItems", "", "Ltv/danmaku/bili/services/videodownload/utils/DocumentTransferItem;", "finalUri", "readFromJsonableFile", "T", "clazz", "Ljava/lang/Class;", "(Ljava/io/InputStream;Ljava/lang/Class;)Lcom/bilibili/videodownloader/utils/Jsonable;", "checkSelectedFile", AudioIntentHelper.ARGS_URI, "filerDownloadCacheDir", "", "([Landroidx/documentfile/provider/DocumentFile;Landroid/content/Context;)Ljava/util/List;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DocumentTransfer extends DownloadTransfer {
    public static final DocumentTransfer INSTANCE = new DocumentTransfer();
    public static final int $stable = 8;

    private DocumentTransfer() {
    }

    @Override // tv.danmaku.bili.services.videodownload.utils.DownloadTransfer
    public void transfer(final Uri src) {
        Intrinsics.checkNotNullParameter(src, "src");
        if (isProcessing()) {
            return;
        }
        setProcessing(true);
        final Application app = getApplication();
        if (app == null) {
            return;
        }
        final long startTime = System.currentTimeMillis();
        log("try to transfer " + src);
        getPauseDownloadObservable(app).map(new Function() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$transfer$1
            public final Uri apply(Boolean it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return src;
            }
        }).observeOn(Schedulers.io()).map(new Function() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$transfer$2
            public final List<DocumentTransferItem> apply(Uri uri) {
                Uri finalUri;
                List items;
                Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
                finalUri = DocumentTransfer.INSTANCE.checkSelectedFile(app, uri);
                if (finalUri == null) {
                    return null;
                }
                items = DocumentTransfer.INSTANCE.findDownloadItems(app, finalUri);
                DocumentTransfer.INSTANCE.log("find " + items.size() + " entry");
                return items;
            }
        }).observeOn(Schedulers.io()).map(new DocumentTransfer$transfer$3(app)).observeOn(AndroidSchedulers.mainThread()).flatMap(new Function() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$transfer$4
            public final ObservableSource<? extends Boolean> apply(Boolean it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return DocumentTransfer.INSTANCE.getForceLoadObservable(app, it.booleanValue());
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$transfer$5
            public final void accept(Boolean it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.booleanValue()) {
                    DownloadTaskTransfer.recordTransfered(app);
                    DocumentTransfer.INSTANCE.trackSuccess(System.currentTimeMillis() - startTime, DocumentTransfer.INSTANCE.getEntryCount());
                    DocumentTransfer.INSTANCE.log("transfer success");
                    TransferListener listener = DocumentTransfer.INSTANCE.getListener();
                    if (listener != null) {
                        listener.onSuccess();
                    }
                } else {
                    DocumentTransfer.INSTANCE.log("transfer fail");
                    DocumentTransfer.INSTANCE.trackFail("");
                    TransferListener listener2 = DocumentTransfer.INSTANCE.getListener();
                    if (listener2 != null) {
                        listener2.onFail(null);
                    }
                }
                DocumentTransfer.INSTANCE.setProcessing(false);
            }
        }, new Consumer() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$transfer$6
            public final void accept(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Throwable $this$accept_u24lambda_u240 = it.getCause();
                if ($this$accept_u24lambda_u240 != null) {
                    BLog.e(DocumentTransfer.INSTANCE.getTag(), $this$accept_u24lambda_u240);
                }
                DocumentTransfer documentTransfer = DocumentTransfer.INSTANCE;
                Throwable cause = it.getCause();
                documentTransfer.trackFail(cause != null ? cause.getMessage() : null);
                TransferListener listener = DocumentTransfer.INSTANCE.getListener();
                if (listener != null) {
                    listener.onFail(it.getCause());
                }
                DocumentTransfer.INSTANCE.setProcessing(false);
            }
        }, new Action() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$$ExternalSyntheticLambda0
            public final void run() {
                DocumentTransfer.transfer$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transfer$lambda$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteDirectory(DocumentFile dir) {
        if (dir != null) {
            try {
                if (dir.isDirectory()) {
                    DocumentFile[] files = dir.listFiles();
                    Intrinsics.checkNotNullExpressionValue(files, "listFiles(...)");
                    if (!(files.length == 0)) {
                        for (DocumentFile file : files) {
                            if (file.isDirectory()) {
                                deleteDirectory(file);
                            } else {
                                file.delete();
                            }
                        }
                    }
                    dir.delete();
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean preCopyCheck(DocumentFile from, DocumentFile cacheRoot, DocumentFile to) {
        return from != null && cacheRoot != null && to != null && from.canRead() && from.canWrite() && cacheRoot.canRead() && cacheRoot.canWrite() && to.canRead() && to.canWrite() && StringUtil.isNotBlank(from.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertToDb(Jsonable entry, DocumentFile root, DocumentFile child) {
        VideoDownloadEntry downloadEntry;
        Application app = BiliContext.application();
        if (app == null) {
            return;
        }
        if (entry instanceof VideoDownloadAVPageEntry) {
            downloadEntry = (VideoDownloadEntry) entry;
        } else {
            downloadEntry = entry instanceof VideoDownloadSeasonEpEntry ? (VideoDownloadEntry) entry : null;
        }
        if (downloadEntry == null) {
            return;
        }
        DownloadDatabase.Companion.get(app).downloadDao().insertOrUpdate(DBUtilsKt.toDownloadEntry(String.valueOf(root != null ? root.getUri() : null), String.valueOf(child != null ? child.getUri() : null), downloadEntry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DocumentFile checkAimParent(DocumentFile root, DocumentFile child, DocumentFile privateDownloadDir) {
        String fromParentName;
        String multiPDirName;
        if (root == null || child == null || (fromParentName = root.getName()) == null) {
            return null;
        }
        DocumentFile avDir = privateDownloadDir.findFile(fromParentName);
        if (avDir == null) {
            avDir = privateDownloadDir.createDirectory(fromParentName);
        }
        if (avDir == null || (multiPDirName = child.getName()) == null) {
            return null;
        }
        DocumentFile multiPDir = avDir.findFile(fromParentName);
        boolean z = false;
        if (multiPDir != null && multiPDir.isDirectory()) {
            z = true;
        }
        if (z) {
            multiPDir.delete();
        }
        return avDir.createDirectory(multiPDirName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DocumentFile getAimDir() {
        File driFile;
        File dir = VideoDownloadStorageStrategy.getSecondaryDirectoryFile(getApplication());
        if (dir == null) {
            dir = VideoDownloadStorageStrategy.getPrimaryDirectoryFile(getApplication());
        }
        if (dir != null) {
            driFile = dir;
        } else {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            Application application = getApplication();
            driFile = new File(externalStorageDirectory, "Android/data/" + (application != null ? application.getPackageName() : null) + "/download");
        }
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        DocumentFile fromFile = DocumentFile.fromFile(driFile);
        Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(...)");
        return fromFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyDir(Context ctx, DocumentFile fromFile, DocumentFile aimFile) {
        if (fromFile == null || aimFile == null || !fromFile.isDirectory() || !fromFile.isDirectory()) {
            return;
        }
        Object[] listFiles = fromFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles(...)");
        Object[] $this$forEach$iv = listFiles;
        for (Object element$iv : $this$forEach$iv) {
            DocumentFile it = (DocumentFile) element$iv;
            if (it.isDirectory()) {
                DocumentFile nextChild = INSTANCE.getChild(aimFile, it.getName(), true, true);
                INSTANCE.copyDir(ctx, it, nextChild);
            } else {
                DocumentFile aim = INSTANCE.getChild(aimFile, it.getName(), true, false);
                INSTANCE.copyFile(ctx, it, aim);
            }
        }
    }

    private final void copyFile(Context ctx, DocumentFile src, DocumentFile aim) {
        if (src == null || aim == null) {
            return;
        }
        ContentResolver contentResolver = ctx.getContentResolver();
        InputStream input = contentResolver.openInputStream(src.getUri());
        OutputStream output = contentResolver.openOutputStream(aim.getUri());
        copy(input, output);
    }

    public final void copy(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return;
        }
        try {
            byte[] buffer = new byte[4096];
            while (true) {
                int it = inputStream.read(buffer);
                if (it >= 0) {
                    outputStream.write(buffer, 0, it);
                } else {
                    return;
                }
            }
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    static /* synthetic */ DocumentFile getChild$default(DocumentTransfer documentTransfer, DocumentFile documentFile, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return documentTransfer.getChild(documentFile, str, z, z2);
    }

    private final DocumentFile getChild(DocumentFile src, String displayName, boolean create, boolean isDir) {
        DocumentFile child;
        if (src == null || displayName == null) {
            return null;
        }
        DocumentFile child2 = src.findFile(displayName);
        if (child2 == null && create) {
            if (isDir) {
                child = src.createDirectory(displayName);
            } else {
                child = src.createFile("*/*", displayName);
            }
            return child;
        }
        return child2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DocumentTransferItem> findDownloadItems(Context ctx, Uri finalUri) {
        DocumentFile rootFile = DocumentFile.fromTreeUri(ctx, finalUri);
        if (rootFile == null) {
            return new ArrayList();
        }
        DocumentFile[] listFiles = rootFile.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles(...)");
        return filerDownloadCacheDir(listFiles, ctx);
    }

    public final <T extends Jsonable> T readFromJsonableFile(InputStream inputStream, Class<T> cls) throws IOException, JSONException {
        String text;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        T t = null;
        try {
            try {
                text = IOUtils.toString(inputStream, "UTF-8");
            } catch (IllegalAccessException e) {
                LogHelper.printStackTrace(e);
            } catch (InstantiationException e2) {
                LogHelper.printStackTrace(e2);
            }
            if (TextUtils.isEmpty(text)) {
                throw new JSONException("null json text");
            }
            JSONObject object = new JSONObject(text);
            if (object.length() == 0) {
                throw new JSONException("invalid json");
            }
            t = cls.newInstance();
            if (t != null) {
                t.fromJsonObject(object);
            }
            return t;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri checkSelectedFile(Context ctx, Uri uri) {
        DocumentFile result;
        Uri uri2;
        DocumentFile selected = DocumentFile.fromTreeUri(ctx, uri);
        if (selected == null) {
            return uri;
        }
        String packageName = ctx.getPackageName();
        if (Intrinsics.areEqual(selected.getName(), packageName)) {
            result = selected.findFile("download");
        } else {
            DocumentFile findFile = selected.findFile(packageName);
            result = findFile != null ? findFile.findFile("download") : null;
        }
        return (result == null || (uri2 = result.getUri()) == null) ? uri : uri2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x006e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private final java.util.List<tv.danmaku.bili.services.videodownload.utils.DocumentTransferItem> filerDownloadCacheDir(androidx.documentfile.provider.DocumentFile[] r27, android.content.Context r28) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer.filerDownloadCacheDir(androidx.documentfile.provider.DocumentFile[], android.content.Context):java.util.List");
    }
}