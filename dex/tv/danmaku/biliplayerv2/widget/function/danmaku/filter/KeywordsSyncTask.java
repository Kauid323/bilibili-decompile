package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.content.Context;
import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.api.BiliApiException;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.BiliApiParseException;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils;

public class KeywordsSyncTask {
    public static final int FROM_STARTUP = 1;
    public static final int FROM_USER_SYNC = 3;
    public static final int FROM_VIDEO_PRELOAD = 2;
    private static final String TAG = "KeywordsSyncTask";
    private KeywordsBlockApiService mApiService;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface KeywordAddCallback {
        void onFailed(int i, String str, UserKeywordItem userKeywordItem);

        void onKeywordAddedToLocal(UserKeywordItem userKeywordItem);

        void onSuccess(UserKeywordItem userKeywordItem);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface KeywordsAddCallback extends KeywordAddCallback {
        void onKeywordAddFinish(int i, int i2);

        void onKeywordsAddedToLocal();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface KeywordsRemoveCallback {
        void onKeywordsRemoved(boolean z);

        void onKeywordsRemovedFromLocal();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface KeywordsSyncCallback {
        void onSyncAfterWriteDataSuccess();

        void onSyncKeywords(boolean z, BlockedKeywords<UserKeywordItem> blockedKeywords);
    }

    public void preloadDanmakuBlockList(Context context) {
        final Context appContext = context.getApplicationContext();
        Runnable r = new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (BlockListStorageUtils.isUserKeywordsExpired(appContext)) {
                    KeywordsSyncTask.this.readUserBlockedKeywordsFromRemote(appContext, null, 2);
                }
            }
        };
        execute(r);
    }

    public void readGlobalBlockedKeywordsFromRemote(Context context, final int from) {
        final Context appContext = context.getApplicationContext();
        Runnable r = new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (BlockListStorageUtils.isGlobalBlockListExpired(appContext)) {
                    long ver = BlockListStorageUtils.getGlobalBlockListVersion(appContext);
                    KeywordsSyncTask.this.readGlobalBlockedKeywordsFromRemote(appContext, ver, from);
                }
            }
        };
        execute(r);
    }

    public void readGlobalBlockedKeywordsFromRemote(Context context, long localVersion, int from) {
    }

    public void readUserBlockedKeywordsFromRemote(Context context, final KeywordsSyncCallback callback, int from) {
        if (context == null) {
            return;
        }
        final Context appContext = context.getApplicationContext();
        if (this.mApiService == null) {
            this.mApiService = createApiService();
        }
        BiliCall<GeneralResponse<BlockedKeywords<UserKeywordItem>>> call = this.mApiService.getBlockedData(getAccessKey(appContext));
        call.enqueue(new BiliApiDataCallback<BlockedKeywords<UserKeywordItem>>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.3
            public void onDataSuccess(BlockedKeywords<UserKeywordItem> data) {
                if (callback != null) {
                    callback.onSyncKeywords(true, data);
                }
                AsyncBlockListStorageUtils.writeUserBlockedKeywords(data, appContext, new AsyncBlockListStorageUtils.AsyncBlockListStorageUtilsCallback() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.3.1
                    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils.AsyncBlockListStorageUtilsCallback
                    public void onComplete() {
                        if (callback != null) {
                            callback.onSyncAfterWriteDataSuccess();
                        }
                    }
                });
            }

            public void onError(Throwable t) {
                if (callback != null) {
                    BlockedKeywords<UserKeywordItem> data = new BlockedKeywords<>();
                    if (t instanceof BiliApiException) {
                        String exceptionMessage = t.getMessage();
                        data.mToast = exceptionMessage;
                        callback.onSyncKeywords(false, data);
                        return;
                    }
                    data.mToast = String.valueOf(R.string.playerbaseres_global_string_659);
                    callback.onSyncKeywords(false, data);
                }
            }
        });
    }

    public void appendKeywords(Context context, final List<UserKeywordItem> items, final KeywordsAddCallback callback) {
        if (context == null || items == null || items.isEmpty()) {
            return;
        }
        final Context appContext = context.getApplicationContext();
        long mid = BiliAccounts.get(appContext).mid();
        if (mid < 0) {
            return;
        }
        Runnable r = new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4
            /* JADX WARN: Incorrect condition in loop: B:7:0x0035 */
            /* JADX WARN: Removed duplicated region for block: B:63:0x0105  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x011c  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean noEnoughSpace;
                boolean itemAlreadyExist;
                boolean itemAddSuccess;
                String noEnoughSpaceMsg;
                String msg;
                int code;
                boolean z;
                boolean noEnoughSpace2;
                boolean noEnoughSpace3;
                boolean itemAddSuccess2;
                boolean itemAlreadyExist2;
                if (KeywordsSyncTask.this.mApiService == null) {
                    KeywordsSyncTask.this.mApiService = KeywordsSyncTask.this.createApiService();
                }
                final int[] successCount = {0};
                final int[] failedCount = {0};
                ArrayList<UserKeywordItem> itemsToSave = new ArrayList<>();
                Iterator it = items.iterator();
                String noEnoughSpaceMsg2 = "";
                boolean noEnoughSpaceMsg3 = false;
                while (noEnoughSpace) {
                    final UserKeywordItem item = (UserKeywordItem) it.next();
                    boolean itemAddSuccess3 = false;
                    boolean itemAlreadyExist3 = false;
                    String msg2 = "";
                    int code2 = -1;
                    if (!noEnoughSpaceMsg3) {
                        BiliCall<GeneralResponse<String>> call = KeywordsSyncTask.this.mApiService.add(KeywordsSyncTask.this.getAccessKey(appContext), item.type, item.data);
                        try {
                            GeneralResponse<String> response = (GeneralResponse) call.execute().body();
                            if (response == null) {
                                boolean noEnoughSpace4 = noEnoughSpaceMsg3;
                                itemAddSuccess2 = noEnoughSpace4;
                            } else if (response.isSuccess()) {
                                JSONObject res = new JSONObject((String) response.data);
                                noEnoughSpace2 = noEnoughSpaceMsg3;
                                try {
                                    int newId = res.optInt("id", -1);
                                    if (newId == -1) {
                                        itemAlreadyExist2 = false;
                                    } else {
                                        noEnoughSpace3 = false;
                                        itemAlreadyExist2 = false;
                                        try {
                                            item.id = newId;
                                            itemAddSuccess3 = true;
                                        } catch (BiliApiParseException | IOException | JSONException e) {
                                            itemAlreadyExist3 = false;
                                            itemAddSuccess3 = noEnoughSpace3;
                                            itemAddSuccess2 = noEnoughSpace2;
                                            noEnoughSpace = itemAddSuccess2;
                                            noEnoughSpaceMsg = noEnoughSpaceMsg2;
                                            itemAddSuccess = itemAddSuccess3;
                                            itemAlreadyExist = itemAlreadyExist3;
                                            msg = msg2;
                                            code = code2;
                                            if (!itemAlreadyExist) {
                                            }
                                            final boolean success = itemAddSuccess;
                                            final String errMsg = msg;
                                            final int errCode = code;
                                            KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    if (callback != null) {
                                                        if (success) {
                                                            callback.onSuccess(item);
                                                        } else {
                                                            callback.onFailed(errCode, errMsg, item);
                                                        }
                                                    }
                                                }
                                            });
                                            noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                                            noEnoughSpaceMsg3 = noEnoughSpace;
                                        }
                                    }
                                    itemAddSuccess2 = noEnoughSpace2;
                                    itemAlreadyExist3 = itemAlreadyExist2;
                                } catch (BiliApiParseException e2) {
                                    noEnoughSpace3 = false;
                                    itemAddSuccess3 = noEnoughSpace3;
                                    itemAddSuccess2 = noEnoughSpace2;
                                    noEnoughSpace = itemAddSuccess2;
                                    noEnoughSpaceMsg = noEnoughSpaceMsg2;
                                    itemAddSuccess = itemAddSuccess3;
                                    itemAlreadyExist = itemAlreadyExist3;
                                    msg = msg2;
                                    code = code2;
                                    if (!itemAlreadyExist) {
                                    }
                                    final boolean success2 = itemAddSuccess;
                                    final String errMsg2 = msg;
                                    final int errCode2 = code;
                                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (callback != null) {
                                                if (success2) {
                                                    callback.onSuccess(item);
                                                } else {
                                                    callback.onFailed(errCode2, errMsg2, item);
                                                }
                                            }
                                        }
                                    });
                                    noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                                    noEnoughSpaceMsg3 = noEnoughSpace;
                                } catch (IOException e3) {
                                    noEnoughSpace3 = false;
                                    itemAddSuccess3 = noEnoughSpace3;
                                    itemAddSuccess2 = noEnoughSpace2;
                                    noEnoughSpace = itemAddSuccess2;
                                    noEnoughSpaceMsg = noEnoughSpaceMsg2;
                                    itemAddSuccess = itemAddSuccess3;
                                    itemAlreadyExist = itemAlreadyExist3;
                                    msg = msg2;
                                    code = code2;
                                    if (!itemAlreadyExist) {
                                    }
                                    final boolean success22 = itemAddSuccess;
                                    final String errMsg22 = msg;
                                    final int errCode22 = code;
                                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (callback != null) {
                                                if (success22) {
                                                    callback.onSuccess(item);
                                                } else {
                                                    callback.onFailed(errCode22, errMsg22, item);
                                                }
                                            }
                                        }
                                    });
                                    noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                                    noEnoughSpaceMsg3 = noEnoughSpace;
                                } catch (JSONException e4) {
                                    noEnoughSpace3 = false;
                                    itemAddSuccess3 = noEnoughSpace3;
                                    itemAddSuccess2 = noEnoughSpace2;
                                    noEnoughSpace = itemAddSuccess2;
                                    noEnoughSpaceMsg = noEnoughSpaceMsg2;
                                    itemAddSuccess = itemAddSuccess3;
                                    itemAlreadyExist = itemAlreadyExist3;
                                    msg = msg2;
                                    code = code2;
                                    if (!itemAlreadyExist) {
                                    }
                                    final boolean success222 = itemAddSuccess;
                                    final String errMsg222 = msg;
                                    final int errCode222 = code;
                                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (callback != null) {
                                                if (success222) {
                                                    callback.onSuccess(item);
                                                } else {
                                                    callback.onFailed(errCode222, errMsg222, item);
                                                }
                                            }
                                        }
                                    });
                                    noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                                    noEnoughSpaceMsg3 = noEnoughSpace;
                                }
                            } else {
                                noEnoughSpace2 = noEnoughSpaceMsg3;
                                noEnoughSpace3 = false;
                                code2 = response.code;
                                if (response.code != 36005) {
                                    itemAlreadyExist3 = false;
                                } else {
                                    itemAlreadyExist3 = true;
                                }
                                try {
                                    msg2 = KeywordsSyncMsgInterceptor.onIntercept(appContext, response.code, response.message);
                                    if (response.code != 36003) {
                                        itemAddSuccess3 = false;
                                        itemAddSuccess2 = noEnoughSpace2;
                                    } else {
                                        noEnoughSpaceMsg2 = msg2;
                                        itemAddSuccess3 = false;
                                        itemAddSuccess2 = true;
                                    }
                                } catch (IOException e5) {
                                    itemAddSuccess3 = noEnoughSpace3;
                                    itemAddSuccess2 = noEnoughSpace2;
                                    noEnoughSpace = itemAddSuccess2;
                                    noEnoughSpaceMsg = noEnoughSpaceMsg2;
                                    itemAddSuccess = itemAddSuccess3;
                                    itemAlreadyExist = itemAlreadyExist3;
                                    msg = msg2;
                                    code = code2;
                                    if (!itemAlreadyExist) {
                                    }
                                    final boolean success2222 = itemAddSuccess;
                                    final String errMsg2222 = msg;
                                    final int errCode2222 = code;
                                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (callback != null) {
                                                if (success2222) {
                                                    callback.onSuccess(item);
                                                } else {
                                                    callback.onFailed(errCode2222, errMsg2222, item);
                                                }
                                            }
                                        }
                                    });
                                    noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                                    noEnoughSpaceMsg3 = noEnoughSpace;
                                } catch (JSONException e6) {
                                    itemAddSuccess3 = noEnoughSpace3;
                                    itemAddSuccess2 = noEnoughSpace2;
                                    noEnoughSpace = itemAddSuccess2;
                                    noEnoughSpaceMsg = noEnoughSpaceMsg2;
                                    itemAddSuccess = itemAddSuccess3;
                                    itemAlreadyExist = itemAlreadyExist3;
                                    msg = msg2;
                                    code = code2;
                                    if (!itemAlreadyExist) {
                                    }
                                    final boolean success22222 = itemAddSuccess;
                                    final String errMsg22222 = msg;
                                    final int errCode22222 = code;
                                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (callback != null) {
                                                if (success22222) {
                                                    callback.onSuccess(item);
                                                } else {
                                                    callback.onFailed(errCode22222, errMsg22222, item);
                                                }
                                            }
                                        }
                                    });
                                    noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                                    noEnoughSpaceMsg3 = noEnoughSpace;
                                } catch (BiliApiParseException e7) {
                                    itemAddSuccess3 = noEnoughSpace3;
                                    itemAddSuccess2 = noEnoughSpace2;
                                    noEnoughSpace = itemAddSuccess2;
                                    noEnoughSpaceMsg = noEnoughSpaceMsg2;
                                    itemAddSuccess = itemAddSuccess3;
                                    itemAlreadyExist = itemAlreadyExist3;
                                    msg = msg2;
                                    code = code2;
                                    if (!itemAlreadyExist) {
                                    }
                                    final boolean success222222 = itemAddSuccess;
                                    final String errMsg222222 = msg;
                                    final int errCode222222 = code;
                                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (callback != null) {
                                                if (success222222) {
                                                    callback.onSuccess(item);
                                                } else {
                                                    callback.onFailed(errCode222222, errMsg222222, item);
                                                }
                                            }
                                        }
                                    });
                                    noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                                    noEnoughSpaceMsg3 = noEnoughSpace;
                                }
                            }
                        } catch (BiliApiParseException | IOException | JSONException e8) {
                            noEnoughSpace2 = noEnoughSpaceMsg3;
                            noEnoughSpace3 = false;
                        }
                        noEnoughSpace = itemAddSuccess2;
                        noEnoughSpaceMsg = noEnoughSpaceMsg2;
                        itemAddSuccess = itemAddSuccess3;
                        itemAlreadyExist = itemAlreadyExist3;
                        msg = msg2;
                        code = code2;
                    } else {
                        noEnoughSpace = noEnoughSpaceMsg3;
                        itemAlreadyExist = false;
                        itemAddSuccess = false;
                        noEnoughSpaceMsg = noEnoughSpaceMsg2;
                        msg = noEnoughSpaceMsg2;
                        code = -1;
                    }
                    if (!itemAlreadyExist) {
                        z = false;
                    } else if (itemAddSuccess) {
                        z = false;
                        successCount[0] = successCount[0] + 1;
                        itemsToSave.add(item);
                    } else {
                        z = false;
                        failedCount[0] = failedCount[0] + 1;
                    }
                    final boolean success2222222 = itemAddSuccess;
                    final String errMsg2222222 = msg;
                    final int errCode2222222 = code;
                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (callback != null) {
                                if (success2222222) {
                                    callback.onSuccess(item);
                                } else {
                                    callback.onFailed(errCode2222222, errMsg2222222, item);
                                }
                            }
                        }
                    });
                    noEnoughSpaceMsg2 = noEnoughSpaceMsg;
                    noEnoughSpaceMsg3 = noEnoughSpace;
                }
                KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (callback != null) {
                            callback.onKeywordAddFinish(successCount[0], failedCount[0]);
                        }
                    }
                });
                BlockListStorageUtils.appendUserBlockedKeywords(appContext, itemsToSave);
                KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.4.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (callback != null) {
                            callback.onKeywordsAddedToLocal();
                        }
                    }
                });
            }
        };
        execute(r);
    }

    public void appendKeyword(Context context, UserKeywordItem item, KeywordAddCallback callback) {
        if (context == null) {
            return;
        }
        Context appContext = context.getApplicationContext();
        long mid = BiliAccounts.get(appContext).mid();
        if (mid < 0) {
            return;
        }
        if (this.mApiService == null) {
            this.mApiService = createApiService();
        }
        BiliCall<GeneralResponse<String>> call = this.mApiService.add(getAccessKey(appContext), item.type, item.data);
        call.enqueue(new AnonymousClass5(callback, item, appContext));
    }

    /* renamed from: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask$5  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    class AnonymousClass5 extends BiliApiDataCallback<String> {
        final /* synthetic */ Context val$appContext;
        final /* synthetic */ KeywordAddCallback val$callback;
        final /* synthetic */ UserKeywordItem val$item;

        AnonymousClass5(KeywordAddCallback keywordAddCallback, UserKeywordItem userKeywordItem, Context context) {
            this.val$callback = keywordAddCallback;
            this.val$item = userKeywordItem;
            this.val$appContext = context;
        }

        public void onDataSuccess(String data) {
            ArrayList<UserKeywordItem> itemsToSave = new ArrayList<>();
            try {
            } catch (JSONException e) {
                if (this.val$callback != null) {
                    this.val$callback.onFailed(0, "", this.val$item);
                }
            }
            if (data == null) {
                if (this.val$callback != null) {
                    this.val$callback.onFailed(0, "", this.val$item);
                    return;
                }
                return;
            }
            JSONObject res = new JSONObject(data);
            int newId = res.optInt("id", -1);
            if (newId != -1) {
                this.val$item.id = newId;
            }
            itemsToSave.add(this.val$item);
            if (this.val$callback != null) {
                this.val$callback.onSuccess(this.val$item);
            }
            AsyncBlockListStorageUtils.appendUserBlockedKeywords(this.val$appContext, itemsToSave, new AsyncBlockListStorageUtils.AsyncBlockListStorageUtilsCallback() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.5.1
                @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils.AsyncBlockListStorageUtilsCallback
                public void onComplete() {
                    KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass5.this.val$callback != null) {
                                AnonymousClass5.this.val$callback.onKeywordAddedToLocal(AnonymousClass5.this.val$item);
                            }
                        }
                    });
                }
            });
        }

        public void onError(Throwable t) {
            if (this.val$callback != null) {
                String msg = "";
                int code = -1;
                if (t instanceof BiliApiException) {
                    msg = KeywordsSyncMsgInterceptor.onIntercept(this.val$appContext, ((BiliApiException) t).mCode, t.getMessage());
                    code = ((BiliApiException) t).mCode;
                }
                this.val$callback.onFailed(code, msg, this.val$item);
            }
        }
    }

    public void removeKeywords(Context context, Collection<UserKeywordItem> items, final KeywordsRemoveCallback callback) {
        if (context == null || items == null || items.isEmpty()) {
            return;
        }
        Context appContext = context.getApplicationContext();
        long mid = BiliAccounts.get(appContext).mid();
        if (mid < 0) {
            return;
        }
        AsyncBlockListStorageUtils.removeUserBlockedKeywords(appContext, items, new AsyncBlockListStorageUtils.AsyncBlockListStorageUtilsCallback() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.6
            @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.AsyncBlockListStorageUtils.AsyncBlockListStorageUtilsCallback
            public void onComplete() {
                if (callback != null) {
                    callback.onKeywordsRemovedFromLocal();
                }
            }
        });
        if (this.mApiService == null) {
            this.mApiService = createApiService();
        }
        StringBuilder ids = new StringBuilder();
        for (UserKeywordItem item : items) {
            ids.append(item.id).append(",");
        }
        int index = ids.lastIndexOf(",");
        if (index > 0) {
            ids.deleteCharAt(index);
        }
        if (!TextUtils.isEmpty(ids.toString())) {
            BiliCall<GeneralResponse<String>> call = this.mApiService.delete(getAccessKey(appContext), ids.toString());
            call.enqueue(new BiliApiDataCallback<String>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.7
                public void onDataSuccess(String data) {
                    if (callback != null) {
                        callback.onKeywordsRemoved(true);
                    }
                }

                public void onError(Throwable t) {
                    if (callback != null) {
                        callback.onKeywordsRemoved(false);
                    }
                }
            });
        }
    }

    public void removeKeywordsAsync(Context context, final Set<String> items, KeywordsRemoveCallback callback) {
        if (context == null || items == null || items.isEmpty()) {
            return;
        }
        final Context appContext = context.getApplicationContext();
        Task.callInBackground(new Callable<List<UserKeywordItem>>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.9
            @Override // java.util.concurrent.Callable
            public List<UserKeywordItem> call() throws Exception {
                List<UserKeywordItem> userKeywordItems = BlockListStorageUtils.readUserBlockedUserIds(appContext);
                List<UserKeywordItem> list = new ArrayList<>();
                if (!userKeywordItems.isEmpty()) {
                    for (String item : items) {
                        for (UserKeywordItem userKeywordItem : userKeywordItems) {
                            if (TextUtils.equals(item, userKeywordItem.data)) {
                                list.add(userKeywordItem);
                            }
                        }
                    }
                }
                return list;
            }
        }).continueWith(new AnonymousClass8(appContext, callback), Task.UI_THREAD_EXECUTOR);
    }

    /* renamed from: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask$8  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    class AnonymousClass8 implements Continuation<List<UserKeywordItem>, Object> {
        final /* synthetic */ Context val$appContext;
        final /* synthetic */ KeywordsRemoveCallback val$callback;

        AnonymousClass8(Context context, KeywordsRemoveCallback keywordsRemoveCallback) {
            this.val$appContext = context;
            this.val$callback = keywordsRemoveCallback;
        }

        public Object then(Task<List<UserKeywordItem>> task) throws Exception {
            List<UserKeywordItem> result;
            if (task.isCompleted() && (result = (List) task.getResult()) != null && !result.isEmpty()) {
                KeywordsSyncTask.this.removeKeywords(this.val$appContext, result, new KeywordsRemoveCallback() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.8.1
                    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.KeywordsRemoveCallback
                    public void onKeywordsRemoved(boolean success) {
                    }

                    @Override // tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.KeywordsRemoveCallback
                    public void onKeywordsRemovedFromLocal() {
                        KeywordsSyncTask.notifyOnUiThread(new Runnable() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.KeywordsSyncTask.8.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass8.this.val$callback != null) {
                                    AnonymousClass8.this.val$callback.onKeywordsRemovedFromLocal();
                                }
                            }
                        });
                    }
                });
                return null;
            }
            return null;
        }
    }

    public void removeKeyword(Context context, UserKeywordItem item, KeywordsRemoveCallback callback) {
        List<UserKeywordItem> items = new ArrayList<>();
        items.add(item);
        removeKeywords(context, items, callback);
    }

    private static void execute(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        HandlerThreads.getHandler(2).post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        HandlerThreads.getHandler(0).post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public KeywordsBlockApiService createApiService() {
        return (KeywordsBlockApiService) ServiceGenerator.createService(KeywordsBlockApiService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAccessKey(Context context) {
        return BiliAccounts.get(context).getAccessKey();
    }
}