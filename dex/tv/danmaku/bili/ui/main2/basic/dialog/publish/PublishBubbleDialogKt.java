package tv.danmaku.bili.ui.main2.basic.dialog.publish;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.moduleservice.upper.UpperCenterPlusBubbleService;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.basic.TabHostGarbProviderKt;

/* compiled from: PublishBubbleDialog.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\f\u001a\u00020\rH\u0000\u001a0\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0007H\u0007\u001a.\u0010\u001a\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0007H\u0087@¢\u0006\u0002\u0010\u001b\u001a\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u0018H\u0000\u001a\u0010\u0010<\u001a\u0004\u0018\u00010=H\u0082@¢\u0006\u0002\u0010>\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\"\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020!X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\"\u001a\u0004\u0018\u00010#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0014\u0010&\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0003\"\u0014\u0010(\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0003\"\u001b\u0010*\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,\"\u001b\u0010/\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b0\u0010\u0003\"$\u00103\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0003\"\u0004\b5\u0010\u0005\"$\u00106\u001a\u00020!2\u0006\u00102\u001a\u00020!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b7\u0010,\"\u0004\b8\u00109¨\u0006?"}, d2 = {"splashExitTime", "", "getSplashExitTime", "()J", "setSplashExitTime", "(J)V", "inMainDialogManager", "", "getInMainDialogManager", "()Z", "setInMainDialogManager", "(Z)V", "showNextDialog", "", "mDialog", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubbleDialog;", "isDialogAdded", "showPublishBubbleInLifecycleScope", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "anchor", "Lcom/bilibili/lib/homepage/widget/TabHost;", "tabUrl", "", "addMainDialogManager", "showPublishBubble", "(Lcom/bilibili/lib/homepage/widget/TabHost;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "KEY_START_TIME", "KEY_SHOW_TIMES_SEVEN_DAYS", "KEY_SHOW_HISTORY", "SEVEN_DAYS", "MAX_SAVE_ID_SIZE", "", "kv", "Landroid/content/SharedPreferences;", "getKv", "()Landroid/content/SharedPreferences;", "localNow", "getLocalNow", "serverNow", "getServerNow", "mMaxShowCountInSevenDays", "getMMaxShowCountInSevenDays", "()I", "mMaxShowCountInSevenDays$delegate", "Lkotlin/Lazy;", "delayShowTime", "getDelayShowTime", "delayShowTime$delegate", "value", "mStartTime", "getMStartTime", "setMStartTime", "mShowTimesInSevenDays", "getMShowTimesInSevenDays", "setMShowTimesInSevenDays", "(I)V", "recordShowHistory", "id", "getAllowShowItem", "Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PublishBubbleDialogKt {
    private static final String KEY_SHOW_HISTORY = "SP_KEY_PUBLISH_GUIDE_POPUP_SHOW_HISTORY";
    private static final String KEY_SHOW_TIMES_SEVEN_DAYS = "SP_KEY_PUBLISH_GUIDE_POPUP_SHOW_TIMES_SEVEN_DAYS";
    private static final String KEY_START_TIME = "SP_KEY_PUBLISH_GUIDE_POPUP_START_TIME";
    public static final int MAX_SAVE_ID_SIZE = 5;
    public static final long SEVEN_DAYS = 604800000;
    private static boolean inMainDialogManager;
    private static boolean isDialogAdded;
    private static WeakReference<PublishBubbleDialog> mDialog;
    private static long splashExitTime;
    private static final Lazy mMaxShowCountInSevenDays$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubbleDialogKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            int mMaxShowCountInSevenDays_delegate$lambda$0;
            mMaxShowCountInSevenDays_delegate$lambda$0 = PublishBubbleDialogKt.mMaxShowCountInSevenDays_delegate$lambda$0();
            return Integer.valueOf(mMaxShowCountInSevenDays_delegate$lambda$0);
        }
    });
    private static final Lazy delayShowTime$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubbleDialogKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            long delayShowTime_delegate$lambda$0;
            delayShowTime_delegate$lambda$0 = PublishBubbleDialogKt.delayShowTime_delegate$lambda$0();
            return Long.valueOf(delayShowTime_delegate$lambda$0);
        }
    });

    public static final Object showPublishBubble(TabHost tabHost, String str, Continuation<? super Unit> continuation) {
        return showPublishBubble$default(tabHost, str, false, continuation, 4, null);
    }

    public static final Object showPublishBubble(TabHost tabHost, Continuation<? super Unit> continuation) {
        return showPublishBubble$default(tabHost, null, false, continuation, 6, null);
    }

    public static final void showPublishBubbleInLifecycleScope(LifecycleOwner lifecycleOwner, TabHost tabHost) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        showPublishBubbleInLifecycleScope$default(lifecycleOwner, tabHost, null, false, 12, null);
    }

    public static final void showPublishBubbleInLifecycleScope(LifecycleOwner lifecycleOwner, TabHost tabHost, String str) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        showPublishBubbleInLifecycleScope$default(lifecycleOwner, tabHost, str, false, 8, null);
    }

    public static final long getSplashExitTime() {
        return splashExitTime;
    }

    public static final void setSplashExitTime(long j) {
        splashExitTime = j;
    }

    public static final boolean getInMainDialogManager() {
        return inMainDialogManager;
    }

    public static final void setInMainDialogManager(boolean z) {
        inMainDialogManager = z;
    }

    public static final void showNextDialog() {
        if (inMainDialogManager) {
            MainDialogManager.showNextDialog("home_publish_bubble", false, (Context) null);
        }
        mDialog = null;
    }

    public static /* synthetic */ void showPublishBubbleInLifecycleScope$default(LifecycleOwner lifecycleOwner, TabHost tabHost, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            z = true;
        }
        showPublishBubbleInLifecycleScope(lifecycleOwner, tabHost, str, z);
    }

    public static final void showPublishBubbleInLifecycleScope(LifecycleOwner lifecycleOwner, TabHost anchor, String tabUrl, boolean addMainDialogManager) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new PublishBubbleDialogKt$showPublishBubbleInLifecycleScope$1(anchor, tabUrl, addMainDialogManager, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object showPublishBubble(TabHost anchor, String tabUrl, boolean addMainDialogManager, Continuation<? super Unit> continuation) {
        PublishBubbleDialogKt$showPublishBubble$1 publishBubbleDialogKt$showPublishBubble$1;
        Object allowShowItem;
        TabHost anchor2;
        boolean addMainDialogManager2;
        UpperCenterPlusBubbleService.BubbleInfo showItem;
        WeakReference<PublishBubbleDialog> weakReference;
        PublishBubbleDialog $this$showPublishBubble_u24lambda_u241;
        WeakReference<PublishBubbleDialog> weakReference2;
        if (continuation instanceof PublishBubbleDialogKt$showPublishBubble$1) {
            publishBubbleDialogKt$showPublishBubble$1 = (PublishBubbleDialogKt$showPublishBubble$1) continuation;
            if ((publishBubbleDialogKt$showPublishBubble$1.label & Integer.MIN_VALUE) != 0) {
                publishBubbleDialogKt$showPublishBubble$1.label -= Integer.MIN_VALUE;
                Object $result = publishBubbleDialogKt$showPublishBubble$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (publishBubbleDialogKt$showPublishBubble$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BLog.i(TabHostGarbProviderKt.TAG, "show publish bubble anchor:" + anchor + ", tabUrl:" + tabUrl);
                        if (EnvironmentManager.getInstance().isFirstStart()) {
                            return Unit.INSTANCE;
                        }
                        publishBubbleDialogKt$showPublishBubble$1.L$0 = anchor;
                        publishBubbleDialogKt$showPublishBubble$1.L$1 = tabUrl;
                        publishBubbleDialogKt$showPublishBubble$1.Z$0 = addMainDialogManager;
                        publishBubbleDialogKt$showPublishBubble$1.label = 1;
                        allowShowItem = getAllowShowItem(publishBubbleDialogKt$showPublishBubble$1);
                        if (allowShowItem == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anchor2 = anchor;
                        addMainDialogManager2 = addMainDialogManager;
                        break;
                    case 1:
                        addMainDialogManager2 = publishBubbleDialogKt$showPublishBubble$1.Z$0;
                        tabUrl = (String) publishBubbleDialogKt$showPublishBubble$1.L$1;
                        anchor2 = (TabHost) publishBubbleDialogKt$showPublishBubble$1.L$0;
                        ResultKt.throwOnFailure($result);
                        allowShowItem = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                showItem = (UpperCenterPlusBubbleService.BubbleInfo) allowShowItem;
                if (anchor2 != null && showItem != null) {
                    weakReference2 = mDialog;
                    if ((weakReference2 == null ? weakReference2.get() : null) == null && !isDialogAdded) {
                        BLog.i(TabHostGarbProviderKt.TAG, "show publish bubble init dialog");
                        PublishBubbleDialog dialogInfo = new PublishBubbleDialog();
                        dialogInfo.setPopupItem(showItem);
                        dialogInfo.setOriginTabUrl(tabUrl);
                        dialogInfo.setAnchorView(anchor2);
                        inMainDialogManager = !addMainDialogManager2;
                        mDialog = new WeakReference<>(dialogInfo);
                        if (!addMainDialogManager2) {
                            MainDialogManager.addDialog(new MainDialogManager.DialogManagerInfo("home_publish_bubble", dialogInfo, 2305), anchor2.getContext());
                            isDialogAdded = true;
                        } else {
                            dialogInfo.onShow();
                        }
                    }
                }
                weakReference = mDialog;
                if (weakReference != null && ($this$showPublishBubble_u24lambda_u241 = weakReference.get()) != null) {
                    $this$showPublishBubble_u24lambda_u241.setPopupItem(showItem);
                    $this$showPublishBubble_u24lambda_u241.setOriginTabUrl(tabUrl);
                    $this$showPublishBubble_u24lambda_u241.setAnchorView(anchor2);
                    inMainDialogManager = addMainDialogManager2;
                }
                return Unit.INSTANCE;
            }
        }
        publishBubbleDialogKt$showPublishBubble$1 = new PublishBubbleDialogKt$showPublishBubble$1(continuation);
        Object $result2 = publishBubbleDialogKt$showPublishBubble$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (publishBubbleDialogKt$showPublishBubble$1.label) {
        }
        showItem = (UpperCenterPlusBubbleService.BubbleInfo) allowShowItem;
        if (anchor2 != null) {
            weakReference2 = mDialog;
            if ((weakReference2 == null ? weakReference2.get() : null) == null) {
                BLog.i(TabHostGarbProviderKt.TAG, "show publish bubble init dialog");
                PublishBubbleDialog dialogInfo2 = new PublishBubbleDialog();
                dialogInfo2.setPopupItem(showItem);
                dialogInfo2.setOriginTabUrl(tabUrl);
                dialogInfo2.setAnchorView(anchor2);
                inMainDialogManager = !addMainDialogManager2;
                mDialog = new WeakReference<>(dialogInfo2);
                if (!addMainDialogManager2) {
                }
            }
        }
        weakReference = mDialog;
        if (weakReference != null) {
            $this$showPublishBubble_u24lambda_u241.setPopupItem(showItem);
            $this$showPublishBubble_u24lambda_u241.setOriginTabUrl(tabUrl);
            $this$showPublishBubble_u24lambda_u241.setAnchorView(anchor2);
            inMainDialogManager = addMainDialogManager2;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object showPublishBubble$default(TabHost tabHost, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return showPublishBubble(tabHost, str, z, continuation);
    }

    public static final SharedPreferences getKv() {
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference();
    }

    public static final long getLocalNow() {
        return System.currentTimeMillis();
    }

    public static final long getServerNow() {
        return ServerClock.now();
    }

    private static final int getMMaxShowCountInSevenDays() {
        return ((Number) mMaxShowCountInSevenDays$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int mMaxShowCountInSevenDays_delegate$lambda$0() {
        Integer intOrNull;
        String str = (String) ConfigManager.Companion.config().get("list.main.publish_bubble_times_per_week", LoginReporterV2.Show.LOGIN_SUCCEED_NA_PHONE_REGISTER);
        if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
            return 7;
        }
        return intOrNull.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getDelayShowTime() {
        return ((Number) delayShowTime$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long delayShowTime_delegate$lambda$0() {
        Long longOrNull;
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "main.publish_bubble_delay_show_millis", (Object) null, 2, (Object) null);
        if (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) {
            return 3000L;
        }
        return longOrNull.longValue();
    }

    private static final long getMStartTime() {
        SharedPreferences kv = getKv();
        if (kv != null) {
            return kv.getLong(KEY_START_TIME, 0L);
        }
        return 0L;
    }

    private static final void setMStartTime(long value) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        SharedPreferences kv = getKv();
        if (kv == null || (edit = kv.edit()) == null || (putLong = edit.putLong(KEY_START_TIME, value)) == null) {
            return;
        }
        putLong.apply();
    }

    private static final int getMShowTimesInSevenDays() {
        SharedPreferences kv;
        BLog.i(TabHostGarbProviderKt.TAG, "mStartTime:" + getMStartTime());
        if (getLocalNow() - getMStartTime() < SEVEN_DAYS && (kv = getKv()) != null) {
            return kv.getInt(KEY_SHOW_TIMES_SEVEN_DAYS, 0);
        }
        return 0;
    }

    private static final void setMShowTimesInSevenDays(int value) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putInt;
        SharedPreferences kv = getKv();
        if (kv == null || (edit = kv.edit()) == null || (putInt = edit.putInt(KEY_SHOW_TIMES_SEVEN_DAYS, value)) == null) {
            return;
        }
        putInt.apply();
    }

    public static final void recordShowHistory(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (getLocalNow() - getMStartTime() > SEVEN_DAYS) {
            setMStartTime(getLocalNow());
            setMShowTimesInSevenDays(1);
            return;
        }
        setMShowTimesInSevenDays(getMShowTimesInSevenDays() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getAllowShowItem(Continuation<? super UpperCenterPlusBubbleService.BubbleInfo> continuation) {
        PublishBubbleDialogKt$getAllowShowItem$1 publishBubbleDialogKt$getAllowShowItem$1;
        int showTimeInSevenDays;
        UpperCenterPlusBubbleService.BubbleInfo bubbleInfo;
        Object bubbleInfo2;
        int showTimeInSevenDays2;
        UpperCenterPlusBubbleService.BubbleInfo info;
        if (continuation instanceof PublishBubbleDialogKt$getAllowShowItem$1) {
            publishBubbleDialogKt$getAllowShowItem$1 = (PublishBubbleDialogKt$getAllowShowItem$1) continuation;
            if ((publishBubbleDialogKt$getAllowShowItem$1.label & Integer.MIN_VALUE) != 0) {
                publishBubbleDialogKt$getAllowShowItem$1.label -= Integer.MIN_VALUE;
                Object $result = publishBubbleDialogKt$getAllowShowItem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (publishBubbleDialogKt$getAllowShowItem$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        showTimeInSevenDays = getMShowTimesInSevenDays();
                        bubbleInfo = null;
                        if (showTimeInSevenDays >= getMMaxShowCountInSevenDays()) {
                            BLog.i(TabHostGarbProviderKt.TAG, "can't show bubble, mShowTimesInSevenDays:" + showTimeInSevenDays + " :" + getMMaxShowCountInSevenDays());
                            break;
                        } else {
                            BLog.i(TabHostGarbProviderKt.TAG, "invoking getBubbleInfo");
                            UpperCenterPlusBubbleService upperCenterPlusBubbleService = (UpperCenterPlusBubbleService) BLRouter.get$default(BLRouter.INSTANCE, UpperCenterPlusBubbleService.class, (String) null, 2, (Object) null);
                            if (upperCenterPlusBubbleService != null) {
                                publishBubbleDialogKt$getAllowShowItem$1.I$0 = showTimeInSevenDays;
                                publishBubbleDialogKt$getAllowShowItem$1.label = 1;
                                bubbleInfo2 = upperCenterPlusBubbleService.getBubbleInfo(publishBubbleDialogKt$getAllowShowItem$1);
                                if (bubbleInfo2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                showTimeInSevenDays2 = showTimeInSevenDays;
                                bubbleInfo = (UpperCenterPlusBubbleService.BubbleInfo) bubbleInfo2;
                                showTimeInSevenDays = showTimeInSevenDays2;
                                break;
                            }
                        }
                        break;
                    case 1:
                        showTimeInSevenDays2 = publishBubbleDialogKt$getAllowShowItem$1.I$0;
                        ResultKt.throwOnFailure($result);
                        bubbleInfo2 = $result;
                        bubbleInfo = (UpperCenterPlusBubbleService.BubbleInfo) bubbleInfo2;
                        showTimeInSevenDays = showTimeInSevenDays2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                info = bubbleInfo;
                Map $this$getAllowShowItem_u24lambda_u240_u240 = MapsKt.createMapBuilder();
                if (info != null) {
                    $this$getAllowShowItem_u24lambda_u240_u240.put("strategy_id", info.getStrategyId());
                    $this$getAllowShowItem_u24lambda_u240_u240.put("resource_id", info.getResourceId());
                    $this$getAllowShowItem_u24lambda_u240_u240.put("text_id", info.getTitleId());
                    $this$getAllowShowItem_u24lambda_u240_u240.put("text_content", info.getTitle() + "_" + info.getSubtitle());
                    String str = (String) $this$getAllowShowItem_u24lambda_u240_u240.put("resource_result_type", info.getResourceType());
                }
                $this$getAllowShowItem_u24lambda_u240_u240.put("count", String.valueOf(showTimeInSevenDays));
                $this$getAllowShowItem_u24lambda_u240_u240.put("setting", String.valueOf(getMMaxShowCountInSevenDays()));
                Unit unit = Unit.INSTANCE;
                Neurons.reportExposure$default(false, "main.homepage.bottombar-bubble.frequency.show", MapsKt.build($this$getAllowShowItem_u24lambda_u240_u240), (List) null, 8, (Object) null);
                return info;
            }
        }
        publishBubbleDialogKt$getAllowShowItem$1 = new PublishBubbleDialogKt$getAllowShowItem$1(continuation);
        Object $result2 = publishBubbleDialogKt$getAllowShowItem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (publishBubbleDialogKt$getAllowShowItem$1.label) {
        }
        info = bubbleInfo;
        Map $this$getAllowShowItem_u24lambda_u240_u2402 = MapsKt.createMapBuilder();
        if (info != null) {
        }
        $this$getAllowShowItem_u24lambda_u240_u2402.put("count", String.valueOf(showTimeInSevenDays));
        $this$getAllowShowItem_u24lambda_u240_u2402.put("setting", String.valueOf(getMMaxShowCountInSevenDays()));
        Unit unit2 = Unit.INSTANCE;
        Neurons.reportExposure$default(false, "main.homepage.bottombar-bubble.frequency.show", MapsKt.build($this$getAllowShowItem_u24lambda_u240_u2402), (List) null, 8, (Object) null);
        return info;
    }
}