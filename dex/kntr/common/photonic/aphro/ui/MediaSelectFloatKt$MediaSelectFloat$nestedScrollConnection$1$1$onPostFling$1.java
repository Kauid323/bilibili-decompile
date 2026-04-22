package kntr.common.photonic.aphro.ui;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaSelectFloat.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1", f = "MediaSelectFloat.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {177, 180, 182, 185}, m = "onPostFling-RZ2iAVY", n = {"$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0"}, s = {"J$0", "J$1", "J$0", "J$1", "J$0", "J$1", "J$0", "J$1"}, v = 1)
public final class MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1(MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1 mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1, Continuation<? super MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = mediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m2245onPostFlingRZ2iAVY(0L, 0L, (Continuation) this);
    }
}