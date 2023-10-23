package com.emreunaldi.carregistrationsystemapi.business.abstracts;


import com.emreunaldi.carregistrationsystemapi.business.request.*;
import com.emreunaldi.carregistrationsystemapi.business.response.GetUserResponse;
import com.emreunaldi.carregistrationsystemapi.entities.User;
import com.emreunaldi.carregistrationsystemapi.utilities.results.DataResult;
import com.emreunaldi.carregistrationsystemapi.utilities.results.Result;

public interface UserService {
    DataResult<AddUserRequest> add(AddUserRequest addUserRequest);

    Result delete(int id);

    DataResult<User> update(UpdateUserRequest updateUserRequest);

    Result register(RegisterRequest registerRequest);

    DataResult<GetUserResponse> login(LoginRequest loginRequest);

    Result changePassword(ChangePasswordRequest changePasswordRequest);
}
