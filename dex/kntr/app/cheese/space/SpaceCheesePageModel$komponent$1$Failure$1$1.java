package kntr.app.cheese.space;

import androidx.compose.runtime.MutableState;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpaceCheesePageModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class SpaceCheesePageModel$komponent$1$Failure$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ KomponentScope<SpaceCheesePageState> $this_Komponent;
    final /* synthetic */ MutableState<PageState> $uiState$delegate;
    final /* synthetic */ SpaceCheesePageModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpaceCheesePageModel$komponent$1$Failure$1$1(KomponentScope<? super SpaceCheesePageState> komponentScope, SpaceCheesePageModel spaceCheesePageModel, MutableState<PageState> mutableState) {
        super(0, Intrinsics.Kotlin.class, "refreshData", "komponent$lambda$0$refreshData(Lkntr/common/komponent/KomponentScope;Lkntr/app/cheese/space/SpaceCheesePageModel;Landroidx/compose/runtime/MutableState;)V", 0);
        this.$this_Komponent = komponentScope;
        this.this$0 = spaceCheesePageModel;
        this.$uiState$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m545invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m545invoke() {
        SpaceCheesePageModel.komponent$lambda$0$refreshData(this.$this_Komponent, this.this$0, this.$uiState$delegate);
    }
}