package kntr.app.im.chat.service.personal;

import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSetChatSettingsReply;
import com.bapis.bilibili.app.im.v1.KSetChatSettingsReq;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingSwitch;
import com.bapis.bilibili.app.im.v1.KSwitchConfirmDialog;
import com.bapis.bilibili.relation.interfaces.KAct;
import com.bapis.bilibili.relation.interfaces.KFollowingReq;
import com.bapis.bilibili.relation.interfaces.KModifyRelationReply;
import com.bapis.bilibili.relation.interfaces.KRelationInterfaceMoss;
import im.base.IMLog;
import javax.inject.Inject;
import kntr.app.im.chat.core.service.ConversationService;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: ConversationServiceImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0096@¢\u0006\u0004\b\u0011\u0010\u000eJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\u0013\u0010\u000eJ&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/service/personal/ConversationServiceImpl;", "Lkntr/app/im/chat/core/service/ConversationService;", "sessionId", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "kSessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "chatInfoService", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "<init>", "(Lkntr/app/im/chat/di/module/personal/PersonalChat;Lcom/bapis/bilibili/app/im/v1/KSessionId;Lkntr/app/im/chat/core/service/FusionChatInfoService;)V", "blockUser", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "blockUser-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "followUser", RoomRecommendViewModel.EMPTY_CURSOR, "followUser-IoAF18A", "disallowPush", "disallowPush-IoAF18A", "setChatSetting", "type", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "switchOn", RoomRecommendViewModel.EMPTY_CURSOR, "setChatSetting-0E7RQCE", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationServiceImpl implements ConversationService {
    public static final int $stable = 8;
    private final FusionChatInfoService chatInfoService;
    private final KSessionId kSessionId;
    private final PersonalChat sessionId;

    @Inject
    public ConversationServiceImpl(PersonalChat sessionId, KSessionId kSessionId, FusionChatInfoService chatInfoService) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
        Intrinsics.checkNotNullParameter(chatInfoService, "chatInfoService");
        this.sessionId = sessionId;
        this.kSessionId = kSessionId;
        this.chatInfoService = chatInfoService;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    @Override // kntr.app.im.chat.core.service.ConversationService
    /* renamed from: blockUser-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1354blockUserIoAF18A(Continuation<? super Result<String>> continuation) {
        ConversationServiceImpl$blockUser$1 conversationServiceImpl$blockUser$1;
        if (continuation instanceof ConversationServiceImpl$blockUser$1) {
            conversationServiceImpl$blockUser$1 = (ConversationServiceImpl$blockUser$1) continuation;
            if ((conversationServiceImpl$blockUser$1.label & Integer.MIN_VALUE) != 0) {
                conversationServiceImpl$blockUser$1.label -= Integer.MIN_VALUE;
                Object $result = conversationServiceImpl$blockUser$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (conversationServiceImpl$blockUser$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        conversationServiceImpl$blockUser$1.label = 1;
                        Object m1587setChatSetting0E7RQCE = m1587setChatSetting0E7RQCE((KIMSettingType) KIMSettingType.SETTING_TYPE_BLOCK_USER.INSTANCE, true, conversationServiceImpl$blockUser$1);
                        return m1587setChatSetting0E7RQCE == coroutine_suspended ? coroutine_suspended : m1587setChatSetting0E7RQCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        conversationServiceImpl$blockUser$1 = new ConversationServiceImpl$blockUser$1(this, continuation);
        Object $result2 = conversationServiceImpl$blockUser$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (conversationServiceImpl$blockUser$1.label) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|8|21|22|(2:24|(1:26)(2:27|13))|14|(0)|17))|35|6|7|8|21|22|(0)|14|(0)|17) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ab, code lost:
        r9 = kotlin.Result.Companion;
        r0 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ec  */
    @Override // kntr.app.im.chat.core.service.ConversationService
    /* renamed from: followUser-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1356followUserIoAF18A(Continuation<? super Result<Unit>> continuation) {
        ConversationServiceImpl$followUser$1 conversationServiceImpl$followUser$1;
        ConversationServiceImpl$followUser$1 conversationServiceImpl$followUser$12;
        Object obj;
        Throwable it;
        Object modifyRelation;
        if (continuation instanceof ConversationServiceImpl$followUser$1) {
            conversationServiceImpl$followUser$1 = (ConversationServiceImpl$followUser$1) continuation;
            if ((conversationServiceImpl$followUser$1.label & Integer.MIN_VALUE) != 0) {
                conversationServiceImpl$followUser$1.label -= Integer.MIN_VALUE;
                conversationServiceImpl$followUser$12 = conversationServiceImpl$followUser$1;
                Object $result = conversationServiceImpl$followUser$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (conversationServiceImpl$followUser$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i("ConversationService", "Follow user " + this.sessionId.getTalkerUid());
                        Result.Companion companion = Result.Companion;
                        KRelationInterfaceMoss kRelationInterfaceMoss = new KRelationInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KFollowingReq kFollowingReq = new KFollowingReq(this.sessionId.getTalkerUid(), KAct.ACT_ADD_FOLLOWING.INSTANCE, 71, (String) null, (String) null, (String) null, (String) null, (String) null, 248, (DefaultConstructorMarker) null);
                        conversationServiceImpl$followUser$12.I$0 = 0;
                        conversationServiceImpl$followUser$12.I$1 = 0;
                        conversationServiceImpl$followUser$12.label = 1;
                        modifyRelation = kRelationInterfaceMoss.modifyRelation(kFollowingReq, conversationServiceImpl$followUser$12);
                        if (modifyRelation == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        int i = conversationServiceImpl$followUser$12.I$1;
                        int i2 = conversationServiceImpl$followUser$12.I$0;
                        ResultKt.throwOnFailure($result);
                        modifyRelation = $result;
                        break;
                    case 2:
                        int i3 = conversationServiceImpl$followUser$12.I$0;
                        KModifyRelationReply kModifyRelationReply = (KModifyRelationReply) conversationServiceImpl$followUser$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = Unit.INSTANCE;
                        Object obj2 = Result.constructor-impl(obj);
                        it = Result.exceptionOrNull-impl(obj2);
                        if (it != null) {
                            IMLog.Companion.e("ConversationService", "Fail to follow user", it);
                        }
                        return obj2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KModifyRelationReply) modifyRelation);
                JobKt.ensureActive(conversationServiceImpl$followUser$12.getContext());
                if (Result.isSuccess-impl(obj)) {
                    Result.Companion companion2 = Result.Companion;
                    FusionChatInfoService fusionChatInfoService = this.chatInfoService;
                    conversationServiceImpl$followUser$12.L$0 = SpillingKt.nullOutSpilledVariable((KModifyRelationReply) obj);
                    conversationServiceImpl$followUser$12.I$0 = 0;
                    conversationServiceImpl$followUser$12.label = 2;
                    if (fusionChatInfoService.load(true, conversationServiceImpl$followUser$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = Unit.INSTANCE;
                }
                Object obj22 = Result.constructor-impl(obj);
                it = Result.exceptionOrNull-impl(obj22);
                if (it != null) {
                }
                return obj22;
            }
        }
        conversationServiceImpl$followUser$1 = new ConversationServiceImpl$followUser$1(this, continuation);
        conversationServiceImpl$followUser$12 = conversationServiceImpl$followUser$1;
        Object $result2 = conversationServiceImpl$followUser$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (conversationServiceImpl$followUser$12.label) {
        }
        obj = Result.constructor-impl((KModifyRelationReply) modifyRelation);
        JobKt.ensureActive(conversationServiceImpl$followUser$12.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
        Object obj222 = Result.constructor-impl(obj);
        it = Result.exceptionOrNull-impl(obj222);
        if (it != null) {
        }
        return obj222;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    @Override // kntr.app.im.chat.core.service.ConversationService
    /* renamed from: disallowPush-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1355disallowPushIoAF18A(Continuation<? super Result<String>> continuation) {
        ConversationServiceImpl$disallowPush$1 conversationServiceImpl$disallowPush$1;
        if (continuation instanceof ConversationServiceImpl$disallowPush$1) {
            conversationServiceImpl$disallowPush$1 = (ConversationServiceImpl$disallowPush$1) continuation;
            if ((conversationServiceImpl$disallowPush$1.label & Integer.MIN_VALUE) != 0) {
                conversationServiceImpl$disallowPush$1.label -= Integer.MIN_VALUE;
                Object $result = conversationServiceImpl$disallowPush$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (conversationServiceImpl$disallowPush$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        conversationServiceImpl$disallowPush$1.label = 1;
                        Object m1587setChatSetting0E7RQCE = m1587setChatSetting0E7RQCE((KIMSettingType) KIMSettingType.SETTING_TYPE_RECEIVE_PUSH.INSTANCE, false, conversationServiceImpl$disallowPush$1);
                        return m1587setChatSetting0E7RQCE == coroutine_suspended ? coroutine_suspended : m1587setChatSetting0E7RQCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).unbox-impl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        conversationServiceImpl$disallowPush$1 = new ConversationServiceImpl$disallowPush$1(this, continuation);
        Object $result2 = conversationServiceImpl$disallowPush$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (conversationServiceImpl$disallowPush$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* renamed from: setChatSetting-0E7RQCE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1587setChatSetting0E7RQCE(KIMSettingType type, boolean switchOn, Continuation<? super Result<String>> continuation) {
        ConversationServiceImpl$setChatSetting$1 conversationServiceImpl$setChatSetting$1;
        ConversationServiceImpl$setChatSetting$1 conversationServiceImpl$setChatSetting$12;
        Object chatSettings;
        Object obj;
        Throwable it;
        KIMSettingType type2 = type;
        if (continuation instanceof ConversationServiceImpl$setChatSetting$1) {
            conversationServiceImpl$setChatSetting$1 = (ConversationServiceImpl$setChatSetting$1) continuation;
            if ((conversationServiceImpl$setChatSetting$1.label & Integer.MIN_VALUE) != 0) {
                conversationServiceImpl$setChatSetting$1.label -= Integer.MIN_VALUE;
                conversationServiceImpl$setChatSetting$12 = conversationServiceImpl$setChatSetting$1;
                Object $result = conversationServiceImpl$setChatSetting$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (conversationServiceImpl$setChatSetting$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i("ConversationService", "Set chat setting " + type2 + " to " + switchOn);
                        try {
                            Result.Companion companion = Result.Companion;
                            KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            KSetChatSettingsReq kSetChatSettingsReq = new KSetChatSettingsReq(this.kSessionId, MapsKt.mapOf(TuplesKt.to(Boxing.boxInt(type.getValue()), new KSetting(new KSetting.KSwitch(new KSettingSwitch(switchOn, (String) null, (String) null, (KSwitchConfirmDialog) null, (KSwitchConfirmDialog) null, 30, (DefaultConstructorMarker) null))))));
                            conversationServiceImpl$setChatSetting$12.L$0 = type2;
                            conversationServiceImpl$setChatSetting$12.Z$0 = switchOn;
                            conversationServiceImpl$setChatSetting$12.I$0 = 0;
                            conversationServiceImpl$setChatSetting$12.I$1 = 0;
                            conversationServiceImpl$setChatSetting$12.label = 1;
                            chatSettings = kChatMoss.setChatSettings(kSetChatSettingsReq, conversationServiceImpl$setChatSetting$12);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(conversationServiceImpl$setChatSetting$12.getContext());
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                        if (chatSettings == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = Result.constructor-impl(((KSetChatSettingsReply) chatSettings).getToast());
                        JobKt.ensureActive(conversationServiceImpl$setChatSetting$12.getContext());
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            IMLog.Companion.e("ConversationService", "Fail to set chat setting " + type2, it);
                        }
                        return obj;
                    case 1:
                        int i = conversationServiceImpl$setChatSetting$12.I$1;
                        int i2 = conversationServiceImpl$setChatSetting$12.I$0;
                        boolean z = conversationServiceImpl$setChatSetting$12.Z$0;
                        type2 = (KIMSettingType) conversationServiceImpl$setChatSetting$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            chatSettings = $result;
                            obj = Result.constructor-impl(((KSetChatSettingsReply) chatSettings).getToast());
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(conversationServiceImpl$setChatSetting$12.getContext());
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                            }
                            return obj;
                        }
                        JobKt.ensureActive(conversationServiceImpl$setChatSetting$12.getContext());
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                        }
                        return obj;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        conversationServiceImpl$setChatSetting$1 = new ConversationServiceImpl$setChatSetting$1(this, continuation);
        conversationServiceImpl$setChatSetting$12 = conversationServiceImpl$setChatSetting$1;
        Object $result2 = conversationServiceImpl$setChatSetting$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (conversationServiceImpl$setChatSetting$12.label) {
        }
    }
}