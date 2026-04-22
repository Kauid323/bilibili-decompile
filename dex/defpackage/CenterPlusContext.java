package defpackage;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: CenterPlusConstant.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"LCenterPlusContext;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "jumpParams", "", "getJumpParams", "()Ljava/lang/String;", "setJumpParams", "(Ljava/lang/String;)V", "isFromCenterPlus", "", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "editor_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: CenterPlusContext  reason: default package */
public final class CenterPlusContext implements DefaultLifecycleObserver {
    public static final CenterPlusContext INSTANCE = new CenterPlusContext();
    private static String jumpParams = "";

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, lifecycleOwner);
    }

    private CenterPlusContext() {
    }

    public final String getJumpParams() {
        return jumpParams;
    }

    public final void setJumpParams(String str) {
        jumpParams = str;
    }

    public final boolean isFromCenterPlus() {
        return CenterPlusConstantKt.isFromCenterPlus(jumpParams);
    }

    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        DefaultLifecycleObserver.-CC.$default$onDestroy(this, owner);
        BLog.i("CenterPlusConstantKt", "CenterPlusContext onDestroy: jumpParams=" + jumpParams);
        jumpParams = "";
    }
}