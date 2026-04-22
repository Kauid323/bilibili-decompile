package tv.danmaku.bili.videopage.common.segment;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.view.OrientationEventListener;
import androidx.fragment.app.FragmentActivity;
import com.bapis.bilibili.app.distribution.BoolValue;
import com.bapis.bilibili.app.distribution.setting.play.PlayConfig;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.device.settings.generated.api.DistributionSettings;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.common.segment.SystemGravityHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WindowStateManageSegment.kt */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001 \b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0015\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J\u0015\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\rH\u0000¢\u0006\u0002\b1J\r\u00102\u001a\u00020+H\u0000¢\u0006\u0002\b3J\r\u00104\u001a\u00020+H\u0000¢\u0006\u0002\b5J\r\u00106\u001a\u00020+H\u0000¢\u0006\u0002\b7J\r\u00108\u001a\u00020+H\u0000¢\u0006\u0002\b9J\r\u0010:\u001a\u00020+H\u0000¢\u0006\u0002\b;J\r\u0010<\u001a\u00020+H\u0000¢\u0006\u0002\b=J\r\u0010>\u001a\u00020\u0007H\u0000¢\u0006\u0002\b?R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/OrientationChangeProcessor;", "", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "onlyHorizontalRotationEnable", "", "getOnlyHorizontalRotationEnable$videopagecommon_apinkDebug", "()Z", "setOnlyHorizontalRotationEnable$videopagecommon_apinkDebug", "(Z)V", "mCurrentOrientation", "", "mSystemGravityHelper", "Ltv/danmaku/bili/videopage/common/segment/SystemGravityHelper;", "mTargetOrientation", "mSystemGravityEnable", "mDistributionPlayConfig", "Lcom/bilibili/lib/device/settings/generated/api/DistributionSettings;", "mIsAppScreenRotateEnable", "gravityEnableDispatcherList", "Ljava/util/HashMap;", "Ltv/danmaku/bili/videopage/common/segment/GravityEnableDispatcher;", "", "Lkotlin/collections/HashMap;", "getGravityEnableDispatcherList$videopagecommon_apinkDebug", "()Ljava/util/HashMap;", "setGravityEnableDispatcherList$videopagecommon_apinkDebug", "(Ljava/util/HashMap;)V", "mGravitySensorEnable", "mSystemGravityChangedListener", "tv/danmaku/bili/videopage/common/segment/OrientationChangeProcessor$mSystemGravityChangedListener$1", "Ltv/danmaku/bili/videopage/common/segment/OrientationChangeProcessor$mSystemGravityChangedListener$1;", "mRecorrectOrientationRunnable", "Ljava/lang/Runnable;", "mOrientationEventListener", "Landroid/view/OrientationEventListener;", "isActivityPortriat", "gravityEnableCheckFromDiapatcher", "isAppEnableGravityRotate", "isInMultiWindowMode", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onConfigurationChanged$videopagecommon_apinkDebug", "switchScreenOrientation", "orientation", "switchScreenOrientation$videopagecommon_apinkDebug", "switchToSuitablePortriat", "switchToSuitablePortriat$videopagecommon_apinkDebug", "switchToSuitableLandscape", "switchToSuitableLandscape$videopagecommon_apinkDebug", "start", "start$videopagecommon_apinkDebug", "stop", "stop$videopagecommon_apinkDebug", "startGravitySensor", "startGravitySensor$videopagecommon_apinkDebug", "stopGravitySensor", "stopGravitySensor$videopagecommon_apinkDebug", "onBackPressed", "onBackPressed$videopagecommon_apinkDebug", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OrientationChangeProcessor {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "OrientationChangeProcessor";
    private HashMap<GravityEnableDispatcher, String> gravityEnableDispatcherList;
    private final FragmentActivity mActivity;
    private int mCurrentOrientation;
    private DistributionSettings mDistributionPlayConfig;
    private boolean mGravitySensorEnable;
    private boolean mIsAppScreenRotateEnable;
    private final OrientationEventListener mOrientationEventListener;
    private final Runnable mRecorrectOrientationRunnable;
    private final OrientationChangeProcessor$mSystemGravityChangedListener$1 mSystemGravityChangedListener;
    private boolean mSystemGravityEnable;
    private final SystemGravityHelper mSystemGravityHelper;
    private int mTargetOrientation;
    private boolean onlyHorizontalRotationEnable;

    /* compiled from: WindowStateManageSegment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/OrientationChangeProcessor$Companion;", "", "<init>", "()V", "TAG", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.bili.videopage.common.segment.OrientationChangeProcessor$mSystemGravityChangedListener$1] */
    public OrientationChangeProcessor(FragmentActivity mActivity) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.mActivity = mActivity;
        this.mCurrentOrientation = 1;
        Context applicationContext = this.mActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.mSystemGravityHelper = new SystemGravityHelper(applicationContext, new Handler());
        this.mTargetOrientation = 1;
        SystemGravityHelper.Companion companion = SystemGravityHelper.Companion;
        Context applicationContext2 = this.mActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        this.mSystemGravityEnable = companion.getGravityOpenStatus(applicationContext2);
        this.mDistributionPlayConfig = (DistributionSettings) BLRouter.get$default(BLRouter.INSTANCE, DistributionSettings.class, (String) null, 2, (Object) null);
        this.mIsAppScreenRotateEnable = true;
        this.gravityEnableDispatcherList = new HashMap<>();
        this.mSystemGravityChangedListener = new SystemGravityHelper.OnSystemGravityChangedListener() { // from class: tv.danmaku.bili.videopage.common.segment.OrientationChangeProcessor$mSystemGravityChangedListener$1
            @Override // tv.danmaku.bili.videopage.common.segment.SystemGravityHelper.OnSystemGravityChangedListener
            public void onOpen() {
                OrientationChangeProcessor.this.mSystemGravityEnable = true;
                BLog.i("OrientationChangeProcessor", "System gravity is opened now");
            }

            @Override // tv.danmaku.bili.videopage.common.segment.SystemGravityHelper.OnSystemGravityChangedListener
            public void onClose() {
                OrientationChangeProcessor.this.mSystemGravityEnable = false;
                BLog.i("OrientationChangeProcessor", "System gravity is closed now");
            }
        };
        this.mRecorrectOrientationRunnable = new Runnable() { // from class: tv.danmaku.bili.videopage.common.segment.OrientationChangeProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OrientationChangeProcessor.mRecorrectOrientationRunnable$lambda$0(OrientationChangeProcessor.this);
            }
        };
        final Application application = BiliContext.application();
        this.mOrientationEventListener = new OrientationEventListener(application) { // from class: tv.danmaku.bili.videopage.common.segment.OrientationChangeProcessor$mOrientationEventListener$1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                int i;
                int i2;
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                boolean gravityEnableCheckFromDiapatcher;
                int i3;
                int i4;
                int i5;
                boolean z5;
                boolean isActivityPortriat;
                boolean gravityEnableCheckFromDiapatcher2;
                int i6;
                boolean z6;
                boolean z7;
                int i7;
                int i8;
                boolean z8;
                boolean isActivityPortriat2;
                boolean gravityEnableCheckFromDiapatcher3;
                int i9;
                boolean z9;
                boolean z10;
                int i10;
                int i11;
                boolean z11;
                boolean z12;
                boolean z13;
                boolean z14;
                boolean gravityEnableCheckFromDiapatcher4;
                int i12;
                if (orientation <= -1) {
                    BLog.e("OrientationChangeProcessor", "Can't auto rotate, illegal orientation: " + orientation);
                    return;
                }
                boolean z15 = true;
                if (!(350 <= orientation && orientation < 361)) {
                    if (!(orientation >= 0 && orientation < 11)) {
                        if (170 <= orientation && orientation < 191) {
                            i10 = OrientationChangeProcessor.this.mCurrentOrientation;
                            if (i10 != 9) {
                                OrientationChangeProcessor.this.mCurrentOrientation = 9;
                                i11 = OrientationChangeProcessor.this.mCurrentOrientation;
                                BLog.e("OrientationChangeProcessor", "Current orientation: " + i11);
                                z11 = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                                if (z11) {
                                    z14 = OrientationChangeProcessor.this.mSystemGravityEnable;
                                    if (z14) {
                                        if (!OrientationChangeProcessor.this.getOnlyHorizontalRotationEnable$videopagecommon_apinkDebug()) {
                                            gravityEnableCheckFromDiapatcher4 = OrientationChangeProcessor.this.gravityEnableCheckFromDiapatcher();
                                            if (gravityEnableCheckFromDiapatcher4) {
                                                OrientationChangeProcessor orientationChangeProcessor = OrientationChangeProcessor.this;
                                                i12 = OrientationChangeProcessor.this.mCurrentOrientation;
                                                orientationChangeProcessor.switchScreenOrientation$videopagecommon_apinkDebug(i12);
                                                BLog.i("OrientationChangeProcessor", "gravity to reverse portrait");
                                                return;
                                            }
                                            return;
                                        }
                                        BLog.e("OrientationChangeProcessor", "Can't rotate, only horizontal rotation enable.");
                                        return;
                                    }
                                }
                                z12 = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                                z13 = OrientationChangeProcessor.this.mSystemGravityEnable;
                                BLog.e("OrientationChangeProcessor", "Can't rotate, app rotate:" + z12 + ", system rotate:" + z13);
                                return;
                            }
                            return;
                        }
                        if (80 <= orientation && orientation < 101) {
                            i7 = OrientationChangeProcessor.this.mCurrentOrientation;
                            if (i7 != 8) {
                                OrientationChangeProcessor.this.mCurrentOrientation = 8;
                                i8 = OrientationChangeProcessor.this.mCurrentOrientation;
                                BLog.e("OrientationChangeProcessor", "Current orientation: " + i8);
                                z8 = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                                if (!z8) {
                                    z10 = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                                    BLog.e("OrientationChangeProcessor", "Can't rotate, app rotate:" + z10);
                                    return;
                                }
                                isActivityPortriat2 = OrientationChangeProcessor.this.isActivityPortriat();
                                if (isActivityPortriat2) {
                                    z9 = OrientationChangeProcessor.this.mSystemGravityEnable;
                                    if (!z9) {
                                        BLog.i("OrientationChangeProcessor", "Can't auto rotate, system gravity disable and current activity is portriat");
                                        return;
                                    }
                                }
                                gravityEnableCheckFromDiapatcher3 = OrientationChangeProcessor.this.gravityEnableCheckFromDiapatcher();
                                if (gravityEnableCheckFromDiapatcher3) {
                                    OrientationChangeProcessor orientationChangeProcessor2 = OrientationChangeProcessor.this;
                                    i9 = OrientationChangeProcessor.this.mCurrentOrientation;
                                    orientationChangeProcessor2.switchScreenOrientation$videopagecommon_apinkDebug(i9);
                                    BLog.i("OrientationChangeProcessor", "gravity to reverse landscape");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (260 > orientation || orientation >= 281) {
                            z15 = false;
                        }
                        if (z15) {
                            i4 = OrientationChangeProcessor.this.mCurrentOrientation;
                            if (i4 != 0) {
                                OrientationChangeProcessor.this.mCurrentOrientation = 0;
                                i5 = OrientationChangeProcessor.this.mCurrentOrientation;
                                BLog.e("OrientationChangeProcessor", "Current orientation: " + i5);
                                z5 = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                                if (!z5) {
                                    z7 = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                                    BLog.e("OrientationChangeProcessor", "Can't rotate, app rotate:" + z7);
                                    return;
                                }
                                isActivityPortriat = OrientationChangeProcessor.this.isActivityPortriat();
                                if (isActivityPortriat) {
                                    z6 = OrientationChangeProcessor.this.mSystemGravityEnable;
                                    if (!z6) {
                                        BLog.i("OrientationChangeProcessor", "Can't auto rotate, system gravity disable and current activity is portriat");
                                        return;
                                    }
                                }
                                gravityEnableCheckFromDiapatcher2 = OrientationChangeProcessor.this.gravityEnableCheckFromDiapatcher();
                                if (gravityEnableCheckFromDiapatcher2) {
                                    OrientationChangeProcessor orientationChangeProcessor3 = OrientationChangeProcessor.this;
                                    i6 = OrientationChangeProcessor.this.mCurrentOrientation;
                                    orientationChangeProcessor3.switchScreenOrientation$videopagecommon_apinkDebug(i6);
                                    BLog.i("OrientationChangeProcessor", "gravity to landscape");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                i = OrientationChangeProcessor.this.mCurrentOrientation;
                if (i != 1) {
                    OrientationChangeProcessor.this.mCurrentOrientation = 1;
                    i2 = OrientationChangeProcessor.this.mCurrentOrientation;
                    BLog.e("OrientationChangeProcessor", "Current orientation: " + i2);
                    z = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                    if (z) {
                        z4 = OrientationChangeProcessor.this.mSystemGravityEnable;
                        if (z4) {
                            if (!OrientationChangeProcessor.this.getOnlyHorizontalRotationEnable$videopagecommon_apinkDebug()) {
                                gravityEnableCheckFromDiapatcher = OrientationChangeProcessor.this.gravityEnableCheckFromDiapatcher();
                                if (gravityEnableCheckFromDiapatcher) {
                                    OrientationChangeProcessor orientationChangeProcessor4 = OrientationChangeProcessor.this;
                                    i3 = OrientationChangeProcessor.this.mCurrentOrientation;
                                    orientationChangeProcessor4.switchScreenOrientation$videopagecommon_apinkDebug(i3);
                                    BLog.i("OrientationChangeProcessor", "gravity to portrait");
                                    return;
                                }
                                return;
                            }
                            BLog.e("OrientationChangeProcessor", "Can't rotate, only horizontal rotation enable.");
                            return;
                        }
                    }
                    z2 = OrientationChangeProcessor.this.mIsAppScreenRotateEnable;
                    z3 = OrientationChangeProcessor.this.mSystemGravityEnable;
                    BLog.e("OrientationChangeProcessor", "Can't rotate, app rotate:" + z2 + ", system rotate:" + z3);
                }
            }
        };
    }

    public final boolean getOnlyHorizontalRotationEnable$videopagecommon_apinkDebug() {
        return this.onlyHorizontalRotationEnable;
    }

    public final void setOnlyHorizontalRotationEnable$videopagecommon_apinkDebug(boolean z) {
        this.onlyHorizontalRotationEnable = z;
    }

    public final HashMap<GravityEnableDispatcher, String> getGravityEnableDispatcherList$videopagecommon_apinkDebug() {
        return this.gravityEnableDispatcherList;
    }

    public final void setGravityEnableDispatcherList$videopagecommon_apinkDebug(HashMap<GravityEnableDispatcher, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.gravityEnableDispatcherList = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRecorrectOrientationRunnable$lambda$0(OrientationChangeProcessor this$0) {
        BLog.i(TAG, "Recorrect orientation.");
        this$0.switchScreenOrientation$videopagecommon_apinkDebug(this$0.mTargetOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isActivityPortriat() {
        return this.mActivity.getRequestedOrientation() == 1 || this.mActivity.getRequestedOrientation() == 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean gravityEnableCheckFromDiapatcher() {
        Map $this$forEach$iv = this.gravityEnableDispatcherList;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            if (!element$iv.getKey().dispatchGravityEnable()) {
                BLog.i(TAG, "Gravity disable, from:" + ((Object) element$iv.getValue()));
                return false;
            }
        }
        return true;
    }

    private final boolean isAppEnableGravityRotate() {
        DistributionSettings distributionSettings;
        PlayConfig playConfig;
        BoolValue enableGravityRotateScreen;
        PlayConfig playConfig2;
        DistributionSettings distributionSettings2 = this.mDistributionPlayConfig;
        boolean z = false;
        if (distributionSettings2 != null && (playConfig2 = distributionSettings2.getPlayConfig()) != null && playConfig2.hasEnableGravityRotateScreen()) {
            z = true;
        }
        if (!z || (distributionSettings = this.mDistributionPlayConfig) == null || (playConfig = distributionSettings.getPlayConfig()) == null || (enableGravityRotateScreen = playConfig.getEnableGravityRotateScreen()) == null) {
            return true;
        }
        return enableGravityRotateScreen.getValue();
    }

    private final boolean isInMultiWindowMode() {
        return Build.VERSION.SDK_INT >= 24 && this.mActivity.isInMultiWindowMode();
    }

    public final void onConfigurationChanged$videopagecommon_apinkDebug(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (!isInMultiWindowMode()) {
            HandlerThreads.remove(0, this.mRecorrectOrientationRunnable);
            if (newConfig.orientation == 1) {
                if (this.mTargetOrientation != 1 && this.mTargetOrientation != 9) {
                    HandlerThreads.postDelayed(0, this.mRecorrectOrientationRunnable, 1000L);
                }
            } else if (newConfig.orientation == 2 && this.mTargetOrientation != 0 && this.mTargetOrientation != 8) {
                HandlerThreads.postDelayed(0, this.mRecorrectOrientationRunnable, 1000L);
            }
        }
    }

    public final void switchScreenOrientation$videopagecommon_apinkDebug(int orientation) {
        if (!isInMultiWindowMode()) {
            this.mTargetOrientation = orientation;
        } else {
            BLog.i(TAG, "redundant requestedOrientation " + orientation);
        }
        BLog.i(TAG, "switch screen orientation to " + orientation + ", current orientation is " + this.mActivity.getRequestedOrientation());
        this.mActivity.setRequestedOrientation(orientation);
    }

    public final void switchToSuitablePortriat$videopagecommon_apinkDebug() {
        if (this.mCurrentOrientation == 9 && this.mSystemGravityEnable && this.mIsAppScreenRotateEnable) {
            switchScreenOrientation$videopagecommon_apinkDebug(9);
        } else {
            switchScreenOrientation$videopagecommon_apinkDebug(1);
        }
    }

    public final void switchToSuitableLandscape$videopagecommon_apinkDebug() {
        if (this.mCurrentOrientation == 8) {
            switchScreenOrientation$videopagecommon_apinkDebug(8);
        } else {
            switchScreenOrientation$videopagecommon_apinkDebug(0);
        }
    }

    public final void start$videopagecommon_apinkDebug() {
        startGravitySensor$videopagecommon_apinkDebug();
        this.mSystemGravityHelper.startObserver();
        this.mSystemGravityHelper.setChangedListener(this.mSystemGravityChangedListener);
    }

    public final void stop$videopagecommon_apinkDebug() {
        stopGravitySensor$videopagecommon_apinkDebug();
        this.mSystemGravityHelper.stopObserver();
        this.mSystemGravityHelper.setChangedListener(null);
    }

    public final void startGravitySensor$videopagecommon_apinkDebug() {
        if (this.mGravitySensorEnable) {
            return;
        }
        this.mGravitySensorEnable = true;
        this.mIsAppScreenRotateEnable = isAppEnableGravityRotate();
        if (this.mOrientationEventListener.canDetectOrientation()) {
            this.mOrientationEventListener.enable();
            BLog.i(TAG, "Start gravity sensor, app screen rotate enable: " + this.mIsAppScreenRotateEnable);
            return;
        }
        BLog.e(TAG, "Cannot detect orientation!!");
    }

    public final void stopGravitySensor$videopagecommon_apinkDebug() {
        if (!this.mGravitySensorEnable) {
            return;
        }
        this.mGravitySensorEnable = false;
        this.mOrientationEventListener.disable();
        BLog.i(TAG, "Stop gravity sensor");
    }

    public final boolean onBackPressed$videopagecommon_apinkDebug() {
        BLog.i(TAG, "onBackPressed");
        if (this.mActivity.getRequestedOrientation() == 0 || this.mActivity.getRequestedOrientation() == 8) {
            switchScreenOrientation$videopagecommon_apinkDebug(1);
            return true;
        }
        BLog.i(TAG, "onBackPressed not resolve.");
        return false;
    }
}