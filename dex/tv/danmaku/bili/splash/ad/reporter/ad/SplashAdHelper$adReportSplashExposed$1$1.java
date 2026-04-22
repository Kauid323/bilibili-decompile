package tv.danmaku.bili.splash.ad.reporter.ad;

import android.os.Bundle;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.IClickInfo;
import com.bilibili.adcommon.data.model.FeedExtra;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.GAdReport;
import com.bilibili.gripper.api.ad.core.report.ExtraParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashAdHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportSplashExposed$1$1", f = "SplashAdHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashAdHelper$adReportSplashExposed$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IAdReportInfo $adReportInfo;
    final /* synthetic */ String $eventFrom;
    final /* synthetic */ String $openEvent;
    final /* synthetic */ SplashOrder $splash;
    final /* synthetic */ SplashOrder $this_run;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdHelper$adReportSplashExposed$1$1(IAdReportInfo iAdReportInfo, SplashOrder splashOrder, String str, String str2, SplashOrder splashOrder2, Continuation<? super SplashAdHelper$adReportSplashExposed$1$1> continuation) {
        super(2, continuation);
        this.$adReportInfo = iAdReportInfo;
        this.$this_run = splashOrder;
        this.$openEvent = str;
        this.$eventFrom = str2;
        this.$splash = splashOrder2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> splashAdHelper$adReportSplashExposed$1$1 = new SplashAdHelper$adReportSplashExposed$1$1(this.$adReportInfo, this.$this_run, this.$openEvent, this.$eventFrom, this.$splash, continuation);
        splashAdHelper$adReportSplashExposed$1$1.L$0 = obj;
        return splashAdHelper$adReportSplashExposed$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashAdHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportSplashExposed$1$1$1", f = "SplashAdHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportSplashExposed$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAdReportInfo $adReportInfo;
        final /* synthetic */ String $eventFrom;
        final /* synthetic */ String $openEvent;
        final /* synthetic */ SplashOrder $splash;
        final /* synthetic */ SplashOrder $this_run;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IAdReportInfo iAdReportInfo, SplashOrder splashOrder, String str, String str2, SplashOrder splashOrder2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$adReportInfo = iAdReportInfo;
            this.$this_run = splashOrder;
            this.$openEvent = str;
            this.$eventFrom = str2;
            this.$splash = splashOrder2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$adReportInfo, this.$this_run, this.$openEvent, this.$eventFrom, this.$splash, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ExtraParams extraParams = new ExtraParams((Bundle) null, 1, (DefaultConstructorMarker) null);
                    SplashOrder splashOrder = this.$this_run;
                    String str = this.$openEvent;
                    String str2 = this.$eventFrom;
                    SplashOrder splashOrder2 = this.$splash;
                    Bundle $this$invokeSuspend_u24lambda_u240_u240 = extraParams.getExtra();
                    $this$invokeSuspend_u24lambda_u240_u240.putString("splash_request_id", splashOrder.getRuntimeExtra().getSplashRequestId());
                    $this$invokeSuspend_u24lambda_u240_u240.putString("open_event", str);
                    $this$invokeSuspend_u24lambda_u240_u240.putString("event_from", str2);
                    $this$invokeSuspend_u24lambda_u240_u240.putString("new_splash", "1");
                    $this$invokeSuspend_u24lambda_u240_u240.putString("is_out_open_deeplink", String.valueOf(splashOrder2.getRuntimeExtra().isFromCalledUp() ? 1 : 0));
                    GAdCoreKt.getGAdReport().dedupEvent(ReportEvent.EVENT_TYPE_SHOW, this.$adReportInfo, extraParams);
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
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$adReportInfo, this.$this_run, this.$openEvent, this.$eventFrom, this.$splash, null), 3, (Object) null);
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$adReportInfo, this.$splash, null), 3, (Object) null);
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(this.$adReportInfo, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashAdHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportSplashExposed$1$1$2", f = "SplashAdHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportSplashExposed$1$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAdReportInfo $adReportInfo;
        final /* synthetic */ SplashOrder $splash;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(IAdReportInfo iAdReportInfo, SplashOrder splashOrder, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$adReportInfo = iAdReportInfo;
            this.$splash = splashOrder;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$adReportInfo, this.$splash, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IClickInfo clickInfo;
            FeedExtra extraDeprecated;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    GAdReport gAdReport = GAdCoreKt.getGAdReport();
                    IAdReportInfo iAdReportInfo = this.$adReportInfo;
                    IAdInfo adInfo = ExtSplashOrderKt.adInfo(this.$splash);
                    Job it = gAdReport.reportTouchSpot(iAdReportInfo, (adInfo == null || (clickInfo = adInfo.getClickInfo()) == null || (extraDeprecated = clickInfo.getExtraDeprecated()) == null) ? null : extraDeprecated.getSplashTouch());
                    SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
                    SplashAdHelper.reportTouchSpotJob = it;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashAdHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportSplashExposed$1$1$3", f = "SplashAdHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper$adReportSplashExposed$1$1$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAdReportInfo $adReportInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(IAdReportInfo iAdReportInfo, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$adReportInfo = iAdReportInfo;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$adReportInfo, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    GAdCoreKt.getGAdReport().exposedMMAWithRequestId(this.$adReportInfo, "show_urls");
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}