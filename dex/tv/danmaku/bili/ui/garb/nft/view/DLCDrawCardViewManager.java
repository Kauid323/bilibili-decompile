package tv.danmaku.bili.ui.garb.nft.view;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.alibaba.fastjson.JSON;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.okretro.ServiceGenerator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardItem;
import tv.danmaku.bili.ui.garb.api.BillDLCRespInfo;
import tv.danmaku.bili.ui.garb.api.CardInfo;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.api.DLCItem;
import tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService;
import tv.danmaku.bili.ui.garb.nft.api.DLCApiService;
import tv.danmaku.bili.ui.garb.nft.helper.DLCCardModelHelper;
import tv.danmaku.bili.ui.garb.nft.model.CardShareInfo;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardShareModel;

/* compiled from: DLCDrawCardViewManager.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010,\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020\u001bH\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\u0006\u00103\u001a\u00020\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001b0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001b0 X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\"\u001a%\u0012\u0004\u0012\u00020#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001b0 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardViewManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "lifeCycle", "Landroidx/lifecycle/Lifecycle;", "bottomViewGroup", "Landroid/view/ViewGroup;", "drawCardGroup", "multiViewViewGroup", "drawCardModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;", "actionWrapper", "Ltv/danmaku/bili/ui/garb/nft/view/DrawCardActionWrapper;", "drawCardView", "Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardView;", "drawCardViewResultView", "Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardResultView;", "service", "Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;", "goBackWrapper", "Lkotlin/Function0;", "", "goGraphicWrapper", "Lkotlin/Function1;", "", "drawAgainWrapper", "Lkotlin/Function2;", "", "goToDrawResultWrapper", "Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "cardLockStatus", "initData", "multiViewContainer", "floatBottomContainer", "drawCardContainer", "goToDrawView", "fromResult", "", "goToResultView", "respInfo", "destroyDrawView", "destroyResultView", "destroy", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCDrawCardViewManager {
    public static final int $stable = 8;
    private DrawCardActionWrapper actionWrapper;
    private ViewGroup bottomViewGroup;
    private Context context;
    private Function2<? super Integer, ? super Integer, Unit> drawAgainWrapper;
    private ViewGroup drawCardGroup;
    private DLCCardDrawModel drawCardModel;
    private DLCDrawCardView drawCardView;
    private DLCDrawCardResultView drawCardViewResultView;
    private Function0<Unit> goBackWrapper;
    private Function1<? super String, Unit> goGraphicWrapper;
    private Function2<? super BillDLCRespInfo, ? super CardLockStatus, Unit> goToDrawResultWrapper;
    private Lifecycle lifeCycle;
    private ViewGroup multiViewViewGroup;
    private final DLCApiService service;

    public DLCDrawCardViewManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object createService = ServiceGenerator.createService(DLCApiService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        this.service = (DLCApiService) createService;
        this.goBackWrapper = new Function0() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardViewManager$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit goBackWrapper$lambda$0;
                goBackWrapper$lambda$0 = DLCDrawCardViewManager.goBackWrapper$lambda$0(DLCDrawCardViewManager.this);
                return goBackWrapper$lambda$0;
            }
        };
        this.goGraphicWrapper = new Function1() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardViewManager$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit goGraphicWrapper$lambda$0;
                goGraphicWrapper$lambda$0 = DLCDrawCardViewManager.goGraphicWrapper$lambda$0(DLCDrawCardViewManager.this, (String) obj);
                return goGraphicWrapper$lambda$0;
            }
        };
        this.drawAgainWrapper = new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardViewManager$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit drawAgainWrapper$lambda$0;
                drawAgainWrapper$lambda$0 = DLCDrawCardViewManager.drawAgainWrapper$lambda$0(DLCDrawCardViewManager.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return drawAgainWrapper$lambda$0;
            }
        };
        this.goToDrawResultWrapper = new Function2() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardViewManager$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit goToDrawResultWrapper$lambda$0;
                goToDrawResultWrapper$lambda$0 = DLCDrawCardViewManager.goToDrawResultWrapper$lambda$0(DLCDrawCardViewManager.this, (BillDLCRespInfo) obj, (CardLockStatus) obj2);
                return goToDrawResultWrapper$lambda$0;
            }
        };
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit goBackWrapper$lambda$0(DLCDrawCardViewManager this$0) {
        Function0<Unit> goBack;
        DrawCardActionWrapper drawCardActionWrapper = this$0.actionWrapper;
        if (drawCardActionWrapper != null && (goBack = drawCardActionWrapper.getGoBack()) != null) {
            goBack.invoke();
        }
        this$0.destroy();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit goGraphicWrapper$lambda$0(DLCDrawCardViewManager this$0, String it) {
        Function1<String, Unit> goGraphic;
        Intrinsics.checkNotNullParameter(it, "it");
        Uri parse = Uri.parse(it);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(parse), this$0.context);
        DrawCardActionWrapper drawCardActionWrapper = this$0.actionWrapper;
        if (drawCardActionWrapper != null && (goGraphic = drawCardActionWrapper.getGoGraphic()) != null) {
            goGraphic.invoke(it);
        }
        this$0.destroy();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawAgainWrapper$lambda$0(DLCDrawCardViewManager this$0, int leftChance, int lotteryNum) {
        Function0<Unit> drawAgain;
        Function1<Integer, Unit> purchase;
        this$0.destroyResultView();
        if (leftChance < lotteryNum) {
            DrawCardActionWrapper drawCardActionWrapper = this$0.actionWrapper;
            if (drawCardActionWrapper != null && (purchase = drawCardActionWrapper.getPurchase()) != null) {
                purchase.invoke(Integer.valueOf(lotteryNum));
            }
        } else {
            DrawCardActionWrapper drawCardActionWrapper2 = this$0.actionWrapper;
            if (drawCardActionWrapper2 != null && (drawAgain = drawCardActionWrapper2.getDrawAgain()) != null) {
                drawAgain.invoke();
            }
            this$0.goToDrawView(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit goToDrawResultWrapper$lambda$0(DLCDrawCardViewManager this$0, BillDLCRespInfo resp, CardLockStatus cardLockStatus) {
        DLCItem dLCItem;
        Function3<DLCCardShareModel, DLCItem, Boolean, Unit> switchToResult;
        CardInfo copy;
        String str;
        String imgSmall;
        Intrinsics.checkNotNullParameter(resp, "resp");
        this$0.destroyDrawView();
        this$0.goToResultView(resp);
        ArrayList list = new ArrayList();
        boolean hasSmeltingTutorial = false;
        boolean singleCard = resp.getItemList().size() == 1;
        Iterable $this$forEach$iv = resp.getItemList();
        Iterator<T> it = $this$forEach$iv.iterator();
        while (true) {
            dLCItem = null;
            byte[] bArr = null;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            DLCItem it2 = (DLCItem) element$iv;
            String defaultImageUrl = DLCCardModelHelper.INSTANCE.getDefaultImageUrl(it2.getCardItem());
            String valueOf = String.valueOf(it2.getCardItem().getCardInfo().getId());
            String valueOf2 = String.valueOf(it2.getCardItem().getCardTypeInfo().getId());
            String valueOf3 = String.valueOf(it2.getItemType());
            String name = it2.getCardItem().getCardTypeInfo().getName();
            String jSONString = JSON.toJSONString(it2.getCardItem().getTag());
            if (jSONString != null) {
                bArr = jSONString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "getBytes(...)");
            }
            String encodeToString = Base64.encodeToString(bArr, 2);
            if (encodeToString != null) {
                str = encodeToString;
            } else {
                str = "";
            }
            String img = it2.getDisplay().getCornerMark().getImg();
            if (singleCard) {
                imgSmall = it2.getDisplay().getFrame().getImg();
            } else {
                imgSmall = it2.getDisplay().getFrame().getImgSmall();
            }
            list.add(new CardShareInfo(defaultImageUrl, name, str, valueOf, valueOf2, valueOf3, img, imgSmall, it2.getCardItem().getCardInfo().getWebCard().getSmeltTag()));
        }
        DLCCardDrawModel dLCCardDrawModel = this$0.drawCardModel;
        long lotteryId = dLCCardDrawModel != null ? dLCCardDrawModel.getLotteryId() : 0L;
        DLCCardDrawModel dLCCardDrawModel2 = this$0.drawCardModel;
        DLCCardShareModel shareModel = new DLCCardShareModel(lotteryId, dLCCardDrawModel2 != null ? dLCCardDrawModel2.getShareType() : 0, list);
        DLCItem originDlcCardItem = (DLCItem) CollectionsKt.firstOrNull(resp.getItemList());
        if (cardLockStatus == null) {
            dLCItem = originDlcCardItem;
        } else if (originDlcCardItem != null) {
            BiliDLCCardItem cardItem = originDlcCardItem.getCardItem();
            copy = r11.copy((r22 & 1) != 0 ? r11.id : 0L, (r22 & 2) != 0 ? r11.cardNo : null, (r22 & 4) != 0 ? r11.hashCode : null, (r22 & 8) != 0 ? r11.cardRightShow : null, (r22 & 16) != 0 ? r11.cardNumberGradientColor : null, (r22 & 32) != 0 ? r11.webCard : null, (r22 & 64) != 0 ? r11.cardRight : null, (r22 & BR.cover) != 0 ? r11.cardLockStatus : cardLockStatus, (r22 & BR.hallEnterHotText) != 0 ? originDlcCardItem.getCardItem().getCardInfo().cardExtText : null);
            dLCItem = DLCItem.copy$default(originDlcCardItem, 0, 0, BiliDLCCardItem.copy$default(cardItem, null, 0.0f, copy, 0, null, null, null, BR.count, null), null, 11, null);
        }
        DLCItem dlcItem = dLCItem;
        Iterable $this$any$iv = resp.getItemList();
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it3 = $this$any$iv.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object element$iv2 = it3.next();
                if (((DLCItem) element$iv2).getCardItem().getCardInfo().getWebCard().isSmeltCard()) {
                    hasSmeltingTutorial = true;
                    break;
                }
            }
        }
        DrawCardActionWrapper drawCardActionWrapper = this$0.actionWrapper;
        if (drawCardActionWrapper != null && (switchToResult = drawCardActionWrapper.getSwitchToResult()) != null) {
            switchToResult.invoke(shareModel, dlcItem, Boolean.valueOf(hasSmeltingTutorial));
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void initData$default(DLCDrawCardViewManager dLCDrawCardViewManager, ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3, DLCCardDrawModel dLCCardDrawModel, DrawCardActionWrapper drawCardActionWrapper, Lifecycle lifecycle, int i, Object obj) {
        Lifecycle lifecycle2;
        if ((i & 32) == 0) {
            lifecycle2 = lifecycle;
        } else {
            lifecycle2 = null;
        }
        dLCDrawCardViewManager.initData(viewGroup, viewGroup2, viewGroup3, dLCCardDrawModel, drawCardActionWrapper, lifecycle2);
    }

    public final void initData(ViewGroup multiViewContainer, ViewGroup floatBottomContainer, ViewGroup drawCardContainer, DLCCardDrawModel drawCardModel, DrawCardActionWrapper actionWrapper, Lifecycle lifeCycle) {
        Intrinsics.checkNotNullParameter(actionWrapper, "actionWrapper");
        this.multiViewViewGroup = multiViewContainer;
        this.bottomViewGroup = floatBottomContainer;
        this.drawCardGroup = drawCardContainer;
        this.drawCardModel = drawCardModel;
        this.lifeCycle = lifeCycle;
        this.actionWrapper = actionWrapper;
        goToDrawView$default(this, false, 1, null);
    }

    static /* synthetic */ void goToDrawView$default(DLCDrawCardViewManager dLCDrawCardViewManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dLCDrawCardViewManager.goToDrawView(z);
    }

    private final void goToDrawView(boolean fromResult) {
        destroyDrawView();
        if (this.drawCardView == null) {
            Context context = this.context;
            Lifecycle lifecycle = this.lifeCycle;
            DLCCardLockService dlcCardLockService = new DLCCardLockService(context, lifecycle != null ? LifecycleKt.getCoroutineScope(lifecycle) : null, this.service, null, 8, null);
            DLCDrawCardView $this$goToDrawView_u24lambda_u240 = new DLCDrawCardView(this.context, dlcCardLockService);
            $this$goToDrawView_u24lambda_u240.initView();
            $this$goToDrawView_u24lambda_u240.initData(this.drawCardGroup, this.drawCardModel, this.lifeCycle, this.goToDrawResultWrapper, this.goBackWrapper, fromResult);
            this.drawCardView = $this$goToDrawView_u24lambda_u240;
        }
    }

    private final void goToResultView(BillDLCRespInfo respInfo) {
        if (this.drawCardViewResultView == null) {
            DLCDrawCardResultView $this$goToResultView_u24lambda_u240 = new DLCDrawCardResultView(this.context);
            $this$goToResultView_u24lambda_u240.initView();
            $this$goToResultView_u24lambda_u240.initData(this.bottomViewGroup, this.multiViewViewGroup, this.drawCardModel, respInfo, this.drawAgainWrapper, this.goGraphicWrapper, this.goBackWrapper);
            this.drawCardViewResultView = $this$goToResultView_u24lambda_u240;
        }
    }

    private final void destroyDrawView() {
        View it;
        ViewGroup viewGroup;
        DLCDrawCardView dLCDrawCardView = this.drawCardView;
        if (dLCDrawCardView != null && (it = dLCDrawCardView.getRootView()) != null && (viewGroup = this.drawCardGroup) != null) {
            viewGroup.removeView(it);
        }
        DLCDrawCardView dLCDrawCardView2 = this.drawCardView;
        if (dLCDrawCardView2 != null) {
            dLCDrawCardView2.destroy();
        }
        this.drawCardView = null;
    }

    private final void destroyResultView() {
        View it;
        ViewGroup viewGroup;
        View it2;
        ViewGroup viewGroup2;
        DLCDrawCardResultView dLCDrawCardResultView = this.drawCardViewResultView;
        if (dLCDrawCardResultView != null && (it2 = dLCDrawCardResultView.getBottomView()) != null && (viewGroup2 = this.bottomViewGroup) != null) {
            viewGroup2.removeView(it2);
        }
        DLCDrawCardResultView dLCDrawCardResultView2 = this.drawCardViewResultView;
        if (dLCDrawCardResultView2 != null && (it = dLCDrawCardResultView2.getMultiView()) != null && (viewGroup = this.multiViewViewGroup) != null) {
            viewGroup.removeView(it);
        }
        ViewGroup viewGroup3 = this.multiViewViewGroup;
        if (viewGroup3 != null) {
            viewGroup3.removeAllViews();
        }
        DLCDrawCardResultView dLCDrawCardResultView3 = this.drawCardViewResultView;
        if (dLCDrawCardResultView3 != null) {
            dLCDrawCardResultView3.destroy();
        }
        this.drawCardViewResultView = null;
    }

    public final void destroy() {
        destroyDrawView();
        destroyResultView();
    }
}