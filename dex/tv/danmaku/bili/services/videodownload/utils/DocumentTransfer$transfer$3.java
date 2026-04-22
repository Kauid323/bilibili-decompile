package tv.danmaku.bili.services.videodownload.utils;

import android.app.Application;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.bilibili.base.MainThread;
import io.reactivex.rxjava3.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: DocumentTransfer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class DocumentTransfer$transfer$3<T, R> implements Function {
    final /* synthetic */ Application $app;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentTransfer$transfer$3(Application application) {
        this.$app = application;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0104 A[Catch: all -> 0x0155, TryCatch #0 {all -> 0x0155, blocks: (B:29:0x00d7, B:31:0x00ef, B:33:0x00f5, B:43:0x0104, B:44:0x0109), top: B:62:0x00d7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean apply(List<DocumentTransferItem> list) {
        DocumentFile privateDownloadDir;
        DocumentFile to;
        boolean checkResult;
        int $i$f$forEachIndexed;
        Uri uri;
        Iterator<T> it;
        Uri uri2;
        boolean z;
        boolean z2;
        DocumentFile[] listFiles;
        List<DocumentTransferItem> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            privateDownloadDir = DocumentTransfer.INSTANCE.getAimDir();
            DocumentTransfer.INSTANCE.setEntryCount(list.size());
            List<DocumentTransferItem> $this$forEachIndexed$iv = list;
            Application application = this.$app;
            int $i$f$forEachIndexed2 = 0;
            int index$iv = 0;
            Iterator<T> it2 = $this$forEachIndexed$iv.iterator();
            while (it2.hasNext()) {
                Object item$iv = it2.next();
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DocumentTransferItem documentTransferItem = (DocumentTransferItem) item$iv;
                Application application2 = application;
                DocumentFile from = DocumentFile.fromTreeUri(application2, documentTransferItem.getMultiPUri());
                DocumentFile cacheRoot = DocumentFile.fromTreeUri(application2, documentTransferItem.getCacheRoot());
                to = DocumentTransfer.INSTANCE.checkAimParent(cacheRoot, from, privateDownloadDir);
                checkResult = DocumentTransfer.INSTANCE.preCopyCheck(from, cacheRoot, to);
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                DocumentTransfer documentTransfer = DocumentTransfer.INSTANCE;
                Uri uri3 = from != null ? from.getUri() : null;
                if (cacheRoot != null) {
                    $i$f$forEachIndexed = $i$f$forEachIndexed2;
                    uri = cacheRoot.getUri();
                } else {
                    $i$f$forEachIndexed = $i$f$forEachIndexed2;
                    uri = null;
                }
                if (to != null) {
                    it = it2;
                    uri2 = to.getUri();
                } else {
                    it = it2;
                    uri2 = null;
                }
                documentTransfer.log("current transfer \n from > " + uri3 + "; \n cacheRoot > " + uri + "; \nto > " + uri2 + "; \n checkResult > " + checkResult);
                if (checkResult) {
                    try {
                        DocumentTransfer.INSTANCE.copyDir(application, from, to);
                        DocumentTransfer.INSTANCE.insertToDb(documentTransferItem.getEntry(), privateDownloadDir, to);
                        DocumentTransfer.INSTANCE.deleteDirectory(from);
                        if (cacheRoot == null || (listFiles = cacheRoot.listFiles()) == null) {
                            z = true;
                        } else {
                            z = true;
                            if (listFiles.length == 0) {
                                z2 = true;
                                if (z2) {
                                    DocumentTransfer.INSTANCE.deleteDirectory(cacheRoot);
                                }
                                DocumentTransfer.INSTANCE.setCurrntIndex(index$iv + 1);
                                DocumentTransfer.INSTANCE.log("progress > " + DocumentTransfer.INSTANCE.getEntryCount() + ", " + DocumentTransfer.INSTANCE.getCurrntIndex());
                                MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$transfer$3$$ExternalSyntheticLambda0
                                    public final Object invoke() {
                                        Unit apply$lambda$0$0;
                                        apply$lambda$0$0 = DocumentTransfer$transfer$3.apply$lambda$0$0();
                                        return apply$lambda$0$0;
                                    }
                                });
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                $i$f$forEachIndexed2 = $i$f$forEachIndexed;
                                it2 = it;
                                index$iv = index$iv2;
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        DocumentTransfer.INSTANCE.setCurrntIndex(index$iv + 1);
                        DocumentTransfer.INSTANCE.log("progress > " + DocumentTransfer.INSTANCE.getEntryCount() + ", " + DocumentTransfer.INSTANCE.getCurrntIndex());
                        MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.bili.services.videodownload.utils.DocumentTransfer$transfer$3$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit apply$lambda$0$0;
                                apply$lambda$0$0 = DocumentTransfer$transfer$3.apply$lambda$0$0();
                                return apply$lambda$0$0;
                            }
                        });
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
                        it2 = it;
                        index$iv = index$iv2;
                    } catch (Throwable t) {
                        BLog.e(DocumentTransfer.INSTANCE.getTag(), t);
                        throw t;
                    }
                } else {
                    throw new IllegalStateException("pre check fail, from > " + (from != null ? from.getUri() : null) + ", to > " + (to != null ? to.getUri() : null) + ", root > " + (cacheRoot != null ? cacheRoot.getUri() : null) + " ");
                }
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit apply$lambda$0$0() {
        TransferListener listener = DocumentTransfer.INSTANCE.getListener();
        if (listener != null) {
            listener.onProgress(DocumentTransfer.INSTANCE.getEntryCount(), DocumentTransfer.INSTANCE.getCurrntIndex());
        }
        return Unit.INSTANCE;
    }
}