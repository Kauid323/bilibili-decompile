package tv.danmaku.biliplayerv2.widget;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionContainer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/IFunctionContainer;", "Ltv/danmaku/biliplayerv2/widget/IWidget;", "showWidget", "", "widget", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "params", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "hideWidget", "release", "getAvailableWidth", "", "getAvailableHeight", "LayoutParams", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IFunctionContainer extends IWidget {
    int getAvailableHeight();

    int getAvailableWidth();

    void hideWidget(AbsFunctionWidget absFunctionWidget);

    void release();

    void showWidget(AbsFunctionWidget absFunctionWidget, LayoutParams layoutParams);

    /* compiled from: IFunctionContainer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\nJ\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u000202J\u0010\u00105\u001a\u0002022\b\u00106\u001a\u0004\u0018\u00010\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\f¨\u00068"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "", "width", "", "height", "<init>", "(II)V", "layoutType", "(III)V", "functionType", "(IIII)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "leftMargin", "getLeftMargin", "setLeftMargin", "topMargin", "getTopMargin", "setTopMargin", "bottomMargin", "getBottomMargin", "setBottomMargin", "rightMargin", "getRightMargin", "setRightMargin", "getFunctionType", "setFunctionType", "getLayoutType", "setLayoutType", "enterAnim", "getEnterAnim", "setEnterAnim", "exitAnim", "getExitAnim", "setExitAnim", "backgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "value", "flag", "getFlag", "touchOutsideDismiss", "dismiss", "", "touchEnable", "enable", "different", "other", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LayoutParams {
        public static final Companion Companion = new Companion(null);
        public static final int FLAG_TOUCH_ENABLE = 2;
        public static final int FLAG_TOUCH_OUTSIDE_DISMISS = 1;
        public static final int FUNCTION_TYPE_DIALOG = 3;
        public static final int FUNCTION_TYPE_EMBEDDED_VIEW = 0;
        public static final int FUNCTION_TYPE_NORMAL = 1;
        public static final int FUNCTION_TYPE_POPUP_WINDOW = 2;
        public static final int LAYOUT_TYPE_ALIGN_BOTTOM = 8;
        public static final int LAYOUT_TYPE_ALIGN_LEFT = 1;
        public static final int LAYOUT_TYPE_ALIGN_RIGHT = 4;
        public static final int LAYOUT_TYPE_ALIGN_TOP = 2;
        public static final int LAYOUT_TYPE_IN_CENTER = 16;
        public static final int LAYOUT_TYPE_UNDEFINED = 32;
        public static final int NO_ANIMATION = -1;
        private Drawable backgroundDrawable;
        private int bottomMargin;
        private int enterAnim;
        private int exitAnim;
        private int flag;
        private int functionType;
        private int height;
        private int layoutType;
        private int leftMargin;
        private int rightMargin;
        private int topMargin;
        private int width;

        /* compiled from: IFunctionContainer.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams$Companion;", "", "<init>", "()V", "LAYOUT_TYPE_ALIGN_LEFT", "", "LAYOUT_TYPE_ALIGN_TOP", "LAYOUT_TYPE_ALIGN_RIGHT", "LAYOUT_TYPE_ALIGN_BOTTOM", "LAYOUT_TYPE_IN_CENTER", "LAYOUT_TYPE_UNDEFINED", "FUNCTION_TYPE_EMBEDDED_VIEW", "FUNCTION_TYPE_NORMAL", "FUNCTION_TYPE_POPUP_WINDOW", "FUNCTION_TYPE_DIALOG", "FLAG_TOUCH_OUTSIDE_DISMISS", "FLAG_TOUCH_ENABLE", "NO_ANIMATION", "layoutTypeAlias", "", "type", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String layoutTypeAlias(int type) {
                if ((type & 32) != 0) {
                    return "undefined";
                }
                if ((type & 16) != 0) {
                    return "left|top|right|bottom";
                }
                StringBuilder sb = new StringBuilder();
                if ((type & 1) != 0) {
                    sb.append("left");
                }
                if ((type & 2) != 0) {
                    sb.append("|top");
                }
                if ((type & 4) != 0) {
                    sb.append("|right");
                }
                if ((type & 8) != 0) {
                    sb.append("|bottom");
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return sb2;
            }
        }

        public LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
            this.functionType = 2;
            touchOutsideDismiss(true);
            touchEnable(true);
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setWidth(int i) {
            this.width = i;
        }

        public LayoutParams(int width, int height, int layoutType) {
            this(width, height);
            this.layoutType = layoutType;
        }

        public LayoutParams(int width, int height, int layoutType, int functionType) {
            this(width, height);
            this.layoutType = layoutType;
            this.functionType = functionType;
        }

        public final int getLeftMargin() {
            return this.leftMargin;
        }

        public final void setLeftMargin(int i) {
            this.leftMargin = i;
        }

        public final int getTopMargin() {
            return this.topMargin;
        }

        public final void setTopMargin(int i) {
            this.topMargin = i;
        }

        public final int getBottomMargin() {
            return this.bottomMargin;
        }

        public final void setBottomMargin(int i) {
            this.bottomMargin = i;
        }

        public final int getRightMargin() {
            return this.rightMargin;
        }

        public final void setRightMargin(int i) {
            this.rightMargin = i;
        }

        public final int getFunctionType() {
            return this.functionType;
        }

        public final void setFunctionType(int i) {
            this.functionType = i;
        }

        public final int getLayoutType() {
            return this.layoutType;
        }

        public final void setLayoutType(int i) {
            this.layoutType = i;
        }

        public final int getEnterAnim() {
            return this.enterAnim;
        }

        public final void setEnterAnim(int i) {
            this.enterAnim = i;
        }

        public final int getExitAnim() {
            return this.exitAnim;
        }

        public final void setExitAnim(int i) {
            this.exitAnim = i;
        }

        public final Drawable getBackgroundDrawable() {
            return this.backgroundDrawable;
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            this.backgroundDrawable = drawable;
        }

        public final int getFlag() {
            return this.flag;
        }

        public final LayoutParams touchOutsideDismiss(boolean dismiss) {
            int i;
            if (dismiss) {
                i = this.flag | 1;
            } else {
                i = this.flag & (-2);
            }
            this.flag = i;
            return this;
        }

        public final LayoutParams touchEnable(boolean enable) {
            int i;
            if (enable) {
                i = this.flag | 2;
            } else {
                i = this.flag & (-3);
            }
            this.flag = i;
            return this;
        }

        public final boolean different(LayoutParams other) {
            if (other == null) {
                return true;
            }
            if (Intrinsics.areEqual(this, other)) {
                return false;
            }
            return (other.flag == this.flag && other.exitAnim == this.exitAnim && other.enterAnim == this.enterAnim && Intrinsics.areEqual(other.backgroundDrawable, this.backgroundDrawable) && other.layoutType == this.layoutType && other.height == this.height && other.width == this.width && other.functionType == this.functionType) ? false : true;
        }
    }
}