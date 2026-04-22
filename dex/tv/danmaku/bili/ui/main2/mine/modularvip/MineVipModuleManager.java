package tv.danmaku.bili.ui.main2.mine.modularvip;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.image2.view.BiliImageView;
import com.opensource.svgaplayer.SVGAImageView;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliLayoutMineVipModuleRefactoringBinding;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum;
import tv.danmaku.bili.utils.vip.VipRoutes;

/* compiled from: MineVipModuleManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleManager;", "", "binding", "Ltv/danmaku/bili/databinding/BiliLayoutMineVipModuleRefactoringBinding;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Ltv/danmaku/bili/databinding/BiliLayoutMineVipModuleRefactoringBinding;Landroidx/lifecycle/LifecycleOwner;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliLayoutMineVipModuleRefactoringBinding;", "enums", "", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", "modelFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "reportScope", "Lkotlinx/coroutines/CoroutineScope;", "renderEnums", "", "model", "rollback", ReportUtilKt.POS_UPDATE, "account", "Ltv/danmaku/bili/ui/main2/api/AccountMine;", "fromCache", "", "onPageInvisible", "onThemeChange", "onTeenagerMode", "isTeenager", "reportLatencyExposure", "reportExposure", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipModuleManager {
    public static final int $stable = 8;
    private final BiliLayoutMineVipModuleRefactoringBinding binding;
    private final List<MineVipModuleEnum> enums;
    private final LifecycleOwner lifecycleOwner;
    private final MutableStateFlow<MineVipModel> modelFlow;
    private final CoroutineScope reportScope;

    public MineVipModuleManager(BiliLayoutMineVipModuleRefactoringBinding binding, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.binding = binding;
        this.lifecycleOwner = lifecycleOwner;
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, ReportUtilKt.POS_TITLE);
        TextView textView2 = this.binding.subtitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "subtitle");
        ImageView imageView = this.binding.rightArrow;
        Intrinsics.checkNotNullExpressionValue(imageView, "rightArrow");
        BiliImageView biliImageView = this.binding.logo;
        Intrinsics.checkNotNullExpressionValue(biliImageView, "logo");
        SVGAImageView sVGAImageView = this.binding.svgaImage;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "svgaImage");
        BiliImageView biliImageView2 = this.binding.bivStaticIcon;
        Intrinsics.checkNotNullExpressionValue(biliImageView2, "bivStaticIcon");
        View view = this.binding.animateSpace;
        Intrinsics.checkNotNullExpressionValue(view, "animateSpace");
        LinearLayout linearLayout = this.binding.button;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "button");
        TextView textView3 = this.binding.buttonText;
        Intrinsics.checkNotNullExpressionValue(textView3, "buttonText");
        BiliImageView biliImageView3 = this.binding.background;
        Intrinsics.checkNotNullExpressionValue(biliImageView3, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND);
        View view2 = this.binding.shadow;
        Intrinsics.checkNotNullExpressionValue(view2, "shadow");
        this.enums = CollectionsKt.listOf(new MineVipModuleEnum[]{new MineVipModuleEnum.Title(textView), new MineVipModuleEnum.Subtitle(textView2, imageView), new MineVipModuleEnum.Logo(biliImageView), new MineVipModuleEnum.Icon(sVGAImageView, biliImageView2, view), new MineVipModuleEnum.Button(linearLayout, textView3), new MineVipModuleEnum.Background(biliImageView3, view2)});
        this.modelFlow = StateFlowKt.MutableStateFlow(new MineVipModel(null, 0L, null, null, null, null, null, null, null, BR.roleTitle, null));
        this.reportScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus((CoroutineExceptionHandler) new MineVipModuleManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
        final BiliLayoutMineVipModuleRefactoringBinding $this$_init__u24lambda_u240 = this.binding;
        final Function1 routeTo = new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return MineVipModuleManager.lambda$0$0(BiliLayoutMineVipModuleRefactoringBinding.this, (String) obj);
            }
        };
        $this$_init__u24lambda_u240.getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MineVipModuleManager.lambda$0$1(MineVipModuleManager.this, routeTo, view3);
            }
        });
        $this$_init__u24lambda_u240.button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MineVipModuleManager.lambda$0$2(MineVipModuleManager.this, routeTo, view3);
            }
        });
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
    }

    public final BiliLayoutMineVipModuleRefactoringBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(BiliLayoutMineVipModuleRefactoringBinding $this_with, String url) {
        RouteRequest it;
        boolean z = false;
        if (url != null && StringsKt.startsWith$default(url, AppConfig.SCHEME_HTTP, false, 2, (Object) null)) {
            z = true;
        }
        if (z) {
            VipRoutes.openH5($this_with.getRoot().getContext(), url);
        } else if (url != null && (it = RouteRequestKt.toRouteRequest(url)) != null) {
            BLRouter.routeTo(it, $this_with.getRoot().getContext());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$1(MineVipModuleManager this$0, Function1 $routeTo, View it) {
        String url = MineVipService.INSTANCE.getRouterUrl((MineVipModel) this$0.modelFlow.getValue(), false);
        MineVipService.INSTANCE.reportClickEvent((MineVipModel) this$0.modelFlow.getValue(), "text", url);
        $routeTo.invoke(url);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$2(MineVipModuleManager this$0, Function1 $routeTo, View it) {
        String url = MineVipService.INSTANCE.getRouterUrl((MineVipModel) this$0.modelFlow.getValue(), true);
        MineVipService.INSTANCE.reportClickEvent((MineVipModel) this$0.modelFlow.getValue(), "button", url);
        $routeTo.invoke(url);
    }

    /* compiled from: MineVipModuleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$2", f = "MineVipModuleManager.kt", i = {}, l = {BR.cornerText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MineVipModuleManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$2$1", f = "MineVipModuleManager.kt", i = {}, l = {BR.cornerVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$2$1  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MineVipModuleManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MineVipModuleManager mineVipModuleManager, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mineVipModuleManager;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MutableStateFlow mutableStateFlow = this.this$0.modelFlow;
                        final MineVipModuleManager mineVipModuleManager = this.this$0;
                        this.label = 1;
                        if (mutableStateFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager.2.1.1
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((MineVipModel) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(MineVipModel model, Continuation<? super Unit> continuation) {
                                BLog.d(MineVipModuleManagerKt.TAG, "on collect model.(" + model + ")");
                                MineVipModuleManager.this.renderEnums(model);
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

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(MineVipModuleManager.this.lifecycleOwner, Lifecycle.State.CREATED, new AnonymousClass1(MineVipModuleManager.this, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderEnums(MineVipModel model) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), Dispatchers.getMain().getImmediate().plus((CoroutineExceptionHandler) new MineVipModuleManager$renderEnums$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this)), (CoroutineStart) null, new MineVipModuleManager$renderEnums$2(this, model, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rollback() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$rollback$1(this, null), 3, (Object) null);
    }

    public final void update(AccountMine account, boolean fromCache) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$update$1(account, this, null), 3, (Object) null);
        if (!fromCache) {
            reportExposure();
        }
    }

    public final void onPageInvisible() {
        BLog.d(MineVipModuleManagerKt.TAG, "on page invisible.");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$onPageInvisible$1(this, null), 3, (Object) null);
    }

    public final void onThemeChange() {
        BLog.d(MineVipModuleManagerKt.TAG, "on theme changed.");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$onThemeChange$1(this, null), 3, (Object) null);
    }

    public final void onTeenagerMode(boolean isTeenager) {
        int i;
        View $this$setVisibleOrGone_u24default$iv = this.binding.getRoot();
        boolean show$iv = !isTeenager;
        if ($this$setVisibleOrGone_u24default$iv != null) {
            if (show$iv) {
                i = 0;
            } else {
                i = 8;
            }
            $this$setVisibleOrGone_u24default$iv.setVisibility(i);
        }
        if (!show$iv || $this$setVisibleOrGone_u24default$iv != null) {
        }
    }

    public final void reportLatencyExposure() {
        BuildersKt.launch$default(this.reportScope, (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$reportLatencyExposure$1(this, null), 3, (Object) null);
    }

    public final void reportExposure() {
        BuildersKt.launch$default(this.reportScope, (CoroutineContext) null, (CoroutineStart) null, new MineVipModuleManager$reportExposure$1(this, null), 3, (Object) null);
    }
}