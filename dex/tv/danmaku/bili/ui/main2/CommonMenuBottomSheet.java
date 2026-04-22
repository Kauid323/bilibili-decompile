package tv.danmaku.bili.ui.main2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.playset.decoration.HorizontalDividerItemDecoration;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheet;

/* compiled from: CommonMenuBottomSheet.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/main2/CommonMenuBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tvCancel", "Landroid/widget/TextView;", "data", "", "Ltv/danmaku/bili/ui/main2/MenuItemBean;", "listener", "Ltv/danmaku/bili/ui/main2/OnMenuClickListener;", "setOnMenuClickListener", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "findChildUnderContainer", "MenuAdapter", "MenuItemHolder", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CommonMenuBottomSheet extends BottomSheetDialogFragment {
    public static final int $stable = 8;
    private List<MenuItemBean> data = new ArrayList();
    private OnMenuClickListener listener;
    private RecyclerView recyclerView;
    private TextView tvCancel;

    public final void setOnMenuClickListener(OnMenuClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bili_app_menu_common_bottom_sheet, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ArrayList it;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.recyclerView = view.findViewById(R.id.recycler_view);
        this.tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView textView = this.tvCancel;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.CommonMenuBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommonMenuBottomSheet.this.dismiss();
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments != null && (it = arguments.getParcelableArrayList(CommonMenuBottomSheetKt.KEY_ITEMS)) != null) {
            this.data.addAll(it);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(new MenuAdapter());
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).drawable(new ColorDrawable(getResources().getColor(com.bilibili.lib.theme.R.color.Ga2))).size(ListExtentionsKt.toPx(0.5f)).margin(ListExtentionsKt.toPx(21.0f), 0).positionInsideItem(true).build());
        }
        view.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.CommonMenuBottomSheet$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CommonMenuBottomSheet.onViewCreated$lambda$2(CommonMenuBottomSheet.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(CommonMenuBottomSheet this$0) {
        View child = this$0.findChildUnderContainer(this$0.getView());
        if (child != null) {
            int peekHeight = ScreenUtil.getScreenHeight(child.getContext()) - ((ScreenUtil.getScreenWidth(child.getContext()) * 5) / 9);
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = peekHeight;
            }
            BottomSheetBehavior.from(child).setPeekHeight(peekHeight);
            View view = this$0.getView();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    /* compiled from: CommonMenuBottomSheet.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/main2/CommonMenuBottomSheet$MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/main2/CommonMenuBottomSheet$MenuItemHolder;", "Ltv/danmaku/bili/ui/main2/CommonMenuBottomSheet;", "<init>", "(Ltv/danmaku/bili/ui/main2/CommonMenuBottomSheet;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class MenuAdapter extends RecyclerView.Adapter<MenuItemHolder> {
        public MenuAdapter() {
        }

        public MenuItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new MenuItemHolder(CommonMenuBottomSheet.this, parent);
        }

        public int getItemCount() {
            return CommonMenuBottomSheet.this.data.size();
        }

        public void onBindViewHolder(MenuItemHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            MenuItemBean it = (MenuItemBean) CollectionsKt.getOrNull(CommonMenuBottomSheet.this.data, position);
            if (it != null) {
                holder.bind(it);
            }
        }
    }

    /* compiled from: CommonMenuBottomSheet.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/main2/CommonMenuBottomSheet$MenuItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Ltv/danmaku/bili/ui/main2/CommonMenuBottomSheet;Landroid/view/ViewGroup;)V", "ivIcon", "Landroid/widget/ImageView;", "tvText", "Landroid/widget/TextView;", "bind", "", "item", "Ltv/danmaku/bili/ui/main2/MenuItemBean;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class MenuItemHolder extends RecyclerView.ViewHolder {
        private final ImageView ivIcon;
        final /* synthetic */ CommonMenuBottomSheet this$0;
        private final TextView tvText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MenuItemHolder(CommonMenuBottomSheet this$0, ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_item_menu_common_bottom_sheet, parent, false));
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.this$0 = this$0;
            View findViewById = this.itemView.findViewById(R.id.iv_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivIcon = (ImageView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.tv_text);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvText = (TextView) findViewById2;
            View view = this.itemView;
            final CommonMenuBottomSheet commonMenuBottomSheet = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.CommonMenuBottomSheet$MenuItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommonMenuBottomSheet.MenuItemHolder._init_$lambda$0(CommonMenuBottomSheet.MenuItemHolder.this, commonMenuBottomSheet, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(MenuItemHolder this$0, CommonMenuBottomSheet this$1, View it) {
            OnMenuClickListener onMenuClickListener;
            Object tag = this$0.itemView.getTag();
            MenuItemBean it2 = tag instanceof MenuItemBean ? (MenuItemBean) tag : null;
            if (it2 == null || (onMenuClickListener = this$1.listener) == null) {
                return;
            }
            onMenuClickListener.onMenuClick(it2);
        }

        public final void bind(MenuItemBean item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView.setTag(item);
            this.ivIcon.setImageResource(item.getIconResId());
            this.tvText.setText(item.getMenuText());
        }
    }

    private final View findChildUnderContainer(View view) {
        CoordinatorLayout parent;
        boolean z = false;
        if (view != null && view.getId() == com.google.android.material.R.id.container) {
            z = true;
        }
        if (z || view == null || (parent = view.getParent()) == null) {
            return null;
        }
        if (parent instanceof CoordinatorLayout) {
            if (parent.getId() == com.google.android.material.R.id.container) {
                return view;
            }
            return null;
        } else if (parent instanceof View) {
            return findChildUnderContainer((View) parent);
        } else {
            return null;
        }
    }
}