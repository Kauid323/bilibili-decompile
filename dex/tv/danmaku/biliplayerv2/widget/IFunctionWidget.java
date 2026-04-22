package tv.danmaku.biliplayerv2.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionWidget.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/IFunctionWidget;", "Ltv/danmaku/biliplayerv2/widget/IWidget;", "tag", "", "getTag", "()Ljava/lang/String;", "membersInjector", "", "getMembersInjector", "()Z", "getView", "Landroid/view/View;", "onWidgetShow", "", "onWidgetDismiss", "onRelease", "onWindowInsetChanged", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IFunctionWidget extends IWidget {
    boolean getMembersInjector();

    String getTag();

    View getView();

    void onRelease();

    void onWidgetDismiss();

    void onWidgetShow();

    void onWindowInsetChanged(WindowInset windowInset);

    /* compiled from: IFunctionWidget.kt */
    /* renamed from: tv.danmaku.biliplayerv2.widget.IFunctionWidget$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static String $default$getTag(IFunctionWidget _this) {
            String simpleName = _this.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            return simpleName;
        }

        public static boolean $default$getMembersInjector(IFunctionWidget _this) {
            return false;
        }
    }
}