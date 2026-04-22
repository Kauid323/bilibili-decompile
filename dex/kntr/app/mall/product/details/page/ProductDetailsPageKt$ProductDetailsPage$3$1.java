package kntr.app.mall.product.details.page;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvEventTriggerKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: ProductDetailsPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ProductDetailsPageKt$ProductDetailsPage$3$1", f = "ProductDetailsPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ProductDetailsPageKt$ProductDetailsPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ String $is_ad;
    final /* synthetic */ String $itemsId;
    final /* synthetic */ String $msource;
    final /* synthetic */ PvEventTrigger $pvTrigger;
    final /* synthetic */ String $track_id;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsPageKt$ProductDetailsPage$3$1(String str, String str2, String str3, String str4, String str5, PvEventTrigger pvEventTrigger, Continuation<? super ProductDetailsPageKt$ProductDetailsPage$3$1> continuation) {
        super(2, continuation);
        this.$itemsId = str;
        this.$from = str2;
        this.$msource = str3;
        this.$track_id = str4;
        this.$is_ad = str5;
        this.$pvTrigger = pvEventTrigger;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailsPageKt$ProductDetailsPage$3$1(this.$itemsId, this.$from, this.$msource, this.$track_id, this.$is_ad, this.$pvTrigger, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair[] pairArr = new Pair[5];
                String str = this.$itemsId;
                if (str == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("itemsId", str);
                String str2 = this.$from;
                if (str2 == null) {
                    str2 = "";
                }
                pairArr[1] = TuplesKt.to("from", str2);
                String str3 = this.$msource;
                if (str3 == null) {
                    str3 = "";
                }
                pairArr[2] = TuplesKt.to("msource", str3);
                String str4 = this.$track_id;
                if (str4 == null) {
                    str4 = "";
                }
                pairArr[3] = TuplesKt.to("track_id", str4);
                Object obj = this.$is_ad;
                if (obj == null) {
                    obj = Boxing.boxBoolean(false);
                }
                pairArr[4] = TuplesKt.to("is_ad", obj.toString());
                Map msgMap = MapsKt.mapOf(pairArr);
                StringFormat $this$encodeToString$iv = Json.Default;
                $this$encodeToString$iv.getSerializersModule();
                String msgString = $this$encodeToString$iv.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), msgMap);
                PvEventTriggerKt.updateExtra(this.$pvTrigger, "msg", msgString);
                PvEventTrigger pvEventTrigger = this.$pvTrigger;
                String str5 = this.$itemsId;
                if (str5 == null) {
                    str5 = "";
                }
                PvEventTriggerKt.updateExtra(pvEventTrigger, "itemsId", str5);
                PvEventTrigger pvEventTrigger2 = this.$pvTrigger;
                String str6 = this.$msource;
                if (str6 == null) {
                    str6 = "";
                }
                PvEventTriggerKt.updateExtra(pvEventTrigger2, "msource", str6);
                PvEventTrigger pvEventTrigger3 = this.$pvTrigger;
                String str7 = this.$track_id;
                if (str7 == null) {
                    str7 = "";
                }
                PvEventTriggerKt.updateExtra(pvEventTrigger3, "track_id", str7);
                PvEventTrigger pvEventTrigger4 = this.$pvTrigger;
                String str8 = this.$from;
                PvEventTriggerKt.updateExtra(pvEventTrigger4, "from", str8 != null ? str8 : "");
                PvEventTrigger pvEventTrigger5 = this.$pvTrigger;
                Object obj2 = this.$is_ad;
                if (obj2 == null) {
                    obj2 = Boxing.boxBoolean(false);
                }
                PvEventTriggerKt.updateExtra(pvEventTrigger5, "is_ad", obj2.toString());
                PvEventTriggerKt.updateExtra(this.$pvTrigger, "is_na", "1");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}