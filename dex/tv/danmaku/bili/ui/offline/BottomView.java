package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.theme.R;
import com.bilibili.magicasakura.widgets.TintLinearLayout;

/* JADX INFO: Access modifiers changed from: package-private */
public class BottomView extends TintLinearLayout implements View.OnClickListener {
    private BottomActionCallback mBottomActionCallback;
    private CheckBox mCheckBox;
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private TextView mDanmaku;
    private TextView mDelete;
    private boolean mShowDanmaku;

    public BottomView(Context context) {
        super(context);
        this.mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.ui.offline.BottomView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (BottomView.this.mBottomActionCallback != null) {
                    BottomView.this.mBottomActionCallback.checkAll(isChecked);
                }
            }
        };
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        setOrientation(1);
        setBackgroundResource(R.color.Wh0);
        LayoutInflater.from(getContext()).inflate(tv.danmaku.bili.R.layout.bili_app_view_offline_bottom_bar, (ViewGroup) this);
        this.mCheckBox = (CheckBox) findViewById(tv.danmaku.bili.R.id.checkbox);
        this.mDanmaku = (TextView) findViewById(tv.danmaku.bili.R.id.update_danmaku);
        this.mDelete = (TextView) findViewById(tv.danmaku.bili.R.id.delete);
        findViewById(tv.danmaku.bili.R.id.check_area).setOnClickListener(this);
        this.mCheckBox.setOnCheckedChangeListener(this.mCheckedChangeListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attach(ViewGroup mContainer, ViewGroup.LayoutParams params, int pos, boolean showDanmaku, BottomActionCallback callback) {
        this.mBottomActionCallback = callback;
        this.mShowDanmaku = showDanmaku;
        this.mDanmaku.setVisibility(this.mShowDanmaku ? 0 : 8);
        mContainer.addView((View) this, pos, params);
        updateCheckCount(0, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void detach() {
        this.mBottomActionCallback = null;
        this.mCheckBox.setChecked(false);
        updateCheckCount(0, false);
        ((ViewGroup) getParent()).removeView(this);
    }

    public void updateCheckCount(int count, boolean allChecked) {
        this.mCheckBox.setOnCheckedChangeListener(null);
        this.mCheckBox.setChecked(allChecked);
        this.mCheckBox.setOnCheckedChangeListener(this.mCheckedChangeListener);
        if (count <= 0) {
            this.mDelete.setEnabled(false);
            this.mDelete.setText(getResources().getString(bili.resource.common.R.string.common_global_string_113));
            this.mDelete.setTextColor(ContextCompat.getColor(getContext(), R.color.Ga4));
            this.mDelete.setOnClickListener(null);
            enableDanmaku(false);
            return;
        }
        this.mDelete.setEnabled(true);
        this.mDelete.setText(getResources().getString(bili.resource.downloads.R.string.downloads_global_string_125, String.valueOf(count)));
        this.mDelete.setTextColor(ContextCompat.getColor(getContext(), R.color.Re6));
        this.mDelete.setOnClickListener(this);
        if (this.mShowDanmaku) {
            enableDanmaku(true);
        }
    }

    private void enableDanmaku(boolean enable) {
        int colorRes = enable ? R.color.Ga8 : R.color.Ga4;
        this.mDanmaku.setTextColor(ContextCompat.getColor(getContext(), colorRes));
        this.mDanmaku.setOnClickListener(enable ? this : null);
        this.mDanmaku.setEnabled(enable);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == tv.danmaku.bili.R.id.update_danmaku) {
            if (!ConnectivityMonitor.getInstance().isNetworkActive()) {
                ToastHelper.showToastShort(getContext(), bili.resource.homepage.R.string.homepage_global_string_139);
            } else if (this.mBottomActionCallback != null) {
                this.mBottomActionCallback.updateDanmaku();
            }
        } else if (id == tv.danmaku.bili.R.id.delete) {
            if (this.mBottomActionCallback != null) {
                this.mBottomActionCallback.delete();
            }
        } else if (id == tv.danmaku.bili.R.id.check_area) {
            this.mCheckBox.setChecked(!this.mCheckBox.isChecked());
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class BottomActionCallback {
        void checkAll(boolean check) {
        }

        void delete() {
        }

        void updateDanmaku() {
        }
    }
}