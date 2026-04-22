package tv.danmaku.biliplayerv2.widget;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.FunctionWidgetInsetConfig;
import tv.danmaku.biliplayerv2.service.FunctionWidgetToken;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.IFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionWidget.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u00020\u0011H\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020 H\u0017J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0017J\b\u0010&\u001a\u00020 H\u0017J\b\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0003H$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "Ltv/danmaku/biliplayerv2/widget/IFunctionWidget;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "mContentView", "Landroid/view/View;", "token", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "getToken", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "setToken", "(Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;)V", "isShowing", "", "()Z", "setShowing", "(Z)V", "functionWidgetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getFunctionWidgetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "functionInsetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetInsetConfig;", "getFunctionInsetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetInsetConfig;", "getView", "shouldRecreateView", "bindPlayerContainer", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "onWidgetShow", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "onWidgetDismiss", "onBackPressed", "onConfigurationChanged", "onNewLayoutParams", "layoutParams", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "onWindowInsetChanged", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "createContentView", "context", "Configuration", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsFunctionWidget implements IFunctionWidget {
    private boolean isShowing;
    private View mContentView;
    private final Context mContext;
    public FunctionWidgetToken token;

    /* compiled from: IFunctionWidget.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class Configuration {
    }

    protected abstract View createContentView(Context context);

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public /* synthetic */ boolean getMembersInjector() {
        return IFunctionWidget.CC.$default$getMembersInjector(this);
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public /* synthetic */ String getTag() {
        return IFunctionWidget.CC.$default$getTag(this);
    }

    public AbsFunctionWidget(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getMContext() {
        return this.mContext;
    }

    public final FunctionWidgetToken getToken() {
        FunctionWidgetToken functionWidgetToken = this.token;
        if (functionWidgetToken != null) {
            return functionWidgetToken;
        }
        Intrinsics.throwUninitializedPropertyAccessException("token");
        return null;
    }

    public final void setToken(FunctionWidgetToken functionWidgetToken) {
        Intrinsics.checkNotNullParameter(functionWidgetToken, "<set-?>");
        this.token = functionWidgetToken;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final void setShowing(boolean z) {
        this.isShowing = z;
    }

    public FunctionWidgetConfig getFunctionWidgetConfig() {
        return new FunctionWidgetConfig.Builder().build();
    }

    public FunctionWidgetInsetConfig getFunctionInsetConfig() {
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public final View getView() {
        if (this.mContentView == null) {
            this.mContentView = createContentView(this.mContext);
        }
        View view2 = this.mContentView;
        Intrinsics.checkNotNull(view2);
        return view2;
    }

    public final boolean shouldRecreateView() {
        return this.mContentView == null;
    }

    @Override // tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetShow() {
        this.isShowing = true;
    }

    public void onWidgetShow(Configuration configuration) {
        onWidgetShow();
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetDismiss() {
        this.isShowing = false;
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    public void onNewLayoutParams(IFunctionContainer.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0.getSupport() == true) goto L5;
     */
    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onWindowInsetChanged(WindowInset windowInset) {
        boolean z;
        int left;
        int top;
        int right;
        Intrinsics.checkNotNullParameter(windowInset, "windowInset");
        FunctionWidgetInsetConfig functionInsetConfig = getFunctionInsetConfig();
        int bottom = 0;
        if (functionInsetConfig != null) {
            z = true;
        }
        z = false;
        if (!z) {
            return;
        }
        if (windowInset.getLeftPadding() > 0) {
            left = windowInset.getLeftPadding() > functionInsetConfig.getContentLeftPadding() ? windowInset.getLeftPadding() - functionInsetConfig.getContentLeftPadding() : windowInset.getLeftPadding();
        } else {
            left = 0;
        }
        if (windowInset.getTopPadding() > 0) {
            top = windowInset.getTopPadding() > functionInsetConfig.getContentTopPadding() ? windowInset.getTopPadding() - functionInsetConfig.getContentTopPadding() : windowInset.getTopPadding();
        } else {
            top = 0;
        }
        if (windowInset.getRightPadding() > 0) {
            right = windowInset.getRightPadding() > functionInsetConfig.getContentRightPadding() ? windowInset.getRightPadding() - functionInsetConfig.getContentRightPadding() : windowInset.getRightPadding();
        } else {
            right = 0;
        }
        if (windowInset.getBottomPadding() > 0) {
            bottom = windowInset.getBottomPadding() > functionInsetConfig.getContentBottomPadding() ? windowInset.getBottomPadding() - functionInsetConfig.getContentBottomPadding() : windowInset.getBottomPadding();
        }
        getView().setPadding(left, top, right, bottom);
    }
}