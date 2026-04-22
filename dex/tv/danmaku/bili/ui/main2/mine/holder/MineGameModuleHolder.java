package tv.danmaku.bili.ui.main2.mine.holder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.lifecycle.UnStickyEventObserver;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.mine.MenuItemTip;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterAdapter;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.notice.NoticeCacheService;
import tv.danmaku.bili.ui.notice.NoticeExtKt;

/* compiled from: MineGameModuleHolder.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010 \u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/holder/MineGameModuleHolder;", "Ltv/danmaku/bili/ui/main2/mine/holder/MineNormalModuleHolder;", "Landroid/view/ViewStub$OnInflateListener;", "parent", "Landroid/view/ViewGroup;", "adapter", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAdapter;", "fragment", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment;", "<init>", "(Landroid/view/ViewGroup;Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAdapter;Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment;)V", "llTips", "Landroid/view/View;", "ivTips", "Lcom/bilibili/lib/image2/view/BiliImageView;", "tvTips", "Landroid/widget/TextView;", "vsTips", "Landroid/view/ViewStub;", "icArrow", "mTip", "Lcom/bilibili/lib/homepage/mine/MenuItemTip;", "onInflate", "", "stub", "inflated", "bind", "data", "Lcom/bilibili/lib/homepage/mine/MenuGroup;", "reportTips", "from", "", "reportButton", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGameModuleHolder extends MineNormalModuleHolder implements ViewStub.OnInflateListener {
    public static final int $stable = 8;
    private View icArrow;
    private BiliImageView ivTips;
    private View llTips;
    private MenuItemTip mTip;
    private TextView tvTips;
    private ViewStub vsTips;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineGameModuleHolder(ViewGroup parent, HomeUserCenterAdapter adapter, HomeUserCenterFragment fragment) {
        super(MineGameModuleHolderKt.access$inflateFrom(R.layout.bili_layout_main_user_center_module_normal, parent), adapter, fragment);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewStub $this$_init__u24lambda_u240 = (ViewStub) this.itemView.findViewById(R.id.button_tip);
        if ($this$_init__u24lambda_u240 != null) {
            $this$_init__u24lambda_u240.setOnInflateListener(this);
        } else {
            $this$_init__u24lambda_u240 = null;
        }
        this.vsTips = $this$_init__u24lambda_u240;
        this.icArrow = this.itemView.findViewById(R.id.ic_arrow);
    }

    @Override // android.view.ViewStub.OnInflateListener
    public void onInflate(ViewStub stub, View inflated) {
        this.vsTips = null;
        this.llTips = inflated;
        this.ivTips = inflated != null ? (BiliImageView) inflated.findViewById(R.id.iv_tips) : null;
        this.tvTips = inflated != null ? (TextView) inflated.findViewById(R.id.tv_tips) : null;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder
    public void bind(final MenuGroup data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.bind(data);
        Unit unit = Unit.INSTANCE;
        List list = data.menuItemTips;
        final MenuItemTip tips = list != null ? NoticeExtKt.findValidOrNull(list) : null;
        this.mTip = tips;
        if (tips != null) {
            if (this.itemView.isAttachedToWindow()) {
                reportTips("game_tips_binding");
            }
            ListExtentionsKt.gone(this.mButtonLayout);
            ListExtentionsKt.gone(this.mButtonForward);
            ViewStub viewStub = this.vsTips;
            if (viewStub != null) {
                ViewStub viewStub2 = (ViewStub) ListExtentionsKt.visible(viewStub);
            }
            View view = this.llTips;
            if (view != null) {
                ListExtentionsKt.visible(view);
            }
            View view2 = this.icArrow;
            if (view2 != null) {
                ListExtentionsKt.visible(view2);
            }
            BiliImageView biliImageView = this.ivTips;
            if (biliImageView != null) {
                ImageExtentionKt.displayImage$default(biliImageView, tips.getIcon(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
            }
            TextView textView = this.tvTips;
            if (textView != null) {
                textView.setText(tips.getContent());
            }
            View view3 = this.llTips;
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineGameModuleHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        MineGameModuleHolder.bind$lambda$0$0(tips, data, this, view4);
                    }
                });
            }
            View view4 = this.llTips;
            if (view4 != null) {
                view4.requestLayout();
                return;
            }
            return;
        }
        View view5 = this.llTips;
        if (view5 != null) {
            ListExtentionsKt.gone(view5);
        }
        View view6 = this.icArrow;
        if (view6 != null) {
            ListExtentionsKt.gone(view6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(final MenuItemTip $tips, MenuGroup $data, final MineGameModuleHolder this$0, View it) {
        HashMap extra = new HashMap(4);
        extra.put("issue_type", $tips.getLocalDefault() ? "1" : "0");
        extra.put("icon_type", $tips.hasIcon() ? "special" : MineReporter.MINE_ICON_TYPE_DEFAULT);
        extra.put("module_id", "0");
        extra.put("entity", AppConfig.HOST_GAME);
        HashMap hashMap = extra;
        String id = $tips.getId();
        if (id == null) {
            id = "";
        }
        hashMap.put("batch_id", id);
        $tips.setClicked(true);
        Iterable iterable = $data.menuItemTips;
        if (iterable != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                MenuItemTip tip = (MenuItemTip) element$iv;
                tip.setTempHidden(true);
            }
        }
        LifecycleOwner findFragmentActivityOrNull = UtilKt.findFragmentActivityOrNull(it.getContext());
        if (findFragmentActivityOrNull != null) {
            final LifecycleOwner $this$onNextEvent$iv = findFragmentActivityOrNull;
            final Lifecycle.Event e$iv = Lifecycle.Event.ON_START;
            LifecycleObserver lifecycleObserver = new UnStickyEventObserver() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineGameModuleHolder$bind$lambda$0$0$$inlined$onNextEvent$1
                public void onEvent(LifecycleOwner source, Lifecycle.Event event) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event != e$iv) {
                        return;
                    }
                    NoticeExtKt.close($tips);
                    NoticeCacheService.Companion.ofTips().hideTips();
                    RecyclerView.Adapter bindingAdapter = this$0.getBindingAdapter();
                    if (bindingAdapter != null) {
                        bindingAdapter.notifyItemChanged(this$0.getBindingAdapterPosition());
                    }
                    $this$onNextEvent$iv.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            };
            $this$onNextEvent$iv.getLifecycle().addObserver(lifecycleObserver);
            lifecycleObserver.onAdded();
        }
        MineReporter.reportMineItemClickWithRedDot(null, 4, 0, $tips.getContent(), extra);
        String url = $tips.getUrl();
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(url != null ? url : ""), it.getContext());
    }

    private final void reportTips(String from) {
        MenuItemTip first = this.mTip;
        if (first != null && !first.getExposed()) {
            first.setExposed(true);
            HashMap extra = new HashMap(4);
            extra.put("issue_type", first.getLocalDefault() ? "1" : "0");
            extra.put("icon_type", first.hasIcon() ? "special" : MineReporter.MINE_ICON_TYPE_DEFAULT);
            extra.put("module_id", "0");
            extra.put("entity", AppConfig.HOST_GAME);
            HashMap hashMap = extra;
            String id = first.getId();
            if (id == null) {
                id = "";
            }
            hashMap.put("batch_id", id);
            MineReporter.reportMineItemShowWithRedDot(null, 4, 0, first.getContent(), extra, from);
        }
    }

    @Override // tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder
    protected void reportButton(String from) {
        reportTips(from);
        super.reportButton(from);
    }
}