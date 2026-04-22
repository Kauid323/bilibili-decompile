package tv.danmaku.bili.ui.main2.basic.dialog.top;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageBubble;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: TopTabBubbleMainDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubbleMainDialog;", "Lcom/bilibili/app/dialogmanager/MainDialogManager$IDialogInterface;", "anchor", "Landroid/view/View;", "item", "Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/view/View;Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;Landroid/graphics/drawable/Drawable;)V", "getAnchor", "()Landroid/view/View;", "setAnchor", "(Landroid/view/View;)V", "getItem", "()Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "onShow", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopTabBubbleMainDialog implements MainDialogManager.IDialogInterface {
    public static final int $stable = 8;
    private View anchor;
    private final Drawable drawable;
    private final SecondaryPageBubble item;

    public TopTabBubbleMainDialog(View anchor, SecondaryPageBubble item, Drawable drawable) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.anchor = anchor;
        this.item = item;
        this.drawable = drawable;
    }

    public final View getAnchor() {
        return this.anchor;
    }

    public final void setAnchor(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.anchor = view;
    }

    public final SecondaryPageBubble getItem() {
        return this.item;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public void onShow() {
        new TopTabBubblePopWindow(this.anchor, this.drawable, this.item).show();
    }
}