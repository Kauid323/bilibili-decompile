package tv.danmaku.bili.ui.garb.nft.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bilibili.droid.DimenUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.api.BillDLCRespInfo;
import tv.danmaku.bili.ui.garb.api.DLCItem;
import tv.danmaku.bili.ui.garb.api.DLCReporterHelper;
import tv.danmaku.bili.ui.garb.nft.helper.DLCCardModelHelper;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawItem;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;

/* compiled from: DLCDrawCardResultView.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\u000eJp\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eJ<\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010 \u001a\u0004\u0018\u00010\u00112\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eH\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardResultView;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "bottomView", "Landroid/view/View;", "multiCardView", "getBottomView", "getMultiView", "initView", "", "initData", "bottomViewGroup", "Landroid/view/ViewGroup;", "multiCardViewGroup", "drawCardModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;", "dlcDrawCardResp", "Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "drawAgain", "Lkotlin/Function2;", "", "goGraphic", "Lkotlin/Function1;", "", "goBack", "Lkotlin/Function0;", "addMultiCardView", "viewGroup", CommonMenuBottomSheetKt.KEY_ITEMS, "", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawItem;", "setTextViewGradient", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "destroy", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCDrawCardResultView {
    public static final int $stable = 8;
    private View bottomView;
    private final Context context;
    private View multiCardView;

    public DLCDrawCardResultView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final View getBottomView() {
        return this.bottomView;
    }

    public final View getMultiView() {
        return this.multiCardView;
    }

    public final void initView() {
        this.bottomView = LayoutInflater.from(this.context).inflate(R.layout.bili_app_dlc_dialog_card_result_bottom, (ViewGroup) null, false);
        this.multiCardView = LayoutInflater.from(this.context).inflate(R.layout.bili_app_dlc_dialog_card_result_multi_card, (ViewGroup) null, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0180, code lost:
        if (r4 == null) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initData(ViewGroup bottomViewGroup, ViewGroup multiCardViewGroup, final DLCCardDrawModel drawCardModel, final BillDLCRespInfo dlcDrawCardResp, final Function2<? super Integer, ? super Integer, Unit> function2, final Function1<? super String, Unit> function1, Function0<Unit> function0) {
        List itemList;
        int marginBottom;
        Iterable itemList2;
        String string;
        View view = this.bottomView;
        AppCompatTextView $this$initData_u24lambda_u240 = view != null ? (AppCompatTextView) view.findViewById(R.id.tv_dlc_card_result_draw_again) : null;
        if (!($this$initData_u24lambda_u240 instanceof AppCompatTextView)) {
            $this$initData_u24lambda_u240 = null;
        }
        if ($this$initData_u24lambda_u240 != null) {
            $this$initData_u24lambda_u240.setSelected(true);
            if ((drawCardModel != null ? drawCardModel.getLotteryNum() : 0) == 1) {
                string = $this$initData_u24lambda_u240.getContext().getString(bili.resource.homepage.R.string.homepage_global_string_146);
            } else {
                if ((drawCardModel != null ? drawCardModel.getLotteryNum() : 0) == 5) {
                    if ((dlcDrawCardResp != null ? dlcDrawCardResp.getLeftChance() : 0) >= 5) {
                        string = $this$initData_u24lambda_u240.getContext().getString(bili.resource.homepage.R.string.homepage_global_string_259);
                    }
                }
                if ((drawCardModel != null ? drawCardModel.getLotteryNum() : 0) == 10) {
                    if ((dlcDrawCardResp != null ? dlcDrawCardResp.getLeftChance() : 0) >= 10) {
                        string = $this$initData_u24lambda_u240.getContext().getString(bili.resource.homepage.R.string.homepage_global_string_318);
                    }
                }
                if (drawCardModel != null) {
                    drawCardModel.setLotteryNum(1);
                }
                string = $this$initData_u24lambda_u240.getContext().getString(bili.resource.homepage.R.string.homepage_global_string_146);
            }
            $this$initData_u24lambda_u240.setText(string);
            $this$initData_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardResultView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DLCDrawCardResultView.initData$lambda$0$0(DLCCardDrawModel.this, function2, dlcDrawCardResp, view2);
                }
            });
        }
        View view2 = this.bottomView;
        AppCompatTextView $this$initData_u24lambda_u241 = view2 != null ? (AppCompatTextView) view2.findViewById(R.id.tv_dlc_card_result_left_chance) : null;
        Intrinsics.checkNotNull($this$initData_u24lambda_u241, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String quantityString = $this$initData_u24lambda_u241.getContext().getResources().getQuantityString(bili.resource.homepage.R.plurals.homepage_global_string_442, dlcDrawCardResp != null ? dlcDrawCardResp.getLeftChance() : 0, Integer.valueOf(dlcDrawCardResp != null ? dlcDrawCardResp.getLeftChance() : 0));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        String format = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(dlcDrawCardResp != null ? dlcDrawCardResp.getLeftChance() : 0)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        $this$initData_u24lambda_u241.setText(format);
        View view3 = this.bottomView;
        AppCompatTextView appCompatTextView = view3 != null ? (AppCompatTextView) view3.findViewById(R.id.tv_dlc_card_result_goto_graphic) : null;
        Intrinsics.checkNotNull(appCompatTextView, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        final AppCompatTextView $this$initData_u24lambda_u242 = appCompatTextView;
        $this$initData_u24lambda_u242.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardResultView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                DLCDrawCardResultView.initData$lambda$2$0($this$initData_u24lambda_u242, function1, drawCardModel, view4);
            }
        });
        if (dlcDrawCardResp != null && (itemList2 = dlcDrawCardResp.getItemList()) != null) {
            Iterable $this$map$iv = itemList2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                DLCItem it = (DLCItem) item$iv$iv;
                destination$iv$iv.add(DLCCardModelHelper.INSTANCE.getDefaultImageItem(it.getCardItem(), it.getDisplay()));
            }
            itemList = CollectionsKt.toList((List) destination$iv$iv);
        }
        itemList = new ArrayList();
        boolean fullScreen = drawCardModel != null && drawCardModel.getScreenType() == 0;
        if (fullScreen) {
            if (itemList.size() >= 10) {
                marginBottom = DimenUtilsKt.dpToPx(10);
            } else if (itemList.size() >= 5) {
                marginBottom = DimenUtilsKt.dpToPx((int) BR.danmakuCountText);
            } else {
                marginBottom = DimenUtilsKt.dpToPx(0);
            }
        } else {
            marginBottom = DimenUtilsKt.dpToPx(0);
        }
        ConstraintLayout.LayoutParams $this$initData_u24lambda_u244 = new ConstraintLayout.LayoutParams(-1, -2);
        $this$initData_u24lambda_u244.bottomMargin = marginBottom;
        if (bottomViewGroup != null) {
            bottomViewGroup.addView(this.bottomView, (ViewGroup.LayoutParams) $this$initData_u24lambda_u244);
        }
        if (itemList.size() > 1) {
            addMultiCardView(drawCardModel, multiCardViewGroup, itemList, function0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$0$0(DLCCardDrawModel $drawCardModel, Function2 $drawAgain, BillDLCRespInfo $dlcDrawCardResp, View it) {
        String fSource;
        String fromId;
        String fromWhere;
        DLCReporterHelper.INSTANCE.reportDrawCardClick($drawCardModel != null ? $drawCardModel.getActId() : 0L, $drawCardModel != null ? $drawCardModel.getLotteryId() : 0L, $drawCardModel != null ? $drawCardModel.getActivityStatus() : 0, $drawCardModel != null ? $drawCardModel.getLotteryNum() : 0, ($drawCardModel == null || (fromWhere = $drawCardModel.getFromWhere()) == null) ? "" : fromWhere, ($drawCardModel == null || (fromId = $drawCardModel.getFromId()) == null) ? "" : fromId, ($drawCardModel == null || (fSource = $drawCardModel.getFSource()) == null) ? "" : fSource, $drawCardModel != null ? $drawCardModel.getPageType() : 0);
        if ($drawAgain != null) {
            $drawAgain.invoke(Integer.valueOf($dlcDrawCardResp != null ? $dlcDrawCardResp.getLeftChance() : -1), Integer.valueOf($drawCardModel != null ? $drawCardModel.getLotteryNum() : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$2$0(AppCompatTextView $this_apply, Function1 $goGraphic, DLCCardDrawModel $drawCardModel, View it) {
        $this_apply.setSelected(true);
        if ($goGraphic != null) {
            $goGraphic.invoke(($drawCardModel == null || (r0 = $drawCardModel.getJumpUrl()) == null) ? "" : "");
        }
    }

    private final void addMultiCardView(DLCCardDrawModel drawCardModel, ViewGroup viewGroup, final List<DLCCardDrawItem> list, final Function0<Unit> function0) {
        int marginTop;
        int marginBottom;
        if (this.multiCardView == null) {
            return;
        }
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(-1, -1);
        if (viewGroup != null) {
            viewGroup.addView(this.multiCardView, (ViewGroup.LayoutParams) params);
        }
        View view = this.multiCardView;
        Intrinsics.checkNotNull(view);
        AppCompatImageView closeBtn = view.findViewById(R.id.dlc_result_card_top_cancel);
        if (drawCardModel != null && drawCardModel.getScreenType() == 1) {
            if (closeBtn != null) {
                closeBtn.setVisibility(0);
            }
            if (closeBtn != null) {
                closeBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardResultView$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DLCDrawCardResultView.addMultiCardView$lambda$0(function0, view2);
                    }
                });
            }
        }
        View view2 = this.multiCardView;
        Intrinsics.checkNotNull(view2);
        final LinearLayout midView = (LinearLayout) view2.findViewById(R.id.cl_dlc_card_result_mid);
        View view3 = this.multiCardView;
        Intrinsics.checkNotNull(view3);
        LinearLayout linNameWrapper = (LinearLayout) view3.findViewById(R.id.linNameWrapper);
        View view4 = this.multiCardView;
        Intrinsics.checkNotNull(view4);
        AppCompatTextView tvCardsTitle = (AppCompatTextView) view4.findViewById(R.id.tvCardsTitle);
        final boolean fullScreen = drawCardModel != null && drawCardModel.getScreenType() == 0;
        final boolean isFiveCards = list.size() <= 5;
        if (fullScreen) {
            Intrinsics.checkNotNull(tvCardsTitle);
            setTextViewGradient(tvCardsTitle);
            Intrinsics.checkNotNull(linNameWrapper);
            linNameWrapper.setVisibility(0);
            if (isFiveCards) {
                marginTop = DimenUtilsKt.dpToPx(119);
            } else {
                marginTop = DimenUtilsKt.dpToPx(55);
            }
            if (isFiveCards) {
                marginBottom = DimenUtilsKt.dpToPx(60);
            } else {
                marginBottom = DimenUtilsKt.dpToPx(17);
            }
            ViewGroup.LayoutParams layoutParams = linNameWrapper.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams $this$addMultiCardView_u24lambda_u241 = (LinearLayout.LayoutParams) layoutParams;
            $this$addMultiCardView_u24lambda_u241.bottomMargin = marginBottom;
            $this$addMultiCardView_u24lambda_u241.topMargin = marginTop;
            linNameWrapper.setLayoutParams($this$addMultiCardView_u24lambda_u241);
        } else {
            Intrinsics.checkNotNull(linNameWrapper);
            linNameWrapper.setVisibility(8);
        }
        View view5 = this.multiCardView;
        if (view5 != null) {
            view5.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardResultView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    DLCDrawCardResultView.addMultiCardView$lambda$2(DLCDrawCardResultView.this, isFiveCards, midView, list, fullScreen);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addMultiCardView$lambda$0(Function0 $goBack, View it) {
        if ($goBack != null) {
            $goBack.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addMultiCardView$lambda$2(DLCDrawCardResultView this$0, boolean $isFiveCards, LinearLayout $midView, List $items, boolean $fullScreen) {
        MultiCardsLayoutHelper helper;
        int marginTop;
        Context it = this$0.context;
        if ($isFiveCards) {
            helper = new FiveCardsLayoutHelper(this$0.context);
        } else {
            helper = new TenCardsLayoutHelper(this$0.context);
        }
        DLCMultiCardsView $this$addMultiCardView_u24lambda_u242_u240_u240 = new DLCMultiCardsView(helper, it, null, 0, 12, null);
        $this$addMultiCardView_u24lambda_u242_u240_u240.setData($items, $midView != null ? Integer.valueOf($midView.getWidth()) : null);
        LinearLayout.LayoutParams $this$addMultiCardView_u24lambda_u242_u240_u241 = new LinearLayout.LayoutParams(-1, -2);
        if (!$fullScreen) {
            if ($isFiveCards) {
                marginTop = DimenUtilsKt.dpToPx(36);
            } else {
                marginTop = DimenUtilsKt.dpToPx(0);
            }
            $this$addMultiCardView_u24lambda_u242_u240_u241.topMargin = marginTop;
        }
        if ($midView != null) {
            $midView.addView($this$addMultiCardView_u24lambda_u242_u240_u240, $this$addMultiCardView_u24lambda_u242_u240_u241);
        }
    }

    private final void setTextViewGradient(final AppCompatTextView textView) {
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardResultView$setTextViewGradient$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int width = textView.getMeasuredWidth();
                LinearGradient textShader = new LinearGradient(0.0f, 0.0f, width, 0.0f, ColorKt.toArgb-8_81llA(ColorKt.Color(4294967295L)), ColorKt.toArgb-8_81llA(ColorKt.Color(4294964413L)), Shader.TileMode.CLAMP);
                textView.getPaint().setShader(textShader);
                textView.invalidate();
            }
        });
    }

    public final void destroy() {
    }
}