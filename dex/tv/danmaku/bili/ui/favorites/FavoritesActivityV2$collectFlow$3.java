package tv.danmaku.bili.ui.favorites;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppActivityCollectionV2Binding;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageEvent;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$3", f = "FavoritesActivityV2.kt", i = {}, l = {BR.eventHandle}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoritesActivityV2$collectFlow$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesActivityV2$collectFlow$3(FavoritesActivityV2 favoritesActivityV2, Continuation<? super FavoritesActivityV2$collectFlow$3> continuation) {
        super(2, continuation);
        this.this$0 = favoritesActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesActivityV2$collectFlow$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FavoritesActivityViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(viewModel.getUiEventFlow());
                final FavoritesActivityV2 favoritesActivityV2 = this.this$0;
                this.label = 1;
                if (distinctUntilChanged.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$3.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((FavoritesPageEvent) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(FavoritesPageEvent event, Continuation<? super Unit> continuation) {
                        final BiliAppActivityCollectionV2Binding $this$emit_u24lambda_u241;
                        final BiliAppActivityCollectionV2Binding $this$emit_u24lambda_u240;
                        if (Intrinsics.areEqual(event, FavoritesPageEvent.StartBatchManage.INSTANCE)) {
                            $this$emit_u24lambda_u240 = FavoritesActivityV2.this.getBinding();
                            $this$emit_u24lambda_u240.viewPager.setUserInputEnabled(false);
                            ObjectAnimator transAnim = ObjectAnimator.ofFloat($this$emit_u24lambda_u240.navTopBar, View.TRANSLATION_X, 0.0f, -$this$emit_u24lambda_u240.navTopBar.getWidth());
                            ObjectAnimator alphaAnim1 = ObjectAnimator.ofFloat($this$emit_u24lambda_u240.navTopBar, View.ALPHA, 1.0f, 0.0f);
                            ObjectAnimator alphaAnim2 = ObjectAnimator.ofFloat($this$emit_u24lambda_u240.toolBarManage, View.ALPHA, 0.0f, 1.0f);
                            AnimatorSet $this$emit_u24lambda_u240_u240 = new AnimatorSet();
                            $this$emit_u24lambda_u240_u240.playTogether(transAnim, alphaAnim1, alphaAnim2);
                            AnimatorSet $this$addListener_u24default$iv = $this$emit_u24lambda_u240_u240;
                            $this$addListener_u24default$iv.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$3$1$emit$lambda$0$0$$inlined$addListener$default$1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    ListExtentionsKt.visible(BiliAppActivityCollectionV2Binding.this.toolBarManage);
                                }
                            });
                            $this$emit_u24lambda_u240_u240.setDuration(200L);
                            $this$emit_u24lambda_u240_u240.start();
                        } else if (Intrinsics.areEqual(event, FavoritesPageEvent.QuitBatchManage.INSTANCE)) {
                            $this$emit_u24lambda_u241 = FavoritesActivityV2.this.getBinding();
                            $this$emit_u24lambda_u241.viewPager.setUserInputEnabled(true);
                            ObjectAnimator transAnim2 = ObjectAnimator.ofFloat($this$emit_u24lambda_u241.navTopBar, View.TRANSLATION_X, -$this$emit_u24lambda_u241.navTopBar.getWidth(), 0.0f);
                            ObjectAnimator alphaAnim12 = ObjectAnimator.ofFloat($this$emit_u24lambda_u241.navTopBar, View.ALPHA, 0.0f, 1.0f);
                            ObjectAnimator alphaAnim22 = ObjectAnimator.ofFloat($this$emit_u24lambda_u241.toolBarManage, View.ALPHA, 1.0f, 0.0f);
                            AnimatorSet $this$emit_u24lambda_u241_u240 = new AnimatorSet();
                            $this$emit_u24lambda_u241_u240.playTogether(transAnim2, alphaAnim12, alphaAnim22);
                            AnimatorSet $this$addListener_u24default$iv2 = $this$emit_u24lambda_u241_u240;
                            $this$addListener_u24default$iv2.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$3$1$emit$lambda$1$0$$inlined$addListener$default$1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    ListExtentionsKt.gone(BiliAppActivityCollectionV2Binding.this.toolBarManage);
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }
                            });
                            $this$emit_u24lambda_u241_u240.setDuration(200L);
                            $this$emit_u24lambda_u241_u240.start();
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
        return Unit.INSTANCE;
    }
}