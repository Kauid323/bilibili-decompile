package tv.danmaku.bili.ui.splash.utils.sensor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bilibili.app.comm.list.common.sensor.AcceleratorSensor;
import com.bilibili.app.comm.list.common.sensor.ISensor;
import com.bilibili.app.comm.list.common.sensor.RotateDegreeSensor;
import com.bilibili.app.comm.list.common.sensor.SensorSet;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.BuildConfig;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.widget.SplashRunningBallView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashSensorDebug.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¨\u0006\u000f"}, d2 = {"addTwistDebugView", "", "rootView", "Landroid/view/View;", "sensorSet", "Lcom/bilibili/app/comm/list/common/sensor/SensorSet;", "addRunningBallDebugView", "roundStr", "", "", "isDebugSensorEnable", "", "context", "Landroid/content/Context;", "disableSplashSensor", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashSensorDebugKt {
    public static final void addTwistDebugView(final View rootView, SensorSet sensorSet) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(sensorSet, "sensorSet");
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (!isDebugSensorEnable(context)) {
            return;
        }
        final View contentView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.bili_app_splash_sensor_twist_debug, (ViewGroup) new FrameLayout(rootView.getContext()), false);
        View findViewById = contentView.findViewById(R.id.text1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        final TextView title1 = (TextView) findViewById;
        View findViewById2 = contentView.findViewById(R.id.text2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        final TextView title2 = (TextView) findViewById2;
        View findViewById3 = contentView.findViewById(R.id.text3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        final TextView title3 = (TextView) findViewById3;
        View findViewById4 = contentView.findViewById(R.id.text4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        final TextView title4 = (TextView) findViewById4;
        Iterator it = sensorSet.getSensors().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISensor it2 = (ISensor) obj;
            if (it2 instanceof RotateDegreeSensor) {
                break;
            }
        }
        RotateDegreeSensor rotateSensor = obj instanceof RotateDegreeSensor ? (RotateDegreeSensor) obj : null;
        Iterator it3 = sensorSet.getSensors().iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            ISensor it4 = (ISensor) obj2;
            if (it4 instanceof AcceleratorSensor) {
                break;
            }
        }
        AcceleratorSensor accSensor = obj2 instanceof AcceleratorSensor ? (AcceleratorSensor) obj2 : null;
        if (rotateSensor != null) {
            rotateSensor.addListener(new RotateDegreeSensor.RotateListener() { // from class: tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorDebugKt$$ExternalSyntheticLambda0
                public final void onDegreeChanged(float[] fArr) {
                    SplashSensorDebugKt.addTwistDebugView$lambda$2(title1, title2, title3, fArr);
                }
            });
        } else {
            title1.setVisibility(8);
            title2.setVisibility(8);
            title3.setVisibility(8);
        }
        if (accSensor != null) {
            accSensor.addListener(new AcceleratorSensor.SpeedChangedListener() { // from class: tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorDebugKt$$ExternalSyntheticLambda1
                public final void onSpeedChanged(float f) {
                    SplashSensorDebugKt.addTwistDebugView$lambda$3(title4, f);
                }
            });
        } else {
            title3.setVisibility(8);
        }
        if (rootView.isAttachedToWindow()) {
            ViewParent parent = rootView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.addView(contentView);
                return;
            }
            return;
        }
        rootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorDebugKt$addTwistDebugView$$inlined$doOnAttach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                rootView.removeOnAttachStateChangeListener(this);
                ViewParent parent2 = view2.getParent();
                ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                if (viewGroup2 != null) {
                    viewGroup2.addView(contentView);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTwistDebugView$lambda$2(TextView $title1, TextView $title2, TextView $title3, float[] degrees) {
        Intrinsics.checkNotNullParameter(degrees, "degrees");
        $title1.setText("角度 X：" + roundStr(degrees[0]));
        $title2.setText("角度 Y：" + roundStr(degrees[1]));
        $title3.setText("角度 Z：" + roundStr(degrees[2]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTwistDebugView$lambda$3(TextView $title4, float accSpeed) {
        $title4.setText("加速度: " + roundStr(accSpeed));
    }

    public static final void addRunningBallDebugView(final View rootView, SensorSet sensorSet) {
        Object obj;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(sensorSet, "sensorSet");
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (!isDebugSensorEnable(context)) {
            return;
        }
        final View contentView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.bili_app_splash_sensor_runningball_debug, (ViewGroup) new FrameLayout(rootView.getContext()), false);
        View findViewById = contentView.findViewById(R.id.text1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        final TextView title1 = (TextView) findViewById;
        Iterator it = sensorSet.getSensors().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISensor it2 = (ISensor) obj;
            if (it2 instanceof RotateDegreeSensor) {
                break;
            }
        }
        RotateDegreeSensor rotateSensor = obj instanceof RotateDegreeSensor ? (RotateDegreeSensor) obj : null;
        if (rotateSensor != null) {
            rotateSensor.addListener(new RotateDegreeSensor.RotateListener() { // from class: tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorDebugKt$$ExternalSyntheticLambda2
                public final void onDegreeChanged(float[] fArr) {
                    SplashSensorDebugKt.addRunningBallDebugView$lambda$1(title1, fArr);
                }
            });
        } else {
            title1.setVisibility(8);
        }
        if (rootView.isAttachedToWindow()) {
            ViewParent parent = rootView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.addView(contentView);
                return;
            }
            return;
        }
        rootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorDebugKt$addRunningBallDebugView$$inlined$doOnAttach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                rootView.removeOnAttachStateChangeListener(this);
                ViewParent parent2 = view2.getParent();
                ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
                if (viewGroup2 != null) {
                    viewGroup2.addView(contentView);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addRunningBallDebugView$lambda$1(TextView $title1, float[] degreesDelta) {
        Intrinsics.checkNotNullParameter(degreesDelta, "degreesDelta");
        $title1.setText(roundStr((float) Math.toDegrees(SplashRunningBallView.Companion.adjustRadian(degreesDelta))) + "°");
    }

    private static final String roundStr(float $this$roundStr) {
        DecimalFormat format = new DecimalFormat("0.#");
        format.setRoundingMode(RoundingMode.FLOOR);
        String format2 = format.format(Float.valueOf($this$roundStr));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    private static final boolean isDebugSensorEnable(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        return BuildConfig.DEBUG && BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2).getBoolean("splash_is_sensor_debug_enable", true);
    }

    public static final boolean disableSplashSensor(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return BuildConfig.DEBUG && BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2).getBoolean("disable_splash_debug_sensor", false);
    }
}