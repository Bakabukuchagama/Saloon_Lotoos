package ru.lotoos.saloon_lotoos.retrofit;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ImageService {

    @GET("user/images/{id}")
    Call<List<UUID>> findById_Employee(@Path("id") UUID id);

    @GET("v2/list")
    Call<String> STRING_CALL();
}
