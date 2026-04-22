package tv.danmaku.bili.videopage.foundation.event;

import android.content.res.Configuration;
import android.view.KeyEvent;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ILifecycleStateEventObserver.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/foundation/event/ILifecycleStateEventObserver;", "", "onCreate", "", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "", "onWindowFocusChanged", "hasFocus", "onKeyEvent", "keyEvent", "Landroid/view/KeyEvent;", "videopagefoundation_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ILifecycleStateEventObserver {
    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    boolean onKeyEvent(KeyEvent keyEvent);

    void onMultiWindowModeChanged(boolean z);

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void onWindowFocusChanged(boolean z);

    /* compiled from: ILifecycleStateEventObserver.kt */
    /* renamed from: tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onCreate(ILifecycleStateEventObserver _this) {
        }

        public static void $default$onStart(ILifecycleStateEventObserver _this) {
        }

        public static void $default$onResume(ILifecycleStateEventObserver _this) {
        }

        public static void $default$onPause(ILifecycleStateEventObserver _this) {
        }

        public static void $default$onStop(ILifecycleStateEventObserver _this) {
        }

        public static void $default$onDestroy(ILifecycleStateEventObserver _this) {
        }

        public static void $default$onConfigurationChanged(ILifecycleStateEventObserver _this, Configuration newConfig) {
        }

        public static void $default$onMultiWindowModeChanged(ILifecycleStateEventObserver _this, boolean isInMultiWindowMode) {
        }

        public static void $default$onWindowFocusChanged(ILifecycleStateEventObserver _this, boolean hasFocus) {
        }

        public static boolean $default$onKeyEvent(ILifecycleStateEventObserver _this, KeyEvent keyEvent) {
            return false;
        }
    }
}