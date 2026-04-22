package tv.danmaku.bili.widget;

import android.app.Activity;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.Tintable;

public class SearchView extends FrameLayout implements Tintable {
    private int hintColorRes;
    private boolean mClearingFocus;
    private ImageView mCloseButton;
    private TintTextView mFakeQueryTextView;
    private Filter mFilter;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private View.OnClickListener mOnClickListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private OnQueryTextListener mOnQueryChangeListener;
    private CharSequence mQueryHint;
    public QueryText mQueryTextView;
    private View mSearchPlate;
    private SearchableInfo mSearchable;
    private Runnable mShowImeRunnable;
    private boolean mSubmitButtonEnabled;
    protected TextWatcher mTextWatcher;
    private int mThreshold;
    private Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private boolean mVoiceButtonEnabled;
    private OnKeyPreImeListener onKeyPreImeListener;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnCreateInputConnectionListener {
        InputConnection onCreateInputConnection(InputConnection inputConnection);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnKeyPreImeListener {
        boolean onKeyPreIme(int i, KeyEvent keyEvent);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);

        boolean onSuggestionQuery(String str);
    }

    public void tint() {
        if (this.hintColorRes != 0) {
            this.mQueryTextView.setHintTextColor(ThemeUtils.getColorById(getContext(), this.hintColorRes));
        }
    }

    public void setOnKeyPreImeListener(OnKeyPreImeListener onKeyPreImeListener) {
        this.onKeyPreImeListener = onKeyPreImeListener;
        if (this.mQueryTextView != null) {
            this.mQueryTextView.setOnKeyPreImeListener(this.onKeyPreImeListener);
        }
    }

