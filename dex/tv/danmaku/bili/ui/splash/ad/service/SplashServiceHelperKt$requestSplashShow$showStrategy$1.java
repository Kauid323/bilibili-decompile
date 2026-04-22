package tv.danmaku.bili.ui.splash.ad.service;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.utils.ExBilowUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.ui.splash.ad.model.SplashShowData;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashServiceHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShowData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.service.SplashServiceHelperKt$requestSplashShow$showStrategy$1", f = "SplashServiceHelper.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashServiceHelperKt$requestSplashShow$showStrategy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SplashShowData>, Object> {
    final /* synthetic */ String $accessKey;
    final /* synthetic */ String $adExtra;
    final /* synthetic */ int $height;
    final /* synthetic */ String $network;
    final /* synthetic */ String $topviewIds;
    final /* synthetic */ int $width;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashServiceHelperKt$requestSplashShow$showStrategy$1(String str, int i, int i2, String str2, String str3, String str4, Continuation<? super SplashServiceHelperKt$requestSplashShow$showStrategy$1> continuation) {
        super(2, continuation);
        this.$accessKey = str;
        this.$width = i;
        this.$height = i2;
        this.$adExtra = str2;
        this.$network = str3;
        this.$topviewIds = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashServiceHelperKt$requestSplashShow$showStrategy$1(this.$accessKey, this.$width, this.$height, this.$adExtra, this.$network, this.$topviewIds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SplashShowData> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashServiceHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShowData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.service.SplashServiceHelperKt$requestSplashShow$showStrategy$1$1", f = "SplashServiceHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.splash.ad.service.SplashServiceHelperKt$requestSplashShow$showStrategy$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SplashShowData>, Object> {
        final /* synthetic */ String $accessKey;
        final /* synthetic */ String $adExtra;
        final /* synthetic */ int $height;
        final /* synthetic */ String $network;
        final /* synthetic */ String $topviewIds;
        final /* synthetic */ int $width;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i, int i2, String str2, String str3, String str4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$accessKey = str;
            this.$width = i;
            this.$height = i2;
            this.$adExtra = str2;
            this.$network = str3;
            this.$topviewIds = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$accessKey, this.$width, this.$height, this.$adExtra, this.$network, this.$topviewIds, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SplashShowData> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            SplashService splashService;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    splashService = SplashServiceHelperKt.service;
                    String str = this.$accessKey;
                    int i = this.$width;
                    int i2 = this.$height;
                    String str2 = this.$adExtra;
                    String str3 = this.$network;
                    String str4 = this.$topviewIds;
                    if (str4 == null) {
                        str4 = "";
                    }
                    BiliCall<GeneralResponse<SplashShowData>> splashShowList = splashService.getSplashShowList(str, i, i2, str2, str3, str4);
                    return ExBilowUtil.extractResponseData(splashShowList != null ? splashShowList.execute() : null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object await = BuildersKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$accessKey, this.$width, this.$height, this.$adExtra, this.$network, this.$topviewIds, null), 3, (Object) null).await((Continuation) this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return await;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}