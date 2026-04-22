package tv.danmaku.bili.ui.main2.mine.holder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.IMineItemClickListener;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.notice.NoticeExtKt;

/* compiled from: MineCommonNoticeHolder.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0014\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u00104\u001a\u0002052\u0006\u0010%\u001a\u00020&J \u00106\u001a\u0002052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0016J&\u00107\u001a\u0002052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J$\u00108\u001a\u0002052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010&J\u0018\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010<\u001a\u0002052\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010=\u001a\u0002052\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J,\u0010>\u001a\u00020?2\u0006\u0010:\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010A2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020?0CH\u0084\bø\u0001\u0000J\b\u0010D\u001a\u000205H\u0016J\u0006\u0010E\u001a\u000205R\u001c\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u00100\u001a\u0002018DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/holder/MineCommonNoticeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bilibili/magicasakura/widgets/Tintable;", "parent", "Landroid/view/ViewGroup;", "itemClickListener", "Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;", "<init>", "(Landroid/view/ViewGroup;Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;)V", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icNotice", "Lcom/bilibili/lib/image2/view/BiliImageView;", "kotlin.jvm.PlatformType", "getIcNotice", "()Lcom/bilibili/lib/image2/view/BiliImageView;", "tvContent", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "tvAction", "getTvAction", "icAction", "getIcAction", "op", "Lcom/bilibili/lib/homepage/mine/MenuGroup$CommonOpItem;", "getOp", "()Lcom/bilibili/lib/homepage/mine/MenuGroup$CommonOpItem;", "setOp", "(Lcom/bilibili/lib/homepage/mine/MenuGroup$CommonOpItem;)V", "item", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "getItem", "()Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "setItem", "(Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;)V", "menuGroup", "Lcom/bilibili/lib/homepage/mine/MenuGroup;", "getMenuGroup", "()Lcom/bilibili/lib/homepage/mine/MenuGroup;", "setMenuGroup", "(Lcom/bilibili/lib/homepage/mine/MenuGroup;)V", "mItemClickListener", "getMItemClickListener", "()Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;", "setMItemClickListener", "(Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "bind", "", "bindActionIcon", "action", "close", "setBack", "isNight", "", "setTitleColor", "setActionColor", "getColor", "", "colorStr", "", "defaultColor", "Lkotlin/Function0;", "tint", "onAttachedToRecyclerView", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class MineCommonNoticeHolder extends RecyclerView.ViewHolder implements Tintable {
    public static final int $stable = 8;
    private final BiliImageView icAction;
    private final BiliImageView icNotice;
    private MenuGroup.Item item;
    private IMineItemClickListener mItemClickListener;
    private MenuGroup menuGroup;
    private MenuGroup.CommonOpItem op;
    private final TextView tvAction;
    private final TextView tvContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineCommonNoticeHolder(ViewGroup parent, IMineItemClickListener itemClickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_common_notice, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.icNotice = this.itemView.findViewById(R.id.ic_notice);
        this.tvContent = (TextView) this.itemView.findViewById(R.id.content);
        this.tvAction = (TextView) this.itemView.findViewById(R.id.tv_action);
        this.icAction = this.itemView.findViewById(R.id.ic_action);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineCommonNoticeHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineCommonNoticeHolder._init_$lambda$0(MineCommonNoticeHolder.this, view);
            }
        });
        this.icAction.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineCommonNoticeHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineCommonNoticeHolder._init_$lambda$1(MineCommonNoticeHolder.this, view);
            }
        });
        this.mItemClickListener = itemClickListener;
    }

    public /* synthetic */ MineCommonNoticeHolder(ViewGroup viewGroup, IMineItemClickListener iMineItemClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : iMineItemClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineCommonNoticeHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.icNotice = this.itemView.findViewById(R.id.ic_notice);
        this.tvContent = (TextView) this.itemView.findViewById(R.id.content);
        this.tvAction = (TextView) this.itemView.findViewById(R.id.tv_action);
        this.icAction = this.itemView.findViewById(R.id.ic_action);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineCommonNoticeHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineCommonNoticeHolder._init_$lambda$0(MineCommonNoticeHolder.this, view);
            }
        });
        this.icAction.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineCommonNoticeHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineCommonNoticeHolder._init_$lambda$1(MineCommonNoticeHolder.this, view);
            }
        });
    }

    protected final BiliImageView getIcNotice() {
        return this.icNotice;
    }

    protected final TextView getTvContent() {
        return this.tvContent;
    }

    protected final TextView getTvAction() {
        return this.tvAction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BiliImageView getIcAction() {
        return this.icAction;
    }

    protected final MenuGroup.CommonOpItem getOp() {
        return this.op;
    }

    protected final void setOp(MenuGroup.CommonOpItem commonOpItem) {
        this.op = commonOpItem;
    }

    protected final MenuGroup.Item getItem() {
        return this.item;
    }

    protected final void setItem(MenuGroup.Item item) {
        this.item = item;
    }

    protected final MenuGroup getMenuGroup() {
        return this.menuGroup;
    }

    protected final void setMenuGroup(MenuGroup menuGroup) {
        this.menuGroup = menuGroup;
    }

    public final IMineItemClickListener getMItemClickListener() {
        return this.mItemClickListener;
    }

    public final void setMItemClickListener(IMineItemClickListener iMineItemClickListener) {
        this.mItemClickListener = iMineItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MineCommonNoticeHolder this$0, View it) {
        MenuGroup.CommonOpItem commonOpItem = this$0.op;
        String str = commonOpItem != null ? commonOpItem.title : null;
        MenuGroup.Item item = this$0.item;
        MineReporter.reportMineModuleButtonClick$default(str, null, null, item != null ? Long.valueOf(item.id) : null, 6, null);
        this$0.action(this$0.op, this$0.item, this$0.menuGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(MineCommonNoticeHolder this$0, View it) {
        MineReporter mineReporter = MineReporter.INSTANCE;
        MenuGroup.CommonOpItem commonOpItem = this$0.op;
        String str = commonOpItem != null ? commonOpItem.title : null;
        MenuGroup.Item item = this$0.item;
        mineReporter.reportMineModuleCloseClick(str, item != null ? Long.valueOf(item.id) : null);
        this$0.close(this$0.op, this$0.item, this$0.menuGroup);
    }

    protected final Context getContext() {
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004f, code lost:
        if ((!kotlin.text.StringsKt.isBlank(r5)) == true) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(MenuGroup menuGroup) {
        MenuGroup.CommonOpItem op;
        boolean z;
        Intrinsics.checkNotNullParameter(menuGroup, "menuGroup");
        MenuGroup.Item item = NoticeExtKt.findFirstNotice(menuGroup);
        if (item == null || (op = item.commonOpItem) == null) {
            return;
        }
        this.op = op;
        this.item = item;
        this.menuGroup = menuGroup;
        BiliImageView biliImageView = this.icNotice;
        Intrinsics.checkNotNullExpressionValue(biliImageView, "icNotice");
        ImageExtentionKt.displayImage$default(biliImageView, op.titleIcon, (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
        this.tvContent.setText(op.title);
        View $this$setVisibleOrGone$iv = this.tvAction;
        if (op.text != null) {
            z = true;
        }
        z = false;
        boolean show$iv = z;
        if ($this$setVisibleOrGone$iv != null) {
            $this$setVisibleOrGone$iv.setVisibility(show$iv ? 0 : 8);
        }
        if (show$iv && $this$setVisibleOrGone$iv != null) {
            TextView $this$bind_u24lambda_u240 = (TextView) $this$setVisibleOrGone$iv;
            $this$bind_u24lambda_u240.setText(op.text);
        }
        bindActionIcon(op, item, menuGroup);
        boolean isNight = MultipleThemeUtils.isNightTheme(getContext());
        setBack(isNight, op);
        setTitleColor(isNight, op);
        setActionColor(isNight, op);
    }

    public void bindActionIcon(MenuGroup.CommonOpItem op, MenuGroup.Item item, MenuGroup menuGroup) {
        int fallbackIcon;
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(menuGroup, "menuGroup");
        switch (op.linkType) {
            case 1:
            case 2:
                fallbackIcon = com.bilibili.app.comm.baseres.R.drawable.ic_arrow_right_gray;
                break;
            case 3:
            case 4:
            default:
                fallbackIcon = 0;
                break;
            case 5:
                fallbackIcon = R.drawable.ic_mine_notice_close;
                break;
        }
        this.icAction.setImageResource(fallbackIcon);
    }

    public void action(MenuGroup.CommonOpItem op, MenuGroup.Item item, MenuGroup menuGroup) {
        String str;
        RouteRequest it;
        if (item != null && (str = item.uri) != null && (it = RouteRequestKt.toRouteRequest(str)) != null) {
            BLRouter.routeTo(it, getContext());
        }
    }

    public final void close(MenuGroup.CommonOpItem op, MenuGroup.Item item, MenuGroup menuGroup) {
        IMineItemClickListener iMineItemClickListener;
        boolean z = false;
        if (op != null && op.linkType == 5) {
            z = true;
        }
        if (!z || (iMineItemClickListener = this.mItemClickListener) == null) {
            return;
        }
        iMineItemClickListener.onNoticeItemClickClose(getBindingAdapterPosition(), menuGroup, item);
    }

    public void setBack(boolean isNight, MenuGroup.CommonOpItem op) {
        int color;
        Intrinsics.checkNotNullParameter(op, "op");
        View view = this.itemView;
        GradientDrawable $this$setBack_u24lambda_u240 = new GradientDrawable();
        $this$setBack_u24lambda_u240.setCornerRadius(ListExtentionsKt.toPx(4));
        String colorStr$iv = op.backgroundColor;
        if (!isNight) {
            String str = colorStr$iv;
            if (!(str == null || StringsKt.isBlank(str))) {
                try {
                    color = Color.parseColor(colorStr$iv);
                } catch (Exception e) {
                    color = ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga0_s);
                }
                $this$setBack_u24lambda_u240.setColor(color);
                view.setBackground($this$setBack_u24lambda_u240);
            }
        }
        color = ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga0_s);
        $this$setBack_u24lambda_u240.setColor(color);
        view.setBackground($this$setBack_u24lambda_u240);
    }

    public void setTitleColor(boolean isNight, MenuGroup.CommonOpItem op) {
        int color;
        Intrinsics.checkNotNullParameter(op, "op");
        TextView textView = this.tvContent;
        String colorStr$iv = op.titleColor;
        if (!isNight) {
            String str = colorStr$iv;
            if (!(str == null || StringsKt.isBlank(str))) {
                try {
                    color = Color.parseColor(colorStr$iv);
                } catch (Exception e) {
                    color = ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Text1);
                }
                textView.setTextColor(color);
            }
        }
        color = ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Text1);
        textView.setTextColor(color);
    }

    public void setActionColor(boolean isNight, MenuGroup.CommonOpItem op) {
        int color;
        Intrinsics.checkNotNullParameter(op, "op");
        String colorStr$iv = op.linkContainerColor;
        if (!isNight) {
            String str = colorStr$iv;
            if (!(str == null || StringsKt.isBlank(str))) {
                try {
                    color = Color.parseColor(colorStr$iv);
                } catch (Exception e) {
                    color = ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga7);
                }
                int color2 = color;
                this.tvAction.setTextColor(color2);
                this.icAction.setColorFilter(color2);
            }
        }
        color = ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga7);
        int color22 = color;
        this.tvAction.setTextColor(color22);
        this.icAction.setColorFilter(color22);
    }

    protected final int getColor(boolean isNight, String colorStr, Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultColor");
        if (!isNight) {
            String str = colorStr;
            if (!(str == null || StringsKt.isBlank(str))) {
                try {
                    return Color.parseColor(colorStr);
                } catch (Exception e) {
                    return ((Number) function0.invoke()).intValue();
                }
            }
        }
        return ((Number) function0.invoke()).intValue();
    }

    public void tint() {
        MenuGroup p0 = this.menuGroup;
        if (p0 != null) {
            bind(p0);
        }
    }

    public final void onAttachedToRecyclerView() {
        MineReporter mineReporter = MineReporter.INSTANCE;
        MenuGroup.CommonOpItem commonOpItem = this.op;
        String str = commonOpItem != null ? commonOpItem.title : null;
        MenuGroup.Item item = this.item;
        mineReporter.reportMineModuleShow(str, item != null ? Long.valueOf(item.id) : null);
    }
}