
package com.appers.myretrofitapicall.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.appers.myretrofitapicall.R;
import com.appers.myretrofitapicall.databinding.ActivityMainBinding;
import com.appers.myretrofitapicall.model.RandomResponse;
import com.appers.myretrofitapicall.model.Users;
import com.appers.myretrofitapicall.presenter.Contract;
import com.appers.myretrofitapicall.presenter.RandomPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View{
private Contract.Presenter randomPresenter;
private ActivityMainBinding binding;
private RandomAdapter adapter=new RandomAdapter(new ArrayList<>());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
binding.mainRecyclerview.setAdapter(adapter);
        randomPresenter=new RandomPresenter(this);
        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=binding.searchEdittext.getText().toString();
                if (value.isEmpty()) {
                     Toast.makeText(MainActivity.this,"Search bar cannot be empty" , Toast.LENGTH_SHORT).show();
                }else {
                    int value1 = Integer.parseInt(value);

                    randomPresenter.getUsers(value1);
                }
            }
        });
    }


    @Override
    public void displayUsers(List<Users> usersList) {
adapter.setUsers(usersList);
    }

    @Override
    public void setStatus(com.appers.myretrofitapicall.presenter.RandomPresenter.Status status) {
switch(status){
    case ERROR:
        showtoast();
        break;
    case LOADING:
        binding.progressbar.setVisibility(View.VISIBLE);
        break;
    case COMPLETE:
        binding.progressbar.setVisibility(View.GONE);
}
    }

    private void showtoast() {
        Toast.makeText(this,"An error occured",Toast.LENGTH_SHORT).show();
    }
}