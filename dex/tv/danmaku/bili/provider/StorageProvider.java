package tv.danmaku.bili.provider;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bilibili.app.preferences.Settings;
import com.bilibili.lib.spy.generated.android_content_ContentProvider;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.ExternalStorageHelper;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.bili.utils.storage.fetcher.StoragePathFetcherImpl;

public class StorageProvider extends android_content_ContentProvider {
    private static final int MAX_RETRY = 3;
    private static ExternalStorageHelper legacyStorageHelper;
    private static final Map<String, String> CACHE = new HashMap();
    private static int failCount = 0;

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Context) ctx).registerReceiver(receiver, filter);
    }

    public void attachInfo(Context context, ProviderInfo info) {
        super.attachInfo(context, info);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(context, new MediaReceiver(), intentFilter);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return buildCursor4Query(uri.getLastPathSegment());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Cursor buildCursor4Query(String query) {
        String value;
        char c;
        File directory;
        synchronized (CACHE) {
            MatrixCursor cursor = new MatrixCursor(new String[]{"value"});
            if ("storage_persistable_uri".equals(query)) {
                value = getUriString(getContext());
            } else {
                value = CACHE.get(query);
                if (value == null) {
                    switch (query.hashCode()) {
                        case -817598092:
                            if (query.equals("secondary")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -314765822:
                            if (query.equals("primary")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            value = StoragePathFetcherImpl.getPrimaryPath(getContext());
                            break;
                        case 1:
                            value = StoragePathFetcherImpl.getSecondaryPath(getContext());
                            break;
                        default:
                            return null;
                    }
                    if (value == null && legacyStorageHelper != null && (directory = legacyStorageHelper.getSecondaryStorageDirectory()) != null) {
                        value = directory.getAbsolutePath();
                        BLog.w("StorageProvider", "legacyStorageHelper.getSecondaryStorageDirectory():" + value);
                    }
                    if (value == null) {
                        int i = failCount;
                        failCount = i + 1;
                        if (i > 3) {
                            CACHE.put(query, "");
                        }
                    }
                    CACHE.put(query, value);
                }
            }
            if (value == null || value.length() <= 0) {
                return null;
            }
            cursor.addRow(new Object[]{value});
            return cursor;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String segment = uri.getLastPathSegment();
        Context context = getContext();
        if (context != null && "storage_persistable_uri".equals(segment)) {
            revokeOldUriPermissionIfNeed(uri, context);
            String newUri = values.getAsString("storage_persistable_uri_key");
            if (!TextUtils.isEmpty(newUri)) {
                saveUriString(getContext(), newUri);
                return 1;
            }
            return 1;
        }
        return 0;
    }

    private void revokeOldUriPermissionIfNeed(Uri uri, Context context) {
        String oldUri = getUriString(context);
        if (!TextUtils.isEmpty(oldUri)) {
            try {
                context.getContentResolver().releasePersistableUriPermission(Uri.parse(oldUri), 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveUriString(context, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearCache(Context context) {
        synchronized (CACHE) {
            CACHE.clear();
            boolean result = false;
            String path = Settings.Download.getDownloadCustomStoragePath(context);
            if (!TextUtils.isEmpty(path) && !StorageHelper.isPrimary(context, path)) {
                Settings.Download.setDownloadCustomStoragePath(context, "");
                result = true;
            }
            if (Settings.Download.getDownloadStorage(context) == 2) {
                result = true;
            }
            if (result) {
                Settings.putString(context, Settings.Download.getDownloadStorageKey(context), "1");
            }
        }
    }

    static void mount(Intent intent) {
        if (legacyStorageHelper != null) {
            legacyStorageHelper.mountedStorage(intent);
        }
    }

    private static void saveUriString(Context context, String uri) {
        context.getSharedPreferences("storage", 0).edit().putString("storage_persistable_uri_key", uri).apply();
    }

    private static String getUriString(Context context) {
        return context.getSharedPreferences("storage", 0).getString("storage_persistable_uri_key", null);
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class MediaReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StorageProvider.failCount = 0;
            StorageProvider.clearCache(context);
            Log.i("Storage", "Media event received!");
            if ("android.intent.action.MEDIA_MOUNTED".equals(intent.getAction())) {
                StorageProvider.mount(intent);
            }
        }
    }
}