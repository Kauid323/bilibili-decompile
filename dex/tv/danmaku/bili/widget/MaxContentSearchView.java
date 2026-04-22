package tv.danmaku.bili.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.SearchView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MaxContentSearchView.kt */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0003*\u0001\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/widget/MaxContentSearchView;", "Ltv/danmaku/bili/widget/SearchView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mCloseClickListener", "Ltv/danmaku/bili/widget/CloseClickListener;", "getMCloseClickListener", "()Ltv/danmaku/bili/widget/CloseClickListener;", "setMCloseClickListener", "(Ltv/danmaku/bili/widget/CloseClickListener;)V", "setCloseClickListener", "", "onCloseClicked", "mMaxCharacters", "", "getMMaxCharacters", "()I", "setMMaxCharacters", "(I)V", "mTextWatcher2", "tv/danmaku/bili/widget/MaxContentSearchView$mTextWatcher2$1", "Ltv/danmaku/bili/widget/MaxContentSearchView$mTextWatcher2$1;", "widget_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MaxContentSearchView extends SearchView {
    public static final int $stable = 8;
    private CloseClickListener mCloseClickListener;
    private int mMaxCharacters;
    private final MaxContentSearchView$mTextWatcher2$1 mTextWatcher2;

    public final CloseClickListener getMCloseClickListener() {
        return this.mCloseClickListener;
    }

    public final void setMCloseClickListener(CloseClickListener closeClickListener) {
        this.mCloseClickListener = closeClickListener;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.widget.MaxContentSearchView$mTextWatcher2$1] */
    public MaxContentSearchView(Context context) {
        super(context);
        this.mMaxCharacters = -1;
        this.mTextWatcher2 = new TextWatcher() { // from class: tv.danmaku.bili.widget.MaxContentSearchView$mTextWatcher2$1
            private CharSequence changeBefore = "";

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int before, int after) {
                Intrinsics.checkNotNullParameter(s, "s");
                this.changeBefore = new SpannableStringBuilder(s);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int after) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (MaxContentSearchView.this.getMMaxCharacters() == -1) {
                    MaxContentSearchView.this.onTextChanged(s);
                    return;
                }
                if (s.length() > MaxContentSearchView.this.getMMaxCharacters()) {
                    MaxContentSearchView.this.setQuery(this.changeBefore);
                }
                if (s.length() <= MaxContentSearchView.this.getMMaxCharacters() && this.changeBefore.length() <= MaxContentSearchView.this.getMMaxCharacters()) {
                    MaxContentSearchView.this.onTextChanged(s);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.bili.widget.MaxContentSearchView$mTextWatcher2$1] */
    public MaxContentSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMaxCharacters = -1;
        this.mTextWatcher2 = new TextWatcher() { // from class: tv.danmaku.bili.widget.MaxContentSearchView$mTextWatcher2$1
            private CharSequence changeBefore = "";

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int before, int after) {
                Intrinsics.checkNotNullParameter(s, "s");
                this.changeBefore = new SpannableStringBuilder(s);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int after) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (MaxContentSearchView.this.getMMaxCharacters() == -1) {
                    MaxContentSearchView.this.onTextChanged(s);
                    return;
                }
                if (s.length() > MaxContentSearchView.this.getMMaxCharacters()) {
                    MaxContentSearchView.this.setQuery(this.changeBefore);
                }
                if (s.length() <= MaxContentSearchView.this.getMMaxCharacters() && this.changeBefore.length() <= MaxContentSearchView.this.getMMaxCharacters()) {
                    MaxContentSearchView.this.onTextChanged(s);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }
        };
        try {
            SearchView.QueryText queryText = this.mQueryTextView;
            if (queryText != null) {
                queryText.removeTextChangedListener(this.mTextWatcher);
            }
            SearchView.QueryText queryText2 = this.mQueryTextView;
            if (queryText2 != null) {
                queryText2.addTextChangedListener(this.mTextWatcher2);
            }
            int padLeft = ListExtentionsKt.toPx(6);
            SearchView.QueryText queryText3 = this.mQueryTextView;
            if (queryText3 != null) {
                queryText3.setPadding(padLeft, 0, padLeft, 0);
            }
        } catch (Exception e) {
        }
    }

    public final void setCloseClickListener(CloseClickListener mCloseClickListener) {
        Intrinsics.checkNotNullParameter(mCloseClickListener, "mCloseClickListener");
        this.mCloseClickListener = mCloseClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.widget.SearchView
    public void onCloseClicked() {
        super.onCloseClicked();
        CloseClickListener closeClickListener = this.mCloseClickListener;
        if (closeClickListener != null) {
            closeClickListener.onCloseClick();
        }
    }

    public final int getMMaxCharacters() {
        return this.mMaxCharacters;
    }

    public final void setMMaxCharacters(int i) {
        this.mMaxCharacters = i;
    }
}