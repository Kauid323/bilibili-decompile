package tv.danmaku.bili.preferences;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import bili.resource.homepage.R;
import com.bilibili.app.preferences.Settings;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.StringUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.ui.BasePreferenceFragment;
import com.bilibili.offline.OfflineABServiceKt;
import com.bilibili.playerbizcommonv2.utils.NumberExtensionKt;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.utils.CustomDirUtils;
import com.bilibili.videodownloader.utils.DebugUtilsKt;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.preferences.DownloadStoragePrefHelper;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.services.videodownload.action.AutoStartAllTaskIfNeedAction;
import tv.danmaku.bili.services.videodownload.action.ForceLoadTaskAction;
import tv.danmaku.bili.services.videodownload.action.HideOldFolderTaskAction;
import tv.danmaku.bili.services.videodownload.action.VideoDownloadActionServiceHelper;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;
import tv.danmaku.bili.ui.offline.OfflineReporter;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper;
import tv.danmaku.bili.widget.RadioButtonPreference;
import tv.danmaku.bili.widget.RadioGroupPreference;

public class DownloadStoragePrefHelper {
    private static final String KEY_FF_CUSTOM_FOLDER_HIDE_CUSTOM = "download_custom_folder_hide";
    private static final String KEY_UNSELECT_CUSTOM_VERSION = "download_setting_unselect_custom_version";
    public static final int REQ_CODE__FROM_CHOOSE_FOLDER = 10;
    public static final int REQ_CODE__FROM_DOCUMENT_PROVIDER = 11;
    private static final String TAG = "DownloadStoragePrefHelper";
    private MediaReceiver mMediaReceiver;
    private RadioGroupPreference.OnPreferenceRadioItemClickListener mOnPreferenceRadioItemClickListener = new AnonymousClass1();
    private RadioGroupPreference mPreference;
    private String mRadioValue;
    private WeakReference<PreferenceFragmentCompat> mWeakActivity;

