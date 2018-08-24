package com.myapp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airsaid.pickerviewlibrary.AwardPickerView;
import com.airsaid.pickerviewlibrary.QiXianPickerView;
import com.airsaid.pickerviewlibrary.listener.OnItemSelectedListener;
import com.airsaid.pickerviewlibrary.listener.OnOptionsSelectListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_show_date_dialog;
    Button btn_show_single_wheel;
    Button btn_show_double_wheel;
    Button btn_show_three_wheel;
    private QiXianPickerView<String> qiXianPickerView;
    private AwardPickerView<String> yearIncomePickerView, yearRatePickerView, awardPickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn_show_date_dialog = (Button) findViewById(R.id.btn_show_date_dialog);
         btn_show_single_wheel=(Button) findViewById(R.id.btn_show_single_wheel);
         btn_show_double_wheel= (Button) findViewById(R.id.btn_show_double_wheel);
        btn_show_three_wheel= (Button) findViewById(R.id.btn_show_three_wheel);
         btn_show_date_dialog.setOnClickListener(this);
         btn_show_single_wheel.setOnClickListener(this);
         btn_show_double_wheel.setOnClickListener(this);
         btn_show_three_wheel.setOnClickListener(this);
        //筛选对话框
         yearIncomePickerView = new AwardPickerView<>(this, 1);//年化收益率对话框
         qiXianPickerView = new QiXianPickerView<>(this);//期限筛选对话框
         yearRatePickerView = new AwardPickerView<>(this, 2);//年利率对话框
         awardPickerView = new AwardPickerView<>(this, 3);//奖励对话框


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show_date_dialog:
                MyDatePickerDialog datePickerDialog = new MyDatePickerDialog(MainActivity.this);

                datePickerDialog.setOnSureListener(new MyDatePickerDialog.OnSureListener() {
                    @Override
                    public void back(String name) {
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                    }
                });
                datePickerDialog.show();
                //必须在  datePickerDialog.show()之后调用
                datePickerDialog.setYearValue(2018);
                datePickerDialog.setMonthValue(6);
                break;
            case R.id.btn_show_single_wheel:
                yearIncomePickerView.setPicker(DataUtils.getYearIncome());
                yearIncomePickerView.setCyclic(true);//设置是否可以循环滚动
                yearIncomePickerView.setSelectOptions(5);//设置选中
                yearIncomePickerView.setOnOptionsSelectListener(new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int option1, int option2, int option3) {
                        String selectItem1=DataUtils.getYearIncome().get(option1);
                        Toast.makeText(MainActivity.this, "select:"+selectItem1, Toast.LENGTH_SHORT).show();
                    }
                });
                yearIncomePickerView.setOnScrollChangeListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(int index) {
                        String selectItem1=DataUtils.getYearIncome().get(index);
                        Toast.makeText(MainActivity.this, "select:"+selectItem1, Toast.LENGTH_SHORT).show();
                    }
                },null,null);
                yearIncomePickerView.show();
                break;
            case R.id.btn_show_double_wheel://二级数据
                qiXianPickerView.setPicker(DataUtils.getMonthList(),DataUtils.getDayList(),true);
                qiXianPickerView.setOnOptionsSelectListener(new QiXianPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int option1, int option2, int option3) {
                        String selectItem1=DataUtils.getMonthList().get(option1);
                        String selectItem2=DataUtils.getDayList().get(0).get(option2);
                        Toast.makeText(MainActivity.this, "select:"+selectItem1+"--"+selectItem2+"--"+option3, Toast.LENGTH_SHORT).show();
                    }
                });
                qiXianPickerView.show();
                break;
            case R.id.btn_show_three_wheel:
                break;
        }

    }
}
