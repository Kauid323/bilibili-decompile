package kntr.app.game.base.ui.container;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.Orientation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameComposeContainer.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/common/komponent/Orientation;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.container.GameComposeContainerActivity$applyKomponent$2", f = "GameComposeContainer.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class GameComposeContainerActivity$applyKomponent$2 extends SuspendLambda implements Function2<Orientation, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GameComposeContainerActivity this$0;

    /* compiled from: GameComposeContainer.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Unspecified.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.User.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Orientation.UserPortrait.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Orientation.Portrait.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Orientation.PortraitUpsideDown.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Orientation.UserLandscape.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Orientation.LandscapeHeadingRight.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Orientation.LandscapeHeadingLeft.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameComposeContainerActivity$applyKomponent$2(GameComposeContainerActivity gameComposeContainerActivity, Continuation<? super GameComposeContainerActivity$applyKomponent$2> continuation) {
        super(2, continuation);
        this.this$0 = gameComposeContainerActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> gameComposeContainerActivity$applyKomponent$2 = new GameComposeContainerActivity$applyKomponent$2(this.this$0, continuation);
        gameComposeContainerActivity$applyKomponent$2.L$0 = obj;
        return gameComposeContainerActivity$applyKomponent$2;
    }

    public final Object invoke(Orientation orientation, Continuation<? super Unit> continuation) {
        return create(orientation, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int requestedOrientation;
        Orientation it = (Orientation) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GameComposeContainerActivity gameComposeContainerActivity = this.this$0;
                switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    case 1:
                        requestedOrientation = this.this$0.getRequestedOrientation();
                        break;
                    case 2:
                        requestedOrientation = 2;
                        break;
                    case 3:
                        requestedOrientation = 12;
                        break;
                    case 4:
                        requestedOrientation = 1;
                        break;
                    case 5:
                        requestedOrientation = 9;
                        break;
                    case 6:
                        requestedOrientation = 11;
                        break;
                    case 7:
                        requestedOrientation = 8;
                        break;
                    case 8:
                        requestedOrientation = 0;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                gameComposeContainerActivity.setRequestedOrientation(requestedOrientation);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}