    private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((Context) ctx).registerReceiver(receiver, filter, 4);
        }
        return ((Activity) ctx).registerReceiver(receiver, filter);
    }

    public static DownloadStoragePrefHelper newInstance(PreferenceFragmentCompat fragment) {
        return new DownloadStoragePrefHelper(fragment);
    }

    protected DownloadStoragePrefHelper(PreferenceFragmentCompat fragment) {
        this.mWeakActivity = new WeakReference<>(fragment);
        Activity activity = fragment.getActivity();
        this.mPreference = fragment.findPreference(Settings.Download.getDownloadStorageKey(activity));
        this.mRadioValue = this.mPreference.getRadioValue();
        this.mPreference.setOnPreferenceRadioItemClickListener(this.mOnPreferenceRadioItemClickListener);
        refresh(activity);
        registerMediaReceiver(activity);
    }

    private void registerMediaReceiver(Activity activity) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.mMediaReceiver = new MediaReceiver(this);
        __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(activity, this.mMediaReceiver, intentFilter);
    }

    void destroy(Activity activity) {
        activity.unregisterReceiver(this.mMediaReceiver);
        OfflineReporter.reportStoragePath(this.mRadioValue);
    }

    /* renamed from: tv.danmaku.bili.preferences.DownloadStoragePrefHelper$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    class AnonymousClass1 implements RadioGroupPreference.OnPreferenceRadioItemClickListener {
        AnonymousClass1() {
        }

        public boolean onPreferenceRadioItemClick(RadioGroupPreference radioGroup, RadioButtonPreference radioItem) {
            final FragmentActivity activity;
            PreferenceFragmentCompat fragment = (PreferenceFragmentCompat) DownloadStoragePrefHelper.this.mWeakActivity.get();
            if (fragment == null || (activity = fragment.getActivity()) == null) {
                return false;
            }
            DownloadStoragePrefHelper.this.mRadioValue = radioItem.getRadioValue();
            try {
                final int radioValue = Integer.parseInt(DownloadStoragePrefHelper.this.mRadioValue);
                if (radioValue == 3) {
                    final String path = Settings.Download.getDownloadCustomStoragePath(activity);
                    File olddir = null;
                    if (!TextUtils.isEmpty(path)) {
                        olddir = VideoDownloadStorageStrategy.getCustomDirectory(activity, path);
                    }
                    if (olddir != null && olddir.isDirectory() && FileUtils.listFilesOrEmpty(olddir).length > 0) {
                        new AlertDialog.Builder(activity).setTitle(R.string.homepage_global_string_337).setMessage(R.string.homepage_global_string_138).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null).setPositiveButton(bili.resource.common.R.string.common_global_string_202, new DialogInterface$OnClickListenerC00131(path, fragment)).show();
                    } else {
                        RouteRequest request = new RouteRequest.Builder(MainRouteUris.URI_FILE_CHOOSER).extras(new Function1() { // from class: tv.danmaku.bili.preferences.DownloadStoragePrefHelper$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return DownloadStoragePrefHelper.AnonymousClass1.lambda$onPreferenceRadioItemClick$0(path, (MutableBundleLike) obj);
                            }
                        }).requestCode(10).build();
                        BLRouter.routeTo(request, fragment);
                    }
                } else if (radioValue == 2) {
                    File secondaryFile = VideoDownloadStorageStrategy.getSecondaryDirectoryFile(activity);
                    if (secondaryFile == null) {
                        return false;
                    }
                    DocumentProviderCompatHelper.obtainExternalPathStoragePermission(fragment, secondaryFile.getAbsolutePath(), 11, new DocumentProviderCompatHelper.AuthorizedCallback() { // from class: tv.danmaku.bili.preferences.DownloadStoragePrefHelper.1.2
                        public void onHasBeenAuthorized() {
                            DownloadStoragePrefHelper.this.refresh(activity, radioValue);
                            DownloadStoragePrefHelper.this.recordUnSelectCustomFolderVersion(activity);
                        }

                        public void onAuthorizeStartFail() {
                            ToastHelper.showToastShort(activity, bili.resource.downloads.R.string.downloads_global_string_2);
                        }

                        public void onAuthorizedCancel() {
                            DownloadStoragePrefHelper.this.resetDefaultValue();
                        }
                    });
                } else {
                    DownloadStoragePrefHelper.this.recordUnSelectCustomFolderVersion(activity);
                    DownloadStoragePrefHelper.this.refresh(activity, radioValue);
                }
                return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        /* renamed from: tv.danmaku.bili.preferences.DownloadStoragePrefHelper$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        class DialogInterface$OnClickListenerC00131 implements DialogInterface.OnClickListener {
            final /* synthetic */ PreferenceFragmentCompat val$fragment;
            final /* synthetic */ String val$path;

            DialogInterface$OnClickListenerC00131(String str, PreferenceFragmentCompat preferenceFragmentCompat) {
                this.val$path = str;
                this.val$fragment = preferenceFragmentCompat;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                RouteRequest.Builder builder = new RouteRequest.Builder(MainRouteUris.URI_FILE_CHOOSER);
                final String str = this.val$path;
                RouteRequest request = builder.extras(new Function1() { // from class: tv.danmaku.bili.preferences.DownloadStoragePrefHelper$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return DownloadStoragePrefHelper.AnonymousClass1.DialogInterface$OnClickListenerC00131.lambda$onClick$0(str, (MutableBundleLike) obj);
                    }
                }).requestCode(10).build();
                BLRouter.routeTo(request, this.val$fragment);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static /* synthetic */ Unit lambda$onClick$0(String path, MutableBundleLike mutableBundleLike) {
                if (!TextUtils.isEmpty(path)) {
                    mutableBundleLike.put(FileChooserActivity.EXTRA_CURRENT_BASE_PATH, path);
                    return null;
                }
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onPreferenceRadioItemClick$0(String path, MutableBundleLike mutableBundleLike) {
            if (!TextUtils.isEmpty(path)) {
                mutableBundleLike.put(FileChooserActivity.EXTRA_CURRENT_BASE_PATH, path);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDefaultValue() {
        this.mPreference.setRadioValue(String.valueOf(1));
    }

    private void refresh(Context context) {
        boolean isPrimaryShow = refresh(context, 1).booleanValue();
        boolean isSecondaryShow = refresh(context, 2).booleanValue();
        boolean isCustomShow = refresh(context, 3).booleanValue();
        if (!isPrimaryShow && !isSecondaryShow && !isCustomShow) {
            this.mPreference.setVisible(false);
        }
        if (OfflineABServiceKt.hitsKOffline() && OfflineABServiceKt.hitsKOfflineHitsHideExternalCard()) {
            this.mPreference.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean refresh(Context context, int prefValue) {
        StringBuilder sb = new StringBuilder();
        boolean available = getPrefSummaryByValue(context, prefValue, sb);
        boolean isShow = false;
        if (this.mPreference != null) {
            if (!available && (prefValue == 2 || isForceHideCustomFolder(context))) {
                this.mPreference.removeByRadioValue(prefValue);
                isShow = false;
            } else {
                this.mPreference.setEnabledByRadioValue(prefValue, available);
                this.mPreference.setRadioSummary(prefValue, sb.toString());
                isShow = true;
            }
        }
        return Boolean.valueOf(isShow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshByMediaMount(Context context) {
        boolean result = false;
        StringBuilder sb = new StringBuilder();
        getPrefSummaryByValue(context, 3, sb);
        if (TextUtils.isEmpty(sb)) {
            result = true;
            this.mPreference.setRadioSummary(3, "");
        }
        if (!getPrefSummaryByValue(context, 2, new StringBuilder())) {
            this.mPreference.removeByRadioValue(2);
            result = true;
        }
        if (result) {
            resetDefaultValue();
        }
    }

    public static boolean formatSummary(Context context, StringBuilder sb, StorageHelper.Storage storage) {
        if (storage != null) {
            sb.append(storage.getPath());
            if (storage.getTotalByte() > 0) {
                sb.append(" (");
                sb.append(NumberExtensionKt.toFileSize(storage.getAvailableByte()) + " / " + NumberExtensionKt.toFileSize(storage.getTotalByte()));
                sb.append(") ");
                return true;
            }
            sb.append(" (");
            sb.append(context.getString(R.string.homepage_global_string_268));
            sb.append(") ");
            return false;
        }
        sb.append("(");
        sb.append(context.getString(R.string.homepage_global_string_268));
        sb.append(") ");
        return false;
    }

    public final boolean getPrefSummaryByValue(Context context, int type, StringBuilder sb) {
        switch (type) {
            case 2:
                return isSecondaryExternalShow(context, sb);
            case 3:
                return isCustomStoragePathShow(context, sb);
            default:
                return isPrimaryExternalShow(context, sb);
        }
    }

    private boolean isCustomStoragePathShow(Context context, StringBuilder sb) {
        boolean forceHideCustomFolder = isForceHideCustomFolder(context);
        if (forceHideCustomFolder) {
            return false;
        }
        String path = Settings.Download.getDownloadCustomStoragePath(context);
        if (TextUtils.isEmpty(path)) {
            sb.setLength(0);
            return true;
        }
        File file = new File(path);
        boolean summaryResult = formatSummary(context, sb, StorageHelper.Storage.fromFile(file));
        if (!summaryResult && !StorageHelper.isPrimary(context, path)) {
            sb.delete(0, sb.length());
        }
        return true;
    }

    private boolean isSecondaryExternalShow(Context context, StringBuilder sb) {
        return formatSummary(context, sb, StorageHelper.getSecondaryStorage(context));
    }

    private boolean isPrimaryExternalShow(Context context, StringBuilder sb) {
        boolean forceHideCustomFolder = isForceHideCustomFolder(context);
        boolean notHasSecondaryExternal = StorageHelper.getSecondaryStorage(context) == null;
        if (forceHideCustomFolder && notHasSecondaryExternal) {
            return false;
        }
        return formatSummary(context, sb, StorageHelper.getPrimaryStorage(context));
    }

    private boolean isForceHideCustomFolder(Context context) {
        if (BuildConfig.DEBUG && DebugUtilsKt.isForceShowCustomDirForDebug()) {
            ToastHelper.showToastShort(context, "debug tools force show custom dir!!!!");
            return false;
        } else if (CustomDirUtils.isAbandonCustomDir()) {
            return true;
        } else {
            boolean isHideCustom = ConfigManager.ab().get(KEY_FF_CUSTOM_FOLDER_HIDE_CUSTOM, false) == Boolean.TRUE;
            if (BuildConfig.DEBUG) {
                ToastHelper.showToastShort(context, isHideCustom ? "ff hide custom" : "ff show custom");
            }
            if (!isHideCustom) {
                if (Build.VERSION.SDK_INT >= 30) {
                    return StringUtil.isBlank(Settings.Download.getDownloadCustomStoragePath(context));
                }
                return false;
            }
            boolean hasCustomFolder = StringUtil.isNotBlank(Settings.Download.getDownloadCustomStoragePath(context));
            if (!hasCustomFolder) {
                BLog.i(TAG, "hide custom folder because user never set it");
                return true;
            }
            boolean isSelectedCustomFolder = Settings.Download.getDownloadStorage(context) == 3;
            if (!isSelectedCustomFolder) {
                int currentVersion = Foundation.instance().getApps().getVersionCode();
                int unSelectVersion = getUnSelectCustomFolderVersion(context);
                if (currentVersion > unSelectVersion) {
                    BLog.i(TAG, "hide custom folder because old version un select it, unselect version > " + unSelectVersion);
                    return true;
                }
            }
            return false;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        final FragmentActivity activity;
        PreferenceFragmentCompat fragment = this.mWeakActivity.get();
        if (fragment == null || (activity = fragment.getActivity()) == null || this.mPreference == null) {
            return;
        }
        if (requestCode == 11) {
            if (resultCode == -1) {
                if (DocumentProviderCompatHelper.onSuccessDocumentProviderActivityResult(activity, data)) {
                    int radioValue = this.mPreference.getRadioValueAsInteger(1);
                    if (radioValue == 2) {
                        refresh(activity, radioValue);
                    }
                    ToastHelper.showToastShort(activity, bili.resource.downloads.R.string.downloads_global_string_21);
                    return;
                }
                ToastHelper.showToastShort(activity, bili.resource.downloads.R.string.downloads_global_string_72);
                return;
            }
            resetDefaultValue();
            ToastHelper.showToastShort(activity, bili.resource.downloads.R.string.downloads_global_string_86);
        } else if (requestCode == 10) {
            final String lastPath = Settings.Download.getDownloadCustomStoragePath(activity);
            if (resultCode == -1) {
                final String path = data.getData().getPath();
                if (!TextUtils.isEmpty(lastPath)) {
                    String relPath = getRealDownloadPath(activity, path);
                    String lastRelPath = getRealDownloadPath(activity, lastPath);
                    if (!relPath.equals(lastRelPath)) {
                        VideoFile dir = DocumentProviderCompatHelper.getVideoFileFromFile(activity, VideoDownloadStorageStrategy.getCustomDirectory(activity, lastPath));
                        if (hasChildFile(dir)) {
                            new AlertDialog.Builder(activity).setTitle(R.string.homepage_global_string_285).setMessage(activity.getString(R.string.homepage_global_string_319, new Object[]{lastPath})).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null).setPositiveButton(bili.resource.common.R.string.common_global_string_202, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.preferences.DownloadStoragePrefHelper.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    DownloadStoragePrefHelper.this.save(activity, path);
                                    DownloadStoragePrefHelper.notifyDownloadFolderChanged(activity, lastPath, path);
                                }
                            }).show();
                            return;
                        }
                        save(activity, path);
                        notifyDownloadFolderChanged(activity, lastPath, path);
                        return;
                    }
                    save(activity, relPath);
                    return;
                }
                save(activity, path);
                notifyDownloadFolderChanged(activity, lastPath, path);
            } else if (TextUtils.isEmpty(lastPath)) {
                resetDefaultValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordUnSelectCustomFolderVersion(Context context) {
        int currentVersion = Foundation.instance().getApps().getVersionCode();
        BiliGlobalPreferenceHelper.getInstance(context).edit().putInt(KEY_UNSELECT_CUSTOM_VERSION, currentVersion).apply();
    }

    private int getUnSelectCustomFolderVersion(Context context) {
        return BiliGlobalPreferenceHelper.getInstance(context).optInteger(KEY_UNSELECT_CUSTOM_VERSION, 0);
    }

    private void clearUnSelectCustomFolderVersion(Context context) {
        BiliGlobalPreferenceHelper.getInstance(context).edit().remove(KEY_UNSELECT_CUSTOM_VERSION).apply();
    }

    private boolean hasChildFile(VideoFile dir) {
        VideoFile[] videoFiles;
        return dir != null && dir.isDirectory() && (videoFiles = dir.listFiles()) != null && videoFiles.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(Context context, String path) {
        Settings.Download.setDownloadCustomStoragePath(context, path);
        clearUnSelectCustomFolderVersion(context);
        refresh(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyDownloadFolderChanged(Context context, String oldFolder, String newFolder) {
        VideoDownloadActionServiceHelper.startByBroadcast(context, new HideOldFolderTaskAction(oldFolder, newFolder), new ForceLoadTaskAction(), new AutoStartAllTaskIfNeedAction());
    }

    private static String getRealDownloadPath(Context context, String path) {
        try {
            path = new File(path).getCanonicalPath();
        } catch (IOException e) {
        }
        int lastIndex = path.lastIndexOf(VideoDownloadStorageStrategy.getDirBiliRoot(context));
        if (lastIndex > 0) {
            return path.substring(0, lastIndex - 1);
        }
        return path;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class MediaReceiver extends BroadcastReceiver {
        private DownloadStoragePrefHelper preHelper;

        public MediaReceiver(DownloadStoragePrefHelper preHelper) {
            this.preHelper = preHelper;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BLog.d(DownloadStoragePrefHelper.TAG, "Media event received!");
            this.preHelper.refreshByMediaMount(context);
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class DownloadPrefFragment extends BasePreferenceFragment {
        private DownloadStoragePrefHelper mDownloadStoragePrefHelper;

        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            getActivity().setTitle(getString(bili.resource.settings.R.string.settings_global_string_1));
            addPreferencesFromResource(tv.danmaku.bili.R.xml.download_preferences);
            Preference testSdPref = findPreference(getString(com.bilibili.app.preferences.R.string.pref_key_download_offline_external_storage));
            if (testSdPref != null && OfflineABServiceKt.hitsKOffline()) {
                if (OfflineABServiceKt.hitsKOfflineHitsHideExternalCard()) {
                    testSdPref.setVisible(false);
                }
                testSdPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: tv.danmaku.bili.preferences.DownloadStoragePrefHelper$DownloadPrefFragment$$ExternalSyntheticLambda0
                    public final boolean onPreferenceClick(Preference preference) {
                        return DownloadStoragePrefHelper.DownloadPrefFragment.this.m1250lambda$onCreatePreferences$0$tvdanmakubilipreferencesDownloadStoragePrefHelper$DownloadPrefFragment(preference);
                    }
                });
            }
            Preference offlineDiagnosePref = findPreference(getString(com.bilibili.app.preferences.R.string.pref_key_download_offline_diagnose));
            if (offlineDiagnosePref != null && OfflineABServiceKt.hitsKOffline()) {
                offlineDiagnosePref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: tv.danmaku.bili.preferences.DownloadStoragePrefHelper$DownloadPrefFragment$$ExternalSyntheticLambda1
                    public final boolean onPreferenceClick(Preference preference) {
                        return DownloadStoragePrefHelper.DownloadPrefFragment.this.m1251lambda$onCreatePreferences$1$tvdanmakubilipreferencesDownloadStoragePrefHelper$DownloadPrefFragment(preference);
                    }
                });
            }
            this.mDownloadStoragePrefHelper = DownloadStoragePrefHelper.newInstance(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onCreatePreferences$0$tv-danmaku-bili-preferences-DownloadStoragePrefHelper$DownloadPrefFragment  reason: not valid java name */
        public /* synthetic */ boolean m1250lambda$onCreatePreferences$0$tvdanmakubilipreferencesDownloadStoragePrefHelper$DownloadPrefFragment(Preference preference) {
            BLRouter.routeTo(RouteRequestKt.toRouteRequest("bilibili://offline/cache/diagnose/sd"), getContext());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onCreatePreferences$1$tv-danmaku-bili-preferences-DownloadStoragePrefHelper$DownloadPrefFragment  reason: not valid java name */
        public /* synthetic */ boolean m1251lambda$onCreatePreferences$1$tvdanmakubilipreferencesDownloadStoragePrefHelper$DownloadPrefFragment(Preference pref) {
            BLRouter.routeTo(RouteRequestKt.toRouteRequest("bilibili://offline/cache/diagnose/data"), getContext());
            return true;
        }

        public void onDestroy() {
            super.onDestroy();
            this.mDownloadStoragePrefHelper.destroy(getActivity());
        }

        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode) {
                case 10:
                case 11:
                    this.mDownloadStoragePrefHelper.onActivityResult(requestCode, resultCode, data);
                    return;
                default:
                    return;
            }
        }
    }
}