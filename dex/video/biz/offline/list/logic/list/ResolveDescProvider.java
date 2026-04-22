package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.infra.utils.ResourceValidateCode;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.net.IpTaskKt;
import video.biz.offline.list.logic.net.Zone;
import video.biz.offline.list.logic.statemachine.DiagnosticState;
import video.biz.offline.list.logic.tree.VideoFile;
import video.biz.offline.list.logic.utils.OfflineLogicKt;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lvideo/biz/offline/list/logic/list/ResolveDescProvider;", "Lvideo/biz/offline/list/logic/list/IResolveProvider;", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getVideoEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "getDownloadedButInvalidDesc", "validateCode", "Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadingButInvalidDesc", "getIpInfo", "zone", "Lvideo/biz/offline/list/logic/net/Zone;", "getResolveTestInfo", "getResolvedVideoEntityInfo", "getDownloadingCanRetryDesc", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDamageCannotRetryDesc", "getCompleteDesc", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolveDescProvider implements IResolveProvider {
    public static final int $stable = OfflineVideoEntity.$stable;
    private final OfflineVideoEntity videoEntity;

    /* compiled from: OfflineResolveDataProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.BizType.values().length];
            try {
                iArr[OfflineVideoEntity.BizType.UGC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.BizType.OGV.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ResolveDescProvider(OfflineVideoEntity videoEntity) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        this.videoEntity = videoEntity;
    }

    public final OfflineVideoEntity getVideoEntity() {
        return this.videoEntity;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[ORIG_RETURN, RETURN] */
    @Override // video.biz.offline.list.logic.list.IResolveProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object title(Continuation<? super String> continuation) {
        ResolveDescProvider$title$1 resolveDescProvider$title$1;
        Object from;
        if (continuation instanceof ResolveDescProvider$title$1) {
            resolveDescProvider$title$1 = (ResolveDescProvider$title$1) continuation;
            if ((resolveDescProvider$title$1.label & Integer.MIN_VALUE) != 0) {
                resolveDescProvider$title$1.label -= Integer.MIN_VALUE;
                Object $result = resolveDescProvider$title$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveDescProvider$title$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        OfflineVideoEntity offlineVideoEntity = this.videoEntity;
                        resolveDescProvider$title$1.label = 1;
                        from = companion.from(offlineVideoEntity, resolveDescProvider$title$1);
                        if (from == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        from = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DiagnosticState state = (DiagnosticState) from;
                return !(state instanceof DiagnosticState.Completed) ? "视频信息:" : "诊断信息:";
            }
        }
        resolveDescProvider$title$1 = new ResolveDescProvider$title$1(this, continuation);
        Object $result2 = resolveDescProvider$title$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveDescProvider$title$1.label) {
        }
        DiagnosticState state2 = (DiagnosticState) from;
        if (!(state2 instanceof DiagnosticState.Completed)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    @Override // video.biz.offline.list.logic.list.IResolveProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object content(Continuation<? super String> continuation) {
        ResolveDescProvider$content$1 resolveDescProvider$content$1;
        Object from;
        DiagnosticState state;
        if (continuation instanceof ResolveDescProvider$content$1) {
            resolveDescProvider$content$1 = (ResolveDescProvider$content$1) continuation;
            if ((resolveDescProvider$content$1.label & Integer.MIN_VALUE) != 0) {
                resolveDescProvider$content$1.label -= Integer.MIN_VALUE;
                Object $result = resolveDescProvider$content$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveDescProvider$content$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        OfflineVideoEntity offlineVideoEntity = this.videoEntity;
                        resolveDescProvider$content$1.label = 1;
                        from = companion.from(offlineVideoEntity, resolveDescProvider$content$1);
                        if (from == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        from = $result;
                        break;
                    case 2:
                        DiagnosticState diagnosticState = (DiagnosticState) resolveDescProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 3:
                        DiagnosticState diagnosticState2 = (DiagnosticState) resolveDescProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 4:
                        DiagnosticState diagnosticState3 = (DiagnosticState) resolveDescProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 5:
                        DiagnosticState diagnosticState4 = (DiagnosticState) resolveDescProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                state = (DiagnosticState) from;
                if (state instanceof DiagnosticState.Completed) {
                    if (!(state instanceof DiagnosticState.Damaged)) {
                        if (state instanceof DiagnosticState.Incomplete) {
                            OfflineVideoEntity entity = ((DiagnosticState.Incomplete) state).getEntity();
                            resolveDescProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            resolveDescProvider$content$1.label = 5;
                            Object downloadingCanRetryDesc = getDownloadingCanRetryDesc(entity, resolveDescProvider$content$1);
                            return downloadingCanRetryDesc == coroutine_suspended ? coroutine_suspended : downloadingCanRetryDesc;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    DiagnosticState.Damaged.Reason reason = ((DiagnosticState.Damaged) state).getReason();
                    if (reason instanceof DiagnosticState.Damaged.Reason.DownloadedButInvalid) {
                        OfflineVideoEntity entity2 = ((DiagnosticState.Damaged) state).getEntity();
                        ResourceValidateCode code = ((DiagnosticState.Damaged.Reason.DownloadedButInvalid) ((DiagnosticState.Damaged) state).getReason()).getCode();
                        resolveDescProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                        resolveDescProvider$content$1.label = 2;
                        Object downloadedButInvalidDesc = getDownloadedButInvalidDesc(entity2, code, resolveDescProvider$content$1);
                        return downloadedButInvalidDesc == coroutine_suspended ? coroutine_suspended : downloadedButInvalidDesc;
                    } else if (reason instanceof DiagnosticState.Damaged.Reason.DownloadingButInvalid) {
                        OfflineVideoEntity entity3 = ((DiagnosticState.Damaged) state).getEntity();
                        ResourceValidateCode code2 = ((DiagnosticState.Damaged.Reason.DownloadingButInvalid) ((DiagnosticState.Damaged) state).getReason()).getCode();
                        resolveDescProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                        resolveDescProvider$content$1.label = 3;
                        Object downloadingButInvalidDesc = getDownloadingButInvalidDesc(entity3, code2, resolveDescProvider$content$1);
                        return downloadingButInvalidDesc == coroutine_suspended ? coroutine_suspended : downloadingButInvalidDesc;
                    } else if (reason instanceof DiagnosticState.Damaged.Reason.WithUnretryableDownloadingError) {
                        OfflineVideoEntity entity4 = ((DiagnosticState.Damaged) state).getEntity();
                        resolveDescProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                        resolveDescProvider$content$1.label = 4;
                        Object damageCannotRetryDesc = getDamageCannotRetryDesc(entity4, resolveDescProvider$content$1);
                        return damageCannotRetryDesc == coroutine_suspended ? coroutine_suspended : damageCannotRetryDesc;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return getCompleteDesc(((DiagnosticState.Completed) state).getEntity());
            }
        }
        resolveDescProvider$content$1 = new ResolveDescProvider$content$1(this, continuation);
        Object $result2 = resolveDescProvider$content$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveDescProvider$content$1.label) {
        }
        state = (DiagnosticState) from;
        if (state instanceof DiagnosticState.Completed) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDownloadedButInvalidDesc(OfflineVideoEntity videoEntity, ResourceValidateCode validateCode, Continuation<? super String> continuation) {
        ResolveDescProvider$getDownloadedButInvalidDesc$1 resolveDescProvider$getDownloadedButInvalidDesc$1;
        StringBuilder $this$getDownloadedButInvalidDesc_u24lambda_u240;
        StringBuilder sb;
        int i;
        Object obj;
        ResolveDescProvider resolveDescProvider;
        StringBuilder sb2;
        Object resolveTestInfo;
        StringBuilder sb3;
        if (continuation instanceof ResolveDescProvider$getDownloadedButInvalidDesc$1) {
            resolveDescProvider$getDownloadedButInvalidDesc$1 = (ResolveDescProvider$getDownloadedButInvalidDesc$1) continuation;
            if ((resolveDescProvider$getDownloadedButInvalidDesc$1.label & Integer.MIN_VALUE) != 0) {
                resolveDescProvider$getDownloadedButInvalidDesc$1.label -= Integer.MIN_VALUE;
                Object $result = resolveDescProvider$getDownloadedButInvalidDesc$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveDescProvider$getDownloadedButInvalidDesc$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        StringBuilder sb4 = new StringBuilder();
                        $this$getDownloadedButInvalidDesc_u24lambda_u240 = sb4;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$0 = videoEntity;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$1 = validateCode;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$2 = sb4;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$3 = $this$getDownloadedButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$4 = this;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$5 = $this$getDownloadedButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.I$0 = 0;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.label = 1;
                        Object startIp = IpTaskKt.startIp(resolveDescProvider$getDownloadedButInvalidDesc$1);
                        if (startIp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb = sb4;
                        i = 0;
                        obj = startIp;
                        resolveDescProvider = this;
                        sb2 = $this$getDownloadedButInvalidDesc_u24lambda_u240;
                        sb2.append("1." + resolveDescProvider.getIpInfo((Zone) obj));
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$1 = SpillingKt.nullOutSpilledVariable(validateCode);
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$2 = sb;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$3 = SpillingKt.nullOutSpilledVariable($this$getDownloadedButInvalidDesc_u24lambda_u240);
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$4 = $this$getDownloadedButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$5 = null;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.I$0 = i;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, validateCode, resolveDescProvider$getDownloadedButInvalidDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb3 = $this$getDownloadedButInvalidDesc_u24lambda_u240;
                        sb3.append("2." + resolveTestInfo);
                        return sb.toString();
                    case 1:
                        i = resolveDescProvider$getDownloadedButInvalidDesc$1.I$0;
                        ResolveDescProvider resolveDescProvider2 = (ResolveDescProvider) resolveDescProvider$getDownloadedButInvalidDesc$1.L$4;
                        sb = (StringBuilder) resolveDescProvider$getDownloadedButInvalidDesc$1.L$2;
                        validateCode = (ResourceValidateCode) resolveDescProvider$getDownloadedButInvalidDesc$1.L$1;
                        videoEntity = (OfflineVideoEntity) resolveDescProvider$getDownloadedButInvalidDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        sb2 = (StringBuilder) resolveDescProvider$getDownloadedButInvalidDesc$1.L$5;
                        $this$getDownloadedButInvalidDesc_u24lambda_u240 = (StringBuilder) resolveDescProvider$getDownloadedButInvalidDesc$1.L$3;
                        resolveDescProvider = resolveDescProvider2;
                        sb2.append("1." + resolveDescProvider.getIpInfo((Zone) obj));
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$1 = SpillingKt.nullOutSpilledVariable(validateCode);
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$2 = sb;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$3 = SpillingKt.nullOutSpilledVariable($this$getDownloadedButInvalidDesc_u24lambda_u240);
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$4 = $this$getDownloadedButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.L$5 = null;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.I$0 = i;
                        resolveDescProvider$getDownloadedButInvalidDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, validateCode, resolveDescProvider$getDownloadedButInvalidDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i2 = resolveDescProvider$getDownloadedButInvalidDesc$1.I$0;
                        sb3 = (StringBuilder) resolveDescProvider$getDownloadedButInvalidDesc$1.L$4;
                        StringBuilder sb5 = (StringBuilder) resolveDescProvider$getDownloadedButInvalidDesc$1.L$3;
                        ResourceValidateCode resourceValidateCode = (ResourceValidateCode) resolveDescProvider$getDownloadedButInvalidDesc$1.L$1;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) resolveDescProvider$getDownloadedButInvalidDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        sb = (StringBuilder) resolveDescProvider$getDownloadedButInvalidDesc$1.L$2;
                        resolveTestInfo = $result;
                        sb3.append("2." + resolveTestInfo);
                        return sb.toString();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        resolveDescProvider$getDownloadedButInvalidDesc$1 = new ResolveDescProvider$getDownloadedButInvalidDesc$1(this, continuation);
        Object $result2 = resolveDescProvider$getDownloadedButInvalidDesc$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveDescProvider$getDownloadedButInvalidDesc$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDownloadingButInvalidDesc(OfflineVideoEntity videoEntity, ResourceValidateCode validateCode, Continuation<? super String> continuation) {
        ResolveDescProvider$getDownloadingButInvalidDesc$1 resolveDescProvider$getDownloadingButInvalidDesc$1;
        StringBuilder $this$getDownloadingButInvalidDesc_u24lambda_u240;
        StringBuilder sb;
        int i;
        Object obj;
        ResolveDescProvider resolveDescProvider;
        StringBuilder sb2;
        Object resolveTestInfo;
        StringBuilder sb3;
        if (continuation instanceof ResolveDescProvider$getDownloadingButInvalidDesc$1) {
            resolveDescProvider$getDownloadingButInvalidDesc$1 = (ResolveDescProvider$getDownloadingButInvalidDesc$1) continuation;
            if ((resolveDescProvider$getDownloadingButInvalidDesc$1.label & Integer.MIN_VALUE) != 0) {
                resolveDescProvider$getDownloadingButInvalidDesc$1.label -= Integer.MIN_VALUE;
                Object $result = resolveDescProvider$getDownloadingButInvalidDesc$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveDescProvider$getDownloadingButInvalidDesc$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        StringBuilder sb4 = new StringBuilder();
                        $this$getDownloadingButInvalidDesc_u24lambda_u240 = sb4;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$0 = videoEntity;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$1 = validateCode;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$2 = sb4;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$3 = $this$getDownloadingButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$4 = this;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$5 = $this$getDownloadingButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.I$0 = 0;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.label = 1;
                        Object startIp = IpTaskKt.startIp(resolveDescProvider$getDownloadingButInvalidDesc$1);
                        if (startIp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb = sb4;
                        i = 0;
                        obj = startIp;
                        resolveDescProvider = this;
                        sb2 = $this$getDownloadingButInvalidDesc_u24lambda_u240;
                        sb2.append("1." + resolveDescProvider.getIpInfo((Zone) obj));
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$1 = SpillingKt.nullOutSpilledVariable(validateCode);
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$2 = sb;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$3 = SpillingKt.nullOutSpilledVariable($this$getDownloadingButInvalidDesc_u24lambda_u240);
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$4 = $this$getDownloadingButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$5 = null;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.I$0 = i;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, validateCode, resolveDescProvider$getDownloadingButInvalidDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb3 = $this$getDownloadingButInvalidDesc_u24lambda_u240;
                        sb3.append("2." + resolveTestInfo);
                        return sb.toString();
                    case 1:
                        i = resolveDescProvider$getDownloadingButInvalidDesc$1.I$0;
                        ResolveDescProvider resolveDescProvider2 = (ResolveDescProvider) resolveDescProvider$getDownloadingButInvalidDesc$1.L$4;
                        sb = (StringBuilder) resolveDescProvider$getDownloadingButInvalidDesc$1.L$2;
                        validateCode = (ResourceValidateCode) resolveDescProvider$getDownloadingButInvalidDesc$1.L$1;
                        videoEntity = (OfflineVideoEntity) resolveDescProvider$getDownloadingButInvalidDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        sb2 = (StringBuilder) resolveDescProvider$getDownloadingButInvalidDesc$1.L$5;
                        $this$getDownloadingButInvalidDesc_u24lambda_u240 = (StringBuilder) resolveDescProvider$getDownloadingButInvalidDesc$1.L$3;
                        resolveDescProvider = resolveDescProvider2;
                        sb2.append("1." + resolveDescProvider.getIpInfo((Zone) obj));
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$1 = SpillingKt.nullOutSpilledVariable(validateCode);
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$2 = sb;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$3 = SpillingKt.nullOutSpilledVariable($this$getDownloadingButInvalidDesc_u24lambda_u240);
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$4 = $this$getDownloadingButInvalidDesc_u24lambda_u240;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.L$5 = null;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.I$0 = i;
                        resolveDescProvider$getDownloadingButInvalidDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, validateCode, resolveDescProvider$getDownloadingButInvalidDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i2 = resolveDescProvider$getDownloadingButInvalidDesc$1.I$0;
                        sb3 = (StringBuilder) resolveDescProvider$getDownloadingButInvalidDesc$1.L$4;
                        StringBuilder sb5 = (StringBuilder) resolveDescProvider$getDownloadingButInvalidDesc$1.L$3;
                        ResourceValidateCode resourceValidateCode = (ResourceValidateCode) resolveDescProvider$getDownloadingButInvalidDesc$1.L$1;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) resolveDescProvider$getDownloadingButInvalidDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        sb = (StringBuilder) resolveDescProvider$getDownloadingButInvalidDesc$1.L$2;
                        resolveTestInfo = $result;
                        sb3.append("2." + resolveTestInfo);
                        return sb.toString();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        resolveDescProvider$getDownloadingButInvalidDesc$1 = new ResolveDescProvider$getDownloadingButInvalidDesc$1(this, continuation);
        Object $result2 = resolveDescProvider$getDownloadingButInvalidDesc$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveDescProvider$getDownloadingButInvalidDesc$1.label) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0031, code lost:
        if (r3 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getIpInfo(Zone zone) {
        String str;
        StringBuilder $this$getIpInfo_u24lambda_u240 = new StringBuilder();
        if (zone != null) {
            str = "本机 IP:" + zone.getIp() + " " + IpTaskKt.getGeoString(zone);
        }
        str = "获取本机 IP 失败了";
        $this$getIpInfo_u24lambda_u240.append(str);
        $this$getIpInfo_u24lambda_u240.append(VideoFile.TREE_END);
        return $this$getIpInfo_u24lambda_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getResolveTestInfo(OfflineVideoEntity videoEntity, ResourceValidateCode validateCode, Continuation<? super String> continuation) {
        ResolveDescProvider$getResolveTestInfo$1 resolveDescProvider$getResolveTestInfo$1;
        StringBuilder sb;
        StringBuilder $this$getResolveTestInfo_u24lambda_u240;
        Object isNotInDB;
        if (continuation instanceof ResolveDescProvider$getResolveTestInfo$1) {
            resolveDescProvider$getResolveTestInfo$1 = (ResolveDescProvider$getResolveTestInfo$1) continuation;
            if ((resolveDescProvider$getResolveTestInfo$1.label & Integer.MIN_VALUE) != 0) {
                resolveDescProvider$getResolveTestInfo$1.label -= Integer.MIN_VALUE;
                Object $result = resolveDescProvider$getResolveTestInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveDescProvider$getResolveTestInfo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        sb = new StringBuilder();
                        $this$getResolveTestInfo_u24lambda_u240 = sb;
                        $this$getResolveTestInfo_u24lambda_u240.append("解析测试:\n");
                        resolveDescProvider$getResolveTestInfo$1.L$0 = videoEntity;
                        resolveDescProvider$getResolveTestInfo$1.L$1 = validateCode;
                        resolveDescProvider$getResolveTestInfo$1.L$2 = sb;
                        resolveDescProvider$getResolveTestInfo$1.L$3 = $this$getResolveTestInfo_u24lambda_u240;
                        resolveDescProvider$getResolveTestInfo$1.I$0 = 0;
                        resolveDescProvider$getResolveTestInfo$1.label = 1;
                        isNotInDB = OfflineResolveDataProviderKt.isNotInDB(videoEntity, resolveDescProvider$getResolveTestInfo$1);
                        if (isNotInDB != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = resolveDescProvider$getResolveTestInfo$1.I$0;
                        $this$getResolveTestInfo_u24lambda_u240 = (StringBuilder) resolveDescProvider$getResolveTestInfo$1.L$3;
                        sb = (StringBuilder) resolveDescProvider$getResolveTestInfo$1.L$2;
                        validateCode = (ResourceValidateCode) resolveDescProvider$getResolveTestInfo$1.L$1;
                        videoEntity = (OfflineVideoEntity) resolveDescProvider$getResolveTestInfo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        isNotInDB = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) isNotInDB).booleanValue()) {
                    $this$getResolveTestInfo_u24lambda_u240.append("\t下载视频信息不完整，稿件信息丢失");
                } else if (validateCode == ResourceValidateCode.ERROR_INVALID_ENTRY) {
                    $this$getResolveTestInfo_u24lambda_u240.append("\t下载视频信息不完整");
                } else {
                    $this$getResolveTestInfo_u24lambda_u240.append(getResolvedVideoEntityInfo(videoEntity));
                }
                return sb.toString();
            }
        }
        resolveDescProvider$getResolveTestInfo$1 = new ResolveDescProvider$getResolveTestInfo$1(this, continuation);
        Object $result2 = resolveDescProvider$getResolveTestInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveDescProvider$getResolveTestInfo$1.label) {
        }
        if (!((Boolean) isNotInDB).booleanValue()) {
        }
        return sb.toString();
    }

    private final String getResolvedVideoEntityInfo(OfflineVideoEntity videoEntity) {
        StringBuilder $this$getResolvedVideoEntityInfo_u24lambda_u240 = new StringBuilder();
        $this$getResolvedVideoEntityInfo_u24lambda_u240.append("\t视频id:" + videoEntity.getAid() + VideoFile.TREE_END);
        $this$getResolvedVideoEntityInfo_u24lambda_u240.append("\tfrom=" + videoEntity.getFrom() + VideoFile.TREE_END);
        $this$getResolvedVideoEntityInfo_u24lambda_u240.append("\tcid=" + videoEntity.getCid() + VideoFile.TREE_END);
        $this$getResolvedVideoEntityInfo_u24lambda_u240.append("\tformat=" + videoEntity.getMediaType().name() + VideoFile.TREE_END);
        return $this$getResolvedVideoEntityInfo_u24lambda_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDownloadingCanRetryDesc(OfflineVideoEntity videoEntity, Continuation<? super String> continuation) {
        ResolveDescProvider$getDownloadingCanRetryDesc$1 resolveDescProvider$getDownloadingCanRetryDesc$1;
        Object obj;
        StringBuilder sb;
        int i;
        ResolveDescProvider resolveDescProvider;
        StringBuilder $this$getDownloadingCanRetryDesc_u24lambda_u240;
        StringBuilder $this$getDownloadingCanRetryDesc_u24lambda_u2402;
        Object resolveTestInfo;
        StringBuilder sb2;
        if (continuation instanceof ResolveDescProvider$getDownloadingCanRetryDesc$1) {
            resolveDescProvider$getDownloadingCanRetryDesc$1 = (ResolveDescProvider$getDownloadingCanRetryDesc$1) continuation;
            if ((resolveDescProvider$getDownloadingCanRetryDesc$1.label & Integer.MIN_VALUE) != 0) {
                resolveDescProvider$getDownloadingCanRetryDesc$1.label -= Integer.MIN_VALUE;
                Object $result = resolveDescProvider$getDownloadingCanRetryDesc$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveDescProvider$getDownloadingCanRetryDesc$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        StringBuilder $this$getDownloadingCanRetryDesc_u24lambda_u2403 = new StringBuilder();
                        StringBuilder append = $this$getDownloadingCanRetryDesc_u24lambda_u2403.append("1.");
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$0 = videoEntity;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$1 = $this$getDownloadingCanRetryDesc_u24lambda_u2403;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$2 = $this$getDownloadingCanRetryDesc_u24lambda_u2403;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$3 = this;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$4 = append;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.I$0 = 0;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.label = 1;
                        Object startIp = IpTaskKt.startIp(resolveDescProvider$getDownloadingCanRetryDesc$1);
                        if (startIp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = startIp;
                        sb = $this$getDownloadingCanRetryDesc_u24lambda_u2403;
                        i = 0;
                        resolveDescProvider = this;
                        $this$getDownloadingCanRetryDesc_u24lambda_u240 = $this$getDownloadingCanRetryDesc_u24lambda_u2403;
                        $this$getDownloadingCanRetryDesc_u24lambda_u2402 = append;
                        $this$getDownloadingCanRetryDesc_u24lambda_u2402.append(resolveDescProvider.getIpInfo((Zone) obj));
                        StringBuilder append2 = $this$getDownloadingCanRetryDesc_u24lambda_u240.append("2.");
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$1 = sb;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$2 = SpillingKt.nullOutSpilledVariable($this$getDownloadingCanRetryDesc_u24lambda_u240);
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$3 = append2;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$4 = null;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.I$0 = i;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, null, resolveDescProvider$getDownloadingCanRetryDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb2 = append2;
                        sb2.append((String) resolveTestInfo);
                        return sb.toString();
                    case 1:
                        i = resolveDescProvider$getDownloadingCanRetryDesc$1.I$0;
                        $this$getDownloadingCanRetryDesc_u24lambda_u2402 = (StringBuilder) resolveDescProvider$getDownloadingCanRetryDesc$1.L$4;
                        resolveDescProvider = (ResolveDescProvider) resolveDescProvider$getDownloadingCanRetryDesc$1.L$3;
                        $this$getDownloadingCanRetryDesc_u24lambda_u240 = (StringBuilder) resolveDescProvider$getDownloadingCanRetryDesc$1.L$2;
                        sb = (StringBuilder) resolveDescProvider$getDownloadingCanRetryDesc$1.L$1;
                        videoEntity = (OfflineVideoEntity) resolveDescProvider$getDownloadingCanRetryDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        $this$getDownloadingCanRetryDesc_u24lambda_u2402.append(resolveDescProvider.getIpInfo((Zone) obj));
                        StringBuilder append22 = $this$getDownloadingCanRetryDesc_u24lambda_u240.append("2.");
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$1 = sb;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$2 = SpillingKt.nullOutSpilledVariable($this$getDownloadingCanRetryDesc_u24lambda_u240);
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$3 = append22;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.L$4 = null;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.I$0 = i;
                        resolveDescProvider$getDownloadingCanRetryDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, null, resolveDescProvider$getDownloadingCanRetryDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i2 = resolveDescProvider$getDownloadingCanRetryDesc$1.I$0;
                        sb2 = (StringBuilder) resolveDescProvider$getDownloadingCanRetryDesc$1.L$3;
                        StringBuilder sb3 = (StringBuilder) resolveDescProvider$getDownloadingCanRetryDesc$1.L$2;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) resolveDescProvider$getDownloadingCanRetryDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        sb = (StringBuilder) resolveDescProvider$getDownloadingCanRetryDesc$1.L$1;
                        resolveTestInfo = $result;
                        sb2.append((String) resolveTestInfo);
                        return sb.toString();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        resolveDescProvider$getDownloadingCanRetryDesc$1 = new ResolveDescProvider$getDownloadingCanRetryDesc$1(this, continuation);
        Object $result2 = resolveDescProvider$getDownloadingCanRetryDesc$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveDescProvider$getDownloadingCanRetryDesc$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDamageCannotRetryDesc(OfflineVideoEntity videoEntity, Continuation<? super String> continuation) {
        ResolveDescProvider$getDamageCannotRetryDesc$1 resolveDescProvider$getDamageCannotRetryDesc$1;
        StringBuilder $this$getDamageCannotRetryDesc_u24lambda_u240;
        StringBuilder sb;
        int i;
        Object obj;
        ResolveDescProvider resolveDescProvider;
        StringBuilder sb2;
        Object resolveTestInfo;
        StringBuilder sb3;
        if (continuation instanceof ResolveDescProvider$getDamageCannotRetryDesc$1) {
            resolveDescProvider$getDamageCannotRetryDesc$1 = (ResolveDescProvider$getDamageCannotRetryDesc$1) continuation;
            if ((resolveDescProvider$getDamageCannotRetryDesc$1.label & Integer.MIN_VALUE) != 0) {
                resolveDescProvider$getDamageCannotRetryDesc$1.label -= Integer.MIN_VALUE;
                Object $result = resolveDescProvider$getDamageCannotRetryDesc$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveDescProvider$getDamageCannotRetryDesc$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        StringBuilder sb4 = new StringBuilder();
                        $this$getDamageCannotRetryDesc_u24lambda_u240 = sb4;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$0 = videoEntity;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$1 = sb4;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$2 = $this$getDamageCannotRetryDesc_u24lambda_u240;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$3 = this;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$4 = $this$getDamageCannotRetryDesc_u24lambda_u240;
                        resolveDescProvider$getDamageCannotRetryDesc$1.I$0 = 0;
                        resolveDescProvider$getDamageCannotRetryDesc$1.label = 1;
                        Object startIp = IpTaskKt.startIp(resolveDescProvider$getDamageCannotRetryDesc$1);
                        if (startIp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb = sb4;
                        i = 0;
                        obj = startIp;
                        resolveDescProvider = this;
                        sb2 = $this$getDamageCannotRetryDesc_u24lambda_u240;
                        sb2.append("1." + resolveDescProvider.getIpInfo((Zone) obj));
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$1 = sb;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$2 = SpillingKt.nullOutSpilledVariable($this$getDamageCannotRetryDesc_u24lambda_u240);
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$3 = $this$getDamageCannotRetryDesc_u24lambda_u240;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$4 = null;
                        resolveDescProvider$getDamageCannotRetryDesc$1.I$0 = i;
                        resolveDescProvider$getDamageCannotRetryDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, null, resolveDescProvider$getDamageCannotRetryDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb3 = $this$getDamageCannotRetryDesc_u24lambda_u240;
                        sb3.append("2." + resolveTestInfo);
                        return sb.toString();
                    case 1:
                        i = resolveDescProvider$getDamageCannotRetryDesc$1.I$0;
                        ResolveDescProvider resolveDescProvider2 = (ResolveDescProvider) resolveDescProvider$getDamageCannotRetryDesc$1.L$3;
                        sb = (StringBuilder) resolveDescProvider$getDamageCannotRetryDesc$1.L$1;
                        videoEntity = (OfflineVideoEntity) resolveDescProvider$getDamageCannotRetryDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        sb2 = (StringBuilder) resolveDescProvider$getDamageCannotRetryDesc$1.L$4;
                        $this$getDamageCannotRetryDesc_u24lambda_u240 = (StringBuilder) resolveDescProvider$getDamageCannotRetryDesc$1.L$2;
                        resolveDescProvider = resolveDescProvider2;
                        sb2.append("1." + resolveDescProvider.getIpInfo((Zone) obj));
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$1 = sb;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$2 = SpillingKt.nullOutSpilledVariable($this$getDamageCannotRetryDesc_u24lambda_u240);
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$3 = $this$getDamageCannotRetryDesc_u24lambda_u240;
                        resolveDescProvider$getDamageCannotRetryDesc$1.L$4 = null;
                        resolveDescProvider$getDamageCannotRetryDesc$1.I$0 = i;
                        resolveDescProvider$getDamageCannotRetryDesc$1.label = 2;
                        resolveTestInfo = getResolveTestInfo(videoEntity, null, resolveDescProvider$getDamageCannotRetryDesc$1);
                        if (resolveTestInfo != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i2 = resolveDescProvider$getDamageCannotRetryDesc$1.I$0;
                        sb3 = (StringBuilder) resolveDescProvider$getDamageCannotRetryDesc$1.L$3;
                        StringBuilder sb5 = (StringBuilder) resolveDescProvider$getDamageCannotRetryDesc$1.L$2;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) resolveDescProvider$getDamageCannotRetryDesc$1.L$0;
                        ResultKt.throwOnFailure($result);
                        sb = (StringBuilder) resolveDescProvider$getDamageCannotRetryDesc$1.L$1;
                        resolveTestInfo = $result;
                        sb3.append("2." + resolveTestInfo);
                        return sb.toString();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        resolveDescProvider$getDamageCannotRetryDesc$1 = new ResolveDescProvider$getDamageCannotRetryDesc$1(this, continuation);
        Object $result2 = resolveDescProvider$getDamageCannotRetryDesc$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveDescProvider$getDamageCannotRetryDesc$1.label) {
        }
    }

    private final String getCompleteDesc(OfflineVideoEntity videoEntity) {
        StringBuilder completeInfoSb = new StringBuilder().append("下载状态:完成").append(VideoFile.TREE_END);
        switch (WhenMappings.$EnumSwitchMapping$0[videoEntity.getBizType().ordinal()]) {
            case 1:
                completeInfoSb.append("视频id ").append(videoEntity.getAid() + VideoFile.TREE_END).append("标题：").append(videoEntity.getVideoTitle() + VideoFile.TREE_END).append("分P: ");
                String title = videoEntity.getPageTitle();
                String pTitle = "P" + videoEntity.getPageIndex();
                if (Intrinsics.areEqual(pTitle, title)) {
                    completeInfoSb.append(pTitle);
                } else {
                    completeInfoSb.append(pTitle).append("-").append(title);
                }
                completeInfoSb.append(VideoFile.TREE_END);
                break;
            case 2:
                completeInfoSb.append("视频id ").append(videoEntity.getAid()).append(VideoFile.TREE_END).append("标题: ").append(videoEntity.getGroupTitle()).append(VideoFile.TREE_END).append("分集: ").append(OfflineLogicKt.getReadableIndexTitle(videoEntity));
                break;
            default:
                LogKt.getVBLog().debug("video.offline.list.ResolveDescProvider.getCompleteInfo: Unknown bizType");
                Unit unit = Unit.INSTANCE;
                break;
        }
        String sb = completeInfoSb.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}