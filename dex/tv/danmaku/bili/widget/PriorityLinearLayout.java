package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PriorityLinearLayout.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u001f !\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\f\u0010\u0013\u001a\u00060\u000fR\u00020\u0000H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0014J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/bili/widget/PriorityLinearLayout;", "Lcom/bilibili/magicasakura/widgets/TintLinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "priorityMap", "Ljava/util/TreeMap;", "measureHelper", "Ltv/danmaku/bili/widget/PriorityLinearLayout$AbsPriorityMeasureHelper;", "setOrientation", "", "orientation", "buildMeasureHelper", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "buildPriorityTree", "getPriorityMap", "", "generateLayoutParams", "Ltv/danmaku/bili/widget/PriorityLinearLayout$LayoutParams;", "generateDefaultLayoutParams", "lp", "Landroid/view/ViewGroup$LayoutParams;", "LayoutParams", "AbsPriorityMeasureHelper", "HorizontalPriorityMeasureHelper", "VerticalPriorityMeasureHelper", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PriorityLinearLayout extends TintLinearLayout {
    private AbsPriorityMeasureHelper measureHelper;
    private final TreeMap<Integer, Integer> priorityMap;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int priorityMap$lambda$0(Integer o1, Integer o2) {
        Intrinsics.checkNotNull(o1);
        int intValue = o1.intValue();
        Intrinsics.checkNotNull(o2);
        return -Intrinsics.compare(intValue, o2.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int priorityMap$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        return ((Number) $tmp0.invoke(p0, p1)).intValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityLinearLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        final Function2 function2 = new Function2() { // from class: tv.danmaku.bili.widget.PriorityLinearLayout$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                int priorityMap$lambda$0;
                priorityMap$lambda$0 = PriorityLinearLayout.priorityMap$lambda$0((Integer) obj, (Integer) obj2);
                return Integer.valueOf(priorityMap$lambda$0);
            }
        };
        this.priorityMap = new TreeMap<>(new Comparator() { // from class: tv.danmaku.bili.widget.PriorityLinearLayout$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int priorityMap$lambda$1;
                priorityMap$lambda$1 = PriorityLinearLayout.priorityMap$lambda$1(function2, obj, obj2);
                return priorityMap$lambda$1;
            }
        });
        this.measureHelper = buildMeasureHelper();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        final Function2 function2 = new Function2() { // from class: tv.danmaku.bili.widget.PriorityLinearLayout$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                int priorityMap$lambda$0;
                priorityMap$lambda$0 = PriorityLinearLayout.priorityMap$lambda$0((Integer) obj, (Integer) obj2);
                return Integer.valueOf(priorityMap$lambda$0);
            }
        };
        this.priorityMap = new TreeMap<>(new Comparator() { // from class: tv.danmaku.bili.widget.PriorityLinearLayout$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int priorityMap$lambda$1;
                priorityMap$lambda$1 = PriorityLinearLayout.priorityMap$lambda$1(function2, obj, obj2);
                return priorityMap$lambda$1;
            }
        });
        this.measureHelper = buildMeasureHelper();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        final Function2 function2 = new Function2() { // from class: tv.danmaku.bili.widget.PriorityLinearLayout$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                int priorityMap$lambda$0;
                priorityMap$lambda$0 = PriorityLinearLayout.priorityMap$lambda$0((Integer) obj, (Integer) obj2);
                return Integer.valueOf(priorityMap$lambda$0);
            }
        };
        this.priorityMap = new TreeMap<>(new Comparator() { // from class: tv.danmaku.bili.widget.PriorityLinearLayout$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int priorityMap$lambda$1;
                priorityMap$lambda$1 = PriorityLinearLayout.priorityMap$lambda$1(function2, obj, obj2);
                return priorityMap$lambda$1;
            }
        });
        this.measureHelper = buildMeasureHelper();
    }

    public void setOrientation(int orientation) {
        super.setOrientation(orientation);
        this.measureHelper = buildMeasureHelper();
    }

    private final AbsPriorityMeasureHelper buildMeasureHelper() {
        if (getOrientation() == 0) {
            return new HorizontalPriorityMeasureHelper();
        }
        return new VerticalPriorityMeasureHelper();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewGroup.LayoutParams lp = getLayoutParams();
        if ((lp.width == -2 && getOrientation() == 0) || (lp.height == -2 && getOrientation() == 1)) {
            throw new IllegalArgumentException("DO NOT set size WRAP_CONTENT in your layout orientation. \nOr use standard LinearLayout instead for better performance.");
        }
        buildPriorityTree();
        this.measureHelper.measureOnMajor();
    }

    private final void buildPriorityTree() {
        this.priorityMap.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child != null) {
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : null;
                if (!((layoutParams2 == null || layoutParams2.isHideByCollapse()) ? false : true) || child.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams3 = child.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type tv.danmaku.bili.widget.PriorityLinearLayout.LayoutParams");
                    LayoutParams lp = (LayoutParams) layoutParams3;
                    Integer prev = this.priorityMap.put(Integer.valueOf(lp.getPriority()), Integer.valueOf(i));
                    if (prev != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("DO NOT set duplicate priority to you children views : %1$s and %2$s", Arrays.copyOf(new Object[]{child.toString(), getChildAt(prev.intValue()).toString()}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        throw new IllegalArgumentException(format);
                    }
                }
            }
        }
    }

    public final Map<Integer, Integer> getPriorityMap() {
        return this.priorityMap;
    }

    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LayoutParams m2033generateLayoutParams(AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new LayoutParams(context, attrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LayoutParams m2031generateDefaultLayoutParams() {
        LinearLayout.LayoutParams lp = super.generateDefaultLayoutParams();
        Intrinsics.checkNotNull(lp);
        return new LayoutParams(lp, lp.weight, lp.gravity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LayoutParams m2034generateLayoutParams(ViewGroup.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(lp, "lp");
        LinearLayout.LayoutParams llp = super.generateLayoutParams(lp);
        Intrinsics.checkNotNull(llp);
        return new LayoutParams(llp, llp.weight, llp.gravity);
    }

    /* compiled from: PriorityLinearLayout.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b!R\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/widget/PriorityLinearLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lp", "Landroid/view/ViewGroup$MarginLayoutParams;", "weight", "", "gravity", "", "(Landroid/view/ViewGroup$MarginLayoutParams;FI)V", "priority", "getPriority", "()I", "setPriority", "(I)V", "onCollapse", "getOnCollapse", "setOnCollapse", "paramStore", "Ltv/danmaku/bili/widget/LayoutParamStore;", "isHideByCollapse", "", "storeParamAndHide", "", "view", "Landroid/view/View;", "storeParamAndHide$widget_debug", "restoreParam", "restoreParam$widget_debug", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LayoutParams extends LinearLayout.LayoutParams {
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = 0, to = "collapse"), @ViewDebug.IntToString(from = 1, to = "hide")})
        private int onCollapse;
        @ViewDebug.ExportedProperty(category = "collapse", deepExport = true, prefix = "origin_")
        private LayoutParamStore paramStore;
        @ViewDebug.ExportedProperty(category = "layout")
        private int priority;

        public final int getPriority() {
            return this.priority;
        }

        public final void setPriority(int i) {
            this.priority = i;
        }

        public final int getOnCollapse() {
            return this.onCollapse;
        }

        public final void setOnCollapse(int i) {
            this.onCollapse = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            TypedArray a = c.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.PriorityLinearLayout_Layout);
            Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
            this.priority = a.getInteger(com.bilibili.lib.widget.R.styleable.PriorityLinearLayout_Layout_layout_priority, 0);
            if (this.priority == 0 && a.hasValue(com.bilibili.lib.widget.R.styleable.PriorityLinearLayout_Layout_priority)) {
                this.priority = a.getInteger(com.bilibili.lib.widget.R.styleable.PriorityLinearLayout_Layout_priority, 0);
                BLog.e("PriorityLinearLayout", "app:priority is deprecated, use app:layout_priority instead!");
            }
            this.onCollapse = a.getInt(com.bilibili.lib.widget.R.styleable.PriorityLinearLayout_Layout_onCollapse, 0);
            a.recycle();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams lp, float weight, int gravity) {
            super(lp);
            Intrinsics.checkNotNullParameter(lp, "lp");
            this.weight = weight;
            this.gravity = gravity;
            this.priority = 0;
        }

        @ViewDebug.ExportedProperty(category = "collapse")
        public final boolean isHideByCollapse() {
            return this.paramStore != null;
        }

        public final void storeParamAndHide$widget_debug(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            LayoutParamStore $this$storeParamAndHide_u24lambda_u240 = new LayoutParamStore();
            $this$storeParamAndHide_u24lambda_u240.saveParam(view2);
            this.paramStore = $this$storeParamAndHide_u24lambda_u240;
            view2.setLayoutParams(this);
            view2.setVisibility(8);
        }

        public final void restoreParam$widget_debug(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            LayoutParamStore layoutParamStore = this.paramStore;
            if (layoutParamStore != null) {
                layoutParamStore.restoreParam(view2);
            }
            this.paramStore = null;
            view2.setLayoutParams(this);
        }
    }

    /* compiled from: PriorityLinearLayout.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H&J\b\u0010\u0018\u001a\u00020\u0007H&J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u001aH&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u001fH&J \u0010!\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H&J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H&¨\u0006'"}, d2 = {"Ltv/danmaku/bili/widget/PriorityLinearLayout$AbsPriorityMeasureHelper;", "", "<init>", "(Ltv/danmaku/bili/widget/PriorityLinearLayout;)V", "measureOnMajor", "", "onChildCollapse", "", "child", "Landroid/view/View;", "lp", "Ltv/danmaku/bili/widget/PriorityLinearLayout$LayoutParams;", "childMajorSize", "childMinerMeasureSpec", "newMajorSize", "restoreView", "view", "layoutParams", "hideView", "getChildMajorMeasureSpec", "measureSpec", "getMeasureSpec", "sizeParam", "getMajorPadding", "getMinerPadding", "getMinerParam", "Landroid/view/ViewGroup$LayoutParams;", "getMajorParam", "getMeasuredMajorSize", "getMeasuredMinerSize", "getMajorMarginSize", "Landroid/view/ViewGroup$MarginLayoutParams;", "getMinerMarginSize", "measure", "majorMeasureSpec", "minerMeasureSpec", "setFinalMeasuredSize", "majorSize", "minerSize", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public abstract class AbsPriorityMeasureHelper {
        public abstract int getMajorMarginSize(ViewGroup.MarginLayoutParams marginLayoutParams);

        public abstract int getMajorPadding();

        public abstract int getMajorParam(ViewGroup.LayoutParams layoutParams);

        public abstract int getMeasuredMajorSize(View view2);

        public abstract int getMeasuredMinerSize(View view2);

        public abstract int getMinerMarginSize(ViewGroup.MarginLayoutParams marginLayoutParams);

        public abstract int getMinerPadding();

        public abstract int getMinerParam(ViewGroup.LayoutParams layoutParams);

        public abstract void measure(View view2, int i, int i2);

        public abstract void setFinalMeasuredSize(int i, int i2);

        public AbsPriorityMeasureHelper() {
        }

        public final void measureOnMajor() {
            int sizeConsumed;
            int space = getMeasuredMajorSize((View) PriorityLinearLayout.this) - getMajorPadding();
            int maxMinerSize = 0;
            for (Map.Entry<Integer, Integer> entry : PriorityLinearLayout.this.getPriorityMap().entrySet()) {
                int value = entry.getValue().intValue();
                View child = PriorityLinearLayout.this.getChildAt(value);
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type tv.danmaku.bili.widget.PriorityLinearLayout.LayoutParams");
                LayoutParams lp = (LayoutParams) layoutParams;
                Intrinsics.checkNotNull(child);
                restoreView(child, lp);
                if (child.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
                    Intrinsics.checkNotNullExpressionValue(layoutParams2, "getLayoutParams(...)");
                    int childMinerMeasureSpec = getMeasureSpec(getMinerParam(layoutParams2));
                    if (space == 0) {
                        hideView(child, lp);
                    } else {
                        if (lp.weight == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                            PriorityLinearLayout priorityLinearLayout = PriorityLinearLayout.this;
                            ViewGroup.LayoutParams layoutParams3 = child.getLayoutParams();
                            Intrinsics.checkNotNullExpressionValue(layoutParams3, "getLayoutParams(...)");
                            priorityLinearLayout.measureChild(child, getChildMajorMeasureSpec(getMajorParam(layoutParams3)), childMinerMeasureSpec);
                        }
                        int childMajorSize = getMeasuredMajorSize(child);
                        if (getMajorMarginSize(lp) + childMajorSize > space) {
                            int newMajorSize = Math.max(0, space - getMajorMarginSize(lp));
                            sizeConsumed = onChildCollapse(child, lp, childMajorSize, childMinerMeasureSpec, newMajorSize);
                        } else {
                            sizeConsumed = getMajorMarginSize(lp) + childMajorSize;
                        }
                        space -= sizeConsumed;
                        if (space < 0) {
                            hideView(child, lp);
                            space += sizeConsumed;
                        }
                        maxMinerSize = Math.max(maxMinerSize, getMeasuredMinerSize(child) + getMinerMarginSize(lp));
                    }
                }
            }
            ViewGroup.LayoutParams layoutParams4 = PriorityLinearLayout.this.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams4, "getLayoutParams(...)");
            if (getMinerParam(layoutParams4) == -2) {
                setFinalMeasuredSize(getMeasuredMajorSize((View) PriorityLinearLayout.this), getMinerPadding() + maxMinerSize);
            } else {
                setFinalMeasuredSize(getMeasuredMajorSize((View) PriorityLinearLayout.this), getMeasuredMinerSize((View) PriorityLinearLayout.this));
            }
        }

        private final int onChildCollapse(View child, LayoutParams lp, int childMajorSize, int childMinerMeasureSpec, int newMajorSize) {
            if (lp.getOnCollapse() == 1) {
                hideView(child, lp);
                return 0;
            }
            measure(child, View.MeasureSpec.makeMeasureSpec(Math.min(childMajorSize, newMajorSize), 1073741824), childMinerMeasureSpec);
            return getMajorMarginSize(lp) + getMeasuredMajorSize(child);
        }

        private final void restoreView(View view2, LayoutParams layoutParams) {
            layoutParams.restoreParam$widget_debug(view2);
        }

        private final void hideView(View view2, LayoutParams layoutParams) {
            layoutParams.storeParamAndHide$widget_debug(view2);
            measure(view2, View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        }

        private final int getChildMajorMeasureSpec(int measureSpec) {
            return measureSpec == 0 ? View.MeasureSpec.makeMeasureSpec(measureSpec, 0) : getMeasureSpec(measureSpec);
        }

        private final int getMeasureSpec(int sizeParam) {
            int mode;
            switch (sizeParam) {
                case -2:
                    mode = 0;
                    break;
                case -1:
                    mode = Integer.MIN_VALUE;
                    break;
                default:
                    mode = 1073741824;
                    break;
            }
            return View.MeasureSpec.makeMeasureSpec(sizeParam, mode);
        }
    }

    /* compiled from: PriorityLinearLayout.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0011H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/widget/PriorityLinearLayout$HorizontalPriorityMeasureHelper;", "Ltv/danmaku/bili/widget/PriorityLinearLayout$AbsPriorityMeasureHelper;", "Ltv/danmaku/bili/widget/PriorityLinearLayout;", "<init>", "(Ltv/danmaku/bili/widget/PriorityLinearLayout;)V", "getMajorPadding", "", "getMinerPadding", "getMinerParam", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getMajorParam", "getMeasuredMajorSize", "view", "Landroid/view/View;", "getMeasuredMinerSize", "getMajorMarginSize", "Landroid/view/ViewGroup$MarginLayoutParams;", "getMinerMarginSize", "measure", "", "majorMeasureSpec", "minerMeasureSpec", "setFinalMeasuredSize", "majorSize", "minerSize", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class HorizontalPriorityMeasureHelper extends AbsPriorityMeasureHelper {
        public HorizontalPriorityMeasureHelper() {
            super();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMajorPadding() {
            return PriorityLinearLayout.this.getPaddingLeft() + PriorityLinearLayout.this.getPaddingRight();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMinerPadding() {
            return PriorityLinearLayout.this.getPaddingTop() + PriorityLinearLayout.this.getPaddingBottom();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMinerParam(ViewGroup.LayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return layoutParams.height;
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMajorParam(ViewGroup.LayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return layoutParams.width;
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMeasuredMajorSize(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            return view2.getMeasuredWidth();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMeasuredMinerSize(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            return view2.getMeasuredHeight();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMajorMarginSize(ViewGroup.MarginLayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return MarginLayoutParamsCompat.getMarginStart(layoutParams) + MarginLayoutParamsCompat.getMarginEnd(layoutParams);
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMinerMarginSize(ViewGroup.MarginLayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return layoutParams.topMargin + layoutParams.bottomMargin;
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public void measure(View view2, int majorMeasureSpec, int minerMeasureSpec) {
            Intrinsics.checkNotNullParameter(view2, "view");
            view2.measure(majorMeasureSpec, minerMeasureSpec);
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public void setFinalMeasuredSize(int majorSize, int minerSize) {
            PriorityLinearLayout.this.setMeasuredDimension(majorSize, minerSize);
        }
    }

    /* compiled from: PriorityLinearLayout.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0011H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/widget/PriorityLinearLayout$VerticalPriorityMeasureHelper;", "Ltv/danmaku/bili/widget/PriorityLinearLayout$AbsPriorityMeasureHelper;", "Ltv/danmaku/bili/widget/PriorityLinearLayout;", "<init>", "(Ltv/danmaku/bili/widget/PriorityLinearLayout;)V", "getMajorPadding", "", "getMinerPadding", "getMinerParam", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getMajorParam", "getMeasuredMajorSize", "view", "Landroid/view/View;", "getMeasuredMinerSize", "getMajorMarginSize", "Landroid/view/ViewGroup$MarginLayoutParams;", "getMinerMarginSize", "measure", "", "majorMeasureSpec", "minerMeasureSpec", "setFinalMeasuredSize", "majorSize", "minerSize", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class VerticalPriorityMeasureHelper extends AbsPriorityMeasureHelper {
        public VerticalPriorityMeasureHelper() {
            super();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMajorPadding() {
            return PriorityLinearLayout.this.getPaddingTop() + PriorityLinearLayout.this.getPaddingBottom();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMinerPadding() {
            return PriorityLinearLayout.this.getPaddingLeft() + PriorityLinearLayout.this.getPaddingRight();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMinerParam(ViewGroup.LayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return layoutParams.width;
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMajorParam(ViewGroup.LayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return layoutParams.height;
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMeasuredMajorSize(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            return view2.getMeasuredHeight();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMeasuredMinerSize(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            return view2.getMeasuredWidth();
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMajorMarginSize(ViewGroup.MarginLayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return layoutParams.topMargin + layoutParams.bottomMargin;
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public int getMinerMarginSize(ViewGroup.MarginLayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            return MarginLayoutParamsCompat.getMarginStart(layoutParams) + MarginLayoutParamsCompat.getMarginEnd(layoutParams);
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public void measure(View view2, int majorMeasureSpec, int minerMeasureSpec) {
            Intrinsics.checkNotNullParameter(view2, "view");
            view2.measure(minerMeasureSpec, majorMeasureSpec);
        }

        @Override // tv.danmaku.bili.widget.PriorityLinearLayout.AbsPriorityMeasureHelper
        public void setFinalMeasuredSize(int majorSize, int minerSize) {
            PriorityLinearLayout.this.setMeasuredDimension(minerSize, majorSize);
        }
    }
}