package com.example.hin.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hin.Consts.LocalStringConst;
import com.example.hin.entity.Experts;
import com.example.hin.entity.Post;
import com.example.hin.system.R;

public class ExpertsActivity extends Activity implements View.OnClickListener {

    private ImageView iv_back;
    private RelativeLayout rl_achievement;
    private TextView tv_consult, tv_achievement, tv_name, tv_sex, tv_degree, tv_title, tv_organization, tv_study, tv_consultCount;
    private RatingBar rb_rank;
    private Button Regist;
    private Experts experts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experts_introduce);
        //用于退出程序
        CloseActivity.activityList.add(this);

        parseIntent();

        findView();
        initView();
        iniListener();
    }

    /*
    * 解析传过来的Inetent数据*/
    public void parseIntent() {
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        experts = (Experts) bundle.getSerializable("expertsObject");
    }

    //获取控件ID
    public void findView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        rl_achievement = (RelativeLayout) findViewById(R.id.rl_achievement);
        tv_achievement = (TextView) findViewById(R.id.tv_achievement);
        tv_consult = (TextView) findViewById(R.id.tv_consult);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_degree = (TextView) findViewById(R.id.tv_degree);
        tv_degree = (TextView) findViewById(R.id.tv_degree);
        tv_organization = (TextView) findViewById(R.id.tv_organization);
        tv_study = (TextView) findViewById(R.id.tv_study);
        tv_consultCount = (TextView) findViewById(R.id.tv_consultCount);
        tv_title = (TextView) findViewById(R.id.tv_title);
        rb_rank = (RatingBar) findViewById(R.id.rb_rank);

    }

    /*初始化数据*/
    public void initView() {
        tv_name.setText(experts.getName());
        tv_sex.setText(experts.getSex());
        tv_degree.setText(experts.getDegree());
        tv_title.setText(experts.getTitle());
        tv_organization.setText(experts.getOrganization());
        tv_study.setText(experts.getStudy());
        tv_achievement.setText(experts.getAchievement());
        tv_consultCount.setText(experts.getConsultCount().toString());
        rb_rank.setRating(experts.getRank());
    }


    //监听事件
    public void iniListener() {

        iv_back.setOnClickListener(this);
        tv_consult.setOnClickListener(this);
        rl_achievement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_achievement:
                new AlertDialog.Builder(this).setTitle("研究成果").setItems(
                        new String[]{experts.getAchievement(), "Item2", "Item1", "Item2"}, null).setNegativeButton(
                        "确定", null).show();
                break;
            case R.id.tv_consult:
                setResult(RESULT_OK, new Intent().putExtra(LocalStringConst.INTENT_EXPERT_ID, 1));
                finish();
            default:
                break;
        }

    }
}
