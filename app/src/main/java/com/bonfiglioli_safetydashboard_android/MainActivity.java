package com.bonfiglioli_safetydashboard_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends Activity {


    public EditText text1;
    public EditText text2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onInputDialogClick(View view) {
        EditText editText = findViewById(R.id.blank1);
        EditText editText1 = findViewById(R.id.blank2);
        //写在了工具类里面，后续别处用的时候直接调用即可
        normalDialog(this, editText,editText1);


    }

    public void normalDialog(final Context context, final EditText editText,final EditText editText1) {
        //得到自定义对话框
        final View DialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit, null);
        //初始化edit值，把当前值显示到对话框里。
        final EditText init = (EditText) DialogView.findViewById(R.id.et);
        final EditText init1 = (EditText) DialogView.findViewById(R.id.et1);
        init.setText(editText.getText());
        init1.setText(editText1.getText());
        //控制光标显示位置
        init.setSelection(init.getText().length());
        init1.setSelection(init1.getText().length());
        new AlertDialog.Builder(context).setTitle("编辑信息")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setView(DialogView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //按下确定键后的事件
                        //输入后点击“确定”，开始获取我们要的内容 DialogView就是AlertDialog弹出的Activity
                        editText.setText(init.getText().toString());
                        editText1.setText(init1.getText().toString());
                        //控制光标显示位置
                        editText.setSelection(editText.getText().length());
                        editText1.setSelection(editText1.getText().length());
                    }
                }).setNegativeButton("取消", null).show();


        handler.post(task);


    }

    public long getTimeDistance(Date begindate ,Date enddata){
        Calendar fromCalender= Calendar.getInstance();
        fromCalender.setTime(begindate);
        Calendar currentcalender = Calendar.getInstance();
        currentcalender.setTime(enddata);
        return (currentcalender.getTimeInMillis()-fromCalender.getTimeInMillis());
    }

    private Handler handler = new Handler();

    private Runnable task =new Runnable() {
        public void run() {
            // TODOAuto-generated method stub
            handler.postDelayed(this,1000);//设置延迟时间，此处是5秒
            //需要执行的代码
        }
    };
}