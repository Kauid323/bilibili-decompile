package tv.danmaku.biliplayerv2.service.interact.biz.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.commons.ArrayUtils;
import com.bilibili.lib.ui.R;
import com.bilibili.magicasakura.widgets.TintRadioButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.RecyclerView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerRadioGridGroup.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0004\u001f !\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00112\b\b\u0001\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup;", "Ltv/danmaku/bili/widget/RecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAdapter", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$DanmakuReportAdapter;", "mLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "setData", "", "data", "", "", "([Ljava/lang/String;)V", "clearCheckState", "setSpanCount", "count", "setBoxTextColor", "textColor", "setItemCheckedChangeListener", "itemCheckedChangeListener", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$OnItemCheckedChangeListener;", "init", "DanmakuReportAdapter", "DanmakuReportVH", "OnItemCheckedChangeListener", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerRadioGridGroup extends RecyclerView {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_SPAN_COUNT = 3;
    private DanmakuReportAdapter mAdapter;
    private GridLayoutManager mLayoutManager;

    /* compiled from: PlayerRadioGridGroup.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$OnItemCheckedChangeListener;", "", "onItemChecked", "", "oldChecked", "", "newChecked", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnItemCheckedChangeListener {
        void onItemChecked(int i, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerRadioGridGroup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerRadioGridGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerRadioGridGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init();
    }

    public final void setData(String[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        stopScroll();
        DanmakuReportAdapter danmakuReportAdapter = this.mAdapter;
        if (danmakuReportAdapter != null) {
            danmakuReportAdapter.setData(data);
        }
        DanmakuReportAdapter danmakuReportAdapter2 = this.mAdapter;
        if (danmakuReportAdapter2 != null) {
            danmakuReportAdapter2.notifyDataSetChanged();
        }
    }

    public final void clearCheckState() {
        DanmakuReportAdapter danmakuReportAdapter = this.mAdapter;
        if (danmakuReportAdapter != null) {
            danmakuReportAdapter.clearCheckState();
        }
        DanmakuReportAdapter danmakuReportAdapter2 = this.mAdapter;
        if (danmakuReportAdapter2 != null) {
            danmakuReportAdapter2.notifyDataSetChanged();
        }
        getRecycledViewPool().clear();
    }

    public final void setSpanCount(int count) {
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        Intrinsics.checkNotNull(gridLayoutManager);
        gridLayoutManager.setSpanCount(count);
    }

    public final void setBoxTextColor(int textColor) {
        DanmakuReportAdapter danmakuReportAdapter = this.mAdapter;
        if (danmakuReportAdapter != null) {
            danmakuReportAdapter.setButtonTextColor(textColor);
        }
    }

    public final void setItemCheckedChangeListener(OnItemCheckedChangeListener itemCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(itemCheckedChangeListener, "itemCheckedChangeListener");
        DanmakuReportAdapter danmakuReportAdapter = this.mAdapter;
        if (danmakuReportAdapter != null) {
            danmakuReportAdapter.setCheckedChangeListener(itemCheckedChangeListener);
        }
    }

    private final void init() {
        if (this.mAdapter == null) {
            this.mAdapter = new DanmakuReportAdapter();
        }
        if (this.mLayoutManager == null) {
            this.mLayoutManager = new GridLayoutManager(getContext(), DEFAULT_SPAN_COUNT);
        }
        setLayoutManager((RecyclerView.LayoutManager) this.mLayoutManager);
        setAdapter(this.mAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerRadioGridGroup.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u001aJ\u0019\u0010\"\u001a\u00020\u001a2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u001a2\b\b\u0001\u0010%\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\nR\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$DanmakuReportAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$DanmakuReportVH;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "data", "", "", "listener", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$OnItemCheckedChangeListener;", "([Ljava/lang/String;Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$OnItemCheckedChangeListener;)V", "mData", "[Ljava/lang/String;", "buttonTextColor", "", "value", "checkedPos", "getCheckedPos", "()I", "mCheckedChangeListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "onClick", "v", "Landroid/view/View;", "clearCheckState", "setData", "([Ljava/lang/String;)V", "setButtonTextColor", "textColor", "setCheckedChangeListener", "checkedChangeListener", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DanmakuReportAdapter extends RecyclerView.Adapter<DanmakuReportVH> implements View.OnClickListener {
        private int buttonTextColor;
        private int checkedPos;
        private OnItemCheckedChangeListener mCheckedChangeListener;
        private String[] mData;

        public final int getCheckedPos() {
            return this.checkedPos;
        }

        public DanmakuReportAdapter() {
            this.buttonTextColor = -1;
            this.checkedPos = -1;
        }

        public DanmakuReportAdapter(String[] data, OnItemCheckedChangeListener listener) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.buttonTextColor = -1;
            this.checkedPos = -1;
            this.mData = data;
            this.mCheckedChangeListener = listener;
        }

        public DanmakuReportVH onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return DanmakuReportVH.Companion.create(parent, this.buttonTextColor, this);
        }

        public void onBindViewHolder(DanmakuReportVH holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            String[] strArr = this.mData;
            Intrinsics.checkNotNull(strArr);
            holder.bind(strArr[position], this.checkedPos == position);
        }

        public int getItemCount() {
            if (this.mData == null) {
                return 0;
            }
            String[] strArr = this.mData;
            Intrinsics.checkNotNull(strArr);
            return strArr.length;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Object tag = v.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            String text = (String) tag;
            int oldChecked = this.checkedPos;
            this.checkedPos = ArrayUtils.indexOf(this.mData, text);
            notifyItemChanged(oldChecked);
            notifyItemChanged(this.checkedPos);
            if (this.mCheckedChangeListener != null) {
                OnItemCheckedChangeListener onItemCheckedChangeListener = this.mCheckedChangeListener;
                Intrinsics.checkNotNull(onItemCheckedChangeListener);
                onItemCheckedChangeListener.onItemChecked(oldChecked, this.checkedPos);
            }
        }

        public final void clearCheckState() {
            this.checkedPos = -1;
        }

        public final void setData(String[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.mData = data;
        }

        public final void setButtonTextColor(int textColor) {
            this.buttonTextColor = textColor;
        }

        public final void setCheckedChangeListener(OnItemCheckedChangeListener checkedChangeListener) {
            Intrinsics.checkNotNullParameter(checkedChangeListener, "checkedChangeListener");
            this.mCheckedChangeListener = checkedChangeListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerRadioGridGroup.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$DanmakuReportVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "buttonTextColor", "", "mOnClickListener", "Landroid/view/View$OnClickListener;", "<init>", "(Landroid/view/View;ILandroid/view/View$OnClickListener;)V", "mRadioButton", "Lcom/bilibili/magicasakura/widgets/TintRadioButton;", "bind", "", "text", "", "isChecked", "", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DanmakuReportVH extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        private final View.OnClickListener mOnClickListener;
        private final TintRadioButton mRadioButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DanmakuReportVH(View itemView, int buttonTextColor, View.OnClickListener mOnClickListener) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(mOnClickListener, "mOnClickListener");
            this.mOnClickListener = mOnClickListener;
            this.mRadioButton = (TintRadioButton) itemView;
            this.mRadioButton.setCompoundButtonTintList(R.color.selector_compoundbutton_normal);
            if (buttonTextColor == -1) {
                return;
            }
            this.mRadioButton.setTextColorById(buttonTextColor);
        }

        public final void bind(String text, boolean isChecked) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.mRadioButton.setText(text);
            this.mRadioButton.setChecked(isChecked);
            this.mRadioButton.setTag(text);
            this.mRadioButton.setOnClickListener(this.mOnClickListener);
        }

        /* compiled from: PlayerRadioGridGroup.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$DanmakuReportVH$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$DanmakuReportVH;", "parent", "Landroid/view/ViewGroup;", "buttonTextColor", "", "listener", "Landroid/view/View$OnClickListener;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final DanmakuReportVH create(ViewGroup parent, int buttonTextColor, View.OnClickListener listener) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(listener, "listener");
                View view2 = LayoutInflater.from(parent.getContext()).inflate(tv.danmaku.biliplayerv2.R.layout.bili_player_chronos_danmaku_report_item, parent, false);
                Intrinsics.checkNotNull(view2);
                return new DanmakuReportVH(view2, buttonTextColor, listener);
            }
        }
    }

    /* compiled from: PlayerRadioGridGroup.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/widget/PlayerRadioGridGroup$Companion;", "", "<init>", "()V", "DEFAULT_SPAN_COUNT", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}