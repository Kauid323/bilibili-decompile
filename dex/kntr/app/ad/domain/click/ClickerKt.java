package kntr.app.ad.domain.click;

import java.util.Map;
import kntr.app.ad.domain.click.internal.ClickRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clicker.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087@¢\u0006\u0002\u0010\u0015\u001aH\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0019H\u0087@¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u000eH\u0002\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u000eH\u0002\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u001e"}, d2 = {"hasJumped", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/Clicker;", "getHasJumped$annotations", "(Lkntr/app/ad/domain/click/Clicker;)V", "getHasJumped", "(Lkntr/app/ad/domain/click/Clicker;)Z", "hasJumpedToThirdApp", "getHasJumpedToThirdApp$annotations", "getHasJumpedToThirdApp", "isValidClick", "isValidClick$annotations", "clickCard", "arg", "Lkntr/app/ad/domain/click/ClickArg;", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "listener", "Lkntr/app/ad/domain/click/ICardClickListener;", "(Lkntr/app/ad/domain/click/Clicker;Lkntr/app/ad/domain/click/ClickArg;Ljava/util/Map;Lkntr/app/ad/domain/click/ICardClickListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickButton", "buttonArg", "cardArg", "Lkntr/app/ad/domain/click/IButtonClickListener;", "(Lkntr/app/ad/domain/click/Clicker;Lkntr/app/ad/domain/click/ClickArg;Lkntr/app/ad/domain/click/ClickArg;Ljava/util/Map;Lkntr/app/ad/domain/click/IButtonClickListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toCardRequest", "Lkntr/app/ad/domain/click/internal/ClickRequest;", "toButtonRequest", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClickerKt {
    public static /* synthetic */ void getHasJumped$annotations(Clicker clicker) {
    }

    public static /* synthetic */ void getHasJumpedToThirdApp$annotations(Clicker clicker) {
    }

    public static /* synthetic */ void isValidClick$annotations(Clicker clicker) {
    }

    public static final boolean getHasJumped(Clicker $this$hasJumped) {
        Intrinsics.checkNotNullParameter($this$hasJumped, "<this>");
        return $this$hasJumped.getContext$click_debug().getHasJumped();
    }

    public static final boolean getHasJumpedToThirdApp(Clicker $this$hasJumpedToThirdApp) {
        Intrinsics.checkNotNullParameter($this$hasJumpedToThirdApp, "<this>");
        return $this$hasJumpedToThirdApp.getContext$click_debug().getHasJumpedToThirdApp();
    }

    public static final boolean isValidClick(Clicker $this$isValidClick) {
        Intrinsics.checkNotNullParameter($this$isValidClick, "<this>");
        return $this$isValidClick.getContext$click_debug().isValidClick();
    }

    public static /* synthetic */ Object clickCard$default(Clicker clicker, ClickArg clickArg, Map map, ICardClickListener iCardClickListener, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        if ((i & 4) != 0) {
            iCardClickListener = new DefaultCardClickListener(clickArg);
        }
        return clickCard(clicker, clickArg, map, iCardClickListener, continuation);
    }

    public static final Object clickCard(final Clicker $this$clickCard, ClickArg arg, Map<String, ? extends Object> map, final ICardClickListener listener, Continuation<? super Boolean> continuation) {
        ClickRequest $this$clickCard_u24lambda_u240 = toCardRequest(arg);
        $this$clickCard_u24lambda_u240.setOnStart$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit clickCard$lambda$0$0;
                clickCard$lambda$0$0 = ClickerKt.clickCard$lambda$0$0(ICardClickListener.this, $this$clickCard);
                return clickCard$lambda$0$0;
            }
        });
        $this$clickCard_u24lambda_u240.setOnAnswered$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit clickCard$lambda$0$1;
                clickCard$lambda$0$1 = ClickerKt.clickCard$lambda$0$1(ICardClickListener.this, $this$clickCard);
                return clickCard$lambda$0$1;
            }
        });
        $this$clickCard_u24lambda_u240.setOnLost$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit clickCard$lambda$0$2;
                clickCard$lambda$0$2 = ClickerKt.clickCard$lambda$0$2(ICardClickListener.this, $this$clickCard);
                return clickCard$lambda$0$2;
            }
        });
        return $this$clickCard.click$click_debug($this$clickCard_u24lambda_u240, map, continuation);
    }

    public static final Unit clickCard$lambda$0$0(ICardClickListener $listener, Clicker $this_clickCard) {
        $listener.onStart($this_clickCard.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static final Unit clickCard$lambda$0$1(ICardClickListener $listener, Clicker $this_clickCard) {
        $listener.onAnswered($this_clickCard.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static final Unit clickCard$lambda$0$2(ICardClickListener $listener, Clicker $this_clickCard) {
        $listener.onLost($this_clickCard.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object clickButton$default(Clicker clicker, ClickArg clickArg, ClickArg clickArg2, Map map, IButtonClickListener iButtonClickListener, Continuation continuation, int i, Object obj) {
        Map map2;
        DefaultButtonClickListener defaultButtonClickListener;
        if ((i & 4) == 0) {
            map2 = map;
        } else {
            map2 = null;
        }
        if ((i & 8) == 0) {
            defaultButtonClickListener = iButtonClickListener;
        } else {
            defaultButtonClickListener = new DefaultButtonClickListener(clickArg, clickArg2);
        }
        return clickButton(clicker, clickArg, clickArg2, map2, defaultButtonClickListener, continuation);
    }

    public static final Object clickButton(final Clicker $this$clickButton, ClickArg buttonArg, ClickArg cardArg, Map<String, ? extends Object> map, final IButtonClickListener listener, Continuation<? super Boolean> continuation) {
        if (buttonArg == null) {
            return clickCard$default($this$clickButton, cardArg, map, null, continuation, 4, null);
        }
        ClickRequest $this$clickButton_u24lambda_u240 = toButtonRequest(buttonArg);
        $this$clickButton_u24lambda_u240.setOnStart$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit clickButton$lambda$0$0;
                clickButton$lambda$0$0 = ClickerKt.clickButton$lambda$0$0(IButtonClickListener.this, $this$clickButton);
                return clickButton$lambda$0$0;
            }
        });
        $this$clickButton_u24lambda_u240.setOnAnswered$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit clickButton$lambda$0$1;
                clickButton$lambda$0$1 = ClickerKt.clickButton$lambda$0$1(IButtonClickListener.this, $this$clickButton);
                return clickButton$lambda$0$1;
            }
        });
        $this$clickButton_u24lambda_u240.setOnLost$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda8
            public final Object invoke() {
                Unit clickButton$lambda$0$2;
                clickButton$lambda$0$2 = ClickerKt.clickButton$lambda$0$2(IButtonClickListener.this, $this$clickButton);
                return clickButton$lambda$0$2;
            }
        });
        ClickRequest $this$clickButton_u24lambda_u240_u243 = toCardRequest(cardArg);
        $this$clickButton_u24lambda_u240_u243.setOnStart$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda9
            public final Object invoke() {
                Unit clickButton$lambda$0$3$0;
                clickButton$lambda$0$3$0 = ClickerKt.clickButton$lambda$0$3$0(IButtonClickListener.this, $this$clickButton);
                return clickButton$lambda$0$3$0;
            }
        });
        $this$clickButton_u24lambda_u240_u243.setOnAnswered$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda10
            public final Object invoke() {
                Unit clickButton$lambda$0$3$1;
                clickButton$lambda$0$3$1 = ClickerKt.clickButton$lambda$0$3$1(IButtonClickListener.this, $this$clickButton);
                return clickButton$lambda$0$3$1;
            }
        });
        $this$clickButton_u24lambda_u240_u243.setOnLost$click_debug(new Function0() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit clickButton$lambda$0$3$2;
                clickButton$lambda$0$3$2 = ClickerKt.clickButton$lambda$0$3$2(IButtonClickListener.this, $this$clickButton);
                return clickButton$lambda$0$3$2;
            }
        });
        $this$clickButton_u24lambda_u240.setDowngrade($this$clickButton_u24lambda_u240_u243);
        return $this$clickButton.click$click_debug($this$clickButton_u24lambda_u240, map, continuation);
    }

    public static final Unit clickButton$lambda$0$0(IButtonClickListener $listener, Clicker $this_clickButton) {
        $listener.onButtonStart($this_clickButton.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static final Unit clickButton$lambda$0$1(IButtonClickListener $listener, Clicker $this_clickButton) {
        $listener.onButtonAnswered($this_clickButton.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static final Unit clickButton$lambda$0$2(IButtonClickListener $listener, Clicker $this_clickButton) {
        $listener.onButtonLost($this_clickButton.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static final Unit clickButton$lambda$0$3$0(IButtonClickListener $listener, Clicker $this_clickButton) {
        $listener.onCardStart($this_clickButton.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static final Unit clickButton$lambda$0$3$1(IButtonClickListener $listener, Clicker $this_clickButton) {
        $listener.onCardAnswered($this_clickButton.getContext$click_debug());
        return Unit.INSTANCE;
    }

    public static final Unit clickButton$lambda$0$3$2(IButtonClickListener $listener, Clicker $this_clickButton) {
        $listener.onCardLost($this_clickButton.getContext$click_debug());
        return Unit.INSTANCE;
    }

    private static final ClickRequest toCardRequest(final ClickArg $this$toCardRequest) {
        return new ClickRequest(ClickArgKt.clickArg(new Function1() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit cardRequest$lambda$0;
                cardRequest$lambda$0 = ClickerKt.toCardRequest$lambda$0(ClickArg.this, (ClickArgBuilder) obj);
                return cardRequest$lambda$0;
            }
        }));
    }

    public static final Unit toCardRequest$lambda$0(ClickArg $this_toCardRequest, ClickArgBuilder $this$clickArg) {
        Intrinsics.checkNotNullParameter($this$clickArg, "$this$clickArg");
        $this$clickArg.setWxInfo($this_toCardRequest.getWxInfo());
        $this$clickArg.setCallUpUrl($this_toCardRequest.getCallUpUrl());
        $this$clickArg.setJumpUrl($this_toCardRequest.getJumpUrl());
        $this$clickArg.setCancelUrl($this_toCardRequest.getCancelUrl());
        $this$clickArg.setEnableCallUpCancelToJumpUrl($this_toCardRequest.getEnableCallUpCancelToJumpUrl());
        $this$clickArg.setEnableDoubleJump($this_toCardRequest.getEnableDoubleJump());
        $this$clickArg.setUseAdWeb($this_toCardRequest.getUseAdWeb());
        $this$clickArg.setOpenWhiteList($this_toCardRequest.getOpenWhiteList());
        $this$clickArg.setDownloadWhiteList($this_toCardRequest.getDownloadWhiteList());
        $this$clickArg.setDlSucCallUpUrl(null);
        $this$clickArg.setEnableAppStore($this_toCardRequest.getEnableAppStore());
        $this$clickArg.setEnableAppDownload(false);
        $this$clickArg.setClickUrls($this_toCardRequest.getClickUrls());
        $this$clickArg.setUniversalApp($this_toCardRequest.getUniversalApp());
        $this$clickArg.setAppStorePriority($this_toCardRequest.getAppStorePriority());
        $this$clickArg.setStoreLink($this_toCardRequest.getStoreLink());
        $this$clickArg.setDownloadUrlType($this_toCardRequest.getDownloadUrlType());
        $this$clickArg.setFirstJump($this_toCardRequest.isFirstJump());
        return Unit.INSTANCE;
    }

    private static final ClickRequest toButtonRequest(final ClickArg $this$toButtonRequest) {
        return new ClickRequest(ClickArgKt.clickArg(new Function1() { // from class: kntr.app.ad.domain.click.ClickerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit buttonRequest$lambda$0;
                buttonRequest$lambda$0 = ClickerKt.toButtonRequest$lambda$0(ClickArg.this, (ClickArgBuilder) obj);
                return buttonRequest$lambda$0;
            }
        }));
    }

    public static final Unit toButtonRequest$lambda$0(ClickArg $this_toButtonRequest, ClickArgBuilder $this$clickArg) {
        Intrinsics.checkNotNullParameter($this$clickArg, "$this$clickArg");
        $this$clickArg.setWxInfo(null);
        $this$clickArg.setCallUpUrl($this_toButtonRequest.getCallUpUrl());
        $this$clickArg.setJumpUrl($this_toButtonRequest.getJumpUrl());
        $this$clickArg.setCancelUrl($this_toButtonRequest.getCancelUrl());
        $this$clickArg.setEnableCallUpCancelToJumpUrl($this_toButtonRequest.getEnableCallUpCancelToJumpUrl());
        $this$clickArg.setEnableDoubleJump($this_toButtonRequest.getEnableDoubleJump());
        $this$clickArg.setUseAdWeb($this_toButtonRequest.getUseAdWeb());
        $this$clickArg.setOpenWhiteList($this_toButtonRequest.getOpenWhiteList());
        $this$clickArg.setDownloadWhiteList($this_toButtonRequest.getDownloadWhiteList());
        $this$clickArg.setDlSucCallUpUrl($this_toButtonRequest.getDlSucCallUpUrl());
        $this$clickArg.setEnableAppStore($this_toButtonRequest.getEnableAppStore());
        $this$clickArg.setEnableAppDownload($this_toButtonRequest.getEnableAppDownload());
        $this$clickArg.setClickUrls($this_toButtonRequest.getClickUrls());
        $this$clickArg.setUniversalApp($this_toButtonRequest.getUniversalApp());
        $this$clickArg.setAppStorePriority($this_toButtonRequest.getAppStorePriority());
        $this$clickArg.setStoreLink($this_toButtonRequest.getStoreLink());
        $this$clickArg.setDownloadUrlType($this_toButtonRequest.getDownloadUrlType());
        $this$clickArg.setFirstJump($this_toButtonRequest.isFirstJump());
        return Unit.INSTANCE;
    }
}