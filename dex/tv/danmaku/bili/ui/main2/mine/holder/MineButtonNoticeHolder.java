package tv.danmaku.bili.ui.main2.mine.holder;

import android.graphics.ColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;

/* compiled from: MineCommonNoticeHolder.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/holder/MineButtonNoticeHolder;", "Ltv/danmaku/bili/ui/main2/mine/holder/MineCommonNoticeHolder;", "parent", "Landroid/view/ViewGroup;", "itemClickListener", "Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;", "<init>", "(Landroid/view/ViewGroup;Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;)V", "bindActionIcon", "", "op", "Lcom/bilibili/lib/homepage/mine/MenuGroup$CommonOpItem;", "item", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "menuGroup", "Lcom/bilibili/lib/homepage/mine/MenuGroup;", "setActionColor", "isNight", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineButtonNoticeHolder extends MineCommonNoticeHolder {
    public static final int $stable = 8;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MineButtonNoticeHolder(ViewGroup parent, IMineItemClickListener itemClickListener) {
        super(r0);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_button_notice, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setMItemClickListener(itemClickListener);
    }

    public /* synthetic */ MineButtonNoticeHolder(ViewGroup viewGroup, IMineItemClickListener iMineItemClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : iMineItemClickListener);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.MineCommonNoticeHolder
    public void bindActionIcon(MenuGroup.CommonOpItem op, MenuGroup.Item item, MenuGroup menuGroup) {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(menuGroup, "menuGroup");
        BiliImageView icAction = getIcAction();
        Intrinsics.checkNotNullExpressionValue(icAction, "<get-icAction>(...)");
        ImageExtentionKt.displayImage$default(icAction, op.linkIcon, (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.MineCommonNoticeHolder
    public void setActionColor(boolean isNight, MenuGroup.CommonOpItem op) {
        Intrinsics.checkNotNullParameter(op, "op");
        super.setActionColor(isNight, op);
        if (!isNight) {
            getIcAction().setColorFilter((ColorFilter) null);
        }
    }
}