package kntr.app.tribee.publish.core.v2.serviceImpl.create;

import bili.resource.following.FollowingRes;
import bili.resource.following.Res;
import bili.resource.following.String0_commonMainKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.dynamic.common.KCreateActivity;
import com.bapis.bilibili.dynamic.common.KCreateBaseDraft;
import com.bapis.bilibili.dynamic.common.KCreateOption;
import com.bapis.bilibili.dynamic.common.KCreateResp;
import com.bapis.bilibili.dynamic.common.KCreateScene;
import com.bapis.bilibili.dynamic.common.KCreateTopic;
import com.bapis.bilibili.dynamic.common.KDynIdentity;
import com.bapis.bilibili.dynamic.common.KLbsLoc;
import com.bapis.bilibili.dynamic.common.KLiveWaterMark;
import com.bapis.bilibili.dynamic.common.KMetaDataCtrl;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KUserCreateMeta;
import com.bapis.bilibili.dynamic.common.KVideoShareInfo;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KCreateOpusReq;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KFeedMoss;
import javax.inject.Inject;
import kntr.app.tribee.base.TribeeResultChannel;
import kntr.app.tribee.base.TribeeResultContent;
import kntr.app.tribee.publish.core.v2.di.TribeePublishCreateFrom;
import kntr.app.tribee.publish.core.v2.di.TribeePublishFromSpmid;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.di.create.TribeePublishResultKey;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.service.PublishResult;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDataConverter;
import kntr.app.tribee.publish.core.v2.service.TribeePublishService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: TribeeCreatePublishServiceImpl.kt */
@TribeePublishScope
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/create/TribeeCreatePublishServiceImpl;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;", "converter", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "resultKey", "", "fromSpmid", "from", "<init>", "(Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "publish", "Lkotlin/Result;", "Lkntr/app/tribee/publish/core/v2/service/PublishResult;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "publish-gIAlu-s", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeCreatePublishServiceImpl implements TribeePublishService {
    private final TribeePublishDataConverter converter;
    private final String from;
    private final String fromSpmid;
    private final String resultKey;

    @Inject
    public TribeeCreatePublishServiceImpl(TribeePublishDataConverter converter, @TribeePublishResultKey String resultKey, @TribeePublishFromSpmid String fromSpmid, @TribeePublishCreateFrom String from) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(resultKey, "resultKey");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(from, "from");
        this.converter = converter;
        this.resultKey = resultKey;
        this.fromSpmid = fromSpmid;
        this.from = from;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|65|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
        r16 = " to ";
        r17 = "TribeePublishServiceImpl";
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0176 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0183 A[Catch: all -> 0x01e2, TRY_LEAVE, TryCatch #1 {all -> 0x01e2, blocks: (B:30:0x017a, B:32:0x0183), top: B:62:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0248  */
    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishService
    /* renamed from: publish-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo881publishgIAlus(TribeePublishContent content, Continuation<? super Result<PublishResult>> continuation) {
        TribeeCreatePublishServiceImpl$publish$1 tribeeCreatePublishServiceImpl$publish$1;
        String str;
        String str2;
        TribeePublishContent content2;
        Object m2636constructorimpl;
        String str3;
        String str4;
        Throwable it;
        KCreateScene kCreateScene;
        Object convert;
        KFeedMoss moss;
        TribeePublishContent content3;
        KCreateOpusReq req;
        TribeeCreatePublishServiceImpl $this$publish_gIAlu_s_u24lambda_u240;
        Object createOpus;
        TribeePublishContent content4;
        int i;
        TribeeCreatePublishServiceImpl $this$publish_gIAlu_s_u24lambda_u2402;
        KCreateResp result;
        KTribeeDyn it2;
        Object suspendGetString;
        KCreateResp result2;
        if (continuation instanceof TribeeCreatePublishServiceImpl$publish$1) {
            tribeeCreatePublishServiceImpl$publish$1 = (TribeeCreatePublishServiceImpl$publish$1) continuation;
            if ((tribeeCreatePublishServiceImpl$publish$1.label & Integer.MIN_VALUE) != 0) {
                tribeeCreatePublishServiceImpl$publish$1.label -= Integer.MIN_VALUE;
                Object $result = tribeeCreatePublishServiceImpl$publish$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeCreatePublishServiceImpl$publish$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("TribeePublishServiceImpl", "Publishing tribee content title " + content.getTitle() + " to " + content.getTribeeInfo());
                        KFeedMoss moss2 = new KFeedMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        kCreateScene = KCreateScene.CREATE_SCENE_CREATE_TRIBEE.INSTANCE;
                        TribeePublishDataConverter tribeePublishDataConverter = this.converter;
                        tribeeCreatePublishServiceImpl$publish$1.L$0 = content;
                        tribeeCreatePublishServiceImpl$publish$1.L$1 = moss2;
                        tribeeCreatePublishServiceImpl$publish$1.L$2 = kCreateScene;
                        tribeeCreatePublishServiceImpl$publish$1.label = 1;
                        convert = tribeePublishDataConverter.convert(content, false, tribeeCreatePublishServiceImpl$publish$1);
                        if (convert == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        moss = moss2;
                        content3 = content;
                        req = new KCreateOpusReq(new KUserCreateMeta(new KMetaDataCtrl((String) null, (String) null, (String) null, (String) null, (String) null, this.fromSpmid, this.from, (String) null, 0, 0, (String) null, 0, (String) null, 8095, (DefaultConstructorMarker) null), (KLbsLoc) null, 0, 6, (DefaultConstructorMarker) null), (KOpus) convert, kCreateScene, new KCreateOption(0, 0, 0, 0, 0, (KVideoShareInfo) null, (KCreateActivity) null, 0, 0L, 0, 0, 0L, 0L, 0L, 0, (KLiveWaterMark) null, content3.getSendToFollowing(), content3.getAigc(), 65535, (DefaultConstructorMarker) null), (KCreateTopic) null, (KCreateBaseDraft) null, (String) null, (KDynIdentity) null, content3.getTribeeArg(), 240, (DefaultConstructorMarker) null);
                        try {
                            Result.Companion companion = Result.Companion;
                            $this$publish_gIAlu_s_u24lambda_u240 = this;
                            tribeeCreatePublishServiceImpl$publish$1.L$0 = content3;
                            tribeeCreatePublishServiceImpl$publish$1.L$1 = SpillingKt.nullOutSpilledVariable(moss);
                            tribeeCreatePublishServiceImpl$publish$1.L$2 = SpillingKt.nullOutSpilledVariable(req);
                            tribeeCreatePublishServiceImpl$publish$1.L$3 = $this$publish_gIAlu_s_u24lambda_u240;
                            tribeeCreatePublishServiceImpl$publish$1.I$0 = 0;
                            tribeeCreatePublishServiceImpl$publish$1.label = 2;
                            createOpus = moss.createOpus(req, tribeeCreatePublishServiceImpl$publish$1);
                        } catch (Throwable th) {
                            th = th;
                            str = " to ";
                            str2 = "TribeePublishServiceImpl";
                            content2 = content3;
                            Result.Companion companion2 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            }
                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (it != null) {
                            }
                            return m2636constructorimpl;
                        }
                        if (createOpus != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        content4 = content3;
                        i = 0;
                        $this$publish_gIAlu_s_u24lambda_u2402 = $this$publish_gIAlu_s_u24lambda_u240;
                        try {
                            result = (KCreateResp) createOpus;
                            it2 = result.getTribeeFakeCard();
                            if (it2 == null) {
                                str = " to ";
                                str2 = "TribeePublishServiceImpl";
                                try {
                                    TribeeResultChannel.INSTANCE.setResult($this$publish_gIAlu_s_u24lambda_u2402.resultKey, new TribeeResultContent(result.getTribeeCategoryId(), it2));
                                } catch (Throwable th2) {
                                    th = th2;
                                    content2 = content4;
                                    Result.Companion companion22 = Result.Companion;
                                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                    if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                                    }
                                    it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                                    if (it != null) {
                                    }
                                    return m2636constructorimpl;
                                }
                            } else {
                                str = " to ";
                                str2 = "TribeePublishServiceImpl";
                            }
                            FollowingRes followingRes = FollowingRes.INSTANCE;
                            StringResource following_global_string_365 = String0_commonMainKt.getFollowing_global_string_365(Res.string.INSTANCE);
                            tribeeCreatePublishServiceImpl$publish$1.L$0 = content4;
                            tribeeCreatePublishServiceImpl$publish$1.L$1 = SpillingKt.nullOutSpilledVariable(moss);
                            tribeeCreatePublishServiceImpl$publish$1.L$2 = SpillingKt.nullOutSpilledVariable(req);
                            tribeeCreatePublishServiceImpl$publish$1.L$3 = SpillingKt.nullOutSpilledVariable($this$publish_gIAlu_s_u24lambda_u2402);
                            tribeeCreatePublishServiceImpl$publish$1.L$4 = result;
                            tribeeCreatePublishServiceImpl$publish$1.I$0 = i;
                            tribeeCreatePublishServiceImpl$publish$1.label = 3;
                            suspendGetString = followingRes.suspendGetString(following_global_string_365, tribeeCreatePublishServiceImpl$publish$1);
                        } catch (Throwable th3) {
                            th = th3;
                            str = " to ";
                            str2 = "TribeePublishServiceImpl";
                        }
                        if (suspendGetString != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        content2 = content4;
                        result2 = result;
                        try {
                            String successToast = (String) suspendGetString;
                            m2636constructorimpl = Result.m2636constructorimpl(new PublishResult(result2.getDynIdStr(), successToast));
                        } catch (Throwable th4) {
                            th = th4;
                            Result.Companion companion222 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            }
                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (it != null) {
                            }
                            return m2636constructorimpl;
                        }
                        if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            str3 = str;
                            str4 = str2;
                            KLog_androidKt.getKLog().i(str4, new StringBuilder().append("Publish succeed, title ").append(content2.getTitle()).append(str3).append(content2.getTribeeInfo()).append(" opus id ").append((PublishResult) m2636constructorimpl).toString());
                        } else {
                            str3 = str;
                            str4 = str2;
                        }
                        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (it != null) {
                            JobKt.ensureActive(tribeeCreatePublishServiceImpl$publish$1.getContext());
                            KLog_androidKt.getKLog().e(str4, "Publish failed, title " + content2.getTitle() + str3 + content2.getTribeeInfo(), it);
                        }
                        return m2636constructorimpl;
                    case 1:
                        TribeePublishContent content5 = (TribeePublishContent) tribeeCreatePublishServiceImpl$publish$1.L$0;
                        ResultKt.throwOnFailure($result);
                        convert = $result;
                        moss = (KFeedMoss) tribeeCreatePublishServiceImpl$publish$1.L$1;
                        kCreateScene = (KCreateScene.CREATE_SCENE_CREATE_TRIBEE) tribeeCreatePublishServiceImpl$publish$1.L$2;
                        content3 = content5;
                        req = new KCreateOpusReq(new KUserCreateMeta(new KMetaDataCtrl((String) null, (String) null, (String) null, (String) null, (String) null, this.fromSpmid, this.from, (String) null, 0, 0, (String) null, 0, (String) null, 8095, (DefaultConstructorMarker) null), (KLbsLoc) null, 0, 6, (DefaultConstructorMarker) null), (KOpus) convert, kCreateScene, new KCreateOption(0, 0, 0, 0, 0, (KVideoShareInfo) null, (KCreateActivity) null, 0, 0L, 0, 0, 0L, 0L, 0L, 0, (KLiveWaterMark) null, content3.getSendToFollowing(), content3.getAigc(), 65535, (DefaultConstructorMarker) null), (KCreateTopic) null, (KCreateBaseDraft) null, (String) null, (KDynIdentity) null, content3.getTribeeArg(), 240, (DefaultConstructorMarker) null);
                        Result.Companion companion3 = Result.Companion;
                        $this$publish_gIAlu_s_u24lambda_u240 = this;
                        tribeeCreatePublishServiceImpl$publish$1.L$0 = content3;
                        tribeeCreatePublishServiceImpl$publish$1.L$1 = SpillingKt.nullOutSpilledVariable(moss);
                        tribeeCreatePublishServiceImpl$publish$1.L$2 = SpillingKt.nullOutSpilledVariable(req);
                        tribeeCreatePublishServiceImpl$publish$1.L$3 = $this$publish_gIAlu_s_u24lambda_u240;
                        tribeeCreatePublishServiceImpl$publish$1.I$0 = 0;
                        tribeeCreatePublishServiceImpl$publish$1.label = 2;
                        createOpus = moss.createOpus(req, tribeeCreatePublishServiceImpl$publish$1);
                        if (createOpus != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        i = tribeeCreatePublishServiceImpl$publish$1.I$0;
                        $this$publish_gIAlu_s_u24lambda_u2402 = (TribeeCreatePublishServiceImpl) tribeeCreatePublishServiceImpl$publish$1.L$3;
                        req = (KCreateOpusReq) tribeeCreatePublishServiceImpl$publish$1.L$2;
                        moss = (KFeedMoss) tribeeCreatePublishServiceImpl$publish$1.L$1;
                        TribeePublishContent content6 = (TribeePublishContent) tribeeCreatePublishServiceImpl$publish$1.L$0;
                        ResultKt.throwOnFailure($result);
                        content4 = content6;
                        createOpus = $result;
                        result = (KCreateResp) createOpus;
                        it2 = result.getTribeeFakeCard();
                        if (it2 == null) {
                        }
                        FollowingRes followingRes2 = FollowingRes.INSTANCE;
                        StringResource following_global_string_3652 = String0_commonMainKt.getFollowing_global_string_365(Res.string.INSTANCE);
                        tribeeCreatePublishServiceImpl$publish$1.L$0 = content4;
                        tribeeCreatePublishServiceImpl$publish$1.L$1 = SpillingKt.nullOutSpilledVariable(moss);
                        tribeeCreatePublishServiceImpl$publish$1.L$2 = SpillingKt.nullOutSpilledVariable(req);
                        tribeeCreatePublishServiceImpl$publish$1.L$3 = SpillingKt.nullOutSpilledVariable($this$publish_gIAlu_s_u24lambda_u2402);
                        tribeeCreatePublishServiceImpl$publish$1.L$4 = result;
                        tribeeCreatePublishServiceImpl$publish$1.I$0 = i;
                        tribeeCreatePublishServiceImpl$publish$1.label = 3;
                        suspendGetString = followingRes2.suspendGetString(following_global_string_3652, tribeeCreatePublishServiceImpl$publish$1);
                        if (suspendGetString != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        int i2 = tribeeCreatePublishServiceImpl$publish$1.I$0;
                        result2 = (KCreateResp) tribeeCreatePublishServiceImpl$publish$1.L$4;
                        TribeeCreatePublishServiceImpl tribeeCreatePublishServiceImpl = (TribeeCreatePublishServiceImpl) tribeeCreatePublishServiceImpl$publish$1.L$3;
                        KCreateOpusReq kCreateOpusReq = (KCreateOpusReq) tribeeCreatePublishServiceImpl$publish$1.L$2;
                        KFeedMoss kFeedMoss = (KFeedMoss) tribeeCreatePublishServiceImpl$publish$1.L$1;
                        content2 = (TribeePublishContent) tribeeCreatePublishServiceImpl$publish$1.L$0;
                        ResultKt.throwOnFailure($result);
                        suspendGetString = $result;
                        str = " to ";
                        str2 = "TribeePublishServiceImpl";
                        String successToast2 = (String) suspendGetString;
                        m2636constructorimpl = Result.m2636constructorimpl(new PublishResult(result2.getDynIdStr(), successToast2));
                        if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                        }
                        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (it != null) {
                        }
                        return m2636constructorimpl;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeCreatePublishServiceImpl$publish$1 = new TribeeCreatePublishServiceImpl$publish$1(this, continuation);
        Object $result2 = tribeeCreatePublishServiceImpl$publish$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeCreatePublishServiceImpl$publish$1.label) {
        }
    }
}