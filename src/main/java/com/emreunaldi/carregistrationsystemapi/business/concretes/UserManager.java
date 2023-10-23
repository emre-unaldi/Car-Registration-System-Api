package com.emreunaldi.carregistrationsystemapi.business.concretes;

import com.emreunaldi.carregistrationsystemapi.business.abstracts.UserService;
import com.emreunaldi.carregistrationsystemapi.business.request.*;
import com.emreunaldi.carregistrationsystemapi.business.response.GetUserResponse;
import com.emreunaldi.carregistrationsystemapi.dataAccess.UserRepository;
import com.emreunaldi.carregistrationsystemapi.entities.User;
import com.emreunaldi.carregistrationsystemapi.utilities.mappers.ModelMapperService;
import com.emreunaldi.carregistrationsystemapi.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManager implements UserService {

    UserRepository _userRepository;
    ModelMapperService _modelMapperService;

    @Autowired
    public UserManager(UserRepository _userRepository, ModelMapperService _modelMapperService) {
        this._userRepository = _userRepository;
        this._modelMapperService = _modelMapperService;
    }

    @Override
    public DataResult<AddUserRequest> add(AddUserRequest addUserRequest) {
        try {
            User user = this._modelMapperService.forRequest().map(addUserRequest, User.class);
            this._userRepository.save(user);
            addUserRequest = this._modelMapperService.forResponse().map(user, AddUserRequest.class);
            return new SuccessDataResult<>(addUserRequest, "Success");
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public Result delete(int id) {
        try {
                this._userRepository.deleteById(id);
                return new SuccessResult("Success");
        } catch (Exception error) {
            return new ErrorResult(error.getMessage());
        }
    }

    @Override
    public DataResult<User> update(UpdateUserRequest updateUserRequest) {
        try {
            User user = this._modelMapperService.forRequest().map(updateUserRequest, User.class);
            this._userRepository.save(user);
            return new SuccessDataResult<>(user, "Success");
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public Result register(RegisterRequest registerRequest) {
        try {
            User user = this._modelMapperService.forRequest().map(registerRequest, User.class);
            this._userRepository.save(user);
            return new SuccessDataResult<>(null, "Success");
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<GetUserResponse> login(LoginRequest loginRequest) {
        try {
            User user = this._userRepository.getByUsername(loginRequest.getUsername());
            if (user.getPassword().equals(loginRequest.getPassword())) {
                GetUserResponse getUserResponse=this._modelMapperService.forResponse().map(user,GetUserResponse.class);
                return new SuccessDataResult<>(getUserResponse, "Success");
            } else {
                return new ErrorDataResult<>("Lütfen bilgileri kontrol ediniz!");
            }
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public Result changePassword(ChangePasswordRequest changePasswordRequest) {
        try {
            User user = this._userRepository.getByUsername(changePasswordRequest.getUsername());
            if (changePasswordRequest.getOldPassword().equals(user.getPassword())) {
                user.setPassword(changePasswordRequest.getNewPassword());
                this._userRepository.save(user);
                return new SuccessResult("Success");
            } else {
                return new ErrorResult("Yanlış Bilgiler!");
            }
        } catch (Exception error) {
            return new ErrorResult(error.getMessage());
        }
    }
}
