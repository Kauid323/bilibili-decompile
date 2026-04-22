package tv.danmaku.bili.ui.favorites.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppFragmentFavoritesTabBinding;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageEvent;

/* compiled from: FavoritesEditTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$7", f = "FavoritesEditTabFragment.kt", i = {}, l = {BR.msgContent}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesEditTabFragment$onViewCreated$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesEditTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesEditTabFragment$onViewCreated$7(FavoritesEditTabFragment favoritesEditTabFragment, Continuation<? super FavoritesEditTabFragment$onViewCreated$7> continuation) {
        super(2, continuation);
        this.this$0 = favoritesEditTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesEditTabFragment$onViewCreated$7(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow flowWithLifecycle = FlowExtKt.flowWithLifecycle(this.this$0.getActivityVM().getUiEventFlow(), this.this$0.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.RESUMED);
                final FavoritesEditTabFragment favoritesEditTabFragment = this.this$0;
                this.label = 1;
                if (flowWithLifecycle.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$7.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((FavoritesPageEvent) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(FavoritesPageEvent event, Continuation<? super Unit> continuation) {
                        BLog.d("FavoritesEditTabFragment", "activity event:" + event);
                        if (Intrinsics.areEqual(event, FavoritesPageEvent.QuitBatchManage.INSTANCE)) {
                            FavoritesEditTabFragment.this.getViewModel().sendAction(FavoritesAction.QuitBatchManage.INSTANCE);
                            final BiliAppFragmentFavoritesTabBinding $this$emit_u24lambda_u240 = FavoritesEditTabFragment.this.getBinding();
                            ObjectAnimator $this$emit_u24lambda_u240_u240 = ObjectAnimator.ofFloat($this$emit_u24lambda_u240.batchManageContainer, View.ALPHA, 1.0f, 0.0f);
                            $this$emit_u24lambda_u240_u240.setDuration(200L);
                            Intrinsics.checkNotNull($this$emit_u24lambda_u240_u240);
                            ObjectAnimator $this$doOnEnd$iv = $this$emit_u24lambda_u240_u240;
                            Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$7$1$emit$lambda$0$0$$inlined$doOnEnd$1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    ListExtentionsKt.gone(BiliAppFragmentFavoritesTabBinding.this.batchManageContainer);
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }
                            };
                            $this$doOnEnd$iv.addListener(animatorListener);
                            $this$emit_u24lambda_u240_u240.addListener(animatorListener);
                            $this$emit_u24lambda_u240_u240.start();
                            ObjectAnimator $this$emit_u24lambda_u240_u241 = ObjectAnimator.ofFloat($this$emit_u24lambda_u240.shadow, View.ALPHA, 0.1f, 0.0f);
                            $this$emit_u24lambda_u240_u241.setDuration(200L);
                            Intrinsics.checkNotNull($this$emit_u24lambda_u240_u241);
                            ObjectAnimator $this$doOnEnd$iv2 = $this$emit_u24lambda_u240_u241;
                            Animator.AnimatorListener animatorListener2 = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$7$1$emit$lambda$0$1$$inlined$doOnEnd$1
                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationRepeat(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    ListExtentionsKt.gone(BiliAppFragmentFavoritesTabBinding.this.shadow);
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                }

                                @Override // android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }
                            };
                            $this$doOnEnd$iv2.addListener(animatorListener2);
                            $this$emit_u24lambda_u240_u241.addListener(animatorListener2);
                            $this$emit_u24lambda_u240_u241.start();
                        } else if (Intrinsics.areEqual(event, FavoritesPageEvent.StartBatchManage.INSTANCE)) {
                            FavoritesEditTabFragment.this.getViewModel().sendAction(FavoritesAction.StartBatchManage.INSTANCE);
                            final BiliAppFragmentFavoritesTabBinding $this$emit_u24lambda_u241 = FavoritesEditTabFragment.this.getBinding();
                            ObjectAnimator $this$emit_u24lambda_u241_u240 = ObjectAnimator.ofFloat($this$emit_u24lambda_u241.batchManageContainer, View.ALPHA, 0.0f, 1.0f);
                            $this$emit_u24lambda_u241_u240.setDuration(200L);
                            Intrinsics.checkNotNull($this$emit_u24lambda_u241_u240);
                            ObjectAnimator $this$doOnStart$iv = $this$emit_u24lambda_u241_u240;
                            Animator.AnimatorListener animatorListener3 = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$7$1$emit$lambda$1$0$$inlined$doOnStart$1
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
                                    ListExtentionsKt.visible(BiliAppFragmentFavoritesTabBinding.this.batchManageContainer);
                                }
                            };
                            $this$doOnStart$iv.addListener(animatorListener3);
                            $this$emit_u24lambda_u241_u240.addListener(animatorListener3);
                            $this$emit_u24lambda_u241_u240.start();
                            ObjectAnimator $this$emit_u24lambda_u241_u241 = ObjectAnimator.ofFloat($this$emit_u24lambda_u241.shadow, View.ALPHA, 0.0f, 0.1f);
                            $this$emit_u24lambda_u241_u241.setDuration(200L);
                            Intrinsics.checkNotNull($this$emit_u24lambda_u241_u241);
                            ObjectAnimator $this$doOnStart$iv2 = $this$emit_u24lambda_u241_u241;
                            Animator.AnimatorListener animatorListener4 = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$7$1$emit$lambda$1$1$$inlined$doOnStart$1
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
                                    ListExtentionsKt.visible(BiliAppFragmentFavoritesTabBinding.this.shadow);
                                }
                            };
                            $this$doOnStart$iv2.addListener(animatorListener4);
                            $this$emit_u24lambda_u241_u241.addListener(animatorListener4);
                            $this$emit_u24lambda_u241_u241.start();
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