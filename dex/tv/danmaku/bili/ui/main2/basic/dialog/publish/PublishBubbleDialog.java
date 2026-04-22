package tv.danmaku.bili.ui.main2.basic.dialog.publish;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.moduleservice.upper.UpperCenterPlusBubbleService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.basic.TabHostGarbProviderKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PublishBubbleDialog.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J*\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020!H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubbleDialog;", "Lcom/bilibili/app/dialogmanager/MainDialogManager$IDialogInterface;", "<init>", "()V", "popupItem", "Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;", "getPopupItem", "()Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;", "setPopupItem", "(Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;)V", "originTabUrl", "", "getOriginTabUrl", "()Ljava/lang/String;", "setOriginTabUrl", "(Ljava/lang/String;)V", "anchorView", "Lcom/bilibili/lib/homepage/widget/TabHost;", "getAnchorView", "()Lcom/bilibili/lib/homepage/widget/TabHost;", "setAnchorView", "(Lcom/bilibili/lib/homepage/widget/TabHost;)V", "value", "Ltv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubblePopupWindow;", "popupWindow", "getPopupWindow", "()Ltv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubblePopupWindow;", "onShow", "", "showPopupWindow", "item", "anchor", "drawable", "Landroid/graphics/drawable/Drawable;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PublishBubbleDialog implements MainDialogManager.IDialogInterface {
    private TabHost anchorView;
    private String originTabUrl;
    private UpperCenterPlusBubbleService.BubbleInfo popupItem;
    private PublishBubblePopupWindow popupWindow;

    public final UpperCenterPlusBubbleService.BubbleInfo getPopupItem() {
        return this.popupItem;
    }

    public final void setPopupItem(UpperCenterPlusBubbleService.BubbleInfo bubbleInfo) {
        this.popupItem = bubbleInfo;
    }

    public final String getOriginTabUrl() {
        return this.originTabUrl;
    }

    public final void setOriginTabUrl(String str) {
        this.originTabUrl = str;
    }

    public final TabHost getAnchorView() {
        return this.anchorView;
    }

    public final void setAnchorView(TabHost tabHost) {
        this.anchorView = tabHost;
    }

    public final PublishBubblePopupWindow getPopupWindow() {
        return this.popupWindow;
    }

    public void onShow() {
        UpperCenterPlusBubbleService.BubbleInfo bubbleInfo = this.popupItem;
        BLog.i(TabHostGarbProviderKt.TAG, "PublishGuidePopup on show :" + bubbleInfo + " :" + this.anchorView);
        UpperCenterPlusBubbleService.BubbleInfo item = this.popupItem;
        View view = this.anchorView;
        if (view == null || item == null) {
            PublishBubbleDialogKt.showNextDialog();
        } else {
            BiliImageLoader.INSTANCE.acquire(view).useRaw().asDrawable().url(item.getUrl()).submit().subscribe(new PublishBubbleDialog$onShow$1(this, item, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPopupWindow(UpperCenterPlusBubbleService.BubbleInfo item, TabHost anchor, String originTabUrl, Drawable drawable) {
        Lifecycle.State currentState;
        if (anchor.isAttachedToWindow()) {
            Context context = anchor.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Lifecycle lifecycle = ListExtentionsKt.lifecycle(context);
            boolean z = true;
            if (((lifecycle == null || (currentState = lifecycle.getCurrentState()) == null || true != currentState.isAtLeast(Lifecycle.State.RESUMED)) ? false : true) && anchor.getLocalVisibleRect(new Rect())) {
                if (PublishBubbleDialogKt.getInMainDialogManager()) {
                    if (anchor.getCurrentItem() == 0) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    this.popupWindow = new PublishBubblePopupWindow(item, (View) anchor, originTabUrl, drawable);
                    PublishBubblePopupWindow publishBubblePopupWindow = this.popupWindow;
                    if (publishBubblePopupWindow != null) {
                        publishBubblePopupWindow.show();
                        return;
                    }
                    return;
                }
            }
        }
        PublishBubbleDialogKt.showNextDialog();
        BLog.i(TabHostGarbProviderKt.TAG, "show popup failed, page is not visible");
    }
}