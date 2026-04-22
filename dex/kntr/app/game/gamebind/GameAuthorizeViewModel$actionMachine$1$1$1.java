package kntr.app.game.gamebind;

import com.bilibili.biligame.kntr.common.api.BiligameApiException;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.gamebind.AuthorizeAction;
import kntr.app.game.gamebind.AuthorizeEvent;
import kntr.app.game.gamebind.GameBindEvent;
import kntr.app.game.gamebind.bean.AuthorizeParams;
import kntr.app.game.gamebind.bean.BindResult;
import kntr.app.game.gamebind.bean.TokenlinkData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameAuthorizeViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/AuthorizeAction;", "event", "Lkntr/app/game/gamebind/AuthorizeEvent$Bind;", "action", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1", f = "GameAuthorizeViewModel.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5}, l = {83, 86, 89, 91, 99, 101}, m = "invokeSuspend", n = {"event", "action", "event", "action", "event", "action", "event", "action", "tokenLink", "event", "action", "event", "action", "bindResult"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
public final class GameAuthorizeViewModel$actionMachine$1$1$1 extends SuspendLambda implements Function3<AuthorizeEvent.Bind, State<AuthorizeAction>, Continuation<? super ChangedState<? extends AuthorizeAction>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ GameAuthorizeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameAuthorizeViewModel$actionMachine$1$1$1(GameAuthorizeViewModel gameAuthorizeViewModel, Continuation<? super GameAuthorizeViewModel$actionMachine$1$1$1> continuation) {
        super(3, continuation);
        this.this$0 = gameAuthorizeViewModel;
    }

    public final Object invoke(AuthorizeEvent.Bind bind, State<AuthorizeAction> state, Continuation<? super ChangedState<? extends AuthorizeAction>> continuation) {
        GameAuthorizeViewModel$actionMachine$1$1$1 gameAuthorizeViewModel$actionMachine$1$1$1 = new GameAuthorizeViewModel$actionMachine$1$1$1(this.this$0, continuation);
        gameAuthorizeViewModel$actionMachine$1$1$1.L$0 = bind;
        gameAuthorizeViewModel$actionMachine$1$1$1.L$1 = state;
        return gameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
        return r1.override(new kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda2(r3));
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:7:0x001e, B:63:0x016f, B:8:0x0023, B:57:0x0145, B:59:0x014d, B:64:0x017c, B:11:0x002d, B:42:0x00eb, B:12:0x0032, B:36:0x00c1, B:38:0x00c9, B:43:0x00f9, B:45:0x0101, B:50:0x010b, B:51:0x0116, B:13:0x0038, B:30:0x0093, B:14:0x003c, B:25:0x006c, B:27:0x0079, B:31:0x009e, B:33:0x00aa, B:52:0x0122, B:54:0x012e, B:65:0x0188, B:19:0x0047, B:21:0x004d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:7:0x001e, B:63:0x016f, B:8:0x0023, B:57:0x0145, B:59:0x014d, B:64:0x017c, B:11:0x002d, B:42:0x00eb, B:12:0x0032, B:36:0x00c1, B:38:0x00c9, B:43:0x00f9, B:45:0x0101, B:50:0x010b, B:51:0x0116, B:13:0x0038, B:30:0x0093, B:14:0x003c, B:25:0x006c, B:27:0x0079, B:31:0x009e, B:33:0x00aa, B:52:0x0122, B:54:0x012e, B:65:0x0188, B:19:0x0047, B:21:0x004d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:7:0x001e, B:63:0x016f, B:8:0x0023, B:57:0x0145, B:59:0x014d, B:64:0x017c, B:11:0x002d, B:42:0x00eb, B:12:0x0032, B:36:0x00c1, B:38:0x00c9, B:43:0x00f9, B:45:0x0101, B:50:0x010b, B:51:0x0116, B:13:0x0038, B:30:0x0093, B:14:0x003c, B:25:0x006c, B:27:0x0079, B:31:0x009e, B:33:0x00aa, B:52:0x0122, B:54:0x012e, B:65:0x0188, B:19:0x0047, B:21:0x004d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:7:0x001e, B:63:0x016f, B:8:0x0023, B:57:0x0145, B:59:0x014d, B:64:0x017c, B:11:0x002d, B:42:0x00eb, B:12:0x0032, B:36:0x00c1, B:38:0x00c9, B:43:0x00f9, B:45:0x0101, B:50:0x010b, B:51:0x0116, B:13:0x0038, B:30:0x0093, B:14:0x003c, B:25:0x006c, B:27:0x0079, B:31:0x009e, B:33:0x00aa, B:52:0x0122, B:54:0x012e, B:65:0x0188, B:19:0x0047, B:21:0x004d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014d A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:7:0x001e, B:63:0x016f, B:8:0x0023, B:57:0x0145, B:59:0x014d, B:64:0x017c, B:11:0x002d, B:42:0x00eb, B:12:0x0032, B:36:0x00c1, B:38:0x00c9, B:43:0x00f9, B:45:0x0101, B:50:0x010b, B:51:0x0116, B:13:0x0038, B:30:0x0093, B:14:0x003c, B:25:0x006c, B:27:0x0079, B:31:0x009e, B:33:0x00aa, B:52:0x0122, B:54:0x012e, B:65:0x0188, B:19:0x0047, B:21:0x004d), top: B:79:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017c A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:7:0x001e, B:63:0x016f, B:8:0x0023, B:57:0x0145, B:59:0x014d, B:64:0x017c, B:11:0x002d, B:42:0x00eb, B:12:0x0032, B:36:0x00c1, B:38:0x00c9, B:43:0x00f9, B:45:0x0101, B:50:0x010b, B:51:0x0116, B:13:0x0038, B:30:0x0093, B:14:0x003c, B:25:0x006c, B:27:0x0079, B:31:0x009e, B:33:0x00aa, B:52:0x0122, B:54:0x012e, B:65:0x0188, B:19:0x0047, B:21:0x004d), top: B:79:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChangedState override;
        Object authorize;
        AuthorizeParams authorizeParams;
        AuthorizeParams authorizeParams2;
        AuthorizeParams authorizeParams3;
        Object realBind;
        Object tokenLink;
        final TokenlinkData tokenLink2;
        BindResult bindResult;
        AuthorizeEvent.Bind event = (AuthorizeEvent.Bind) this.L$0;
        State action = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (event.getAuthorizeInfo() != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                        this.L$1 = action;
                        this.label = 1;
                        authorize = this.this$0.authorize(event.isAll(), event.getAuthorizeInfo(), (Continuation) this);
                        if (authorize == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    authorizeParams = this.this$0.authorizeParams;
                    if (!authorizeParams.getOnlyAuth()) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                        this.L$1 = action;
                        this.label = 2;
                        if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                AuthorizeAction.Close invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$0((AuthorizeAction) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    }
                    authorizeParams2 = this.this$0.authorizeParams;
                    if (authorizeParams2.getBindMethodType() != 2) {
                        authorizeParams3 = this.this$0.authorizeParams;
                        if (authorizeParams3.getBindMethodType() == 1) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = action;
                            this.label = 5;
                            realBind = this.this$0.realBind((Continuation) this);
                            if (realBind == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bindResult = (BindResult) realBind;
                            if (bindResult.getBind()) {
                                final GameAuthorizeViewModel gameAuthorizeViewModel = this.this$0;
                                return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj) {
                                        AuthorizeAction.Close invokeSuspend$lambda$5;
                                        invokeSuspend$lambda$5 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$5(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                                        return invokeSuspend$lambda$5;
                                    }
                                });
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = action;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(bindResult);
                            this.label = 6;
                            if (GameBindEventStore.INSTANCE.post(GameBindEvent.Bind.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            final GameAuthorizeViewModel gameAuthorizeViewModel2 = this.this$0;
                            return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    AuthorizeAction.Close invokeSuspend$lambda$4;
                                    invokeSuspend$lambda$4 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$4(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                                    return invokeSuspend$lambda$4;
                                }
                            });
                        }
                        return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                AuthorizeAction.Close invokeSuspend$lambda$6;
                                invokeSuspend$lambda$6 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$6((AuthorizeAction) obj);
                                return invokeSuspend$lambda$6;
                            }
                        });
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = action;
                    this.label = 3;
                    tokenLink = this.this$0.getTokenLink((Continuation) this);
                    if (tokenLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tokenLink2 = (TokenlinkData) tokenLink;
                    if (tokenLink2.getBind()) {
                        String bindUrl = tokenLink2.getBindUrl();
                        if (bindUrl != null && !StringsKt.isBlank(bindUrl)) {
                            z = false;
                            break;
                        }
                        final GameAuthorizeViewModel gameAuthorizeViewModel3 = this.this$0;
                        return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj) {
                                AuthorizeAction.Close invokeSuspend$lambda$3;
                                invokeSuspend$lambda$3 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$3(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                                return invokeSuspend$lambda$3;
                            }
                        });
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = action;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(tokenLink2);
                    this.label = 4;
                    if (GameBindEventStore.INSTANCE.post(GameBindEvent.Bind.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    final GameAuthorizeViewModel gameAuthorizeViewModel4 = this.this$0;
                    return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            AuthorizeAction.Close invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$1(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                case 1:
                    ResultKt.throwOnFailure($result);
                    authorizeParams = this.this$0.authorizeParams;
                    if (!authorizeParams.getOnlyAuth()) {
                    }
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            AuthorizeAction.Close invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$0((AuthorizeAction) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                case 3:
                    ResultKt.throwOnFailure($result);
                    tokenLink = $result;
                    tokenLink2 = (TokenlinkData) tokenLink;
                    if (tokenLink2.getBind()) {
                    }
                    break;
                case 4:
                    TokenlinkData tokenlinkData = (TokenlinkData) this.L$2;
                    ResultKt.throwOnFailure($result);
                    final GameAuthorizeViewModel gameAuthorizeViewModel42 = this.this$0;
                    return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            AuthorizeAction.Close invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$1(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                case 5:
                    ResultKt.throwOnFailure($result);
                    realBind = $result;
                    bindResult = (BindResult) realBind;
                    if (bindResult.getBind()) {
                    }
                    break;
                case 6:
                    BindResult bindResult2 = (BindResult) this.L$2;
                    ResultKt.throwOnFailure($result);
                    final GameAuthorizeViewModel gameAuthorizeViewModel22 = this.this$0;
                    return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            AuthorizeAction.Close invokeSuspend$lambda$4;
                            invokeSuspend$lambda$4 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$4(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                            return invokeSuspend$lambda$4;
                        }
                    });
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            if (!(th instanceof BiligameApiException)) {
                final GameAuthorizeViewModel gameAuthorizeViewModel5 = this.this$0;
                override = action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        AuthorizeAction.Close invokeSuspend$lambda$9;
                        invokeSuspend$lambda$9 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$9(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                        return invokeSuspend$lambda$9;
                    }
                });
            } else if (th.getCode() == -8004 || th.getCode() == -8009) {
                override = action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        AuthorizeAction.NoRoleInfo invokeSuspend$lambda$7;
                        invokeSuspend$lambda$7 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$7((AuthorizeAction) obj);
                        return invokeSuspend$lambda$7;
                    }
                });
            } else {
                final GameAuthorizeViewModel gameAuthorizeViewModel6 = this.this$0;
                override = action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$1$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        AuthorizeAction.Close invokeSuspend$lambda$8;
                        invokeSuspend$lambda$8 = GameAuthorizeViewModel$actionMachine$1$1$1.invokeSuspend$lambda$8(GameAuthorizeViewModel.this, th, (AuthorizeAction) obj);
                        return invokeSuspend$lambda$8;
                    }
                });
            }
            return override;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$0(AuthorizeAction $this$override) {
        return new AuthorizeAction.Close("授权成功");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$1(GameAuthorizeViewModel this$0, AuthorizeAction $this$override) {
        String bindSuccessToast;
        bindSuccessToast = this$0.bindSuccessToast();
        return new AuthorizeAction.Close(bindSuccessToast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.GoBindTencent invokeSuspend$lambda$2(TokenlinkData $tokenLink, AuthorizeAction $this$override) {
        return new AuthorizeAction.GoBindTencent($tokenLink.getBindUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$3(GameAuthorizeViewModel this$0, AuthorizeAction $this$override) {
        return new AuthorizeAction.Close(GameAuthorizeViewModel.mapCodeToMessage$default(this$0, -1, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$4(GameAuthorizeViewModel this$0, AuthorizeAction $this$override) {
        String bindSuccessToast;
        bindSuccessToast = this$0.bindSuccessToast();
        return new AuthorizeAction.Close(bindSuccessToast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$5(GameAuthorizeViewModel this$0, AuthorizeAction $this$override) {
        return new AuthorizeAction.Close(GameAuthorizeViewModel.mapCodeToMessage$default(this$0, -1, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$6(AuthorizeAction $this$override) {
        return new AuthorizeAction.Close(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.NoRoleInfo invokeSuspend$lambda$7(AuthorizeAction $this$override) {
        return AuthorizeAction.NoRoleInfo.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$8(GameAuthorizeViewModel this$0, Throwable $e, AuthorizeAction $this$override) {
        String mapCodeToMessage;
        mapCodeToMessage = this$0.mapCodeToMessage(((BiligameApiException) $e).getCode(), $e.getMessage());
        return new AuthorizeAction.Close(mapCodeToMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$9(GameAuthorizeViewModel this$0, AuthorizeAction $this$override) {
        return new AuthorizeAction.Close(GameAuthorizeViewModel.mapCodeToMessage$default(this$0, -1, null, 2, null));
    }
}