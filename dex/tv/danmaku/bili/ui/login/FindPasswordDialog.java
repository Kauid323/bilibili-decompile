package tv.danmaku.bili.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bilibili.app.accountui.R;
import tv.danmaku.bili.ui.login.LoginReporterV2;

public class FindPasswordDialog extends AppCompatDialog implements View.OnClickListener {
    public static final int ITEM_ID_BY_EMAIL = 2;
    public static final int ITEM_ID_BY_PHONE_NUM = 1;
    private OnItemClickListener mOnItemClickListener;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface OnItemClickListener {
        void onSelected(int i);
    }

    public FindPasswordDialog(Context context, OnItemClickListener onItemClickListener) {
        super(context, R.style.ChoiceDialog);
        this.mOnItemClickListener = onItemClickListener;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_dialog_forget_password);
        initViews();
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_PWD_LOGIN_FORGOT_0_SHOW);
    }

    private void initViews() {
        findViewById(R.id.layout_choice_phone_num).setOnClickListener(this);
        findViewById(R.id.layout_choice_email).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }

    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.ChoiceDialog_Animation);
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.layout_choice_phone_num) {
            this.mOnItemClickListener.onSelected(1);
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_FORGOT_PHONE_CLICK);
        } else if (i == R.id.layout_choice_email) {
            this.mOnItemClickListener.onSelected(2);
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_FORGOT_MAIL_CLICK);
        }
        cancel();
    }
}