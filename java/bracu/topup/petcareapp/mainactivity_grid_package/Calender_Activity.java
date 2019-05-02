package bracu.topup.petcareapp.mainactivity_grid_package;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

import bracu.topup.petcareapp.MainActivity;
import bracu.topup.petcareapp.R;

public class Calender_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        MaterialCalendarView materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);


        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2015, 12, 1))
                .setMaximumDate(CalendarDay.from(2025, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
              //  Toast.makeText(Calender_Activity.this,""+date,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
