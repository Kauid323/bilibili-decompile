package kntr.app.game.steam;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.game.base.bridge.KntrGameReportService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.router.GlobalRouterKt;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: SteamGamePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamGamePageKt$SteamGamePageContent$5$1", f = "SteamGamePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SteamGamePageKt$SteamGamePageContent$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ String $sourceFrom;
    final /* synthetic */ String $steamId;
    final /* synthetic */ Toaster $toaster;
    final /* synthetic */ SteamGameVM $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamGamePageKt$SteamGamePageContent$5$1(SteamGameVM steamGameVM, String str, String str2, CoroutineScope coroutineScope, Toaster toaster, String str3, Continuation<? super SteamGamePageKt$SteamGamePageContent$5$1> continuation) {
        super(2, continuation);
        this.$viewModel = steamGameVM;
        this.$steamId = str;
        this.$appId = str2;
        this.$scope = coroutineScope;
        this.$toaster = toaster;
        this.$sourceFrom = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamGamePageKt$SteamGamePageContent$5$1(this.$viewModel, this.$steamId, this.$appId, this.$scope, this.$toaster, this.$sourceFrom, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$viewModel.setParameters(this.$steamId, this.$appId);
                BuildersKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$viewModel, this.$toaster, null), 3, (Object) null);
                BuildersKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$viewModel, this.$sourceFrom, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SteamGamePage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.steam.SteamGamePageKt$SteamGamePageContent$5$1$1", f = "SteamGamePage.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.steam.SteamGamePageKt$SteamGamePageContent$5$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Toaster $toaster;
        final /* synthetic */ SteamGameVM $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SteamGameVM steamGameVM, Toaster toaster, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$viewModel = steamGameVM;
            this.$toaster = toaster;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$viewModel, this.$toaster, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SharedFlow<String> toastEvent = this.$viewModel.getToastEvent();
                    final Toaster toaster = this.$toaster;
                    this.label = 1;
                    if (toastEvent.collect(new FlowCollector() { // from class: kntr.app.game.steam.SteamGamePageKt.SteamGamePageContent.5.1.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((String) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(String toast, Continuation<? super Unit> continuation) {
                            if (toast.length() > 0) {
                                Toaster.-CC.showToast$default(toaster, toast, (ToastDuration) null, 2, (Object) null);
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SteamGamePage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.steam.SteamGamePageKt$SteamGamePageContent$5$1$2", f = "SteamGamePage.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.steam.SteamGamePageKt$SteamGamePageContent$5$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $sourceFrom;
        final /* synthetic */ SteamGameVM $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SteamGameVM steamGameVM, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$viewModel = steamGameVM;
            this.$sourceFrom = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$viewModel, this.$sourceFrom, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SharedFlow<String> navigateToSteamLogin = this.$viewModel.getNavigateToSteamLogin();
                    final SteamGameVM steamGameVM = this.$viewModel;
                    final String str = this.$sourceFrom;
                    this.label = 1;
                    if (navigateToSteamLogin.collect(new FlowCollector() { // from class: kntr.app.game.steam.SteamGamePageKt.SteamGamePageContent.5.1.2.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((String) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(String str2, Continuation<? super Unit> continuation) {
                            SteamGameVM.this.markNavigatedToSteamLogin();
                            GlobalRouterKt.getGlobalRouter().launch(Uri.Companion.parse("https://gmds.biligame.com/?bound_source=4").buildUpon().appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, str).appendQueryParameter("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()).build());
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }
}