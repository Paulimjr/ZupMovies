package movies.zup.com.br.zupmovies.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Utils para aplicação
 *
 * Created by paulo on 16/01/18.
 */

public class Utils {

    /**
     * Retorna se está conectado ou nao
     *
     * @param c o contexto
     * @return true ou false
     */
    static public boolean isNetworkAvailable(Context c) {
        ConnectivityManager cm =
                (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

}
