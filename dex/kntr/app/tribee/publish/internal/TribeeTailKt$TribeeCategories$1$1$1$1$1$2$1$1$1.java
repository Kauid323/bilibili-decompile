package kntr.app.tribee.publish.internal;

import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeTail.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.internal.TribeeTailKt$TribeeCategories$1$1$1$1$1$2$1$1$1", f = "TribeeTail.kt", i = {}, l = {252, KotlinVersion.MAX_COMPONENT_VALUE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeTailKt$TribeeCategories$1$1$1$1$1$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KTribeeCategory $category;
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    final /* synthetic */ TribeeInfo $tribeeInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeTailKt$TribeeCategories$1$1$1$1$1$2$1$1$1(Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, KTribeeCategory kTribeeCategory, TribeeInfo tribeeInfo, Continuation<? super TribeeTailKt$TribeeCategories$1$1$1$1$1$2$1$1$1> continuation) {
        super(2, continuation);
        this.$onAction = function2;
        this.$category = kTribeeCategory;
        this.$tribeeInfo = tribeeInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeTailKt$TribeeCategories$1$1$1$1$1$2$1$1$1(this.$onAction, this.$category, this.$tribeeInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2;
        TribeePublishAction.TrackerAction.CategorySelected categorySelected;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<TribeePublishAction, Continuation<? super Unit>, Object> function22 = this.$onAction;
                TribeePublishAction.ToggleSelectedCategory toggleSelectedCategory = new TribeePublishAction.ToggleSelectedCategory(this.$category);
                this.label = 1;
                if (function22.invoke(toggleSelectedCategory, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function2 = this.$onAction;
                categorySelected = new TribeePublishAction.TrackerAction.CategorySelected(String.valueOf(this.$tribeeInfo.getTribeeId()), this.$category);
                this.label = 2;
                if (function2.invoke(categorySelected, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                function2 = this.$onAction;
                categorySelected = new TribeePublishAction.TrackerAction.CategorySelected(String.valueOf(this.$tribeeInfo.getTribeeId()), this.$category);
                this.label = 2;
                if (function2.invoke(categorySelected, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}