    public void setOnCreateInputConnectionListener(OnCreateInputConnectionListener onCreateInputConnectionListener) {
        if (this.mQueryTextView != null) {
            this.mQueryTextView.setOnCreateInputConnectionListener(onCreateInputConnectionListener);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mThreshold = 1;
        this.mShowImeRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager imm = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (imm != null) {
                    imm.showSoftInput(SearchView.this.mQueryTextView, 0);
                }
            }
        };
        this.mUpdateDrawableStateRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.updateFocusedState();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.widget.SearchView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SearchView.this.mCloseButton) {
                    SearchView.this.onCloseClicked();
                } else if (v == SearchView.this.mQueryTextView) {
                    SearchView.this.forceSuggestionQuery();
                } else if (v == SearchView.this.mFakeQueryTextView) {
                    SearchView.this.showRealQuery();
                    SearchView.this.mQueryTextView.requestFocus();
                    if (!TextUtils.isEmpty(SearchView.this.mUserQuery)) {
                        SearchView.this.mQueryTextView.setSelection(SearchView.this.mUserQuery.length());
                    }
                    SearchView.this.forceSuggestionQuery();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: tv.danmaku.bili.widget.SearchView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int before, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int after) {
                SearchView.this.onTextChanged(s);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.widget.SearchView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                SearchView.this.onSubmitQuery();
                return true;
            }
        };
        init(context, attrs, defStyleAttr);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mThreshold = 1;
        this.mShowImeRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager imm = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (imm != null) {
                    imm.showSoftInput(SearchView.this.mQueryTextView, 0);
                }
            }
        };
        this.mUpdateDrawableStateRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.updateFocusedState();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.widget.SearchView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SearchView.this.mCloseButton) {
                    SearchView.this.onCloseClicked();
                } else if (v == SearchView.this.mQueryTextView) {
                    SearchView.this.forceSuggestionQuery();
                } else if (v == SearchView.this.mFakeQueryTextView) {
                    SearchView.this.showRealQuery();
                    SearchView.this.mQueryTextView.requestFocus();
                    if (!TextUtils.isEmpty(SearchView.this.mUserQuery)) {
                        SearchView.this.mQueryTextView.setSelection(SearchView.this.mUserQuery.length());
                    }
                    SearchView.this.forceSuggestionQuery();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: tv.danmaku.bili.widget.SearchView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int before, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int after) {
                SearchView.this.onTextChanged(s);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.widget.SearchView.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                SearchView.this.onSubmitQuery();
                return true;
            }
        };
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(com.bilibili.lib.widget.R.layout.bili_app_view_channel_search_plate, this);
        this.mSearchPlate = findViewById(com.bilibili.lib.widget.R.id.search_plate);
        this.mQueryTextView = (QueryText) findViewById(com.bilibili.lib.widget.R.id.search_src_text);
        this.mFakeQueryTextView = findViewById(com.bilibili.lib.widget.R.id.search_fake_text);
        this.mQueryTextView.setSearchView(this);
        this.mCloseButton = (ImageView) findViewById(com.bilibili.lib.widget.R.id.search_close_btn);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.setOnClickListener(this.mOnClickListener);
        this.mFakeQueryTextView.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.addTextChangedListener(this.mTextWatcher);
        this.mQueryTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        changeForNightTheme(context);
        TypedArray a = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.SearchViewCopy, defStyleAttr, 0);
        int maxWidth = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.SearchViewCopy_android_maxWidth, -1);
        if (maxWidth != -1) {
            setMaxWidth(maxWidth);
        }
        CharSequence queryHint = a.getText(com.bilibili.lib.widget.R.styleable.SearchViewCopy_queryHint);
        if (!TextUtils.isEmpty(queryHint)) {
            setQueryHint(queryHint);
        }
        int imeOptions = a.getInt(com.bilibili.lib.widget.R.styleable.SearchViewCopy_android_imeOptions, -1);
        if (imeOptions != -1) {
            setImeOptions(imeOptions);
        }
        int inputType = a.getInt(com.bilibili.lib.widget.R.styleable.SearchViewCopy_android_inputType, -1);
        if (inputType != -1) {
            setInputType(inputType);
        }
        Drawable closeIcon = a.getDrawable(com.bilibili.lib.widget.R.styleable.SearchViewCopy_closeIcon);
        if (closeIcon != null) {
            this.mCloseButton.setImageDrawable(closeIcon);
            updateCloseButton();
        }
        this.hintColorRes = a.getResourceId(com.bilibili.lib.widget.R.styleable.SearchViewCopy_searchHintColor, com.bilibili.lib.widget.R.color.search_view_hint_text_color);
        int hintColor = a.getColor(com.bilibili.lib.widget.R.styleable.SearchViewCopy_searchHintColor, getResources().getColor(com.bilibili.lib.widget.R.color.search_view_hint_text_color));
        int inputColor = a.getColor(com.bilibili.lib.widget.R.styleable.SearchViewCopy_searchInputColor, getResources().getColor(com.bilibili.lib.theme.R.color.Text1));
        this.mQueryTextView.setHintTextColor(hintColor);
        this.mQueryTextView.setTextColor(inputColor);
        this.mFakeQueryTextView.setTextColor(inputColor);
        a.recycle();
    }

    private void changeForNightTheme(Context context) {
        this.mQueryTextView.setHintTextColor(ContextCompat.getColor(context, com.bilibili.lib.widget.R.color.search_view_hint_text_color));
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_search_view_preferred_width);
    }

    public void setImeOptions(int imeOptions) {
        this.mQueryTextView.setImeOptions(imeOptions);
    }

    public int getImeOptions() {
        return this.mQueryTextView.getImeOptions();
    }

    public void setInputType(int inputType) {
        this.mQueryTextView.setInputType(inputType);
    }

    public int getInputType() {
        return this.mQueryTextView.getInputType();
    }

    public void setMaxWidth(int maxpixels) {
        this.mMaxWidth = maxpixels;
        requestLayout();
    }

    public QueryText getQueryTextView() {
        return this.mQueryTextView;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public void setQueryHint(CharSequence hint) {
        this.mQueryHint = hint;
        updateQueryHint();
    }

    public CharSequence getQueryHint() {
        int hintId;
        if (this.mQueryHint != null) {
            return this.mQueryHint;
        }
        if (this.mSearchable == null || (hintId = this.mSearchable.getHintId()) == 0) {
            return null;
        }
        CharSequence hint = getContext().getString(hintId);
        return hint;
    }

    public void setFilter(Filter filter) {
        this.mFilter = filter;
    }

    private void updateQueryHint() {
        if (this.mQueryHint != null) {
            this.mQueryTextView.setHint(this.mQueryHint);
        } else if (this.mSearchable != null) {
            CharSequence hint = null;
            int hintId = this.mSearchable.getHintId();
            if (hintId != 0) {
                hint = getContext().getString(hintId);
            }
            if (hint != null) {
                this.mQueryTextView.setHint(hint);
            }
        } else {
            this.mQueryTextView.setHint("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCloseClicked() {
        showRealQuery();
        CharSequence text = this.mQueryTextView.getText();
        if (TextUtils.isEmpty(text)) {
            clearFocus();
            return;
        }
        this.mQueryTextView.setText("");
        this.mQueryTextView.requestFocus();
        setImeVisibility(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTextChanged(CharSequence newText) {
        CharSequence text = this.mQueryTextView.getText();
        this.mUserQuery = text;
        this.mFakeQueryTextView.setText(newText);
        updateCloseButton();
        if (this.mOnQueryChangeListener != null && !TextUtils.equals(newText, this.mOldQueryText)) {
            this.mOnQueryChangeListener.onQueryTextChange(newText.toString());
        }
        this.mOldQueryText = newText.toString();
    }

    void afterTextChanged(CharSequence newText) {
        if (enoughToFilter() || newText.length() == 0) {
            performFiltering(newText);
        }
    }

    public boolean enoughToFilter() {
        return this.mQueryTextView.getText().length() >= this.mThreshold;
    }

    public void onQueryRefine(CharSequence queryText) {
        setQuery(queryText);
    }

    void onTextFocusChanged() {
        postUpdateFocusedState();
        if (this.mQueryTextView.hasFocus()) {
            showRealQuery();
            forceSuggestionQuery();
            setImeVisibility(true);
            return;
        }
        if (TextUtils.isEmpty(this.mUserQuery) && !TextUtils.isEmpty(this.mQueryTextView.getHint())) {
            showRealQuery();
        } else {
            showFakeQuery();
        }
        setImeVisibility(false);
    }

    void forceSuggestionQuery() {
        String query = this.mQueryTextView.getText().toString();
        if (this.mOnQueryChangeListener != null && !this.mOnQueryChangeListener.onSuggestionQuery(query)) {
            performFiltering(query);
        }
    }

    private void performFiltering(CharSequence constraint) {
        if (this.mFilter != null) {
            this.mFilter.filter(constraint);
        }
    }

    private void showFakeQuery() {
        this.mQueryTextView.setVisibility(8);
        this.mFakeQueryTextView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRealQuery() {
        this.mFakeQueryTextView.setVisibility(8);
        this.mQueryTextView.setVisibility(0);
    }

    public void setOnQueryTextListener(OnQueryTextListener listener) {
        this.mOnQueryChangeListener = listener;
    }

    public void setSubmitButtonEnabled(boolean enabled) {
        this.mSubmitButtonEnabled = enabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubmitQuery() {
        String query = this.mQueryTextView.getText().toString();
        if ((this.mOnQueryChangeListener == null || !this.mOnQueryChangeListener.onQueryTextSubmit(query)) && this.mSearchable != null && query != null && TextUtils.getTrimmedLength(query) > 0) {
            launchQuerySearch(0, null, query);
            setImeVisibility(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImeVisibility(boolean visible) {
        if (visible) {
            post(this.mShowImeRunnable);
            return;
        }
        removeCallbacks(this.mShowImeRunnable);
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void setSearchableInfo(SearchableInfo searchable) {
        this.mSearchable = searchable;
        if (this.mSearchable != null) {
            updateQueryHint();
            this.mThreshold = this.mSearchable.getSuggestThreshold();
        }
        this.mVoiceButtonEnabled = hasVoiceSearch();
        if (this.mVoiceButtonEnabled) {
            this.mQueryTextView.setPrivateImeOptions("nm");
        }
    }

    private boolean hasVoiceSearch() {
        return false;
    }

    private boolean isSubmitAreaEnabled() {
        return this.mSubmitButtonEnabled || this.mVoiceButtonEnabled;
    }

    private void updateCloseButton() {
        boolean hasText = !TextUtils.isEmpty(this.mQueryTextView.getText());
        this.mCloseButton.setVisibility(hasText ? 0 : 8);
        this.mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFocusedState() {
        boolean focused = this.mQueryTextView.hasFocus();
        if (this.mSearchPlate.getBackground() == null) {
            return;
        }
        this.mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (!this.mClearingFocus && isFocusable()) {
            return this.mQueryTextView.requestFocus(direction, previouslyFocusedRect);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        this.mQueryTextView.clearFocus();
        this.mClearingFocus = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        postUpdateFocusedState();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        super.onDetachedFromWindow();
    }

    public void setQuery(CharSequence query) {
        if (this.mQueryTextView.hasFocus() || TextUtils.isEmpty(query)) {
            showRealQuery();
        } else {
            showFakeQuery();
        }
        if (query != null && this.mUserQuery != null && query.toString().equals(this.mUserQuery.toString())) {
            return;
        }
        this.mUserQuery = query;
        this.mQueryTextView.setText(query);
        this.mFakeQueryTextView.setText(query);
        this.mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    public CharSequence getQuery() {
        return this.mUserQuery;
    }

    private void launchQuerySearch(int actionKey, String actionMsg, String query) {
        Intent intent = createIntent("android.intent.action.SEARCH", null, null, query, actionKey, actionMsg);
        Activity activity = ContextUtilKt.findActivityOrNull(getContext());
        if (activity == null) {
            intent.setFlags(268435456);
        }
        getContext().startActivity(intent);
    }

    private Intent createIntent(String action, Uri data, String extraData, String query, int actionKey, String actionMsg) {
        Intent intent = new Intent(action);
        intent.addFlags(268435456);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (query != null) {
            intent.putExtra("query", query);
        }
        if (extraData != null) {
            intent.putExtra("intent_extra_data_key", extraData);
        }
        if (actionKey != 0) {
            intent.putExtra("action_key", actionKey);
            intent.putExtra("action_msg", actionMsg);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class QueryText extends AppCompatEditText {
        private SearchView mSearchView;
        OnCreateInputConnectionListener onCreateInputConnectionListener;
        OnKeyPreImeListener onKeyPreImeListener;

        public QueryText(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        public void setOnKeyPreImeListener(OnKeyPreImeListener onKeyPreImeListener) {
            this.onKeyPreImeListener = onKeyPreImeListener;
        }

        public void setOnCreateInputConnectionListener(OnCreateInputConnectionListener onCreateInputConnectionListener) {
            this.onCreateInputConnectionListener = onCreateInputConnectionListener;
        }

        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            this.mSearchView.onTextFocusChanged();
        }

        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            if (keyCode == 4) {
                if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.startTracking(event, this);
                    }
                    return true;
                } else if (event.getAction() == 1) {
                    KeyEvent.DispatcherState state2 = getKeyDispatcherState();
                    if (state2 != null) {
                        state2.handleUpEvent(event);
                    }
                    if (event.isTracking()) {
                        this.mSearchView.clearFocus();
                        this.mSearchView.setImeVisibility(false);
                        return this.onKeyPreImeListener != null && this.onKeyPreImeListener.onKeyPreIme(keyCode, event);
                    }
                }
            }
            return super.onKeyPreIme(keyCode, event);
        }

        public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
            InputConnection inputConnection = super.onCreateInputConnection(outAttrs);
            if (inputConnection != null && this.onCreateInputConnectionListener != null) {
                return this.onCreateInputConnectionListener.onCreateInputConnection(inputConnection);
            }
            return inputConnection;
        }
    }
}