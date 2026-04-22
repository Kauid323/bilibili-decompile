package tv.danmaku.bili.utils.storage.dp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.UriPermission;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.browseractions.BrowserActionsFallbackMenuDialog$;
import androidx.fragment.app.Fragment;
import bili.resource.common.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.base.Applications;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.videodownloader.action.ServiceCustomizableAction;
import com.bilibili.videodownloader.directory.file.VideoFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.services.videodownload.action.ForceLoadTaskAction;
import tv.danmaku.bili.services.videodownload.action.VideoDownloadActionServiceHelper;
import tv.danmaku.bili.utils.storage.StorageHelper;
import video.biz.offline.base.infra.utils.StorageHelperKt;

public class DocumentProviderCompatHelper {
    private static final String TAG = "DPCompatHelper";
    private static final BaseDocumentProviderCompat sInstance = create();

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface AuthorizedCallback {
        void onAuthorizeStartFail();

        void onAuthorizedCancel();

        void onHasBeenAuthorized();
    }

    private static BaseDocumentProviderCompat create() {
        if (Build.VERSION.SDK_INT >= 24) {
            return new DocumentProviderCompatV24();
        }
        return new DocumentProviderCompatV21();
    }

    public static void obtainExternalPathStoragePermission(Activity activity, String dirPath, int requestCode, AuthorizedCallback callback) {
        obtainExternalPathStoragePermission(activity, null, dirPath, requestCode, callback);
    }

    public static void obtainExternalPathStoragePermission(Fragment fragment, String dirPath, int requestCode, AuthorizedCallback callback) {
        obtainExternalPathStoragePermission(null, fragment, dirPath, requestCode, callback);
    }

