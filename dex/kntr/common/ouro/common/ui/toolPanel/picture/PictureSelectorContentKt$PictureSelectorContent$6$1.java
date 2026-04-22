package kntr.common.ouro.common.ui.toolPanel.picture;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.Easing;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.watch.later.watchlater.edit.FavoriteSingleViewModelKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PictureSelectorContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.picture.PictureSelectorContentKt$PictureSelectorContent$6$1", f = "PictureSelectorContent.kt", i = {}, l = {FavoriteSingleViewModelKt.MAX_PAGE_SIZE, 106, 113}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PictureSelectorContentKt$PictureSelectorContent$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AphroState.AphroContent $albums;
    final /* synthetic */ ExpandablePanelState.Style $anchoredDraggableCurrentValue;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $bottomBarAnimation;
    int label;

    /* compiled from: PictureSelectorContent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExpandablePanelState.Style.values().length];
            try {
                iArr[ExpandablePanelState.Style.Expanded.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ExpandablePanelState.Style.Normal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureSelectorContentKt$PictureSelectorContent$6$1(AphroState.AphroContent aphroContent, ExpandablePanelState.Style style, Animatable<Float, AnimationVector1D> animatable, Continuation<? super PictureSelectorContentKt$PictureSelectorContent$6$1> continuation) {
        super(2, continuation);
        this.$albums = aphroContent;
        this.$anchoredDraggableCurrentValue = style;
        this.$bottomBarAnimation = animatable;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureSelectorContentKt$PictureSelectorContent$6$1(this.$albums, this.$anchoredDraggableCurrentValue, this.$bottomBarAnimation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object animateTo$default;
        Object animateTo$default2;
        Object animateTo$default3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$albums.getCurrentSelected().isEmpty()) {
                    this.label = 3;
                    animateTo$default = Animatable.animateTo$default(this.$bottomBarAnimation, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null);
                    if (animateTo$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AnimationResult animationResult = (AnimationResult) animateTo$default;
                    return Unit.INSTANCE;
                }
                switch (WhenMappings.$EnumSwitchMapping$0[this.$anchoredDraggableCurrentValue.ordinal()]) {
                    case 1:
                        this.label = 1;
                        animateTo$default2 = Animatable.animateTo$default(this.$bottomBarAnimation, Boxing.boxFloat(0.0f), AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null);
                        if (animateTo$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AnimationResult animationResult2 = (AnimationResult) animateTo$default2;
                        return Unit.INSTANCE;
                    case 2:
                        this.label = 2;
                        animateTo$default3 = Animatable.animateTo$default(this.$bottomBarAnimation, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null);
                        if (animateTo$default3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AnimationResult animationResult3 = (AnimationResult) animateTo$default3;
                        return Unit.INSTANCE;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                animateTo$default2 = $result;
                AnimationResult animationResult22 = (AnimationResult) animateTo$default2;
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                animateTo$default3 = $result;
                AnimationResult animationResult32 = (AnimationResult) animateTo$default3;
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                animateTo$default = $result;
                AnimationResult animationResult4 = (AnimationResult) animateTo$default;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}