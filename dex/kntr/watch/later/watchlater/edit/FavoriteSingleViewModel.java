package kntr.watch.later.watchlater.edit;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import bili.resource.favorites.FavoritesRes;
import bili.resource.favorites.String0_commonMainKt;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FavoriteSingleViewModel.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\r2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010+J\b\u0010,\u001a\u00020(H\u0002J2\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020(0+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020(0+J4\u00102\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020(0+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020(0+H\u0002J4\u00103\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020(0+2\f\u00104\u001a\b\u0012\u0004\u0012\u00020(0+H\u0002J\u0006\u00105\u001a\u00020(R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001c¨\u00066"}, d2 = {"Lkntr/watch/later/watchlater/edit/FavoriteSingleViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_folders", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/watch/later/watchlater/edit/FavFolder;", "folders", "", "getFolders", "()Ljava/util/List;", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_isFavoriting", "isFavoriting", "_toastMessage", "", "toastMessage", "getToastMessage", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "pageIndex", "newFolderId", "", "getNewFolderId", "()J", "setNewFolderId", "(J)V", "opType", "getOpType", "setOpType", "loadData", "", "refresh", "onFailed", "Lkotlin/Function0;", "checkNewCreate", "submitFromWatchLater", "folder", "resources", "onSuccess", "onDismissRequest", "submitCopy", "submitMove", "onRequestDismiss", "clearToast", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FavoriteSingleViewModel extends ViewModel {
    public static final int $stable = 8;
    private int opType;
    private int totalCount;
    private final SnapshotStateList<FavFolder> _folders = SnapshotStateKt.mutableStateListOf();
    private final MutableStateFlow<Boolean> _isLoading = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<Boolean> isLoading = this._isLoading;
    private final MutableStateFlow<Boolean> _isFavoriting = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<Boolean> isFavoriting = this._isFavoriting;
    private final MutableStateFlow<String> _toastMessage = StateFlowKt.MutableStateFlow("");
    private final StateFlow<String> toastMessage = this._toastMessage;
    private int pageIndex = 1;
    private long newFolderId = -1;

    public final List<FavFolder> getFolders() {
        return this._folders;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<Boolean> isFavoriting() {
        return this.isFavoriting;
    }

    public final StateFlow<String> getToastMessage() {
        return this.toastMessage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(int i) {
        this.totalCount = i;
    }

    public final long getNewFolderId() {
        return this.newFolderId;
    }

    public final void setNewFolderId(long j) {
        this.newFolderId = j;
    }

    public final int getOpType() {
        return this.opType;
    }

    public final void setOpType(int i) {
        this.opType = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadData$default(FavoriteSingleViewModel favoriteSingleViewModel, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        favoriteSingleViewModel.loadData(z, function0);
    }

    public final void loadData(boolean refresh, Function0<Unit> function0) {
        if (((Boolean) this.isLoading.getValue()).booleanValue()) {
            return;
        }
        if (refresh) {
            this.pageIndex = 1;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FavoriteSingleViewModel$loadData$1(this, function0, refresh, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkNewCreate() {
        Object element$iv;
        boolean z;
        Iterable $this$firstOrNull$iv = this._folders;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                FavFolder it2 = (FavFolder) element$iv;
                if (it2.getId() == this.newFolderId) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        FavFolder existingFolder = (FavFolder) element$iv;
        if (existingFolder != null) {
            this._folders.remove(existingFolder);
            this._folders.add(0, existingFolder);
            this.newFolderId = -1L;
        }
    }

    public final void submitFromWatchLater(FavFolder folder, String resources, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function02, "onDismissRequest");
        KNeuron.INSTANCE.reportClick(false, "playlist.manage-playlist.batch-favorite.myfoundpl.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("playlist_id", String.valueOf(folder.getId())), TuplesKt.to("playlist_type", String.valueOf(folder.getAttr()))}));
        if (StringsKt.isBlank(resources)) {
            this._toastMessage.setValue(FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_49(FavoritesRes.INSTANCE.getString())));
        } else if (((Boolean) this.isFavoriting.getValue()).booleanValue()) {
        } else {
            if (this.opType == 0) {
                submitCopy(folder, resources, function0, function02);
            } else {
                submitMove(folder, resources, function0, function02);
            }
        }
    }

    private final void submitCopy(FavFolder folder, String resources, Function0<Unit> function0, Function0<Unit> function02) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FavoriteSingleViewModel$submitCopy$1(this, resources, folder, function0, function02, null), 3, (Object) null);
    }

    private final void submitMove(FavFolder folder, String resources, Function0<Unit> function0, Function0<Unit> function02) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FavoriteSingleViewModel$submitMove$1(this, resources, folder, function0, function02, null), 3, (Object) null);
    }

    public final void clearToast() {
        this._toastMessage.setValue("");
    }
}