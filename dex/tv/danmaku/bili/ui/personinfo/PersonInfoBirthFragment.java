package tv.danmaku.bili.ui.personinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bilibili.app.personinfo.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import tv.danmaku.bili.ui.personinfo.event.PersonInfoModifyViewModel;

public class PersonInfoBirthFragment extends DialogFragment {
    public static final String TAG = "PersonInfoBirthFragment";
    DatePicker mDatePicker;
    private int mDay;
    private PersonInfoLoadFragment mLoaderFragment;
    private int mMonth;
    private PersonInfoModifyViewModel mPersonInfoModifyViewModel;
    private int mYear;
    Calendar mTime = Calendar.getInstance();
    SimpleDateFormat mSdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public void show(FragmentManager manager, String tag) {
        try {
            Field mStateSaved = manager.getClass().getDeclaredField("mStateSaved");
            mStateSaved.setAccessible(true);
            if (!mStateSaved.getBoolean(manager)) {
                super.show(manager, tag);
            }
        } catch (Exception e) {
            super.show(manager, tag);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.mPersonInfoModifyViewModel = (PersonInfoModifyViewModel) new ViewModelProvider(activity).get(PersonInfoModifyViewModel.class);
        }
        setStyle(1, R.style.PersonInfo_AppTheme_AppCompat_Dialog);
        this.mLoaderFragment = PersonInfoLoadFragment.getInstance(getFragmentManager());
        if (this.mLoaderFragment == null) {
            this.mLoaderFragment = new PersonInfoLoadFragment();
            PersonInfoLoadFragment.attachTo(getFragmentManager(), this.mLoaderFragment);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bili_app_fragment_perinfo_birthday, container, false);
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        super.onViewCreated(view2, savedInstanceState);
        this.mDatePicker = (DatePicker) view2.findViewById(R.id.datePicker);
        this.mDatePicker.init(this.mYear, this.mMonth, this.mDay, null);
        view2.findViewById(R.id.birthday_ok).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoBirthFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PersonInfoBirthFragment.this.onConfirm();
            }
        });
    }

    public void onConfirm() {
        this.mTime.set(this.mDatePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth());
        if (this.mTime.after(Calendar.getInstance())) {
            ToastHelper.showToast(getContext(), bili.resource.profile.R.string.profile_global_string_30, 0);
            return;
        }
        String chooseDate = this.mSdf.format(this.mTime.getTime());
        AccountInfo accountInfo = PersonInfoLoadHelper.getLocalAccountInfo(getActivity());
        if (accountInfo != null && !chooseDate.equals(accountInfo.getBirthday())) {
            this.mLoaderFragment.modifyBirthday(chooseDate);
            if (this.mPersonInfoModifyViewModel != null) {
                this.mPersonInfoModifyViewModel.getUploadingEvent().setValue((Object) null);
            }
        }
        dismissAllowingStateLoss();
    }

    public void setDate(String date) {
        Date birthDate = null;
        if (date != null) {
            try {
                birthDate = this.mSdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (birthDate != null) {
                this.mTime.setTime(birthDate);
            }
        }
        this.mYear = this.mTime.get(1);
        this.mMonth = this.mTime.get(2);
        this.mDay = this.mTime.get(5);
    }
}