package tv.danmaku.bili.auth.modify;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.auth.R;
import com.bilibili.droid.ToastHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.BiliAuthExtsKt;
import tv.danmaku.bili.auth.helper.CheckStatusListener;
import tv.danmaku.bili.auth.modify.BiliAuthModifyFragment;
import tv.danmaku.bili.auth.v2.BiliAuditingFragmentV2;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;
import tv.danmaku.bili.widget.recycler.DividerDecoration;

/* compiled from: BiliAuthModifyFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0006\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "<init>", "()V", "modifyAllow", "", "getModifyAllow", "()Z", "setModifyAllow", "(Z)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "buildModifyItems", "list", "Landroidx/recyclerview/widget/RecyclerView;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ItemHolder", "ItemAdapter", "RealnameModify", "ModifyType", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthModifyFragment extends BaseAuthModifyFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthModifyFragment";
    private boolean modifyAllow;

    public final boolean getModifyAllow() {
        return this.modifyAllow;
    }

    public final void setModifyAllow(boolean z) {
        this.modifyAllow = z;
    }

    /* compiled from: BiliAuthModifyFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthModifyFragment newInstance(Bundle params) {
            BiliAuthModifyFragment fragment = new BiliAuthModifyFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_modify, container, false);
        return view;
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(bili.resource.account.R.string.account_global_string_263);
        }
        RecyclerView findViewById = view.findViewById(R.id.modify_list);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView list = findViewById;
        list.setLayoutManager(new LinearLayoutManager(view.getContext()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BiliAuthModifyFragment$onViewCreated$1(this, list, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void buildModifyItems(RecyclerView list) {
        List supportList = BiliAuthExtsKt.getRealnameModifyList();
        final List items = new ArrayList();
        if (supportList.contains("modify")) {
            RealnameModify modify_name = new RealnameModify(this, getString(bili.resource.account.R.string.account_global_string_227), getString(bili.resource.account.R.string.account_global_string_282), getURL_BILI_AUTH_MODIFY_NAME$auth_debug(), ModifyType.NAME);
            items.add(modify_name);
        }
        if (supportList.contains("change") && this.modifyAllow) {
            RealnameModify modify_person = new RealnameModify(this, getString(bili.resource.account.R.string.account_global_string_249), getString(bili.resource.account.R.string.account_global_string_283), getURL_BILI_AUTH_MODIFY_PERSON$auth_debug(), ModifyType.PERSON);
            items.add(modify_person);
        }
        BLog.i(TAG, "buildModifyItems");
        final int i = com.bilibili.app.comm.baseres.R.color.daynight_color_dividing_line;
        final int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.bilibili.app.comm.baseres.R.dimen.item_medium_spacing);
        list.addItemDecoration(new DividerDecoration(i, dimensionPixelOffset) { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyFragment$buildModifyItems$1
            protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
                return (holder == null || holder.getAdapterPosition() == items.size() - 1) ? false : true;
            }

            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top = this.getResources().getDimensionPixelOffset(R.dimen.profile_tips_bottom_margin_top);
                }
            }
        });
        list.setAdapter(new ItemAdapter(this, items));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getModifyAllow(Continuation<? super Boolean> continuation) {
        return TimeoutKt.withTimeout(5000L, new BiliAuthModifyFragment$getModifyAllow$2(null), continuation);
    }

    /* compiled from: BiliAuthModifyFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fR\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;Landroid/view/View;)V", "nameView", "Landroid/widget/TextView;", "tipsView", "bind", "", "item", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$RealnameModify;", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class ItemHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        final /* synthetic */ BiliAuthModifyFragment this$0;
        private final TextView tipsView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHolder(BiliAuthModifyFragment this$0, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = this$0;
            View findViewById = itemView.findViewById(R.id.modify_item);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.nameView = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.item_tips);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tipsView = (TextView) findViewById2;
        }

        public final void bind(final RealnameModify item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.nameView.setText(item.getName());
            this.tipsView.setText(item.getTips());
            View view = this.itemView;
            final BiliAuthModifyFragment biliAuthModifyFragment = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyFragment$ItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BiliAuthModifyFragment.ItemHolder.bind$lambda$0(BiliAuthModifyFragment.this, item, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(final BiliAuthModifyFragment this$0, final RealnameModify $item, View it) {
            this$0.getMModifyHelper().requestCheckStatus(Integer.valueOf($item.getType().getValue()), new CheckStatusListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyFragment$ItemHolder$bind$1$1

                /* compiled from: BiliAuthModifyFragment.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                public static final /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[BiliAuthModifyFragment.ModifyType.values().length];
                        try {
                            iArr[BiliAuthModifyFragment.ModifyType.NAME.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[BiliAuthModifyFragment.ModifyType.PERSON.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // tv.danmaku.bili.auth.helper.CheckStatusListener
                public void onPassed() {
                    switch (WhenMappings.$EnumSwitchMapping$0[BiliAuthModifyFragment.RealnameModify.this.getType().ordinal()]) {
                        case 1:
                            this$0.showFragmentWithBundle(this$0.getContext(), this$0.getArguments(), (Fragment) this$0, this$0.getURL_BILI_AUTH_MODIFY_NAME$auth_debug(), BiliAuthModifyNameFragment.TAG);
                            return;
                        case 2:
                            this$0.showFragmentWithBundle(this$0.getContext(), this$0.getArguments(), (Fragment) this$0, this$0.getURL_BILI_AUTH_MODIFY_PERSON$auth_debug(), "BiliAuthModifyPersonFragment");
                            return;
                        default:
                            this$0.showFragmentWithBundle(this$0.getContext(), this$0.getArguments(), (Fragment) this$0, this$0.getURL_BILI_AUTH_MODIFY_ERROR$auth_debug(), "BiliAuthModifySuccessFragment");
                            return;
                    }
                }

                @Override // tv.danmaku.bili.auth.helper.CheckStatusListener
                public void onReject(ArrayList<String> arrayList) {
                    Bundle bundle = this$0.getArguments();
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putStringArrayList(this$0.getBUNDLE_KEY_FAIL_TIPS$auth_debug(), arrayList);
                    this$0.showFragmentWithBundle(this$0.getContext(), bundle, (Fragment) this$0, this$0.getURL_BILI_AUTH_MODIFY_ERROR$auth_debug(), "BiliAuthModifySuccessFragment");
                }

                @Override // tv.danmaku.bili.auth.helper.CheckStatusListener
                public void onApplying() {
                    this$0.popBackStack();
                    this$0.showFragmentWithBundle(this$0.getContext(), this$0.getArguments(), (Fragment) this$0, this$0.getURL_BILI_AUTH_MODIFY_APPLYING$auth_debug(), BiliAuditingFragmentV2.TAG);
                }

                @Override // tv.danmaku.bili.auth.helper.CheckStatusListener
                public void onError() {
                    ToastHelper.showToastShort(this$0.getContext(), bili.resource.account.R.string.account_global_string_478);
                }
            });
        }
    }

    /* compiled from: BiliAuthModifyFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0019\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ItemHolder;", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;", CommonMenuBottomSheetKt.KEY_ITEMS, "", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$RealnameModify;", "<init>", "(Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        private final List<RealnameModify> items;
        final /* synthetic */ BiliAuthModifyFragment this$0;

        public ItemAdapter(BiliAuthModifyFragment this$0, List<RealnameModify> list) {
            Intrinsics.checkNotNullParameter(list, CommonMenuBottomSheetKt.KEY_ITEMS);
            this.this$0 = this$0;
            this.items = list;
        }

        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            BiliAuthModifyFragment biliAuthModifyFragment = this.this$0;
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_fragment_auth_modify_list, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ItemHolder(biliAuthModifyFragment, inflate);
        }

        public int getItemCount() {
            return this.items.size();
        }

        public void onBindViewHolder(ItemHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.bind(this.items.get(position));
        }
    }

    /* compiled from: BiliAuthModifyFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$RealnameModify;", "", ChannelRoutes.CHANNEL_NAME, "", "tips", "url", "type", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ModifyType;", "<init>", "(Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ModifyType;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getTips", "setTips", "getUrl", "setUrl", "getType", "()Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ModifyType;", "setType", "(Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ModifyType;)V", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class RealnameModify {
        private String name;
        final /* synthetic */ BiliAuthModifyFragment this$0;
        private String tips;
        private ModifyType type;
        private String url;

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getTips() {
            return this.tips;
        }

        public final void setTips(String str) {
            this.tips = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final ModifyType getType() {
            return this.type;
        }

        public final void setType(ModifyType modifyType) {
            Intrinsics.checkNotNullParameter(modifyType, "<set-?>");
            this.type = modifyType;
        }

        public RealnameModify(BiliAuthModifyFragment this$0, String name, String tips, String url, ModifyType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.this$0 = this$0;
            this.type = ModifyType.UNKNOWN;
            this.name = name;
            this.tips = tips;
            this.url = url;
            this.type = type;
        }
    }

    /* compiled from: BiliAuthModifyFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment$ModifyType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NAME", "PERSON", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum ModifyType {
        UNKNOWN(0),
        NAME(1),
        PERSON(2);
        
        private final int value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<ModifyType> getEntries() {
            return $ENTRIES;
        }

        ModifyType(int value) {
            this.value = value;
        }

        public final int getValue() {
            return this.value;
        }
    }
}