package kntr.app.tribee.publish.core.v2.serviceImpl.edit;

import bili.resource.following.FollowingRes;
import bili.resource.following.Res;
import bili.resource.following.String0_commonMainKt;
import com.bapis.bilibili.dynamic.common.KCreateActivity;
import com.bapis.bilibili.dynamic.common.KCreateBaseDraft;
import com.bapis.bilibili.dynamic.common.KCreateOption;
import com.bapis.bilibili.dynamic.common.KCreateScene;
import com.bapis.bilibili.dynamic.common.KCreateTopic;
import com.bapis.bilibili.dynamic.common.KLbsLoc;
import com.bapis.bilibili.dynamic.common.KLiveWaterMark;
import com.bapis.bilibili.dynamic.common.KMetaDataCtrl;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KUserCreateMeta;
import com.bapis.bilibili.dynamic.common.KVideoShareInfo;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KEditOpusReq;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KFeedMoss;
import javax.inject.Inject;
import kntr.app.tribee.publish.core.v2.di.TribeePublishCreateFrom;
import kntr.app.tribee.publish.core.v2.di.TribeePublishFromSpmid;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.di.edit.TribeeEditContentId;
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

/* compiled from: TribeeEditPublishServiceImpl.kt */
@TribeePublishScope
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/edit/TribeeEditPublishServiceImpl;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishService;", "converter", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;", "fromSpmid", "", "from", "contentId", "<init>", "(Lkntr/app/tribee/publish/core/v2/service/TribeePublishDataConverter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "publish", "Lkotlin/Result;", "Lkntr/app/tribee/publish/core/v2/service/PublishResult;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "publish-gIAlu-s", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeEditPublishServiceImpl implements TribeePublishService {
    private final String contentId;
    private final TribeePublishDataConverter converter;
    private final String from;
    private final String fromSpmid;

    @Inject
    public TribeeEditPublishServiceImpl(TribeePublishDataConverter converter, @TribeePublishFromSpmid String fromSpmid, @TribeePublishCreateFrom String from, @TribeeEditContentId String contentId) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        this.converter = converter;
        this.fromSpmid = fromSpmid;
        this.from = from;
        this.contentId = contentId;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|70|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x026f  */
    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishService
    /* renamed from: publish-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo881publishgIAlus(TribeePublishContent content, Continuation<? super Result<PublishResult>> continuation) {
        TribeeEditPublishServiceImpl$publish$1 tribeeEditPublishServiceImpl$publish$1;
        TribeeEditPublishServiceImpl$publish$1 tribeeEditPublishServiceImpl$publish$12;
        Object m2636constructorimpl;
        TribeePublishContent content2;
        TribeeEditPublishServiceImpl tribeeEditPublishServiceImpl;
        Throwable it;
        TribeeEditPublishServiceImpl $this$publish_gIAlu_s_u24lambda_u240;
        int i;
        Object obj;
        long id;
        KCreateScene kCreateScene;
        Object convert;
        TribeeEditPublishServiceImpl $this$publish_gIAlu_s_u24lambda_u2402;
        KFeedMoss moss;
        KEditOpusReq req;
        KFeedMoss moss2;
        long id2;
        int i2;
        String str;
        Object suspendGetString;
        TribeePublishContent content3 = content;
        if (continuation instanceof TribeeEditPublishServiceImpl$publish$1) {
            tribeeEditPublishServiceImpl$publish$1 = (TribeeEditPublishServiceImpl$publish$1) continuation;
            if ((tribeeEditPublishServiceImpl$publish$1.label & Integer.MIN_VALUE) != 0) {
                tribeeEditPublishServiceImpl$publish$1.label -= Integer.MIN_VALUE;
                tribeeEditPublishServiceImpl$publish$12 = tribeeEditPublishServiceImpl$publish$1;
                Object $result = tribeeEditPublishServiceImpl$publish$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeEditPublishServiceImpl$publish$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KFeedMoss moss3 = new KFeedMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        try {
                            Result.Companion companion = Result.Companion;
                            $this$publish_gIAlu_s_u24lambda_u240 = this;
                            i = 0;
                            long id3 = Long.parseLong($this$publish_gIAlu_s_u24lambda_u240.contentId);
                            obj = coroutine_suspended;
                            id = id3;
                            KLog_androidKt.getKLog().i("TribeeEditPublishServiceImpl", "Editing tribee content id " + id + " title " + content.getTitle() + " to " + content.getTribeeInfo());
                            kCreateScene = KCreateScene.CREATE_SCENE_CREATE_TRIBEE.INSTANCE;
                            TribeePublishDataConverter tribeePublishDataConverter = $this$publish_gIAlu_s_u24lambda_u240.converter;
                            tribeeEditPublishServiceImpl$publish$12.L$0 = content3;
                            tribeeEditPublishServiceImpl$publish$12.L$1 = moss3;
                            tribeeEditPublishServiceImpl$publish$12.L$2 = $this$publish_gIAlu_s_u24lambda_u240;
                            tribeeEditPublishServiceImpl$publish$12.L$3 = kCreateScene;
                            tribeeEditPublishServiceImpl$publish$12.I$0 = 0;
                            tribeeEditPublishServiceImpl$publish$12.J$0 = id;
                            tribeeEditPublishServiceImpl$publish$12.label = 1;
                            convert = tribeePublishDataConverter.convert(content3, false, tribeeEditPublishServiceImpl$publish$12);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            content2 = content3;
                            if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            }
                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (it != null) {
                            }
                            return m2636constructorimpl;
                        }
                        if (convert == obj) {
                            return obj;
                        }
                        $this$publish_gIAlu_s_u24lambda_u2402 = $this$publish_gIAlu_s_u24lambda_u240;
                        moss = moss3;
                        try {
                            KFeedMoss moss4 = moss;
                            try {
                                req = new KEditOpusReq(id, new KUserCreateMeta(new KMetaDataCtrl((String) null, (String) null, (String) null, (String) null, (String) null, $this$publish_gIAlu_s_u24lambda_u2402.fromSpmid, $this$publish_gIAlu_s_u24lambda_u2402.from, (String) null, 0, 0, (String) null, 0, (String) null, 8095, (DefaultConstructorMarker) null), (KLbsLoc) null, 0, 6, (DefaultConstructorMarker) null), (KOpus) convert, kCreateScene, new KCreateOption(0, 0, 0, 0, 0, (KVideoShareInfo) null, (KCreateActivity) null, 0, 0L, 0, 0, 0L, 0L, 0L, 0, (KLiveWaterMark) null, false, content3.getAigc(), 131071, (DefaultConstructorMarker) null), (KCreateTopic) null, (KCreateBaseDraft) null, (String) null, content3.getTribeeArg(), 0L, 736, (DefaultConstructorMarker) null);
                                tribeeEditPublishServiceImpl$publish$12.L$0 = content3;
                                tribeeEditPublishServiceImpl$publish$12.L$1 = SpillingKt.nullOutSpilledVariable(moss4);
                                tribeeEditPublishServiceImpl$publish$12.L$2 = $this$publish_gIAlu_s_u24lambda_u2402;
                                tribeeEditPublishServiceImpl$publish$12.L$3 = SpillingKt.nullOutSpilledVariable(req);
                                tribeeEditPublishServiceImpl$publish$12.I$0 = i;
                                tribeeEditPublishServiceImpl$publish$12.J$0 = id;
                                tribeeEditPublishServiceImpl$publish$12.label = 2;
                                moss2 = moss4;
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion22 = Result.Companion;
                                m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                content2 = content3;
                                if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                                }
                                it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                                if (it != null) {
                                }
                                return m2636constructorimpl;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        if (moss2.editOpus(req, tribeeEditPublishServiceImpl$publish$12) != obj) {
                            return obj;
                        }
                        id2 = id;
                        i2 = i;
                        try {
                            str = $this$publish_gIAlu_s_u24lambda_u2402.contentId;
                            FollowingRes followingRes = FollowingRes.INSTANCE;
                            StringResource following_global_string_145 = String0_commonMainKt.getFollowing_global_string_145(Res.string.INSTANCE);
                            tribeeEditPublishServiceImpl$publish$12.L$0 = content3;
                            content2 = content3;
                            try {
                                tribeeEditPublishServiceImpl$publish$12.L$1 = SpillingKt.nullOutSpilledVariable(moss2);
                                tribeeEditPublishServiceImpl$publish$12.L$2 = SpillingKt.nullOutSpilledVariable($this$publish_gIAlu_s_u24lambda_u2402);
                                tribeeEditPublishServiceImpl$publish$12.L$3 = SpillingKt.nullOutSpilledVariable(req);
                                tribeeEditPublishServiceImpl$publish$12.L$4 = str;
                                tribeeEditPublishServiceImpl$publish$12.I$0 = i2;
                                tribeeEditPublishServiceImpl$publish$12.J$0 = id2;
                                tribeeEditPublishServiceImpl$publish$12.label = 3;
                                suspendGetString = followingRes.suspendGetString(following_global_string_145, tribeeEditPublishServiceImpl$publish$12);
                            } catch (Throwable th4) {
                                th = th4;
                                content3 = content2;
                                Result.Companion companion222 = Result.Companion;
                                m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                content2 = content3;
                                if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                                }
                                it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                                if (it != null) {
                                }
                                return m2636constructorimpl;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            Result.Companion companion2222 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            content2 = content3;
                            if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            }
                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (it != null) {
                            }
                            return m2636constructorimpl;
                        }
                        if (suspendGetString != obj) {
                            return obj;
                        }
                        m2636constructorimpl = Result.m2636constructorimpl(new PublishResult(str, (String) suspendGetString));
                        if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            tribeeEditPublishServiceImpl = this;
                        } else {
                            PublishResult publishResult = (PublishResult) m2636constructorimpl;
                            tribeeEditPublishServiceImpl = this;
                            KLog_androidKt.getKLog().i("TribeeEditPublishServiceImpl", "Publish succeed, " + tribeeEditPublishServiceImpl.contentId + " title " + content2.getTitle() + " to " + content2.getTribeeInfo());
                        }
                        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (it != null) {
                            JobKt.ensureActive(tribeeEditPublishServiceImpl$publish$12.getContext());
                            KLog_androidKt.getKLog().e("TribeeEditPublishServiceImpl", "Publish failed, " + tribeeEditPublishServiceImpl.contentId + " title " + content2.getTitle() + " to " + content2.getTribeeInfo(), it);
                        }
                        return m2636constructorimpl;
                    case 1:
                        long id4 = tribeeEditPublishServiceImpl$publish$12.J$0;
                        i = tribeeEditPublishServiceImpl$publish$12.I$0;
                        kCreateScene = (KCreateScene.CREATE_SCENE_CREATE_TRIBEE) tribeeEditPublishServiceImpl$publish$12.L$3;
                        TribeeEditPublishServiceImpl $this$publish_gIAlu_s_u24lambda_u2403 = (TribeeEditPublishServiceImpl) tribeeEditPublishServiceImpl$publish$12.L$2;
                        KFeedMoss moss5 = (KFeedMoss) tribeeEditPublishServiceImpl$publish$12.L$1;
                        content3 = (TribeePublishContent) tribeeEditPublishServiceImpl$publish$12.L$0;
                        ResultKt.throwOnFailure($result);
                        convert = $result;
                        moss = moss5;
                        obj = coroutine_suspended;
                        id = id4;
                        $this$publish_gIAlu_s_u24lambda_u2402 = $this$publish_gIAlu_s_u24lambda_u2403;
                        KFeedMoss moss42 = moss;
                        req = new KEditOpusReq(id, new KUserCreateMeta(new KMetaDataCtrl((String) null, (String) null, (String) null, (String) null, (String) null, $this$publish_gIAlu_s_u24lambda_u2402.fromSpmid, $this$publish_gIAlu_s_u24lambda_u2402.from, (String) null, 0, 0, (String) null, 0, (String) null, 8095, (DefaultConstructorMarker) null), (KLbsLoc) null, 0, 6, (DefaultConstructorMarker) null), (KOpus) convert, kCreateScene, new KCreateOption(0, 0, 0, 0, 0, (KVideoShareInfo) null, (KCreateActivity) null, 0, 0L, 0, 0, 0L, 0L, 0L, 0, (KLiveWaterMark) null, false, content3.getAigc(), 131071, (DefaultConstructorMarker) null), (KCreateTopic) null, (KCreateBaseDraft) null, (String) null, content3.getTribeeArg(), 0L, 736, (DefaultConstructorMarker) null);
                        tribeeEditPublishServiceImpl$publish$12.L$0 = content3;
                        tribeeEditPublishServiceImpl$publish$12.L$1 = SpillingKt.nullOutSpilledVariable(moss42);
                        tribeeEditPublishServiceImpl$publish$12.L$2 = $this$publish_gIAlu_s_u24lambda_u2402;
                        tribeeEditPublishServiceImpl$publish$12.L$3 = SpillingKt.nullOutSpilledVariable(req);
                        tribeeEditPublishServiceImpl$publish$12.I$0 = i;
                        tribeeEditPublishServiceImpl$publish$12.J$0 = id;
                        tribeeEditPublishServiceImpl$publish$12.label = 2;
                        moss2 = moss42;
                        if (moss2.editOpus(req, tribeeEditPublishServiceImpl$publish$12) != obj) {
                        }
                        break;
                    case 2:
                        long id5 = tribeeEditPublishServiceImpl$publish$12.J$0;
                        int i3 = tribeeEditPublishServiceImpl$publish$12.I$0;
                        KEditOpusReq req2 = (KEditOpusReq) tribeeEditPublishServiceImpl$publish$12.L$3;
                        TribeeEditPublishServiceImpl $this$publish_gIAlu_s_u24lambda_u2404 = (TribeeEditPublishServiceImpl) tribeeEditPublishServiceImpl$publish$12.L$2;
                        moss2 = (KFeedMoss) tribeeEditPublishServiceImpl$publish$12.L$1;
                        content3 = (TribeePublishContent) tribeeEditPublishServiceImpl$publish$12.L$0;
                        ResultKt.throwOnFailure($result);
                        req = req2;
                        obj = coroutine_suspended;
                        i2 = i3;
                        $this$publish_gIAlu_s_u24lambda_u2402 = $this$publish_gIAlu_s_u24lambda_u2404;
                        id2 = id5;
                        str = $this$publish_gIAlu_s_u24lambda_u2402.contentId;
                        FollowingRes followingRes2 = FollowingRes.INSTANCE;
                        StringResource following_global_string_1452 = String0_commonMainKt.getFollowing_global_string_145(Res.string.INSTANCE);
                        tribeeEditPublishServiceImpl$publish$12.L$0 = content3;
                        content2 = content3;
                        tribeeEditPublishServiceImpl$publish$12.L$1 = SpillingKt.nullOutSpilledVariable(moss2);
                        tribeeEditPublishServiceImpl$publish$12.L$2 = SpillingKt.nullOutSpilledVariable($this$publish_gIAlu_s_u24lambda_u2402);
                        tribeeEditPublishServiceImpl$publish$12.L$3 = SpillingKt.nullOutSpilledVariable(req);
                        tribeeEditPublishServiceImpl$publish$12.L$4 = str;
                        tribeeEditPublishServiceImpl$publish$12.I$0 = i2;
                        tribeeEditPublishServiceImpl$publish$12.J$0 = id2;
                        tribeeEditPublishServiceImpl$publish$12.label = 3;
                        suspendGetString = followingRes2.suspendGetString(following_global_string_1452, tribeeEditPublishServiceImpl$publish$12);
                        if (suspendGetString != obj) {
                        }
                        break;
                    case 3:
                        long j = tribeeEditPublishServiceImpl$publish$12.J$0;
                        int i4 = tribeeEditPublishServiceImpl$publish$12.I$0;
                        str = (String) tribeeEditPublishServiceImpl$publish$12.L$4;
                        KEditOpusReq kEditOpusReq = (KEditOpusReq) tribeeEditPublishServiceImpl$publish$12.L$3;
                        TribeeEditPublishServiceImpl tribeeEditPublishServiceImpl2 = (TribeeEditPublishServiceImpl) tribeeEditPublishServiceImpl$publish$12.L$2;
                        KFeedMoss kFeedMoss = (KFeedMoss) tribeeEditPublishServiceImpl$publish$12.L$1;
                        TribeePublishContent content4 = (TribeePublishContent) tribeeEditPublishServiceImpl$publish$12.L$0;
                        ResultKt.throwOnFailure($result);
                        content2 = content4;
                        suspendGetString = $result;
                        m2636constructorimpl = Result.m2636constructorimpl(new PublishResult(str, (String) suspendGetString));
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
        tribeeEditPublishServiceImpl$publish$1 = new TribeeEditPublishServiceImpl$publish$1(this, continuation);
        tribeeEditPublishServiceImpl$publish$12 = tribeeEditPublishServiceImpl$publish$1;
        Object $result2 = tribeeEditPublishServiceImpl$publish$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeEditPublishServiceImpl$publish$12.label) {
        }
    }
}