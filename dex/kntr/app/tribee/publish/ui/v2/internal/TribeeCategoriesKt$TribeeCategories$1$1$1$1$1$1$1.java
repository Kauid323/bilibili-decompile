package kntr.app.tribee.publish.ui.v2.internal;

import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeCategories.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.internal.TribeeCategoriesKt$TribeeCategories$1$1$1$1$1$1$1", f = "TribeeCategories.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeCategoriesKt$TribeeCategories$1$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KTribeeCategory $category;
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ TribeeInfo $tribeeInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeCategoriesKt$TribeeCategories$1$1$1$1$1$1$1(CoroutineScope coroutineScope, Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, TribeeInfo tribeeInfo, KTribeeCategory kTribeeCategory, Continuation<? super TribeeCategoriesKt$TribeeCategories$1$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$onAction = function2;
        this.$tribeeInfo = tribeeInfo;
        this.$category = kTribeeCategory;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeCategoriesKt$TribeeCategories$1$1$1$1$1$1$1(this.$scope, this.$onAction, this.$tribeeInfo, this.$category, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TribeeCategories.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.internal.TribeeCategoriesKt$TribeeCategories$1$1$1$1$1$1$1$1", f = "TribeeCategories.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.tribee.publish.ui.v2.internal.TribeeCategoriesKt$TribeeCategories$1$1$1$1$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KTribeeCategory $category;
        final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
        final /* synthetic */ TribeeInfo $tribeeInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, TribeeInfo tribeeInfo, KTribeeCategory kTribeeCategory, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onAction = function2;
            this.$tribeeInfo = tribeeInfo;
            this.$category = kTribeeCategory;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$onAction, this.$tribeeInfo, this.$category, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2 = this.$onAction;
                    TribeePublishAction.TrackerAction.CategoryExposure categoryExposure = new TribeePublishAction.TrackerAction.CategoryExposure(String.valueOf(this.$tribeeInfo.getTribeeId()), this.$category);
                    this.label = 1;
                    if (function2.invoke(categoryExposure, this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BuildersKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$onAction, this.$tribeeInfo, this.$category, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}