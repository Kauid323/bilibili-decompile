package kntr.app.deepsearch.ui.cards;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCardItem;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.Map;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.PicRect;
import kntr.app.deepsearch.base.model.biz.PicTransaction;
import kntr.app.deepsearch.base.model.biz.TransactionsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Picture.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.cards.PictureKt$Pic$1$1$1", f = "Picture.kt", i = {0, 0, 0, 0, 0, 0}, l = {363}, m = "invokeSuspend", n = {"it", "picDataKey", "rectAreaKey", "picIndex", "uri", "$i$a$-let-PictureKt$Pic$1$1$1$1"}, s = {"L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, v = 1)
public final class PictureKt$Pic$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $clicked$delegate;
    final /* synthetic */ Function1<DeepSearchAction, Unit> $dispatcher;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ FocusRequester $fq;
    final /* synthetic */ int $index;
    final /* synthetic */ KPictureCardItem $item;
    final /* synthetic */ KPictureCard $pic;
    final /* synthetic */ String $queryId;
    final /* synthetic */ Map<Integer, PicRect> $rect;
    final /* synthetic */ Router $route;
    final /* synthetic */ String $sessionId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PictureKt$Pic$1$1$1(KPictureCardItem kPictureCardItem, MutableState<Boolean> mutableState, Function1<? super DeepSearchAction, Unit> function1, KPictureCard kPictureCard, String str, Map<Integer, PicRect> map, int i, String str2, Router router, FocusManager focusManager, FocusRequester focusRequester, Continuation<? super PictureKt$Pic$1$1$1> continuation) {
        super(2, continuation);
        this.$item = kPictureCardItem;
        this.$clicked$delegate = mutableState;
        this.$dispatcher = function1;
        this.$pic = kPictureCard;
        this.$queryId = str;
        this.$rect = map;
        this.$index = i;
        this.$sessionId = str2;
        this.$route = router;
        this.$focusManager = focusManager;
        this.$fq = focusRequester;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PictureKt$Pic$1$1$1(this.$item, this.$clicked$delegate, this.$dispatcher, this.$pic, this.$queryId, this.$rect, this.$index, this.$sessionId, this.$route, this.$focusManager, this.$fq, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [boolean, int] */
    public final Object invokeSuspend(Object $result) {
        boolean Pic$lambda$1;
        KPictureCardItem it;
        MutableState<Boolean> mutableState;
        ?? r8;
        FocusManager focusManager;
        FocusRequester focusRequester;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pic$lambda$1 = PictureKt.Pic$lambda$1(this.$clicked$delegate);
                if (!Pic$lambda$1 && (it = this.$item) != null) {
                    Function1<DeepSearchAction, Unit> function1 = this.$dispatcher;
                    KPictureCard kPictureCard = this.$pic;
                    String str = this.$queryId;
                    Map<Integer, PicRect> map = this.$rect;
                    int i = this.$index;
                    String str2 = this.$sessionId;
                    Router router = this.$route;
                    FocusManager focusManager2 = this.$focusManager;
                    FocusRequester focusRequester2 = this.$fq;
                    mutableState = this.$clicked$delegate;
                    function1.invoke(new DeepSearchAction.TrackerAction.PictureClick(kPictureCard.getSource(), kPictureCard.getBizId(), str));
                    String picDataKey = PicTransaction.INSTANCE.recordPic(kPictureCard);
                    String rectAreaKey = PicTransaction.INSTANCE.recordArea(map);
                    String picIndex = String.valueOf(i);
                    Uri uri = UrisKt.toUri(TransactionsKt.DEEP_SEARCH_ACTIVITY_MEDIA_VIEWER).buildUpon().appendQueryParameter("index", picIndex).appendQueryParameter("data", picDataKey).appendQueryParameter("rect", rectAreaKey).appendQueryParameter("sessionId", str2).appendQueryParameter("queryId", str).build();
                    router.launch(uri);
                    PictureKt.Pic$lambda$2(mutableState, true);
                    Duration.Companion companion = Duration.Companion;
                    long duration = DurationKt.toDuration(300L, DurationUnit.MILLISECONDS);
                    this.L$0 = focusManager2;
                    this.L$1 = focusRequester2;
                    this.L$2 = mutableState;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(picDataKey);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(rectAreaKey);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(picIndex);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(uri);
                    this.I$0 = 0;
                    r8 = 1;
                    this.label = 1;
                    if (DelayKt.delay-VtjQ1oo(duration, this) != coroutine_suspended) {
                        focusManager = focusManager2;
                        focusRequester = focusRequester2;
                        PictureKt.Pic$lambda$2(mutableState, false);
                        focusManager.clearFocus((boolean) r8);
                        FocusRequester.requestFocus-3ESFkO8$default(focusRequester, 0, (int) r8, (Object) null);
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i2 = this.I$0;
                Uri uri2 = (Uri) this.L$7;
                String str3 = (String) this.L$6;
                String str4 = (String) this.L$5;
                String str5 = (String) this.L$4;
                KPictureCardItem kPictureCardItem = (KPictureCardItem) this.L$3;
                focusRequester = (FocusRequester) this.L$1;
                focusManager = (FocusManager) this.L$0;
                ResultKt.throwOnFailure($result);
                mutableState = (MutableState) this.L$2;
                r8 = 1;
                PictureKt.Pic$lambda$2(mutableState, false);
                focusManager.clearFocus((boolean) r8);
                FocusRequester.requestFocus-3ESFkO8$default(focusRequester, 0, (int) r8, (Object) null);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}