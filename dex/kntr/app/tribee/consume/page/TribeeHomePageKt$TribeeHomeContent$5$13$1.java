package kntr.app.tribee.consume.page;

import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import java.util.Iterator;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: TribeeHomePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$13$1", f = "TribeeHomePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomePageKt$TribeeHomeContent$5$13$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KTribeeBaseInfo $basicInfo;
    final /* synthetic */ String $fromSpmid;
    final /* synthetic */ TribeeHomeContentState $pageState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomePageKt$TribeeHomeContent$5$13$1(String str, KTribeeBaseInfo kTribeeBaseInfo, TribeeHomeContentState tribeeHomeContentState, Continuation<? super TribeeHomePageKt$TribeeHomeContent$5$13$1> continuation) {
        super(2, continuation);
        this.$fromSpmid = str;
        this.$basicInfo = kTribeeBaseInfo;
        this.$pageState = tribeeHomeContentState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeHomePageKt$TribeeHomeContent$5$13$1(this.$fromSpmid, this.$basicInfo, this.$pageState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Object obj;
        boolean z;
        KTribeeDesc tribeeInfo;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str2 = this.$fromSpmid;
                KTribeeBaseInfo kTribeeBaseInfo = this.$basicInfo;
                String str3 = null;
                if (kTribeeBaseInfo == null || (tribeeInfo = kTribeeBaseInfo.getTribeeInfo()) == null) {
                    str = null;
                } else {
                    str = String.valueOf(tribeeInfo.getId());
                }
                if (str == null) {
                    str = "";
                }
                long categoryId = this.$pageState.getCategoryId();
                TribeeHomeContentState tribeeHomeContentState = this.$pageState;
                Iterator<T> it = this.$pageState.getCategoryList().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                    } else {
                        obj = it.next();
                        KTribeeCategory key = (KTribeeCategory) obj;
                        if (key.getId() == tribeeHomeContentState.getCategoryId()) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                        }
                    }
                }
                KTribeeCategory kTribeeCategory = (KTribeeCategory) obj;
                if (kTribeeCategory != null) {
                    str3 = kTribeeCategory.getName();
                }
                TrackerKt.categoryContentExposure(str2, str, categoryId, str3 != null ? str3 : "");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}