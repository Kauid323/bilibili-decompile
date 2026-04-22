package tv.danmaku.bili.ui.main2.mine.modularvip;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.IGenericProperties;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModuleManager.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"TAG", "", "reset", "Lcom/bilibili/lib/image2/view/BiliImageView;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipModuleManagerKt {
    public static final String TAG = "MineVipRefactoring";

    public static final BiliImageView reset(BiliImageView $this$reset) {
        Intrinsics.checkNotNullParameter($this$reset, "<this>");
        $this$reset.setAlpha(1.0f);
        ImageExtentionKt.displayDefaultImage($this$reset);
        IGenericProperties $this$reset_u24lambda_u240 = $this$reset.getGenericProperties();
        $this$reset_u24lambda_u240.setImage(new ColorDrawable(0));
        $this$reset_u24lambda_u240.setOverlayImage((Drawable) null);
        $this$reset_u24lambda_u240.setBackground((Drawable) null);
        $this$reset_u24lambda_u240.setPlaceholderImage((Drawable) null);
        IGenericProperties.-CC.setActualImageColorFilterByValue$default($this$reset_u24lambda_u240, 0, (PorterDuff.Mode) null, 2, (Object) null);
        return $this$reset;
    }
}