package tv.danmaku.biliplayerimpl.panel;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.ViewGroupKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerimpl.BuildConfig;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.panel.IPlayerLayer;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.IWithViewPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PanelContainer.kt */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b \b\u0000\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0080\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ$\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00182\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0016J\u0018\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0016J\u0010\u00103\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0010\u00104\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0010H\u0002J\u001a\u00105\u001a\u00020+2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u000207H\u0016J\u0018\u0010;\u001a\u00020+2\u0006\u00106\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0016J \u0010>\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0006\u0010?\u001a\u00020@2\u0006\u0010<\u001a\u00020=H\u0016J0\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u00020+2\u0006\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\fH\u0016J(\u0010H\u001a\u00020(2\u0006\u0010B\u001a\u0002072\u0006\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH\u0016J(\u0010I\u001a\u00020+2\u0006\u0010B\u001a\u0002072\u0006\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH\u0016J8\u0010J\u001a\u00020+2\u0006\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0016J \u0010H\u001a\u00020(2\u0006\u0010L\u001a\u0002072\u0006\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020\fH\u0016J \u0010I\u001a\u00020+2\u0006\u0010L\u001a\u0002072\u0006\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020\fH\u0016J\u0010\u0010G\u001a\u00020+2\u0006\u0010L\u001a\u000207H\u0016J0\u0010J\u001a\u00020+2\u0006\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fH\u0016J(\u0010A\u001a\u00020+2\u0006\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020\f2\u0006\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020=H\u0016J(\u0010Q\u001a\u00020(2\u0006\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020R2\u0006\u0010N\u001a\u00020R2\u0006\u0010O\u001a\u00020(H\u0016J \u0010S\u001a\u00020(2\u0006\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020R2\u0006\u0010N\u001a\u00020RH\u0016J\b\u0010T\u001a\u00020\fH\u0016J\u0010\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020WH\u0016J\u0012\u0010X\u001a\u00020(2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0012\u0010[\u001a\u00020(2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J:\u0010^\u001a\u00020+2\b\u0010_\u001a\u0004\u0018\u00010\u001f2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010a2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010a2\u0006\u0010c\u001a\u00020(H\u0016J\u0018\u0010d\u001a\u00020(2\u0006\u0010_\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u0010H\u0002J\u0018\u0010e\u001a\u00020(2\u0006\u0010_\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020\u0014H\u0002J\u0010\u0010g\u001a\u00020+2\u0006\u0010c\u001a\u00020(H\u0002J\u0018\u0010h\u001a\u00020+2\u0006\u0010i\u001a\u00020\f2\u0006\u0010j\u001a\u00020\fH\u0014J0\u0010k\u001a\u00020+2\u0006\u0010l\u001a\u00020(2\u0006\u0010m\u001a\u00020\f2\u0006\u0010n\u001a\u00020\f2\u0006\u0010o\u001a\u00020\f2\u0006\u0010p\u001a\u00020\fH\u0014J\u0010\u0010q\u001a\u00020+2\u0006\u0010r\u001a\u00020%H\u0016J\u0010\u0010s\u001a\u00020+2\u0006\u0010r\u001a\u00020%H\u0016J\b\u0010t\u001a\u00020(H\u0002J\u001c\u0010u\u001a\u00020+2\b\u0010v\u001a\u0004\u0018\u0001072\b\u0010w\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010x\u001a\u00020+2\b\u0010v\u001a\u0004\u0018\u000107H\u0016J\b\u0010y\u001a\u00020+H\u0016J\u001c\u0010z\u001a\u00020+2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010{\u001a\u00020\u0010H\u0016J \u0010z\u001a\u00020+2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030\u00162\n\u0010{\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\u0014\u0010|\u001a\u00020+2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\u0018\u0010}\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00102\u0006\u0010~\u001a\u00020(H\u0016J\u0014\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0016R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00150\u000fj\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0015`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010#\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010%0% &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010$0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/panel/PanelContainer;", "Landroid/widget/FrameLayout;", "Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBuiltInLayers", "Ljava/util/HashMap;", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "Ltv/danmaku/biliplayerimpl/panel/AbsBuiltInPlayerLayer;", "Lkotlin/collections/HashMap;", "mCustomLayers", "", "Ljava/util/LinkedList;", "Ltv/danmaku/biliplayerv2/panel/IPlayerLayer;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mControlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "mViewPortsByBuiltInLayer", "", "Landroid/graphics/Rect;", "mViewPortsByCustomerLayer", "mWidthMeasureSpec", "mHeightMeasureSpec", "mOnKeyListeners", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Landroid/view/View$OnKeyListener;", "kotlin.jvm.PlatformType", "mShouldClearFocusWhenKeyListenersEmpty", "", "mShouldApplyViewPortWhenLayout", "init", "", "playerContainer", "controlContainerConfig", "ensureBuiltInLayer", "layer", "service", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "addBuiltInLayer", "removeBuiltInLayer", "indexBuiltInLayer", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "getView", "location", "point", "", "locationByAncestor", "ancestor", "Landroid/view/ViewGroup;", "onNestedPreScroll", "p0", "p1", "p2", "p3", "p4", "onStopNestedScroll", "onStartNestedScroll", "onNestedScrollAccepted", "onNestedScroll", "p5", "var1", "var2", "var3", "var4", "var5", "onNestedFling", "", "onNestedPreFling", "getNestedScrollAxes", "onVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "updateViewPort", "viewPort", "builtInLayers", "", "customerLayers", "immediately", "updateBuiltInViewPort", "updateCustomerViewPort", "type", "applyViewPort", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "removeOnKeyListener", "listener", "addOnKeyListener", "requestFocusInternal", "requestChildFocus", "child", "focused", "clearChildFocus", "clearFocus", "addLayer", "over", "removeLayer", "setBuiltInLayerVisibility", "visibility", "getControlContainerConfig", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PanelContainer extends FrameLayout implements IPanelContainer, NestedScrollingParent2 {
    public static final Companion Companion = new Companion(null);
    private static final String FF_KEY_PLAYER_LAYER_BUILD_BY_LAZY = "ff_player_layer_build_by_lazy";
    private static final String TAG = "PanelContainer";
    private final HashMap<BuiltInLayer, AbsBuiltInPlayerLayer> mBuiltInLayers;
    private Map<ControlContainerType, ControlContainerConfig> mControlContainerConfig;
    private final HashMap<String, LinkedList<IPlayerLayer<?>>> mCustomLayers;
    private int mHeightMeasureSpec;
    private Collections.SafeIteratorList<View.OnKeyListener> mOnKeyListeners;
    private PlayerContainer mPlayerContainer;
    private boolean mShouldApplyViewPortWhenLayout;
    private boolean mShouldClearFocusWhenKeyListenersEmpty;
    private final Map<BuiltInLayer, Rect> mViewPortsByBuiltInLayer;
    private final Map<String, Rect> mViewPortsByCustomerLayer;
    private int mWidthMeasureSpec;

    /* compiled from: PanelContainer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BuiltInLayer.values().length];
            try {
                iArr[BuiltInLayer.LayerRender.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BuiltInLayer.LayerControl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[BuiltInLayer.LayerFunction.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[BuiltInLayer.LayerToast.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: PanelContainer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerimpl/panel/PanelContainer$Companion;", "", "<init>", "()V", "TAG", "", "FF_KEY_PLAYER_LAYER_BUILD_BY_LAZY", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBuiltInLayers = new HashMap<>();
        this.mCustomLayers = new HashMap<>();
        this.mViewPortsByBuiltInLayer = new EnumMap(BuiltInLayer.class);
        this.mViewPortsByCustomerLayer = new HashMap();
        this.mOnKeyListeners = Collections.safeIteratorList(new LinkedList());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBuiltInLayers = new HashMap<>();
        this.mCustomLayers = new HashMap<>();
        this.mViewPortsByBuiltInLayer = new EnumMap(BuiltInLayer.class);
        this.mViewPortsByCustomerLayer = new HashMap();
        this.mOnKeyListeners = Collections.safeIteratorList(new LinkedList());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBuiltInLayers = new HashMap<>();
        this.mCustomLayers = new HashMap<>();
        this.mViewPortsByBuiltInLayer = new EnumMap(BuiltInLayer.class);
        this.mViewPortsByCustomerLayer = new HashMap();
        this.mOnKeyListeners = Collections.safeIteratorList(new LinkedList());
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void init(PlayerContainer playerContainer, Map<ControlContainerType, ControlContainerConfig> map) {
        Map controlContainerConfig = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        Intrinsics.checkNotNullParameter(controlContainerConfig, "controlContainerConfig");
        this.mPlayerContainer = playerContainer;
        this.mControlContainerConfig = controlContainerConfig;
        Context context = playerContainer.getContext();
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        View renderContainer = playerContainer2.getRenderContainerService().createView(context);
        addView(renderContainer, BuiltInLayer.LayerRender.getIndex(), new ViewGroup.LayoutParams(-1, -1));
        this.mBuiltInLayers.put(BuiltInLayer.LayerRender, new PlayerRenderLayer(renderContainer, playerContainer.getRenderContainerService()));
        playerContainer.getInteractLayerService().bindDanmakuContainer(new FrameLayout(context));
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void ensureBuiltInLayer(BuiltInLayer layer, IWithViewPlayerService service) {
        Rect viewPort;
        Intrinsics.checkNotNullParameter(layer, "layer");
        Intrinsics.checkNotNullParameter(service, "service");
        if (this.mBuiltInLayers.containsKey(layer)) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[layer.ordinal()]) {
            case 1:
                if (!(service instanceof IRenderContainerService)) {
                    if (BuildConfig.DEBUG) {
                        throw new IllegalArgumentException("service: " + service + " can not match layer: " + layer);
                    }
                    PlayerLog.e(TAG, "service: " + service + " can not match layer: " + layer);
                    break;
                } else {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    View renderContainer = service.createView(context);
                    renderContainer.setTag(BuiltInLayer.LayerRender);
                    addView(renderContainer, indexBuiltInLayer(BuiltInLayer.LayerRender), new ViewGroup.LayoutParams(-1, -1));
                    this.mBuiltInLayers.put(BuiltInLayer.LayerRender, new PlayerRenderLayer(renderContainer, (IRenderContainerService) service));
                    break;
                }
            case 2:
                if (!(service instanceof IControlContainerService)) {
                    if (BuildConfig.DEBUG) {
                        throw new IllegalArgumentException("service: " + service + " can not match layer: " + layer);
                    }
                    PlayerLog.e(TAG, "service: " + service + " can not match layer: " + layer);
                    break;
                } else {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    View controlContainer = service.createView(context2);
                    controlContainer.setTag(BuiltInLayer.LayerControl);
                    addView(controlContainer, indexBuiltInLayer(BuiltInLayer.LayerControl), new ViewGroup.LayoutParams(-1, -1));
                    controlContainer.setId(R.id.control_container);
                    IControlContainerService iControlContainerService = (IControlContainerService) service;
                    Map<ControlContainerType, ControlContainerConfig> map = this.mControlContainerConfig;
                    if (map == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mControlContainerConfig");
                        map = null;
                    }
                    iControlContainerService.setControlContainerConfig(map);
                    this.mBuiltInLayers.put(BuiltInLayer.LayerControl, new PlayerControlLayer(controlContainer));
                    break;
                }
            case 3:
                if (!(service instanceof AbsFunctionWidgetService)) {
                    if (BuildConfig.DEBUG) {
                        throw new IllegalArgumentException("service: " + service + " can not match layer: " + layer);
                    }
                    PlayerLog.e(TAG, "service: " + service + " can not match layer: " + layer);
                    break;
                } else {
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    View functionContainer = service.createView(context3);
                    functionContainer.setTag(BuiltInLayer.LayerFunction);
                    addView(functionContainer, indexBuiltInLayer(BuiltInLayer.LayerFunction), new ViewGroup.LayoutParams(-1, -1));
                    this.mBuiltInLayers.put(BuiltInLayer.LayerFunction, new PlayerFunctionLayer(functionContainer));
                    break;
                }
            case 4:
                if (!(service instanceof IToastService)) {
                    if (BuildConfig.DEBUG) {
                        throw new IllegalArgumentException("service: " + service + " can not match layer: " + layer);
                    }
                    PlayerLog.e(TAG, "service: " + service + " can not match layer: " + layer);
                    break;
                } else {
                    Context context4 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                    View toastContainer = service.createView(context4);
                    toastContainer.setTag(BuiltInLayer.LayerToast);
                    addView(toastContainer, indexBuiltInLayer(BuiltInLayer.LayerToast), new ViewGroup.LayoutParams(-1, -1));
                    this.mBuiltInLayers.put(BuiltInLayer.LayerToast, new PlayerToastLayer(toastContainer));
                    break;
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
        AbsBuiltInPlayerLayer it = this.mBuiltInLayers.get(layer);
        if (it != null && (viewPort = this.mViewPortsByBuiltInLayer.get(layer)) != null) {
            IPlayerLayer.CC.onViewPortUpdate$default(it, viewPort, getWidth(), getHeight(), false, 8, null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void addBuiltInLayer(BuiltInLayer layer, IWithViewPlayerService service) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        Intrinsics.checkNotNullParameter(service, "service");
        PlayerLog.i(TAG, "add layer: " + layer + ", service: " + service);
        ensureBuiltInLayer(layer, service);
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void removeBuiltInLayer(BuiltInLayer layer) {
        View it;
        Intrinsics.checkNotNullParameter(layer, "layer");
        PlayerLog.i(TAG, "remove layer: " + layer);
        AbsBuiltInPlayerLayer remove = this.mBuiltInLayers.remove(layer);
        if (remove != null && (it = remove.getView()) != null) {
            removeView(it);
        }
    }

    private final int indexBuiltInLayer(BuiltInLayer layer) {
        Sequence $this$indexOfFirst$iv = ViewGroupKt.getChildren(this);
        int index$iv = 0;
        Iterator it = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View it2 = (View) item$iv;
                Object tag = it2.getTag();
                BuiltInLayer builtInLayer = tag instanceof BuiltInLayer ? (BuiltInLayer) tag : null;
                if ((builtInLayer != null ? builtInLayer.getIndex() : 0) > layer.getIndex()) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int targetIndex = index$iv;
        if (targetIndex == -1) {
            targetIndex = getChildCount();
        }
        PlayerLog.i(TAG, "index layer " + layer + ": " + targetIndex);
        return targetIndex;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public View getView() {
        return this;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void location(View view2, int[] point) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(point, "point");
        if (!locationByAncestor(view2, this, point)) {
            point[0] = -1;
            point[1] = -1;
        }
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public boolean locationByAncestor(View view2, ViewGroup ancestor, int[] point) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(ancestor, "ancestor");
        Intrinsics.checkNotNullParameter(point, "point");
        int childCount = ancestor.getChildCount();
        boolean found = false;
        int oldX = point[0];
        int oldY = point[1];
        for (int i = 0; i < childCount; i++) {
            View child = ancestor.getChildAt(i);
            point[0] = point[0] + child.getLeft();
            point[1] = point[1] + child.getTop();
            if (Intrinsics.areEqual(child, view2)) {
                return true;
            }
            if ((child instanceof ViewGroup) && (found = locationByAncestor(view2, (ViewGroup) child, point))) {
                return true;
            }
            if (!found) {
                point[0] = oldX;
                point[1] = oldY;
            }
        }
        return found;
    }

    public void onNestedPreScroll(View p0, int p1, int p2, int[] p3, int p4) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p3, "p3");
    }

    public void onStopNestedScroll(View p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    public boolean onStartNestedScroll(View p0, View p1, int p2, int p3) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return true;
    }

    public void onNestedScrollAccepted(View p0, View p1, int p2, int p3) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
    }

    public void onNestedScroll(View p0, int p1, int p2, int p3, int p4, int p5) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        if (p0 instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) p0).stopNestedScroll(p5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View var1, View var2, int var3) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        Intrinsics.checkNotNullParameter(var2, "var2");
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View var1, View var2, int var3) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        Intrinsics.checkNotNullParameter(var2, "var2");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View var1) {
        Intrinsics.checkNotNullParameter(var1, "var1");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
        Intrinsics.checkNotNullParameter(var1, "var1");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        Intrinsics.checkNotNullParameter(var4, "var4");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View var1, float var2, float var3) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 0;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver
    public void onVideoInsetChanged(VideoInset inset) {
        Intrinsics.checkNotNullParameter(inset, "inset");
        Map $this$forEach$iv = this.mBuiltInLayers;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            element$iv.getValue().onVideoInsetChanged(inset);
        }
        Map $this$forEach$iv2 = this.mCustomLayers;
        for (Map.Entry element$iv2 : $this$forEach$iv2.entrySet()) {
            LinkedList<IPlayerLayer<?>> $this$forEach$iv3 = element$iv2.getValue();
            for (Object element$iv3 : $this$forEach$iv3) {
                IPlayerLayer layer = (IPlayerLayer) element$iv3;
                layer.onVideoInsetChanged(inset);
            }
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View, tv.danmaku.biliplayerv2.panel.IPanelContainer
    public boolean dispatchKeyEvent(final KeyEvent event) {
        if (event == null) {
            return false;
        }
        final Ref.BooleanRef handled = new Ref.BooleanRef();
        handled.element = super.dispatchKeyEvent(event);
        if (!handled.element) {
            this.mOnKeyListeners.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.panel.PanelContainer$$ExternalSyntheticLambda0
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    PanelContainer.dispatchKeyEvent$lambda$0(handled, this, event, (View.OnKeyListener) obj);
                }
            });
        }
        return handled.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchKeyEvent$lambda$0(Ref.BooleanRef $handled, PanelContainer this$0, KeyEvent $event, View.OnKeyListener it) {
        $handled.element = $handled.element || it.onKey(this$0, $event.getKeyCode(), $event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean z = true;
        if (ev != null && ev.getAction() == 0) {
            boolean handle = super.dispatchTouchEvent(ev);
            if (handle) {
                PlayerContainer playerContainer = this.mPlayerContainer;
                if (playerContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer = null;
                }
                if (playerContainer.getPlayerParams().getConfig().getDisallowParentIntercept()) {
                    requestDisallowInterceptTouchEvent(true);
                    return handle;
                }
                return handle;
            }
            return handle;
        }
        if (!(ev != null && ev.getAction() == 1)) {
            if (ev == null || ev.getAction() != 3) {
                z = false;
            }
            if (!z) {
                boolean handle2 = super.dispatchTouchEvent(ev);
                return handle2;
            }
        }
        boolean handle3 = super.dispatchTouchEvent(ev);
        requestDisallowInterceptTouchEvent(false);
        return handle3;
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void updateViewPort(Rect viewPort, List<? extends BuiltInLayer> list, List<String> list2, boolean immediately) {
        Iterable builtInLayers = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Iterable customerLayers = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        if (viewPort == null || viewPort.height() <= 0 || viewPort.width() <= 0) {
            return;
        }
        boolean changed = false;
        if (builtInLayers != null) {
            Iterable $this$forEach$iv = builtInLayers;
            for (Object element$iv : $this$forEach$iv) {
                BuiltInLayer it = (BuiltInLayer) element$iv;
                changed = updateBuiltInViewPort(viewPort, it) || changed;
            }
        }
        if (customerLayers != null) {
            Iterable $this$forEach$iv2 = customerLayers;
            for (Object element$iv2 : $this$forEach$iv2) {
                String it2 = (String) element$iv2;
                changed = updateCustomerViewPort(viewPort, it2) || changed;
            }
        }
        if (changed) {
            if (isLayoutRequested()) {
                this.mShouldApplyViewPortWhenLayout = true;
            } else {
                applyViewPort(immediately);
            }
        }
    }

    private final boolean updateBuiltInViewPort(Rect viewPort, BuiltInLayer layer) {
        Rect bViewPort = this.mViewPortsByBuiltInLayer.get(layer);
        if (bViewPort == null) {
            bViewPort = new Rect();
            this.mViewPortsByBuiltInLayer.put(layer, bViewPort);
        }
        if (!Intrinsics.areEqual(bViewPort, viewPort)) {
            bViewPort.set(viewPort);
            return true;
        }
        return false;
    }

    private final boolean updateCustomerViewPort(Rect viewPort, String type) {
        Rect cViewPort = this.mViewPortsByCustomerLayer.get(type);
        if (cViewPort == null) {
            cViewPort = new Rect();
            this.mViewPortsByCustomerLayer.put(type, cViewPort);
        }
        if (!Intrinsics.areEqual(cViewPort, viewPort)) {
            cViewPort.set(viewPort);
            return true;
        }
        return false;
    }

    private final void applyViewPort(boolean immediately) {
        Iterable layerList;
        AbsBuiltInPlayerLayer absBuiltInPlayerLayer;
        for (Map.Entry entry : this.mViewPortsByBuiltInLayer.entrySet()) {
            Rect port = entry.getValue();
            if (port != null && (absBuiltInPlayerLayer = this.mBuiltInLayers.get(entry.getKey())) != null) {
                absBuiltInPlayerLayer.onViewPortUpdate(port, getWidth(), getHeight(), immediately);
            }
        }
        for (Map.Entry entry2 : this.mViewPortsByCustomerLayer.entrySet()) {
            Rect port2 = entry2.getValue();
            if (port2 != null && (layerList = (LinkedList) this.mCustomLayers.get(entry2.getKey())) != null) {
                Iterable $this$forEach$iv = layerList;
                for (Object element$iv : $this$forEach$iv) {
                    IPlayerLayer it = (IPlayerLayer) element$iv;
                    it.onViewPortUpdate(port2, getWidth(), getHeight(), immediately);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mWidthMeasureSpec = widthMeasureSpec;
        this.mHeightMeasureSpec = heightMeasureSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mShouldApplyViewPortWhenLayout || changed) {
            this.mShouldApplyViewPortWhenLayout = false;
            applyViewPort(false);
        }
        int childCount = getChildCount();
        boolean shouldRelayoutChild = false;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int lpWidth = child.getLayoutParams().width;
            int lpHeight = child.getLayoutParams().height;
            if (lpHeight > 0 && lpWidth > 0 && (child.getMeasuredWidth() != lpWidth || child.getMeasuredHeight() != lpHeight)) {
                measureChildWithMargins(child, this.mWidthMeasureSpec, 0, this.mHeightMeasureSpec, 0);
                IPlayerLayer.Companion companion = IPlayerLayer.Companion;
                Intrinsics.checkNotNull(child);
                companion.markRelayout(child);
                shouldRelayoutChild = true;
            }
        }
        if (shouldRelayoutChild) {
            super.onLayout(changed, left, top, right, bottom);
        }
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void removeOnKeyListener(View.OnKeyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnKeyListeners.remove(listener);
        if (this.mOnKeyListeners.isEmpty() && this.mShouldClearFocusWhenKeyListenersEmpty) {
            clearFocus();
        }
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void addOnKeyListener(View.OnKeyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnKeyListeners.add(listener);
        if (!hasFocus()) {
            this.mShouldClearFocusWhenKeyListenersEmpty = requestFocusInternal();
        }
    }

    private final boolean requestFocusInternal() {
        if (Build.VERSION.SDK_INT >= 26) {
            setFocusable(1);
        }
        setFocusableInTouchMode(true);
        return requestFocus();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        if (hasFocus()) {
            this.mShouldClearFocusWhenKeyListenersEmpty = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void clearChildFocus(View child) {
        super.clearChildFocus(child);
        Collections.SafeIteratorList<View.OnKeyListener> safeIteratorList = this.mOnKeyListeners;
        Intrinsics.checkNotNullExpressionValue(safeIteratorList, "mOnKeyListeners");
        if (!safeIteratorList.isEmpty() && !hasFocus()) {
            this.mShouldClearFocusWhenKeyListenersEmpty = requestFocusInternal();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        Collections.SafeIteratorList<View.OnKeyListener> safeIteratorList = this.mOnKeyListeners;
        Intrinsics.checkNotNullExpressionValue(safeIteratorList, "mOnKeyListeners");
        if (!safeIteratorList.isEmpty()) {
            return;
        }
        super.clearFocus();
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void addLayer(IPlayerLayer<?> iPlayerLayer, BuiltInLayer over) {
        IRenderContainerService service;
        Rect viewPort;
        Intrinsics.checkNotNullParameter(iPlayerLayer, "layer");
        Intrinsics.checkNotNullParameter(over, "over");
        PlayerContainer playerContainer = null;
        switch (WhenMappings.$EnumSwitchMapping$0[over.ordinal()]) {
            case 1:
                PlayerContainer playerContainer2 = this.mPlayerContainer;
                if (playerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer2 = null;
                }
                service = playerContainer2.getRenderContainerService();
                break;
            case 2:
                PlayerContainer playerContainer3 = this.mPlayerContainer;
                if (playerContainer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer3 = null;
                }
                service = playerContainer3.getControlContainerService();
                break;
            case 3:
                PlayerContainer playerContainer4 = this.mPlayerContainer;
                if (playerContainer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer4 = null;
                }
                service = playerContainer4.getFunctionWidgetService();
                break;
            case 4:
                PlayerContainer playerContainer5 = this.mPlayerContainer;
                if (playerContainer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer5 = null;
                }
                service = playerContainer5.getToastService();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        ensureBuiltInLayer(over, service);
        AbsBuiltInPlayerLayer absBuiltInPlayerLayer = this.mBuiltInLayers.get(over);
        int index = absBuiltInPlayerLayer != null ? absBuiltInPlayerLayer.insertIndex() : -1;
        if (index >= 0) {
            addView(iPlayerLayer.getView(), index, new ViewGroup.LayoutParams(-1, -1));
            Map $this$forEach$iv = this.mBuiltInLayers;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                if (element$iv.getValue().insertIndex() >= index) {
                    element$iv.getValue().increaseInsertIndex();
                }
            }
        } else {
            addView(iPlayerLayer.getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        String type = iPlayerLayer.type();
        LinkedList layerList = this.mCustomLayers.get(type);
        if (layerList == null) {
            layerList = new LinkedList();
            this.mCustomLayers.put(type, layerList);
        }
        layerList.add(iPlayerLayer);
        PlayerContainer playerContainer6 = this.mPlayerContainer;
        if (playerContainer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer = playerContainer6;
        }
        iPlayerLayer.attachToPlayerContainer(playerContainer);
        if (!this.mShouldApplyViewPortWhenLayout && (viewPort = this.mViewPortsByCustomerLayer.get(iPlayerLayer.type())) != null) {
            IPlayerLayer.CC.onViewPortUpdate$default(iPlayerLayer, viewPort, getWidth(), getHeight(), false, 8, null);
        }
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void addLayer(IPlayerLayer<?> iPlayerLayer, IPlayerLayer<?> iPlayerLayer2) {
        Rect viewPort;
        Intrinsics.checkNotNullParameter(iPlayerLayer, "layer");
        Intrinsics.checkNotNullParameter(iPlayerLayer2, "over");
        LinkedList<IPlayerLayer<?>> linkedList = this.mCustomLayers.get(iPlayerLayer2.type());
        int index = linkedList != null ? CollectionsKt.getLastIndex(linkedList) : -1;
        if (index >= 0) {
            addView(iPlayerLayer.getView(), index, new ViewGroup.LayoutParams(-1, -1));
            Map $this$forEach$iv = this.mBuiltInLayers;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                if (element$iv.getValue().insertIndex() >= index) {
                    element$iv.getValue().increaseInsertIndex();
                }
            }
            String type = iPlayerLayer.type();
            LinkedList layerList = this.mCustomLayers.get(type);
            if (layerList == null) {
                layerList = new LinkedList();
                this.mCustomLayers.put(type, layerList);
            }
            layerList.add(iPlayerLayer);
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            iPlayerLayer.attachToPlayerContainer(playerContainer);
            if (!this.mShouldApplyViewPortWhenLayout && (viewPort = this.mViewPortsByCustomerLayer.get(iPlayerLayer.type())) != null) {
                IPlayerLayer.CC.onViewPortUpdate$default(iPlayerLayer, viewPort, getWidth(), getHeight(), false, 8, null);
                return;
            }
            return;
        }
        throw new IllegalStateException("Not found layer:" + iPlayerLayer2.type() + ", please check layer state");
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void removeLayer(IPlayerLayer<?> iPlayerLayer) {
        Intrinsics.checkNotNullParameter(iPlayerLayer, "layer");
        if (iPlayerLayer instanceof AbsBuiltInPlayerLayer) {
            throw new IllegalArgumentException("could not remove built-in layer");
        }
        int index = indexOfChild(iPlayerLayer.getView());
        if (index >= 0) {
            Map $this$forEach$iv = this.mBuiltInLayers;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                if (element$iv.getValue().insertIndex() > index) {
                    element$iv.getValue().decreaseInsertIndex();
                }
            }
            removeView(iPlayerLayer.getView());
        }
        LinkedList layerList = this.mCustomLayers.get(iPlayerLayer.type());
        if (layerList != null) {
            layerList.remove(iPlayerLayer);
            if (layerList.isEmpty()) {
                this.mCustomLayers.remove(iPlayerLayer.type());
            }
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        iPlayerLayer.detachFromPlayerContainer(playerContainer);
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public void setBuiltInLayerVisibility(BuiltInLayer layer, boolean visibility) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        AbsBuiltInPlayerLayer actualLayer = this.mBuiltInLayers.get(layer);
        if (actualLayer == null) {
            return;
        }
        actualLayer.setVisibility(visibility);
    }

    @Override // tv.danmaku.biliplayerv2.panel.IPanelContainer
    public Map<ControlContainerType, ControlContainerConfig> getControlContainerConfig() {
        Map<ControlContainerType, ControlContainerConfig> map = this.mControlContainerConfig;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControlContainerConfig");
            map = null;
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(map);
    }
}