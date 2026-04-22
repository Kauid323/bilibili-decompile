package tv.danmaku.bili.ui.splash.ad.button.sensor;

import android.content.Context;
import android.view.View;
import com.bilibili.app.comm.list.common.sensor.AcceleratorSensor;
import com.bilibili.app.comm.list.common.sensor.ISensor;
import com.bilibili.app.comm.list.common.sensor.RotateDegreeSensor;
import com.bilibili.app.comm.list.common.sensor.SensorSet;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.BuildConfig;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonTwistState;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.model.TwistStrategy;
import tv.danmaku.bili.ui.splash.ad.model.TwistType;
import tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorDebugKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashRotateSensorHelper.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001aL\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0002\u001a \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a8\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002\u001a0\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0002\"\u000e\u0010&\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020*X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"addRotateSensor", "", "context", "Landroid/content/Context;", "containerView", "Landroid/view/View;", "rotateView", "buttonData", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "listener", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "checkTwistState", "", "xAngle", "", "yAngle", "zAngle", "twistAngle", "twistReverseAngle", "twistStrategy", "Ltv/danmaku/bili/ui/splash/ad/model/TwistStrategy;", "state", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonTwistState;", "handleTwistStrategy", "type", "", "currAngle", "handleReverseTwistStrategy", "twistType", "angle", "leftAngle", "rightAngle", "isReachJumpState", "xReach", "yReach", "zReach", "TWIST_AXIS_X", "TWIST_AXIS_Y", "TWIST_AXIS_Z", "TAG", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashRotateSensorHelperKt {
    private static final String TAG = "[Splash]SplashRotateSensorHelper";
    private static final int TWIST_AXIS_X = 1;
    private static final int TWIST_AXIS_Y = 2;
    private static final int TWIST_AXIS_Z = 3;

    public static final void addRotateSensor(Context context, View containerView, View rotateView, final SplashGuideButton buttonData, final Splash splash, final SplashButtonClickListener listener) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(rotateView, "rotateView");
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final SensorSet sensorSet = new SensorSet();
        final SplashButtonTwistState twistState = new SplashButtonTwistState();
        if (buttonData.getTwistSpeed() >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            ISensor acceleratorSensor = new AcceleratorSensor(context2);
            acceleratorSensor.addListener(new AcceleratorSensor.SpeedChangedListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.sensor.SplashRotateSensorHelperKt$$ExternalSyntheticLambda0
                public final void onSpeedChanged(float f) {
                    SplashRotateSensorHelperKt.addRotateSensor$lambda$0(SplashGuideButton.this, sensorSet, listener, f);
                }
            });
            sensorSet.addSensor(acceleratorSensor);
        }
        if (buttonData.getTwistAngle() >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            ISensor rotateDegreeSensor = new RotateDegreeSensor(context2);
            rotateDegreeSensor.addListener(new RotateDegreeSensor.RotateListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.sensor.SplashRotateSensorHelperKt$$ExternalSyntheticLambda1
                public final void onDegreeChanged(float[] fArr) {
                    SplashRotateSensorHelperKt.addRotateSensor$lambda$1(SplashGuideButton.this, twistState, splash, sensorSet, listener, fArr);
                }
            });
            sensorSet.addSensor(rotateDegreeSensor);
        }
        if (!sensorSet.isEmpty()) {
            rotateView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.sensor.SplashRotateSensorHelperKt$addRotateSensor$3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    ISensor.-CC.start$default(sensorSet, 0, 1, (Object) null);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    sensorSet.stop();
                }
            });
        }
        if (BuildConfig.DEBUG) {
            SplashSensorDebugKt.addTwistDebugView(containerView, sensorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRotateSensor$lambda$0(SplashGuideButton $buttonData, SensorSet $sensorSet, SplashButtonClickListener $listener, float speed) {
        if (speed >= $buttonData.getTwistSpeed()) {
            $sensorSet.clear();
            $listener.onShake($buttonData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRotateSensor$lambda$1(SplashGuideButton $buttonData, SplashButtonTwistState $twistState, Splash $splash, SensorSet $sensorSet, SplashButtonClickListener $listener, float[] degreesDelta) {
        Intrinsics.checkNotNullParameter(degreesDelta, "degreesDelta");
        float xAngle = (float) Math.toDegrees(degreesDelta[0]);
        float yAngle = (float) Math.toDegrees(degreesDelta[1]);
        float zAngle = (float) Math.toDegrees(degreesDelta[2]);
        boolean qualifyAngleConstrict = checkTwistState(xAngle, yAngle, zAngle, $buttonData.getTwistAngle(), $buttonData.getTwistReverseAngle(), $buttonData.getTwistStrategy(), $twistState, $splash);
        if (qualifyAngleConstrict) {
            $sensorSet.clear();
            float twistAngle = $buttonData.getTwistAngle();
            BLog.i(TAG, "trigger jump angle, twistAngle = " + twistAngle + ", twistReverseAngle = " + $buttonData.getTwistReverseAngle() + " xAngle = " + xAngle + ", yAngle =  " + yAngle + ",  zAngle = " + zAngle);
            $listener.onRotate($buttonData);
        }
    }

    static /* synthetic */ boolean checkTwistState$default(float f, float f2, float f3, float f4, float f5, TwistStrategy twistStrategy, SplashButtonTwistState splashButtonTwistState, Splash splash, int i, Object obj) {
        TwistStrategy twistStrategy2;
        if ((i & 32) == 0) {
            twistStrategy2 = twistStrategy;
        } else {
            twistStrategy2 = null;
        }
        return checkTwistState(f, f2, f3, f4, f5, twistStrategy2, splashButtonTwistState, splash);
    }

    private static final boolean checkTwistState(float xAngle, float yAngle, float zAngle, float twistAngle, float twistReverseAngle, TwistStrategy twistStrategy, SplashButtonTwistState state, Splash splash) {
        boolean zReach;
        boolean xReach;
        boolean yReach;
        if (BuildConfig.DEBUG) {
            BLog.i(TAG, "xAngle = " + xAngle + ", yAngle =  " + yAngle + ",  zAngle = " + zAngle);
        }
        if (twistStrategy == null) {
            if (Math.max(Math.abs(xAngle), Math.max(Math.abs(yAngle), Math.abs(zAngle))) >= twistAngle) {
                return true;
            }
            return false;
        }
        if (twistReverseAngle <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            xReach = handleTwistStrategy(twistStrategy.getXType(), xAngle, twistAngle);
            yReach = handleTwistStrategy(twistStrategy.getYType(), -yAngle, twistAngle);
            zReach = handleTwistStrategy(twistStrategy.getZType(), zAngle, twistAngle);
        } else {
            state.setLeftAngleX(Math.min(state.getLeftAngleX(), xAngle));
            state.setLeftAngleY(Math.min(state.getLeftAngleY(), -yAngle));
            state.setLeftAngleZ(Math.min(state.getLeftAngleZ(), zAngle));
            state.setRightAngleX(Math.max(state.getRightAngleX(), xAngle));
            state.setRightAngleY(Math.max(state.getRightAngleY(), -yAngle));
            state.setRightAngleZ(Math.max(state.getRightAngleZ(), zAngle));
            boolean xReach2 = handleReverseTwistStrategy(twistStrategy.getXType(), xAngle, state.getLeftAngleX(), state.getRightAngleX(), twistAngle, twistReverseAngle);
            boolean yReach2 = handleReverseTwistStrategy(twistStrategy.getYType(), -yAngle, state.getLeftAngleY(), state.getRightAngleY(), twistAngle, twistReverseAngle);
            zReach = handleReverseTwistStrategy(twistStrategy.getZType(), zAngle, state.getLeftAngleZ(), state.getRightAngleZ(), twistAngle, twistReverseAngle);
            xReach = xReach2;
            yReach = yReach2;
        }
        return isReachJumpState(xReach, yReach, zReach, twistStrategy, splash);
    }

    private static final boolean handleTwistStrategy(int type, float currAngle, float twistAngle) {
        if (Math.abs(currAngle) >= twistAngle && type != TwistType.NONE.getValue()) {
            return type == TwistType.LEFT_TRIGGER.getValue() ? currAngle <= (-twistAngle) : type != TwistType.RIGHT_TRIGGER.getValue() || currAngle >= twistAngle;
        }
        return false;
    }

    private static final boolean handleReverseTwistStrategy(int twistType, float angle, float leftAngle, float rightAngle, float twistAngle, float twistReverseAngle) {
        if (twistType == TwistType.NONE.getValue()) {
            return false;
        }
        return twistType == TwistType.LEFT_TRIGGER.getValue() ? leftAngle <= (-twistAngle) && angle >= leftAngle + twistReverseAngle : twistType == TwistType.RIGHT_TRIGGER.getValue() ? rightAngle >= twistAngle && angle <= rightAngle - twistReverseAngle : (leftAngle <= (-twistAngle) && angle >= leftAngle + twistReverseAngle) || (rightAngle >= twistAngle && angle <= rightAngle - twistReverseAngle);
    }

    private static final boolean isReachJumpState(boolean xReach, boolean yReach, boolean zReach, TwistStrategy twistStrategy, Splash splash) {
        if (xReach || yReach || zReach) {
            if (xReach) {
                SplashAdHelper.reportSplashTwist(splash, 1, twistStrategy.getXType());
                return true;
            } else if (yReach) {
                SplashAdHelper.reportSplashTwist(splash, 2, twistStrategy.getYType());
                return true;
            } else {
                SplashAdHelper.reportSplashTwist(splash, 3, twistStrategy.getZType());
                return true;
            }
        }
        return false;
    }
}