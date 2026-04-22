package kntr.app.ad.domain.click.internal.action;

import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.handlers.AdWebHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.AppDownloadHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.AppStoreHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.BiliLinkHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.BiliNativeHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.BxProgramHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.DoubleJumpHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.HookHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.IMaxHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.MWebHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.SchemeHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.ULinkHandlerKt;
import kntr.app.ad.domain.click.internal.action.handlers.WxProgramHandlerKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionChainBuilder.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"addDefault", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionChainBuilder;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActionChainBuilderKt {
    public static final void addDefault(ActionChainBuilder $this$addDefault) {
        Intrinsics.checkNotNullParameter($this$addDefault, "<this>");
        $this$addDefault.add(WxProgramHandlerKt.wxProgramHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ActionParam.WxProgram addDefault$lambda$0;
                addDefault$lambda$0 = ActionChainBuilderKt.addDefault$lambda$0((ClickArg) obj);
                return addDefault$lambda$0;
            }
        });
        $this$addDefault.add(BxProgramHandlerKt.bxProgramHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                ActionParam.Url addDefault$lambda$1;
                addDefault$lambda$1 = ActionChainBuilderKt.addDefault$lambda$1((ClickArg) obj);
                return addDefault$lambda$1;
            }
        });
        $this$addDefault.add(IMaxHandlerKt.iMaxHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                ActionParam.Url addDefault$lambda$2;
                addDefault$lambda$2 = ActionChainBuilderKt.addDefault$lambda$2((ClickArg) obj);
                return addDefault$lambda$2;
            }
        });
        $this$addDefault.add(BiliNativeHandlerKt.biliNativeHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                ActionParam.Url addDefault$lambda$3;
                addDefault$lambda$3 = ActionChainBuilderKt.addDefault$lambda$3((ClickArg) obj);
                return addDefault$lambda$3;
            }
        });
        $this$addDefault.add(DoubleJumpHandlerKt.schemeDoubleJumpHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                ActionParam.SchemeDoubleJump addDefault$lambda$4;
                addDefault$lambda$4 = ActionChainBuilderKt.addDefault$lambda$4((ClickArg) obj);
                return addDefault$lambda$4;
            }
        });
        $this$addDefault.add(SchemeHandlerKt.schemeHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                ActionParam.Scheme addDefault$lambda$5;
                addDefault$lambda$5 = ActionChainBuilderKt.addDefault$lambda$5((ClickArg) obj);
                return addDefault$lambda$5;
            }
        });
        $this$addDefault.add(ULinkHandlerKt.uLinkHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                ActionParam.ULink addDefault$lambda$6;
                addDefault$lambda$6 = ActionChainBuilderKt.addDefault$lambda$6((ClickArg) obj);
                return addDefault$lambda$6;
            }
        });
        $this$addDefault.add(BiliLinkHandlerKt.biliLinkHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                ActionParam.Url addDefault$lambda$7;
                addDefault$lambda$7 = ActionChainBuilderKt.addDefault$lambda$7((ClickArg) obj);
                return addDefault$lambda$7;
            }
        });
        $this$addDefault.add(AppStoreHandlerKt.appStoreHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                ActionParam.AppStore addDefault$lambda$8;
                addDefault$lambda$8 = ActionChainBuilderKt.addDefault$lambda$8((ClickArg) obj);
                return addDefault$lambda$8;
            }
        });
        $this$addDefault.add(AppDownloadHandlerKt.appDownloadHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                ActionParam.AppDownload addDefault$lambda$9;
                addDefault$lambda$9 = ActionChainBuilderKt.addDefault$lambda$9((ClickArg) obj);
                return addDefault$lambda$9;
            }
        });
        $this$addDefault.add(HookHandlerKt.hookHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                ActionParam.Url addDefault$lambda$10;
                addDefault$lambda$10 = ActionChainBuilderKt.addDefault$lambda$10((ClickArg) obj);
                return addDefault$lambda$10;
            }
        });
        $this$addDefault.add(MWebHandlerKt.mWebHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                ActionParam.Web addDefault$lambda$11;
                addDefault$lambda$11 = ActionChainBuilderKt.addDefault$lambda$11((ClickArg) obj);
                return addDefault$lambda$11;
            }
        });
        $this$addDefault.add(AdWebHandlerKt.adWebHandler(), new Function1() { // from class: kntr.app.ad.domain.click.internal.action.ActionChainBuilderKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                ActionParam.Url addDefault$lambda$12;
                addDefault$lambda$12 = ActionChainBuilderKt.addDefault$lambda$12((ClickArg) obj);
                return addDefault$lambda$12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.WxProgram addDefault$lambda$0(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.WxProgram(req.getWxInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Url addDefault$lambda$1(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Url(req.getCallUpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Url addDefault$lambda$2(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Url(req.getCallUpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Url addDefault$lambda$3(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Url(req.getCallUpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.SchemeDoubleJump addDefault$lambda$4(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.SchemeDoubleJump(req.getCallUpUrl(), req.getJumpUrl(), req.getOpenWhiteList(), req.getEnableDoubleJump(), req.getUseAdWeb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Scheme addDefault$lambda$5(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Scheme(req.getCallUpUrl(), req.getCancelUrl(), req.getOpenWhiteList(), req.getEnableCallUpCancelToJumpUrl(), req.getUseAdWeb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.ULink addDefault$lambda$6(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.ULink(req.getCallUpUrl(), req.getOpenWhiteList(), req.getUniversalApp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Url addDefault$lambda$7(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Url(req.getCallUpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.AppStore addDefault$lambda$8(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.AppStore(req.getCallUpUrl(), req.getDownloadWhiteList(), req.getEnableAppStore(), req.getAppStorePriority(), req.getStoreLink(), req.isFirstJump());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.AppDownload addDefault$lambda$9(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.AppDownload(req.getCallUpUrl(), req.getDownloadWhiteList(), req.getEnableAppDownload());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Url addDefault$lambda$10(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Url(req.getCallUpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Web addDefault$lambda$11(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Web(req.getCallUpUrl(), req.getUseAdWeb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionParam.Url addDefault$lambda$12(ClickArg req) {
        Intrinsics.checkNotNullParameter(req, "req");
        return new ActionParam.Url(req.getCallUpUrl());
    }
}