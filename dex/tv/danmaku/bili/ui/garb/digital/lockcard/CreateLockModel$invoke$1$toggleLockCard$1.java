package tv.danmaku.bili.ui.garb.digital.lockcard;

import android.content.Context;
import com.bilibili.bson.dsl.JsonObjectBuilder;
import com.bilibili.droid.ToastHelper;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.bilibili.okretro.response.BiliApiResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.nft.api.DLCApiService;

/* compiled from: CreateLockModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.digital.lockcard.CreateLockModel$invoke$1$toggleLockCard$1", f = "CreateLockModel.kt", i = {}, l = {BR.bottomDesc}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CreateLockModel$invoke$1$toggleLockCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $actId;
    final /* synthetic */ long $cardId;
    final /* synthetic */ String $cardNo;
    final /* synthetic */ long $cardTypeId;
    final /* synthetic */ boolean $toggleCardLocked;
    int label;
    final /* synthetic */ CreateLockModel this$0;
    final /* synthetic */ CreateLockModel$invoke$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateLockModel$invoke$1$toggleLockCard$1(CreateLockModel createLockModel, boolean z, long j, long j2, String str, long j3, CreateLockModel$invoke$1 createLockModel$invoke$1, Continuation<? super CreateLockModel$invoke$1$toggleLockCard$1> continuation) {
        super(2, continuation);
        this.this$0 = createLockModel;
        this.$toggleCardLocked = z;
        this.$actId = j;
        this.$cardTypeId = j2;
        this.$cardNo = str;
        this.$cardId = j3;
        this.this$1 = createLockModel$invoke$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateLockModel$invoke$1$toggleLockCard$1(this.this$0, this.$toggleCardLocked, this.$actId, this.$cardTypeId, this.$cardNo, this.$cardId, this.this$1, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DLCApiService dLCApiService;
        Object $result;
        MutableStateFlow mutableStateFlow;
        Context context;
        Context context2;
        Context context3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                boolean z = this.$toggleCardLocked;
                long j = this.$actId;
                long j2 = this.$cardTypeId;
                String str = this.$cardNo;
                long j3 = this.$cardId;
                JsonObject jsonObject$iv$iv = JsonObjectBuilder.constructor-impl(new JsonObject());
                JsonObjectBuilder.kv-impl(jsonObject$iv$iv, "operate", Boxing.boxInt(z ? 1 : 2));
                JsonElement jsonElement = JsonObjectBuilder.constructor-impl(new JsonObject());
                JsonObjectBuilder.kv-impl(jsonElement, "act_id", Boxing.boxLong(j));
                JsonObjectBuilder.kv-impl(jsonElement, "card_type_id", Boxing.boxLong(j2));
                JsonObjectBuilder.kv-impl(jsonElement, "card_number", str);
                Unit unit = Unit.INSTANCE;
                JsonObjectBuilder.kv-impl(jsonObject$iv$iv, "card_uk_to_lock", jsonElement);
                JsonElement jsonArray = new JsonArray();
                jsonArray.add(Boxing.boxLong(j3));
                Unit unit2 = Unit.INSTANCE;
                JsonObjectBuilder.kv-impl(jsonObject$iv$iv, "card_ids_to_lock", jsonArray);
                String jsonStr = JsonUtilKt.toJson(jsonObject$iv$iv);
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonStr);
                dLCApiService = this.this$0.service;
                Intrinsics.checkNotNull(requestBody);
                this.label = 1;
                Object obj2 = dLCApiService.toggleDlcLockCard(requestBody, (Continuation) this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj2;
                break;
            case 1:
                $result = obj;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BiliApiResponse.BusinessFailure businessFailure = (BiliApiResponse) $result;
        CreateLockModel$invoke$1 createLockModel$invoke$1 = this.this$1;
        boolean z2 = this.$toggleCardLocked;
        CreateLockModel createLockModel = this.this$0;
        long j4 = this.$cardId;
        CreateLockModel createLockModel2 = this.this$0;
        CreateLockModel createLockModel3 = this.this$0;
        if (businessFailure instanceof BiliApiResponse.BusinessFailure) {
            BiliApiResponse.BusinessFailure $this$invokeSuspend_u24lambda_u242 = businessFailure;
            context3 = createLockModel2.context;
            String message = $this$invokeSuspend_u24lambda_u242.getMessage();
            ToastHelper.showToast(context3, message != null ? message : "锁定失败，请重试", 0, 17);
        } else if (businessFailure instanceof BiliApiResponse.ServiceUnavailable) {
            ((BiliApiResponse.ServiceUnavailable) businessFailure).getException();
            context2 = createLockModel3.context;
            ToastHelper.showToast(context2, "锁定失败，请重试", 0, 17);
        } else if (businessFailure instanceof BiliApiResponse.Success) {
            Unit unit3 = (Unit) ((BiliApiResponse.Success) businessFailure).getData();
            createLockModel$invoke$1.setLockStatus(z2 ? CardLockStatus.LOCKED : CardLockStatus.UNLOCKED);
            String toastText = z2 ? "锁定成功，卡牌将不可分解" : "解锁成功";
            mutableStateFlow = createLockModel.cardLockStateChangedFlow;
            mutableStateFlow.setValue(new Pair(Boxing.boxLong(j4), createLockModel$invoke$1.getLockStatus()));
            context = createLockModel.context;
            ToastHelper.showToast(context, toastText, 0, 17);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}