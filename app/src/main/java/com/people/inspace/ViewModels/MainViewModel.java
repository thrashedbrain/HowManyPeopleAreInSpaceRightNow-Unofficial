package com.people.inspace.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.people.inspace.Models.ResponseModel;
import com.people.inspace.Repository.ClientRepository;

public class MainViewModel extends ViewModel {
    private MutableLiveData<ResponseModel> responseLiveData;
    private ClientRepository repository;

    public void call(){
        if (repository == null){
            repository = ClientRepository.getInstance();
        }
        responseLiveData = repository.getResponseLiveData();
    }

    public LiveData<ResponseModel> responseModelLiveData(){
        return responseLiveData;
    }
}
