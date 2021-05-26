package com.appers.myretrofitapicall.presenter;

import com.appers.myretrofitapicall.model.RandomResponse;
import com.appers.myretrofitapicall.model.Users;

import java.util.List;

public interface Contract {
    public interface Presenter{
        public void getUsers(int total);
    }
    public interface View{
        public void displayUsers(List<Users> usersList);
        public void setStatus(RandomPresenter.Status status);
    }
}
