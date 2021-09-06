package com.example.studentmanagersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ListView Student_ALL;
    //List<Student> studentList = new ArrayList<>();
    //对应控件
    EditText sid;
    EditText sname;
    EditText ssex;
    EditText snative;
    EditText sscore;
    Spinner spinner;
    //数据库
    SQLiteDatabase db;
    int choice = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //建立数据库
        final DatabaseHelper databaseHelper = new DatabaseHelper(this,"ciec.db",null,1);
        db = databaseHelper.getWritableDatabase();

        sid = (EditText) findViewById(R.id.editTextTextPersonName);
        sname = (EditText) findViewById(R.id.editTextTextPersonName2);
        ssex = (EditText) findViewById(R.id.editTextTextPersonName3);
        snative = (EditText) findViewById(R.id.editTextTextPersonName4);
        sscore = (EditText) findViewById(R.id.editTextTextPersonName5);

        Button btn1 = (Button) findViewById(R.id.button3);
        Button btn2 = (Button) findViewById(R.id.button4);

        ImageButton imgbtn1 = (ImageButton) findViewById(R.id.imageButton);
        ImageButton imgbtn2 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton imgbtn3 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imgbtn4 = (ImageButton) findViewById(R.id.imageButton3);

        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbtn1.setImageDrawable(getResources().getDrawable(R.drawable.xz1));
                imgbtn2.setImageDrawable(getResources().getDrawable(R.drawable.tx2));
                imgbtn3.setImageDrawable(getResources().getDrawable(R.drawable.tx3));
                imgbtn4.setImageDrawable(getResources().getDrawable(R.drawable.tx4));
                choice = 1;
            }
        });

        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbtn1.setImageDrawable(getResources().getDrawable(R.drawable.tx1));
                imgbtn2.setImageDrawable(getResources().getDrawable(R.drawable.xz2));
                imgbtn3.setImageDrawable(getResources().getDrawable(R.drawable.tx3));
                imgbtn4.setImageDrawable(getResources().getDrawable(R.drawable.tx4));
                choice = 2;
            }
        });

        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbtn1.setImageDrawable(getResources().getDrawable(R.drawable.tx1));
                imgbtn2.setImageDrawable(getResources().getDrawable(R.drawable.tx2));
                imgbtn3.setImageDrawable(getResources().getDrawable(R.drawable.xz3));
                imgbtn4.setImageDrawable(getResources().getDrawable(R.drawable.tx4));
                choice = 3;
            }
        });

        imgbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbtn1.setImageDrawable(getResources().getDrawable(R.drawable.tx1));
                imgbtn2.setImageDrawable(getResources().getDrawable(R.drawable.tx2));
                imgbtn3.setImageDrawable(getResources().getDrawable(R.drawable.tx3));
                imgbtn4.setImageDrawable(getResources().getDrawable(R.drawable.xz4));
                choice = 4;
            }
        });

        //监听文字改变
        sid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                query(0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                query(0);
            }
        });

        sname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                query(0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                query(0);
            }
        });

        snative.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                query(0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                query(0);
            }
        });

        ssex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                query(0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                query(0);
            }
        });

        sscore.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                query(0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                query(0);
            }
        });

        //添加
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String tid = sid.getText().toString().trim();
                final String tname = sname.getText().toString().trim();
                final String tsex = ssex.getText().toString().trim();
                final String tnative = snative.getText().toString().trim();
                final String tscore = sscore.getText().toString().trim();

                if(tid.isEmpty() | tname.isEmpty() | tsex.isEmpty() | tnative.isEmpty() | tscore.isEmpty()){
                    Toast.makeText(MainActivity.this,"请将信息全部填完",Toast.LENGTH_SHORT).show();
                }
                else if(!tsex.equals("男") && !tsex.equals("女")){
                    Toast.makeText(MainActivity.this,"请填写正确性别（男/女）"+tsex,Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    Cursor cursor = db.query("information", new String[]{"id"},"id = ?", new String[] {tid}, null, null, null);
                    if(cursor.getCount()>0){
                        Toast.makeText(MainActivity.this,"学生信息已经存在！！！",Toast.LENGTH_SHORT).show();
                    }else {
                        values.put("id",tid);
                        values.put("name",tname);
                        values.put("sex", tsex+Integer.toString(choice));
                        values.put("native",tnative);
                        values.put("score",tscore);
                        db.insert("information",null,values);
                        Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        query(0);
                    }
                }
            }
        });
        //查询
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //query(0);
                //清空
                sid.setText("");
                sname.setText("");
                ssex.setText("");
                snative.setText("");
                sscore.setText("");
            }
        });
        //下拉菜单
        String [] data = new String[]{"学号","姓名","籍贯","成绩"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,data);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("spinner",Integer.toString(position));
                //Toast.makeText(MainActivity.this,Integer.toString(position),Toast.LENGTH_SHORT).show();
                query(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    protected void query(int Control){
        final String tid = sid.getText().toString().trim();
        final String tname = sname.getText().toString().trim();
        final String tsex = ssex.getText().toString().trim();
        final String tnative = snative.getText().toString().trim();
        final String tscore = sscore.getText().toString().trim();
        List<Student> studentList = new ArrayList<>();

        String order = "id";
        switch (Control){
            case 0:
                order = "id";
                break;
            case 1:
                order = "name";
                break;
            case 2:
                order = "native";
                break;
            case 3:
                order = "score";
                break;
            default:
                order = "id";
        }
        //Toast.makeText(MainActivity.this,order,Toast.LENGTH_SHORT).show();
        //TextView test = findViewById(R.id.textView4);
        Cursor cursor = db.query("information", new String[]{"id","name","sex","native","score"}, "id like ? and name like ? and sex like ? and native like ? and score like ?", new String[]{"%"+tid+"%","%"+tname+"%","%"+tsex+"%","%"+tnative+"%","%"+tscore+"%"}, null, null, order);
        String textview_data = "";
        if(cursor.getCount()==0){
           // Toast.makeText(MainActivity.this,"未找到结果",Toast.LENGTH_SHORT).show();
        }else
        {
            //Toast.makeText(MainActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
        }
        //利用游标遍历所有数据对象
        //为了显示全部，把所有对象连接起来，放到TextView中
        while(cursor.moveToNext()){
            String line1 = "学号："+cursor.getString(cursor.getColumnIndex("id"));
            String line2 = "名字："+cursor.getString(cursor.getColumnIndex("name"));
            String line3 = "性别："+cursor.getString(cursor.getColumnIndex("sex"));
            String line4 = "籍贯："+cursor.getString(cursor.getColumnIndex("native"));
            String line5 = "成绩："+cursor.getString(cursor.getColumnIndex("score"));
            Student t=new Student(line1,line2,line3,line4,line5);
            studentList.add(t);
        }
        MyBaseAdapter mAdapter = new MyBaseAdapter(MainActivity.this,R.layout.item,studentList);
        //String text = studentList.get(0).getid();
        //test.setText(text);
        //ListView Student_ALL = (ListView)findViewById(R.id.Student_ALL);
        MyListView Student_ALL = (MyListView)findViewById(R.id.Student_ALL);
        Student_ALL.setAdapter(mAdapter);

        //左滑删除
        Student_ALL.setDelButtonClickListener(new DeleteClickListener() {
            @Override
            public void onClickDelete(int position) {
                db.delete("information", "id=?", new String[]{studentList.get(position).getid().substring(3)});
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                mAdapter.remove(mAdapter.getItem(position));
                //TextView t=findViewById(R.id.textView4);
                //t.setText("debug");
            }
        });

//                Student_ALL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(MainActivity.this, position + " : " + mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
//                    }
//                });

    }
    class MyBaseAdapter extends ArrayAdapter<Student> {
        private int resourceId;

        public MyBaseAdapter(Context context, int textViewResourceId, List<Student> objects) {
            super(context,textViewResourceId,objects);
            resourceId=textViewResourceId;
        }


        /*
                @Override
                public int getCount() {
                    return data.length;
                }


        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }

         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Student student= (Student) getItem(position);
            View view;
            ViewHolder holder;
            if(convertView == null){
                view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
                holder = new ViewHolder();
                holder.mid = (TextView) view.findViewById(R.id.tv1);
                holder.mname = (TextView) view.findViewById(R.id.tv2);
                holder.msex = (TextView) view.findViewById(R.id.tv3);
                holder.mnative = (TextView) view.findViewById(R.id.tv4);
                holder.mscore = (TextView) view.findViewById(R.id.tv5);
                holder.touxiang = (ImageView) view.findViewById(R.id.iv);
                
                view.setTag(holder);

            }else {
                view=convertView;
                holder = (ViewHolder) view.getTag();
            }
            //Toast.makeText(MainActivity.this,student.getid(),Toast.LENGTH_SHORT).show();
            holder.mid.setText(student.getid());
            holder.mname.setText(student.getname());
            holder.msex.setText(student.getsex().substring(0,4));
            holder.mnative.setText(student.getnative());
            holder.mscore.setText(student.getscore());

            String tx = "tx"+student.getsex().substring(4);
            int icon = getResources().getIdentifier(tx, "drawable", getPackageName());

            holder.touxiang.setImageResource(icon);

            return view;
        }


        class ViewHolder {
            TextView mid;
            TextView mname;
            TextView msex;
            TextView mnative;
            TextView mscore;
            ImageView touxiang;
        }
    }
}