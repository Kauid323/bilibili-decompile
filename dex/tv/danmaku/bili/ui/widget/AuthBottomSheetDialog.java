package tv.danmaku.bili.ui.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.auth.R;
import com.bilibili.app.auth.databinding.BiliAuthBottomSheetItemBinding;
import com.bilibili.app.auth.databinding.FragmentAuthBottomSheetDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.widget.AuthBottomSheetDialog;
import tv.danmaku.bili.widget.recycler.DividerDecoration;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 :2\u00020\u0001:\u0003:;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00103\u001a\u00020\u0018H\u0003J\b\u00104\u001a\u00020\u0018H\u0002J\u001a\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"¨\u0006="}, d2 = {"Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/bilibili/app/auth/databinding/FragmentAuthBottomSheetDialogBinding;", "getBinding", "()Lcom/bilibili/app/auth/databinding/FragmentAuthBottomSheetDialogBinding;", "setBinding", "(Lcom/bilibili/app/auth/databinding/FragmentAuthBottomSheetDialogBinding;)V", "lastOffset", "", "offset", "itemList", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "setItemList", "(Ljava/util/ArrayList;)V", "onItemClick", "Lkotlin/Function1;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "useNewStyle", "", "getUseNewStyle", "()Z", "setUseNewStyle", "(Z)V", "adapter", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog$ListBottomSheetAdapter;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "hitIndicator", "getHitIndicator", "setHitIndicator", "initUI", "setBackgroundAlpha", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "Companion", "ListBottomSheetAdapter", "ListBottomSheetItemHolder", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthBottomSheetDialog extends BottomSheetDialogFragment {
    public static final String ARG_ITEMS = "arg_items";
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ListBottomSheetDialog";
    private final ListBottomSheetAdapter adapter = new ListBottomSheetAdapter(new Function1() { // from class: tv.danmaku.bili.ui.widget.AuthBottomSheetDialog$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit adapter$lambda$0;
            adapter$lambda$0 = AuthBottomSheetDialog.adapter$lambda$0(AuthBottomSheetDialog.this, ((Integer) obj).intValue());
            return adapter$lambda$0;
        }
    });
    public FragmentAuthBottomSheetDialogBinding binding;
    private boolean hitIndicator;
    private ArrayList<AuthBottomSheetItem> itemList;
    private float lastOffset;
    private float offset;
    private Function1<? super Integer, Unit> onItemClick;
    private boolean useNewStyle;

    public final FragmentAuthBottomSheetDialogBinding getBinding() {
        FragmentAuthBottomSheetDialogBinding fragmentAuthBottomSheetDialogBinding = this.binding;
        if (fragmentAuthBottomSheetDialogBinding != null) {
            return fragmentAuthBottomSheetDialogBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentAuthBottomSheetDialogBinding fragmentAuthBottomSheetDialogBinding) {
        Intrinsics.checkNotNullParameter(fragmentAuthBottomSheetDialogBinding, "<set-?>");
        this.binding = fragmentAuthBottomSheetDialogBinding;
    }

    public final ArrayList<AuthBottomSheetItem> getItemList() {
        return this.itemList;
    }

    public final void setItemList(ArrayList<AuthBottomSheetItem> arrayList) {
        this.itemList = arrayList;
    }

    public final Function1<Integer, Unit> getOnItemClick() {
        return this.onItemClick;
    }

    public final void setOnItemClick(Function1<? super Integer, Unit> function1) {
        this.onItemClick = function1;
    }

    public final boolean getUseNewStyle() {
        return this.useNewStyle;
    }

    public final void setUseNewStyle(boolean z) {
        this.useNewStyle = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit adapter$lambda$0(AuthBottomSheetDialog this$0, int it) {
        Function1<? super Integer, Unit> function1 = this$0.onItemClick;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(it));
        }
        this$0.dismiss();
        return Unit.INSTANCE;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            dismissAllowingStateLoss();
        } else {
            setStyle(0, R.style.AuthBottomSheetDialogTheme);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentAuthBottomSheetDialogBinding inflate = FragmentAuthBottomSheetDialogBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        Bundle arguments = getArguments();
        this.itemList = arguments != null ? arguments.getParcelableArrayList(ARG_ITEMS) : null;
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        initUI();
        setBackgroundAlpha();
    }

    public final boolean getHitIndicator() {
        return this.hitIndicator;
    }

    public final void setHitIndicator(boolean z) {
        this.hitIndicator = z;
    }

    private final void initUI() {
        final FragmentAuthBottomSheetDialogBinding $this$initUI_u24lambda_u240 = getBinding();
        if (this.useNewStyle) {
            View view2 = $this$initUI_u24lambda_u240.recyclerView;
            Intrinsics.checkNotNullExpressionValue(view2, "recyclerView");
            AuthBottomSheetDialogKt.setMargin(view2, 0, AuthBottomSheetDialogKt.toPx(16), AuthBottomSheetDialogKt.toPx(16), AuthBottomSheetDialogKt.toPx(33));
            $this$initUI_u24lambda_u240.recyclerView.setBackgroundResource(R.drawable.auth_shape_roundrect_coner_8dp);
            $this$initUI_u24lambda_u240.container.setBackgroundResource(R.drawable.auth_shape_bottom_sheet_dialog_corner_bg2_float);
        }
        $this$initUI_u24lambda_u240.indicatorContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.widget.AuthBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                AuthBottomSheetDialog.this.dismiss();
            }
        });
        $this$initUI_u24lambda_u240.indicatorContainer.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.widget.AuthBottomSheetDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                boolean initUI$lambda$0$1;
                initUI$lambda$0$1 = AuthBottomSheetDialog.initUI$lambda$0$1(AuthBottomSheetDialog.this, view3, motionEvent);
                return initUI$lambda$0$1;
            }
        });
        $this$initUI_u24lambda_u240.recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.widget.AuthBottomSheetDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                boolean initUI$lambda$0$2;
                initUI$lambda$0$2 = AuthBottomSheetDialog.initUI$lambda$0$2($this$initUI_u24lambda_u240, this, view3, motionEvent);
                return initUI$lambda$0$2;
            }
        });
        $this$initUI_u24lambda_u240.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        $this$initUI_u24lambda_u240.recyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView = $this$initUI_u24lambda_u240.recyclerView;
        final int i = com.bilibili.lib.theme.R.color.Line_regular;
        final int px = AuthBottomSheetDialogKt.toPx(0.5d);
        final int px2 = AuthBottomSheetDialogKt.toPx(20);
        recyclerView.addItemDecoration(new DividerDecoration(i, px, px2) { // from class: tv.danmaku.bili.ui.widget.AuthBottomSheetDialog$initUI$1$4
            @Override // tv.danmaku.bili.widget.recycler.DividerDecoration
            protected boolean needDrawDivider(RecyclerView.ViewHolder holder) {
                boolean z = false;
                if (holder != null) {
                    int absoluteAdapterPosition = holder.getAbsoluteAdapterPosition();
                    ArrayList<AuthBottomSheetItem> itemList = AuthBottomSheetDialog.this.getItemList();
                    if (absoluteAdapterPosition == (itemList != null ? itemList.size() : 0) - 1) {
                        z = true;
                    }
                }
                return true ^ z;
            }
        });
        ListBottomSheetAdapter listBottomSheetAdapter = this.adapter;
        ArrayList<AuthBottomSheetItem> arrayList = this.itemList;
        listBottomSheetAdapter.setData(arrayList != null ? arrayList : CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initUI$lambda$0$1(AuthBottomSheetDialog this$0, View view2, MotionEvent event) {
        if (event.getActionMasked() == 0) {
            this$0.hitIndicator = true;
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initUI$lambda$0$2(FragmentAuthBottomSheetDialogBinding $this_apply, AuthBottomSheetDialog this$0, View view2, MotionEvent event) {
        Rect rect = new Rect();
        $this_apply.indicatorContainer.getHitRect(rect);
        rect.bottom += AuthBottomSheetDialogKt.toPx(9);
        this$0.hitIndicator = rect.contains((int) event.getX(), (int) event.getY());
        return false;
    }

    private final void setBackgroundAlpha() {
        BottomSheetDialog dialog = getDialog();
        final BottomSheetDialog $this$setBackgroundAlpha_u24lambda_u240 = dialog instanceof BottomSheetDialog ? dialog : null;
        if ($this$setBackgroundAlpha_u24lambda_u240 != null) {
            Window window = $this$setBackgroundAlpha_u24lambda_u240.getWindow();
            if (window != null) {
                window.setDimAmount(0.5f);
            }
            View bottomSheet = $this$setBackgroundAlpha_u24lambda_u240.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (bottomSheet != null) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior, "from(...)");
                bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: tv.danmaku.bili.ui.widget.AuthBottomSheetDialog$setBackgroundAlpha$1$1$1
                    public void onStateChanged(View bottomSheet2, int newState) {
                        float f;
                        Intrinsics.checkNotNullParameter(bottomSheet2, "bottomSheet");
                        if (newState == 2) {
                            f = AuthBottomSheetDialog.this.offset;
                            if (f < DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && AuthBottomSheetDialog.this.getHitIndicator()) {
                                $this$setBackgroundAlpha_u24lambda_u240.dismiss();
                            }
                        }
                    }

                    public void onSlide(View bottomSheet2, float slideOffset) {
                        float f;
                        Intrinsics.checkNotNullParameter(bottomSheet2, "bottomSheet");
                        AuthBottomSheetDialog authBottomSheetDialog = AuthBottomSheetDialog.this;
                        f = AuthBottomSheetDialog.this.lastOffset;
                        authBottomSheetDialog.offset = slideOffset - f;
                        AuthBottomSheetDialog.this.lastOffset = slideOffset;
                        Window window2 = $this$setBackgroundAlpha_u24lambda_u240.getWindow();
                        if (window2 != null) {
                            window2.setDimAmount((1 + slideOffset) * 0.5f);
                        }
                    }
                });
            }
        }
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            super.show(manager, tag);
        } catch (IllegalStateException e) {
            BLog.e(TAG, "ListBottomSheetDialog show failed");
        }
    }

    /* compiled from: AuthBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog$Companion;", "", "<init>", "()V", "TAG", "", "ARG_ITEMS", "newInstance", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog;", "items", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem;", "Lkotlin/collections/ArrayList;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AuthBottomSheetDialog newInstance$default(Companion companion, ArrayList arrayList, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = null;
            }
            return companion.newInstance(arrayList, function1);
        }

        public final AuthBottomSheetDialog newInstance(ArrayList<AuthBottomSheetItem> arrayList, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(arrayList, "items");
            AuthBottomSheetDialog $this$newInstance_u24lambda_u240 = new AuthBottomSheetDialog();
            Bundle $this$newInstance_u24lambda_u240_u240 = new Bundle();
            $this$newInstance_u24lambda_u240_u240.putSerializable(AuthBottomSheetDialog.ARG_ITEMS, arrayList);
            $this$newInstance_u24lambda_u240.setArguments($this$newInstance_u24lambda_u240_u240);
            $this$newInstance_u24lambda_u240.setOnItemClick(function1);
            return $this$newInstance_u24lambda_u240;
        }
    }

    /* compiled from: AuthBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog$ListBottomSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog$ListBottomSheetItemHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "data", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem;", "Lkotlin/collections/ArrayList;", "setData", "items", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ListBottomSheetAdapter extends RecyclerView.Adapter<ListBottomSheetItemHolder> {
        private final ArrayList<AuthBottomSheetItem> data = new ArrayList<>();
        private final Function1<Integer, Unit> onClick;

        /* JADX WARN: Multi-variable type inference failed */
        public ListBottomSheetAdapter(Function1<? super Integer, Unit> function1) {
            this.onClick = function1;
        }

        public final Function1<Integer, Unit> getOnClick() {
            return this.onClick;
        }

        public final void setData(List<AuthBottomSheetItem> list) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.data.clear();
            this.data.addAll(list);
            notifyDataSetChanged();
        }

        public ListBottomSheetItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return ListBottomSheetItemHolder.Companion.onCreate(parent, this.onClick);
        }

        public void onBindViewHolder(ListBottomSheetItemHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            AuthBottomSheetItem authBottomSheetItem = this.data.get(position);
            Intrinsics.checkNotNullExpressionValue(authBottomSheetItem, "get(...)");
            holder.bind(authBottomSheetItem);
        }

        public int getItemCount() {
            return this.data.size();
        }
    }

    /* compiled from: AuthBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog$ListBottomSheetItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bilibili/app/auth/databinding/BiliAuthBottomSheetItemBinding;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/bilibili/app/auth/databinding/BiliAuthBottomSheetItemBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/bilibili/app/auth/databinding/BiliAuthBottomSheetItemBinding;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "bind", "data", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetItem;", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ListBottomSheetItemHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        private final BiliAuthBottomSheetItemBinding binding;
        private final Function1<Integer, Unit> onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ListBottomSheetItemHolder(BiliAuthBottomSheetItemBinding binding, Function1<? super Integer, Unit> function1) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            this.onClick = function1;
        }

        public final BiliAuthBottomSheetItemBinding getBinding() {
            return this.binding;
        }

        public final Function1<Integer, Unit> getOnClick() {
            return this.onClick;
        }

        public final void bind(AuthBottomSheetItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            BiliAuthBottomSheetItemBinding $this$bind_u24lambda_u240 = this.binding;
            $this$bind_u24lambda_u240.content.setText(data.getText());
            $this$bind_u24lambda_u240.content.setTextColorById(data.getTextColor());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.widget.AuthBottomSheetDialog$ListBottomSheetItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AuthBottomSheetDialog.ListBottomSheetItemHolder.bind$lambda$0$0(AuthBottomSheetDialog.ListBottomSheetItemHolder.this, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0$0(ListBottomSheetItemHolder this$0, View it) {
            Function1<Integer, Unit> function1 = this$0.onClick;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this$0.getAbsoluteAdapterPosition()));
            }
        }

        /* compiled from: AuthBottomSheetDialog.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog$ListBottomSheetItemHolder$Companion;", "", "<init>", "()V", "onCreate", "Ltv/danmaku/bili/ui/widget/AuthBottomSheetDialog$ListBottomSheetItemHolder;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ListBottomSheetItemHolder onCreate(ViewGroup parent, Function1<? super Integer, Unit> function1) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                BiliAuthBottomSheetItemBinding inflate = BiliAuthBottomSheetItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new ListBottomSheetItemHolder(inflate, function1);
            }
        }
    }
}