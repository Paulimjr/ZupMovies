package movies.zup.com.br.zupmovies.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit client para comunicar com as API's
 *
 * Created by paulo on 16/01/2018.
 */

public class RetrofitClient {

    /**
     * URL base da chamada dos Serviços REST
     */
    private static final String BASE_URL = "URL_SERVER_HERE";

    private Retrofit retrofit;

    /**
     * Criando o objeto retrofit e retornando
     *
     * @since 16/01/2018
     * @return {@link Retrofit}
     */
    public Retrofit createRetrofit() {
        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }
        return retrofit;
    }
}
