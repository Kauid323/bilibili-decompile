package kntr.app.tribee.search.state;

import androidx.compose.foundation.text.input.TextFieldState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSearchPageState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\t¨\u0006\u0019"}, d2 = {"Lkntr/app/tribee/search/state/SearchBarState;", "", "hint", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "<init>", "(Ljava/lang/String;Landroidx/compose/foundation/text/input/TextFieldState;)V", "getHint", "()Ljava/lang/String;", "getTextFieldState", "()Landroidx/compose/foundation/text/input/TextFieldState;", "isSearchButtonEnable", "", "()Z", "query", "getQuery", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SearchBarState {
    public static final int $stable = 0;
    private final String hint;
    private final TextFieldState textFieldState;

    public static /* synthetic */ SearchBarState copy$default(SearchBarState searchBarState, String str, TextFieldState textFieldState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchBarState.hint;
        }
        if ((i & 2) != 0) {
            textFieldState = searchBarState.textFieldState;
        }
        return searchBarState.copy(str, textFieldState);
    }

    public final String component1() {
        return this.hint;
    }

    public final TextFieldState component2() {
        return this.textFieldState;
    }

    public final SearchBarState copy(String str, TextFieldState textFieldState) {
        Intrinsics.checkNotNullParameter(str, "hint");
        Intrinsics.checkNotNullParameter(textFieldState, "textFieldState");
        return new SearchBarState(str, textFieldState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchBarState) {
            SearchBarState searchBarState = (SearchBarState) obj;
            return Intrinsics.areEqual(this.hint, searchBarState.hint) && Intrinsics.areEqual(this.textFieldState, searchBarState.textFieldState);
        }
        return false;
    }

    public int hashCode() {
        return (this.hint.hashCode() * 31) + this.textFieldState.hashCode();
    }

    public String toString() {
        String str = this.hint;
        return "SearchBarState(hint=" + str + ", textFieldState=" + this.textFieldState + ")";
    }

    public SearchBarState(String hint, TextFieldState textFieldState) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(textFieldState, "textFieldState");
        this.hint = hint;
        this.textFieldState = textFieldState;
    }

    public final String getHint() {
        return this.hint;
    }

    public final TextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final boolean isSearchButtonEnable() {
        return this.textFieldState.getText().length() > 0;
    }

    public final String getQuery() {
        return this.textFieldState.getText().toString();
    }
}