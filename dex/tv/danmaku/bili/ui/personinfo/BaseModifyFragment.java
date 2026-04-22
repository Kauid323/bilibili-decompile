package tv.danmaku.bili.ui.personinfo;

import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.lang.ref.WeakReference;

public abstract class BaseModifyFragment extends BaseFragment {
    protected InputMethodManager mImm;
    protected boolean mImmShowing;
    protected TintProgressDialog mProgressDialog;
    protected ResultReceiver mResultReceiver;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getApplicationContext() != null) {
            this.mImm = (InputMethodManager) getApplicationContext().getSystemService("input_method");
        }
        this.mResultReceiver = new MyResultReceiver(this);
    }

    public void onDetach() {
        super.onDetach();
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mResultReceiver = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showSoftInput(View v) {
        if (this.mImm != null) {
            this.mImm.showSoftInput(v, 16, this.mResultReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideSoftInput(IBinder token) {
        if (this.mImm != null) {
            this.mImm.hideSoftInputFromWindow(token, 0, this.mResultReceiver);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static class MyResultReceiver extends ResultReceiver {
        WeakReference<BaseModifyFragment> mRef;

        public MyResultReceiver(BaseModifyFragment fragment) {
            super(null);
            this.mRef = new WeakReference<>(fragment);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            BaseModifyFragment f = this.mRef.get();
            if (f != null) {
                f.mImmShowing = resultCode == 2 || resultCode == 0;
            }
        }
    }
}