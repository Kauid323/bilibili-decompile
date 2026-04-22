package kntr.common.share.common.ui.internal;

import androidx.compose.ui.graphics.ImageBitmap;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImage_androidKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.StaticImage;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareImage;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.ShareLog;
import kntr.common.share.common.ShareRawResult;
import kntr.common.share.common.ShareResult;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareToTargetState;
import kntr.common.share.domain.ShareDomainApi;
import kntr.common.share.domain.ShareReporter;
import kntr.common.share.domain.model.ShareClickParams;
import kntr.common.share.domain.model.ShareClickResult;
import kntr.common.share.domain.model.ShareClickResultKt;
import kntr.common.share.domain.model.ShareFinishParams;
import kntr.common.share.domain.model.ShareFinishResult;
import kntr.common.share.domain.model.ShareResponse;
import kntr.common.share.domain.model.ShareSession;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareClickHandler.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkntr/common/share/common/ui/ShareToTargetState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.common.ui.internal.ShareClickHandlerKt$mShareToTargetWithFetch$1", f = "ShareClickHandler.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, AdditionalButton.CLICK_TYPE_FIELD_NUMBER, AdditionalButton.CLICK_TYPE_FIELD_NUMBER, AdditionalButton.CLICK_TYPE_FIELD_NUMBER, 8, 8, 8, ConstantsKt.SPACER_9, ConstantsKt.SPACER_9, ConstantsKt.SPACER_9, ConstantsKt.SPACER_9, ConstantsKt.SPACER_9, 10, 10, 10, 10, 10}, l = {39, ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH, ConstantsKt.DAY_CONTENT_PREVIEW_ROW_HEIGHT, 55, ConstantsKt.RESERVATION_CONTENT_BUTTON_WIDTH, 64, 66, 72, 76, 86, 95}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "targetContent", "isRequested", "$this$flow", "targetContent", "isRequested", "$this$flow", "targetContent", "response", "isRequested", "$this$flow", "targetContent", "response", "isRequested", "$this$flow", "targetContent", "isRequested", "$this$flow", "targetContent", "request", "isRequested", "$this$flow", "targetContent", "isRequested", "$this$flow", "targetContent", "isRequested", "$this$flow", "targetContent", "result", "params", "isRequested", "$this$flow", "targetContent", "result", "finishMessage", "isRequested"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class ShareClickHandlerKt$mShareToTargetWithFetch$1 extends SuspendLambda implements Function2<FlowCollector<? super ShareToTargetState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShareContent $content;
    final /* synthetic */ ShareLocalContext $context;
    final /* synthetic */ ShareDomainApi $domain;
    final /* synthetic */ ShareReporter $reporter;
    final /* synthetic */ ShareSession $session;
    final /* synthetic */ ShareTarget $target;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareClickHandlerKt$mShareToTargetWithFetch$1(ShareTarget shareTarget, ShareContent shareContent, ShareDomainApi shareDomainApi, ShareSession shareSession, ShareReporter shareReporter, ShareLocalContext shareLocalContext, Continuation<? super ShareClickHandlerKt$mShareToTargetWithFetch$1> continuation) {
        super(2, continuation);
        this.$target = shareTarget;
        this.$content = shareContent;
        this.$domain = shareDomainApi;
        this.$session = shareSession;
        this.$reporter = shareReporter;
        this.$context = shareLocalContext;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> shareClickHandlerKt$mShareToTargetWithFetch$1 = new ShareClickHandlerKt$mShareToTargetWithFetch$1(this.$target, this.$content, this.$domain, this.$session, this.$reporter, this.$context, continuation);
        shareClickHandlerKt$mShareToTargetWithFetch$1.L$0 = obj;
        return shareClickHandlerKt$mShareToTargetWithFetch$1;
    }

    public final Object invoke(FlowCollector<? super ShareToTargetState> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0370, code lost:
        if (r7 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0199 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0229 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0296 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0327  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        Ref.ObjectRef targetContent;
        ShareClickParams buildClickParams;
        Object requestShareClick;
        Ref.ObjectRef targetContent2;
        String imageUrl;
        Ref.ObjectRef targetContent3;
        ShareResponse response;
        Ref.ObjectRef targetContent4;
        ShareResponse response2;
        String bizErrorMsg;
        Object loadImage$default;
        StaticImage staticImage;
        ImageBitmap image;
        ShareContent copy;
        Object withContext;
        ShareRawResult result;
        String str;
        Ref.ObjectRef targetContent5;
        ShareRawResult result2;
        Object requestShareFinish;
        Ref.ObjectRef targetContent6;
        String finishMessage;
        ShareReporter shareReporter;
        ShareResponse.Success success;
        ShareFinishResult shareFinishResult;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        String str2 = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$target instanceof ShareTarget.Custom) {
                    ShareLog.Companion.e("mShareToTargetWithFetch", "not allow custom channel");
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                    this.label = 1;
                    if ($this$flow.emit(new ShareToTargetState.ShareFinish(ShareResult.Failure, "Unknown"), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                i = 0;
                targetContent = new Ref.ObjectRef();
                targetContent.element = this.$content;
                if (this.$domain != null) {
                    i = 1;
                    this.L$0 = $this$flow;
                    this.L$1 = targetContent;
                    this.I$0 = 1;
                    this.label = 2;
                    if ($this$flow.emit(ShareToTargetState.Loading.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ShareLog.Companion.i("mShareToTargetWithFetch", "loading content.");
                    ShareDomainApi shareDomainApi = this.$domain;
                    ShareSession shareSession = this.$session;
                    buildClickParams = ShareClickHandlerKt.buildClickParams(this.$content, this.$target);
                    this.L$0 = $this$flow;
                    this.L$1 = targetContent;
                    this.I$0 = i;
                    this.label = 3;
                    requestShareClick = shareDomainApi.requestShareClick(shareSession, buildClickParams, (Continuation) this);
                    if (requestShareClick == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    response = (ShareResponse) requestShareClick;
                    if (!(response instanceof ShareResponse.Success)) {
                        this.L$0 = $this$flow;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent);
                        this.L$2 = response;
                        this.I$0 = i;
                        this.label = 4;
                        if ($this$flow.emit(new ShareToTargetState.Loaded(this.$content), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        targetContent4 = targetContent;
                        response2 = response;
                        ShareResult shareResult = ShareResult.Failure;
                        bizErrorMsg = ShareClickHandlerKt.bizErrorMsg(response2);
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(response2);
                        this.I$0 = i;
                        this.label = 5;
                        return $this$flow.emit(new ShareToTargetState.ShareFinish(shareResult, bizErrorMsg), (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                    }
                    targetContent.element = ShareClickResultKt.merge((ShareClickResult) ((ShareResponse.Success) response).getData(), this.$content);
                    ShareLog.Companion.i("mShareToTargetWithFetch", "loading content success.");
                }
                if (((ShareContent) targetContent.element).getImage() == null) {
                    if (((ShareContent) targetContent.element).getImageUrl() == null || !(!StringsKt.isBlank(imageUrl))) {
                        z = false;
                    }
                    if (z) {
                        ShareLog.Companion.i("mShareToTargetWithFetch", "loading image " + ((ShareContent) targetContent.element).getImageUrl());
                        if (i == 0) {
                            this.L$0 = $this$flow;
                            this.L$1 = targetContent;
                            this.I$0 = i;
                            this.label = 6;
                            if ($this$flow.emit(ShareToTargetState.Loading.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            targetContent3 = targetContent;
                        } else {
                            targetContent3 = targetContent;
                        }
                        String imageUrl2 = ((ShareContent) targetContent3.element).getImageUrl();
                        Intrinsics.checkNotNull(imageUrl2);
                        ImmutableImageRequest request = new ImageRequest(imageUrl2).build();
                        this.L$0 = $this$flow;
                        this.L$1 = targetContent3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(request);
                        this.I$0 = i;
                        this.label = 7;
                        loadImage$default = BiliImage_androidKt.loadImage$default(request, null, (Continuation) this, 2, null);
                        if (loadImage$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Image source = ((ImageSource) loadImage$default).getSource();
                        staticImage = source instanceof StaticImage ? (StaticImage) source : null;
                        if (staticImage != null && (image = staticImage.getBitmap()) != null) {
                            copy = r11.copy((r26 & 1) != 0 ? r11.mode : null, (r26 & 2) != 0 ? r11.title : null, (r26 & 4) != 0 ? r11.content : null, (r26 & 8) != 0 ? r11.link : null, (r26 & 16) != 0 ? r11.image : new ShareImage.Raw(image), (r26 & 32) != 0 ? r11.imageUrl : null, (r26 & 64) != 0 ? r11.audioLink : null, (r26 & 128) != 0 ? r11.schema : null, (r26 & 256) != 0 ? r11.programContent : null, (r26 & 512) != 0 ? r11.imContent : null, (r26 & 1024) != 0 ? r11.dynamicContent : null, (r26 & 2048) != 0 ? ((ShareContent) targetContent3.element).markPointContent : null);
                            targetContent3.element = copy;
                            ShareLog.Companion.i("mShareToTargetWithFetch", "loaded image");
                        }
                        targetContent2 = targetContent3;
                        this.L$0 = $this$flow;
                        this.L$1 = targetContent2;
                        this.L$2 = null;
                        this.I$0 = i;
                        this.label = 8;
                        if ($this$flow.emit(new ShareToTargetState.Loaded((ShareContent) targetContent2.element), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.L$0 = $this$flow;
                        this.L$1 = targetContent2;
                        this.I$0 = i;
                        this.label = 9;
                        withContext = BuildersKt.withContext(Dispatchers.getMain(), new ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1(this.$target, targetContent2, this.$context, null), (Continuation) this);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result = (ShareRawResult) withContext;
                        ShareLog.Companion.i("mShareToTargetWithFetch", "shareToTarget result(" + result + ")");
                        if (result.getResult() == ShareResult.Success || this.$domain == null) {
                            str = null;
                            targetContent5 = targetContent2;
                            result2 = result;
                            finishMessage = str;
                            shareReporter = this.$reporter;
                            if (shareReporter != null) {
                                ShareReporter.reportClickChannel$default(shareReporter, this.$session, this.$target, ((ShareContent) targetContent5.element).getMode(), null, 8, null);
                            }
                            ShareResult result3 = result2.getResult();
                            if (finishMessage != null) {
                                if (!StringsKt.isBlank(finishMessage)) {
                                    str2 = finishMessage;
                                    break;
                                }
                            }
                            str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                            this.I$0 = i;
                            this.label = 11;
                            return $this$flow.emit(new ShareToTargetState.ShareFinish(result3, str2), (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        ShareTarget shareTarget = this.$target;
                        String link = this.$content.getLink();
                        if (link == null) {
                            link = "";
                        }
                        ShareFinishParams params = new ShareFinishParams(shareTarget, link);
                        this.L$0 = $this$flow;
                        this.L$1 = targetContent2;
                        this.L$2 = result;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(params);
                        this.I$0 = i;
                        this.label = 10;
                        requestShareFinish = this.$domain.requestShareFinish(this.$session, params, (Continuation) this);
                        if (requestShareFinish == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        targetContent6 = targetContent2;
                        success = !(requestShareFinish instanceof ShareResponse.Success) ? (ShareResponse.Success) requestShareFinish : null;
                        if (success != null || (shareFinishResult = (ShareFinishResult) success.getData()) == null) {
                            result2 = result;
                            targetContent5 = targetContent6;
                            str = null;
                        } else {
                            str = shareFinishResult.getToast();
                            result2 = result;
                            targetContent5 = targetContent6;
                        }
                        finishMessage = str;
                        shareReporter = this.$reporter;
                        if (shareReporter != null) {
                        }
                        ShareResult result32 = result2.getResult();
                        if (finishMessage != null) {
                        }
                        str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                        this.I$0 = i;
                        this.label = 11;
                        if ($this$flow.emit(new ShareToTargetState.ShareFinish(result32, str2), (Continuation) this) != coroutine_suspended) {
                        }
                    }
                }
                targetContent2 = targetContent;
                this.L$0 = $this$flow;
                this.L$1 = targetContent2;
                this.L$2 = null;
                this.I$0 = i;
                this.label = 8;
                if ($this$flow.emit(new ShareToTargetState.Loaded((ShareContent) targetContent2.element), (Continuation) this) == coroutine_suspended) {
                }
                this.L$0 = $this$flow;
                this.L$1 = targetContent2;
                this.I$0 = i;
                this.label = 9;
                withContext = BuildersKt.withContext(Dispatchers.getMain(), new ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1(this.$target, targetContent2, this.$context, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                }
                result = (ShareRawResult) withContext;
                ShareLog.Companion.i("mShareToTargetWithFetch", "shareToTarget result(" + result + ")");
                if (result.getResult() == ShareResult.Success) {
                }
                str = null;
                targetContent5 = targetContent2;
                result2 = result;
                finishMessage = str;
                shareReporter = this.$reporter;
                if (shareReporter != null) {
                }
                ShareResult result322 = result2.getResult();
                if (finishMessage != null) {
                }
                str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                this.I$0 = i;
                this.label = 11;
                if ($this$flow.emit(new ShareToTargetState.ShareFinish(result322, str2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                i = this.I$0;
                targetContent = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                ShareLog.Companion.i("mShareToTargetWithFetch", "loading content.");
                ShareDomainApi shareDomainApi2 = this.$domain;
                ShareSession shareSession2 = this.$session;
                buildClickParams = ShareClickHandlerKt.buildClickParams(this.$content, this.$target);
                this.L$0 = $this$flow;
                this.L$1 = targetContent;
                this.I$0 = i;
                this.label = 3;
                requestShareClick = shareDomainApi2.requestShareClick(shareSession2, buildClickParams, (Continuation) this);
                if (requestShareClick == coroutine_suspended) {
                }
                response = (ShareResponse) requestShareClick;
                if (!(response instanceof ShareResponse.Success)) {
                }
                break;
            case 3:
                i = this.I$0;
                targetContent = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                requestShareClick = $result;
                response = (ShareResponse) requestShareClick;
                if (!(response instanceof ShareResponse.Success)) {
                }
                break;
            case 4:
                i = this.I$0;
                response2 = (ShareResponse) this.L$2;
                targetContent4 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                ShareResult shareResult2 = ShareResult.Failure;
                bizErrorMsg = ShareClickHandlerKt.bizErrorMsg(response2);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent4);
                this.L$2 = SpillingKt.nullOutSpilledVariable(response2);
                this.I$0 = i;
                this.label = 5;
                if ($this$flow.emit(new ShareToTargetState.ShareFinish(shareResult2, bizErrorMsg), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 5:
                int i2 = this.I$0;
                ShareResponse shareResponse = (ShareResponse) this.L$2;
                Ref.ObjectRef objectRef = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
            case 6:
                i = this.I$0;
                targetContent3 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                String imageUrl22 = ((ShareContent) targetContent3.element).getImageUrl();
                Intrinsics.checkNotNull(imageUrl22);
                ImmutableImageRequest request2 = new ImageRequest(imageUrl22).build();
                this.L$0 = $this$flow;
                this.L$1 = targetContent3;
                this.L$2 = SpillingKt.nullOutSpilledVariable(request2);
                this.I$0 = i;
                this.label = 7;
                loadImage$default = BiliImage_androidKt.loadImage$default(request2, null, (Continuation) this, 2, null);
                if (loadImage$default == coroutine_suspended) {
                }
                Image source2 = ((ImageSource) loadImage$default).getSource();
                if (source2 instanceof StaticImage) {
                }
                if (staticImage != null) {
                    copy = r11.copy((r26 & 1) != 0 ? r11.mode : null, (r26 & 2) != 0 ? r11.title : null, (r26 & 4) != 0 ? r11.content : null, (r26 & 8) != 0 ? r11.link : null, (r26 & 16) != 0 ? r11.image : new ShareImage.Raw(image), (r26 & 32) != 0 ? r11.imageUrl : null, (r26 & 64) != 0 ? r11.audioLink : null, (r26 & 128) != 0 ? r11.schema : null, (r26 & 256) != 0 ? r11.programContent : null, (r26 & 512) != 0 ? r11.imContent : null, (r26 & 1024) != 0 ? r11.dynamicContent : null, (r26 & 2048) != 0 ? ((ShareContent) targetContent3.element).markPointContent : null);
                    targetContent3.element = copy;
                    ShareLog.Companion.i("mShareToTargetWithFetch", "loaded image");
                    break;
                }
                targetContent2 = targetContent3;
                this.L$0 = $this$flow;
                this.L$1 = targetContent2;
                this.L$2 = null;
                this.I$0 = i;
                this.label = 8;
                if ($this$flow.emit(new ShareToTargetState.Loaded((ShareContent) targetContent2.element), (Continuation) this) == coroutine_suspended) {
                }
                this.L$0 = $this$flow;
                this.L$1 = targetContent2;
                this.I$0 = i;
                this.label = 9;
                withContext = BuildersKt.withContext(Dispatchers.getMain(), new ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1(this.$target, targetContent2, this.$context, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                }
                result = (ShareRawResult) withContext;
                ShareLog.Companion.i("mShareToTargetWithFetch", "shareToTarget result(" + result + ")");
                if (result.getResult() == ShareResult.Success) {
                }
                str = null;
                targetContent5 = targetContent2;
                result2 = result;
                finishMessage = str;
                shareReporter = this.$reporter;
                if (shareReporter != null) {
                }
                ShareResult result3222 = result2.getResult();
                if (finishMessage != null) {
                }
                str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                this.I$0 = i;
                this.label = 11;
                if ($this$flow.emit(new ShareToTargetState.ShareFinish(result3222, str2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                i = this.I$0;
                ImmutableImageRequest immutableImageRequest = (ImmutableImageRequest) this.L$2;
                targetContent3 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                loadImage$default = $result;
                Image source22 = ((ImageSource) loadImage$default).getSource();
                if (source22 instanceof StaticImage) {
                }
                if (staticImage != null) {
                }
                targetContent2 = targetContent3;
                this.L$0 = $this$flow;
                this.L$1 = targetContent2;
                this.L$2 = null;
                this.I$0 = i;
                this.label = 8;
                if ($this$flow.emit(new ShareToTargetState.Loaded((ShareContent) targetContent2.element), (Continuation) this) == coroutine_suspended) {
                }
                this.L$0 = $this$flow;
                this.L$1 = targetContent2;
                this.I$0 = i;
                this.label = 9;
                withContext = BuildersKt.withContext(Dispatchers.getMain(), new ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1(this.$target, targetContent2, this.$context, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                }
                result = (ShareRawResult) withContext;
                ShareLog.Companion.i("mShareToTargetWithFetch", "shareToTarget result(" + result + ")");
                if (result.getResult() == ShareResult.Success) {
                }
                str = null;
                targetContent5 = targetContent2;
                result2 = result;
                finishMessage = str;
                shareReporter = this.$reporter;
                if (shareReporter != null) {
                }
                ShareResult result32222 = result2.getResult();
                if (finishMessage != null) {
                }
                str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                this.I$0 = i;
                this.label = 11;
                if ($this$flow.emit(new ShareToTargetState.ShareFinish(result32222, str2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 8:
                i = this.I$0;
                targetContent2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$flow;
                this.L$1 = targetContent2;
                this.I$0 = i;
                this.label = 9;
                withContext = BuildersKt.withContext(Dispatchers.getMain(), new ShareClickHandlerKt$mShareToTargetWithFetch$1$result$1(this.$target, targetContent2, this.$context, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                }
                result = (ShareRawResult) withContext;
                ShareLog.Companion.i("mShareToTargetWithFetch", "shareToTarget result(" + result + ")");
                if (result.getResult() == ShareResult.Success) {
                }
                str = null;
                targetContent5 = targetContent2;
                result2 = result;
                finishMessage = str;
                shareReporter = this.$reporter;
                if (shareReporter != null) {
                }
                ShareResult result322222 = result2.getResult();
                if (finishMessage != null) {
                }
                str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                this.I$0 = i;
                this.label = 11;
                if ($this$flow.emit(new ShareToTargetState.ShareFinish(result322222, str2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case ConstantsKt.SPACER_9 /* 9 */:
                i = this.I$0;
                targetContent2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                withContext = $result;
                result = (ShareRawResult) withContext;
                ShareLog.Companion.i("mShareToTargetWithFetch", "shareToTarget result(" + result + ")");
                if (result.getResult() == ShareResult.Success) {
                }
                str = null;
                targetContent5 = targetContent2;
                result2 = result;
                finishMessage = str;
                shareReporter = this.$reporter;
                if (shareReporter != null) {
                }
                ShareResult result3222222 = result2.getResult();
                if (finishMessage != null) {
                }
                str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                this.I$0 = i;
                this.label = 11;
                if ($this$flow.emit(new ShareToTargetState.ShareFinish(result3222222, str2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 10:
                i = this.I$0;
                ShareFinishParams shareFinishParams = (ShareFinishParams) this.L$3;
                result = (ShareRawResult) this.L$2;
                targetContent6 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
                requestShareFinish = $result;
                if (!(requestShareFinish instanceof ShareResponse.Success)) {
                }
                if (success != null) {
                    break;
                }
                result2 = result;
                targetContent5 = targetContent6;
                str = null;
                finishMessage = str;
                shareReporter = this.$reporter;
                if (shareReporter != null) {
                }
                ShareResult result32222222 = result2.getResult();
                if (finishMessage != null) {
                }
                str2 = ShareClickHandlerKt.getDefaultMessage(this.$target, result2);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(targetContent5);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(finishMessage);
                this.I$0 = i;
                this.label = 11;
                if ($this$flow.emit(new ShareToTargetState.ShareFinish(result32222222, str2), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case MediaAttrUtils.TYPE_MENU /* 11 */:
                int i3 = this.I$0;
                String str3 = (String) this.L$3;
                ShareRawResult shareRawResult = (ShareRawResult) this.L$2;
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}