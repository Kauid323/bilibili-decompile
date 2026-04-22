package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionWidgetService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "", "id", "", "clazz", "Ljava/lang/Class;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "<init>", "(ILjava/lang/Class;)V", "getId", "()I", "getClazz", "()Ljava/lang/Class;", "functionType", "getFunctionType", "setFunctionType", "(I)V", "value", "", "isShowing", "()Z", "setShowing", "(Z)V", "isRemoved", "setRemoved", "widgetChangedListener", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken$WidgetChangedListener;", "getWidgetChangedListener", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken$WidgetChangedListener;", "setWidgetChangedListener", "(Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken$WidgetChangedListener;)V", "toString", "", "WidgetChangedListener", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionWidgetToken {
    private final Class<? extends AbsFunctionWidget> clazz;
    private int functionType;
    private final int id;
    private boolean isRemoved;
    private boolean isShowing;
    private WidgetChangedListener widgetChangedListener;

    public FunctionWidgetToken(int id, Class<? extends AbsFunctionWidget> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.id = id;
        this.clazz = cls;
    }

    public final int getId() {
        return this.id;
    }

    public final Class<? extends AbsFunctionWidget> getClazz() {
        return this.clazz;
    }

    public final int getFunctionType() {
        return this.functionType;
    }

    public final void setFunctionType(int i) {
        this.functionType = i;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final void setShowing(boolean value) {
        this.isShowing = value;
        if (!value) {
            WidgetChangedListener widgetChangedListener = this.widgetChangedListener;
            if (widgetChangedListener != null) {
                widgetChangedListener.onDismiss();
                return;
            }
            return;
        }
        WidgetChangedListener widgetChangedListener2 = this.widgetChangedListener;
        if (widgetChangedListener2 != null) {
            widgetChangedListener2.onShow();
        }
    }

    public final boolean isRemoved() {
        return this.isRemoved;
    }

    public final void setRemoved(boolean value) {
        this.isRemoved = value;
        if (value) {
            setShowing(false);
            WidgetChangedListener widgetChangedListener = this.widgetChangedListener;
            if (widgetChangedListener != null) {
                widgetChangedListener.onRemoved();
            }
        }
    }

    public final WidgetChangedListener getWidgetChangedListener() {
        return this.widgetChangedListener;
    }

    public final void setWidgetChangedListener(WidgetChangedListener widgetChangedListener) {
        this.widgetChangedListener = widgetChangedListener;
    }

    public String toString() {
        int i = this.id;
        return "id=" + i + ";clazz=" + this.clazz.getName();
    }

    /* compiled from: IFunctionWidgetService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken$WidgetChangedListener;", "", "onDismiss", "", "onRemoved", "onShow", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface WidgetChangedListener {
        void onDismiss();

        void onRemoved();

        void onShow();

        /* compiled from: IFunctionWidgetService.kt */
        /* renamed from: tv.danmaku.biliplayerv2.service.FunctionWidgetToken$WidgetChangedListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static void $default$onDismiss(WidgetChangedListener _this) {
            }

            public static void $default$onRemoved(WidgetChangedListener _this) {
            }

            public static void $default$onShow(WidgetChangedListener _this) {
            }
        }
    }
}