package tv.danmaku.bili.splash.ad.reporter.ad;

import com.bilibili.adcommon.basic.Motion;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.IClickInfo;
import com.bilibili.adcommon.data.model.FeedExtra;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.GAdReport;
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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashAdHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportMiddlePageClicked$1$1", f = "SplashAdHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashAdHelper$adReportMiddlePageClicked$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IAdReportInfo $adReportInfo;
    final /* synthetic */ SplashOrder $splash;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdHelper$adReportMiddlePageClicked$1$1(IAdReportInfo iAdReportInfo, SplashOrder splashOrder, Continuation<? super SplashAdHelper$adReportMiddlePageClicked$1$1> continuation) {
        super(2, continuation);
        this.$adReportInfo = iAdReportInfo;
        this.$splash = splashOrder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> splashAdHelper$adReportMiddlePageClicked$1$1 = new SplashAdHelper$adReportMiddlePageClicked$1$1(this.$adReportInfo, this.$splash, continuation);
        splashAdHelper$adReportMiddlePageClicked$1$1.L$0 = obj;
        return splashAdHelper$adReportMiddlePageClicked$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashAdHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportMiddlePageClicked$1$1$1", f = "SplashAdHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportMiddlePageClicked$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAdReportInfo $adReportInfo;
        final /* synthetic */ SplashOrder $splash;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IAdReportInfo iAdReportInfo, SplashOrder splashOrder, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$adReportInfo = iAdReportInfo;
            this.$splash = splashOrder;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$adReportInfo, this.$splash, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    GAdReport gAdReport = GAdCoreKt.getGAdReport();
                    IAdReportInfo iAdReportInfo = this.$adReportInfo;
                    IAdInfo adInfo = ExtSplashOrderKt.adInfo(this.$splash);
                    IClickInfo clickInfo = adInfo != null ? adInfo.getClickInfo() : null;
                    FeedExtra feedExtra = clickInfo instanceof FeedExtra ? (FeedExtra) clickInfo : null;
                    gAdReport.clickedMMAWithRequestId(iAdReportInfo, (Motion) null, feedExtra != null ? feedExtra.getMiddleClickUrls() : null, "click_urls");
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$adReportInfo, this.$splash, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}