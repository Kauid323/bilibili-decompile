package tv.danmaku.bili.push.innerpush.v2;

import android.app.Activity;
import com.bilibili.pvtracker.PageViewTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2", f = "AppInnerPushManagerV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppInnerPushManagerV2$tryShowInnerPush$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInnerPushManagerV2$tryShowInnerPush$2(AppInnerPushManagerV2 appInnerPushManagerV2, Activity activity, Continuation<? super AppInnerPushManagerV2$tryShowInnerPush$2> continuation) {
        super(2, continuation);
        this.this$0 = appInnerPushManagerV2;
        this.$activity = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$tryShowInnerPush$2(this.this$0, this.$activity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                String currentPageViewId = PageViewTracker.getInstance().getCurrentPageViewId();
                if (currentPageViewId == null) {
                    currentPageViewId = "";
                }
                String pvId = currentPageViewId;
                Iterable $this$map$iv = CollectionsKt.toMutableList(this.this$0.bizRuleMap.keySet());
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String it = (String) item$iv$iv;
                    destination$iv$iv.add(Boxing.boxInt(Integer.parseInt(it)));
                }
                List registeredBiz = (List) destination$iv$iv;
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$activity, pvId, registeredBiz, this.this$0, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppInnerPushManagerV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.paddingStartAndEnd}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $pvId;
        final /* synthetic */ List<Integer> $registeredBiz;
        int label;
        final /* synthetic */ AppInnerPushManagerV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, String str, List<Integer> list, AppInnerPushManagerV2 appInnerPushManagerV2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$pvId = str;
            this.$registeredBiz = list;
            this.this$0 = appInnerPushManagerV2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activity, this.$pvId, this.$registeredBiz, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    InnerPushCacheManagerV2 companion = InnerPushCacheManagerV2.Companion.getInstance();
                    Activity activity = this.$activity;
                    String str = this.$pvId;
                    List<Integer> list = this.$registeredBiz;
                    final AppInnerPushManagerV2 appInnerPushManagerV2 = this.this$0;
                    final Activity activity2 = this.$activity;
                    final String str2 = this.$pvId;
                    this.label = 1;
                    if (companion.findInnerPush(activity, str, list, new Function3() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = AppInnerPushManagerV2$tryShowInnerPush$2.AnonymousClass1.invokeSuspend$lambda$0(AppInnerPushManagerV2.this, activity2, str2, (InnerPushType) obj, (List) obj2, (String) obj3);
                            return invokeSuspend$lambda$0;
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(AppInnerPushManagerV2 this$0, Activity $activity, String $pvId, InnerPushType type, List list, String params) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1(type, this$0, $activity, list, $pvId, params, null), 3, (Object) null);
            return Unit.INSTANCE;
        }
    }
}