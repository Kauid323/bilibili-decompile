package kntr.common.ouro.ui.textField;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.LinkedList;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroEditText.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J*\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012J2\u0010\u001c\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0006H\u0016J2\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\u0016\u0010\"\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0010H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006-"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroEditTextListener;", "Landroid/text/TextWatcher;", "<init>", "()V", "manualStateStack", "Ljava/util/LinkedList;", "", "value", "manual", "getManual", "()Z", "setManual", "(Z)V", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "onSelectionChanged", "selStart", "selEnd", "beforeTextChangedFiltered", "onTextChangedFiltered", "afterTextChangedFiltered", "onSelectionChangedFiltered", "handleEnterEvent", "handleDeleteEvent", "handleCopyEvent", "defaultAction", "Lkotlin/Function0;", "handleCutEvent", "handlePasteEvent", "handleCommitText", "text", "handleSetComposingText", "handleFinishComposingText", "handleSetComposingRegion", "end", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public class OuroEditTextListener implements TextWatcher {
    public static final int $stable = 8;
    private final LinkedList<Boolean> manualStateStack = new LinkedList<>();

    public final boolean getManual() {
        Boolean peek = this.manualStateStack.peek();
        if (peek != null) {
            return peek.booleanValue();
        }
        return false;
    }

    public final void setManual(boolean value) {
        if (value) {
            this.manualStateStack.push(true);
        } else if (!this.manualStateStack.isEmpty()) {
            this.manualStateStack.pop();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        beforeTextChangedFiltered(s, start, count, after, getManual());
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        onTextChangedFiltered(s, start, before, count, getManual());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        afterTextChangedFiltered(s, getManual());
    }

    public final void onSelectionChanged(int selStart, int selEnd) {
        onSelectionChangedFiltered(selStart, selEnd, getManual());
    }

    public void beforeTextChangedFiltered(CharSequence s, int start, int count, int after, boolean manual) {
    }

    public void onTextChangedFiltered(CharSequence s, int start, int before, int count, boolean manual) {
    }

    public void afterTextChangedFiltered(Editable s, boolean manual) {
    }

    public void onSelectionChangedFiltered(int selStart, int selEnd, boolean manual) {
    }

    public boolean handleEnterEvent() {
        return false;
    }

    public boolean handleDeleteEvent() {
        return false;
    }

    public boolean handleCopyEvent(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultAction");
        return false;
    }

    public boolean handleCutEvent() {
        return false;
    }

    public boolean handlePasteEvent() {
        return false;
    }

    public boolean handleCommitText(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return false;
    }

    public boolean handleSetComposingText(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return false;
    }

    public boolean handleFinishComposingText() {
        return false;
    }

    public boolean handleSetComposingRegion(int start, int end) {
        return false;
    }
}