    private static void obtainExternalPathStoragePermission(final Activity activity, final Fragment fragment, final String dirPath, final int requestCode, final AuthorizedCallback callback) {
        if (activity == null && fragment == null) {
            return;
        }
        final Context context = fragment == null ? activity : fragment.getActivity();
        if (sInstance == null || !OnlineParamsHelper.enableDocumentProvider()) {
            if (sInstance != null) {
                StorageHelper.updatePersistableUri(context, "");
            }
            if (callback != null) {
                callback.onHasBeenAuthorized();
                return;
            }
            return;
        }
        String contentDes = context.getString(R.string.common_global_string_29);
        boolean hasObtainEXP = sInstance.isObtainExternalStoragePermission(context);
        if (StorageHelper.isPrimary(context, dirPath) || hasObtainEXP) {
            reportObtainPermission("0", dirPath);
            BLog.d(TAG, "perform directly");
            if (callback != null) {
                callback.onHasBeenAuthorized();
                return;
            }
            return;
        }
        final Dialog dialog = createProgressDialog(context, contentDes, activity == null);
        Task.call(new Callable<Void>() { // from class: tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.3
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                dialog.show();
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR).continueWith(new Continuation<Void, Boolean>() { // from class: tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.2
            /* renamed from: then  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1945then(Task task) throws Exception {
                return then((Task<Void>) task);
            }

            public Boolean then(Task<Void> task) throws Exception {
                return Boolean.valueOf(DocumentProviderCompatHelper.checkWritePermission(new File(dirPath)));
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<Boolean, Void>() { // from class: tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.1
            private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(Object popup) {
                Intrinsics.checkNotNullParameter(popup, "popup");
                if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                    Thread thread = Thread.currentThread();
                    if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                        IllegalStateException exp = new IllegalStateException("Dialog.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                        BLog.e("BgThreadUIAccess", "Dialog.dismiss() called from non-UI thread: " + thread, exp);
                        Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new BrowserActionsFallbackMenuDialog$.ExternalSyntheticLambda0());
                        if (BuildConfig.DEBUG) {
                            throw exp;
                        }
                    }
                }
                ((Dialog) popup).dismiss();
            }

            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1944then((Task<Boolean>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1944then(Task<Boolean> task) throws Exception {
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookDialogDismiss(dialog);
                if (task.getResult() != null && ((Boolean) task.getResult()).booleanValue()) {
                    BLog.d(DocumentProviderCompatHelper.TAG, "perform by write permission");
                    if (callback != null) {
                        DocumentProviderCompatHelper.reportObtainPermission("1", dirPath);
                        callback.onHasBeenAuthorized();
                        return null;
                    }
                    return null;
                } else if (DocumentProviderCompatHelper.hasAndroidExternalDocumentUI(context)) {
                    BLog.d(DocumentProviderCompatHelper.TAG, "request permission");
                    if (activity == null) {
                        DocumentProviderCompatHelper.reportObtainPermission("2", dirPath);
                        DocumentProviderCompatHelper.requestExternalPermissionForFragment(fragment, requestCode, callback);
                        return null;
                    }
                    DocumentProviderCompatHelper.reportObtainPermission("3", dirPath);
                    DocumentProviderCompatHelper.requestExternalPermissionForActivity(activity, requestCode, callback);
                    return null;
                } else if (callback != null) {
                    BLog.d(DocumentProviderCompatHelper.TAG, "obtain permission fail");
                    DocumentProviderCompatHelper.reportObtainPermission("4", dirPath);
                    callback.onAuthorizeStartFail();
                    return null;
                } else {
                    return null;
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public static boolean onSuccessDocumentProviderActivityResult(Activity activity, Intent data) {
        Uri uri = data.getData();
        if (uri != null && isExternalRootDirectoryByContentUri(uri)) {
            activity.getContentResolver().takePersistableUriPermission(uri, 3);
            StorageHelper.updatePersistableUri(activity, uri.toString());
            VideoDownloadActionServiceHelper.startByBroadcast(activity.getApplicationContext(), new ServiceCustomizableAction[]{new ForceLoadTaskAction()});
            reportDocumentPickerUIResult("1");
            return true;
        }
        reportDocumentPickerUIResult("2");
        return false;
    }

    public static VideoFile getVideoFileFromFile(Context context, File file) {
        int index;
        if (file == null) {
            return null;
        }
        VideoFile videoFile = VideoFile.fromFile(file);
        String path = StorageHelper.getPersistableUri(context);
        try {
            String filePath = file.getCanonicalPath();
            if (OnlineParamsHelper.enableDocumentProvider() && !StorageHelper.isPrimary(context, filePath) && VideoFile.checkValidTreeRootUri(path) && (index = getChildPathIndex(context, filePath, path)) > 1) {
                String childPath = "";
                if (index < filePath.length()) {
                    childPath = filePath.substring(index + 1);
                }
                return VideoFile.fromPath(context, path, childPath);
            }
            return videoFile;
        } catch (Exception e) {
            return videoFile;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestExternalPermissionForActivity(final Activity activity, final int requestCode, final AuthorizedCallback callback) {
        new AlertDialog.Builder(activity).setTitle(bili.resource.downloads.R.string.downloads_global_string_1).setView(tv.danmaku.bili.R.layout.bili_app_dialog_document_provider_guide).setPositiveButton(R.string.common_global_string_202, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                activity.startActivityForResult(intent, requestCode);
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.common_global_string_238, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (AuthorizedCallback.this != null) {
                    AuthorizedCallback.this.onAuthorizedCancel();
                    DocumentProviderCompatHelper.reportDocumentPickerUIResult("0");
                }
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestExternalPermissionForFragment(final Fragment fragment, final int requestCode, final AuthorizedCallback callback) {
        new AlertDialog.Builder(fragment.getActivity()).setTitle(bili.resource.downloads.R.string.downloads_global_string_1).setView(tv.danmaku.bili.R.layout.bili_app_dialog_document_provider_guide).setPositiveButton(R.string.common_global_string_202, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                fragment.startActivityForResult(intent, requestCode);
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.common_global_string_238, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (AuthorizedCallback.this != null) {
                    AuthorizedCallback.this.onAuthorizedCancel();
                    DocumentProviderCompatHelper.reportDocumentPickerUIResult("0");
                }
            }
        }).create().show();
    }

    private static Dialog createProgressDialog(Context context, String contentDes, boolean isSupport) {
        if (isSupport) {
            TintProgressDialog tintProgressDialog = new TintProgressDialog(context);
            tintProgressDialog.setCancelable(false);
            tintProgressDialog.setIndeterminate(true);
            tintProgressDialog.setMessage(contentDes);
            return tintProgressDialog;
        }
        Dialog dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        ((ProgressDialog) dialog).setIndeterminate(true);
        ((ProgressDialog) dialog).setMessage(contentDes);
        return dialog;
    }

    private static boolean isExternalRootDirectoryByContentUri(Uri uri) {
        int splitIndex;
        if (VideoFile.isTreeUri(uri)) {
            String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
            if (!TextUtils.isEmpty(treeDocumentId) && (splitIndex = treeDocumentId.indexOf(":")) == treeDocumentId.length() - 1) {
                String uuid = treeDocumentId.substring(0, splitIndex);
                return (TextUtils.isEmpty(uuid) || uuid.equals(StorageHelperKt.PRIMARY) || !uri.toString().endsWith(VideoFile.DOCUMENT_SPLIT_CHARACTER_ENCODED)) ? false : true;
            }
        }
        return false;
    }

    private static int getChildPathIndex(Context context, String filePath, String secondaryPath) {
        try {
            StorageManager manager = (StorageManager) context.getSystemService("storage");
            String documentId = DocumentsContract.getTreeDocumentId(Uri.parse(secondaryPath));
            String secondaryUuid = documentId.substring(0, documentId.indexOf(":"));
            if (sInstance != null) {
                return sInstance.getChildPathIndex(filePath, manager, secondaryUuid);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasAndroidExternalDocumentUI(Context context) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        ResolveInfo info = context.getPackageManager().resolveActivity(intent, 0);
        return (info == null || info.activityInfo == null || TextUtils.isEmpty(info.activityInfo.name)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkWritePermission(File dir) {
        FileInputStream is = null;
        FileOutputStream os = null;
        boolean z = false;
        try {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (dir.isDirectory()) {
                File testFile = new File(dir, "write.test");
                os = new FileOutputStream(testFile);
                os.write("test".getBytes("UTF-8"));
                os.flush();
                is = new FileInputStream(testFile);
                byte[] bytes = new byte[(int) testFile.length()];
                is.read(bytes);
                IOUtils.closeQuietly(is);
                String result = new String(bytes, "UTF-8");
                if ("test".equals(result)) {
                    if (testFile.delete()) {
                        z = true;
                    }
                }
                IOUtils.closeQuietly(is);
                IOUtils.closeQuietly(os);
                return z;
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
            throw th;
        }
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class BaseDocumentProviderCompat {
        static Method sMethodGetVolumeList = null;
        static Method sMethodGetVolumePath = null;
        static Method sMethodGetVolumeUUid = null;

        abstract int getChildPathIndex(String str, StorageManager storageManager, String str2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException;

        abstract boolean isAuthorizedPermissionCurrentMounted(StorageManager storageManager, String str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException;

        boolean isObtainExternalStoragePermission(Context context) {
            boolean isMounted = false;
            String path = StorageHelper.getPersistableUri(context);
            if (TextUtils.isEmpty(path)) {
                return false;
            }
            if (path.startsWith("content")) {
                List<UriPermission> list = context.getContentResolver().getPersistedUriPermissions();
                Iterator<UriPermission> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UriPermission uriPermission = it.next();
                    if (path.equals(uriPermission.getUri().toString())) {
                        try {
                            StorageManager manager = (StorageManager) context.getSystemService("storage");
                            String documentId = DocumentsContract.getTreeDocumentId(Uri.parse(path));
                            String secondaryUuid = documentId.substring(0, documentId.indexOf(":"));
                            if (DocumentProviderCompatHelper.sInstance != null) {
                                isMounted = DocumentProviderCompatHelper.sInstance.isAuthorizedPermissionCurrentMounted(manager, secondaryUuid);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (!isMounted) {
                    StorageHelper.updatePersistableUri(context, "");
                    return isMounted;
                }
                return isMounted;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportObtainPermission(String obtainPermissionType, String path) {
        Application context = Applications.getCurrent();
        if (StorageHelper.isPrimary(context, path)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportDocumentPickerUIResult(String result) {
        Applications.getCurrent();
    }
}