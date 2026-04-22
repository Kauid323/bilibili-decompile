package tv.danmaku.biliplayerv2;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ControlContainerConfig.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#RZ\u0010&\u001aB\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u0019\u0018\u00010'j \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u0019\u0018\u0001`(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#R5\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u001f0@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006I"}, d2 = {"Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "", "<init>", "()V", "layoutRes", "", "getLayoutRes", "()I", "setLayoutRes", "(I)V", "layoutView", "Lkotlin/Function0;", "Landroid/view/ViewGroup;", "getLayoutView", "()Lkotlin/jvm/functions/Function0;", "setLayoutView", "(Lkotlin/jvm/functions/Function0;)V", "containerId", "getContainerId", "()Ljava/lang/Integer;", "setContainerId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "alwaysShowIds", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getAlwaysShowIds", "()Ljava/util/HashSet;", "setAlwaysShowIds", "(Ljava/util/HashSet;)V", "alwaysShowRunning", "", "getAlwaysShowRunning", "()Z", "setAlwaysShowRunning", "(Z)V", "isAlwaysShowing", "setAlwaysShowing", "immersiveVisibleIds", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getImmersiveVisibleIds", "()Ljava/util/HashMap;", "setImmersiveVisibleIds", "(Ljava/util/HashMap;)V", "screenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "getScreenModeType", "()Ltv/danmaku/biliplayerv2/ScreenModeType;", "setScreenModeType", "(Ltv/danmaku/biliplayerv2/ScreenModeType;)V", "bottomSubtitleBlock", "getBottomSubtitleBlock", "setBottomSubtitleBlock", "instance", "Landroid/view/View;", "getInstance", "()Landroid/view/View;", "setInstance", "(Landroid/view/View;)V", "enable", "getEnable", "setEnable", "hideControlAfterImmersive", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "getHideControlAfterImmersive", "()Lkotlin/jvm/functions/Function1;", "setHideControlAfterImmersive", "(Lkotlin/jvm/functions/Function1;)V", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ControlContainerConfig {
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_IMMERSIVE_SEEK_BAR = 1;
    public static final int TYPE_IMMERSIVE_SEEK_THUMBNAIL = 2;
    private HashSet<Integer> alwaysShowIds;
    private boolean alwaysShowRunning;
    private int bottomSubtitleBlock;
    private Integer containerId;
    private HashMap<Integer, HashSet<Integer>> immersiveVisibleIds;
    private View instance;
    private boolean isAlwaysShowing;
    private int layoutRes;
    private Function0<? extends ViewGroup> layoutView;
    private ScreenModeType screenModeType = ScreenModeType.THUMB;
    private boolean enable = true;
    private Function1<? super Integer, Boolean> hideControlAfterImmersive = new Function1() { // from class: tv.danmaku.biliplayerv2.ControlContainerConfig$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            boolean hideControlAfterImmersive$lambda$0;
            hideControlAfterImmersive$lambda$0 = ControlContainerConfig.hideControlAfterImmersive$lambda$0(((Integer) obj).intValue());
            return Boolean.valueOf(hideControlAfterImmersive$lambda$0);
        }
    };

    /* compiled from: ControlContainerConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/ControlContainerConfig$Companion;", "", "<init>", "()V", "TYPE_IMMERSIVE_SEEK_BAR", "", "TYPE_IMMERSIVE_SEEK_THUMBNAIL", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getLayoutRes() {
        return this.layoutRes;
    }

    public final void setLayoutRes(int i) {
        this.layoutRes = i;
    }

    public final Function0<ViewGroup> getLayoutView() {
        return this.layoutView;
    }

    public final void setLayoutView(Function0<? extends ViewGroup> function0) {
        this.layoutView = function0;
    }

    public final Integer getContainerId() {
        return this.containerId;
    }

    public final void setContainerId(Integer num) {
        this.containerId = num;
    }

    public final HashSet<Integer> getAlwaysShowIds() {
        return this.alwaysShowIds;
    }

    public final void setAlwaysShowIds(HashSet<Integer> hashSet) {
        this.alwaysShowIds = hashSet;
    }

    public final boolean getAlwaysShowRunning() {
        return this.alwaysShowRunning;
    }

    public final void setAlwaysShowRunning(boolean z) {
        this.alwaysShowRunning = z;
    }

    public final boolean isAlwaysShowing() {
        return this.isAlwaysShowing;
    }

    public final void setAlwaysShowing(boolean z) {
        this.isAlwaysShowing = z;
    }

    public final HashMap<Integer, HashSet<Integer>> getImmersiveVisibleIds() {
        return this.immersiveVisibleIds;
    }

    public final void setImmersiveVisibleIds(HashMap<Integer, HashSet<Integer>> hashMap) {
        this.immersiveVisibleIds = hashMap;
    }

    public final ScreenModeType getScreenModeType() {
        return this.screenModeType;
    }

    public final void setScreenModeType(ScreenModeType screenModeType) {
        Intrinsics.checkNotNullParameter(screenModeType, "<set-?>");
        this.screenModeType = screenModeType;
    }

    public final int getBottomSubtitleBlock() {
        return this.bottomSubtitleBlock;
    }

    public final void setBottomSubtitleBlock(int i) {
        this.bottomSubtitleBlock = i;
    }

    public final View getInstance() {
        return this.instance;
    }

    public final void setInstance(View view2) {
        this.instance = view2;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hideControlAfterImmersive$lambda$0(int it) {
        return false;
    }

    public final Function1<Integer, Boolean> getHideControlAfterImmersive() {
        return this.hideControlAfterImmersive;
    }

    public final void setHideControlAfterImmersive(Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.hideControlAfterImmersive = function1;
    }
}