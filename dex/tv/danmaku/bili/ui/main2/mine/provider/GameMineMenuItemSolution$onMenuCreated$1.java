package tv.danmaku.bili.ui.main2.mine.provider;

import android.content.Context;
import com.bilibili.biligame.GameCenterService;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.badge.BadgeManager;
import com.bilibili.lib.homepage.mine.MenuGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: GameCenterMineSolution.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.provider.GameMineMenuItemSolution$onMenuCreated$1", f = "GameCenterMineSolution.kt", i = {}, l = {BR.btnBgColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GameMineMenuItemSolution$onMenuCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GameCenterService $gameCenterService;
    final /* synthetic */ MenuGroup.Item $item;
    int label;
    final /* synthetic */ GameMineMenuItemSolution this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameMineMenuItemSolution$onMenuCreated$1(GameCenterService gameCenterService, Context context, GameMineMenuItemSolution gameMineMenuItemSolution, MenuGroup.Item item, Continuation<? super GameMineMenuItemSolution$onMenuCreated$1> continuation) {
        super(2, continuation);
        this.$gameCenterService = gameCenterService;
        this.$context = context;
        this.this$0 = gameMineMenuItemSolution;
        this.$item = item;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameMineMenuItemSolution$onMenuCreated$1(this.$gameCenterService, this.$context, this.this$0, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.collectLatest(this.$gameCenterService.getGameUpdateAndDownloadCounts(this.$context), new AnonymousClass1(this.this$0, this.$item, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameCenterMineSolution.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.provider.GameMineMenuItemSolution$onMenuCreated$1$1", f = "GameCenterMineSolution.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.mine.provider.GameMineMenuItemSolution$onMenuCreated$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ MenuGroup.Item $item;
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ GameMineMenuItemSolution this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GameMineMenuItemSolution gameMineMenuItemSolution, MenuGroup.Item item, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = gameMineMenuItemSolution;
            this.$item = item;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$item, continuation);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        public final Object invoke(int i, Continuation<? super Unit> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation) obj2);
        }

        public final Object invokeSuspend(Object obj) {
            MenuGroup.Item item;
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    int it = this.I$0;
                    BLog.d("GameCenterMineSolution", "badge server refresh: " + it);
                    BadgeManager badgeManager = BadgeManager.getInstance();
                    item = this.this$0.mItem;
                    if (item == null || (str = item.uri) == null) {
                        str = this.$item.uri;
                    }
                    badgeManager.update(str, Badge.obtainNumber(RangesKt.coerceAtMost(it, 99), 99));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}