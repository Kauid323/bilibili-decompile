package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.content.Context;
import com.bilibili.droid.thread.HandlerThreads;
import java.util.Collection;
import java.util.List;

public class AsyncBlockListStorageUtils {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface AsyncBlockListStorageUtilsCallback {
        void onComplete();
    }

    public static void writeUserBlockedKeywords(final BlockedKeywords<UserKeywordItem> data, final Context context, final AsyncBlockListStorageUtilsCallback callback) {
        execute(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AsyncBlockListStorageUtils.lambda$writeUserBlockedKeywords$0(context, data, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$writeUserBlockedKeywords$0(Context context, BlockedKeywords data, AsyncBlockListStorageUtilsCallback callback) {
        BlockListStorageUtils.writeUserBlockedKeywords(context, data);
        if (callback != null) {
            callback.onComplete();
        }
    }

    public static void appendUserBlockedKeywords(final Context context, final List<UserKeywordItem> itemsToSave, final AsyncBlockListStorageUtilsCallback callback) {
        execute(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AsyncBlockListStorageUtils.lambda$appendUserBlockedKeywords$1(context, itemsToSave, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$appendUserBlockedKeywords$1(Context context, List itemsToSave, AsyncBlockListStorageUtilsCallback callback) {
        BlockListStorageUtils.appendUserBlockedKeywords(context, itemsToSave);
        if (callback != null) {
            callback.onComplete();
        }
    }

    public static void removeUserBlockedKeywords(final Context context, final Collection<UserKeywordItem> items, final AsyncBlockListStorageUtilsCallback callback) {
        execute(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AsyncBlockListStorageUtils.lambda$removeUserBlockedKeywords$2(context, items, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$removeUserBlockedKeywords$2(Context context, Collection items, AsyncBlockListStorageUtilsCallback callback) {
        BlockListStorageUtils.removeUserBlockedKeywords(context, items);
        if (callback != null) {
            callback.onComplete();
        }
    }

    public static void writeGlobalKeywords(final Context context, final GlobalBlockedKeywords data) {
        execute(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BlockListStorageUtils.writeGlobalBlockedList(context, data);
            }
        });
    }

    private static void execute(Runnable runnable) {
        HandlerThreads.getHandler(2).post(runnable);
    }
}