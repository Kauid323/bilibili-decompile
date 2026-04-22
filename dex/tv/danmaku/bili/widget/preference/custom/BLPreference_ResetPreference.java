package tv.danmaku.bili.widget.preference.custom;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat$;
import androidx.preference.PreferenceManager;
import com.bilibili.app.preferences.BiliPreferencesActivity;
import com.bilibili.app.preferences.ImageQualityHelper;
import com.bilibili.app.preferences.R;
import com.bilibili.app.preferences.Settings;
import com.bilibili.app.preferences.settings2.Settings2;
import com.bilibili.bangumi.BangumiRelateService;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.videodownloader.action.ServiceCustomizableAction;
import com.bilibili.xpref.Xpref;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.services.videodownload.action.HideOldFolderTaskAction;
import tv.danmaku.bili.services.videodownload.action.VideoDownloadActionServiceHelper;
import tv.danmaku.bili.widget.preference.BLPreference;
import tv.danmaku.bili.widget.preference.custom.BLPreference_ResetPreference;

public class BLPreference_ResetPreference extends BLPreference {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.widget.preference.custom.BLPreference_ResetPreference$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class AnonymousClass1 implements DialogInterface.OnClickListener {
        final /* synthetic */ Context val$context;

        private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                Thread thread = Thread.currentThread();
                if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                    IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                    BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                    Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                    if (BuildConfig.DEBUG) {
                        throw exp;
                    }
                }
            }
            ((Activity) activity).finish();
        }

        AnonymousClass1(Context context) {
            this.val$context = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            notifyCustomDirectoryChanged(this.val$context);
            notifyImageLoaderChanged();
            int timePreferenceResId = BLPreference_ResetPreference.this.getTimePreferenceResId();
            Settings2.setDefaultValues();
            BLPreference_ResetPreference.this.getSharedPreferences().edit().clear().apply();
            PreferenceManager.getDefaultSharedPreferences(BLPreference_ResetPreference.this.getContext().getApplicationContext()).edit().clear().apply();
            PreferenceManager.setDefaultValues(this.val$context, "bili_main_settings_preferences", 0, R.xml.play_setting_preferences, true);
            PreferenceManager.setDefaultValues(this.val$context, "bili_main_settings_preferences", 0, tv.danmaku.bili.R.xml.download_preferences, true);
            if (timePreferenceResId != 0) {
                PreferenceManager.setDefaultValues(this.val$context, "bili_main_settings_preferences", 0, timePreferenceResId, true);
            }
            PreferenceManager.setDefaultValues(this.val$context, "bili_main_settings_preferences", 0, R.xml.advanced_other_preferences, true);
            final Activity activity = ThemeUtils.getWrapperActivity(this.val$context);
            if (activity != null) {
                RouteRequest request = new RouteRequest.Builder("activity://main/preference").extras(new Function1() { // from class: tv.danmaku.bili.widget.preference.custom.BLPreference_ResetPreference$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return BLPreference_ResetPreference.AnonymousClass1.lambda$onClick$0(activity, (MutableBundleLike) obj);
                    }
                }).build();
                BLRouter.routeTo(request, activity);
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
                activity.overridePendingTransition(0, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$onClick$0(Activity activity, MutableBundleLike mutableBundleLike) {
            mutableBundleLike.put("extra:key:fragment", BiliPreferencesActivity.BiliPreferencesFragment.class.getName());
            mutableBundleLike.put("extra:key:title", activity.getString(bili.resource.settings.R.string.settings_global_string_256));
            return null;
        }

        private void notifyCustomDirectoryChanged(Context context) {
            String customPath = Settings.Download.getDownloadCustomStoragePath(context);
            if (!TextUtils.isEmpty(customPath)) {
                VideoDownloadActionServiceHelper.startByBroadcast(context, new ServiceCustomizableAction[]{new HideOldFolderTaskAction(customPath, "")});
            }
        }

        private void notifyImageLoaderChanged() {
            ImageQualityHelper.ImageQualitySupplier.reset();
        }
    }

    public BLPreference_ResetPreference(Context context) {
        super(context);
    }

    public BLPreference_ResetPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BLPreference_ResetPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SharedPreferences getSharedPreferences() {
        return Xpref.getSharedPreferences(getContext(), "bili_main_settings_preferences");
    }

    protected void onClick() {
        super.onClick();
        showAlertDialog(getContext());
    }

    public void showAlertDialog(Context context) {
        new AlertDialog.Builder(context).setMessage(bili.resource.homepage.R.string.homepage_global_string_288).setPositiveButton(bili.resource.common.R.string.common_global_string_49, new AnonymousClass1(context)).setNegativeButton(bili.resource.common.R.string.common_global_string_175, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTimePreferenceResId() {
        BangumiRelateService bangumiService = (BangumiRelateService) BLRouter.INSTANCE.get(BangumiRelateService.class, "default");
        if (bangumiService == null) {
            return 0;
        }
        return bangumiService.getTimePreferenceResourceId();
    }
}