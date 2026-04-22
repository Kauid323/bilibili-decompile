package tv.danmaku.bili.ui.main2.mine;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.magicasakura.widgets.Tintable;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.holder.MineButtonNoticeHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineCommonNoticeHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineGameModuleHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineLiveTipModuleHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineNormalModuleHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineNotUpperModuleHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineNoticeHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineSilenceHolder;
import tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder;

/* compiled from: HomeUserCenterAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0080@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0016J&\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\"2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180\nH\u0016J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\"H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0002H\u0016J\u0006\u0010*\u001a\u00020\u001aR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fragment", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment;", "itemClickListener", "Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment;Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;)V", "data", "", "Lcom/bilibili/lib/homepage/mine/MenuGroup;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "pageVisibility", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "mItemClickListener", "getMItemClickListener", "()Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;", "mFragment", "tintPayload", "", "collectPageVisibility", "", "Lkotlinx/coroutines/flow/StateFlow;", "collectPageVisibility$core_apinkDebug", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "payloads", "onViewAttachedToWindow", "onThemeChanged", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeUserCenterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int MINE_VIEW_TYPE_BUTTON_NOTICE = 9;
    public static final int MINE_VIEW_TYPE_COMMON_NOTICE = 8;
    public static final int MINE_VIEW_TYPE_MODULE_GAME = 7;
    public static final int MINE_VIEW_TYPE_MODULE_LIVE_TIP = 6;
    public static final int MINE_VIEW_TYPE_MODULE_NORMAL = 3;
    public static final int MINE_VIEW_TYPE_MODULE_NO_UPER = 5;
    public static final int MINE_VIEW_TYPE_MODULE_UPER = 4;
    public static final int MINE_VIEW_TYPE_NOTICE = 1;
    public static final int MINE_VIEW_TYPE_SILENCE = 2;
    public static final int MINE_VIEW_TYPE_UPCOMING = 10;
    private List<MenuGroup> data;
    private final HomeUserCenterFragment mFragment;
    private final IMineItemClickListener mItemClickListener;
    private final MutableStateFlow<Boolean> pageVisibility;
    private final Object tintPayload;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public HomeUserCenterAdapter(HomeUserCenterFragment fragment, IMineItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.data = new ArrayList();
        this.pageVisibility = StateFlowKt.MutableStateFlow(false);
        this.mItemClickListener = itemClickListener;
        this.mFragment = fragment;
        this.tintPayload = new Object();
    }

    public final List<MenuGroup> getData() {
        return this.data;
    }

    public final void setData(List<MenuGroup> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    public final IMineItemClickListener getMItemClickListener() {
        return this.mItemClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectPageVisibility$core_apinkDebug(StateFlow<Boolean> stateFlow, Continuation<? super Unit> continuation) {
        HomeUserCenterAdapter$collectPageVisibility$1 homeUserCenterAdapter$collectPageVisibility$1;
        if (continuation instanceof HomeUserCenterAdapter$collectPageVisibility$1) {
            homeUserCenterAdapter$collectPageVisibility$1 = (HomeUserCenterAdapter$collectPageVisibility$1) continuation;
            if ((homeUserCenterAdapter$collectPageVisibility$1.label & Integer.MIN_VALUE) != 0) {
                homeUserCenterAdapter$collectPageVisibility$1.label -= Integer.MIN_VALUE;
                Object $result = homeUserCenterAdapter$collectPageVisibility$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (homeUserCenterAdapter$collectPageVisibility$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        homeUserCenterAdapter$collectPageVisibility$1.label = 1;
                        if (stateFlow.collect(this.pageVisibility, homeUserCenterAdapter$collectPageVisibility$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            }
        }
        homeUserCenterAdapter$collectPageVisibility$1 = new HomeUserCenterAdapter$collectPageVisibility$1(this, continuation);
        Object $result2 = homeUserCenterAdapter$collectPageVisibility$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (homeUserCenterAdapter$collectPageVisibility$1.label) {
        }
        throw new KotlinNothingValueException();
    }

    /* compiled from: HomeUserCenterAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAdapter$Companion;", "", "<init>", "()V", "MINE_VIEW_TYPE_NOTICE", "", "MINE_VIEW_TYPE_SILENCE", "MINE_VIEW_TYPE_MODULE_NORMAL", "MINE_VIEW_TYPE_MODULE_UPER", "MINE_VIEW_TYPE_MODULE_NO_UPER", "MINE_VIEW_TYPE_MODULE_LIVE_TIP", "MINE_VIEW_TYPE_MODULE_GAME", "MINE_VIEW_TYPE_COMMON_NOTICE", "MINE_VIEW_TYPE_BUTTON_NOTICE", "MINE_VIEW_TYPE_UPCOMING", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                MineNoticeHolder create = MineNoticeHolder.create(parent, this.mItemClickListener);
                Intrinsics.checkNotNullExpressionValue(create, "create(...)");
                return create;
            case 2:
                MineSilenceHolder create2 = MineSilenceHolder.create(parent, this.mItemClickListener);
                Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
                return create2;
            case 3:
                MineNormalModuleHolder create3 = MineNormalModuleHolder.create(parent, this, this.mFragment);
                Intrinsics.checkNotNullExpressionValue(create3, "create(...)");
                return create3;
            case 4:
                MineNormalModuleHolder create4 = MineNormalModuleHolder.create(parent, this, this.mFragment);
                Intrinsics.checkNotNullExpressionValue(create4, "create(...)");
                return create4;
            case 5:
                MineNotUpperModuleHolder create5 = MineNotUpperModuleHolder.create(parent, this.mFragment);
                Intrinsics.checkNotNullExpressionValue(create5, "create(...)");
                return create5;
            case 6:
                MineLiveTipModuleHolder create6 = MineLiveTipModuleHolder.create(parent);
                Intrinsics.checkNotNullExpressionValue(create6, "create(...)");
                return create6;
            case 7:
                return new MineGameModuleHolder(parent, this, this.mFragment);
            case 8:
                return new MineCommonNoticeHolder(parent, this.mItemClickListener);
            case 9:
                return new MineButtonNoticeHolder(parent, this.mItemClickListener);
            case 10:
                return MineUpComingHolder.Companion.create(parent, (StateFlow) this.pageVisibility);
            default:
                throw new IllegalStateException("Unknown view type " + viewType + " found in home channel page");
        }
    }

    public int getItemCount() {
        return this.data.size();
    }

    public int getItemViewType(int position) {
        return this.data.get(position).viewType;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> list) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (list.size() == 1 && CollectionsKt.firstOrNull(list) == this.tintPayload) {
            Object $this$asTo$iv = holder;
            if (!($this$asTo$iv instanceof Tintable)) {
                $this$asTo$iv = null;
            }
            Tintable tintable = (Tintable) $this$asTo$iv;
            if (tintable != null) {
                tintable.tint();
                return;
            }
            return;
        }
        super.onBindViewHolder(holder, position, list);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof MineSilenceHolder) {
            ((MineSilenceHolder) holder).bind(this.mFragment.getMMineInfo());
        } else if (holder instanceof MineNoticeHolder) {
            ((MineNoticeHolder) holder).bind(this.mFragment.getNoticeResult());
        } else if (holder instanceof MineNormalModuleHolder) {
            ((MineNormalModuleHolder) holder).bind(this.data.get(position));
        } else if (holder instanceof MineNotUpperModuleHolder) {
            ((MineNotUpperModuleHolder) holder).bind(this.data.get(position));
        } else if (holder instanceof MineLiveTipModuleHolder) {
            ((MineLiveTipModuleHolder) holder).bind(this.mFragment.getMMineInfo());
        } else if (holder instanceof MineCommonNoticeHolder) {
            MenuGroup p0 = (MenuGroup) CollectionsKt.getOrNull(this.data, position);
            if (p0 != null) {
                ((MineCommonNoticeHolder) holder).bind(p0);
            }
        } else if (holder instanceof MineUpComingHolder) {
            MineUpComingHolder mineUpComingHolder = (MineUpComingHolder) holder;
            AccountMine mMineInfo = this.mFragment.getMMineInfo();
            mineUpComingHolder.bind(mMineInfo != null ? mMineInfo.videoUpdateCalendar : null);
        }
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder instanceof MineNormalModuleHolder) {
            ((MineNormalModuleHolder) holder).onAttachedToRecyclerView();
        }
        if (holder instanceof MineCommonNoticeHolder) {
            ((MineCommonNoticeHolder) holder).onAttachedToRecyclerView();
        }
    }

    public final void onThemeChanged() {
        if (getItemCount() > 0) {
            notifyItemRangeChanged(0, getItemCount(), this.tintPayload);
        }
    }
}