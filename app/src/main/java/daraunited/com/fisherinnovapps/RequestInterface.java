package daraunited.com.fisherinnovapps;

import daraunited.com.fisherinnovapps.models.ServerRequest;
import daraunited.com.fisherinnovapps.models.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("mobileconnecteapi/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
