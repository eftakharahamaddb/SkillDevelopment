package com.skill.develoment.skilldevelopment.login_mvp_dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.skill.develoment.skilldevelopment.R;
import com.skill.develoment.skilldevelopment.businesslogic.NetworkApi;
import com.skill.develoment.skilldevelopment.businesslogic.SampleApp;
import com.skill.develoment.skilldevelopment.pojos.Owner;
import com.skill.develoment.skilldevelopment.pojos.Repo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {


    @Inject
    LoginActivityMVP.Presenter presenter;

    @Inject
    NetworkApi networkApi;

    //Activity Components
    TextView tv_user_id;
    TextView tv_password;
    EditText et_user_id;
    EditText et_password;
    Button btn_save_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SampleApp sampleApp = (SampleApp) getApplication();
        sampleApp.getControllerComponent().inject(this);
        tv_user_id = findViewById(R.id.tv_user_id);
        tv_password = findViewById(R.id.tv_password);
        et_user_id = findViewById(R.id.et_user_id);
        et_password = findViewById(R.id.et_password);
        btn_save_data = findViewById(R.id.btn_save_data);
        btn_save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });

        Call<List<Repo>> efty1991 = networkApi.getRepoList("efty1991");
        efty1991.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repos = response.body();
                for (Repo repo : repos)
                    System.out.println("REPO_LOG::" + repo);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        networkApi.getRepoListObservable("efty1991")
                .flatMapIterable(repos -> repos)
                .flatMap(repos -> Observable.fromArray(repos))
                .flatMap(repo->Observable.just(repo.getOwner().getId()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("SUBSCRIBED:","Disposable:"+d.toString());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("SUBSCRIBED:","V:"+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("SUBSCRIBED:","COKMPLETE");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("SUBSCRIBED:","COKMPLETE");
                    }
                });


    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getUserId() {
        if (et_user_id != null && et_user_id.getText() != null && !et_user_id.getText().equals(""))
            return et_user_id.getText().toString();
        return null;
    }

    @Override
    public String getPassword() {
        if (et_password != null && et_password.getText() != null && !et_password.getText().equals(""))
            return et_password.getText().toString();
        return null;
    }

    @Override
    public void setUserId(String userId) {
        if (et_user_id != null)
            et_user_id.setText(userId);
    }

    @Override
    public void setPassword(String password) {
        if (et_password != null)
            et_password.setText(password);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
