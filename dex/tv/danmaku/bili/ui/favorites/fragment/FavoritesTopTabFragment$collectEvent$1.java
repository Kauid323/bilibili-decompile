package tv.danmaku.bili.ui.favorites.fragment;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.iconfont.R;
import com.bilibili.magicasakura.widgets.TintImageView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$collectEvent$1;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageEvent;
import tv.danmaku.bili.ui.favorites.util.FavoritesFolderUtilsKt;

/* compiled from: FavoritesTopTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$collectEvent$1", f = "FavoritesTopTabFragment.kt", i = {}, l = {BR.descTipText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesTopTabFragment$collectEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesTopTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesTopTabFragment$collectEvent$1(FavoritesTopTabFragment favoritesTopTabFragment, Continuation<? super FavoritesTopTabFragment$collectEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = favoritesTopTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesTopTabFragment$collectEvent$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesTopTabFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$collectEvent$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FavoritesTopTabFragment this$0;

        AnonymousClass1(FavoritesTopTabFragment favoritesTopTabFragment) {
            this.this$0 = favoritesTopTabFragment;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((FavoritesPageEvent) value, (Continuation<? super Unit>) $completion);
        }

        public final Object emit(FavoritesPageEvent event, Continuation<? super Unit> continuation) {
            if (Intrinsics.areEqual(event, FavoritesPageEvent.ShowAddFolderIcon.INSTANCE)) {
                ListExtentionsKt.visible(this.this$0.getBinding().icon2);
                TintImageView tintImageView = this.this$0.getBinding().icon2;
                Context context = this.this$0.getContext();
                tintImageView.setImageDrawable(context != null ? KtxKt.getAppCompatDrawable(context, R.drawable.ref_plus_add_line_500) : null);
                this.this$0.getBinding().icon2.setImageTintList(com.bilibili.lib.theme.R.color.Graph_bold);
            } else if (Intrinsics.areEqual(event, FavoritesPageEvent.ShowBatchManageIcon.INSTANCE)) {
                ListExtentionsKt.visible(this.this$0.getBinding().icon2);
                TintImageView tintImageView2 = this.this$0.getBinding().icon2;
                Context context2 = this.this$0.getContext();
                tintImageView2.setImageDrawable(context2 != null ? KtxKt.getAppCompatDrawable(context2, R.drawable.ref_list_select_line_500) : null);
                this.this$0.getBinding().icon2.setImageTintList(com.bilibili.lib.theme.R.color.Graph_bold);
            } else if (event instanceof FavoritesPageEvent.SetSearchIcon) {
                this.this$0.getBinding().icon1.setVisibility(ListExtentionsKt.toVisibility(((FavoritesPageEvent.SetSearchIcon) event).getShow()));
            } else if (Intrinsics.areEqual(event, FavoritesPageEvent.HideRightIcon.INSTANCE)) {
                ListExtentionsKt.gone(this.this$0.getBinding().icon2);
            } else if (Intrinsics.areEqual(event, FavoritesPageEvent.QuitBatchManage.INSTANCE)) {
                ValueAnimator $this$emit_u24lambda_u240 = ValueAnimator.ofInt(0, ListExtentionsKt.toPx(52));
                final FavoritesTopTabFragment favoritesTopTabFragment = this.this$0;
                $this$emit_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$collectEvent$1$1$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FavoritesTopTabFragment$collectEvent$1.AnonymousClass1.emit$lambda$0$0(FavoritesTopTabFragment.this, valueAnimator);
                    }
                });
                $this$emit_u24lambda_u240.setDuration(200L);
                $this$emit_u24lambda_u240.start();
            } else if (Intrinsics.areEqual(event, FavoritesPageEvent.StartBatchManage.INSTANCE)) {
                ValueAnimator $this$emit_u24lambda_u241 = ValueAnimator.ofInt(ListExtentionsKt.toPx(52), 0);
                final FavoritesTopTabFragment favoritesTopTabFragment2 = this.this$0;
                $this$emit_u24lambda_u241.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTopTabFragment$collectEvent$1$1$$ExternalSyntheticLambda1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FavoritesTopTabFragment$collectEvent$1.AnonymousClass1.emit$lambda$1$0(FavoritesTopTabFragment.this, valueAnimator);
                    }
                });
                $this$emit_u24lambda_u241.setDuration(200L);
                $this$emit_u24lambda_u241.start();
            } else if (!Intrinsics.areEqual(event, FavoritesPageEvent.ForceRefresh.INSTANCE) && !Intrinsics.areEqual(event, FavoritesPageEvent.SwitchLayoutType.INSTANCE)) {
                if (!(event instanceof FavoritesPageEvent.ShowCompactIcon)) {
                    throw new NoWhenBranchMatchedException();
                }
                TintImageView tintImageView3 = this.this$0.getBinding().icon3;
                Context context3 = this.this$0.getContext();
                tintImageView3.setImageDrawable(context3 != null ? KtxKt.getAppCompatDrawable(context3, FavoritesFolderUtilsKt.getLayoutIcon()) : null);
                this.this$0.getBinding().icon3.setImageTintList(com.bilibili.lib.theme.R.color.Graph_bold);
                this.this$0.getBinding().icon3.setVisibility(ListExtentionsKt.toVisibility(((FavoritesPageEvent.ShowCompactIcon) event).getShow()));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0$0(FavoritesTopTabFragment this$0, ValueAnimator it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
            if (num != null) {
                int h = num.intValue();
                View view = this$0.getBinding().topContainer;
                Intrinsics.checkNotNullExpressionValue(view, "topContainer");
                View $this$updateLayoutParams$iv = view;
                ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
                if (params$iv$iv != null) {
                    params$iv$iv.height = h;
                    $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$1$0(FavoritesTopTabFragment this$0, ValueAnimator it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
            if (num != null) {
                int h = num.intValue();
                View view = this$0.getBinding().topContainer;
                Intrinsics.checkNotNullExpressionValue(view, "topContainer");
                View $this$updateLayoutParams$iv = view;
                ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
                if (params$iv$iv != null) {
                    params$iv$iv.height = h;
                    $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.distinctUntilChanged(this.this$0.getActivityVM().getUiEventFlow()).collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
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