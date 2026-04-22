package tv.danmaku.bili.ui.personinfo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.bilibili.app.personinfo.R;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import java.lang.ref.WeakReference;
import tv.danmaku.bili.ui.personinfo.event.ModifyPersonInfoEvent;
import tv.danmaku.bili.ui.personinfo.event.ModifyType;

public class PersonInfoModifySignFragment extends BaseModifyFragment {
    private static final int MAX_LENGTH = 70;
    public static final String TAG = "PersonInfoModifySignFragment";
    TextView mEditCount;
    EditText mEditText;
    private String oldSignature;

    @Override // tv.danmaku.bili.ui.personinfo.BaseModifyFragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.bili_app_fragment_perinfo_modify_signature, container, false);
        this.mEditText = (EditText) view2.findViewById(R.id.signature_edit);
        this.mEditCount = (TextView) view2.findViewById(R.id.signature_edit_count);
        this.mEditText.setText(getOldSignature());
        this.mEditCount.setText(String.valueOf(70 - this.mEditText.length()));
        this.mEditText.addTextChangedListener(new MyTextWatcher(this));
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifySignFragment.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    PersonInfoModifySignFragment.this.showSoftInput(v);
                } else {
                    PersonInfoModifySignFragment.this.hideSoftInput(v.getWindowToken());
                }
            }
        });
        return view2;
    }

    public void onResume() {
        super.onResume();
        this.mEditText.requestFocus();
    }

    public String getOldSignature() {
        AccountInfo info;
        if (this.oldSignature == null && (info = PersonInfoLoadHelper.getLocalAccountInfo(getActivity())) != null) {
            this.oldSignature = info.getSignature();
        }
        return this.oldSignature;
    }

    public String getModifySignature() {
        return this.mEditText.getText().toString();
    }

    public void onEventModifyPersonInfo(ModifyPersonInfoEvent event) {
        if (getActivity() != null && event.modifyType == ModifyType.SIGNATURE) {
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
            }
            if (event.error == null) {
                if (this.mImmShowing) {
                    hideSoftInput(this.mEditText.getWindowToken());
                }
                getActivity().onBackPressed();
            }
        }
    }

    @Override // tv.danmaku.bili.ui.personinfo.BaseModifyFragment
    public void onDestroyView() {
        if (this.mImmShowing) {
            hideSoftInput(this.mEditText.getWindowToken());
        }
        super.onDestroyView();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static class MyTextWatcher implements TextWatcher {
        WeakReference<PersonInfoModifySignFragment> mRef;

        public MyTextWatcher(PersonInfoModifySignFragment f) {
            this.mRef = new WeakReference<>(f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            PersonInfoModifySignFragment f = this.mRef.get();
            if (f != null) {
                f.mEditCount.setText(String.valueOf(70 - f.mEditText.length()));
            }
        }
    }
}