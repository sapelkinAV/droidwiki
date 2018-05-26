import com.raywenderlich.android.droidwiki.dagger.AppComponent
import com.raywenderlich.android.droidwiki.dagger.AppModule
import com.raywenderlich.android.droidwiki.dagger.DaggerAppComponent
import com.raywenderlich.android.droidwiki.model.SearchResult
import com.raywenderlich.android.droidwiki.network.Wiki
import com.raywenderlich.android.droidwiki.network.WikiApi
import com.raywenderlich.android.droidwiki.utils.Const
import okhttp3.*
import org.junit.Test
import java.io.IOException


class WikiSearchTest {

    @Test
    fun searchTest() {

        val wiki = Wiki(WikiApi(OkHttpClient(), HttpUrl.parse("${Const.PROTOCOL}://${Const.LANGUAGE}.${Const.BASE_URL}")?.newBuilder()))

        wiki.search("wiki").enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
            }

            override fun onResponse(call: Call?, response: Response?) {
                //Everything is ok, show the result if not null
                if (response?.isSuccessful == true) {
                    SearchResult(response).list?.let {
                        assert(it.toString().contains("wikipedia"))
                    }
                } else {
                    print(response?.message())
                }
            }


        })
    }
}