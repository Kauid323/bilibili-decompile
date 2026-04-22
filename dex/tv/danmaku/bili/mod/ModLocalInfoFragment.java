package tv.danmaku.bili.mod;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.lib.mod.ModResourceClient;
import com.bilibili.lib.ui.BaseFragment;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.RecyclerView;
import tv.danmaku.bili.widget.recycler.DividerDecoration;

/* compiled from: ModLocalInfoFragment.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "rv", "Ltv/danmaku/bili/widget/RecyclerView;", "tvModEnv", "Landroid/widget/TextView;", "tvModTotalSize", "tvModTotalNum", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onActivityCreated", "getModMode", "", "ModAdapter", "ModHeaderViewHolder", "ModItemViewHolder", "BaseViewHolder", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ModLocalInfoFragment extends BaseFragment {
    public static final int $stable = 8;
    private RecyclerView rv;
    private TextView tvModEnv;
    private TextView tvModTotalNum;
    private TextView tvModTotalSize;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bili_app_fragment_local_info, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.rv = view.findViewById(R.id.rv_mod_info);
        this.tvModTotalNum = (TextView) view.findViewById(R.id.tv_mod_total_num);
        this.tvModTotalSize = (TextView) view.findViewById(R.id.tv_mod_total_size);
        this.tvModEnv = (TextView) view.findViewById(R.id.tv_mod_env);
        TextView textView = this.tvModEnv;
        if (textView != null) {
            textView.setText(getString(bili.resource.homepage.R.string.homepage_global_string_130, new Object[]{getModMode()}));
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.mod.ModLocalInfoFragment$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List onActivityCreated$lambda$0;
                onActivityCreated$lambda$0 = ModLocalInfoFragment.onActivityCreated$lambda$0();
                return onActivityCreated$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.mod.ModLocalInfoFragment$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Unit onActivityCreated$lambda$1;
                onActivityCreated$lambda$1 = ModLocalInfoFragment.onActivityCreated$lambda$1(ModLocalInfoFragment.this, task);
                return onActivityCreated$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List onActivityCreated$lambda$0() {
        return ModDataManager.getModInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActivityCreated$lambda$1(ModLocalInfoFragment this$0, Task it) {
        List data = (List) it.getResult();
        if (data != null) {
            int num = 0;
            long size = 0;
            List $this$forEach$iv = data;
            for (Object element$iv : $this$forEach$iv) {
                ModInfo md = (ModInfo) element$iv;
                num += md.getModList().size();
                Iterable $this$forEach$iv2 = md.getModList();
                for (Object element$iv2 : $this$forEach$iv2) {
                    ModItem item = (ModItem) element$iv2;
                    size += item.getSize();
                }
            }
            TextView textView = this$0.tvModTotalNum;
            if (textView != null) {
                textView.setText(this$0.getString(bili.resource.homepage.R.string.homepage_global_string_239, new Object[]{String.valueOf(num)}));
            }
            TextView textView2 = this$0.tvModTotalSize;
            if (textView2 != null) {
                int i = bili.resource.homepage.R.string.homepage_global_string_161;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%.2fMB", Arrays.copyOf(new Object[]{Float.valueOf(((float) size) / 1048576.0f)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(this$0.getString(i, new Object[]{format}));
            }
            RecyclerView recyclerView = this$0.rv;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(this$0.getActivity()));
            }
            RecyclerView recyclerView2 = this$0.rv;
            if (recyclerView2 != null) {
                recyclerView2.addItemDecoration(new DividerDecoration());
            }
            ModAdapter adapter = new ModAdapter();
            RecyclerView recyclerView3 = this$0.rv;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(adapter);
            }
            adapter.setData(data);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: ModLocalInfoFragment.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0014\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment$ModAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/mod/ModLocalInfoFragment$BaseViewHolder;", "<init>", "()V", "positionArray", "Landroid/util/SparseIntArray;", "poolList", "Ljava/util/LinkedList;", "", "modList", "Ltv/danmaku/bili/mod/ModItem;", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "itemViewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "setData", "list", "", "Ltv/danmaku/bili/mod/ModInfo;", "getRealPosition", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ModAdapter extends RecyclerView.Adapter<BaseViewHolder<?>> {
        public static final int $stable = 8;
        private final SparseIntArray positionArray = new SparseIntArray();
        private LinkedList<String> poolList = new LinkedList<>();
        private LinkedList<ModItem> modList = new LinkedList<>();

        public BaseViewHolder<?> onCreateViewHolder(ViewGroup p0, int itemViewType) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            if (2 == itemViewType) {
                return ModHeaderViewHolder.Companion.create(p0);
            }
            return ModItemViewHolder.Companion.create(p0);
        }

        public int getItemCount() {
            return this.poolList.size() + this.modList.size();
        }

        public int getItemViewType(int position) {
            return this.positionArray.get(position) > 0 ? 1 : 2;
        }

        public void onBindViewHolder(BaseViewHolder<?> baseViewHolder, int position) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "p0");
            switch (getItemViewType(position)) {
                case 1:
                    ModItem modItem = this.modList.get(getRealPosition(position));
                    Intrinsics.checkNotNullExpressionValue(modItem, "get(...)");
                    ((ModItemViewHolder) baseViewHolder).bind(modItem);
                    return;
                case 2:
                    String str = this.poolList.get(getRealPosition(position));
                    Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                    ((ModHeaderViewHolder) baseViewHolder).bind(str);
                    return;
                default:
                    return;
            }
        }

        public final void setData(List<ModInfo> list) {
            ModAdapter modAdapter = this;
            Intrinsics.checkNotNullParameter(list, "list");
            int count = 1;
            int headerCount = 0;
            List<ModInfo> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                ModInfo it = (ModInfo) element$iv;
                headerCount++;
                modAdapter.poolList.add(it.getHeader());
                modAdapter.positionArray.put(modAdapter.positionArray.size(), -headerCount);
                count++;
                for (Object element$iv2 : it.getModList()) {
                    ModItem mod = (ModItem) element$iv2;
                    modAdapter.modList.add(mod);
                    modAdapter.positionArray.put(modAdapter.positionArray.size(), count - headerCount);
                    count++;
                    modAdapter = this;
                    $this$forEach$iv = $this$forEach$iv;
                }
                modAdapter = this;
            }
            notifyDataSetChanged();
        }

        private final int getRealPosition(int position) {
            return Math.abs(this.positionArray.get(position)) - 1;
        }
    }

    /* compiled from: ModLocalInfoFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment$ModHeaderViewHolder;", "Ltv/danmaku/bili/mod/ModLocalInfoFragment$BaseViewHolder;", "", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvHeader", "Landroid/widget/TextView;", "bind", "", "data", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ModHeaderViewHolder extends BaseViewHolder<String> {
        private TextView tvHeader;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModHeaderViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.tvHeader = (TextView) itemView.findViewById(R.id.tv_mod_header);
        }

        @Override // tv.danmaku.bili.mod.ModLocalInfoFragment.BaseViewHolder
        public void bind(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            TextView textView = this.tvHeader;
            if (textView != null) {
                textView.setText(this.itemView.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_296, data));
            }
        }

        /* compiled from: ModLocalInfoFragment.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment$ModHeaderViewHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/mod/ModLocalInfoFragment$ModHeaderViewHolder;", "view", "Landroid/view/ViewGroup;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ModHeaderViewHolder create(ViewGroup view) {
                Intrinsics.checkNotNullParameter(view, "view");
                View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.bili_app_list_item_mod_info_header, view, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new ModHeaderViewHolder(inflate);
            }
        }
    }

    /* compiled from: ModLocalInfoFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment$ModItemViewHolder;", "Ltv/danmaku/bili/mod/ModLocalInfoFragment$BaseViewHolder;", "Ltv/danmaku/bili/mod/ModItem;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvModName", "Landroid/widget/TextView;", "tvModSize", "bind", "", "data", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ModItemViewHolder extends BaseViewHolder<ModItem> {
        public static final float SIZE_1_KB = 1024.0f;
        public static final float SIZE_1_MB = 1048576.0f;
        private TextView tvModName;
        private TextView tvModSize;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModItemViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.tvModName = (TextView) itemView.findViewById(R.id.tv_mod_name);
            this.tvModSize = (TextView) itemView.findViewById(R.id.tv_mod_size);
        }

        @Override // tv.danmaku.bili.mod.ModLocalInfoFragment.BaseViewHolder
        public void bind(ModItem data) {
            String format;
            Intrinsics.checkNotNullParameter(data, "data");
            TextView textView = this.tvModName;
            if (textView != null) {
                textView.setText(data.getName());
            }
            TextView textView2 = this.tvModSize;
            if (textView2 != null) {
                if (((float) data.getSize()) < 1048576.0f) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    format = String.format("%.2fKB", Arrays.copyOf(new Object[]{Float.valueOf(((float) data.getSize()) / 1024.0f)}, 1));
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    format = String.format("%.2fMB", Arrays.copyOf(new Object[]{Float.valueOf(((float) data.getSize()) / 1048576.0f)}, 1));
                }
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
            }
        }

        /* compiled from: ModLocalInfoFragment.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment$ModItemViewHolder$Companion;", "", "<init>", "()V", "SIZE_1_KB", "", "SIZE_1_MB", "create", "Ltv/danmaku/bili/mod/ModLocalInfoFragment$ModItemViewHolder;", "view", "Landroid/view/ViewGroup;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ModItemViewHolder create(ViewGroup view) {
                Intrinsics.checkNotNullParameter(view, "view");
                View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.bili_app_list_item_mod_info, view, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new ModItemViewHolder(inflate);
            }
        }
    }

    /* compiled from: ModLocalInfoFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u000b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment$BaseViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "data", "(Ljava/lang/Object;)V", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        public static final int MOD_HEADER_TYPE = 2;
        public static final int MOD_ITEM_TYPE = 1;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public abstract void bind(T t);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        /* compiled from: ModLocalInfoFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoFragment$BaseViewHolder$Companion;", "", "<init>", "()V", "MOD_ITEM_TYPE", "", "MOD_HEADER_TYPE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    private final String getModMode() {
        try {
            boolean isDebug = ModResourceClient.getInstance().isDebugEnv(getApplicationContext());
            String string = getString(isDebug ? bili.resource.homepage.R.string.homepage_global_string_317 : bili.resource.homepage.R.string.homepage_global_string_368);
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Exception e) {
            String string2 = getString(bili.resource.homepage.R.string.homepage_global_string_167);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
    }
}