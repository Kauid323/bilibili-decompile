package kntr.common.compose.launcher;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: ComposeContainer.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkntr/common/komponent/Orientation;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.launcher.ComposeContainerActivity$applyKomponent$2", f = "ComposeContainer.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComposeContainerActivity$applyKomponent$2 extends SuspendLambda implements Function2<Orientation, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ComposeContainerActivity this$0;

    /* compiled from: ComposeContainer.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
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
    public ComposeContainerActivity$applyKomponent$2(ComposeContainerActivity composeContainerActivity, Continuation<? super ComposeContainerActivity$applyKomponent$2> continuation) {
        super(2, continuation);
        this.this$0 = composeContainerActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> composeContainerActivity$applyKomponent$2 = new ComposeContainerActivity$applyKomponent$2(this.this$0, continuation);
        composeContainerActivity$applyKomponent$2.L$0 = obj;
        return composeContainerActivity$applyKomponent$2;
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
                ComposeContainerActivity composeContainerActivity = this.this$0;
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
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        requestedOrientation = 8;
                        break;
                    case 8:
                        requestedOrientation = 0;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                composeContainerActivity.setRequestedOrientation(requestedOrientation);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}